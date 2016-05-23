package com.ks.game.handler;

import java.util.ArrayList;
import java.util.List;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FriendCMD;
import com.ks.util.LockKeyUtil;

/**
 * 好友
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.FRIEND)
public class FriendHandler extends ActionAdapter{
	/**
	 * 获得好友
	 * @param handler 用户编号
	 * @return 所有好友
	 */
	@SubCmd(subCmd=FriendCMD.GAIN_FRIENDS)
	public void  gainFriends(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().gainFriends(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得好友请求
	 * @param handler 用户编号
	 * @return 请求用户基本信息
	 */
	@SubCmd(subCmd=FriendCMD.GAIN_FRIEND_APPLY)
	public void   gainFriendApply(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().gainFriendApply(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 申请好友
	 * @param handler 用户编号
	 * @param playerName 玩家玩家名
	 */
	@SubCmd(subCmd=FriendCMD.APPLY_FRIEND,args={"String"})
	public void  applyFriend(GameHandler handler,String playerName){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			friendAction().applyFriend(handler.getPlayer().getUserId(),playerName);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 同意申请
	 * @param handler 用户编号
	 * @param applyUserId 申请好友编号
	 * @return 添加的好友
	 */
	@SubCmd(subCmd=FriendCMD.AGREE_APPLY,args={"int"})
	public void  agreeApply(GameHandler handler,int applyUserId){
		Player player = handler.getPlayer();
		List<String> keys = new ArrayList<String>();
		keys.add(LockKeyUtil.getUserLockKey(player.getUserId()));
		keys.add(LockKeyUtil.getUserLockKey(applyUserId));
		ClientLockManager.lock(keys);
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().agreeApply(handler.getPlayer().getUserId(),applyUserId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 删除申请
	 * @param handler 用户编号
	 * @param applyUserId 申请用户编号
	 */
	@SubCmd(subCmd=FriendCMD.DELETE_APPLY,args={"int_true"})
	public void   deleteApply(GameHandler handler,List<Integer> applyUserId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			friendAction().deleteApply(handler.getPlayer().getUserId(),applyUserId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 删除好友
	 * @param handler 用户编号
	 * @param friendId 好友编号
	 */
	@SubCmd(subCmd=FriendCMD.DELETE_FRIEND,args={"int"})
	public void   deleteFriend(GameHandler handler,int friendId){
		Player player = handler.getPlayer();
		List<String> keys = new ArrayList<String>();
		keys.add(LockKeyUtil.getUserLockKey(player.getUserId()));
		keys.add(LockKeyUtil.getUserLockKey(friendId));
		ClientLockManager.lock(keys);
		try{
			friendAction().deleteFriend(handler.getPlayer().getUserId(),friendId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 赠送体力
	 * @param handler 用户编号
	 * @param friendId 好友编号
	 */
	@SubCmd(subCmd=FriendCMD.GIVING_STAMINA,args={"int_true"})
	public void   givingStamina(GameHandler handler,List<Integer> friendIds){
		Player player = handler.getPlayer();
		List<String> keys = new ArrayList<String>();
		keys.add(LockKeyUtil.getUserLockKey(player.getUserId()));
		keys.addAll(LockKeyUtil.getUserLockKeys(friendIds));
		ClientLockManager.lock(keys);
		try{
			friendAction().givingStamina(handler.getPlayer().getUserId(),friendIds);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 收取体力
	 * @param handler 用户编号
	 * @param friendId 好友编号
	 */
	@SubCmd(subCmd=FriendCMD.COLLECT_STAMINA,args={"int_true"})
	public void  collectStamina(GameHandler handler,List<Integer> friendIds){
		Player player = handler.getPlayer();
		List<String> keys = new ArrayList<String>();
		keys.add(LockKeyUtil.getUserLockKey(player.getUserId()));
		keys.addAll(LockKeyUtil.getUserLockKeys(friendIds));
		ClientLockManager.lock(keys);
		try{
			friendAction().collectStamina(handler.getPlayer().getUserId(),friendIds);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得推荐好友
	 * @param handler 用户编号
	 * @return 推荐好友
	 */
	@SubCmd(subCmd=FriendCMD.GAIN_FRIEND_RECO)
	public void  gainFriendReco(GameHandler handler){
		Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().gainFriendReco(handler.getPlayer().getUserId()));
	}
	
	/**
	 * 刷新推荐好友
	 * @param handler 用户编号
	 * @return 推荐好友
	 */
	@SubCmd(subCmd=FriendCMD.REF_FRIEND_RECO)
	public void   refFriendReco(GameHandler handler){
		Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().refFriendReco(handler.getPlayer().getUserId()));
	}
	
	/**
	 * 获得战斗好友
	 * @param userId 用户编号
	 * @return 战前好友
	 */
	@SubCmd(subCmd=FriendCMD.GET_BATTLE_FRIEND)
	public void getBattleFriend(GameHandler handler){
		Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().getBattleFriend(handler.getPlayer().getUserId()));
	}
	
	/**
	 * 领取雇佣GP
	 * @param userId 用户编号
	 * @return 获得的雇佣GP
	 */
	@SubCmd(subCmd=FriendCMD.RECEIVE_HIRE_GP)
	public void receiveHireGp(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),friendAction().receiveHireGp(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
}
