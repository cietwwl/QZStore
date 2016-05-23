package com.ks.logic.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentUp;
import com.ks.db.cfg.Hero;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserHero;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.task.LevelUpEquipEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserEquipmentService;
import com.ks.object.ItemEffects;
import com.ks.timer.TimerController;
import com.ks.util.CheckUtil;

public class UserEquipmentServiceImpl extends BaseService implements UserEquipmentService {
	/**************************************************** 数据处理 ****************************************************************/

	@Override
	public void deleteEquip(User user, int userEquipId) {
		userEquipmentDAO.deleteUserEquipment(user.getUserId(), userEquipId);
		userEquipmentDAO.deleteUserEquipmentCache(user.getUserId(), userEquipId);
		if(user.getEquips() != null){
			user.getEquips().remove(userEquipId);
		}
	}
	
	@Override
	public void updateUserEquipments(User user, List<UserEquipment> list, boolean updatedb){
		if(!list.isEmpty()){
			int userId = list.get(0).getUserId();
			for(UserEquipment equip : list){
				if(equip.getUserEquipmentId() == 0){
					userEquipmentDAO.addUserEquipment(equip);
					userEquipmentDAO.addUserEquipmetCache(equip);
					if(user.getEquips() != null){
						user.getEquips().put(equip.getUserEquipmentId(), equip);
					}
				}else{
					userEquipmentDAO.updateUserEquipment(equip);
					userEquipmentDAO.updateUserEquipmentCache(equip);
				}
			}
			dataService.updateEquips(userId, list);
		}
	}
	@Override
	public void updateUserEquipment(User user, UserEquipment equip, boolean updatedb){
		int userId = equip.getUserId();
		if(equip.getUserEquipmentId() == 0){
			userEquipmentDAO.addUserEquipment(equip);
			userEquipmentDAO.addUserEquipmetCache(equip);
			if(user.getEquips() != null){
				user.getEquips().put(equip.getUserEquipmentId(), equip);
			}
		}else{
			userEquipmentDAO.updateUserEquipment(equip);
			userEquipmentDAO.updateUserEquipmentCache(equip);
		}
		dataService.updateEquip(userId, equip);
	}
	/**
	 * 加载装备
	 */
	private Map<Integer, UserEquipment> loadUserEquipment(User user){
		Map<Integer, UserEquipment> map = user.getEquips();
		if(map == null){
			map = loadUserEquipment(user.getUserId());
			user.setEquips(map);
		}
		return map;
	}
	/**
	 * 加载装备
	 */
	private Map<Integer, UserEquipment> loadUserEquipment(int userId){
		Map<Integer, UserEquipment> map = userEquipmentDAO.queryUserEquipmentCache(userId, true);
		if(map == null){
			List<UserEquipment> equips = userEquipmentDAO.queryAllUserEquipment(userId);
			map = new HashMap<Integer, UserEquipment>();
			for(UserEquipment equip : equips){
				map.put(equip.getUserEquipmentId(), equip);
			}
			userEquipmentDAO.setUserEquipmetCache(userId, map);
		}
		return map;
	}
	
	@Override
	public Collection<UserEquipment> getUserEquipments(User user){
		return loadUserEquipment(user).values();
	}
	
	@Override
	public UserEquipment getUserEquipment(User user, int userEquipmentId){
		Map<Integer, UserEquipment> map = loadUserEquipment(user);
		UserEquipment equip = map.get(userEquipmentId);
		if(equip == null){
			throw new GameException(GameException.CODE_装备不存在, "");
		}
		return equip;
	}

	@Override
	public Set<UserEquipment> getUserEquipmentByHero(User user, int userHeroId) {
		Map<Integer, UserEquipment> map = loadUserEquipment(user);
		Set<UserEquipment> list = new HashSet<>();
		for(UserEquipment equip : map.values()){
			if(equip.getUserHeroId() == userHeroId){
				list.add(equip);
			}
		}
		return list;
	}
	
	@Override
	public Collection<UserEquipment> initUserEquipment(int userId) {
		userEquipmentDAO.clearUserEquipmentCache(userId);
		return loadUserEquipment(userId).values();
	}
	
	/**************************************************** 装备逻辑 ****************************************************************/
	
