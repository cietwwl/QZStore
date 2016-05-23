package com.ks.world.task;

import com.ks.timer.task.BaseTask;
import com.ks.world.kernel.WorldServerCache;

public class OnlineReportTask extends BaseTask{

	private int time;
	
	public OnlineReportTask(int time) {
		super();
		this.time = time;
	}

	@Override
	public void runTask() {
		WorldServerCache.onlineReport(time);
		time += period;
	}

}
