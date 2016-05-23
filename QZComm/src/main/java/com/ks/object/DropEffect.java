package com.ks.object;

import java.util.List;

import com.ks.constant.SystemConstant;
import com.ks.util.MathUtil;

public class DropEffect {
	private int amount;   //获得数量（-1为全随机）
	private int probability;  //分组概率
	private List<ItemEffect> items;  //分组内可能道具
	
	public DropEffect(int amount, int probability, List<ItemEffect> items){
		this.amount = amount;
		this.probability = probability;
		this.items = items;
	}
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}
	public int getProbability(){
		return probability;
	}
	public void setProbability(int probability){
		this.probability = probability;
	}
	public List<ItemEffect> getItems(){
		return items;
	}
	public void setItems(List<ItemEffect> items){
		this.items = items;
	}
	public int getItemSize(int type){
		int size = 0;
		for(ItemEffect effect : items){
			if(effect.getType() == type){
				if(type == SystemConstant.ITEM_EFFECT_TYPE_PROP){
					size ++;
				}else{
					size += effect.getValue1();
				}
			}
		}
		return size > amount ?  amount : size;
	}
	public boolean isDrop(){
		boolean drop = probability == SystemConstant.PERCENT_BASE_INT;
		if(!drop){
			drop = MathUtil.nextInt(SystemConstant.PERCENT_BASE_INT) < probability;
		}
		return drop;
	}

}
