package com.ks.logic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentProperty;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalProperty;
import com.ks.db.cfg.EternalSkill;
import com.ks.db.cfg.EternalSmelting;
import com.ks.db.cfg.UserRule;
import com.ks.db.log.DiamondLogger;
import com.ks.db.log.EquipmentLogger;
import com.ks.db.log.EternalLogger;
import com.ks.db.log.ExpLogger;
import com.ks.db.log.GameLogger;
import com.ks.db.log.GoldLogger;
import com.ks.db.log.GpLogger;
import com.ks.db.log.HeroExpPoolLogger;
import com.ks.db.log.HeroLogger;
import com.ks.db.log.PropLogger;
import com.ks.db.log.SlateLogger;
import com.ks.db.log.StaminaLogger;
import com.ks.db.model.EquipmentSkill;
import com.ks.db.model.Guild;
import com.ks.db.model.GuildMember;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.GameLoggerEvent;
import com.ks.logic.event.task.AddItemEvent;
import com.ks.logic.event.task.PlayerLevelUpEvent;
import com.ks.logic.event.task.RewardHeroEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserIncomeService;
import com.ks.object.ItemEffect;
import com.ks.table.GuildMemberTable;
import com.ks.table.GuildTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;

/**
 * 用户收益
 *
 */
public class UserIncomeServiceImpl extends BaseService implements UserIncomeService{
	
	@Override  //TODO Add
	public void addIncomes(User user, Collection<ItemEffect> effects){
		for(ItemEffect effect : effects){
			addIncome(user, effect);
		}
	}
	
