package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.action.world.WorldChatAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Fame;
import com.ks.db.cfg.PropEffect;
import com.ks.db.cfg.Signin;
import com.ks.db.cfg.SumSignin;
import com.ks.db.cfg.UserRule;
import com.ks.db.log.LoginLogger;
import com.ks.db.log.OnlineReportLogger;
import com.ks.db.log.RegistLossLogger;
import com.ks.db.model.AgainstRequst;
import com.ks.db.model.Arena;
import com.ks.db.model.Goods;
import com.ks.db.model.GuildMember;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserTeam;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.cache.UserCache;
import com.ks.logic.event.task.FrameLevelUpEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserService;
import com.ks.model.user.UserBaseinfo;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.protocol.vo.login.LoginResultVO;
import com.ks.protocol.vo.login.LoginVO;
import com.ks.protocol.vo.login.RegisterVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;
import com.ks.protocol.vo.user.UserInfoVO;
import com.ks.protocol.vo.user.UserTeamVO;
import com.ks.protocol.vo.user.ViewUserVO;
import com.ks.rpc.RPCKernel;
import com.ks.table.UserStatTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;
import com.ks.util.DateUtil;
import com.ks.util.KeyWordsUtil;
import com.ks.util.MathUtil;
import com.ks.util.XyTimeUtil;

public final class UserServiceImpl extends BaseService implements UserService {

	/***************************************************user data****************************************************************/
	@Override
	public void updateUser(User user, Map<String, String> hash, boolean updatedb){
		userDAO.updateUserCache(user.getUserId(), hash);
		if(updatedb){
			userDAO.updateUser(user);
		}
		dataService.updateUser(user);
		if(hash.containsKey(UserTable.J_LEVEL)
				|| hash.containsKey(UserTable.J_FIGHTING) 
				|| hash.containsKey(UserTable.J_PLAYERNAME)
				|| hash.containsKey(UserTable.J_CHARGEDIAMOND)
				|| hash.containsKey(UserTable.J_VIP)){
			UserBaseinfo info = getUserBaseInfo(user.getUserId());
			info.setLevel(user.getLevel());
			info.setFighting(user.getFighting());
			info.setPlayerName(user.getPlayerName());
			info.setChargeDiamond(user.getChargeDiamond());
			info.setVip(user.getVip());
			userDAO.updateUserBaseinfo(info);
		}
	}
	
	@Override
	public void updateUserRecord(UserRecord record, SQLOpt opt){
		userDAO.updateUserRecord(record, opt);
		dataService.updateUserRecord(record);
	}
	
	/*******************************************************user stat*********************************************************/
	@Override
	public void updateUserStat(UserStat stat, SQLOpt opt){
		userStatDAO.updateUserStat(opt, stat);
		userStatDAO.updateUserStatCache(stat);
		dataService.updateUserStat(stat);
	}
	
	@Override
	public void addUserStat(UserStat stat){
		userStatDAO.addUserStat(stat);
		userStatDAO.setUserStatCache(stat, false);
	}
	
	/**
	 * 加载用户统计
	 * @param user
	 */
	public UserStat loadUserStatToCache(int userId){
		UserStat stat =  loadDBUserStat(userId);
		userStatDAO.setUserStatCache(stat, true);
		return stat;
	}
	
	/**
	 * 加载用户统计
	 * @param user
	 */
	private UserStat loadDBUserStat(int userId){
		UserStat stat = userStatDAO.queryUserStat(userId);
		return stat;
	}
	
	public UserStat getUserStatData(int userId){
		UserStat stat = userStatDAO.queryUserStatCache(userId);
		if(stat == null){
			stat = loadUserStatToCache(userId);
		}
		return stat;
	}
	
	/***************************************************logic****************************************************************/
	@Override
	public LoginResultVO userLogin(LoginVO login) {
		User user = userDAO.findUserByUsername(login.getUsername(), login.getPartner());
		LoginResultVO vo = MessageFactory.getMessage(LoginResultVO.class);
		if (user != null) {
			if(user.getBanLoginTime() > XyTimeUtil.getNowSecond()){
				throw new GameException(GameException.CODE_您已被封号, "");
			}
			vo.setUserId(user.getUserId());
		}else{
			RegistLossLogger logger = new RegistLossLogger(1, login.getUsername(), login.getPartner());
			gameLoggerDAO.addRegistLossLogger(logger);
		}
		return vo;
	}

