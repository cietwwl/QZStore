package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.CallHero;
import com.ks.db.cfg.CallHeroRule;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroEvo;
import com.ks.db.cfg.HeroEvoMaterial;
import com.ks.db.cfg.HeroRule;
import com.ks.db.cfg.UserRule;
import com.ks.db.model.User;
import com.ks.db.model.UserExplore;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserTeam;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.task.CallHeroEvent;
import com.ks.logic.event.task.HeroLevelUpEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserHeroService;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.hero.EvolutionHeroResultVO;
import com.ks.protocol.vo.hero.HeroOptResultVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.table.UserStatTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;
import com.ks.util.CheckUtil;
import com.ks.util.MathUtil;
import com.ks.util.XyTimeUtil;

public class UserHeroServiceImpl extends BaseService implements UserHeroService {

	/**************************************************** 数据处理 ****************************************************************/
	public void updateHero(UserHero hero){
		userHeroDAO.updateUserHero(hero);
		userHeroDAO.updateUserHeroCache(hero);
		dataService.updateHero(hero.getUserId(), hero);
		
	}
	public void addHero(User user, UserHero hero){
		userHeroDAO.addUserHero(hero);
		userHeroDAO.addUserHeroCache(hero);
		if(user.getHeros() != null){
			user.getHeros().put(hero.getId(), hero);
		}
		dataService.updateHero(hero.getUserId(), hero);
	}
	public void deleteHero(User user, int userHeroId){
		userHeroDAO.deleteUserHeroCache(user.getUserId(), userHeroId);
		userHeroDAO.deleteUserHero(user.getUserId(), userHeroId);
		if(user.getHeros() != null){
			user.getHeros().remove(userHeroId);
		}
	}

	
	@Override
	public Collection<UserHero> initUserHeros(int userId) {
		userHeroDAO.clearUserHeroCache(userId);
		return loadUserHero(userId).values();
	}

	/**
	 * 加载伙伴
	 */
	private Map<Integer, UserHero> loadUserHero(User user){
		Map<Integer, UserHero> map = user.getHeros();
		if(map == null){
			map = loadUserHero(user.getUserId());
			user.setHeros(map);
		}
		return map;
	}
	/**
	 * 加载伙伴
	 */
	private Map<Integer, UserHero> loadUserHero(int userId){
		Map<Integer, UserHero> map = userHeroDAO.queryUserHerosCache(userId, true);
		if(map == null){
			List<UserHero> list  = userHeroDAO.queryUserHeros(userId);
			map = new HashMap<Integer, UserHero>();
			for(UserHero hero : list){
				map.put(hero.getId(), hero);
			}
			userHeroDAO.setUserHeroCache(userId, map);
		}
		return map;
	}
	
	@Override
	public List<UserHero> getUserHeros(User user) {
		List<UserHero> heros = new ArrayList<UserHero>();
		heros.addAll(loadUserHero(user).values());
		return heros;
	}

	@Override
	public UserHero getUserHero(User user, int userHeroId){
		Map<Integer, UserHero> map = loadUserHero(user);
		UserHero target = map.get(userHeroId);
		if(target == null){
			throw new GameException(GameException.CODE_伙伴不存在, "");
		}
		return target;
	}
	
	/****************************************************logic****************************************************************/
	
