package com.ks.logic.service;

import java.util.Collection;
import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.User;
import com.ks.db.model.UserEternal;
import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.prop.EternalSmeltingVO;
import com.ks.protocol.vo.prop.SmeltingVO;

/**
 * 武魂
 * @author ks
 */
public interface UserEternalService {
	
	/**
	 * 更新玩家武魂
	 * @param userId
	 * @param list
	 */
	@Transaction
	void updateUserEternals(User user, List<UserEternal> list, boolean updateDB);
	
	@Transaction
	void deleteUserEternal(User user, int userEternalId);

	
	/**
	 * 初始化武魂
	 * @param user
	 * @return
	 */
	Collection<UserEternal> initUserEternal(int userId);
	
	/**
	 * 获取武魂
	 * @param user
	 * @return
	 */
	Collection<UserEternal> getUserEternals(User user);
	
	/**
	 * 获取武魂
	 * @param user
	 * @param usereternalId
	 * @return
	 */
	UserEternal getUserEternal(User user, int usereternalId);
	
	/**
	 * 获得武魂
	 * @param userId 用户编号
	 * @return 武魂
	 */
	List<UserEternalVO> gainUserEternal(int userId);
	
	/**
	 * 穿戴武魂
	 * @param userId 用户编号
	 * @param userEternalId 用户武魂编号
	 * @param userHeroId 英雄编号
	 */
	@Transaction
	void wearEternal(int userId,int userEternalId,int userHeroId);
	/**
	 * 拆下武魂
	 * @param userId 用户编号
	 * @param userHeroId 英雄编号
	 * @param retain 是否保留
	 */
	@Transaction
	void disEternal(int userId,int userHeroId,boolean retain);
	
	
	/**
	 * 获得熔炼
	 * @param userId 用户编号
	 * @return 熔炼
	 */
	@Transaction
	List<EternalSmeltingVO> gainEternalSmeltings(int userId);
	/**
	 * 熔炼
	 * @param userId 用户编号
	 * @param type 类型
	 * @param equipmentIds 要熔炼的英雄
	 * @return 熔炼后的数据
	 */
	@Transaction
	SmeltingVO eternal(int userId,int type,List<Integer> equipmentIds,List<Integer> eternalIds);
	
	/**
	 * 开炉
	 * @param userId 用户编号
	 * @param type 要开的炉子
	 * @return 获得的物品
	 */
	@Transaction
	UserEternal blowing(int userId,int type);
	/**
	 * 出售武魂
	 * @param userId 用户编号
	 * @param userEternalId 武魂编号
	 */
	@Transaction
	void sellEternal(int userId,int userEternalId);
	/**
	 * 
	 * @param userId
	 * @return
	 */
//	@Transaction
//	List<EternalSmelting> gainEternalSmelting(int userId);
}
