package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.cache.JedisNoLoadException;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.ActivityZone;
import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.BreadStoreRule;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.Zone;
import com.ks.db.cfg.ZoneAward;
import com.ks.db.cfg.ZoneBattle;
import com.ks.db.log.ZoneBattleLogger;
import com.ks.db.model.User;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserZone;
import com.ks.db.model.UserZoneBattle;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.dao.UserZoneDAO;
import com.ks.logic.event.GameLoggerEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserZoneService;
import com.ks.model.fight.Battle;
import com.ks.model.user.AssStat;
import com.ks.object.DropEffect;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.zone.ActivityZoneVO;
import com.ks.protocol.vo.zone.TrialsZoneVO;
import com.ks.protocol.vo.zone.UserZoneBattleVO;
import com.ks.protocol.vo.zone.UserZoneVO;
import com.ks.table.UserRecordTable;
import com.ks.table.UserStatTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;
import com.ks.util.DateUtil;
import com.ks.util.MathUtil;
import com.ks.util.XyStringUtil;

public class UserZoneServiceImpl extends BaseService implements UserZoneService {

	/*****************************************************user_zone data*******************************************************/
	@Override
	public void updateUserZone(UserZone zone){
		userZoneDAO.updateUserZone(zone);
		userZoneDAO.updateUserZoneCache(zone);
	}
	
	public Map<Integer, UserZone> zoneListToMap(Collection<UserZone> collection){
		Map<Integer, UserZone> map = new HashMap<Integer, UserZone>();
		for(UserZone zone : collection){
			map.put(zone.getZoneId(), zone);
		}
		return map;
	}
	/**
	 * 加载副本
	 * @param user
	 */
	public Map<Integer, UserZone> loadUserZoneToCache(int userId){
		List<UserZone> list =  loadDBUserZone(userId);
		Map<Integer, UserZone> map = zoneListToMap(list);
		userZoneDAO.setUserZonesCache(userId, map);
		return map;
	}
	
	/**
	 * 加载副本
	 * @param user
	 */
	private List<UserZone> loadDBUserZone(int userId){
		List<UserZone> list = userZoneDAO.queryZone(userId);
		return list;
	}
	
	@Override
	public UserZone getUserZone(int userId, int zoneId){
		try{
			return userZoneDAO.getUserZoneCache(userId, zoneId);
		}catch(JedisNoLoadException e){
			Map<Integer, UserZone> map = loadUserZoneToCache(userId);
			return map.get(zoneId);
		}
	}
	
	@Override
	public void addUserZone(UserZone zone){
		userZoneDAO.addUserZone(zone);
		userZoneDAO.addUserZoneCache(zone);
	}
	
	@Override
	public void updateUserZoneBattle(UserZoneBattle battle){
		userZoneDAO.updateUserZoneBattle(battle);
		userZoneDAO.updateUserZoneBattleCache(battle);
	}
	
	public Map<String, UserZoneBattle> zoneBattleListToMap(Collection<UserZoneBattle> collection){
		Map<String, UserZoneBattle> map = new HashMap<String, UserZoneBattle>();
		for(UserZoneBattle battle : collection){
			map.put(UserZoneDAO.getUserZoneBattleKey(battle), battle);
		}
		return map;
	}
	/**
	 * 加载副本
	 * @param user
	 */
	public Map<String, UserZoneBattle> loadUserZoneBattleToCache(int userId){
		List<UserZoneBattle> list =  loadDBUserZoneBattle(userId);
		Map<String, UserZoneBattle> map = zoneBattleListToMap(list);
		userZoneDAO.setUserZoneBattlesCache(userId, map);
		return map;
	}
	
	/**
	 * 加载副本
	 * @param user
	 */
	private List<UserZoneBattle> loadDBUserZoneBattle(int userId){
		List<UserZoneBattle> list = userZoneDAO.queryUserZoneBattles(userId);
		return list;
	}
	
