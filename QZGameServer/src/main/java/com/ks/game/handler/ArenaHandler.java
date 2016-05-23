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
import com.ks.protocol.sub.ArenaCMD;
import com.ks.util.LockKeyUtil;

@MainCmd(mainCmd=MainCMD.ARENA)
public class ArenaHandler extends ActionAdapter {
	
	/**
	 * 查询竞技场
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.QUERY_ARENA)
	public void queryArena(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), arenaAction().queryArena(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 竞技场战斗
	 * @param handler
	 * @param rivalUserId
	 */
	@SubCmd(subCmd=ArenaCMD.PLAY_ARENA,args={"int"})
	public void playArena(GameHandler handler,int rivalUserId){
		Player player = handler.getPlayer();
		List<String> keys = new ArrayList<String>();
		keys.add(LockKeyUtil.getUserLockKey(player.getUserId()));
		keys.add(LockKeyUtil.getUserLockKey(rivalUserId));
		ClientLockManager.lock(keys);
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), arenaAction().playArena(player.getUserId(),rivalUserId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 清除cd时间
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.CLEAR_CD_TIME)
	public void clearCdTime(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			arenaAction().clearCdTime(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 购买竞技场次数
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.ADD_ARENA_COUNT)
	public void buyArenaCount(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			arenaAction().buyArenaCount(player.getUserId());
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得竞技场排名
	 * @param type 排名类型
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.QUERY_ARENA_RANK,args={"int"})
	public void queryArenaRank(GameHandler handler,int type){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),arenaAction().queryArenaRank(type,player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 刷新对手
	 * @param userId 用户编号
	 * @return 刷新的对手
	 */
	@SubCmd(subCmd=ArenaCMD.REF_RIVAL)
	public void refRival(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),arenaAction().refRival(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 刷新商城
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.REF_SHOPPING)
	public void refShopping(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),arenaAction().RefreshShopping(player.getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 兑换商城物品
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.EXCHANGE_AWARD,args={"int"})
	public void exchangeAward(GameHandler handler,int shoppingId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),arenaAction().ExchangeAward(player.getUserId(), shoppingId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得竞技场排名
	 * @param type 排名类型
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.QUERY_ARENALOGGER,args={"int"})
	public void queryArenaLogger(GameHandler handler,int type){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),arenaAction().queryArenaLogger(player.getUserId(),type));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 获取竞技场奖励
	 * @param handler
	 */
	@SubCmd(subCmd=ArenaCMD.FIGHTING_AWARD)
	public void getMartialWayFightAward(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), fightAction().getFightRes(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
