package com.ks.logic.action;

import com.ks.action.logic.TaskAction;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.TaskService;
import com.ks.protocol.vo.task.DailyTaskRewardVO;
import com.ks.protocol.vo.task.RenownTaskRewardVO;
import com.ks.protocol.vo.task.UserDailyTaskInfoVO;
import com.ks.protocol.vo.task.UserRenownTaskInfoVO;
/**
 * 任务action
 * @author hanjie.l
 *
 */
public class TaskActionImpl implements TaskAction {
	
	private static final TaskService taskService = ServiceFactory.getService(TaskService.class);

	@Override
	public UserDailyTaskInfoVO getDailyTaskInfo(int userId) {
		return taskService.getDailyTaskInfo(userId);
	}

	@Override
	public UserRenownTaskInfoVO getRenownTaskInfo(int userId) {
		return taskService.getRenownTaskInfo(userId);
	}

	@Override
	public DailyTaskRewardVO receieveDailyTaskReward(int userId, int taskId) {
		return taskService.receieveDailyTaskReward(userId, taskId);
	}

	@Override
	public RenownTaskRewardVO receieveRenownTaskReward(int userId, int taskId) {
		return taskService.receieveRenownTaskReward(userId, taskId);
	}

	@Override
	public DailyTaskRewardVO receieveDailyBoxReward(int userId, int active) {
		return taskService.receieveTaskBoxReward(userId, active);
	}


}
