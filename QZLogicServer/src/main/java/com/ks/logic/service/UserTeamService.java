package com.ks.logic.service;

import com.ks.access.Transaction;
import com.ks.db.model.UserTeam;
import com.ks.protocol.vo.user.UserTeamVO;

/**
 * 用户队伍服务
 * @author ks
 */
public interface UserTeamService {
	/**
	 * 查询用户队伍
	 * @param userId 用户编号
	 * @return 用户队伍
	 */
	@Transaction
	UserTeam queryUserTeam(int userId);
	
	/**
	 * 修改用户队伍
	 * @param userId 用户编号
	 * @param vo 要修改的数据
	 */
	@Transaction
	void updateUserTeam(int userId,UserTeamVO vo);
}
