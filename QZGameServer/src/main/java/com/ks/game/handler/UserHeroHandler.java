package com.ks.game.handler;

import java.util.List;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.UserHeroCMD;
import com.ks.util.LockKeyUtil;

@MainCmd(mainCmd=MainCMD.USER_HERO)
public class UserHeroHandler extends ActionAdapter {
	
	/**
	 * 增加影响容量
	 * @param handler 用户编号
	 */
	@SubCmd(subCmd=UserHeroCMD.ADD_BACKAGE_CAPACITY,args={"int"})
	public void addBackageCapacity(GameHandler handler,int type){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userHeroAction().addBackageCapacity(handler.getPlayer().getUserId(),type);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 锁定英雄
	 * @param handler 用户编号
	 * @param userHeroId 用户英雄编号
	 */
	@SubCmd(subCmd=UserHeroCMD.LOCKED_HERO,args={"int"})
	public void lockedHero(GameHandler handler,int userHeroId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userHeroAction().lockedHero(handler.getPlayer().getUserId(), userHeroId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 解锁英雄
	 * @param handler 用户编号
	 * @param userHeroId 用户英雄编号
	 */
	@SubCmd(subCmd=UserHeroCMD.UN_LOCKED_HERO,args={"int"})
	public void unLockedHero(GameHandler handler,int userHeroId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userHeroAction().unLockedHero(handler.getPlayer().getUserId(), userHeroId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 升级英雄
	 * @param handler 用户编号
	 * @param userHeroId 要升级的英雄编号
	 * @param heros 升级材料
	 */
	@SubCmd(subCmd=UserHeroCMD.LEVEL_UP_HERO,args={"int","int"})
	public void levelUpHero(GameHandler handler,int userHeroId,int num){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),
					userHeroAction().levelUpHero(handler.getPlayer().getUserId(), userHeroId, num));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 英雄进化
	 * @param handler 用户编号
	 * @param evoId 进化编号
	 * @param userHeroId 要进化的战魂编号
	 * @return 操作结果
	 */
	@SubCmd(subCmd=UserHeroCMD.EVOLUTION_HERO,args={"int","int"})
	public void evolutionHero(GameHandler handler,int evoId,int userHeroId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),
					userHeroAction().evolutionHero(handler.getPlayer().getUserId(), evoId, userHeroId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/***
	 * 召唤英雄
	 * @param userId 用户编号
	 * @param type 类型
	 * @param num 数量
	 * @return 召唤到的英雄
	 */
	@SubCmd(subCmd=UserHeroCMD.CALL_HERO,args={"int","int"})
	public void callHero(GameHandler handler,int type,int num){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),
					userHeroAction().callHero(handler.getPlayer().getUserId(), type, num));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 出售英雄
	 * @param userId 用户编号
	 * @param sellHeros 出售英雄编号
	 */
	@SubCmd(subCmd=UserHeroCMD.SELL_HERO,args={"int_true"})
	public void sellHero(GameHandler handler,List<Integer> sellHeros){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userHeroAction().sellHero(handler.getPlayer().getUserId(), sellHeros);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
//	/**
//	 * 获得用户英雄图鉴
//	 * @param handler 用户编号
//	 * @return 图鉴
//	 */
//	@SubCmd(subCmd=UserHeroCMD.GAIN_USER_HERO_MAP)
//	public void gainUserHeroMap(GameHandler handler){
//		Player player = handler.getPlayer();
//		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
//		try{
//			Application.sendMessage(handler.getChannel(), handler.getHead(),
//					userHeroAction().gainUserHeroMap(handler.getPlayer().getUserId()));
//		}finally{
//			ClientLockManager.unlockThreadLock();
//		}
//	}
	/**
	 * 获得探索
	 * @param handler 用户编号
	 * @return 探索
	 */
	@SubCmd(subCmd=UserHeroCMD.GAIN_USER_EXPLORE)
	public void gainUserExplore(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),
					userHeroAction().gainUserExplore(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 开始探索
	 * @param handler 用户编号
	 * @param exploreId 探索编号
	 * @param exploreType 探索类型
	 * @param userHeroId 用户英雄编号
	 */
	@SubCmd(subCmd=UserHeroCMD.START_EXPLORE,args={"int","int","int"})
	public void startExplore(GameHandler handler,int exploreId,int exploreType,int userHeroId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userHeroAction().startExplore(handler.getPlayer().getUserId(), exploreId,exploreType,userHeroId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 获得探索奖励
	 * @param handler 用户编号
	 * @param exploreId 探索编号
	 * @return 探索奖励
	 */
	@SubCmd(subCmd=UserHeroCMD.GAIN_EXPLORE_AWARD,args={"int"})
	public void gainExploreAward(GameHandler handler, int exploreId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),
					userHeroAction().gainExploreAward(handler.getPlayer().getUserId(),exploreId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 分解英雄
	 * @param handler 用户编号
	 * @param heros 英雄
	 */
	@SubCmd(subCmd=UserHeroCMD.RESOLVE_HERO,args={"int_true"})
	public void resolveHero(GameHandler handler,List<Integer> heros){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),userHeroAction().resolveHero(handler.getPlayer().getUserId(),heros));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 激活突破灵元点
	 * @param handler 用户编号
	 * @param heros 英雄
	 */
	@SubCmd(subCmd=UserHeroCMD.ACTIVE_BREAK_SLOT,args={"int","int"})
	public void activeBreakSlot(GameHandler handler,int userheroId, int slot){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),heroBreakAction().activeBreakSlot(handler.getPlayer().getUserId(), userheroId, slot));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 英雄突破
	 * @param handler 用户编号
	 * @param heros 英雄
	 */
	@SubCmd(subCmd=UserHeroCMD.HERO_BREAK,args={"int"})
	public void activeBreakSlot(GameHandler handler,int userheroId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(),heroBreakAction().breakHero(handler.getPlayer().getUserId(), userheroId));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	
}
