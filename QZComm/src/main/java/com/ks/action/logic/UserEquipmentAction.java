package com.ks.action.logic;

import java.util.List;

public interface UserEquipmentAction {
	
	/**
	 * 升级装备
	 * @param userId 用户编号
	 * @param userEquipmentId 装备编号
	 * @param type(1普通，2一键)
	 */
	int levelUpEquipment(int userId,int userEquipmentId, int type);
	/**
	 * 出售装备
	 * @param userId 用户编号
	 * @param equipments 要出售的装备
	 */
	void sellEquipment(int userId,List<Integer> equipments);
	/**
	 * 使用装备
	 * @param userId 用户编号
	 * @param userEquipmentId 装备编号
	 * @param userHeroId 英雄编号
	 */
	void useEquipment(int userId,int userEquipmentId,int userHeroId);
}
