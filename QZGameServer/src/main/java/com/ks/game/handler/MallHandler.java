package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.MallCMD;
import com.ks.util.LockKeyUtil;

/**
 * 商城
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.MALL)
public class MallHandler extends ActionAdapter{
	/**
	 * 获得商城
	 * @param handler
	 */
	@SubCmd(subCmd=MallCMD.GAIN_MALL)
	public void gainMall(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), mallAction().gainMall());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 购买
	 * @param handler 用户编号
	 * @param id 商城编号
	 * @param num 数量
	 * @return 获得的道具
	 */
	@SubCmd(subCmd=MallCMD.BUY,args={"int","int"})
	public void buy(GameHandler handler,int id,int num){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), mallAction().buy(player.getUserId(), id,num));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 刷新黑市
	 * @param handler
	 */
	@SubCmd(subCmd=MallCMD.RANDOM_BLACKMARKET_GOODS)
	public void refreshBlackMarket(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			mallAction().refreshBlackMarket(player.getUserId(), false);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
