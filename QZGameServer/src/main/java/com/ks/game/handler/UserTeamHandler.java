package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.UserTeamCMD;
import com.ks.protocol.vo.user.UserTeamVO;
import com.ks.util.LockKeyUtil;

/**
 * 用户队伍
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.USER_TEAM)
public class UserTeamHandler extends ActionAdapter {
	
	/**
	 * 查询用户队伍
	 * @param handler 用户编号
	 * @return 用户队伍
	 */
	@SubCmd(subCmd=UserTeamCMD.QUERY_USER_TEAM)
	public void queryUserTeam(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userTeamAction().queryUserTeam(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 修改用户队伍
	 * @param handler 用户编号
	 * @param vo 要修改的数据
	 */
	@SubCmd(subCmd=UserTeamCMD.UPDATE_USER_TEAM,args={"userTeam"})
	public void updateUserTeam(GameHandler handler,UserTeamVO vo){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userTeamAction().updateUserTeam(handler.getPlayer().getUserId(), vo);
			Application.sendMessage(handler.getChannel(),
					handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
