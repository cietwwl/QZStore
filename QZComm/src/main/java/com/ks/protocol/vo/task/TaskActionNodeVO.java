package com.ks.protocol.vo.task;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 任务节点进度描述
 * @author hanjie.l
 *
 */
public class TaskActionNodeVO extends Message {

	private static final long serialVersionUID = 2181752885008087822L;
	
	@FieldDesc(desc="行为id")
	private int taskActionId;
	
	@FieldDesc(desc="当前完成值")
	private int curValue;
	
	@FieldDesc(desc="任务完成目标值")
	private int goalValue;

	public int getTaskActionId() {
		return taskActionId;
	}

	public void setTaskActionId(int taskActionId) {
		this.taskActionId = taskActionId;
	}

	public int getCurValue() {
		return curValue;
	}

	public void setCurValue(int curValue) {
		this.curValue = curValue;
	}

	public int getGoalValue() {
		return goalValue;
	}

	public void setGoalValue(int goalValue) {
		this.goalValue = goalValue;
	}
}
