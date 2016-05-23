package com.ks.world.service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ks.timer.TimerController;
import com.ks.timer.task.TaskTypeEnum;
import com.ks.util.XyTimeUtil;
import com.ks.world.task.OnlineReportTask;


/**
 * 世界任务加载
 * @author zck
 *
 */
public class WorldTaskService {
	/**
	 * 加载定时任务
	 */
	public static void loadTimerTask(){
		int period = 3 * XyTimeUtil.MINUTE_SECOND;
		Date date = XyTimeUtil.getDate(0, 0, 0);
		date = XyTimeUtil.getNextDate(date, Calendar.MINUTE, 3);
		Date nowDate = new Date();
		int nexttime = XyTimeUtil.getTimeOfSecond(date);
		int initialDelay = nexttime - XyTimeUtil.getTimeOfSecond(nowDate);
		OnlineReportTask task = new OnlineReportTask(nexttime);
		task.setInitialDelay(initialDelay);
		task.setPeriod(period);
		task.setUnit(TimeUnit.SECONDS);
		task.setType(TaskTypeEnum.SCHEDULE_AT_FIXED_RATE);
		TimerController.register(task);
	}
}