	@Override
	public void logout(int userId) {
		User user = userDAO.getUserFromCache(userId);
		if (user != null) {
			user.setOnline(0);
			int time = (int) ((System.currentTimeMillis() - user.getLastLoginTime().getTime()) / 1000);
			if(user.getFirstOnlineTime() <= 0){
				user.setFirstOnlineTime(time);
			}
			user.setDailyOnlineTime(user.getDailyOnlineTime() + time);
			userDAO.updateUser(user);
			userDAO.delUserCache(userId);
			userStatDAO.clearUserStatCache(userId);
			userHeroDAO.clearUserHeroCache(userId);
			userPropDAO.clearUserPropCache(userId);
			userEternalDAO.clearUserEternalCache(userId);
			userEquipmentDAO.clearUserEquipmentCache(userId);
			userTaskDAO.clearUserTasksCache(userId);
			userZoneDAO.clearUserZonesCache(userId);
			userZoneDAO.clearUserZoneBattlesCache(userId);
			friendDAO.clearFriendsCache(userId);
			friendDAO.clearFriendApplysCache(userId);
			friendDAO.clearFriendRecoCache(userId);
			mailDAO.clearMailsCache(userId);
			UserBaseinfo baseInfo = getUserBaseInfo(userId);
			baseInfo.setOnline(false);
			
			userDAO.updateUserBaseinfo(baseInfo);
			LoginLogger logger = new LoginLogger(user.getUserId(), user.getPlayerName(), 3);
			gameLoggerDAO.addLoginLogger(logger);
		}
	}
	@Override
	public void userRegister(RegisterVO register) {
		if (userDAO.findUserByUsername(register.getUsername(), register.getPartner()) != null){
			throw new GameException(GameException.CODE_玩家已经注册, "");
		}else if (userDAO.findUserByPlayerName(register.getPlayerName()) != null) {
			throw new GameException(GameException.CODE_玩家名重复, "");
		}else if(KeyWordsUtil.hasBadWords(register.getPlayerName())){
			throw new GameException(GameException.CODE_包含敏感词汇, "");
		}
		RegistLossLogger logger2 = new RegistLossLogger(2, register.getUsername(), register.getPartner());
		gameLoggerDAO.addRegistLossLogger(logger2);
		User user = new User();
		user.setUsername(register.getUsername());
		user.setPlayerName(register.getPlayerName());
		user.setPartner(register.getPartner());
		user.setLevel(SystemConstant.USER_MIN_LEVEL);
		user.setGold(SystemConstant.USER_INIT_GOLD);
		user.setDiamond(SystemConstant.USER_INIT_DIAMOND);
		user.setGp(SystemConstant.USER_INIT_GP);
		UserRule rule = GameCache.getUserRule(user.getLevel());
		user.setStamina(rule.getStamina());
		userDAO.addUser(user);
		userDAO.updateUserLevel(user.getLevel(), user.getUserId());

		boolean hasHero = false;
		for (int id : SystemConstant.INIT_HEROS) {
			if (id == register.getInitHeroId()) {
				hasHero = true;
				break;
			}
		}
		// 初始化英雄是否合法
		if (hasHero) {
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_注册赠送);
			effects.addItem(SystemConstant.ITEM_EFFECT_TYPE_HERO, register.getInitHeroId(), 1, 1);
			effectService.addIncome(user, effects);
		} else {
			throw new GameException(GameException.CODE_参数错误, "");
		}

