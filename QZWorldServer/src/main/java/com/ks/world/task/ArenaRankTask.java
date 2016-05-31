package com.ks.world.task;

import com.ks.action.logic.ArenaAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;
import com.ks.timer.task.BaseTask;

/**
 * 竞技场排行和发放奖励
 *
 */
public class ArenaRankTask extends BaseTask{

	@Override
	public void runTask(){
		ArenaAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, ArenaAction.class);
		action.clearArena();
		action.delArenaRank();
	}
	
}
