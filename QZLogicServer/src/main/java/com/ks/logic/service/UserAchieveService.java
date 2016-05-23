package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.UserAchieve;
import com.ks.protocol.vo.goods.GainGameAwardVO;

/**
 * 用户成就
 * @author ks
 */
public interface UserAchieveService {
	/**
	 * 查询所有用户成就
	 * @param userId 用户编号
	 * @return 用户成就
	 */
	List<UserAchieve> queryUserAchieve(int userId);
	/**
	 * 增加成就数量
	 * @param userId 用户编号
	 * @param achieveType 成就类型
	 * @param assId 关联编号
	 * @param num 增加数量
	 */
	@Transaction
	void addAchieveNum(int userId,int achieveType,int assId,int num);
	/**
	 * 获得奖励
	 * @param userId 用户编号
	 * @param achieveId 成就编号
	 * @return 奖励
	 */
	@Transaction
	GainGameAwardVO gainAchieveAward(int userId,int achieveId);
}