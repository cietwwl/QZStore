package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.UserZoneCMD;
import com.ks.util.LockKeyUtil;

/**
 * 战斗
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.USER_ZONE)
public class UserZoneHandler extends ActionAdapter{
	
	/**
	 * 查询当前副本
	 * @param handler 用户编号
	 * @return 副本编号
	 */
	@SubCmd(subCmd=UserZoneCMD.QUERY_CURR_ZONE)
	public void queryCurrZone(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userZoneAction().queryCurrZone(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 进入副本
	 * @param handler 用户编号
	 * @param battleId 战场编号
	 * @return 战斗
	 */
	@SubCmd(subCmd=UserZoneCMD.INTO_ZONE,args={"int"})
	public void intoZone(GameHandler handler,int battleId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userZoneAction().intoZone(handler.getPlayer().getUserId(),
							battleId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 查询当前精英副本
	 * @param handler 用户编号
	 * @param battleId 战场编号
	 * @return 战斗
	 */
	@SubCmd(subCmd=UserZoneCMD.QUERY_CURR_ELITE_ZONE,args={"int"})
	public void queryCurrEliteZone(GameHandler handler,int zoneId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userZoneAction().queryCurrEliteZone(handler.getPlayer().getUserId(),
							zoneId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 查询所有活动副本
	 * @param handler 用户编号
	 * @return 所有可用的活动副本
	 */
	@SubCmd(subCmd=UserZoneCMD.QUERY_ACTIVITY_ZONES)
	public void queryActivityZones(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userZoneAction().queryActivityZones(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 查询用户副本战场
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	@SubCmd(subCmd=UserZoneCMD.QUERY_USER_ZONE_BATTLE,args={"int"})
	public void queryUserZoneBattle(GameHandler handler,int zoneId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userZoneAction().queryUserZoneBattle(handler.getPlayer().getUserId(),zoneId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 获得副本奖励
	 * @param userId
	 * @param zoneId
	 * @param star
	 * @return
	 */
	@SubCmd(subCmd=UserZoneCMD.GAIN_ZONE_AWARD,args={"int","int"})
	public void  gainZoneAward(GameHandler handler,int zoneId,int star){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					userZoneAction().gainZoneAward(handler.getPlayer().getUserId(),zoneId,star));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 获取试练副本
	 * @param handler
	 * @param zoneId
	 */
	@SubCmd(subCmd=UserZoneCMD.GAIN_TRIALS_ZONE, args={"int"})
	public void gainTrialZones(GameHandler handler, int zoneId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userZoneAction().gainTrialZones(player.getUserId(), zoneId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 刷新包子铺
	 * @param handler
	 */
	@SubCmd(subCmd=UserZoneCMD.REFRESH_BREAD_STORE)
	public void refreshBreadStore(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userZoneAction().refreshBreadStore(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
}