	@Override
	public int levelUpEquipment(int userId, int userEquipId, int type) {
		int amount = 1;
		User user = userService.getOnlineUser(userId);
		UserEquipment equip = userEquipmentService.getUserEquipment(user, userEquipId);
		if(equip == null){
			throw new GameException(GameException.CODE_装备不存在, "");
		}
		Equipment config = GameCache.getEquipment(equip.getEquipmentId());
		if(equip.getLevel() >= config.getMaxLevel()){
			throw new GameException(GameException.CODE_装备已经达到最大等级, "");
		}else if(type == 2){
			amount = config.getMaxLevel() - equip.getLevel();
		}
		List<EquipmentUp> expends = GameCache.getEquipmentUps(equip.getLevel());
		if(expends == null || expends.isEmpty()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_强化装备消耗);
		for(EquipmentUp item : expends){
			effects.delItem(item.getType(), item.getAssId(), item.getNum());
		}
		amount = effectService.validDels(user, effects, amount);
		effectService.delIncome(user, effects);
		equip.setLevel(equip.getLevel() + amount);
		updateUserEquipment(user, equip, true);
		//更新战斗力
		fightService.computeFightingEvent(user.getUserId());
		userService.increTodayEquipLevelUpTimes(userId, amount);
		//抛出装备强化事件
		LevelUpEquipEvent event = LevelUpEquipEvent.valueOf(user, equip.getEquipmentId(), equip.getLevel(), SystemConstant.EQUIPMENT_UP_RATE_SUCCESS_成功, amount);
		TimerController.submitGameEvent(event);
		return SystemConstant.EQUIPMENT_UP_RATE_SUCCESS_成功;
//		int upLevel=0;
//		double random=Math.random();
//		EquipmentUpRate rate=GameCache.getEquipmentUpRate(equip.getLevel());
//		if(rate.getSuccessRate()>=random){
//			upLevel = SystemConstant.EQUIPMENT_UP_RATE_SUCCESS_成功;
//		}else if(rate.getMaxSuccessRate()+rate.getSuccessRate()>=random){
//			upLevel = SystemConstant.EQUIPMENT_UP_RATE_SUCCESS_大成功;
//		}else if(rate.getMaxSuccessRate()+rate.getSuccessRate()+rate.getSuperSuccessRate()>=random){
//			upLevel = SystemConstant.EQUIPMENT_UP_RATE_SUCCESS_超成功;
//		}else{
//			upLevel = SystemConstant.EQUIPMENT_UP_RATE_LOSE_失败;
//		}
	}

	@Override
	public void sellEquipment(int userId, List<Integer> equipments) { 
		if(CheckUtil.isRepeatlist(equipments)){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		User user = userService.getOnlineUser(userId);
		int gold = 0;
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_出售装备);
		for(int userEquipmentId : equipments){
			UserEquipment ue = userEquipmentService.getUserEquipment(user, userEquipmentId);
			if(ue == null){
				throw new GameException(GameException.CODE_参数错误, "can't find user equment ");
			}
			Equipment e = GameCache.getEquipment(ue.getEquipmentId());
			gold += e.getSellPrice();
			effects.delItem(ue);
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GOLD, gold, SystemConstant.LOGGER_APPROACH_出售装备);
	}

	@Override
	public void useEquipment(int userId, int userEquipmentId, int userHeroId) {
		User user = userService.getOnlineUser(userId);
		UserEquipment ue = userEquipmentService.getUserEquipment(user, userEquipmentId);
		if(ue == null){
			throw new GameException(GameException.CODE_参数错误, "can't find user equment "+userEquipmentId);
		}
		if(userHeroId > 0){
			UserHero hero = userHeroService.getUserHero(user, userHeroId);
			Set<UserEquipment> ues = getUserEquipmentByHero(user, userHeroId);
			Equipment currEq = GameCache.getEquipment(ue.getEquipmentId());
			if(currEq.getEle()!=0){
				Hero h = GameCache.getHero(hero.getHeroId());
				if(h.getEle() != SystemConstant.EQUIP_ELE_COMMON && currEq.getEle() != h.getEle()){
					throw new GameException(GameException.CODE_装备属性不匹配, "hero ele != equipment ele "+currEq.getEle() + ","+h.getEle());
				}
			}
			for(UserEquipment e : ues){
				Equipment equ = GameCache.getEquipment(e.getEquipmentId());
				if(equ.getType() == currEq.getType()){
					e.setUserHeroId(0);
					updateUserEquipment(user, e, true);
					break;
				}
			}
		}
		ue.setUserHeroId(userHeroId);
//		userEquipmentDAO.updateUserEquipmentCache(ue);
		updateUserEquipment(user, ue, true);
		
		fightService.computeFightingEvent(userId);
	}
	
}
