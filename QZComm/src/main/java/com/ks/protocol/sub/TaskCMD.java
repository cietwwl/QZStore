package com.ks.protocol.sub;

public interface TaskCMD {
	/**查看日常任务*/
	short GET_DAILY_TASK_INFO = 1;
	/**查看名望任务*/
	short GET_RENOWN_TASK_INFO =2;
	/**领取日常任务奖励*/
	short REWARD_DAILY_TASK = 3;
	/**领取名望任务奖励*/
	short REWARD_RENOWN_TASK = 4;
	/**领取活跃度宝箱奖励*/
	short REWARD_TASK_BOX = 5;
	/**刷新任务(推送接口)*/
	short REFRESH_TASK = 101;
}
