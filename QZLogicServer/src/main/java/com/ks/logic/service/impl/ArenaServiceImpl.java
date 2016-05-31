package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.ArenaAward;
import com.ks.db.cfg.ArenaBuy;
import com.ks.db.cfg.MartialWayAwardExp;
import com.ks.db.model.Arena;
import com.ks.db.model.ArenaLogger;
import com.ks.db.model.ArenaShopping;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserTeam;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.task.ArenaFightEvent;
import com.ks.logic.service.ArenaService;
import com.ks.logic.service.BaseService;
import com.ks.model.fight.Battle;
import com.ks.model.user.UserBaseinfo;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.arena.ArenaInfoVO;
import com.ks.protocol.vo.arena.ArenaLoggerVO;
import com.ks.protocol.vo.arena.ArenaShoppingVO;
import com.ks.protocol.vo.arena.ArenaVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;
import com.ks.table.ArenaTable;
import com.ks.table.UserStatTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;
import com.ks.util.XyTimeUtil;

public class ArenaServiceImpl extends BaseService implements ArenaService {
	
	/*******************************************arena_logger data*****************************************************/
	private void trimArenaLogger(int userId,int type){
		arenaDAO.deleteArenaLogger(userId, type);
	}
	public void addArenaLogger(ArenaLogger al){
		trimArenaLogger(al.getUserId(), al.getType());
		arenaDAO.addArenaLogger(al);
		arenaDAO.addArenaLoggerCache(al);
	}
	/**
	 * 加载好友
	 * @param user
	 */
	/**
	 * @param userId
	 * @return
	 */
	public List<ArenaLogger> loadArenaLoggerToCache(int userId, int type){
		List<ArenaLogger> list =  loadDBArenaLogger(userId, type);
		arenaDAO.setArenaLoggersCache(userId, type, list);
		return list;
	}
	/**
	 * 加载好友
	 * @param user
	 */
	private List<ArenaLogger> loadDBArenaLogger(int userId, int type){
		List<ArenaLogger> list = arenaDAO.queryArenaLogger(userId, type);
		return list;
	}
	public List<ArenaLogger> getArenaLoggers(int userId, int type){
		List<ArenaLogger> list = arenaDAO.queryArenaLoggersCache(userId, type);
		if(list == null){
			list = loadArenaLoggerToCache(userId, type);
		}
		return list;
	}
	
	/********************************************logic****************************************************/
	@Override
	public ArenaInfoVO queryArena(int userId) {
		User user = userService.getOnlineUser(userId);
		if(user.getLevel() < SystemConstant.ARENA_OPEN_LEVEL){
			throw new GameException(GameException.CODE_等级不足, "");
		}
		Arena arena = arenaDAO.queryMyArena(userId);
		if(arena == null){
			arena = new Arena();
			arena.setUserId(userId);
			arena.setCdTime(XyTimeUtil.parse("1979-01-01 00:00:00", XyTimeUtil.yyyy_MM_dd_HH_mm_ss1));
			arena.setShoppingList(getShoppings());
			arenaDAO.addArena(arena);
		}
		ArenaInfoVO infoVO = MessageFactory.getMessage(ArenaInfoVO.class);
		if(arena.getIsFirst() == 1){
			List<UserBaseinfoVO> ubVOs = refRival(userId, false);
			infoVO.setRivals(ubVOs);
		}else{
			List<UserBaseinfoVO> ubVOs= new ArrayList<UserBaseinfoVO>();
			for (int i = -3; i < 0; i++) {
				UserBaseinfoVO vbVO= MessageFactory.getMessage(UserBaseinfoVO.class);
				vbVO.setUserId(i);
				vbVO.setLevel(15);
				vbVO.setPlayerName(":");
				ubVOs.add(vbVO);
			}
			infoVO.setRivals(ubVOs);
		}
		ArenaVO avo = MessageFactory.getMessage(ArenaVO.class);
		UserBaseinfoVO ubi = MessageFactory.getMessage(UserBaseinfoVO.class);
		UserBaseinfo baseInfo = userService.getUserBaseInfo(userId);
		ubi.init(baseInfo);
		avo.init(arena);
		avo.setInfo(ubi);
		infoVO.setMyArena(avo);
		return infoVO;
	}