		AgainstRequst ar = new AgainstRequst();
		ar.setUserId(user.getUserId());
		againstRequstDAO.addAgainstRequst(ar);
		RegistLossLogger logger3 = new RegistLossLogger(3, user.getUsername(), user.getPartner());
		gameLoggerDAO.addRegistLossLogger(logger3);
		LoginLogger loginLogger = new LoginLogger(user.getUserId(), user.getPlayerName(), 1);
		gameLoggerDAO.addLoginLogger(loginLogger);
	}
	
	@Override
	public UserInfoVO gainUserInfo(final int userId) {
		Date lastTime = null;
		Map<String, String> hash = new HashMap<>();
		User user = userDAO.getUserFromCache(userId);
		if (user == null) {
			user = userDAO.findUserByUserId(userId);
			if (user == null) {
				throw new GameException(GameException.CODE_参数错误, "");
			}
			lastTime = user.getLastLoginTime();
			user.setLastLoginTime(XyTimeUtil.getNowDate());
			userDAO.addUserCache(user);
		}else{
			lastTime = user.getLastLoginTime();
			user.setLastLoginTime(XyTimeUtil.getNowDate());
			hash.put(UserTable.J_LASTLOGINTIME, String.valueOf(user.getLastLoginTime().getTime()));
		}
		if(user.getBanLoginTime() > XyTimeUtil.getNowSecond()){
			throw new GameException(GameException.CODE_您已被封号, "");
		}
		checkStamina(user);
		privilegeService.resetDate(user, lastTime);  
		if(DateUtil.isBeforeToDay(user.getLastLoginTime())){
			user.setDailyOnlineTime(0);
			hash.put(UserTable.J_DAILYONLINETIME, String.valueOf(user.getDailyOnlineTime()));
		}
		user.setOnline(1);
		user.setAccessTime(XyTimeUtil.getNowSecond());
		hash.put(UserTable.J_ONLINE, String.valueOf(user.getOnline()));
		hash.put(UserTable.J_ACCESSTIME, String.valueOf(user.getAccessTime()));
		updateUser(user, hash, true);

		Collection<UserHero> heros = userHeroService.initUserHeros(userId);
		Collection<UserProp> userProps = userPropService.initProps(userId);
		Collection<UserEquipment> userEquipments = userEquipmentService.initUserEquipment(userId);
		Collection<UserEternal> eternals = userEternalService.initUserEternal(userId);
		mailService.initMails(userId);
		UserRecord userRecord = userDAO.getUserRecord(userId);
		UserInfoVO userInfo = MessageFactory.getMessage(UserInfoVO.class);
		userInfo.init(user, heros, userProps, userEquipments, eternals, userRecord.getFirstRechargeList());

		GuildMember guildMember = guildMemberDAO.queryGuildMember(userId);
		if (guildMember != null) {
			if (guildMember.getProperty() == SystemConstant.GUILD_MEMBER_会长) {
				guildAccuseDAO.deleteGuildAccuse(guildMember.getGuildId());
			}
		}
		userDAO.updateUserLevel(user.getLevel(), user.getUserId());
		
		if(user.getBanChatTime() > XyTimeUtil.getNowSecond()){
			WorldChatAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldChatAction.class);
			action.banChat(user.getUserId(), user.getBanChatTime());
		}
		LoginLogger logger = new LoginLogger(user.getUserId(), user.getPlayerName(), 2);
		gameLoggerDAO.addLoginLogger(logger);
		fightService.computeFightingEvent(user.getUserId());
		return userInfo;
	}

	public void setUserOnline(int userId) {
		UserBaseinfo baseInfo = getUserBaseInfo(userId);
		baseInfo.setOnline(true);
		userDAO.updateUserBaseinfo(baseInfo);
	}

	@Override
	public User getOnlineUser(int userId) {
		User user = queryCacheUser(userId);
		if(user == null){
			throw new GameException(GameException.CODE_已经掉线, "");
		}
		return user;
	}
	
	@Override
	public User queryCacheUser(int userId){
		User user = UserCache.getUser(userId);
		if(user == null){
			user = userDAO.getUserFromCache(userId);
			if(user != null){
				UserCache.add(user);
			}
		}
		return user;
	}

	@Override
	public List<UserRule> queryUserRules() {
		return userRuleDAO.queryUserRule();
	}


	@Override
	public UserStat getUserStat(int userId) {
		User user = getUser(userId);
		if(user.getStat() == null){
			UserStat stat = getUserStatData(user.getUserId());
			boolean add = stat == null;
			if(add){
				stat = UserStat.createUserStat(user.getUserId());
			}
			if(stat.getBlackMarketGoodsList().isEmpty()){
				stat.setBlackMarketGoodsList(mallService.createBlackMarketGoods());
				if(!add){
					SQLOpt opt = new SQLOpt();
					opt.putFieldOpt(UserStatTable.BLACKMARKETGOODS, SQLOpt.EQUAL);
					userService.updateUserStat(stat, opt);
				}
			}
			if(add){
				addUserStat(stat);
			}
			user.setStat(stat);
		}
		return user.getStat();
	}

	@Override
	public ViewUserVO viewUser(int userId) {
		ViewUserVO vo = MessageFactory.getMessage(ViewUserVO.class);
		if(userId > 0){
			User user = userService.getUser(userId);
			UserTeam userTeam = userTeamService.queryUserTeam(userId);
			UserTeamVO teamVO = MessageFactory.getMessage(UserTeamVO.class);
			teamVO.init(userTeam);
			vo.setTeam(teamVO);
			List<UserHeroVO> heros = new ArrayList<UserHeroVO>();
			for(int userHeroId : userTeam.getHeroList()){
				if (userHeroId != 0) {
					UserHero hero = userHeroService.getUserHero(user, userHeroId);
					UserHeroVO hvo = MessageFactory.getMessage(UserHeroVO.class);
					hvo.init(hero);
					heros.add(hvo);
				}
			}
			vo.setHeros(heros);
			UserBaseinfo baseinfo = getUserBaseInfo(userId);
			UserBaseinfoVO bvo = MessageFactory.getMessage(UserBaseinfoVO.class);
			bvo.init(baseinfo);
			vo.setBaseInfo(bvo);
		}
		return vo;
	}

	@Override
	public User getUser(int userId) {
		User user = null;
		if(userId > 0){
			user = UserCache.getUser(userId);
			if(user == null){
				user = userDAO.getUserFromCache(userId);
				if(user == null){
					user = userDAO.findUserByUserId(userId);
					if(user == null){
						throw new GameException(GameException.CODE_用户不存在, "");
					}
				}
				UserCache.add(user);
			}
		}
		return user;
	}
	@Override
	public User getUser(int userId, User dbUser) {
		User user = null;
		if(userId > 0){
			user = UserCache.getUser(userId);
			if(user == null){
				user = userDAO.getUserFromCache(userId);
				if(user == null){
					user = dbUser;
				}
				UserCache.add(user);
			}
		}
		return user;
	}



	@Override
	public void checkStamina(User user) {
		UserRule rule = GameCache.getUserRule(user.getLevel());
		if (user.getStamina() < rule.getStamina()) {
			long time = System.currentTimeMillis() - user.getLastRegainStaminaTime().getTime();
			long count = time / (long) SystemConstant.USER_REGAIN_STAMINA_TIME;
			int stamina = 0;
			if (count > 0) {
				if (count > 10000) {
					stamina = rule.getStamina() - user.getStamina();
					user.setLastRegainStaminaTime(new Date());
				} else {
					if (user.getStamina() + (int) count > rule.getStamina()) {
						stamina = rule.getStamina() - user.getStamina();
						user.setLastRegainStaminaTime(new Date());
					} else {
						stamina = (int) count;
						user.setLastRegainStaminaTime(new Date(System.currentTimeMillis() - (time % SystemConstant.USER_REGAIN_STAMINA_TIME)));
					}
				}
				effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_STAMINA, stamina, SystemConstant.LOGGER_APPROACH_自动回体);
			}
		} else {
			user.setLastRegainStaminaTime(new Date());
		}
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_LASTREGAINSTAMINATIME, String.valueOf(user.getLastRegainStaminaTime().getTime()));
//		userDAO.updateUserCache(user.getUserId(), hash);
		updateUser(user, hash, false);
	}
	
	@Override
	public UserBaseinfo getUserBaseInfo(int userId) {
		UserBaseinfo info = userDAO.getUserBaseinfo(userId);
		if (info == null) {
			User user = getUser(userId);
			info = new UserBaseinfo();
			info.setUserId(userId);
			info.setPlayerName(user.getPlayerName());
			info.setLevel(user.getLevel());
			info.setChargeDiamond(user.getChargeDiamond());
			info.setVip(user.getVip());
			info.setFighting(user.getFighting());
			info.setGuildName("");
			UserTeam team = userTeamService.queryUserTeam(userId);
			UserHero userHero = userHeroService.getUserHero(user, team.getHeroList().get(0));
			info.setHeroId(userHero.getHeroId());
			Arena a = arenaDAO.queryMyArena(userId);
			if (a != null) {
				info.setTodayWins(a.getWinCount());
				info.setTodayMaxWins(a.getMaxWinStreak());
				info.setStreakWin(a.getStreakWin());
			}

			userDAO.updateUserBaseinfo(info);
		}
		return info;
	}

	@Override
	public List<UserBaseinfo> getUserBaseInfo(Collection<Integer> userIds) {
		List<UserBaseinfo> baseInfos = userDAO.getUserBaseinfos(userIds);
		if (baseInfos.size() != userIds.size()) {
			out: for (int userId : userIds) {
				for (UserBaseinfo baseInfo : baseInfos) {
					if (userId == baseInfo.getUserId()) {
						continue out;
					}
				}
				baseInfos.add(getUserBaseInfo(userId));
			}
		}
		return baseInfos;
	}

	@Override
	public GainGameAwardVO drawLoginAwards(int userId) {  //TODO 功能未实现
		return null;
	}

	@Override
	public GainGameAwardVO drawVIPGifi(int userId, int vipLevel) { //TODO 功能未实现
		return null;
	}

	@Override
	public void updatePlotStep(int userId, int plotStep) {
		User user = getOnlineUser(userId);
		if (user.getPlotStep() > plotStep) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		user.setPlotStep(plotStep);
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_PLOTSTEP, String.valueOf(plotStep));
		updateUser(user, hash, false);
	}

	@Override
	public void updateGuideStep(int userId, int guideStep) {
		User user = getOnlineUser(userId);
		if (user.getGuideStep() > guideStep) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		user.setGuideStep(guideStep);
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_GUIDESTEP, String.valueOf(guideStep));
		updateUser(user, hash, false);
	}

	@Override
	public void buyGold(int userId){
		User user = getOnlineUser(userId);
		UserStat stat = getUserStat(userId);
		if (stat.getBuyGoldCount() >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BUY_GOLD_NUMBER)) {
			throw new GameException(GameException.CODE_可购买次数不足, "");
		}else{
			byte b = stat.getBuyGoldCount();
			stat.setBuyGoldCount(++b);
			int price = MathUtil.getBuyGoldPrice(b);
			effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, price, SystemConstant.LOGGER_APPROACH_购买金币);
			effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GOLD, SystemConstant.USER_BUY_GOLD_GAIN, SystemConstant.LOGGER_APPROACH_购买金币获得);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserStatTable.BUYGOLDCOUNT, SQLOpt.EQUAL);
