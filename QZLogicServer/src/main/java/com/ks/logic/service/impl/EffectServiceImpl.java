package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Drop;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.UserRule;
import com.ks.db.cfg.ZoneBattle;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserProp;
import com.ks.db.model.UserTeam;
import com.ks.db.model.UserZoneBattle;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.EffectService;
import com.ks.model.fight.Battle;
import com.ks.object.DropEffect;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.object.Reward;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.equment.UserEquipmentVO;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.goods.GoodsVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.protocol.vo.prop.UserPropVO;
import com.ks.protocol.vo.reward.RewardVO;
import com.ks.util.MathUtil;
import com.ks.util.XyStringUtil;

/**
 * 效果处理
 * hjw
 *
 */
public class EffectServiceImpl extends BaseService implements EffectService{
	
	@Override
	public List<ItemEffect> parseItemEffects(String str, int logSubType){
		List<List<Integer>> lists = XyStringUtil.parseLists(str, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
		List<ItemEffect> effects = new ArrayList<ItemEffect>();
		for(List<Integer> list : lists){
			int effectType = list.get(0);
			int id = list.get(1);
			int value = list.get(2);
			int level = 0;
			int probability = SystemConstant.PERCENT_BASE_INT;
			if(list.size() >= 4){
				level = list.get(3);
				if(list.size() >= 5){
					probability = list.get(4);
				}
			}
			effects.add(createEffect(effectType, id, value, level, probability, logSubType));
		}
		return effects;
	}
	
	@Override
	public List<DropEffect> parseDropEffects(String str, int logSubType){
		List<DropEffect> drops = new ArrayList<>();
		List<String> strs = XyStringUtil.parseListByString(str, XyStringUtil.SPLIT_AND);
		for(String sr : strs){
			List<String> vals = XyStringUtil.parseListByString(sr, XyStringUtil.SPLIT_WELL);
			if(vals.size() >= 3){
				int probability = new Integer(vals.get(0));
				int amount = new Integer(vals.get(1));
				drops.add(new DropEffect(amount, probability, parseItemEffects(vals.get(2), logSubType)));
			}
		}
		return drops;
	}
	
	@Override
	public List<ItemEffect> mergeItemEffect(List<ItemEffect> items1, List<ItemEffect> items2){
		Map<Integer, Map<Integer, ItemEffect>> iMap = new HashMap<Integer, Map<Integer,ItemEffect>>();
		for(ItemEffect item : items1){
			merge(iMap, item);
		}
		for(ItemEffect item : items2){
			merge(iMap, item);
		}
		List<ItemEffect> list = new ArrayList<>();
		for(Map<Integer, ItemEffect> map : iMap.values()){
			list.addAll(map.values());
		}
		return list;
	}
	private void merge(Map<Integer, Map<Integer, ItemEffect>> iMap, ItemEffect item){
		Map<Integer, ItemEffect> map = iMap.get(item.getType());
		if(map == null){
			map = new HashMap<>();
			iMap.put(item.getType(), map);
		}
		ItemEffect old = map.get(item.getId());
		if(old == null){
			map.put(item.getId(), item);
		}else{
			old.setValue1(old.getValue1() + item.getValue1());
		}
	}
	
	@Override
	public List<ItemEffect> mergeEffect(List<ItemEffect> list, int mult){
		List<ItemEffect> news = new ArrayList<>();
		if(list.size() > 1){
			Map<Integer, List<ItemEffect>> map = new HashMap<Integer, List<ItemEffect>>();
			for(ItemEffect item : list){
				List<ItemEffect> gds = map.get(item.getType());
				if(gds == null){
					gds = new ArrayList<>();
					map.put(item.getType(), gds);
				}
				boolean add = true;
				if(!gds.isEmpty()){
					for(ItemEffect gd : gds){
						if((gd.getType() != SystemConstant.ITEM_EFFECT_TYPE_HERO
								&& gd.getType() != SystemConstant.ITEM_EFFECT_TYPE_ETERNAL
								&& gd.getType() != SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT
								&& gd.getType() != SystemConstant.ITEM_EFFECT_TYPE_PROP)
								|| gd.getId() == item.getId()){
							gd.setValue1(gd.getValue1() + item.getValue1());
							add = false;
							break;
						}
					}
				}
				if(add){
					gds.add(item);
				}
			}
			for(List<ItemEffect> ls : map.values()){
				news.addAll(ls);
			}
		}else{
			news.addAll(list);
		}
		if(mult != 1 && mult > 0){
			for(ItemEffect item : news){
				item.setValue1((int)(item.getValue1() * mult));
			}
		}
		return news;
	}
	
	@Override
	public int validAddDrops(User user, List<DropEffect> drops){
		int heroSize = 0;
		int eternalSize = 0;
		int equipSize = 0;
		int dropSize = 0;
		List<Integer> noProps = new ArrayList<>();
		for(DropEffect effect : drops){
			heroSize += effect.getItemSize(SystemConstant.ITEM_EFFECT_TYPE_HERO);
			eternalSize += effect.getItemSize(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL);
			equipSize += effect.getItemSize(SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT);
			dropSize += effect.getItemSize(SystemConstant.ITEM_EFFECT_TYPE_PROP);
			int remove = 0;
			for(ItemEffect item : effect.getItems()){
				if(item.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
					if(!noProps.contains(item.getId())){
						noProps.add(item.getId());
					}else{
						remove ++;
					}
				}
			}
			if(remove > 0){
				dropSize -= remove;
			}
		}
		return validSize(user, heroSize, eternalSize, equipSize, dropSize);
	}
	
	@Override
	public List<ItemEffect> addDrops(User user, List<DropEffect> drops){
		List<ItemEffect> list = new ArrayList<>();
		for(DropEffect drop : drops){
			if(drop.isDrop()){
				int amount = drop.getAmount();
				int probability = 0;
				List<ItemEffect> items = drop.getItems();
				Iterator<ItemEffect> it = items.iterator();
				while(it.hasNext()){
					ItemEffect effect = it.next();
					if(effect.getProbability() == SystemConstant.PERCENT_BASE_INT){
						it.remove();
						incomeService.addIncome(user, effect);
						list.add(effect);
						if(amount > 0){
							amount--;
							if(amount == 0){
								break;
							}
						}
					}else{
						probability += effect.getProbability();
					}
				}
				if(amount > 0){
					for(int i = 0; i < amount; i++){
						if(probability > 0){
							int random = MathUtil.nextInt(probability);
							Iterator<ItemEffect> ix = items.iterator();
							while(ix.hasNext()){
								ItemEffect effect = ix.next();
								if(random < effect.getProbability()){
									probability -= effect.getProbability();
									incomeService.addIncome(user, effect);
									list.add(effect);
									break;
								}else{
									random -= effect.getProbability();
								}
							}
						}
					}
				}else if(amount == -1){
					for(ItemEffect effect : items){
						int random = MathUtil.nextInt(SystemConstant.PERCENT_BASE_INT);
						if(random < effect.getProbability()){
							incomeService.addIncome(user, effect);
							list.add(effect);
						}
					}
				}
			}
		}
		return list;
	}

	@Override
	public ItemEffect createEffect(int effectType, int id, int value1, int value2, int logSubType){
		return createEffect(effectType, id, value1, value2, SystemConstant.PERCENT_BASE_INT, logSubType);
	}

	/**
	 * 创建效果
	 */
	private ItemEffect createEffect(int effectType, int id, int value1, int value2, int probability, int logSubType){
		ItemEffect effect = new ItemEffect();
		effect.setType(effectType);;
		effect.setId(id);
		effect.setValue1(value1);
		effect.setValue2(value2);
		effect.setProbability(probability);
		effect.setLogSubType(logSubType);
		return effect;
	}
	
	public void addItemEffects(User user, List<ItemEffect> effects, RewardVO vo){
		if(effects.size() > 1){
			effects = mergeEffect(effects, 0);
		}
		incomeService.addIncomes(user, effects);
	}
	
	public void addItemEffect(User user, ItemEffect effect, RewardVO vo){
		List<ItemEffect> effects = new ArrayList<>();
		effects.add(effect);
		addItemEffects(user, effects, vo);
	}
	
	public void addItemEffect(User user, int effectType, int value, int logSubType, RewardVO vo){
		incomeService.addIncome(user, effectType, value, logSubType);
	}
	
	@Override
	public int validAdds(User user, ItemEffects effects){
		int heroSize = 0;
		int eternalSize = 0;
		int equipSize = 0;
		int propSize = 0;
		for(Map<Integer, ItemEffect> entry : effects.getItemMap().values()){
			for(ItemEffect effect : entry.values()){
				if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
					Hero hero = GameCache.getHero(effect.getId());
					if(hero == null){
						return GameException.CODE_伙伴不存在;
					}else{
						heroSize += effect.getValue1();
					}
				}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
					Eternal econfig = GameCache.getEternal(effect.getId());
					if(econfig == null){
						return GameException.CODE_武魂不存在;
					}else{
						eternalSize += effect.getValue1();
					}
				}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
					Equipment econfig = GameCache.getEquipment(effect.getId());
					if(econfig == null){
						return GameException.CODE_装备不存在;
					}else{
						equipSize += effect.getValue1();
					}
				}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
					Prop pconfig = GameCache.getProp(effect.getId());
					if(pconfig == null){
						return GameException.CODE_道具不存在;
					}else{
						UserProp prop = userPropService.getUserPropByPropId(user, effect.getId());
						if(prop == null){
							propSize ++;
						}
					}
				}
			}
		}
		return validSize(user, heroSize, eternalSize, equipSize, propSize);
	}
	
	/**
	 * 校验背包格子
	 */
	public int validSize(User user, int heroSize, int eternalSize, int equipSize, int propSize){
		UserRule rule = GameCache.getUserRule(user.getLevel());
		if(rule == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}else if(heroSize > 0){
			incomeService.initSize(user, SystemConstant.ITEM_EFFECT_TYPE_HERO);
			return user.getHeroSize() + heroSize > user.getHeroCapacity() + rule.getHeroCapacity() ? GameException.CODE_伙伴背包空间不足 : GameException.CODE_正常;
		}else if(eternalSize > 0){
			incomeService.initSize(user, SystemConstant.ITEM_EFFECT_TYPE_ETERNAL);
			return user.getEternalSize() + eternalSize > user.getEternalCapacity() + rule.getEternalCapacity() ? GameException.CODE_武魂背包空间不足 : GameException.CODE_正常;
		}else if(equipSize > 0){
			incomeService.initSize(user, SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT);
			return user.getEquipmentSize() + equipSize > user.getEquipmentCapacity() + rule.getEquipmentCapacity() ? GameException.CODE_装备背包空间不足 : GameException.CODE_正常;
		}else if(propSize > 0){
			incomeService.initSize(user, SystemConstant.ITEM_EFFECT_TYPE_PROP);
			return propSize + user.getPropSize() > SystemConstant.USER_BACK_PACK_LIMIT ? GameException.CODE_道具背包空间不足 : GameException.CODE_正常;
		}
		return GameException.CODE_正常;
	}
	
	/**
	 * 校验添加
	 * @param user
	 * @param effect
	 * @return
	 */
	private int validAdd(User user, ItemEffect effect){
		int heroSize = 0;
		int eternalSize = 0;
		int equipSize = 0;
		int propSize = 0;
		if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
			Hero hero = GameCache.getHero(effect.getId());
			if(hero == null){
				return GameException.CODE_伙伴不存在;
			}else{
				heroSize = effect.getValue1();
			}
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
			Eternal econfig = GameCache.getEternal(effect.getId());
			if(econfig == null){
				return GameException.CODE_武魂不存在;
			}else{
				eternalSize = effect.getValue1();
			}
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
			Equipment econfig = GameCache.getEquipment(effect.getId());
			if(econfig == null){
				return GameException.CODE_装备不存在;
			}else{
				equipSize = effect.getValue1();
			}
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
			Prop pconfig = GameCache.getProp(effect.getId());
			if(pconfig == null){
				return GameException.CODE_道具不存在;
			}else{
				UserProp prop = userPropService.getUserPropByPropId(user, effect.getId());
				if(prop == null){
					propSize ++;
				}
			}
		}
		return validSize(user, heroSize, eternalSize, equipSize, propSize);
	}
	
	@Override
	public int validDels(User user, ItemEffects effects, int delAmount){
		if(delAmount <= 0){
			throw new GameException(GameException.CODE_参数错误, "");
		}else{
			int code = GameException.CODE_正常;
			for(int i = delAmount; i > 0; i--){
				out:for(Map<Integer, ItemEffect> map : effects.getItemMap().values()){
					for(ItemEffect effect : map.values()){
						ItemEffect item = effect.copy();
						item.setValue1(item.getValue1() * i);
						code = validDel(user, item);
						if(code != GameException.CODE_正常){
							break out;
						}
					}
				}
				if(code == GameException.CODE_正常){
					return i;
				}else if(i == 1){
					throw new GameException(code, "");
				}
			}
		}
		return 0;
	}
	
	@Override
	public int validDels(User user, ItemEffects effects){
		int code = GameException.CODE_正常;
		for(Map<Integer, ItemEffect> map : effects.getItemMap().values()){
			for(ItemEffect effect : map.values()){
				code = validDel(user, effect);
				if(code != GameException.CODE_正常){
					return code;
				}
			}
		}
		return code;
	}
	
	/**
	 * 校验扣除
	 */
	private int validDel(User user, ItemEffect effect){
		if(effect.getValue1() <= 0 && effect.getRemoveIds().isEmpty()){
			return GameException.CODE_参数错误;
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO){
			List<Integer> removeIds = effect.getRemoveIds();
			for(Integer id : removeIds){
				UserHero userHero = userHeroService.getUserHero(user, id);
				if(userHero.getState() > 0){
					return GameException.CODE_伙伴使用中;
				}else{
					UserTeam team = userTeamService.queryUserTeam(user.getUserId());
					if(team.getHeroList().indexOf(userHero.getId()) != -1){
						return GameException.CODE_无法操作队伍中的伙伴;
					}
				}
			}
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
			List<Integer> removeIds = effect.getRemoveIds();
			for(Integer userEternalId : removeIds){
				UserEternal ue = userEternalService.getUserEternal(user, userEternalId);
				if(ue == null){
					return GameException.CODE_武魂不存在;
				}
			}
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
			List<Integer> ids = effect.getRemoveIds();
			for(Integer id : ids){
				UserEquipment ue = userEquipmentService.getUserEquipment(user, id);
				if(ue == null){
					return GameException.CODE_装备不存在;
				}else if(ue.getUserHeroId() != 0){
					return GameException.CODE_装备使用中;
				}
			}
		}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP){
			UserProp prop = userPropService.getUserPropByPropId(user, effect.getId());
			if(prop == null || prop.getNum() < effect.getValue1()){
				return GameException.CODE_道具不足;
			}
		}else{
			return validDel(user, effect.getType(), effect.getValue1());
		}
		return GameException.CODE_正常;
	}
	/**
	 * 校验扣除
	 */
	private int validDel(User user, int type, int value){
		int code = GameException.CODE_正常;
		if(type == SystemConstant.ITEM_EFFECT_TYPE_GOLD){
			return user.getGold() >= value ? code : GameException.CODE_金币不足;
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_DIAMOND){
			return user.getDiamond() >= value ? code : GameException.CODE_钻石不足;
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_GP){
			return user.getGp() >= value ? code : GameException.CODE_GP不足;
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL){
			return user.getHeroExpPool() >= value ? code : GameException.CODE_参数错误;
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT){
			return userEternalService.gainEternalSmelting(user.getUserId()).get(0).getVal() >= value ? code : GameException.CODE_参数错误;
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_SLATE){
			return user.getSlate() >= value ? code : GameException.CODE_上古石板不足;
		}else if(type == SystemConstant.ITEM_EFFECT_TYPE_STAMINA){
			return user.getStamina() >= value ? code : GameException.CODE_体力不足;
		}
		return code;
	}
	
	@Override
	public void addIncome(User user, int type, int value, int logSubType){
		ItemEffects effects = new ItemEffects(logSubType);
		effects.addItem(type, 0, value, 0);
		addIncome(user, effects);
	}
	
	@Override
	public void addIncome(User user, ItemEffects effects){
		for(Map<Integer, ItemEffect> map : effects.getItemMap().values()){
			incomeService.addIncomes(user, map.values());
		}
	}
	
	@Override
	public void delIncome(User user, int type, int id,  int value, int logSubType){
		ItemEffects effects = new ItemEffects(logSubType);
		effects.delItem(type, id, value);
		int code = validDels(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		delIncome(user, effects);
	}
	
	@Override
	public void delIncome(User user, ItemEffects effects){
		for(Map<Integer, ItemEffect> map : effects.getItemMap().values()){
			incomeService.delIncomes(user, map.values());
		}
	}

	@Override
	public GainAwardVO addGainAwardVo(User user, ItemEffects effects){   
		List<UserHeroVO> heros = new ArrayList<>();
		List<UserEquipmentVO> equipments = new ArrayList<>();
		List<UserEternalVO> eternals = new ArrayList<>();
		List<UserPropVO> props = new ArrayList<>();
		for(Map<Integer, ItemEffect> map : effects.getItemMap().values()){
			for(ItemEffect effect : map.values()){
				List<?> list = incomeService.addIncome(user, effect);
				if(!list.isEmpty()){
					for(Object obj : list){
						if(obj instanceof UserHero){
							UserHeroVO vo = MessageFactory.getMessage(UserHeroVO.class);
							vo.init((UserHero) obj);
							heros.add(vo);
						}else if(obj instanceof UserProp){
							UserPropVO vo = MessageFactory.getMessage(UserPropVO.class);
							vo.init((UserProp) obj);
							props.add(vo);
						}else if(obj instanceof UserEquipment){
							UserEquipmentVO vo = MessageFactory.getMessage(UserEquipmentVO.class);
							vo.init((UserEquipment) obj);
							equipments.add(vo);
						}else if(obj instanceof UserEternal){
							UserEternalVO vo = MessageFactory.getMessage(UserEternalVO.class);
							vo.init((UserEternal) obj);
							eternals.add(vo);
						}
					}
				}
			}
		}
		GainAwardVO awards = MessageFactory.getMessage(GainAwardVO.class);
		awards.setHeros(heros);
		awards.setEquipments(equipments);
		awards.setEnternals(eternals);
		awards.setProps(props);
		return awards;
	}

	@Override
	public GainGameAwardVO addGainGameAwardVo(User user, ItemEffects effects) {
		GainGameAwardVO gea = MessageFactory.getMessage(GainGameAwardVO.class);
		List<GoodsVO> goodsVOs = new ArrayList<GoodsVO>();
		for(Map<Integer, ItemEffect> map : effects.getItemMap().values()){
			for(ItemEffect effect : map.values()){
				GoodsVO vo = MessageFactory.getMessage(GoodsVO.class);
				vo.setGoodsId(effect.getId());
				vo.setType(effect.getType());
				vo.setNum(effect.getValue1());
				vo.setLevel(effect.getValue2());
				goodsVOs.add(vo);
			}
		}
		gea.setGoodses(goodsVOs);
		gea.setAwards(addGainAwardVo(user, effects));
		return gea;
	}
	
	@Override
	public List<Drop> drop(User user, UserZoneBattle userZoneBattle, Battle battle, List<Drop> drops, Reward reward, int logSubType){
		int gold = 0;
		int exp = 0;
		int slate = 0;
		if(userZoneBattle != null){
			ZoneBattle zoneBattle = GameCache.getZoneBattle(userZoneBattle.getZoneBattleId());
			gold = userZoneBattle.getPassCount()==1?zoneBattle.getFirstGold():zoneBattle.getGold();
			exp = userZoneBattle.getPassCount()==1?zoneBattle.getFirstExp():zoneBattle.getExp();
		}
		List<Drop> dlist = new ArrayList<Drop>();
		for(Drop old : drops){
			Drop drop = old.copy();
			try{
				ItemEffect effect = effectService.createEffect(drop.getType(), drop.getAssId(), drop.getNum(), 1, logSubType);
				if(drop.getType() == SystemConstant.ITEM_EFFECT_TYPE_HERO
						|| drop.getType() == SystemConstant.ITEM_EFFECT_TYPE_PROP
						|| drop.getType() == SystemConstant.ITEM_EFFECT_TYPE_ETERNAL
						|| drop.getType() == SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT){
					int code = validAdd(user, effect);
					if(code == GameException.CODE_正常){
						List<?> list = incomeService.addIncome(user, effect);
						for(Object obj : list){
							if(obj instanceof UserHero){
								UserHeroVO vo = MessageFactory.getMessage(UserHeroVO.class);
								vo.init((UserHero) obj);
								reward.getHeros().add(vo);
							}else if(obj instanceof UserProp){
								UserPropVO vo = MessageFactory.getMessage(UserPropVO.class);
								vo.init((UserProp) obj);
								reward.getProps().add(vo);
							}else if(obj instanceof UserEquipment){
								UserEquipmentVO vo = MessageFactory.getMessage(UserEquipmentVO.class);
								vo.init((UserEquipment) obj);
								reward.getEquips().add(vo);
							}else if(obj instanceof UserEternal){
								UserEternalVO vo = MessageFactory.getMessage(UserEternalVO.class);
								vo.init((UserEternal) obj);
								reward.getEternals().add(vo);
							}
						}
					}else{
						drop.setSuccessDrop(false);
					}
				}else{
					if(battle != null){
						if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_EXP){
							effect.setValue1(exp + effect.getValue1());
							int expAddition = fightService.getBattleAddition(battle, SystemConstant.SKILL_EFFECT_ID_经验增加, SystemConstant.PROP_EFFECT_ID_经验加成);
							if(expAddition > 0){
								effect.setAddition(expAddition);
							}
							exp = 0;
						}else if(effect.getType() == SystemConstant.ITEM_EFFECT_TYPE_GOLD){
							effect.setValue1(gold + effect.getValue1());
							int goldAddition = fightService.getBattleAddition(battle, SystemConstant.SKILL_EFFECT_ID_金钱增加, SystemConstant.PROP_EFFECT_ID_金钱加成);
							if(goldAddition > 0){
								effect.setAddition(goldAddition);
							}
							gold = 0;
						}else if(battle.getSlate() > 0){
							slate = battle.getSlate();
						}
					}
					incomeService.addIncome(user, effect);
					reward.setValue(effect.getType(), effect.getValue1());
				}
			}catch(Exception e){
				drop.setSuccessDrop(false);
			}
			if(drop.isSuccessDrop()){
				dlist.add(drop);
			}
		}
		if(slate > 0){
			addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_SLATE, slate, logSubType);
			reward.setSlate(slate);
		}
		if(exp > 0){
			addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_EXP, exp, logSubType);
			reward.setExp(exp);
		}
		if(gold > 0){
			addIncome(user, SystemConstant.ITEM_EFFECT_TYPE_GOLD, gold, logSubType);
			reward.setGold(gold);
		}
		return dlist;
	}
}
