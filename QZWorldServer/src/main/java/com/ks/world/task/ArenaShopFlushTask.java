package com.ks.world.task;

import com.ks.action.logic.ArenaAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;
import com.ks.timer.task.BaseTask;

/**
 * 竞技场商城刷新
 *
 */
public class ArenaShopFlushTask extends BaseTask{

	@Override
	public void runTask(){
		ArenaAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, ArenaAction.class);
		action.refArenaShopping();
	}
	
}
