package com.ks.world.job;

import com.ks.action.logic.GuildAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;
import com.ks.timer.job.BaseJob;
import com.ks.timer.job.Job;

@Job(context="0:0?1")
public class GuildRankAwardJob extends BaseJob {

	@Override
	public void runJob() {
		GuildAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, GuildAction.class);
		action.grantRankAward();
	}

}
