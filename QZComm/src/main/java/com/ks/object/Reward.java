package com.ks.object;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ks.constant.SystemConstant;
import com.ks.protocol.vo.equment.UserEquipmentVO;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.hero.UserHeroVO;
import com.ks.protocol.vo.prop.UserPropVO;

@Data
public class Reward {
	private int gold;
	private int exp;
	private int slate;
	private int smeltingPoint;
	private int heroExp;
	private List<UserHeroVO> heros = new ArrayList<UserHeroVO>();
	private List<UserPropVO> props = new ArrayList<UserPropVO>();
	private List<UserEquipmentVO> equips = new ArrayList<UserEquipmentVO>();
	private List<UserEternalVO> eternals = new ArrayList<UserEternalVO>();
	
	public void setValue(int effectType, int value){
		switch(effectType){
			case SystemConstant.ITEM_EFFECT_TYPE_GOLD:
				gold = value;
				break;
			case SystemConstant.ITEM_EFFECT_TYPE_EXP:
				exp = value;
				break;
			case SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT:
				smeltingPoint = value;
				break;
			case SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL:
				heroExp = value;
				break;
		}
	}
	
	public int getValue(int effectType){
		switch(effectType){
			case SystemConstant.ITEM_EFFECT_TYPE_GOLD:
				return gold;
			case SystemConstant.ITEM_EFFECT_TYPE_EXP:
				return exp;
			case SystemConstant.ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT:
				return smeltingPoint;
			case SystemConstant.ITEM_EFFECT_TYPE_HERO_EXP_POOL:
				return heroExp;
		}
		return 0;
	}
}
