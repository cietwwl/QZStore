package com.ks.world.task;

import java.util.ArrayList;
import java.util.List;

import com.ks.action.logic.MallAction;
import com.ks.app.Application;
import com.ks.lock.KeyLock;
import com.ks.rpc.RPCKernel;
import com.ks.timer.task.BaseTask;
import com.ks.util.LockKeyUtil;
import com.ks.world.kernel.WorldServerCache;
import com.ks.world.manager.GameLockManager;

/**
 * 黑市刷新
 *
 */
public class BlackShopRefreshTask extends BaseTask{

	@Override
	public void runTask(){
		List<Integer> ids =  WorldServerCache.getOnlineUids();
		for(Integer userId : ids){
			List<String> keys = new ArrayList<>();
			keys.add(LockKeyUtil.getUserLockKey(userId));
			KeyLock lock = GameLockManager.getInstance().lockKey(keys);
			try{
				MallAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, MallAction.class);
				action.refreshBlackMarket(userId, true);
			}finally{
				GameLockManager.getInstance().unlockKey(lock);
			}
		}
	}
	
}