	/**
	 * 加载副本战斗
	 * @param userId
	 * @param zoneId
	 * @param battleId
	 * @return
	 */
	@Override
	public UserZoneBattle getUserZoneBattle(int userId, int zoneId, int battleId){
		try{
			return userZoneDAO.getUserZoneBattleCache(userId, zoneId, battleId);
		}catch(JedisNoLoadException e){
			Map<String, UserZoneBattle> map = loadUserZoneBattleToCache(userId);
			return map.get(UserZoneDAO.getUserZoneBattleKey(zoneId, battleId));
		}
	}
	@Override
	public List<UserZoneBattle> getUserZoneBattle(int userId, int zoneId){
		List<ZoneBattle> zbs = GameCache.getZoneBattles(zoneId);
		List<String> keys = new ArrayList<String>();
		for(ZoneBattle zb : zbs){
			keys.add(UserZoneDAO.getUserZoneBattleKey(zb.getZoneId(), zb.getBattleId()));
		}
		try{
			return userZoneDAO.getUserZoneBattleCache(userId, keys);
		}catch(JedisNoLoadException e){
			Map<String, UserZoneBattle> map = loadUserZoneBattleToCache(userId);
			List<UserZoneBattle> list = new ArrayList<UserZoneBattle>();
			for(String key : keys){
				UserZoneBattle battle = map.get(key);
				if(battle != null){
					list.add(battle);
				}
			}
			return list;
		}
	}
	
	@Override
	public void addUserZoneBattle(UserZoneBattle battle){
		userZoneDAO.addUserZoneBattle(battle);
		userZoneDAO.addUserZoneBattleCache(battle);
	}
	
	/*****************************************************user_zone logic*******************************************************/
	
