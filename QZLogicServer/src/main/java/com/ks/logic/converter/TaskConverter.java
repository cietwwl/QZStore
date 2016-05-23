package com.ks.logic.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ks.db.cfg.TaskActionSetting;
import com.ks.db.model.UserTask;
import com.ks.logic.cache.TaskHolder;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.task.TaskActionNodeVO;
import com.ks.protocol.vo.task.TaskNodeVO;
import com.ks.protocol.vo.task.UserTaskInfoVO;

/**
 * 任务VO转换器
 * @author hanjie.l
 *
 */
public class TaskConverter {
	
	/**
	 * 转换成UserTaskInfoVO对象
	 * @param userTask
	 * @return
	 */
	public static UserTaskInfoVO convertToUserTaskInfoVO(UserTask userTask){
		
		UserTaskInfoVO userTaskInfoVO = MessageFactory.getMessage(UserTaskInfoVO.class);
		
		//当前执行的任务
		List<TaskNodeVO> curtTask = new ArrayList<>();
		for(int taskId : userTask.getCurrentTaskMap().keySet()){
			//一个任务
			TaskNodeVO taskNode = MessageFactory.getMessage(TaskNodeVO.class);
			//任务下的action
			List<TaskActionNodeVO> actionNodes = new ArrayList<>();
			Map<Integer, Integer> actions = userTask.getCurrentTaskMap().get(taskId);
			Map<Integer, TaskActionSetting> actionMap = TaskHolder.getActionMapByTaskId(taskId);
			if(actionMap != null){
				for(TaskActionSetting actionSetting : actionMap.values()){
					TaskActionNodeVO taskActionNode = MessageFactory.getMessage(TaskActionNodeVO.class);
					taskActionNode.setTaskActionId(actionSetting.getId());
					taskActionNode.setCurValue(actions.get(actionSetting.getId()));
					taskActionNode.setGoalValue(actionSetting.getGoalValue());
					actionNodes.add(taskActionNode);
				}
			}
			taskNode.setTaskId(taskId);
			taskNode.setActionNodes(actionNodes);
			curtTask.add(taskNode);
		}
		userTaskInfoVO.setCurrentTask(curtTask);
		
		//已完成
		List<Integer> finishedTaskIds = new ArrayList<>();
		for(int id : userTask.getFinishedTaskIdList()){
			finishedTaskIds.add(id);
		}
		userTaskInfoVO.setFinishedTaskIds(finishedTaskIds);
		
		//已领取奖励
		List<Integer> rewardedTaskIds = new ArrayList<>();
		for(int id : userTask.getRewardedTaskIdList()){
			rewardedTaskIds.add(id);
		}
		userTaskInfoVO.setRewardedTaskIds(rewardedTaskIds);
		
		//类型
		userTaskInfoVO.setTaskType(userTask.getTaskType().toString());
		return userTaskInfoVO;
	}

}
