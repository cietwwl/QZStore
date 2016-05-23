package com.ks.object;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import com.ks.constant.SystemConstant;
import com.ks.db.model.Goods;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.exceptions.GameException;
import com.ks.util.XyStringUtil;

@Data
public class ItemEffects {
	private int logSubType;
	private Map<Integer, Map<Integer, ItemEffect>> itemMap = new HashMap<Integer, Map<Integer,ItemEffect>>();
	public ItemEffects(int logSubType){
		this.logSubType = logSubType;
	}
	public void addItems(Collection<? extends Goods> list, int mult){
		if(list != null){
			for(Goods goods : list){
				int value = goods.getNum();
				if(mult > 1){
					value *= mult;
				}
				addItem(goods.getType(), goods.getGoodsId(), value, goods.getLevel());
			}
		}
	}
	public void addItems(String items){
		List<List<Integer>> lists = XyStringUtil.parseLists(items, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
		for(List<Integer> list : lists){
			if(list.size() >= 4){
				addItem(list.get(0), list.get(1), list.get(2), list.get(3));
			}
		}
	}
	public void addItem(int type, int cfgId, int value1, int value2){
		if(value1 > 0){
			addValue(getItemEffect(type, cfgId), value1, value2);
		}
	}
	public void delItem(Object obj){
		if(obj instanceof UserHero){
			UserHero hero = (UserHero) obj;
			del(SystemConstant.ITEM_EFFECT_TYPE_HERO, hero.getHeroId(), hero.getId());
		}else if(obj instanceof UserEquipment){
			UserEquipment equip = (UserEquipment) obj;
			del(SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT, equip.getEquipmentId(), equip.getUserEquipmentId());
		}else if(obj instanceof UserEternal){
			UserEternal eternal = (UserEternal) obj;
			del(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL, eternal.getEternalId(), eternal.getUserEternalId());
		}else{
			throw new GameException();
		}
	}
	public void delItem(int type, int cfgId, int value){
		if(value > 0){
			if(cfgId > 0 && type != SystemConstant.ITEM_EFFECT_TYPE_PROP){
				cfgId = 0;
			}
			addValue(getItemEffect(type, cfgId), value, 0);
		}
	}
	public void delItem(String items){
		List<List<Integer>> lists = XyStringUtil.parseLists(items, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
		for(List<Integer> list : lists){
			if(list.size() >= 4){
				addItem(list.get(0), list.get(1), list.get(2), list.get(3));
			}
		}
	}
	private void del(int type, int cfgId, int id){
		ItemEffect item = getItemEffect(type, cfgId);
		item.del(id);
	}
	private Map<Integer, ItemEffect> getMap(int type){
		Map<Integer, ItemEffect> map = itemMap.get(type);
		if(map == null){
			map = new HashMap<>();
			itemMap.put(type, map);
		}
		return map;
	}
	private ItemEffect getItemEffect(int type, int cfgId){
		Map<Integer, ItemEffect> map = getMap(type);
		ItemEffect item = map.get(cfgId);
		if(item == null){
			item = new ItemEffect();
			item.setType(type);
			item.setLogSubType(logSubType);
			item.setId(cfgId);
			map.put(cfgId, item);
		}
		return item;
	}
	private void addValue(ItemEffect effect, int value1, int value2){
		effect.setValue1(effect.getValue1() + value1);
		if(effect.getValue2() < value2){
			effect.setValue2(value2);
		}
	}

}
