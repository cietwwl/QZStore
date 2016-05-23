package com.ks.object;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ks.constant.SystemConstant;

/**
 * 道具效果
 *
 */
@Data
public class ItemEffect{
	private int type;
	private int id;
	private int value1;
	private int value2;
	private int probability = SystemConstant.PERCENT_BASE_INT;  //道具掉落概率
	private int addition;      //基数为10000
	private int logSubType;  //日志小类型
	private List<Integer> removeIds;  //删除主键id
	
	public int getValue1(){
		if(addition > 0){
			return (int) (addition / SystemConstant.PERCENT_BASE_DOUBLE * value1) + value1;
		}
		return value1;
	}
	public List<Integer> getRemoveIds(){
		if(removeIds == null){
			return new ArrayList<>();
		}
		return removeIds;
	}
	public void del(int id){
		if(removeIds == null){
			removeIds = new ArrayList<>();
		}
		if(!removeIds.contains(id)){
			removeIds.add(id);
		}
	}
	public ItemEffect copy(){
		ItemEffect effect = new ItemEffect();
		effect.setType(type);
		effect.setId(id);
		effect.setValue1(value1);
		effect.setValue2(value2);
		effect.setProbability(probability);
		effect.setAddition(addition);
		effect.setLogSubType(logSubType);
		effect.setRemoveIds(removeIds);
		return effect;
	}
}
