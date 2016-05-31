package com.ks.world.service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ks.constant.SystemConstant;
import com.ks.timer.TimerController;
import com.ks.timer.task.TaskTypeEnum;
import com.ks.util.XyTimeUtil;
import com.ks.world.task.ArenaRankTask;
import com.ks.world.task.ArenaShopFlushTask;
import com.ks.world.task.BlackShopRefreshTask;
import com.ks.world.task.MartialWayAwardTask;
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
		Date zero = XyTimeUtil.getDate(0, 0, 0);
		Date date = XyTimeUtil.getDate(9, 0, 0);
		loadOnlineReportTask(zero);
		loadMartialWayAwardTask(date);
		loadArenaShopFlushTask(date);
		loadArenaRankTask(zero);
		for(int hour : SystemConstant.MALL_BLACK_MARKET_REFRESH_HOURS){
			loadBlackShopRefreshTask(hour, 0);
		}
	}
	
	/**
	 * 加载在线统计定时器
	 */
	private static void loadOnlineReportTask(Date zero){
		int nexttime = XyTimeUtil.getTimeOfSecond(XyTimeUtil.getNextDateByExecute(zero, Calendar.MINUTE, 3));
		int initialDelay = nexttime - XyTimeUtil.getNowSecond();
		OnlineReportTask task = new OnlineReportTask(nexttime);
		task.setInitialDelay(initialDelay);
		task.setPeriod(3 * XyTimeUtil.MINUTE_SECOND);    
		task.setUnit(TimeUnit.SECONDS);
		task.setType(TaskTypeEnum.SCHEDULE_AT_FIXED_RATE);
		TimerController.register(task);
	}
	
	/**
	 * 武道大会排行奖励定时器
	 */
	private static void loadMartialWayAwardTask(Date date){
		Date next = XyTimeUtil.getNextDateByExecute(date, Calendar.DAY_OF_YEAR, 1);
		int initialDelay = XyTimeUtil.getTimeOfSecond(next) - XyTimeUtil.getNowSecond();
		MartialWayAwardTask task = new MartialWayAwardTask();
		task.setInitialDelay(initialDelay);
		task.setPeriod(XyTimeUtil.DAY_SECOND);    
		task.setUnit(TimeUnit.SECONDS);
		task.setType(TaskTypeEnum.SCHEDULE_AT_FIXED_RATE);
		TimerController.register(task);
	}
	
	/**
	 * 竞技场商城刷新
	 */
	private static void loadArenaShopFlushTask(Date date){
		Date next = XyTimeUtil.getNextDateByExecute(date, Calendar.DAY_OF_YEAR, 1);
		int initialDelay = XyTimeUtil.getTimeOfSecond(next) - XyTimeUtil.getNowSecond();
		ArenaShopFlushTask task = new ArenaShopFlushTask();
		task.setInitialDelay(initialDelay);
		task.setPeriod(XyTimeUtil.DAY_SECOND);    
		task.setUnit(TimeUnit.SECONDS);
		task.setType(TaskTypeEnum.SCHEDULE_AT_FIXED_RATE);
		TimerController.register(task);
	}
	
	/**
	 * 竞技场排行/发放奖励
	 */
	private static void loadArenaRankTask(Date zero){
		Date next = XyTimeUtil.getNextDateByExecute(zero, Calendar.DAY_OF_YEAR, 1);
		int initialDelay = XyTimeUtil.getTimeOfSecond(next) - XyTimeUtil.getNowSecond();
		ArenaRankTask task = new ArenaRankTask();
		task.setInitialDelay(initialDelay);
		task.setPeriod(XyTimeUtil.DAY_SECOND);    
		task.setUnit(TimeUnit.SECONDS);
		task.setType(TaskTypeEnum.SCHEDULE_AT_FIXED_RATE);
		TimerController.register(task);
	}
	
	/**
	 * 黑市刷新时间
	 */
	private static void loadBlackShopRefreshTask(int hour, int minute){
		Date date = XyTimeUtil.getDate(hour, minute, 0);
		Date next = XyTimeUtil.getNextDateByExecute(date, Calendar.DAY_OF_YEAR, 1);
		int initialDelay = XyTimeUtil.getTimeOfSecond(next) - XyTimeUtil.getNowSecond();
		BlackShopRefreshTask task = new BlackShopRefreshTask();
		task.setInitialDelay(initialDelay);
		task.setPeriod(XyTimeUtil.DAY_SECOND);    
		task.setUnit(TimeUnit.SECONDS);
		task.setType(TaskTypeEnum.SCHEDULE_AT_FIXED_RATE);
		TimerController.register(task);
	}
}
