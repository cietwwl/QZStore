package com.ks.protocol.vo.task;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 任务节点进度描述
 * @author hanjie.l
 *
 */
public class TaskNodeVO extends Message {

	private static final long serialVersionUID = -7020551477262590378L;

	@FieldDesc(desc="任务id")
	private int taskId;
	
	@FieldDesc(desc="任务行为")
	private List<TaskActionNodeVO> actionNodes;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public List<TaskActionNodeVO> getActionNodes() {
		return actionNodes;
	}

	public void setActionNodes(List<TaskActionNodeVO> actionNodes) {
		this.actionNodes = actionNodes;
	}
}
