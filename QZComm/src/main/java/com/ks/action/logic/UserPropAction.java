package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.prop.SellPropVO;
import com.ks.protocol.vo.prop.UserPropVO;
import com.ks.protocol.vo.reward.RewardVO;

public interface UserPropAction {
	
	/**
	 * 使用道具
	 * @param userId 用户编号
	 * @param propId 道具编号
	 * @return 受影响道具
	 */
	UserPropVO useProp(int userId,int propId, int amount);
	
	/**
	 * 出售道具
	 * @param userId 用户编号
	 * @param props 出售的道具
	 */
	void sellProp(int userId,List<SellPropVO> sellProps);
	
	/**
	 * 开启宝箱
	 * @param userId
	 * @param propId
	 * @return
	 */
	RewardVO openBox(int userId, int propId);
	
}
