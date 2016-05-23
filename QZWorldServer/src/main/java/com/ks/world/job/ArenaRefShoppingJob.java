package com.ks.world.job;

import com.ks.action.logic.ArenaAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;
import com.ks.timer.job.BaseJob;
import com.ks.timer.job.Job;
/**
 * 竞技场奖励
 * @author ks
 */
@Job(context="9:0?*")
public class ArenaRefShoppingJob extends BaseJob {
	@Override
	public void runJob() {
		ArenaAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, ArenaAction.class);
		action.refArenaShopping();
	}

}