	@Override
	public List<?> addIncome(User user, ItemEffect effect){
		if(effect.getValue1() > 0){
			String logDec = SystemConstant.getLoggerApproachName(effect.getLogSubType());
			if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
				return addUserHero(user, effect.getId(), effect.getValue1(), effect.getValue2(), effect.getLogSubType(), logDec);
			}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
				return addProp(user, effect.getId(), effect.getValue1(), effect.getLogSubType(), logDec);
			}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
				return addEquipments(user, effect.getId(), effect.getValue1(), effect.getValue2(), effect.getLogSubType(), logDec);
			}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
				return addEternals(user, effect.getId(), effect.getValue1(), effect.getLogSubType(), logDec);
			}else{
				addIncome(user, effect.getType(), effect.getValue1(), effect.getLogSubType(), logDec);
			}
		}
		return new ArrayList<>();
	}
	
	@Override
	public void addIncome(User user, int effectType, int value, int logSubType){
		if(value <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		String logDec = SystemConstant.getLoggerApproachName(logSubType);
		addIncome(user, effectType, value, logSubType, logDec);
	}

	@Override
	public void addIncome(User user, int effectType, int value, int logSubType, String logDec){
		if(value <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_GOLD){
			addGold(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_DIAMOND){
			addDiamond(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_GP){
			addGp(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL){
			addHeroExpPool(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT){
			addEternalSmelting(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_SLATE){
			addSlate(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_EXP){
			addExp(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_STAMINA){
			addStamina(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_ADD_HERO_POOL_EXP_LIMIT){
			addHeroExpPoolLimit(user, value);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_ADD_SMELTING_POOL_EXP_LIMIT){
			addSmeltingPoolLimit(user, value);
		}else{
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
	
	@Override  //TODO del
	public void delIncomes(User user, Collection<ItemEffect> effects){
		for(ItemEffect effect : effects){
			delIncome(user, effect);
		}
	}

	@Override
	public void delIncome(User user, ItemEffect effect){
		String logDec = SystemConstant.getLoggerApproachName(effect.getLogSubType());
		if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
			delUserHero(user, effect.getId(), effect.getRemoveIds(), effect.getLogSubType(), logDec);
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
			delEquipment(user, effect.getId(), effect.getRemoveIds(), effect.getLogSubType(), logDec);
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
			delEternal(user, effect.getId(), effect.getRemoveIds(), effect.getLogSubType(), logDec);
		}else if(effect.getValue1() <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
			delProp(user, effect.getId(), effect.getValue1(), effect.getLogSubType(), logDec);
		}else{
			delIncome(user, effect.getType(), effect.getValue1(), effect.getLogSubType(), logDec);
		}
	} 
	
	@Override
	public void delIncome(User user, int effectType, int value, int logSubType){
		if(value <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		String logDec = SystemConstant.getLoggerApproachName(logSubType);
		delIncome(user, effectType, value, logSubType, logDec);
	}
	
	@Override
	public void delIncome(User user, int effectType, int value, int logSubType, String logDec){
		if(value <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_GOLD){
			delGold(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_DIAMOND){
			delDiamond(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_GP){
			delGp(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL){
			delHeroExpPool(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT){
			delEternalSmelting(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_SLATE){
			delSlate(user, value, logSubType, logDec);
		}else if(effectType == SystemConstant.ITEM_EFFECT_TYPE_STAMINA){
			delStamina(user, value, logSubType, logDec);
		}else{
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
	
	
	//TODO 添加日志
	/************************************ 添加日志 *****************************************************/
	
	@Override
	public void addLogger(int logType, int logSubType, int uid, int originalAmount, int amount, int surplusAmount, int assId, String logDec){
		GameLogger logger = null;
		if(logType == SystemConstant.LOGGER_TYPE_HERO){
			logger = new HeroLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_DIAMOND){
			logger = new DiamondLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_GOLD){
			logger = new GoldLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_GP){
			logger = new GpLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_EXP){
			logger = new ExpLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_PROP){
			logger = new PropLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_STAMINA){
			logger = new StaminaLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_HERO_EXP_POOL){
			logger = new HeroExpPoolLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_EQUIPMENT){
			logger = new EquipmentLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_ETERNAL){
			logger = new EternalLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}else if(logType == SystemConstant.LOGGER_TYPE_SLATE){
			logger = new SlateLogger(logType, logSubType, uid, originalAmount, amount, surplusAmount, assId, logDec);
		}
		if(logger != null){
			GameLoggerEvent event = new GameLoggerEvent(logger);
			TimerController.submitGameEvent(event);
		}
	}
	
	public void initSize(User user, int type){
		if(type == SystemConstant.ITEM_EFFECT_TYPE_HERO){
			if(user.getHeroSize() == 0){
				if(user.getHeros() != null){
					user.setHeroSize(user.getHeros().size());
				}else{
					user.setHeroSize(userHeroDAO.getUserHeroSize(user.getUserId()));
				}
			}
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
			if(user.getEternalSize() == 0){
				if(user.getEternals() != null){
					user.setEternalSize(user.getEternals().size());
				}else{
					user.setEternalSize(userEternalDAO.getEternalSize(user.getUserId()));
				}
			}
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
			if(user.getEquipmentSize() == 0){
				if(user.getEquips() != null){
					user.setEquipmentSize(user.getEquips().size());
				}else{
					user.setEquipmentSize(userEquipmentDAO.getEquipmentSize(user.getUserId()));
				}
			}
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_PROP){
			if(user.getPropSize() == 0){
				if(user.getProps() != null){
					user.setPropSize(user.getProps().size());
				}else{
					user.setPropSize(userPropDAO.getPropSize(user.getUserId()));
				}
			}
		}
	}
	
	//TODO 货币
	/**************************************** 货币  ***************************************************/
	
	/**
	 * 添加钻石
	 */
	private void addDiamond(User user, int amount, int logSubType, String logDec){
		updateDiamond(user, amount, logSubType, logDec);
	}

	/**
	 * 扣除钻石
	 */
	private void delDiamond(User user, int amount, int logSubType, String logDec){
		if(user.getDiamond() < amount){
			throw new GameException(GameException.CODE_钻石不足, "");
		}
		updateDiamond(user, -amount, logSubType, logDec);
	}

	/**
	 * 更新钻石
	 */
	private void updateDiamond(User user, int amount, int logSubType, String logDec){
		int oamount = user.getDiamond();
		user.setDiamond(getValue(user.getDiamond(), amount));
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_DIAMOND, String.valueOf(user.getDiamond()));
		userService.updateUser(user, hash, false);
		int samount = user.getDiamond();
		addLogger(SystemConstant.LOGGER_TYPE_DIAMOND, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
	}
	
	/**
	 * 添加金币
	 */
	private void addGold(User user, int amount, int logSubType, String logDec){
		updateGold(user, amount, logSubType, logDec);
	}

	/**
	 * 扣除金币
	 */
	private void delGold(User user, int amount, int logSubType, String logDec){
		if(user.getGold() < amount){
			throw new GameException(GameException.CODE_参数错误, "not gold num");
		}
		updateGold(user, -amount, logSubType, logDec);
	}

	/**
	 * 更新钻石
	 */
	private void updateGold(User user, int amount, int logSubType, String logDec){
		int oamount = user.getGold();
		user.setGold(getValue(user.getGold(), amount));
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_GOLD, String.valueOf(user.getGold()));
		userService.updateUser(user, hash, false);
		int samount = user.getGold();
		addLogger(SystemConstant.LOGGER_TYPE_GOLD, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
	}

	/**
	 * 添加灵气/神之召唤点
	 */
	private void addGp(User user, int amount, int logSubType, String logDec){
		updateGp(user, amount, logSubType, logDec);
		//公会成员
		GuildMember gm = guildMemberDAO.queryGuildMember(user.getUserId());
		if (gm != null) {
			int value = amount * 50 / 100;
			
			Guild guild = new Guild();
			guild.setGuildId(gm.getGuildId());
			guild.setExp(value);
			guild.setSkillPoint(value / 2);
			SQLOpt opt = new SQLOpt();
			opt.putFieldOpt(GuildTable.EXP, SQLOpt.PULS);
			opt.putFieldOpt(GuildTable.SKILLPOINT, SQLOpt.PULS);
			guildDAO.updateGuild(opt, guild);

			gm.setTodayDevote(value);
			gm.setDevote(value);
			SQLOpt gopt = new SQLOpt();
			gopt.putFieldOpt(GuildMemberTable.TODAYDEVOTE, SQLOpt.PULS);
			gopt.putFieldOpt(GuildMemberTable.DEVOTE, SQLOpt.PULS);
			guildMemberDAO.updateGuildMemberByOpt(gopt, gm);
		}
	}

	/**
	 * 扣除灵气
	 */
	private void delGp(User user, int amount, int logSubType, String logDec) {
		if(user.getGp() < amount){
			throw new GameException(GameException.CODE_GP不足, "");
		}
		updateGp(user, -amount, logSubType, logDec);
	}

	/**
	 * 更新灵气
	 */
	private void updateGp(User user, int amount, int logSubType, String logDec) {
		int oamount = user.getGp();
		user.setGp(getValue(user.getGp(), amount));
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_GP, String.valueOf(user.getGp()));
		userService.updateUser(user, hash, false);
		int samount = user.getGp();
		addLogger(SystemConstant.LOGGER_TYPE_GP, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
	}

	/**
	 * 添加经验
	 */
	private void addExp(User user, int amount, int logSubType, String logDec){
		if(user.getLevel() < SystemConstant.USER_MAX_LEVEL){
			int oamount = user.getExp();
			int count = getValue(user.getExp(), amount);
			int level = user.getLevel();
			UserRule rule = GameCache.getUserRule(level);
			while(rule != null && count >= rule.getNextExp() && level < SystemConstant.USER_MAX_LEVEL){
				level ++;
				count -= rule.getNextExp();
				rule = GameCache.getUserRule(level);
				if(rule == null || level >= SystemConstant.USER_MAX_LEVEL){
					count = 0;
					break;
				}
			}
			Map<String, String> hash = new HashMap<>();
			user.setExp(count);
			hash.put(UserTable.J_EXP, String.valueOf(user.getExp()));
			int levelUpCount = 0;
			if(level != user.getLevel()){
				levelUpCount = level - user.getLevel();
				user.setLevel(level);
				hash.put(UserTable.J_LEVEL, String.valueOf(user.getLevel()));
				userDAO.updateUserLevel(user.getLevel(), user.getUserId());
				addStamina(user, levelUpCount * SystemConstant.USER_UP_LEVEL_GAIN_STAMINA, SystemConstant.LOGGER_APPROACH_玩家升级, "玩家升级");
				PlayerLevelUpEvent eventLevelUp = PlayerLevelUpEvent.valueOf(user, user.getLevel());
				TimerController.submitGameEvent(eventLevelUp);
				logDec += " : 升级[" + levelUpCount + "]";
				fightService.computeFightingEvent(user.getUserId());
			}
			int samount = user.getExp();
			userService.updateUser(user, hash, false);
			addLogger(SystemConstant.LOGGER_TYPE_EXP, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
		}
	}
	
	/**
	 * 添加体力
	 */
	private void addStamina(User user, int amount, int logSubType, String logDec){
		updateStamina(user, amount, logSubType, logDec);
	}

	/**
	 * 扣除体力
	 */
	private void delStamina(User user, int amount, int logSubType, String logDec){
		if(user.getStamina() < amount){
			throw new GameException(GameException.CODE_体力不足, "");
		}
		updateStamina(user, -amount, logSubType, logDec);
	}

	/**
	 * 更新体力
	 */
	private void updateStamina(User user, int amount, int logSubType, String logDec){
		int oamount = user.getStamina();
		user.setStamina(getValue(user.getStamina(), amount));
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_STAMINA, String.valueOf(user.getStamina()));
		userService.updateUser(user, hash, false);
		int samount = user.getStamina();
		addLogger(SystemConstant.LOGGER_TYPE_STAMINA, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
	}
	
	/**
	 * 校验伙伴经验池值
	 */
	private void addHeroExpPool(User user, int amount, int logSubType, String logDec){
		updateHeroExpPool(user, amount, logSubType, logDec);
	}

	/**
	 * 扣除伙伴经验池值
	 */
	private void delHeroExpPool(User user, int amount, int logSubType, String logDec){
		if(user.getHeroExpPool() < amount){
			throw new GameException(GameException.CODE_参数错误, "");   //经验池不足
		}
		updateHeroExpPool(user, -amount, logSubType, logDec);
	}

	/**
	 * 更新英雄经验池
	 */
	private void updateHeroExpPool(User user, int amount, int logSubType, String logDec){
		int oamount = user.getHeroExpPool();
		user.setHeroExpPool(getValue(user.getHeroExpPool(), amount));
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_HEROEXPPOOL, String.valueOf(user.getHeroExpPool()));
		userService.updateUser(user, hash, false);
		int samount = user.getHeroExpPool();
		addLogger(SystemConstant.LOGGER_TYPE_HERO_EXP_POOL, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
	}
	
	/**
	 * 增加伙伴经验池上限
	 */
	private void addHeroExpPoolLimit(User user, int amount){
		Map<String,String> hash = new HashMap<>();
		user.setAddExpPool(user.getAddExpPool() + amount);
		hash.put(UserTable.J_ADDEXPPOOL, String.valueOf(user.getAddExpPool()));
		userService.updateUser(user, hash, false);
	}
	
	/**
	 * 添加熔炼点
	 */
	private void addEternalSmelting(User user, int amount, int logSubType, String logDec){
		updateEternalSmelting(user, null, amount, logSubType, logDec);
	}
	
	/**
	 * 扣除熔炼点
	 */
	private void delEternalSmelting(User user, int amount, int logSubType, String logDec){
		EternalSmelting smelting = userEternalService.gainEternalSmelting(user.getUserId()).get(0);
		if(smelting.getVal() < amount){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		updateEternalSmelting(user, smelting, -amount, logSubType, logDec);
	}

	/**
	 * 更新熔炼点
	 */
	private void updateEternalSmelting(User user, EternalSmelting smelting, int amount, int logSubType, String logDec){
		if(smelting == null){
			smelting = userEternalService.gainEternalSmelting(user.getUserId()).get(0);
		}
		smelting.setVal(getValue(smelting.getVal(), amount));
		userPropDAO.updateEternalSmelting(smelting);
	}
	
	/**
	 * 添加武魂熔炼池上限
	 */
	private void addSmeltingPoolLimit(User user, int amount){
		EternalSmelting es = userPropDAO.queryEternalSmelting(user.getUserId(), 1);
		es.setAddEternalVal(es.getAddEternalVal() + amount);
		userPropDAO.updateEternalSmelting(es);
	}
	
	/**
	 * 添加上古石板
	 */
	private void addSlate(User user, int amount, int logSubType, String logDec){
		updateSlate(user, amount, logSubType, logDec);
	}
	
	/**
	 * 扣除上古石板
	 */
	private void delSlate(User user, int amount, int logSubType, String logDec){
		if(user.getSlate() < amount){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		updateSlate(user, -amount, logSubType, logDec);
	}
	
	/**
	 * 更新上古石板
	 */
	private void updateSlate(User user, int amount, int logSubType, String logDec){
		int oamount = user.getSlate();
		user.setSlate(getValue(user.getSlate(), amount));
		Map<String, String> hash = new HashMap<>();
		hash.put(UserTable.J_SLATE, String.valueOf(user.getSlate()));
		userService.updateUser(user, hash, false);
		int samount = user.getSlate();
		addLogger(SystemConstant.LOGGER_TYPE_SLATE, logSubType, user.getUserId(), oamount, amount, samount, 0, logDec);
	}
	
	private int getValue(int oldValue, int addValue){
		long value = (long)oldValue + (long)addValue;
		if(value > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if(value < 0){
			return 0;
		}
		return (int) value;
	}
	
	/**
	 * 区间随机数
	 * @param start
	 * @param end
	 * @return
	 */
	private double scopeDouble(double start, double end){
	     BigDecimal rateDecimal = new BigDecimal(Math.random() * (end - start) + start);
	     BigDecimal  number = rateDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return Double.parseDouble(number.toString());
	}
	
	
	/************************************* 伙伴 ************************************************/  //TODO 伙伴
	
	/**
	 * 添加伙伴/英雄
	 */
	private List<UserHero> addUserHero(User user, int heroId, int amount, int level, int logSubType, String logDec){
		int oamount = user.getHeroSize();
		List<UserHero> list = new ArrayList<>();
		level = level <= 0 ? 1 : level;
		String keyIds = "";
		for(int i = 0; i < amount; i++){
			UserHero userHero = new UserHero();
			userHero.setEleLevel(1);
			userHero.setLevel(level);
			userHero.setUserId(user.getUserId());
			userHero.setHeroId(heroId);
			userHero.setCreateTime(new Date());
			userHero.setUpdateTime(new Date());
			keyIds += userHero.getId() + ",";
			list.add(userHero);
			userHeroService.addHero(user, userHero);
		}
		user.setHeroSize(user.getHeroSize() + amount);
		keyIds = keyIds.substring(0, keyIds.length() - 1);
		addLogger(SystemConstant.LOGGER_TYPE_HERO, logSubType, user.getUserId(), oamount, 1, user.getHeroSize(), heroId, logDec + " : ids[" + keyIds + "] : cfgIds [" + heroId +  "]"); 
//		UserHeroMap heroMap = userHeroMapDAO.queryUserHeroMap(user.getUserId(), heroId);
//		if (heroMap == null) {
//			heroMap = new UserHeroMap();
//			heroMap.setUserId(user.getUserId());
//			heroMap.setHeroId(heroId);
//			userHeroMapDAO.addUserHeroMap(heroMap);
//		}
		//英雄获取事件
		RewardHeroEvent rewardHeroEvent = RewardHeroEvent.valueOf(user, heroId);
		TimerController.submitGameEvent(rewardHeroEvent);
		return list;
	}
	
	/**
	 * 扣除伙伴
	 */
	private void delUserHero(User user, int heroId, List<Integer> ids, int logSubType, String logDec){
		initSize(user, SystemConstant.ITEM_EFFECT_TYPE_HERO);
		int oamount = user.getHeroSize();
		String keyIds = "";
		for(Integer userHeroId : ids){
			userHeroService.deleteHero(user, userHeroId);
			keyIds += userHeroId + ",";
		}
		keyIds = keyIds.substring(0, keyIds.length() - 1);
		user.setHeroSize(user.getHeroSize() - ids.size());
		dataService.deleteHeros(user.getUserId(), ids);
		addLogger(SystemConstant.LOGGER_TYPE_HERO, logSubType, user.getUserId(), oamount, -ids.size(), user.getHeroSize(), heroId, logDec + " : ids[" + keyIds + "] : cfgIds[" + heroId + "]"); 
	}

	/************************************* 装备 ************************************************/  //TODO 装备

	/**
	 * 添加装备
	 */
	private List<UserEquipment> addEquipments(User user, int eId, int amount, int level, int logSubType, String logDec){ 
		int oamount = user.getEquipmentSize();
		List<UserEquipment> list = new ArrayList<>();
		Equipment econfig = GameCache.getEquipment(eId);
		Random r = new Random();
		String keyIds = "";
		for(int i = 0; i < amount; i++){
			UserEquipment eq = new UserEquipment();
			eq.setUserId(user.getUserId());
			eq.setEquipmentId(eId);
			eq.setLevel(level);
			eq.setCreateTime(new Date());
			eq.setUpdateTime(new Date());
			eq.setSkillList(getEquipmentSkills(econfig));
			int random = 30; 
			if(econfig.getRarity() != SystemConstant.EQUIP_RARITY_稀有){
				if(r.nextBoolean()){   
					random = r.nextInt(31);
				}else{
					random = -r.nextInt(31);
				}
			}
		    eq.setAddAtk(random / 100d * 10000);
			list.add(eq);
			keyIds += eq.getUserEquipmentId() + ",";
		}
		userEquipmentService.updateUserEquipments(user, list, true);
		keyIds = keyIds.substring(0, keyIds.length() - 1);
		user.setEquipmentSize(user.getEquipmentSize() + amount);
		
		addLogger(SystemConstant.LOGGER_TYPE_EQUIPMENT, logSubType, user.getUserId(), oamount, amount, user.getEquipmentSize(), eId, logDec +" : ids[" + keyIds + "] : cfgIds[" + eId + "]"); 
		return list;
	}

	/**
	 * 获取装备技能
	 */
	private List<EquipmentSkill> getEquipmentSkills(Equipment econfig){
		List<EquipmentSkill> skills=new ArrayList<EquipmentSkill>();
		List<EquipmentProperty> propertys = GameCache.getEquipmentProperty(econfig.getQuality());
		List<EquipmentProperty> newPropertys = new ArrayList<EquipmentProperty>();
		double probability = 0;
		for(EquipmentProperty property : propertys){
			if((econfig.getType() == 1 && property.getSkillType() == SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_增加攻击力)
					|| (econfig.getType() == 2 && property.getSkillType() == SystemConstant.EQUIPMENT_PROPERTY_SKILLTYPE_增加血上限)){
				continue;
			}
			newPropertys.add(property);
			probability += property.getSkillRate();
		}
		if(econfig.getRarity() == SystemConstant.EQUIP_RARITY_稀有){
			if(econfig.getQuality() < 4){
				addEquipmentSkill(1, probability, newPropertys, skills);
			}else if(econfig.getQuality() > 4){
				addEquipmentSkill(3, probability, newPropertys, skills);
			}else if(econfig.getQuality() == 4){
				addEquipmentSkill(2, probability, newPropertys, skills);
			}
		}else{
			if(econfig.getQuality() == 4){
				addEquipmentSkill(1, probability, newPropertys, skills);	
			}else if(econfig.getQuality() > 4){
				addEquipmentSkill(2, probability, newPropertys, skills);
			}
		}
		return skills;
	}
	
	/**
	 * 添加装备技能
	 */
	private void addEquipmentSkill(int size, double probability, List<EquipmentProperty> newPropertys, List<EquipmentSkill> skills){
		for(int i = 0; i < size; i++){
			double random = Math.random() * probability;
			Iterator<EquipmentProperty> it = newPropertys.iterator();
			while(it.hasNext()){
				EquipmentProperty property = it.next();
				if(random < property.getSkillRate()){
					EquipmentSkill es = new EquipmentSkill();
					es.setEquipmentSkillId(property.getSkillType());
					es.setSkillValue(scopeDouble(property.getStartNum(), property.getEndNum()));
					skills.add(es);
					probability -= property.getSkillRate();
					it.remove();
					break;
				}else{
					random -= property.getSkillRate();
				}
			}
		}
	}
	
	private void delEquipment(User user, int equipId, List<Integer> ids, int logSubType, String logDec){
		initSize(user, SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT);
		int oamount = user.getEquipmentSize();
		String keyIds = "";
		for(Integer userEquipId : ids){
			userEquipmentService.deleteEquip(user, userEquipId);
			keyIds += userEquipId + ",";
		}
		keyIds = keyIds.substring(0, keyIds.length() - 1);
		user.setEquipmentSize(user.getEquipmentSize() - ids.size());
		dataService.deleteEquips(user.getUserId(), ids);
		addLogger(SystemConstant.LOGGER_TYPE_EQUIPMENT, logSubType, user.getUserId(), oamount, -ids.size(), user.getEquipmentSize(),  equipId, logDec + " : ids[" + keyIds + "] : cfgIds[" + equipId + "]");  
	}
	

	/************************************* 武魂 ************************************************/  //TODO 武魂
	
	/**
	 * 添加武魂
	 */
	private List<UserEternal> addEternals(User user, int eId, int amount, int logSubType, String logDec){
		int oamount = user.getEternalSize();
		List<UserEternal> list = new ArrayList<UserEternal>();
		Eternal econfig = GameCache.getEternal(eId);
		String keyIds = "";
		for(int i = 0; i < amount; i++){
			UserEternal ue = UserEternal.createUserEternal(user.getUserId(), eId);
			ue.setPropertySkillList(getEternalSkills(econfig));
			list.add(ue);
		}
		user.setEternalSize(user.getEternalSize() + amount);
		userEternalService.updateUserEternals(user, list, true);
		int samount = user.getEternalSize();
		addLogger(SystemConstant.LOGGER_TYPE_ETERNAL, logSubType, user.getUserId(), oamount, amount, samount, eId, logDec + " : ids[" + keyIds + "] : cfgIds[" + eId + "]"); 
		return list;
	}
	
	/**
	 * 获取武魂技能
	 */
	private List<EternalSkill> getEternalSkills(Eternal econfig){
		List<EternalProperty> epBsis = GameCache.getetErnalBsisProperty(econfig.getQuality());
		double bsisProbability = getEternalSkillRete(epBsis);
		List<EternalProperty> epAppends = GameCache.getetErnalAppendsProperty(econfig.getQuality());
		double appendProbability = getEternalSkillRete(epAppends);
		List<EternalSkill> skills=new ArrayList<EternalSkill>();
		if(econfig.getQuality() < 4){
			addEternalSkills(epBsis, skills, bsisProbability);
			addEternalSkills(epAppends, skills, appendProbability);
		}else{
			for(int i = 0; i < 2; i++){
				addEternalSkills(epBsis, skills, bsisProbability);
				addEternalSkills(epAppends, skills, appendProbability);
			}
		}
		return skills;
	}
	
	/**
	 * 获取武魂技能概率
	 */
	private double getEternalSkillRete(List<EternalProperty> list){
		double probability = 0;
		for(EternalProperty property : list){
			probability += property.getSkillRate();
		}
		return probability;
	}
	
	/**
	 * 添加武魂技能到skills
	 */
	private void addEternalSkills(List<EternalProperty> list, List<EternalSkill> skills, double probability){
		double random = Math.random() * probability;
		for(EternalProperty property : list){
			if(random < property.getSkillRate()){
				if(property.getSkillType() == SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加攻击方向){
					String[] atkMode = property.getAtkMode().split("_");
					int size = property.getStartNum() == 2 ? 2 : 1;
					List<Integer> atks = new ArrayList<Integer>();
					for(int i = 0; i < size; i++){
						if(atkMode.length > i){
							int atkRandom = (int)(Math.random() * atkMode.length);
							while(atks.contains(atkRandom)){
								atkRandom = (int)(Math.random() * atkMode.length);
							}
							EternalSkill es = new EternalSkill();
							int skillType = Integer.parseInt(atkMode[atkRandom]);
							if(skillType == SystemConstant.FIGHT_ATK_MODE_DIR_右){
								es.setEternalSkillId(SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加右方攻击方向);
							}else if(skillType == SystemConstant.FIGHT_ATK_MODE_DIR_右上){
								es.setEternalSkillId(SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加右上方攻击方向);
							}else if(skillType == SystemConstant.FIGHT_ATK_MODE_DIR_右下){
								es.setEternalSkillId(SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加右下方攻击方向);
							}else if(skillType == SystemConstant.FIGHT_ATK_MODE_DIR_左){
								es.setEternalSkillId(SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左方攻击方向);
							}else if(skillType == SystemConstant.FIGHT_ATK_MODE_DIR_左上){
								es.setEternalSkillId(SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左上方攻击方向);
							}else if(skillType == SystemConstant.FIGHT_ATK_MODE_DIR_左下){
								es.setEternalSkillId(SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加左下方攻击方向);
							}
							es.setSkillValue(1);
							skills.add(es);
							atks.add(atkRandom);
							if(i >= size - 1){
								break;
							}
						}
					}
				}else{
					EternalSkill es = new EternalSkill();
					es.setEternalSkillId(property.getSkillType());
					if(property.getSkillType() == SystemConstant.ETERNAL_PROPERTY_EFFECT_TYPE_增加移动范围){
						es.setSkillValue(property.getStartNum());
					}else{
						es.setSkillValue(scopeDouble(property.getStartNum(), property.getEndNum()));
					}
					skills.add(es);
				}
				break;
			}else{
				random -= property.getSkillRate();
			}
		}
	}
	
	private void delEternal(User user, int eternalId, List<Integer> ids, int logSubType, String logDec){
		initSize(user, SystemConstant.ITEM_EFFECT_TYPE_ETERNAL);
		int oamount = user.getEternalSize();
		String keyIds = "";
		for(Integer userEternalId : ids){
			userEternalService.deleteUserEternal(user, userEternalId);
			keyIds += userEternalId + ",";
		}
		keyIds = keyIds.substring(0, keyIds.length() - 1);
		user.setEternalSize(user.getEternalSize() - ids.size());
		int samount = user.getEternalSize();
		dataService.deleteEternals(user.getUserId(), ids);
		addLogger(SystemConstant.LOGGER_TYPE_ETERNAL, logSubType, user.getUserId(), oamount, -ids.size(), samount, eternalId, logDec + " : ids["+ keyIds + "] : cfgIds[" + eternalId + "]"); 
	}

	/************************************* 道具 ************************************************/ //TODO 道具
	
	/**
	 * 添加道具
	 */
	private List<UserProp> addProp(User user,int propId, int amount, int logSubType, String logDec){
		List<UserProp> list = new ArrayList<>();
		UserProp prop = userPropService.getUserPropByPropId(user, propId);
		int type = 0;
		if(prop == null){
			prop = userPropService.popEmptyUserProp(user);
			prop.setPropId(propId);
			user.setPropSize(user.getPropSize() + 1);
			type = 1;
		}
		int oamount = prop.getNum();
		prop.setNum(getValue(prop.getNum(), amount));
		userPropService.updateProp(user, prop, type);
		list.add(prop);
		int samount = prop.getNum();
		addLogger(SystemConstant.LOGGER_TYPE_PROP, logSubType, user.getUserId(), oamount, amount, samount, propId, logDec);
		
		//增加累计获得道具数量
		userService.increAddItemCount(user.getUserId(), amount);
		//和原来事件做整合
		AddItemEvent addItemEvent = AddItemEvent.valueOf(user, propId, amount);
		TimerController.submitGameEvent(addItemEvent);
		return list;
	}
	
	private UserProp delProp(User user, int propId, int amount, int logSubType, String logDec){
		initSize(user, SystemConstant.ITEM_EFFECT_TYPE_PROP);
		UserProp prop = userPropService.getUserPropByPropId(user, propId);
		int oamount = prop.getNum();
		prop.setNum(prop.getNum() - amount);
		userPropService.updateProp(user, prop, 0);
		if(prop.getNum() <= 0){
			user.setPropSize(user.getPropSize() - 1);
		}
		int samount = prop.getNum();
		addLogger(SystemConstant.LOGGER_TYPE_PROP, logSubType, user.getUserId(), oamount, -amount, samount, propId, logDec);
		return prop;
	}
}
