package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.eternal.UserEternalVO;
import com.ks.protocol.vo.prop.EternalSmeltingVO;
import com.ks.protocol.vo.prop.SmeltingVO;

public interface UserEternalAction {
	
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
	void wearEternal(int userId,int userEternalId,int userHeroId);
	/**
	 * 拆下武魂
	 * @param userId 用户编号
	 * @param userHeroId 英雄编号
	 * @param retain 是否保留
	 */
	void disEternal(int userId,int userHeroId,boolean retain);
	
	
	/**
	 * 获得熔炼
	 * @param userId 用户编号
	 * @return 熔炼
	 */
	List<EternalSmeltingVO> gainEternalSmeltings(int userId);
	/**
	 * 熔炼
	 * @param userId 用户编号
	 * @param type 类型
	 * @param userHeroIds 要熔炼的英雄
	 * @return 熔炼后的数据
	 */
	SmeltingVO eternal(int userId,int type,
			List<Integer> equipmentIds,List<Integer> eternalIds);
	
	/**
	 * 开炉
	 * @param userId 用户编号
	 * @param type 要开的炉子
	 * @return 获得的物品
	 */
	UserEternalVO blowing(int userId,int type);
	/**
	 * 出售武魂
	 * @param userId 用户编号
	 * @param userEternalId 武魂编号
	 */
	void sellEternal(int userId,int userEternalId);
}
