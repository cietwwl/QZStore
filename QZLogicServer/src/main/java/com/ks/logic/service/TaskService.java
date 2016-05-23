package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.TaskActionSetting;
import com.ks.db.cfg.TaskBoxReward;
import com.ks.db.cfg.TaskReward;
import com.ks.db.cfg.TaskSetting;
import com.ks.logic.event.task.AbstractTaskEvent;
import com.ks.protocol.vo.task.DailyTaskRewardVO;
import com.ks.protocol.vo.task.RenownTaskRewardVO;
import com.ks.protocol.vo.task.UserDailyTaskInfoVO;
import com.ks.protocol.vo.task.UserRenownTaskInfoVO;
import com.ks.protocol.vo.task.UserTaskInfoVO;

/**
 * 任务
 * @author hanjie.l
 *
 */
public interface TaskService {
	
	/**
	 * 获取日常任务信息
	 * @param userId
	 * @return
	 */
	@Transaction
	public UserDailyTaskInfoVO getDailyTaskInfo(int userId);
	
	/**
	 * 获取名望任务信息
	 * @param userId
	 * @return
	 */
	@Transaction
	public UserRenownTaskInfoVO getRenownTaskInfo(int userId);
	
	/**
	 * 领取日常任务奖励
	 */
	@Transaction
	public DailyTaskRewardVO receieveDailyTaskReward(int userId, int taskId);
	
	/**
	 * 领取名望任务奖励
	 */
	@Transaction
	public RenownTaskRewardVO receieveRenownTaskReward(int userId, int taskId);
	
	/**
	 * 领取活跃度宝箱奖励
	 */
	@Transaction
	public DailyTaskRewardVO receieveTaskBoxReward(int userId, int active);
	
	/**
	 * 收到任务事件进行处理
	 * @param event
	 * @return 返回数值发生变化的任务
	 */
	@Transaction
	public List<UserTaskInfoVO> handlerEvent(AbstractTaskEvent event);

//=================================华丽分割线~~囧===========================================================
	
	/**
	 * 查询所有任务基础表
	 * @return
	 */
	public List<TaskSetting> queryTaskSettings();
	
	/**
	 * 查询所有任务行为配置表
	 * @return
	 */
	public List<TaskActionSetting> queryTaskActionSettings();
	
	/**
	 * 查询所有任务奖励配置表
	 * @return
	 */
	public List<TaskReward> queryTaskRewards();
	
	/**
	 * 查询所有活跃度宝箱奖励配置表
	 * @return
	 */
	public List<TaskBoxReward> queryTaskBoxRewards();

}
