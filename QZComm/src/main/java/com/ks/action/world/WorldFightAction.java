package com.ks.action.world;

import com.ks.protocol.Message;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.user.ViewUserVO;
import com.ks.rpc.Async;

/**
 * 
 * @author ks
 */
public interface WorldFightAction {
	/**
	 * 申请战斗
	 * @param userId 申请人编号
	 * @param againstUserId 被申请人编号
	 * @param viewUser 申请人信息
	 */
	@Async
	void againstFight(int userId,int againstUserId,ViewUserVO viewUser);
	/**
	 * 取消战斗
	 * @param againstUserId 被请求人编号
	 */
	@Async
	void cancelFight(int againstUserId);
	/**
	 * 同意战斗
	 * @param userId
	 */
	@Async
	void agreedFight(int userId);
	/**
	 * 在线战斗动作
	 * @param battleId 战斗编号
	 * @param nextShotUserId 下一个出手用户编号
	 * @param head 包头
	 * @param rounds 回合数据
	 * @param end 是否结束
	 */
	@Async
	void onlineFightAction(String battleId,int nextShotUserId,Head head,Object rounds,boolean end);
	
	/**
	 * 放弃战斗
	 * @param battleId
	 * @param userId
	 */
	@Async
	void giveUpFight(String battleId,int userId);
	/**
	 * 战斗准备就绪
	 * @param userId
	 */
	@Async
	void ready(int userId);
	
	/**
	 * 准备
	 * @param userId
	 * @return
	 */
	boolean ready(String fightId,int userId);
	/**
	 * 托管战斗
	 * @param userId
	 */
	@Async
	void hostingFight(int userId);
	/**
	 * 获得战斗结果
	 * @param userId
	 * @return
	 */
	Message getFightRes(int userId);
	
	/**
	 * 
	 * @param userId
	 */
	void checkFight(int userId);
	
	/**
	 * 观战
	 * @param userId
	 * @param fightId
	 */
	@Async
	void watch(int userId, String fightId);
}
