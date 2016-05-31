package com.ks.world.task;

import com.ks.action.logic.MartialWayAction;
import com.ks.app.Application;
import com.ks.rpc.RPCKernel;
import com.ks.timer.task.BaseTask;

/**
 * 武道大会奖励发放
 *
 */
public class MartialWayAwardTask extends BaseTask{

	@Override
	public void runTask(){
		MartialWayAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, MartialWayAction.class);
		action.gainAward();
	}
	
}
