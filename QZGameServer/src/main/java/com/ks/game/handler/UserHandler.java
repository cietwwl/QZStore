package com.ks.game.handler;

import java.util.Date;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.UserCMD;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.user.UserInfoVO;
import com.ks.util.LockKeyUtil;
/**
 * 用户
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.USER)
public class UserHandler extends ActionAdapter{
	/**
	 * 获取用户信息
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.GAIN_USER_INFO)
	public void gainUserInfo(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			UserInfoVO userInfo = playerAction().gainUserInfo(player.getUserId());
			Head head = handler.getHead();
			Application.sendMessage(handler.getChannel(), head, userInfo);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
		
	}
	/**
	 * 用户心跳
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.USER_HEART)
	public void userHeart(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Date now = new Date();
			Date lastHeartTime = player.getLastHeartTime();
			if(lastHeartTime == null){
				lastHeartTime = new Date(now.getTime() - Player.HEART_FREQUENCY);
			}
			if(lastHeartTime.getTime() + Player.HEART_FREQUENCY + 30000 >= now.getTime()){
				playerAction().heard(player.getUserId());
				player.setLastHeartTime(now);
				Head head = handler.getHead();
				Application.sendMessage(handler.getChannel(), head, now.getTime());
			}
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 获得用户简单信息
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.GAIN_USER_SIMPLE_INFO)
	public void gainUserSimpleInfo(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().gainUserSimpleInfo(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 查看用户
	 * @param handler 
	 * @param userId 要查看的用户
	 */
	@SubCmd(subCmd=UserCMD.VIEW_USER,args={"int"})
	public void viewUser(GameHandler handler,int userId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().viewUser(userId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得用户统计
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.GAIN_USER_STAT)
	public void gainUserStat(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().gainUserStat(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 领取登录奖励
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.DRAW_LOGIN_AWARDS)
	public void drawLoginAwards(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().drawLoginAwards(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 领取vip礼包
	 * @param handler 
	 * @param vipLevel 领取的vip等级礼包
	 */
	@SubCmd(subCmd=UserCMD.DRAW_VIP_GIFI,args={"int"})
	public void drawVIPGifi(GameHandler handler,int vipLevel){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().drawVIPGifi(player.getUserId(),vipLevel));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 修改剧情步骤
	 * @param handler
	 * @param plotStep
	 */
	@SubCmd(subCmd=UserCMD.UPDATE_PLOT_STEP,args={"int"})
	public void updatePlotStep(GameHandler handler,int plotStep){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().updatePlotStep(player.getUserId(),plotStep);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 修改新手步骤
	 * @param handler
	 * @param guideStep
	 */
	@SubCmd(subCmd=UserCMD.UPDATE_GUIDE_STEP,args={"int"})
	public void updateGuideStep(GameHandler handler,int guideStep){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().updateGuideStep(player.getUserId(),guideStep);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 获取引导
	 * @param handler
	 * @param guideStep
	 */
	@SubCmd(subCmd=UserCMD.UPDATE_GUIDE_STEP_LIST)
	public void getGuideSteps(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), playerAction().getGuideSteps(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	
	
	/**
	 * 购买金币
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.BUY_GOLD)
	public void buyGold(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().buyGold(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 购买体力
	 * @param handler
	 */
	@SubCmd(subCmd=UserCMD.BUY_STAMINA)
	public void buyStamina(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().buyStamina(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	
	/**
	 * 签到
	 * @param handler
	 * @param day
	 * @return
	 */
	@SubCmd(subCmd=UserCMD.SIGNIN,args={"int"})
	public void signin(GameHandler handler,int day){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().signin(player.getUserId(), day));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 领取累计签到奖励
	 * @param handler
	 * @param sumDay
	 * @return
	 */
	@SubCmd(subCmd=UserCMD.DRAW_SUM_SIGNIN,args={"int"})
	public void drawSumSignin(GameHandler handler,int sumDay){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), 
					playerAction().drawSumSignin(player.getUserId(), sumDay));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 修改功能解锁
	 * @param userId
	 * @param funUnlock
	 */
	@SubCmd(subCmd=UserCMD.UPDATE_FUN_UNLOCK,args={"int"})
	public void updateFunUnlock(GameHandler handler, int funUnlock) {
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().updateFunUnlock(player.getUserId(),funUnlock);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 升级名望
	 * @param userId
	 */
	@SubCmd(subCmd=UserCMD.LEVEL_UP_FAME)
	public void levelUpFame(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),playerAction().levelUpFame(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 领取石板
	 * @param userId
	 */
	@SubCmd(subCmd=UserCMD.GAIN_SLATE)
	public void  gainSlate(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().gainSlate(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 给玩家取名
	 * @param handler
	 * @param playerName
	 */
	@SubCmd(subCmd=UserCMD.USER_RENAME,args={"String"})
	public void givePlayerName(GameHandler handler,String playerName){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().givePlayerName(player.getUserId(), playerName);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 提升经验池上限
	 * @param handler
	 * @param times 提升次数
	 */
	@SubCmd(subCmd=UserCMD.INCRE_EXPPOOL,args={"int"})
	public void increExpPool(GameHandler handler, int times){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().increExpPool(player.getUserId(), times);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 提升容量池上限
	 * @param handler
	 * @param times 提升次数
	 */
	@SubCmd(subCmd=UserCMD.INCRE_ETERNALSMELTING,args={"int"})
	public void increEternalSmelting(GameHandler handler, int times){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			playerAction().increEternalSmelting(player.getUserId(), times);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
