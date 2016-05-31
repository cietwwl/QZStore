package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.PropEffect;
import com.ks.db.cfg.UserRule;
import com.ks.db.model.User;
import com.ks.db.model.UserBuff;
import com.ks.db.model.UserProp;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserPropService;
import com.ks.object.DropEffect;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.prop.SellPropVO;
import com.ks.protocol.vo.reward.ItemEffectVO;
import com.ks.protocol.vo.reward.RewardVO;

public class UserPropServiceImpl extends BaseService implements UserPropService {
	/****************************************************prop data****************************************************************/
	@Override
	public void updateProp(User user, UserProp prop, int type){
		if(type != 0){
			if(prop.getId() == 0){
				userPropDAO.addUserProp(prop);
				userPropDAO.addUserPropCache(prop);
				user.getProps().put(prop.getId(), prop);
			}else{
				List<UserProp> list = new ArrayList<UserProp>();
				list.add(prop);
				userPropDAO.updateUserProps(list);
			}
		}
		if(prop.getNum() > 0){
			userPropDAO.updateUserProp(prop);
			userPropDAO.updateUserPropCache(prop);
		}else{
			userPropDAO.delUserProp(user.getUserId(), prop);
			userPropDAO.delUserPropCache(user.getUserId(), prop);
			user.getProps().remove(prop.getId());
		}
		dataService.updateProp(user.getUserId(), prop);
	}
	
	@Override
	public UserProp getUserPropByPropId(User user, int propId){
		Map<Integer, UserProp> map = user.getProps();
		if(map == null){
			map = loadUserProp(user);
		}
		for(UserProp prop : map.values()){
			if(prop.getPropId() == propId){
				return prop;
			}
		}
		return null;
	}
	
	@Override
	public int getPropAmount(User user, int propId){
		UserProp prop = getUserPropByPropId(user, propId);
		if(prop != null){
			return prop.getNum();
		}
		return 0;
	}
	
	/**
	 * 加载道具
	 * @param user
	 */
	private Map<Integer, UserProp> loadUserProp(User user){
		Map<Integer, UserProp> map = user.getProps();
		if(map == null){
			map = loadUserProp(user.getUserId());
			user.setProps(map);
		}
		return map;
	}
	
	/**
	 * 加载道具
	 * @param user
	 */
	private Map<Integer, UserProp> loadUserProp(int userId){
		Map<Integer, UserProp> map = userPropDAO.queryUserPropsCache(userId, true);
		if(map == null){
			List<UserProp> list  = loadDBUserProp(userId);
			map = listToMap(list);
			userPropDAO.setUserPropsCache(userId, map);
		}
		return map;
	}
	
	/**
	 * 加载道具
	 * @param user
	 */
	private List<UserProp> loadDBUserProp(int userId){
		List<UserProp> list = userPropDAO.queryUserProps(userId);
		return list;
	}
	
	@Override
	public UserProp getUserPropById(User user, int id){
		Map<Integer, UserProp> map = loadUserProp(user);
		return map.get(id);
	}
	
	/****************************************************logic****************************************************************/
	@Override
	public UserProp popEmptyUserProp(User user){
		UserProp prop = new UserProp();
		prop.setUserId(user.getUserId());
		prop.setNum(0);
		prop.setCreateTime(new Date());
		prop.setUpdateTime(new Date());
		return prop;
	}

	public Map<Integer, UserProp> listToMap(Collection<UserProp> collection){
		Map<Integer, UserProp> map = new HashMap<Integer, UserProp>();
		for(UserProp prop : collection){
			map.put(prop.getId(), prop);
		}
		return map;
	}
	@Override
	public Collection<UserProp> initProps(int userId) {
		userPropDAO.clearUserPropCache(userId);
		Map<Integer, UserProp> propmap = loadUserProp(userId);
		return propmap.values();
	}

