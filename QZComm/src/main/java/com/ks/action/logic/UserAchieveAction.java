package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.achieve.UserAchieveVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;

public interface UserAchieveAction {
	
	/**
	 * 查询所有用户成就
	 * @param userId 用户编号
	 * @return 用户成就
	 */
	List<UserAchieveVO> queryUserAchieve(int userId);
	/**
	 * 获得奖励
	 * @param userId 用户编号
	 * @param achieveId 成就编号
	 * @return 奖励
	 */
	GainGameAwardVO gainAchieveAward(int userId,int achieveId);
}
