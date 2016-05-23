package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.AchieveCMD;
import com.ks.util.LockKeyUtil;

@MainCmd(mainCmd=MainCMD.ACHIEVE)
public class AchieveHandler extends ActionAdapter{
	
	/**
	 * 查询所有成就
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=AchieveCMD.QUERY_USER_ACHIEVE)
	public void queryUserAchieve(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userAchieveAction().queryUserAchieve(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得奖励
	 * @param handler 用户编号
	 * @param achieveId 成就编号
	 */
	@SubCmd(subCmd=AchieveCMD.GAIN_ACHIEVE_AWARD,args={"int"})
	public void gainAchieveAward(GameHandler handler,int achieveId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userAchieveAction().gainAchieveAward(player.getUserId(),achieveId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
}
