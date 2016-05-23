package com.ks.world.task;

import java.util.concurrent.TimeUnit;

import com.ks.timer.task.BaseTask;
import com.ks.timer.task.Task;
@Task(initialDelay=10,period=10,unit=TimeUnit.HOURS)
public class TestTask extends BaseTask {

	@Override
	public void runTask() {
		
	}

}
