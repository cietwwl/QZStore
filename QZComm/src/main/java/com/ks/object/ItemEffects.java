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
	private boolean dbUp = false;  //更新数据库
	private Map<Integer, Map<Integer, ItemEffect>> itemMap = new HashMap<Integer, Map<Integer,ItemEffect>>();
	public ItemEffects(int logSubType){
		this.logSubType = logSubType;
	}
	public void appendGoods(Collection<? extends Goods> list, int mult){
		if(list != null){
			for(Goods goods : list){
				int value = goods.getNum();
				if(mult > 1){
					value *= mult;
				}
				appendItem(goods.getType(), goods.getGoodsId(), value, goods.getLevel());
			}
		}
	}
	public void appendStrs(String items){
		List<List<Integer>> lists = XyStringUtil.parseLists(items, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
		for(List<Integer> list : lists){
			if(list.size() >= 4){
				appendItem(list.get(0), list.get(1), list.get(2), list.get(3));
			}
		}
	}
	public void appendItem(int type, int cfgId, int value1, int value2){
		if(value1 > 0 && value2 >= 0){
			ItemEffect effect = getItemEffect(type, cfgId);
			effect.setValue1(effect.getValue1() + value1);
			if(effect.getValue2() < value2){
				effect.setValue2(value2);
			}
		}
	}
	public void appendDelObj(Object obj){
		if(obj instanceof UserHero){
			UserHero hero = (UserHero) obj;
			ItemEffect item = getItemEffect(SystemConstant.ITEM_EFFECT_TYPE_HERO, hero.getHeroId());
			item.del(hero.getId());
		}else if(obj instanceof UserEquipment){
			UserEquipment equip = (UserEquipment) obj;
			ItemEffect item = getItemEffect(SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT, equip.getEquipmentId());
			item.del(equip.getUserEquipmentId());
		}else if(obj instanceof UserEternal){
			UserEternal eternal = (UserEternal) obj;
			ItemEffect item = getItemEffect(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL, eternal.getEternalId());
			item.del(eternal.getUserEternalId());
		}else{
			throw new GameException();
		}
	}
	private ItemEffect getItemEffect(int type, int cfgId){
		Map<Integer, ItemEffect> map = itemMap.get(type);
		if(map == null){
			map = new HashMap<>();
			itemMap.put(type, map);
		}
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

}
