package com.ks.game.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.exceptions.GameException;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.FightCMD;
import com.ks.protocol.vo.fight.AttackRoundVO;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.util.LockKeyUtil;

@MainCmd(mainCmd=MainCMD.FIGHT)
public class FightHandler extends ActionAdapter{
	/**
	 * 移动
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.MOVE,args={"move"})
	public void move(GameHandler handler,MoveVO move){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			List<AttackRoundVO> rounds = fightAction().move(handler.getPlayer().getUserId(), move);
			if(rounds != null){
				Application.sendMessage(handler.getChannel(), handler.getHead(),rounds);
			}
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得战斗奖励
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.GAIN_FIGHT_AWARD)
	public void gainFightAward(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					fightAction().gainFightAward(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 放弃战斗
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.GIVE_UP_FIGHT)
	public void giveUpFight(GameHandler handler) {
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			int userId = handler.getPlayer().getUserId();
			userId = fightAction().giveUpFight(userId);
			if(userId != 0){
				Application.sendMessage(handler.getChannel(),
						handler.getHead(), 
						userId);
			}
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 释放技能
	 * @param handler
	 * @param fightId 战斗编号
	 */
	@SubCmd(subCmd=FightCMD.RELEASE_SKILL,args={"int"})
	public void releaseSkill(GameHandler handler,int fightId) {
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			int userId = handler.getPlayer().getUserId();
			AttackRoundVO round = fightAction().releaseSkill(userId, fightId);
			if(round!=null){
				Application.sendMessage(handler.getChannel(),handler.getHead(),round);
			}
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 托管
	 * @param userId 用户编号
	 */
	@SubCmd(subCmd=FightCMD.HOSTING)
	public void hosting(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					fightAction().hosting(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 获得战斗
	 * @param userId 用户编号
	 */
	@SubCmd(subCmd=FightCMD.GAIN_FIGHT)
	public void gainFight(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					fightAction().gainFight(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 申请战斗
	 * @param handler
	 * @param againstUserId 申请人编号
	 */
	@SubCmd(subCmd=FightCMD.AGAINST_FIGHT,args={"int"})
	public void againstFight(GameHandler handler,int againstUserId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			if(!loginAction().isOnline(againstUserId)){
				throw new GameException(GameException.CODE_对方不在线, "");
			}
			fightAction().againstFight(handler.getPlayer().getUserId(), againstUserId);
			
			player.setAgainstUserId(againstUserId);
			player.setAgainstType(SystemConstant.FIGHT_AGAINST_TYPE_发起者);
			player.setAgainstTime(new Date());
			
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 取消战斗
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.CANCEL_FIGHT)
	public void cancelFight(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			fightAction().cancelFight(handler.getPlayer().getUserId());
			player.setAgainstUserId(0);
			player.setAgainstType(0);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 同意战斗
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.AGREED_FIGHT)
	public void agreedFight(GameHandler handler){
		Player player = handler.getPlayer();
		List<String> keys = new ArrayList<>();
		keys.add(LockKeyUtil.getUserLockKey(player.getAgainstUserId()));
		keys.add(LockKeyUtil.getUserLockKey(player.getUserId()));
		ClientLockManager.lock(keys);
		try{
			if(player.getAgainstType() == SystemConstant.FIGHT_AGAINST_TYPE_发起者){
				throw new GameException(GameException.CODE_参数错误, "");
			}
			if(player.getAgainstUserId() == 0){
				throw new GameException(GameException.CODE_战斗已取消, "");
			}else if(player.getAgainstTime().getTime()+30*1000L<System.currentTimeMillis()){
				throw new GameException(GameException.CODE_战斗已取消, "");
			}
			fightAction().startOnlinePVPFight(player.getAgainstUserId(), player.getUserId(),SystemConstant.FIGHT_TYPE_ONLINE_PVP,0);
			
			worldFightAction().cancelFight(player.getAgainstUserId() );
			player.setAgainstUserId(0);
			player.setAgainstType(0);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 战场复活
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.FIGHT_REVIVE)
	public 	void fightRevive(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),fightAction().fightRevive(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 准备就绪
	 * @param handler
	 */
	@SubCmd(subCmd=FightCMD.START_ONLINE_FIGHT_READY)
	public void ready(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			worldFightAction().ready(handler.getPlayer().getUserId());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 扫荡
	 * @param handler
	 * @param battleId
	 * @param count
	 */
	@SubCmd(subCmd=FightCMD.SWEEP,args={"int","int"})
	public void  sweep(GameHandler handler, int battleId, int count) {
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(), 
					fightAction().sweep(handler.getPlayer().getUserId(), battleId, count));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 观战
	 * @param handler
	 * @param fightId
	 */
	@SubCmd(subCmd=FightCMD.WATCH,args={"String"})
	public void watch(GameHandler handler, String fightId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(),
					handler.getHead(),
					fightAction().watch(player.getUserId(), fightId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
}
