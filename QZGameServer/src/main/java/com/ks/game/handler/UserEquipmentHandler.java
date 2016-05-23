package com.ks.game.handler;

import java.util.List;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.UserEquipmentCMD;
import com.ks.util.LockKeyUtil;
/**
 * 用户装备
 * @author ks
 */
@MainCmd(mainCmd=MainCMD.EQUIPMENT)
public class UserEquipmentHandler extends ActionAdapter {
	
	/**
	 * 升级装备
	 * @param userId 用户编号
	 * @param userEquipmentId 装备编号
	 * return 升级成功的级数
	 */
	@SubCmd(subCmd=UserEquipmentCMD.LEVEL_UP_EQUIPMENT ,args={"int","int"})
	public void levelUpEquipment(GameHandler handler,int userEquipmentId, int type){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			int uplevel=userEquipmentAction().levelUpEquipment(handler.getPlayer().getUserId(), userEquipmentId, type);
			Application.sendMessage(handler.getChannel(), handler.getHead(),uplevel);
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 出售装备
	 * @param userId 用户编号
	 * @param equipments 要出售的装备
	 */
	@SubCmd(subCmd=UserEquipmentCMD.SELL_EQUIPMENT,args={"int_true"})
	public  void sellEquipment(GameHandler handler,List<Integer> equipments){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userEquipmentAction().sellEquipment(handler.getPlayer().getUserId(), equipments);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	/**
	 * 使用装备
	 * @param userId 用户编号
	 * @param userEquipmentId 装备编号
	 * @param userHeroId 英雄编号
	 */
	@SubCmd(subCmd=UserEquipmentCMD.USE_EQUIPMENT,args={"int","int"})
	public void useEquipment(GameHandler handler,int userEquipmentId,int userHeroId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			userEquipmentAction().useEquipment(handler.getPlayer().getUserId(), userEquipmentId,userHeroId);
			Application.sendMessage(handler.getChannel(), handler.getHead());
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
	
}