	@Override
	public List<UserZoneVO> queryCurrZone(int userId) {
//		List<UserZone> zones = userZoneDAO.queryZone(userId);
		Map<Integer, UserZone> zonemap = loadUserZoneToCache(userId);
		if(zonemap.isEmpty()){
			UserZone zone = new UserZone();
			zone.setUserId(userId);
			zone.setZoneId(1001);
			zone.setZoneType(1);
			addUserZone(zone);
			zonemap.put(zone.getZoneId(), zone);
		}
		List<UserZoneVO> vos = new ArrayList<UserZoneVO>();
		for(UserZone zone : zonemap.values()){
			UserZoneVO vo = MessageFactory.getMessage(UserZoneVO.class);
			vo.init(zone);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public FightVO intoZone(int userId, int battleId) {
		User user = userService.getOnlineUser(userId);
		if(!"".equals(user.getFightId())&&user.getFightId()!=null){
			fightDAO.deleteBattle(user.getFightId());
		}
		Zone zone = null;
		ZoneBattle zoneBattle = GameCache.getZoneBattle(battleId);
		if(zoneBattle == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			int code = conditionService.validCondition(user, zoneBattle.getConditionParams());
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}else{
				zone = GameCache.getZone(zoneBattle.getZoneId());
				if(zone.getLevel() > user.getLevel()){
					throw new GameException(GameException.CODE_等级不足, "");
				}else if(zone.getType() == SystemConstant.ZONE_TYPE_TRIALS){
					if(zone.getZoneId() == SystemConstant.ZONE_ID_GOD_WEALTH
							|| zone.getZoneId() == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
						if(!activityService.isOpenTime(zone.getZoneId())){
							throw new GameException(GameException.CODE_未到开启时间, "");
						}
					}
					userService.validTrialsNumber(user, userService.getUserStat(user.getUserId()), zone.getZoneId(), 1);
				}
				validBackpack(user, zoneBattle);//校验背包
			}
		}
		if(zone.getZoneId() == SystemConstant.ZONE_ID_GOD_WEALTH || zone.getZoneId() == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
			UserRecord record = userDAO.getUserRecord(userId);
			if(record != null){
				record.addTrialsId(zoneBattle.getBattleId());
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(UserRecordTable.TRIALSIDS, SQLOpt.EQUAL);
				userDAO.updateUserRecord(record, opt);
			}
		}
		if(zone.getType() == SystemConstant.ZONE_TYPE_SIMPLE 
				|| zone.getType() == SystemConstant.ZONE_TYPE_ELITE
				|| zone.getType() == SystemConstant.ZONE_TYPE_TRIALS){
			UserZone userZone = getUserZone(userId, zoneBattle.getZoneId());
			if(userZone == null){
				if(zoneBattle.getPevBattle()!=0){
					ZoneBattle pevBattle = GameCache.getZoneBattle(zoneBattle.getPevBattle());
					UserZone pevZone = getUserZone(userId, pevBattle.getZoneId());
					if(pevZone == null){
						throw new GameException(GameException.CODE_参数错误, "");
					}
					if(pevZone.getCurrBattle() < zoneBattle.getPevBattle()){
						throw new GameException(GameException.CODE_参数错误, "");
					}
				}
			}else{
				if(zoneBattle.getPevBattle()!=0){
					ZoneBattle pevBattle = GameCache.getZoneBattle(zoneBattle.getPevBattle());
					if(pevBattle.getZoneId()==userZone.getZoneId()){
						if(userZone.getCurrBattle()<pevBattle.getBattleId()){
							throw new GameException(GameException.CODE_参数错误, "");
						}
					}else{
						UserZone pevZone = getUserZone(userId, pevBattle.getZoneId());
						if(pevZone == null){
							throw new GameException(GameException.CODE_参数错误, "");
						}
						if(pevZone.getCurrBattle() < zoneBattle.getPevBattle()){
							throw new GameException(GameException.CODE_参数错误, "");
						}
						
						UserZoneBattle battle = getUserZoneBattle(userId, zone.getZoneId(), battleId);
						if(zoneBattle.getBattleType() == SystemConstant.ZONE_TOLLGATE_TYPE_SIMPLE){
							if(battle!=null&&battle.getPassCount()!=0){
								throw new GameException(GameException.CODE_参数错误, "");
							}
						}
						
						if(zone.getType() == SystemConstant.ZONE_TYPE_ELITE){
							if(battle!=null){
								checkBattleCount(battle);
								if(battle.getChallengeCount()>=3){
									throw new GameException(GameException.CODE_参数错误, "");
								}
							}
						}
					}
				}
			}
		}else{
			ActivityZone az = GameCache.getActivityZone(zone.getZoneId());
			if(az==null){
				throw new GameException(GameException.CODE_活动尚未开始或已过期, "");
			}
			if(az.getType() == 0){
				long now = System.currentTimeMillis();
				if(now<az.getStartTime() || now > az.getEndTime()){
					throw new GameException(GameException.CODE_活动尚未开始或已过期, "");
				}
			}else{
				Calendar  c = Calendar.getInstance();
				int week = c.get(Calendar.DAY_OF_WEEK);
				long hour = c.get(Calendar.HOUR_OF_DAY);
				week = week == 1?7:week-1;
				if(az.getType() != week){
					throw new GameException(GameException.CODE_活动尚未开始或已过期, "");
				}
				if(az.getStartTime()<hour || az.getEndTime()>=hour){
					throw new GameException(GameException.CODE_活动尚未开始或已过期, "");
				}
				if(az.getNum()!=0){
					UserStat stat = userService.getUserStat(userId);
					AssStat as = null;
					for(AssStat a : stat.getActivityZoneCountList()){
						if(a.getAssId() == zone.getZoneId()){
							as = a;
							break;
						}
					}
					if(as!=null){
						if(as.getNum()>=az.getNum()){
							throw new GameException(GameException.CODE_参数错误, "");
						}
					}
				}
			}
			
		}
		
		userService.checkStamina(user);
		
		if(user.getStamina()<zoneBattle.getSp()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		Battle battle = fightService.startZoneFight(userId, battleId);
		
		
		fightDAO.updateBattle(battle);
		
		Map<String,String> hash = new HashMap<>();
		hash.put(UserTable.J_FIGHTID, battle.getBattleId());
		
//		userDAO.updateUserCache(userId, hash);
		userService.updateUser(user, hash, false);
		
		FightVO vo = MessageFactory.getMessage(FightVO.class);
		vo.init(battle);
		ZoneBattleLogger logger = new ZoneBattleLogger(userId, zone.getZoneId(), battleId);
		logger.setState(1);
		TimerController.submitGameEvent(new GameLoggerEvent(SystemConstant.LOG_EVENT_TYPE_BATTLE, logger));
		return vo;
	}
	
	/**
	 * 校验战斗所需背包空间
	 * @param user
	 * @param battle
	 */
	private void validBackpack(User user, ZoneBattle battle){
		int heroSize = 0;
		int eternalSize = 0;
		int equipSize = 0;
		int propSize = 0;
		int round = 1;
		BattleRound nextRound = GameCache.getBattleRound(battle.getBattleId(), round);
		while(nextRound != null){
			for(int monsterId : nextRound.getMonsters()){
				Monster monster = GameCache.getMonster(monsterId);
				if(monster != null && monster.getDrops() != null){
					for(DropEffect effect : monster.getDrops()){
						heroSize += effect.getMaxItemSize(SystemConstant.ITEM_EFFECT_TYPE_HERO);
						propSize += effect.getMaxItemSize(SystemConstant.ITEM_EFFECT_TYPE_PROP);
						eternalSize += effect.getMaxItemSize(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL);
						equipSize += effect.getMaxItemSize(SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT);
					}
				}
			}
			round++;
			nextRound = GameCache.getBattleRound(battle.getBattleId(), round);
		}
		int code = effectService.validSize(user, heroSize, eternalSize, equipSize, propSize);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
	}

	private void checkBattleCount(UserZoneBattle battle) {
		if(DateUtil.isBeforeToDay(battle.getLastChallengeTime())){
			battle.setChallengeCount(0);
			battle.setLastChallengeTime(new Date());
			userZoneDAO.updateUserZoneBattle(battle);
		}
	}

	@Override
	public UserZoneVO queryCurrEliteZone(int userId,int zoneId) {
		UserZone zone = getUserZone(userId, zoneId);
		UserZoneVO vo = MessageFactory.getMessage(UserZoneVO.class);
		vo.init(zone);
		return vo;
	}

	@Override
	public List<ActivityZoneVO> queryActivityZones(int userId) {
		List<ActivityZoneVO> az = new ArrayList<ActivityZoneVO>();
		UserStat stat = userService.getUserStat(userId);
		for(ActivityZone a : GameCache.getActivityZones()){
			if(checkActivityZone(stat, a)){
				ActivityZoneVO vo = MessageFactory.getMessage(ActivityZoneVO.class);
				vo.init(a);
				az.add(vo);
			}
		}
		return az;
	}

	private boolean checkActivityZone(UserStat stat,ActivityZone a) {
		if(a.getType() == SystemConstant.ZONE_TYPE_TIME){
			long now = System.currentTimeMillis();
			if(now<a.getStartTime() || now > a.getEndTime()){
				return false;
			}
		}else{
			Calendar  c = Calendar.getInstance();
			int week = c.get(Calendar.DAY_OF_WEEK);
			long hour = c.get(Calendar.HOUR_OF_DAY);
			week = week == 1?7:week-1;
			if(a.getType() != week){
				return false;
			}
			if(a.getStartTime()<hour || a.getEndTime()>=hour){
				return false;
			}
			if(a.getNum()!=0){
				AssStat as = null;
				for(AssStat aa : stat.getActivityZoneCountList()){
					if(aa.getAssId() == a.getZoneId()){
						as = aa;
						break;
					}
				}
				if(as!=null){
					if(as.getNum()>=a.getNum()){
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public List<UserZoneBattleVO> queryUserZoneBattle(int userId, int zoneId) {
		List<UserZoneBattle> battles = getUserZoneBattle(userId, zoneId);
		List<UserZoneBattleVO> vos = new ArrayList<UserZoneBattleVO>();
		for(UserZoneBattle battle : battles){
			checkBattleCount(battle);
			UserZoneBattleVO vo = MessageFactory.getMessage(UserZoneBattleVO.class);
			vo.init(battle);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public GainGameAwardVO gainZoneAward(int userId, int zoneId, int star) {
		UserZone userZone = getUserZone(userId, zoneId);
		if(userZone==null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(userZone.getGainAwardStar().indexOf(star)!=-1){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		List<ZoneAward> awards = GameCache.getZoneAwards(zoneId, star);
		if(awards==null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		List<UserZoneBattle> zoneBattles = getUserZoneBattle(userId, zoneId);
		int s = 0;
		for(UserZoneBattle uz : zoneBattles){
			ZoneBattle b = GameCache.getZoneBattle(uz.getZoneBattleId());
			if(b.getBattleType() == SystemConstant.ZONE_TOLLGATE_TYPE_BOSS){
				s+=uz.getStar();
			}
		}
		
		if(s<star){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		User user = userService.getOnlineUser(userId);
		int mult = activityService.getMultNumByZoneId(zoneId);
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_副本星数奖励);
		effects.appendGoods(awards, mult);
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		userZone.getGainAwardStarList().add(star);
		updateUserZone(userZone);
		return effectService.addGainGameAwardVo(user, effects);
	}
	
	@Override
	public TrialsZoneVO gainTrialZones(int userId, int zoneId){
		Zone zone = GameCache.getZone(zoneId);
		if(zone == null || zone.getType() != SystemConstant.ZONE_TYPE_TRIALS){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			User user = userService.getOnlineUser(userId);
			UserZone userZone = userZoneService.getUserZone(userId, zoneId);
			if(userZone == null){
				userZone = new UserZone();
				userZone.setUserId(userId);
				userZone.setZoneId(zone.getZoneId());
				userZone.setZoneType(zone.getType());
				userZone.setGainAwardStarList(new ArrayList<Integer>());
				userZoneService.addUserZone(userZone);
			}
			UserStat stat = userService.getUserStat(user.getUserId());
			if(zoneId == SystemConstant.ZONE_ID_BREAD_STORE){
				return refreshBreadStore(user, stat, false);
			}else{
				List<Integer> ids = new ArrayList<>();
				int number = 0;
				if(zoneId == SystemConstant.ZONE_ID_GOD_WEALTH){
					number = getValue(privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_GOD_WEALTH_NUMBER) - stat.getGodWealthCount());
				}else if(zoneId == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
					number = getValue(privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_ANIMA_TEMPLE_NUMBER) - stat.getAnimaTempleCount());
				}
				List<ZoneBattle> zones = GameCache.getZoneBattles(zoneId);
				if(!zones.isEmpty()){
					for(int i = 1; i <= 4; i++){
						for(ZoneBattle bat : zones){
							if(bat.getGroup() == i){
								ids.add(bat.getBattleId());
							}
						}
					}
				}
				TrialsZoneVO vo = MessageFactory.getMessage(TrialsZoneVO.class);
				vo.init(zoneId, ids, number, 0, 0, getTrialsIds(userId, zoneId));
				return vo;
			}
		}
	}
	private int getValue(int value){
		if(value < 0){
			return 0;
		}
		return value;
	}
	private TrialsZoneVO refreshBreadStore(User user, UserStat stat, boolean refresh){
		List<Integer> ids = stat.getBreadStoreZoneIds();
		if(ids.isEmpty() || refresh){
			ids.clear();
			BreadStoreRule rule = GameCache.getBreadStoreRule(user.getLevel());
			if(rule != null){
				List<ZoneBattle> zones = GameCache.getZoneBattles(SystemConstant.ZONE_ID_BREAD_STORE);
				if(!zones.isEmpty()){
					List<Integer> list = new ArrayList<>();
					for(int i = 0; i < 4; i++){
						int eleType = MathUtil.nextInt(5) + 1;
						while(list.contains(eleType)){
							eleType = MathUtil.nextInt(5) + 1;
						}
						list.add(eleType);
						int star = rule.getStar();
						for(ZoneBattle bat : zones){
							if(bat.getGroup() == eleType && bat.getSubGroup() == star){
								ids.add(bat.getBattleId());
								break;
							}
						}
					}
					stat.setBreadStoreZones(XyStringUtil.parseString(ids, XyStringUtil.JOIN_UNDERLINE));
					SQLOpt opt = new SQLOpt();
					opt.putFieldOpt(UserStatTable.BREADSTOREZONES, SQLOpt.EQUAL);
					userService.updateUserStat(stat, opt);
				}
			}
		}
		int number = getValue(privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BREAD_STORE_NUMBER) - stat.getBreadStoreCount());
		int freeRefreshNum = getValue(SystemConstant.TRIALS_BREAD_STORE_REFRESH_NUMBER - stat.getBreadStoreFreeRefreshCount());
		int diamondRefreshNum = getValue(privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BREAD_STORE_DIAMOND_REFRESH_NUMBER) - stat.getBreadStoreDiamondRefreshCount());
		TrialsZoneVO vo = MessageFactory.getMessage(TrialsZoneVO.class);
		vo.init(SystemConstant.ZONE_ID_BREAD_STORE, ids, number, freeRefreshNum, diamondRefreshNum, null);
		return vo;
	}
	
	@Override
	public TrialsZoneVO refreshBreadStore(int userId){
		User user = userService.getOnlineUser(userId);
		UserStat stat = userService.getUserStat(user.getUserId());
		SQLOpt opt = new SQLOpt();
		if(stat.getBreadStoreFreeRefreshCount() >= SystemConstant.TRIALS_BREAD_STORE_REFRESH_NUMBER){
			if(stat.getBreadStoreDiamondRefreshCount() < privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BREAD_STORE_DIAMOND_REFRESH_NUMBER)){
				effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.TRIALS_BREAD_STORE_DIAMOND_REFRESH_PRICE, SystemConstant.LOGGER_APPROACH_刷新包子铺);
				stat.setBreadStoreDiamondRefreshCount(stat.getBreadStoreDiamondRefreshCount() + 1);
				opt.putFieldOpt(UserStatTable.BREADSTOREDIAMONDREFRESHCOUNT, SQLOpt.EQUAL);
			}else{
				throw new GameException(GameException.CODE_可刷新次数不足, "");
			}
		}else{
			stat.setBreadStoreFreeRefreshCount(stat.getBreadStoreFreeRefreshCount() + 1);
			opt.putFieldOpt(UserStatTable.BREADSTOREFREEREFRESHCOUNT, SQLOpt.EQUAL);
		}
		userStatDAO.updateUserStat(opt, stat);
		return refreshBreadStore(user, stat, true);
	}
	
	/**
	 * 获取试练记录
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	private List<Integer> getTrialsIds(int userId, int zoneId){
		if(zoneId != SystemConstant.ZONE_ID_BREAD_STORE){
			List<Integer> ids = new ArrayList<>();
			UserRecord record = userDAO.getUserRecord(userId);
			List<Integer> alls = record.getTrialsIdList();
			if(record != null && !alls.isEmpty()){
				for(Integer id : alls){
					ZoneBattle battle = GameCache.getZoneBattle(id);
					if(battle != null && battle.getZoneId() == zoneId){
						ids.add(id);
					}
				}
			}
			return ids;
		}
		return null;
	}
	
	
}
