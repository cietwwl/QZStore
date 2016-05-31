package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.BlowingRule;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.UserRule;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserEternalService;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.prop.EternalSmeltingVO;
import com.ks.protocol.vo.prop.SmeltingVO;
import com.ks.util.CheckUtil;

public class UserEternalServiceImpl extends BaseService implements UserEternalService{

	/******************************************* 数据处理 ***********************************************/
	@Override
	public void updateUserEternals(User user, List<UserEternal> list, boolean updateDB){
		if(!list.isEmpty()){
			int userId = list.get(0).getUserId();
			for(UserEternal eternal : list){
				if(eternal.getUserEternalId() == 0){
					userEternalDAO.addUserEternal(eternal);
					userEternalDAO.addUserEternalCache(eternal);
					if(user.getEternals() != null){
						user.getEternals().put(eternal.getUserEternalId(), eternal);
					}
				}else{
					userEternalDAO.updateUserEternal(eternal);
					userEternalDAO.updateUserEternalCache(eternal);
				}
			}
			dataService.updateEternals(userId, list);
		}
	}
	
	@Override
	public void deleteUserEternal(User user, int userEternalId){
		userEternalDAO.deleteUserEternal(userEternalId, user.getUserId());
		userEternalDAO.deleteUserEternalCache(user.getUserId(), userEternalId);
		if(user.getEternals() != null){
			user.getEternals().remove(userEternalId);
		}
	}
	
	/**
	 * 加载装备
	 */
	private Map<Integer, UserEternal> loadUserEternal(User user){
		Map<Integer, UserEternal> map = user.getEternals();
		if(map == null){
			map = loadUserEternal(user.getUserId());
			user.setEternals(map);
		}
		return map;
	}
	/**
	 * 加载武魂
	 */
	private Map<Integer, UserEternal> loadUserEternal(int userId){
		Map<Integer, UserEternal> map = userEternalDAO.queryUserEternalsCache(userId, true);
		if(map == null){
			List<UserEternal> list = userEternalDAO.queryUserEternals(userId);
			map = new HashMap<Integer, UserEternal>();
			for(UserEternal eternal : list){
				map.put(eternal.getUserEternalId(), eternal);
			}
			userEternalDAO.setUserEternalCache(userId, map);
		}
		return map;
	}

	@Override
	public Collection<UserEternal> getUserEternals(User user) {
		return loadUserEternal(user).values();
	}
	
	@Override
	public UserEternal getUserEternal(User user, int userEternalId){
		Map<Integer, UserEternal> map = loadUserEternal(user);
		UserEternal target = map.get(userEternalId);
		if(target == null){
			throw new GameException(GameException.CODE_武魂不存在, "");
		}
		return target;
	}

	@Override
	public Collection<UserEternal> initUserEternal(int userId) {
		userEternalDAO.clearUserEternalCache(userId);
		return loadUserEternal(userId).values();
	}
	
