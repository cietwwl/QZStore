package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.UserBuffCMD;
import com.ks.util.LockKeyUtil;

@MainCmd(mainCmd=MainCMD.USER_BUFF)
public class UserBuffHandler extends ActionAdapter{
	/**
	 * 获得用户buff
	 * @param handler
	 */
	@SubCmd(subCmd=UserBuffCMD.GAIN_USER_BUFF)
	public void gainUserBuffs(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userBuffAction().gainUserBuffs(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