//			userStatDAO.updateUserStat(opt, stat);
			userService.updateUserStat(stat, opt);
		}
	}

	@Override
	public void buyStamina(int userId){
		User user = getOnlineUser(userId);
		UserStat stat = getUserStat(userId);
		if (stat.getBuyStaminaCount() > privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BUY_STAMINA_NUMBER)){
			throw new GameException(GameException.CODE_可购买次数不足, "");
		}else{
			byte b = stat.getBuyStaminaCount();
			stat.setBuyStaminaCount(++b);
			int price = MathUtil.getBuyStaminaPrice(b);
			effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, price, SystemConstant.LOGGER_APPROACH_购买体力);
			effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_STAMINA, SystemConstant.USER_BUY_STAMINA_GAIN, SystemConstant.LOGGER_APPROACH_购买体力获得);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(UserStatTable.BUYSTAMINACOUNT, SQLOpt.EQUAL);
//			userStatDAO.updateUserStat(opt, stat);
			userService.updateUserStat(stat, opt);
		}
	}

	@Override
	public GainAwardVO signin(int userId, int day){
		User user = getOnlineUser(userId);
		UserStat stat = getUserStat(userId);
		Calendar c = Calendar.getInstance();
		int today = c.get(Calendar.DAY_OF_MONTH);
		if(stat.getSigninDays().indexOf(day) != -1 || day > 31 || day <= 0 || day > today){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_补签消耗);
		if(day != today){
			if(stat.getFillSignin() >= privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_FILL_SIGNIN_NUMBER)){
				throw new GameException(GameException.CODE_补签次数不足, "");
			}
			UserProp prop = userPropService.getUserPropByPropId(user, SystemConstant.PROP_ID_补签卡);
			if(prop == null || prop.getNum() < 1){
				effects.delItem(SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.USER_SIGNIN_DIAMOND);
			}else{
				effects.delItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, SystemConstant.PROP_ID_补签卡, 1);
			}
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		Signin aw = GameCache.getSignin(day);
		if(aw != null){
			ItemEffects adds = new ItemEffects(SystemConstant.LOGGER_APPROACH_签到获得);
			adds.addItem(aw.getType(), aw.getGoodsId(), aw.getNum(), aw.getLevel());
			code = effectService.validAdds(user, adds);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			SQLOpt opt = new SQLOpt();
			if(day != today){
				stat.setFillSignin(stat.getFillSignin() + 1);
				opt.putFieldOpt(UserStatTable.FILLSIGNIN, SQLOpt.EQUAL);
			}
			stat.getSigninDaysList().add(day);
			opt.putFieldOpt(UserStatTable.SIGNINDAYS, SQLOpt.EQUAL);
			userService.updateUserStat(stat, opt);
			effectService.delIncome(user, effects);
			return effectService.addGainAwardVo(user, effects);
		}else{
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}

	@Override
	public GainAwardVO drawSumSignin(int userId, int sumDay) {  //TODO
		User user = getOnlineUser(userId);
		UserStat stat = getUserStat(userId);

		if (stat.getSigninDaysList().size() < sumDay) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if (stat.getSumSigninDays().indexOf(sumDay) != -1) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		List<SumSignin> goodses = GameCache.getSumSignin(sumDay);
		if (goodses == null) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		int mult = 1;
		int multDay = privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_SIGN_BOX_DOUBLE_DAY);
		if(multDay >= sumDay){
			mult = 2;
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_签到获得);
		effects.addItems(goodses, mult);
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		stat.getSumSigninDaysList().add(sumDay);
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.SUMSIGNINDAYS, SQLOpt.EQUAL);
		userService.updateUserStat(stat, opt);
		return effectService.addGainAwardVo(user, effects);
	}

	@Override
	public void updateFunUnlock(int userId, int funUnlock) {
		User user = getOnlineUser(userId);
		user.setFunUnlock(user.getFunUnlock() | funUnlock);
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_FUNUNLOCK, String.valueOf(user.getFunUnlock()));
//		userDAO.updateUserCache(user.getUserId(), hash);
		updateUser(user, hash, false);
	}



	@Override
	public GainGameAwardVO levelUpFame(int userId) {
		User user = getOnlineUser(userId);
		Fame fame = GameCache.getFame(user.getFame() + 1);
		if (fame == null) {
			throw new GameException(GameException.CODE_参数错误, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_升级名望奖励);
		List<Goods> goodses = GameCache.getFameAward(user.getFame());
		if(goodses != null){
			effects.addItems(goodses, 0);
			int code = effectService.validAdds(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
		}
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_SLATE, 0, fame.getSlate(), SystemConstant.LOGGER_APPROACH_升级消耗);
		user.setFame(user.getFame() + 1);
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_FAME, String.valueOf(user.getFame()));
		updateUser(user, hash, false);
		GainGameAwardVO gainGameAward = effectService.addGainGameAwardVo(user, effects);
		
		FrameLevelUpEvent event = FrameLevelUpEvent.valueOf(user, user.getFame());
		TimerController.submitGameEvent(event);
		return gainGameAward;
	}

	@Override
	public void gainSlate(int userId) {
		User user = userService.getOnlineUser(userId);
		UserStat stat = userService.getUserStat(userId);
		int slate = 0;
		long time = System.currentTimeMillis() - stat.getSlateGainTime().getTime();

		slate = (int) (time / (60 * 60 * 1000));
		slate = slate > 100 ? 100 : slate;

		stat.setSlateGainTime(new Date(System.currentTimeMillis() - time % (60 * 60 * 1000)));

		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_SLATE, slate, SystemConstant.LOGGER_APPROACH_免费领取);

		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.SLATEGAINTIME, SQLOpt.EQUAL);
		
