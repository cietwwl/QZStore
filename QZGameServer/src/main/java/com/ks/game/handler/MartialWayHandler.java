package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.model.martial.MartialWay;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.MartialWayCMD;
import com.ks.util.LockKeyUtil;
/**
 * 武道大会
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.MARTIAL_WAY)
public class MartialWayHandler extends ActionAdapter {
	/**
	 * 进入武道大会
	 * @param userId
	 * @return
	 */
	@SubCmd(subCmd=MartialWayCMD.ENTER_MARTIAL_WAY)
	public void 	enterMartialWay(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), martialWayAction().enterMartialWay(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 匹配
	 * @param handler
	 */
	@SubCmd(subCmd=MartialWayCMD.MACH)
	public void mach(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			MartialWay way = martialWayAction().mach(handler.getPlayer().getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
			worldMartialWayAction().match(way);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 取消匹配
	 * @param handler
	 */
	@SubCmd(subCmd=MartialWayCMD.CANCEL_MATCH)
	public void cancelMatch(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			worldMartialWayAction().cancelMatch(handler.getPlayer().getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 购买次数
	 * @param handler
	 */
	@SubCmd(subCmd=MartialWayCMD.BUY_COUNT)
	public void buyMartialWayCount(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			martialWayAction().buyMartialWayCount(handler.getPlayer().getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得武道大会用户
	 * @param handler
	 */
	@SubCmd(subCmd=MartialWayCMD.GAIN_MARTIAL_WAY_USER,args={"int"})
	public void gainMartialWayUser(GameHandler handler,int userId) {
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), martialWayAction().gainMartialWayUser(userId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得武道大会排名
	 * @param handler
	 */
	@SubCmd(subCmd=MartialWayCMD.GET_MARTIAL_WAY_RANK,args={"int"})
	public void getMartialWayRank(GameHandler handler,int page) {
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), martialWayAction().getMartialWayRank(handler.getPlayer().getUserId(),page));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获取武道大会奖励
	 * @param handler
	 */
	@SubCmd(subCmd=MartialWayCMD.GET_MARTIAL_WAY_FIGHT_AWARD)
	public void getMartialWayFightAward(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), worldFightAction().getFightRes(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
