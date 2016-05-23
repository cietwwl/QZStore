package com.ks.game.handler;

import com.ks.app.Application;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.ClientLockManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.PayCMD;
import com.ks.util.LockKeyUtil;

@MainCmd(mainCmd=MainCMD.PAY)
public class PayHandle extends ActionAdapter{
	
	/**
	 * 购买支付商品
	 * @param handler
	 * @param payGoodsId
	 */
	@SubCmd(subCmd=PayCMD.GAIN_PAY_BILL, args={"int"})
	public void buyPayGoods(GameHandler handler, int payGoodsId){
		Player player = handler.getPlayer();
		ClientLockManager.lock(LockKeyUtil.getUserLockKey(player.getUserId()));
		try{
			Application.sendMessage(handler.getChannel(), handler.getHead(), mallAction().gainPayBill(player.getUserId(), payGoodsId, Application.WORLD_SERVER_ID));
		}finally{
			ClientLockManager.unlockThreadLock();
		}
	}
}
