package com.ks.action.logic;

import com.ks.protocol.vo.task.DailyTaskRewardVO;
import com.ks.protocol.vo.task.RenownTaskRewardVO;
import com.ks.protocol.vo.task.UserDailyTaskInfoVO;
import com.ks.protocol.vo.task.UserRenownTaskInfoVO;
/**
 * 任务action
 * @author hanjie.l
 *
 */
public interface TaskAction {
	
	/**
	 * 获取日常任务信息
	 * @param userId
	 * @return
	 */
	public UserDailyTaskInfoVO getDailyTaskInfo(int userId);
	
	/**
	 * 获取名望任务信息
	 * @param userId
	 * @return
	 */
	public UserRenownTaskInfoVO getRenownTaskInfo(int userId);
	
	/**
	 * 领取日常任务奖励
	 */
	public DailyTaskRewardVO receieveDailyTaskReward(int userId, int taskId);
	
	/**
	 * 领取名望任务奖励
	 */
	public RenownTaskRewardVO receieveRenownTaskReward(int userId, int taskId);

	/**
	 * 领取日常活跃度宝箱奖励
	 */
	public DailyTaskRewardVO receieveDailyBoxReward(int userId, int active);
}
