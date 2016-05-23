package com.ks.game.handler;

import java.util.List;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.EternalCMD;
import com.ks.util.LockKeyUtil;
/**
 * 武魂
 * @author ks
 */
@MainCmd(mainCmd = MainCMD.ETERNAL)
public class EternalHandler extends ActionAdapter{
	
	/**
	 * 获得武魂
	 * @param userId 用户编号
	 * @return 武魂
	 */
	@SubCmd(subCmd=EternalCMD.GAIN_USER_ETERNAL)
	public void gainUserEternal(GameHandler handler){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), userEternalAction().gainUserEternal(handler.getPlayer().getUserId()));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
	/**
	 * 穿戴武魂
	 * @param userId 用户编号
	 * @param userEternalId 用户武魂编号
	 * @param userHeroId 英雄编号
	 */
	@SubCmd(subCmd=EternalCMD.WEAR_ETERNAL,args={"int","int"})
	public void wearEternal(GameHandler handler,int userEternalId,int userHeroId){
		userEternalAction().wearEternal(handler.getPlayer().getUserId(), userEternalId, userHeroId);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	/**
	 * 拆下武魂
	 * @param userId 用户编号
	 * @param userHeroId 英雄编号
	 * @param retain 是否保留
	 */
	@SubCmd(subCmd=EternalCMD.DIS_ETERNAL,args={"int","boolean"})
	public void disEternal(GameHandler handler,int userHeroId,boolean retain){
		userEternalAction().disEternal(handler.getPlayer().getUserId(), userHeroId, retain);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	
	
	/**
	 * 获得熔炼
	 * @param userId 用户编号
	 * @return 熔炼
	 */
	@SubCmd(subCmd=EternalCMD.GAIN_ETERNAL_SMELTINGS)
	public void gainEternalSmeltings(GameHandler handler){
		Application.sendMessage(handler.getChannel(), handler.getHead(),userEternalAction().gainEternalSmeltings(handler.getPlayer().getUserId()));
	}
	/**
	 * 熔炼
	 * @param userId 用户编号
	 * @param type 类型
	 * @param userHeroIds 要熔炼的英雄
	 * @return 熔炼后的数据
	 */
	@SubCmd(subCmd=EternalCMD.ETERNAL,args={"int","int_true","int_true"})
	public void eternal(GameHandler handler,int type,List<Integer> equipmentIds,List<Integer> eternalIds){
		Application.sendMessage(handler.getChannel(), handler.getHead(),userEternalAction().eternal(handler.getPlayer().getUserId(),type,equipmentIds,eternalIds));
	}
	
	/**
	 * 开炉
	 * @param userId 用户编号
	 * @param type 要开的炉子
	 * @return 获得的物品
	 */
	@SubCmd(subCmd=EternalCMD.BLOWING,args={"int"})
	public void  blowing(GameHandler handler,int type){
		Application.sendMessage(handler.getChannel(), handler.getHead(),userEternalAction().blowing(handler.getPlayer().getUserId(),type));
	}
	/**
	 * 出售武魂
	 * @param userId 用户编号
	 * @param userEternalId 武魂编号
	 */
	@SubCmd(subCmd=EternalCMD.SELL_ETERNAL,args={"int"})
	public void sellEternal(GameHandler handler,int userEternalId){
		userEternalAction().sellEternal(handler.getPlayer().getUserId(), userEternalId);
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
}