//		userStatDAO.updateUserStat(opt, stat);
		userService.updateUserStat(stat, opt);
	}

	@Override
	public void increTodayEquipLevelUpTimes(int userId, int upLevel) {
		UserStat stat = userService.getUserStat(userId);
		stat.setTodayEquipCountLevel(stat.getTodayEquipCountLevel() + upLevel);
		stat.setEquipCountLevel(stat.getEquipCountLevel() + upLevel);
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.TODAYEQUIPCOUNTLEVEL, SQLOpt.EQUAL);
		opt.putFieldOpt(UserStatTable.EQUIPCOUNTLEVEL, SQLOpt.EQUAL);
		userService.updateUserStat(stat, opt);
	}

	@Override
	public void increTodayHeroLevelUpTimes(int userId, int upLevel) {
		UserStat stat = userService.getUserStat(userId);
		stat.setTodayHeroCountLevel(stat.getTodayHeroCountLevel() + upLevel);
		stat.setHeroCountLevel(stat.getHeroCountLevel() + upLevel);
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.TODAYHEROCOUNTLEVEL, SQLOpt.EQUAL);
		opt.putFieldOpt(UserStatTable.HEROCOUNTLEVEL, SQLOpt.EQUAL);
		userService.updateUserStat(stat, opt);
	}

	/**
	 * 增加累计竞技场挑战次数
	 */
	@Override
	public void increArenaFightCount(int userId, int count) {
		if(count <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserStat stat = userService.getUserStat(userId);
		stat.setArenaFightCount(stat.getArenaFightCount() + count);
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.ARENAFIGHTCOUNT, SQLOpt.EQUAL);
//		userStatDAO.updateUserStat(opt, stat);
		userService.updateUserStat(stat, opt);
	}

	/**
	 * 增加武道大会挑战次数
	 */
	@Override
	public void increMartialwayFightCount(int userId, int count) {
		if(count <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserStat stat = userService.getUserStat(userId);
		stat.setMartialwayFightCount(stat.getMartialwayFightCount() + count);
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.MARTIALWAYFIGHTCOUNT, SQLOpt.EQUAL);
//		userStatDAO.updateUserStat(opt, stat);
		userService.updateUserStat(stat, opt);
	}

	/**
	 * 增加获得道具数量
	 */
	@Override
	public void increAddItemCount(int userId, int count) {
		if(count <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserStat stat = userService.getUserStat(userId);
		stat.setAddItemCount(stat.getAddItemCount() + count);
		SQLOpt opt = new SQLOpt();
		opt.putFieldOpt(UserStatTable.ADDITEMCOUNT, SQLOpt.EQUAL);
//		userStatDAO.updateUserStat(opt, stat);
		userService.updateUserStat(stat, opt);
	}

	@Override
	public void givePlayerName(int userId, String playerName) {
		User user = getOnlineUser(userId);
		if (playerName == null || playerName.length() > 7) {
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(KeyWordsUtil.hasBadWords(playerName)){
			throw new GameException(GameException.CODE_包含敏感词汇, "");
		}
		User tempPlayer = userDAO.findUserByPlayerName(playerName);
		if(tempPlayer != null){
			throw new GameException(GameException.CODE_该名已被使用, "");
		}
		//扣钱
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.USER_CHANGE_NAME_DIAMOND, SystemConstant.LOGGER_APPROACH_改玩家名字);

		user.setPlayerName(playerName);
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_PLAYERNAME, playerName);
//		userDAO.updateUserCache(userId, hash);
		updateUser(user, hash, false);

		// 立刻更新，方便数据库查看用户
		userDAO.updatePlayerName(userId, playerName);

		// 修改工会中的名字
		GuildMember guildMember = guildMemberDAO.queryGuildMember(userId);
		if (guildMember != null) {
			guildMember.setPlayerName(playerName);
			guildMemberDAO.updateGuildMember(guildMember);
		}

		// 修改基本信息中的名字
		UserBaseinfo info = userDAO.getUserBaseinfo(userId);
		if (info != null) {
			info.setPlayerName(playerName);
			userDAO.updateUserBaseinfo(info);
		}

	}

	@Override
	public void increExpPool(int userId, int times) {
		if(times<0 || times >999){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		User user = getOnlineUser(userId);
		//元气石id
		PropEffect needEffect = null;

		List<PropEffect> effects = propService.queryPropEffects();
		for(PropEffect effect : effects){
			if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_增加经验池上限){
				needEffect = effect;
				break;
			}
		}
		if(needEffect == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, 50 * times, SystemConstant.LOGGER_APPROACH_增加经验池上限);
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_ADD_HERO_POOL_EXP_LIMIT, needEffect.getVal() * times, SystemConstant.LOGGER_APPROACH_增加经验池上限);
		
	}

	@Override
	public void increEternalSmelting(int userId, int times) {
		if(times<0 || times >999){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		User user = getOnlineUser(userId);
		//能量石id
		PropEffect needEffect = null;

		List<PropEffect> effects = propService.queryPropEffects();
		for(PropEffect effect : effects){
			if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_增加熔炼池上限){
				needEffect = effect;
				break;
			}
		}
		if(needEffect == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, 50 * times, SystemConstant.LOGGER_APPROACH_增加熔炼池上限);
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_ADD_SMELTING_POOL_EXP_LIMIT, needEffect.getVal() * times, SystemConstant.LOGGER_APPROACH_增加熔炼池上限);
	}

	@Override
	public void onlineReport(int amount, int time) {
		OnlineReportLogger logger = new OnlineReportLogger(amount, time);
		gameLoggerDAO.addOnlineReportLogger(logger);
	}

	@Override
	public User findUserByUsername(String username, int partner) {
		return userDAO.findUserByUsername(username, partner);
	}
	
	public int findUserIdByUsername(String username, int partner) {
		return userDAO.findUserIdByUsername(username, partner);
	}

	@Override
	public void heard(int userId) {
		User user = getUser(userId);
		user.setAccessTime(XyTimeUtil.getNowSecond());
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_ACCESSTIME, String.valueOf(user.getAccessTime()));
//		userDAO.updateUserCache(userId, hash);
		updateUser(user, hash, false);
	}
	
	@Override
	public void recharge(User user, int diamond, int logType){
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, diamond, logType);
		user.setChargeDiamond(user.getChargeDiamond() + diamond);
		Map<String, String> hash = new HashMap<String, String>();
		hash.put(UserTable.J_CHARGEDIAMOND, String.valueOf(user.getChargeDiamond()));
		vipService.updateVip(user, user.getVip());
		updateUser(user, hash, false);
		UserBaseinfo info = getUserBaseInfo(user.getUserId());
		if(info != null){
			info.setVip(user.getVip());
			info.setChargeDiamond(user.getChargeDiamond());
			userDAO.updateUserBaseinfo(info);
		}
	}
	
	@Override
	public int getUserFighting(int userId){
		return userDAO.getFighting(userId);
	}
	
	@Override
	public void reloadUserFightingCache(){
		int size = 200;
		int start = 0;
		int end = start + size;
		List<User> list = userDAO.loadDBFightings(start, end);
		while(!list.isEmpty()){
			for(User user : list){
				System.err.println(user.getLevel());
				userDAO.updateFighting(user.getFighting(), user.getUserId());
			}
			start = end;
			end = start + size;
			list = userDAO.loadDBFightings(start, end);
		}
	}
	
	@Override
	public void reloadUserLevelCache(){
		int size = 200;
		int start = 0;
		int end = start + size;
		List<User> list = userDAO.loadDBLevels(start, end);
		while(!list.isEmpty()){
			for(User user : list){
				userDAO.updateUserLevel(user.getLevel(), user.getUserId());
			}
			start = end;
			end = start + size;
			list = userDAO.loadDBLevels(start, end);
		}
	}

	@Override
	public void validTrialsNumber(User user, UserStat stat, int zoneId, int number){
		int count = 0;
		int amount = 0;
		if(zoneId == SystemConstant.ZONE_ID_BREAD_STORE){
			count = stat.getBreadStoreCount();
			amount = privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_BREAD_STORE_NUMBER);
		}else if(zoneId == SystemConstant.ZONE_ID_GOD_WEALTH){
			count = stat.getGodWealthCount();
			amount = privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_GOD_WEALTH_NUMBER);
		}else if(zoneId == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
			count = stat.getAnimaTempleCount();
			amount = privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_ANIMA_TEMPLE_NUMBER);
		}else{
			throw new GameException(GameException.CODE_参数错误, "");
		}
		if(count + number > amount){
			throw new GameException(GameException.CODE_挑战次数不足, "");
		}
	}
	
	@Override
	public void addTrialsCountNumber(User user, int zoneId, int number){
		UserStat stat = getUserStat(user.getUserId());
		validTrialsNumber(user, stat, zoneId, number);
		updateTrialsCountNumber(stat, zoneId, number);
	}
	private void updateTrialsCountNumber(UserStat stat, int zoneId, int amount){
		SQLOpt opt = new SQLOpt();
		if(zoneId == SystemConstant.ZONE_ID_BREAD_STORE){
			stat.setBreadStoreCount(stat.getBreadStoreCount() + amount);
			opt.putFieldOpt(UserStatTable.BREADSTORECOUNT, SQLOpt.EQUAL);
		}else if(zoneId == SystemConstant.ZONE_ID_GOD_WEALTH){
			stat.setGodWealthCount(stat.getGodWealthCount() + amount);
			opt.putFieldOpt(UserStatTable.GODWEALTHCOUNT, SQLOpt.EQUAL);
		}else if(zoneId == SystemConstant.ZONE_ID_ANIMA_TEMPLE){
			stat.setAnimaTempleCount(stat.getAnimaTempleCount() + amount);
			opt.putFieldOpt(UserStatTable.ANIMATEMPLECOUNT, SQLOpt.EQUAL);
		}
//		userStatDAO.updateUserStat(opt, stat);
		userService.updateUserStat(stat, opt);
	}
	
	@Override
	public void clearCacheUsers(){
		List<Integer> ids = userDAO.queryRepairIds();
		if(!ids.isEmpty()){
			for(Integer userId : ids){
				logout(userId);
			}
		}
	}
	
}