package com.ks.world.job;

import com.ks.action.logic.MartialWayAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;
import com.ks.timer.job.BaseJob;
import com.ks.timer.job.Job;

@Job(context="9:00?*")
public class MartialWayAwardJob extends BaseJob {

	@Override
	public void runJob() {
		MartialWayAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, MartialWayAction.class);
		action.gainAward();
	}

}