	@Override
	public UserProp useProp(int userId, int propId, int number){ 
		User user = userService.getOnlineUser(userId);
//		UserProp userProp = userPropDAO.queryUserPropFromCache(userId, propId);
		UserProp userProp = getUserPropByPropId(user, propId);
		if(userProp == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(userProp.getNum() < 1 || number <= 0 || userProp.getNum() < number){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			Prop prop = GameCache.getProp(propId);
			if(!prop.isUse()){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			ItemEffects removes = new ItemEffects(SystemConstant.LOGGER_APPROACH_使用道具);
			removes.appendItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, propId, number, 0);
			int code = effectService.validDels(user, removes);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_使用道具获得);
			for(PropEffect effect : prop.getEffects()){
				if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_获得经验){
					effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_EXP, 0, effect.getVal() * number, 0);
				}else if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_获得体力
						|| effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_体力全满){
					int value = effect.getVal() * number;
					if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_体力全满){
						UserRule rule = GameCache.getUserRule(user.getLevel());
						value = rule.getStamina() - user.getStamina();
					}
					if(value > 0){
						effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_STAMINA, 0, value, 0);
					}
				}else if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_金钱加成
						|| effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_经验加成){
					addUserBuff(userId, effect);
				}else if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_增加经验池上限){
					effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_ADD_HERO_POOL_EXP_LIMIT, 0, effect.getVal() * number, 0);
				}else if(effect.getEffectId() == SystemConstant.PROP_EFFECT_ID_增加熔炼池上限){
					effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_ADD_SMELTING_POOL_EXP_LIMIT, 0, effect.getVal() * number, 0);
				}
			}
			code = effectService.validAdds(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			effectService.delIncome(user, removes);
			effectService.addIncome(user, effects, null);
			return userProp;
		}
	}

	private void addUserBuff(int userId, PropEffect effect) {
		UserBuff buff = userBuffDAO.queryUserBuff(userId, effect.getEffectId());
		boolean add = false;
		if(buff == null){
			add = true;
			buff = new UserBuff();
			buff.setUserId(userId);
			buff.setEffectId(effect.getEffectId());
		}
		if(buff.getVal()!=effect.getVal()){
			buff.setVal(effect.getVal());
			buff.setCd(0);
		}
		buff.setCd(buff.getCd()+effect.getCd());
		if(add){
			userBuffDAO.addUserBuff(buff);
		}else{
			userBuffDAO.updateUserBuff(buff);
		}
	}

	@Override
	public void sellProp(int userId, List<SellPropVO> sellProps) {
		User user = userService.getOnlineUser(userId);
		int gold = 0;
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_出售道具);
		for(SellPropVO sell : sellProps){
			Prop prop = GameCache.getProp(sell.getPropId());
			if(sell.getNum() <= 0 || !prop.isSell()){
				throw new GameException(GameException.CODE_参数错误, "");
			}else if(prop.getSellPrice() >= 0){
				effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, sell.getPropId(), sell.getNum(), 0);
				gold += prop.getSellPrice() * sell.getNum();
			}
		}
		int code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		if(gold > 0){
			effectService.delIncome(user, effects);
			effectService.addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GOLD, gold, null, false, SystemConstant.LOGGER_APPROACH_出售道具);
		}
	}
	
	@Override
	public RewardVO openBox(int userId, int propId){
		User user = userService.getOnlineUser(userId);
		Prop prop = GameCache.getProp(propId);
		if(prop == null || prop.getType() != SystemConstant.PROP_TYPE_BOX || prop.getGainItems().length() <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		UserProp userProp = getUserPropByPropId(user, propId);
		if(userProp == null || userProp.getNum() < 1){
			throw new GameException(GameException.CODE_道具不足, "");
		}
		List<DropEffect> drops = effectService.parseDropEffects(prop.getGainItems(), SystemConstant.LOGGER_APPROACH_开启宝箱);
		if(drops.isEmpty()){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		int code = effectService.validAddDrops(user, drops);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_开启宝箱);
		if(prop.getExpendItems().length() > 0){
			effects.appendStrs(prop.getExpendItems());
		}
		effects.appendItem(SystemConstant.ITEM_EFFECT_TYPE_PROP, propId, 1, 0);
		code = effectService.validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		effectService.delIncome(user, effects);
		List<ItemEffect> items = effectService.addDrops(user, drops, false);
		return toVo(items);
	}
	
	public RewardVO toVo(List<ItemEffect> effects){
		RewardVO vo = MessageFactory.getMessage(RewardVO.class);
		for(ItemEffect effect : effects){
			vo.getEffects().add(toItemEffect(effect));
		}
		return vo;
	}
	
	public ItemEffectVO toItemEffect(ItemEffect effect){
		ItemEffectVO itemVO = MessageFactory.getMessage(ItemEffectVO.class);
		itemVO.setType(effect.getType());
		itemVO.setId(effect.getId());
		itemVO.setValue1(effect.getValue1());
		itemVO.setValue2(effect.getValue2());
		return itemVO;
	}
}
