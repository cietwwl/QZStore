package com.ks.logic.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.ks.access.Transaction;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;

/**
 * 用户装备服务
 * @author ks
 */
public interface UserEquipmentService {
	
	/**
	 * 删除装备
	 * @param user
	 * @param userEquipId
	 */
	@Transaction
	void deleteEquip(User user, int userEquipId);
	/**
	 * 更新用户装备
	 * @param userId
	 * @param list
	 */
	@Transaction
	void updateUserEquipments(User user, List<UserEquipment> list, boolean updatedb);
	/**
	 * 更新用户装备
	 * @param userId
	 * @param list
	 */
	@Transaction
	void updateUserEquipment(User user, UserEquipment equip, boolean updatedb);
	
	/**
	 * 获取用户所有装备
	 * @param user
	 * @return
	 */
	Collection<UserEquipment> getUserEquipments(User user);
	
	/**
	 * 获取用户装备
	 * @param user
	 * @param userEquipmentId
	 * @return
	 */
	UserEquipment getUserEquipment(User user, int userEquipmentId);
	
	/**
	 * 获取适用伙伴的装备
	 * @param user
	 * @param userHeroId
	 * @return
	 */
	Set<UserEquipment> getUserEquipmentByHero(User user, int userHeroId);
	/**
	 * 初始化用户装备
	 * @param userId 用户编号
	 * @return 用户装备
	 */
	Collection<UserEquipment> initUserEquipment(int userId);

	/**
	 * 升级装备
	 * @param userId 用户编号
	 * @param userEquipmentId 装备编号
	 * @param 升级类型（1普通，2一键）
	 */
	@Transaction
	int levelUpEquipment(int userId, int userEquipmentId, int type);
	/**
	 * 出售装备
	 * @param userId 用户编号
	 * @param equipments 要出售的装备
	 */
	@Transaction
	void sellEquipment(int userId,List<Integer> equipments);
	
	/**
	 * 使用装备
	 * @param userId 用户编号
	 * @param userEquipmentId 装备编号
	 * @param userHeroId 英雄编号
	 */
	@Transaction
	void useEquipment(int userId,int userEquipmentId,int userHeroId);
}
