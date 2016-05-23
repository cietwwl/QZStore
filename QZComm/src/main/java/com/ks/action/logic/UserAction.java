package com.ks.action.logic;

import com.ks.db.model.User;
import com.ks.rpc.Async;

public interface UserAction {
	/**
	 * 在线用户统计
	 * @param amount 人数
	 * @param time 当前秒数
	 */
	@Async
	void onlineReport(int amount, int time);

	/**
	 * 查找渠道玩家
	 * @param username
	 * @param partner
	 * @return
	 */
	User findUserByUsername(String username, int partner);
	
	/**
	 * 查找渠道玩家ID
	 * @param username
	 * @param partner
	 * @return
	 */
	int findUserIdByUsername(String username, int partner);
}
                                                  