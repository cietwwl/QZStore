package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.protocol.vo.friend.FriendApplyVO;
import com.ks.protocol.vo.friend.FriendRecoVO;
import com.ks.protocol.vo.friend.FriendVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public interface FriendService {
	/**
	 * 获得好友
	 * @param userId 用户编号
	 * @return 所有好友
	 */
	List<FriendVO> gainFriends(int userId);
	/**
	 * 获得好友请求
	 * @param userId 用户编号
	 * @return 请求用户基本信息
	 */
	List<FriendApplyVO> gainFriendApply(int userId);
	/**
	 * 申请好友
	 * @param userId 用户编号
	 * @param playerName 玩家玩家名
	 */
	@Transaction
	void applyFriend(int userId,String playerName);
	/**
	 * 同意申请
	 * @param userId 用户编号
	 * @param applyUserId 申请好友编号
	 * @return 添加的好友
	 */
	@Transaction
	FriendVO agreeApply(int userId,int applyUserId);
	/**
	 * 删除申请
	 * @param userId 用户编号
	 * @param applyUserId 申请用户编号
	 */
	@Transaction
	void deleteApply(int userId,List<Integer> applyUserId);
	/**
	 * 删除好友
	 * @param userId 用户编号
	 * @param friendId 好友编号
	 */
	@Transaction
	void deleteFriend(int userId,int friendId);
	/**
	 * 赠送体力
	 * @param userId 用户编号
	 * @param friendId 好友编号
	 */
	@Transaction
	void givingStamina(int userId,List<Integer> friendIdS);
	/**
	 * 收取体力
	 * @param userId 用户编号
	 * @param friendId 好友编号
	 */
	@Transaction
	void collectStamina(int userId,List<Integer> friendId);
	/**
	 * 获得推荐好友
	 * @param userId 用户编号
	 * @return 推荐好友
	 */
	@Transaction
	FriendRecoVO gainFriendReco(int userId);
	
	/**
	 * 刷新推荐好友
	 * @param userId 用户编号
	 * @return 推荐好友
	 */
	@Transaction
	FriendRecoVO refFriendReco(int userId);
	/**
	 * 获得战斗好友
	 * @param userId 用户编号
	 * @return 战前好友
	 */
	List<UserBaseinfoVO> getBattleFriend(int userId);
	/**
	 * 领取雇佣GP
	 * @param userId 用户编号
	 * @return 获得的雇佣GP
	 */
	@Transaction
	int receiveHireGp(int userId);
}