	/********************************************** 逻辑处理 *************************************************/
	@Override
	public List<UserEternalVO> gainUserEternal(int userId) {
		User user = userService.getOnlineUser(userId);
		Map<Integer, UserEternal> map = loadUserEternal(user);
		List<UserEternalVO>  vos = new ArrayList<UserEternalVO>();
		for(UserEternal ue : map.values()){
			UserEternalVO vo = MessageFactory.getMessage(UserEternalVO.class);
			vo.init(ue);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public void wearEternal(int userId, int userEternalId, int userHeroId) {
		User user = userService.getOnlineUser(userId);
		UserHero userHero = userHeroService.getUserHero(user, userHeroId);
		if(userHero.getEternal() !=0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserEternal ue = getUserEternal(user, userEternalId);
		if(ue.isUse()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		Hero hero = GameCache.getHero(userHero.getHeroId());
		Eternal e = GameCache.getEternal(ue.getEternalId());
		
		if(e.getEle() != 0 && hero.getEle() != e.getEle() && e.getEle() != SystemConstant.EQUIP_ELE_COMMON){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		
		userHero.setEternal(userEternalId);
//		userHeroDAO.updateUserHeroCache(userHero);
		userHeroService.updateHero(userHero);
		ue.setUse(true);
		userEternalDAO.updateUserEternal(ue);
	}

	@Override
	public void disEternal(int userId, int userHeroId, boolean retain) {
		User user = userService.getOnlineUser(userId);
		UserHero userHero = userHeroService.getUserHero(user, userHeroId);
		if(userHero.getEternal() ==0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserEternal ue = getUserEternal(user, userHero.getEternal());
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_拆下武魂);
		if(retain){
			effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, SystemConstant.PROP_ID_秘银棒, 1, 0);
		}else{
			effects.appendDelObj(ue);
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		userHero.setEternal(0);
		ue.setUse(false);
		ue.setUpdateTime(new Date());
		userEternalDAO.updateUserEternal(ue);
//		userHeroDAO.updateUserHeroCache(userHero);
		userHeroService.updateHero(userHero);
		//更新战斗力
		fightService.computeFightingEvent(user.getUserId());
	}
	
	@Override
	public List<EternalSmeltingVO> gainEternalSmeltings(int userId) {
		User user = userService.getOnlineUser(userId);
		List<EternalSmeltingVO> vos = new ArrayList<EternalSmeltingVO>();
		EternalSmeltingVO vo = MessageFactory.getMessage(EternalSmeltingVO.class);
		vo.init(1, user.getSmeltingExp(), user.getAddSmeltingVal());
		vos.add(vo);
		return vos;
	}
	
	private static final int[] ETERNAL_RATE = new int[]{70,90,100};
	
	private static final int[] BEI = new int[]{100,120,130}; 
	
	@Override
	public SmeltingVO eternal(int userId, int type, List<Integer> equipmentIds,List<Integer> eternalIds) { 
		if(CheckUtil.isRepeatlist(equipmentIds)){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		User user = userService.getOnlineUser(userId);
		UserRule rule = GameCache.getUserRule(user.getLevel());
		int limit = privilegeService.getPrivilegesValue(user, SystemConstant.PRIVILEGE_TYPE_ETERNAL_SMELTING_MAX_LIMIT) + rule.getEternalVal() + user.getAddSmeltingVal();
		if(user.getSmeltingExp() >= limit){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		int val = 0;
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_熔炼消耗);
		for(int equipmentId : equipmentIds){
			UserEquipment ue = userEquipmentService.getUserEquipment(user, equipmentId);
			if(ue==null){
				throw new GameException(GameException.CODE_参数错误, "eq = null");
			}
			if(ue.getUserHeroId()!=0){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			Equipment e  = GameCache.getEquipment(ue.getEquipmentId());
			val += e.getEternalVal()*ue.getLevel();
			effects.appendDelObj(ue);
		}
		for(int eternalId : eternalIds){
			UserEternal ue = getUserEternal(user, eternalId);
			if(ue.isUse()){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			Eternal e  = GameCache.getEternal(ue.getEternalId());
			val += e.getEternalVal();
			effects.appendDelObj(ue);
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		SmeltingVO s = MessageFactory.getMessage(SmeltingVO.class);
		int random = ThreadLocalRandom.current().nextInt(100);
		for(int i=0;i<ETERNAL_RATE.length;i++){
			if(ETERNAL_RATE[i]>random){
				s.setType(i);
				val=val*BEI[i]/100;
				break;
			}
		}
		s.setGainPoint(val);
		ItemEffects adds = new ItemEffects(SystemConstant.LOGGER_APPROACH);
		adds.appendItem(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT, 0, val, 0);
		effectService.addIncome(user, adds, null);
		
		EternalSmeltingVO vo = MessageFactory.getMessage(EternalSmeltingVO.class);
		vo.init(1, user.getSmeltingExp(), user.getAddSmeltingVal());
		s.setEs(vo);
		return s;
	}

	@Override
	public UserEternal blowing(int userId, int type) {
		User user = userService.getOnlineUser(userId);
		ItemEffects dels = new ItemEffects(SystemConstant.LOGGER_APPROACH);
		dels.appendItem(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT, 0, SystemConstant.ETERNAL_SMELTING_MAX_VAL[type-1], 0);
		int code = effectService.validDels(user, dels);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		List<BlowingRule> rules = GameCache.queryBlowingRule(type);
		int propId = 0;
		int random = (int) (Math.random()*10000);
		int rate = 0;
		for(BlowingRule rule : rules){
			rate += rule.getRate();
			if(rate > random){
				propId = rule.getPropId();
				break;
			}
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_开炉获得);
		effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL, propId, 1, 1);
		code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, dels);
		ItemEffect effect = new ItemEffect();
		effect.setType(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL);
		effect.setId(propId);
		effect.setValue1(1);
		return (UserEternal) incomeService.addIncome(user, effect, null, false).get(0);
	}

	@Override
	public void sellEternal(int userId, int userEternalId) {
		User user = userService.getOnlineUser(userId);
		UserEternal ue = getUserEternal(user, userEternalId);
		Eternal e = GameCache.getEternal(ue.getEternalId());
		if(ue.isUse() || e == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_出售武魂);
		effects.appendDelObj(ue);
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GOLD, e.getSellPrice(), null, false, SystemConstant.LOGGER_APPROACH_出售武魂获得);
	}
	
}