	@Override
	public FightVO playArena(int userId, int rivalUserId) {
		User user = userService.getOnlineUser(userId);
		if(userId == rivalUserId){
			throw new GameException(GameException.CODE_该功能不支持对自己操作, "");
		}
		UserStat stat = userService.getUserStat(userId);
		if(stat.getArenaCount() < 1){
			throw new GameException(GameException.CODE_挑战次数不足, "");
		}else{
			Arena attArena = arenaDAO.queryMyArena(userId);
			if(XyTimeUtil.before(XyTimeUtil.getNowDate(), attArena.getCdTime())){
				throw new GameException(GameException.CODE_处于冷却CD中, "");
			}
		}
		UserTeam attTeam = userTeamService.queryUserTeam(userId);
		UserTeam defTeam = null;
		if(rivalUserId<0){
			defTeam =GameCache.getUserTeam(rivalUserId);
		}else{
			defTeam = userTeamService.queryUserTeam(rivalUserId);
		}
		if(defTeam==null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		Battle battle = fightService.startArneaPK(attTeam, defTeam);
		fightDAO.updateBattle(battle);
		
		Map<String,String> hash = new HashMap<>();
		hash.put(UserTable.J_FIGHTID, battle.getBattleId());
//		userDAO.updateUserCache(userId, hash);
		userService.updateUser(user, hash, false);
		
		FightVO vo = MessageFactory.getMessage(FightVO.class);
		vo.init(battle);
		
		//增加一次竞技场累计次数
		userService.increArenaFightCount(userId, 1);
		
		//抛出竞技场事件
		ArenaFightEvent event = ArenaFightEvent.valueOf(user);
		TimerController.submitGameEvent(event);
		return vo;
	}

	@Override
	public void clearCdTime(int userId) {
		User user = userService.getOnlineUser(userId);
		Arena arena = arenaDAO.queryMyArena(userId);
		Date now = new Date();
		if(arena.getCdTime().before(now)){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_清除竞技场CD时间);
			effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.ARENA_CLEAR_CD_DIAMOND, 0);
			int code = effectService.validDels(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			effectService.delIncome(user, effects);
			arena.setCdTime(new Date());
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(ArenaTable.CDTIME, SQLOpt.EQUAL);
			arenaDAO.updateArena(arena, opt);
		}
	}

	
	@Override
	public void buyArenaCount(int userId) {
		User user = userService.getOnlineUser(userId);
		UserStat stat = userService.getUserStat(userId);
		if(stat.getArenaBuyCount() >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BUY_ATHLETICS_NUMBER)){
			throw new GameException(GameException.CODE_可购买次数不足, "");
		}else{
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_增加竞技场次数);
			int dimaond = GameCache.getArenaBuy(stat.getArenaBuyCount() + 1).getBuyBattlePrice();
			effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, dimaond, 0);
			int code = effectService.validDels(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			effectService.delIncome(user, effects);
			int value = stat.getArenaCount() + SystemConstant.ARENA_BUY_NUMBER_ADD;
			stat.setArenaCount(value > SystemConstant.ARENA_MAX_NUMBER ? SystemConstant.ARENA_MAX_NUMBER : value);
			stat.setArenaBuyCount(stat.getArenaBuyCount() + 1);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserStatTable.ARENACOUNT, SQLOpt.EQUAL);
			opt.putFieldOpt(UserStatTable.ARENABUYCOUNT, SQLOpt.EQUAL);
			userService.updateUserStat(stat, opt);
		}
	}

	@Override
	public List<ArenaVO> queryArenaRank() {
		List<Arena> arenas = arenaDAO.queryArenaRankTop50();
		List<ArenaVO> vos = new ArrayList<ArenaVO>();
		List<Integer> userIds = new ArrayList<Integer>();
		for(Arena a : arenas){
			ArenaVO vo = MessageFactory.getMessage(ArenaVO.class);
			vo.init(a);
			vos.add(vo);
			userIds.add(a.getUserId());
		}
		List<UserBaseinfo> infos = userService.getUserBaseInfo(userIds); 
		for(UserBaseinfo info : infos){
			for(ArenaVO vo : vos){
				if(vo.getUserId() == info.getUserId()){
					UserBaseinfoVO ub = MessageFactory.getMessage(UserBaseinfoVO.class);
					ub.init(info);
					vo.setInfo(ub);
					break;
				}
			}
		}
		
		return vos;
	}

	@Override
	public List<UserBaseinfoVO> refRival(int userId, boolean flush) {
	     List<UserBaseinfoVO> voList=new ArrayList<UserBaseinfoVO>();
	     User user = userService.getOnlineUser(userId);
	     List<Integer> userIds=arenaDAO.getMatchUserIds(user);
	     if(!userIds.isEmpty()){
	    	 for (Integer uid:userIds) {
	    		 if(user.getUserId()==uid){
	    			 userIds.remove(uid);
	    			 break;
	    		 }
	    	 }
	     }
	     List<UserBaseinfo> ubList = userService.getUserBaseInfo(userIds);
		if(!ubList.isEmpty()){
			for (UserBaseinfo ub:ubList) {
				UserBaseinfoVO vo = MessageFactory.getMessage(UserBaseinfoVO.class);
				vo.init(ub);
				vo.setFighting(userService.getUserFighting(ub.getUserId()));
				voList.add(vo);
			}
		}
		if(flush){
			int size = 3 - voList.size();
			for(int i = 1; i <= size; i++){
				UserBaseinfoVO vbVO= MessageFactory.getMessage(UserBaseinfoVO.class);
				vbVO.setUserId(-i);
				vbVO.setLevel(15);
				vbVO.setPlayerName(":");
				voList.add(vbVO);
			}
		}
		return voList;
	}

	/**
	 * 商店生成
	 * @return
	 */
  private List<ArenaShopping> getShoppings(){
	  List<ArenaShopping> asList=new ArrayList<ArenaShopping>();
	  for (int i = 1; i < 7; i++) {
		  int random=(int)(Math.random()*100);
		  List<ArenaAward> aaList=GameCache.getShoppingAward(i);
		  if(!aaList.isEmpty()){
			  int totalRate=0;
			  for (ArenaAward aa:aaList) {
				  totalRate+=aa.getRate();
				  if(totalRate>=random){
					  ArenaShopping as=new ArenaShopping();
					  as.setGoodsId(aa.getGoodsId());
					  as.setShoppingId(aa.getShoppingId());
					  as.setLevel(aa.getLevel());
					  as.setNum(aa.getNum());
					  as.setType(aa.getType());
					  as.setMoney(aa.getMoney());
					  asList.add(as);
					  break;
				  }
				
			 }
		  }	
	}
	return asList;
  }
	@Override
	public List<ArenaShoppingVO> RefreshShopping(int userId) {
		User user = userService.getOnlineUser(userId);
		Arena arena = arenaDAO.queryMyArena(userId);
		UserStat stat = userService.getUserStat(userId);
		if(arena == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(stat.getArenaRefreshCount() >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_ATHLETICS_REFRESH_NUMBER)){
			throw new GameException(GameException.CODE_可刷新次数不足, "not refresh count");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_刷新商场);
		int dimaond = GameCache.getArenaBuy(stat.getArenaRefreshCount() + 1).getBuyRefreshPrice();
		effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, dimaond, 0);
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		stat.setArenaRefreshCount(stat.getArenaRefreshCount() + 1);
		SQLOpt statOpt = new SQLOpt();
		statOpt.putFieldOpt(UserStatTable.ARENAREFRESHCOUNT, SQLOpt.EQUAL);
		userService.updateUserStat(stat, statOpt);
		arena.setShoppingList(getShoppings());
		SQLOpt arenaOpt = new SQLOpt();
		arenaOpt.putFieldOpt(ArenaTable.SHOPPING, SQLOpt.EQUAL);
		arenaDAO.updateArena(arena, arenaOpt);
		List<ArenaShoppingVO> voList=new ArrayList<ArenaShoppingVO>();
		for (ArenaShopping as:arena.getShoppingList()) {
			ArenaShoppingVO vo=MessageFactory.getMessage(ArenaShoppingVO.class);
			vo.init(as);
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public GainAwardVO ExchangeAward(int userId,int shoppingId) {
		User user = userService.getOnlineUser(userId);
		Arena arena=arenaDAO.queryMyArena(userId);
		if(arena==null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(arena.getShopping().isEmpty()){
			throw new GameException(GameException.CODE_参数错误, "");	
		}
		ArenaShopping as=arena.getShoppingList().get(shoppingId-1);
		if(as.getNum()<=0){
			throw new GameException(GameException.CODE_该商品已经兑换完毕, "");	
		}
		if(arena.getValour()<as.getMoney()){
			throw new GameException(GameException.CODE_勇气点数不够, "");	
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_竞技场兑换);
		effects.appendItem(as.getType(), as.getGoodsId(), as.getNum(), as.getLevel());
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		GainAwardVO awards = effectService.addGainAwardVo(user, effects);
		as.setNum(0);
		arena.getShoppingList().set(shoppingId-1, as);
		SQLOpt arenaOpt = new SQLOpt();
		arenaOpt.putFieldOpt(ArenaTable.SHOPPING, SQLOpt.EQUAL);
		arenaOpt.putFieldOpt(ArenaTable.VALOUR, SQLOpt.EQUAL);
		arena.setValour(arena.getValour()-as.getMoney());
		arenaDAO.updateArena(arena, arenaOpt);
		return awards;
	}

	@Override
	public List<ArenaAward> queryArenaAward() {
		return arenaCfgDAO.queryArenaAward();
	}

	@Override
	public List<UserBaseinfoVO> queryArenaRankTop50(int type,int userId) {
		List<Integer> userIds=null;
		List<UserBaseinfoVO> voList=new ArrayList<UserBaseinfoVO>();
		if(type==1){  //当天胜场最多排行
		     userIds=arenaDAO.getArenaTodayWinsRankTop50();
			
		}else if(type==2){ //当天连胜场最多排行
			  userIds=arenaDAO.getArenaTodayMaxWinsRankTop50();
		}
		List<UserBaseinfo> ubList=userDAO.getUserBaseinfos(userIds);
		for (UserBaseinfo ub:ubList) {
			UserBaseinfoVO vo = MessageFactory.getMessage(UserBaseinfoVO.class);
			vo.init(ub);
			voList.add(vo);
		}
		if(type==2){
			Collections.sort(voList, new Comparator<UserBaseinfoVO>() {
				@Override
				public int compare(UserBaseinfoVO o1, UserBaseinfoVO o2) {
					if(o1.getTodayMaxWins()==o2.getTodayMaxWins()){
						return o1.getUserId()-o2.getUserId();
					}
					return o2.getTodayMaxWins()-o1.getTodayMaxWins();
				}
			});	
		}else{
			Collections.sort(voList, new Comparator<UserBaseinfoVO>() {
				@Override
				public int compare(UserBaseinfoVO o1, UserBaseinfoVO o2) {
					if(o1.getTodayWins()==o2.getTodayWins()){
						return o1.getUserId()-o2.getUserId();
					}
					return o2.getTodayWins()-o1.getTodayWins();
				}
			});	
		}
		 
		return voList;
	}

	@Override
	public List<MartialWayAwardExp> queryArenaAwardExp() {
		return arenaCfgDAO.queryArenaAwardExp();
	}
	@Override
	public List<ArenaLoggerVO> queryArenaLogger(int userId,int type) {
//		 arenaDAO.deleteArenaLogger(userId,type);
		 List<ArenaLogger> alList=getArenaLoggers(userId,type);
		 List<ArenaLoggerVO> voList=new ArrayList<ArenaLoggerVO>();
		 for (ArenaLogger al:alList) {
			 ArenaLoggerVO vo=MessageFactory.getMessage(ArenaLoggerVO.class);
			 vo.init(al);
			 voList.add(vo);
		 }
		return voList;
	}
	@Override
	public void clearArena() {
		arenaDAO.clearArena();
	}
	@Override
	public void refArenaShopping() {
		List<Arena> arenaList=arenaDAO.queryRankArena();
		if(!arenaList.isEmpty()){
			for (Arena arena:arenaList) {
				arenaDAO.refArenaShopping( getShoppings(),arena.getUserId());
			}
		}
	}
	@Override
	public void delArenaRank() {
		arenaDAO.delArenaRank();
		List<Arena> list= arenaDAO.queryRankArena();
		for (Arena arena:list) {
			UserBaseinfo info=userDAO.getUserBaseinfo(arena.getUserId());
			if(info != null){
				info.setStreakWin(0);
				info.setTodayWins(0);
				info.setTodayMaxWins(0);
				userDAO.updateUserBaseinfo(info);
			}
			
		}
	}
	
	@Override
	public List<ArenaBuy> queryArenaBuys() {
		return arenaCfgDAO.queryArenaBuys();
	}
	
}
