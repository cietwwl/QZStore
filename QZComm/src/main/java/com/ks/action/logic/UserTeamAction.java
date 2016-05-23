package com.ks.action.logic;

import com.ks.protocol.vo.user.UserTeamVO;
/**
 * 用户队伍
 * @author ks
 */
public interface UserTeamAction {
	
	/**
	 * 查询用户队伍
	 * @param userId 用户编号
	 * @return 用户队伍
	 */
	UserTeamVO queryUserTeam(int userId);
	/**
	 * 修改用户队伍
	 * @param userId 用户编号
	 * @param vo 要修改的数据
	 */
	void updateUserTeam(int userId,UserTeamVO vo);
}
