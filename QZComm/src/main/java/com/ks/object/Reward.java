package com.ks.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.constant.SystemConstant;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.reward.ItemEffectVO;

public class Reward {
	private Map<Integer, List<ItemEffectVO>> map = new HashMap<>();
	
	public void addItemEffect(int type, int id, int value1, int value2){
		List<ItemEffectVO> list = map.get(type);
		if(list == null){
			list = new ArrayList<>();
			map.put(type, list);
		}
		boolean update = true;
		if(type != SystemConstant.ITEM_EFFECT_TYPE_HERO
				&& type != SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT
				&& type != SystemConstant.ITEM_EFFECT_TYPE_ETERNAL){
			for(ItemEffectVO vo : list){
				if(vo.getId() == id){
					update = false;
					vo.setValue1(vo.getValue1() + value1);
					vo.setValue2(vo.getValue2() + value2);
					break;
				}
			}
		}
		if(update){
			ItemEffectVO vo = MessageFactory.getMessage(ItemEffectVO.class);
			vo.init(type, id, value1, value2);
			list.add(vo);
		}
	}
	
	public List<ItemEffectVO> getItemEffects(){
		List<ItemEffectVO> list = new ArrayList<>();
		for(List<ItemEffectVO> vos : map.values()){
			list.addAll(vos);
		}
		return list;
	}
}
