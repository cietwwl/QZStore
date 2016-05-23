package com.ks.game.handler;

import java.util.List;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.PropCMD;
import com.ks.protocol.vo.prop.SellPropVO;
import com.ks.util.LockKeyUtil;

/**
 * 用户道具
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.USER_PROP)
public class UserPropHandler extends ActionAdapter {
	/**
	 * 使用道具
	 * @param handler
	 * @param propId 道具编号
	 */
	@SubCmd(subCmd=PropCMD.USE_PROP,args={"int","int"})
	public void useProp(GameHandler handler, int propId, int amount){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userPropAction().useProp(player.getUserId(), propId, amount));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 出售道具
	 * @param userId 用户编号
	 * @param props 出售的道具
	 */
	@SubCmd(subCmd=PropCMD.SELL_PROP,args={"sellProp_true"})
	public void sellProp(GameHandler handler,List<SellPropVO> sellProps){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userPropAction().sellProp(handler.getPlayer().getUserId(), sellProps);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 开启宝箱
	 * @param handler
	 * @param propId
	 */
	@SubCmd(subCmd=PropCMD.OPEN_BOX, args={"int"})
	public void openBox(GameHandler handler, int propId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userPropAction().openBox(player.getUserId(), propId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
