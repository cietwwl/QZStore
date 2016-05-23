package com.ks.logic.service;

import java.util.Collection;
import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.User;
import com.ks.db.model.UserProp;
import com.ks.protocol.vo.prop.SellPropVO;
import com.ks.protocol.vo.reward.RewardVO;

/**
 * 用户道具服务
 * @author ks
 */
public interface UserPropService {
	
	/**
	 * 更新道具
	 * @param userId
	 * @param prop
	 * @param type(DB操作,0为不操作,1为insert,2为update)
	 */
	@Transaction
	void updateProp(User user, UserProp prop, int type);
	
	/**
	 * 获取玩家道具
	 * @param user
	 */
	UserProp getUserPropByPropId(User user, int propId);
	
	/**
	 * 获取玩家道具
	 * @param user
	 */
	UserProp getUserPropById(User user, int id);
	
	/**
	 * 加载道具
	 * @param user
	 * @return
	 */
	int getPropAmount(User user, int propId);
	
	/**
	 * 获取空格子
	 * @param user
	 * @return
	 */
	UserProp popEmptyUserProp(User user);
	
	/**
	 * 初始化道具
	 * @param userId 用户编号
	 * @return 所有道具
	 */
	@Transaction
	Collection<UserProp> initProps(int userId);

	/**
	 * 使用道具
	 * @param userId 用户编号
	 * @param propId 道具编号
	 * @return 受影响道具
	 */
	@Transaction
	UserProp useProp(int userId, int propId, int amount);
	
	/**
	 * 出售道具
	 * @param userId 用户编号
	 * @param props 出售的道具
	 */
	@Transaction
	void sellProp(int userId,List<SellPropVO> sellProps);
	
	/**
	 * 开启宝箱
	 */
	@Transaction
	RewardVO openBox(int userId, int propId);
	
}
