package com.ks.action.game;

import com.ks.protocol.vo.user.ViewUserVO;
import com.ks.rpc.Async;


public interface GameFightAction {
	/**
	 * 申请战斗
	 * @param userId 申请人编号
	 * @param againstUserUId 申请人编号   
	 * @param viewUser 用户基本信息
	 */
	void againstFight(int userId,String againstUserUId,ViewUserVO viewUser);
	/**
	 * 取消战斗
	 * @param sessionId 会话编号
	 */
	void cancelFight(String sessionId);
	
	/**
	 * 同意战斗
	 * @param sessionId
	 */
	void agreedFight(String sessionId);
	/**
	 * 执行战斗AI
	 * @param userId
	 */
	@Async
	void execFightAI(String sessionId);
}
