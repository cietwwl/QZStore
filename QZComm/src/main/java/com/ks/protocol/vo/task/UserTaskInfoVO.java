package com.ks.protocol.vo.task;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 任务信息info
 * @author hanjie.l
 *
 */
public class UserTaskInfoVO extends Message {

	private static final long serialVersionUID = -3722783378728285724L;

	@FieldDesc(desc="任务类型：DAILY_TASK 日常任务，RENOWN_TASK 名望任务")
	private String taskType;
	
	@FieldDesc(desc="当前进行中的任务")
	private List<TaskNodeVO> currentTask;
	
	@FieldDesc(desc="已完成任务id")
	private List<Integer> finishedTaskIds;
	
	@FieldDesc(desc="已领取奖励id")
	protected List<Integer> rewardedTaskIds;
	
	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public List<TaskNodeVO> getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(List<TaskNodeVO> currentTask) {
		this.currentTask = currentTask;
	}

	public List<Integer> getFinishedTaskIds() {
		return finishedTaskIds;
	}

	public void setFinishedTaskIds(List<Integer> finishedTaskIds) {
		this.finishedTaskIds = finishedTaskIds;
	}

	public List<Integer> getRewardedTaskIds() {
		return rewardedTaskIds;
	}

	public void setRewardedTaskIds(List<Integer> rewardedTaskIds) {
		this.rewardedTaskIds = rewardedTaskIds;
	}
}