	@Override
	public void addBackageCapacity(int userId,int type) { 
		User user = userService.getOnlineUser(userId);
		if(type <= 0 && type > 3){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(type == 1 && user.getHeroCapacity() >= SystemConstant.USER_MAX_HERO_CAPACITY){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(type == 2 && user.getEquipmentCapacity() >= SystemConstant.USER_MAX_EQUIPMENT_CAPACITY){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(type == 3 && user.getEternalCapacity() >= SystemConstant.USER_MAX_ETERNAL_CAPACITY){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		effectService.delIncome(user, SystemConstant.ITEM_EFFECT_TYPE_DIAMOND, 0, SystemConstant.USER_HERO_ADD_CAPACITY_PRICE, SystemConstant.LOGGER_APPROACH_扩充背包容量);
		Map<String, String> hash = new HashMap<>();
		if(type == 1){
			user.setHeroCapacity(user.getHeroCapacity() + SystemConstant.USER_HERO_ADD_CAPACITY_NUMBER);
			hash.put(UserTable.J_HEROCAPACITY, String.valueOf(user.getHeroCapacity()));
		}else if(type == 2){
			user.setEquipmentCapacity(user.getEquipmentCapacity() + SystemConstant.USER_HERO_ADD_CAPACITY_NUMBER);
			hash.put(UserTable.J_EQUIPMENTCAPACITY, String.valueOf(user.getEquipmentCapacity()));
		}else if(type == 3){
			user.setEternalCapacity(user.getEternalCapacity() + SystemConstant.USER_HERO_ADD_CAPACITY_NUMBER);
			hash.put(UserTable.J_ETERNALCAPACITY, String.valueOf(user.getEternalCapacity()));
		}
//		userDAO.updateUserCache(user.getUserId(), hash);
		userService.updateUser(user, hash, false);
	}

	@Override
	public void lockedHero(int userId, int userHeroId) {
		User user = userService.getOnlineUser(userId);
		UserHero hero = getUserHero(user, userHeroId);
		hero.setState(hero.getState() | SystemConstant.EXPLORE_STATE_LOCKING);
//		userHeroDAO.updateUserHeroCache(hero);
		userHeroService.updateHero(hero);
	}

	@Override
	public void unLockedHero(int userId, int userHeroId) {
		User user = userService.getOnlineUser(userId);
		UserHero hero = getUserHero(user, userHeroId);
		hero.setState(hero.getState() &~ SystemConstant.EXPLORE_STATE_LOCKING);
//		userHeroDAO.updateUserHeroCache(hero);
		userHeroService.updateHero(hero);
	}

	@Override
	public HeroOptResultVO levelUpHero(int userId, int userHeroId, int type){
		User user = userService.getOnlineUser(userId);
		if(user.getHeroExpPool() <= 0){
			throw new GameException(GameException.CODE_伙伴经验池经验不足, "");
		}
		UserHero userHero = getUserHero(user, userHeroId);
		Hero hero = GameCache.getHero(userHero.getHeroId());
		if(userHero.getLevel() >= hero.getMaxLevel()){
			throw new GameException(GameException.CODE_已达到最高等级, "");
		}else{
			int gold = 0;
			int delExp = 0;
			int addExp = userHero.getExp();
			int countExp = user.getHeroExpPool() + addExp;
			int level = userHero.getLevel();
			int countGold = user.getGold();
			HeroRule rule = GameCache.getHeroRule(level);
			if(countExp >= rule.getNextExp(hero.getQuality())){
				if(type == 2){
					while(countExp >= rule.getNextExp(hero.getQuality())){
						int value = rule.getMoney(hero.getQuality());
						countGold -= value;
						if(countGold > 0){
							level++;
							gold += value;
							countExp -= rule.getNextExp(hero.getQuality());
							delExp += rule.getNextExp(hero.getQuality()) - addExp;
							addExp = 0;
							rule = GameCache.getHeroRule(level);
							if(rule == null || level >= hero.getMaxLevel()){
								break;
							}
						}else{
							break;
						}
					}
					if(level < hero.getMaxLevel() && countGold > 0){
						addExp = countExp;
						delExp += countExp;
					}
				}else{
					level++;
					gold += rule.getMoney(hero.getQuality());
					delExp += rule.getNextExp(hero.getQuality()) - addExp;
					addExp = 0;
				}
			}else{
				addExp = countExp;
				delExp = user.getHeroExpPool();
			}
			userHero.setExp(addExp);
			int count = level - userHero.getLevel();
			if(count > 0){
				userService.increTodayHeroLevelUpTimes(userId, count);
				userHero.setLevel(level);
			}
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_升级消耗);
			if(gold > 0){
				effects.delItem(SystemConstant.ITEM_EFFECT_TYPE_GOLD, 0, gold);
			}
			effects.delItem(SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL, 0, delExp);
			int code = effectService.validDels(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			effectService.delIncome(user, effects);
//			userHeroDAO.updateUserHeroCache(userHero);
			userHeroService.updateHero(userHero);
			HeroOptResultVO result = MessageFactory.getMessage(HeroOptResultVO.class);
			result.setType(1);
			result.setExp(addExp);
			UserHeroVO hvo = MessageFactory.getMessage(UserHeroVO.class);
			hvo.init(userHero);
			result.setHero(hvo);
			//更新战斗力
			fightService.computeFightingEvent(user.getUserId());
			// TODO 记得和原来做整合
			HeroLevelUpEvent heroLevelUpEvent = HeroLevelUpEvent.valueOf(user, userHero.getHeroId(), userHero.getLevel(), count, count);
			TimerController.submitGameEvent(heroLevelUpEvent);
			return result;
		}
	}

	@Override
	public EvolutionHeroResultVO evolutionHero(int userId, int ignore, int userHeroId){
		User user = userService.getOnlineUser(userId);
		UserHero userHero = getUserHero(user, userHeroId);
		HeroEvo evo = GameCache.getHeroEvo(userHero.getHeroId());
		Hero hero = GameCache.getHero(userHero.getHeroId());
		if(evo == null || hero == null){
			throw new GameException(GameException.CODE_系统错误, "");
		}else if(userHero.getLevel() < hero.getMaxLevel()){
			throw new GameException(GameException.CODE_伙伴等级不足, "");
		}
		UserTeam team = userTeamService.queryUserTeam(userId);
		inTeam(userHero, team);
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_进化消耗);
		List<UserHero> heros = getUserHeros(user);
		List<Integer> ids = new ArrayList<>();
		for(HeroEvoMaterial item : evo.getMaterials()){
			if(item.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
				int count = 0;
				Iterator<UserHero> it = heros.iterator();
				while(it.hasNext()){
					UserHero next = it.next();
					if(next.getHeroId() == item.getAssId()){
						if(next.getId() != userHeroId && team.getHeroList().indexOf(next.getId()) == -1){
							effects.delItem(next);
							it.remove();
							count++;
							if(count >= item.getNum()){
								break;
							}
						}
					}
				}
				if(count < item.getNum()){
					throw new GameException(GameException.CODE_材料不足, "");
				}
			}else{
				effects.delItem(item.getType(), item.getAssId(), item.getNum());
			}
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		userHero.setHeroId(evo.getEvoHeroId());
		userHero.setLevel(1);
		userHero.setExp(0);
		userHero.setEleLevel(1);
//		userHeroDAO.updateUserHeroCache(userHero);
		userHeroService.updateHero(userHero);

		EvolutionHeroResultVO vo = MessageFactory.getMessage(EvolutionHeroResultVO.class);
		vo.setRemHeros(ids);
		UserHeroVO uhvo = MessageFactory.getMessage(UserHeroVO.class);
		uhvo.init(userHero);
		vo.setHero(uhvo);
		//更新战斗力
		fightService.computeFightingEvent(user.getUserId());
		return vo;
	}

	@Override
	public List<UserHeroVO> callHero(int userId, int type, int num) {
		if(num != 1 && num != 11){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			User user = userService.getOnlineUser(userId);
			int code = effectService.validSize(user, num, 0, 0, 0);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}else{
				int effectType = 0;
				int value = 0;
				int firstId = 0;
				if(type == SystemConstant.HERO_TYPE_GOLD_CALL){
					effectType = SystemConstant.ITEM_EFFECT_TYPE_GOLD;
					if(num == 11){
						value = SystemConstant.HERO_CALL_TEN_GOLD;
					}else{
						UserStat stat = userService.getUserStat(userId);
						if(stat.getGoldCall() < SystemConstant.HERO_CALL_GOLD_FREE 
								&& XyTimeUtil.getNowSecond() - XyTimeUtil.getTimeOfSecond(stat.getLastGoldCallTime()) >= SystemConstant.HERO_CALL_GOLD_FREE_CD){
							stat.setGoldCall(stat.getGoldCall() + 1);
							stat.setLastGoldCallTime(new Date());
							SQLOpt opt = new SQLOpt();
							opt.putFieldOpt(UserStatTable.GOLDCALL, SQLOpt.EQUAL);
							opt.putFieldOpt(UserStatTable.LASTGOLDCALLTIME, SQLOpt.EQUAL);
							userService.updateUserStat(stat, opt);
							type = SystemConstant.HERO_TYPE_FREE_GOLD_CALL;
						}else{
							value = SystemConstant.HERO_CALL_ONE_GOLD;
						}
					}
				}else if(type == SystemConstant.HERO_TYPE_DIAMOND_CALL){
					effectType = SystemConstant.ITEM_EFFECT_TYPE_DIAMOND;
					if(num == 11){
						value = SystemConstant.HERO_CALL_TEN_DIAMOND;
					}else{
						UserStat stat = userService.getUserStat(userId);
						if(XyTimeUtil.getNowSecond() - XyTimeUtil.getTimeOfSecond(stat.getLastDiamondCallTime()) > SystemConstant.HERO_CALL_DIAMOND_FREE_CD){
							stat.setDiamondCall(1);
							stat.setLastDiamondCallTime(new Date());
							SQLOpt opt = new SQLOpt();
							if(stat.isFirstCallHero()){
								firstId = SystemConstant.HERO_FIRST_DIAMOND_CALL_ID;
								stat.setFirstCallHero(false);
								opt.putFieldOpt(UserStatTable.FIRSTCALLHERO, SQLOpt.EQUAL);
							}
							opt.putFieldOpt(UserStatTable.DIAMONDCALL, SQLOpt.EQUAL);
							opt.putFieldOpt(UserStatTable.LASTDIAMONDCALLTIME, SQLOpt.EQUAL);
							userService.updateUserStat(stat, opt);
							type = SystemConstant.HERO_TYPE_FREE_DIAMOND_CALL;
						}else{
							value = SystemConstant.HERO_CALL_ONE_DIAMOND;
						}
					}
				}else{
					throw new GameException(GameException.CODE_参数错误, "");
				}
				List<CallHeroRule> rules = GameCache.getCallHeroRule(type);
				if(rules == null){
					throw new GameException(GameException.CODE_参数错误, "");
				}else{
					int pribability = 0;
					for(CallHeroRule rule : rules){
						pribability += rule.getRate();
					}
					if(pribability <= 0 && firstId == 0){
						throw new GameException(GameException.CODE_参数错误, "");
					}else if(value > 0){
						effectService.delIncome(user, effectType, 0, value, SystemConstant.LOGGER_APPROACH_召唤消耗);
					}
					List<UserHeroVO> vos = new ArrayList<UserHeroVO>();
					if(firstId > 0){
						createHeroVo(user, vos, firstId);
					}else{
						for(int i = 0; i < num; i++){
							int random = MathUtil.nextInt(pribability);
							for(CallHeroRule rule : rules){
								if(random < rule.getRate()){
									CallHero hero = rule.getHeros().get((int) (Math.random() * rule.getHeros().size()));
									createHeroVo(user, vos, hero.getHeroId());
									break;
								}else{
									random -= rule.getRate();
								}
							}
						}
					}
					//抛出召唤事件
					CallHeroEvent event = CallHeroEvent.valueOf(user, num, type);
					TimerController.submitGameEvent(event);
					return vos;
				}
			}
		}
	}
	
	/**
	 * 获得伙伴vo
	 */
	private void createHeroVo(User user, List<UserHeroVO> vos, int heroId){
		ItemEffect effect = effectService.createEffect(SystemConstant.ITEM_EFFECT_TYPE_HERO, heroId, 1, 1, SystemConstant.LOGGER_APPROACH_召唤获得);
		UserHero userHero = (UserHero) incomeService.addIncome(user, effect).get(0);
		UserHeroVO vo = MessageFactory.getMessage(UserHeroVO.class);
		vo.init(userHero);
		vos.add(vo);
	}

	@Override
	public void sellHero(int userId, List<Integer> sellHeros) { 
		User user = userService.getOnlineUser(userId);
		int gold = 0;
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_出售英雄);
		for (int userHeroId : sellHeros) {
			UserHero uh = getUserHero(user, userHeroId);
			Hero hero = GameCache.getHero(uh.getHeroId());
			gold += hero.getSellPrice();
			effects.delItem(uh);
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GOLD, gold, SystemConstant.LOGGER_APPROACH_出售英雄获得);
	}

//	@Override
//	public List<Integer> gainUserHeroMap(int userId) {
//		return userHeroMapDAO.queryAllHeroMap(userId);
//	}
//
//	@Override
//	public void addUserHeroMap(int userId, int heroId) {
//		UserHeroMap heroMap = userHeroMapDAO.queryUserHeroMap(userId, heroId);
//		if (heroMap == null) {
//			heroMap = new UserHeroMap();
//			heroMap.setUserId(userId);
//			heroMap.setHeroId(heroId);
//			userHeroMapDAO.addUserHeroMap(heroMap);
//		}
//	}

	@Override
	public List<UserExplore> gainUserExplore(int userId) {
		User user = userService.getOnlineUser(userId);
		if (user.getLevel() < 10) {
			throw new GameException(GameException.CODE_等级不足, "");
		}
		List<UserExplore> ues = exploreDAO.queryUserExplores(userId);
		if (ues.size() == 0) {
			for (int i = 0; i < 3; i++) {
				UserExplore ue = new UserExplore();
				ue.setUserId(userId);
				ue.setExploreId(i + 1);
				ue.setEndTime(new Date());
				ue.setState(SystemConstant.EXPLORE_STATE_未开始);

				exploreDAO.addUserExplore(ue);

				ues.add(ue);
			}
		}
		return ues;
	}

	@Override
	public void startExplore(int userId, int exploreId, int exploreType,
			int userHeroId) {
		User user = userService.getOnlineUser(userId);

		if (UserExplore.getExploreLevel(exploreId) > user.getLevel()) {
			throw new GameException(GameException.CODE_等级不足, "");
		}

		UserExplore explore = exploreDAO.queryUserExplore(userId, exploreId);
		if (explore == null) {
			throw new GameException(GameException.CODE_参数错误, "");
		}

		if (explore.getState() != SystemConstant.EXPLORE_STATE_未开始) {
			throw new GameException(GameException.CODE_参数错误, "");
		}

		UserHero hero = userHeroService.getUserHero(user, userHeroId);

		if ((hero.getState() & SystemConstant.EXPLORE_STATE_EXPLORE) != 0) {
			throw new GameException(GameException.CODE_参数错误, "");
		}

		UserTeam team = userTeamService.queryUserTeam(userId);
		if (team.getHeros().indexOf(userHeroId) != -1) {
			throw new GameException(GameException.CODE_参数错误, "");
		}

		hero.setState(hero.getState() | SystemConstant.EXPLORE_STATE_EXPLORE);
//		userHeroDAO.updateUserHeroCache(hero);
		userHeroService.updateHero(hero);

		explore.setUserHeroId(userHeroId);
		explore.setState(SystemConstant.EXPLORE_STATE_已开始);
		explore.setExploreId(exploreId);
		explore.setExploreType(exploreType);
		explore.setEndTime(new Date(System.currentTimeMillis()
				+ UserExplore.getExploreTime(exploreType)));
		exploreDAO.updateUserExplore(explore);

	}

	@Override
	public GainGameAwardVO gainExploreAward(int userId, int exploreId) {   //TODO 此功能前端未实现
//		User user = userService.getOnlineUser(userId);
//		VIPState vipState = GameCache.getVIPState(User.getVIPLevel(user.getChargeDiamond()));
//		UserExplore explore = exploreDAO.queryUserExplore(userId, exploreId);
//		if (explore == null) {
//			throw new GameException(GameException.CODE_参数错误, "");
//		}
//		if (explore.getState() != SystemConstant.EXPLORE_STATE_已开始) {
//			throw new GameException(GameException.CODE_参数错误, "");
//		}
//		if (explore.getEndTime().after(new Date())) {
//			throw new GameException(GameException.CODE_参数错误, "");
//		}
//
//		UserHero userHero = userHeroService.getOnlineUserHero(userId, explore.getUserHeroId());
//		userHero.setState(userHero.getState() &~ SystemConstant.EXPLORE_STATE_EXPLORE);
//		userHeroDAO.updateUserHeroCache(userHero);
//
//		Hero hero = GameCache.getHero(userHero.getHeroId());
//
//		int num = UserExplore.getExploreAwardNum(explore.getExploreType());
//		List<ExploreAward> awards = GameCache.getExploreAward(UserExplore
//				.getExploreArray(hero.getQuality()));
//		List<ExploreAward> vipAwards = GameCache.getExploreAward(vipState
//				.getExploreArray());
//		List<Goods> goodses = new ArrayList<Goods>();
//
//		if (vipAwards != null) {
//			int x = (int) (Math.random() * 3);
//			x = x > num ? num : x;
//			num -= x;
//
//			gainGoods(vipAwards, goodses, x);
//		}
//
//		gainGoods(awards, goodses, num);
//
//		GainGameAwardVO gea = mailService.gainGameAward(user, goodses, SystemConstant.LOGGER_APPROACH_探索获得, "探索获得");
//		explore.setState(SystemConstant.EXPLORE_STATE_未开始);
//		exploreDAO.updateUserExplore(explore);
//
//		return gea;
		return null;
	}
//
//	/**
//	 * 获得物品
//	 * 
//	 * @param awards
//	 *            奖励
//	 * @param goodses
//	 *            物品
//	 * @param num
//	 *            获得个数
//	 */
//	private void gainGoods(List<ExploreAward> awards, List<Goods> goodses, int num) {  
//		for (int i = 0; i < num; i++) {
//			int random = (int) (Math.random() * 10000);
//			int rate = 0;
//			for (ExploreAward award : awards) {
//				rate += award.getRate();
//				if (rate > random) {
//					Goods goods = Goods.createGoods(award.getGoodsId(),
//							award.getType(), award.getNum(), award.getLevel());
//					goodses.add(goods);
//					break;
//				}
//			}
//		}
//	}

	@Override
	public HeroOptResultVO resolveHero(int userId, List<Integer> heros){ 
		if(heros.size() > 10 || CheckUtil.isRepeatlist(heros)){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			User user = userService.getOnlineUser(userId);
			UserTeam team = userTeamService.queryUserTeam(userId);
			List<UserHero> uhs = getUserHeros(user);
			for(UserHero hero : uhs){
				if(heros.contains(hero.getId())){
					inTeam(hero, team);
				}
			}
			UserRule userRule = GameCache.getUserRule(user.getLevel());
			int limit = privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_EXP_POOL_MAX_LIMIT) + userRule.getExpPool() + user.getAddExpPool();
			if(userRule == null || user.getHeroExpPool() >= limit){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			int exp = 0;
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_出售英雄);
			for(Integer id : heros){
				UserHero hero = getUserHero(user, id);
				if(hero != null){
					HeroRule rule = GameCache.getHeroRule(hero.getLevel());
					if(rule != null){
						exp += rule.getFenjieExp();
					}
					Hero config = GameCache.getHero(hero.getHeroId());
					exp += hero.getExp() + config.getGiveExp();
					effects.delItem(hero);
				}
			}
			int code = effectService.validDels(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			effectService.delIncome(user, effects);
			HeroOptResultVO vo = MessageFactory.getMessage(HeroOptResultVO.class);
			int random = (int) (Math.random() * 100);
			if(random < 10){
				exp *= UserHero.getLevelUpVal(3);
				vo.setType(3);
			}else if(random < 30){
				exp *= UserHero.getLevelUpVal(2);
				vo.setType(2);
			}else{
				exp *= UserHero.getLevelUpVal(1);
				vo.setType(1);
			}
			effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL, exp, SystemConstant.LOGGER_APPROACH_分解获得);
			vo.setExp(exp);
			return vo;
		}
	}
	
	/**
	 * 在队伍中
	 */
	public void inTeam(UserHero hero, UserTeam team){
		if(team.getHeroList().indexOf(hero.getId()) != -1){
			throw new GameException(GameException.CODE_参数错误, "");
		}
	}
}
