package com.ks.logic.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.ks.db.cfg.TaskActionSetting;
import com.ks.db.cfg.TaskSetting;
import com.ks.logger.LoggerFactory;
import com.ks.model.task.constant.TaskType;

/**
 * 缓存任务映射关系
 * @author hanjie.l
 *
 */
public class TaskHolder {
	
	private static final Logger LOGGER = LoggerFactory.get(TaskHolder.class);
	
	// {任务id 任务行为id, 对应任务行为}
	protected static final Map<Integer, Map<Integer, TaskActionSetting>> task_actions_mapping = new ConcurrentHashMap<>();
		
	//{行为id, 对应任务id列表}
	protected static final Map<Integer, Set<Integer>> action_taskIds_mapping = new ConcurrentHashMap<Integer, Set<Integer>>();
	
	//{任务事件, 对应任务id列表}
	protected static final Map<String, Set<TaskActionSetting>> taskevent_actions_mapping = new ConcurrentHashMap<String, Set<TaskActionSetting>>();
	
	//{任务类型, 对应任务列表}
	protected static final Map<TaskType, Set<TaskSetting>> taskType_tasks_mapping = new ConcurrentHashMap<TaskType, Set<TaskSetting>>();
	
	/**
	 * 初始化
	 */
	public static void init(Map<Integer, TaskSetting> taskSettingMap, Map<Integer, TaskActionSetting> taskActionSettingMap){
		task_actions_mapping.clear();
		action_taskIds_mapping.clear();
		taskType_tasks_mapping.clear();
		taskevent_actions_mapping.clear();
		for(TaskSetting taskSetting : taskSettingMap.values()){
			Map<Integer, TaskActionSetting> actions = new ConcurrentHashMap<>();
			//获取所有行为
			for(int taskActionId : taskSetting.getTaskActionList()){
				TaskActionSetting actionSetting = taskActionSettingMap.get(taskActionId);
				if(actionSetting == null){
					String message = String.format("任务:{%s} 中的任务行为配置: {%s} 不存在", taskSetting.getId(), taskActionId);
					LOGGER.error(message);
				}else{
					actions.put(taskActionId, actionSetting);
					//添加行为->任务映射
					addActionTaskId(taskActionId, taskSetting.getId());
				}
			}
			task_actions_mapping.put(taskSetting.getId(), actions);
			
			//添加任务类型->任务映射
			addTaskByType(taskSetting.getTaskType(), taskSetting);
		}
		for(TaskActionSetting actionSetting : taskActionSettingMap.values()){
			Set<TaskActionSetting> actions = taskevent_actions_mapping.get(actionSetting.getEvent());
			if(actions == null){
				actions = new HashSet<>();
				taskevent_actions_mapping.put(actionSetting.getEvent(), actions);
			}
			actions.add(actionSetting);
		}
	}
	
	/**
	 * 添加行为->任务映射
	 * @param actionId
	 * @param taskId
	 */
	public static void addActionTaskId(int actionId, int taskId){
		Set<Integer> taskIds = action_taskIds_mapping.get(actionId);
		if(taskIds == null){
			taskIds = new HashSet<>();
			action_taskIds_mapping.put(actionId, taskIds);
		}
		taskIds.add(taskId);
	}
	
	/**
	 * 添加任务类型->任务映射
	 * @param taskType
	 * @param taskSetting
	 */
	public static void addTaskByType(TaskType taskType, TaskSetting taskSetting){
		Set<TaskSetting> tasks = taskType_tasks_mapping.get(taskType);
		if(tasks == null){
			tasks = new HashSet<>();
			taskType_tasks_mapping.put(taskType, tasks);
		}
		tasks.add(taskSetting);
	}
	
	
	/**
	 * 获取任务对应的所有
	 * @param taskId
	 * @return
	 */
	public static Map<Integer, TaskActionSetting> getActionMapByTaskId(int taskId){
		Map<Integer, TaskActionSetting> map = task_actions_mapping.get(taskId);
		if(map == null){
			map = new HashMap<>();
		}
		return map;
	}
	
	/**
	 * 获取action对应的所有任务id
	 * @param actionId
	 * @return
	 */
	public static Set<Integer> getTaskIdsByActionId(int actionId){
		Set<Integer> set = action_taskIds_mapping.get(actionId);
		if(set == null){
			set = new HashSet<>();
		}
		return set;
	}
	
	/**
	 * 获取事件对于action
	 * @param eventName
	 * @return
	 */
	public static Set<TaskActionSetting> getActionsByEventName(String eventName){
		Set<TaskActionSetting> set = taskevent_actions_mapping.get(eventName);
		if(set == null){
			set = new HashSet<>();
		}
		return set;
	}
	
	/**
	 * 根据任务类型获取任务
	 * @param taskType
	 * @return
	 */
	public static Set<TaskSetting> getTaskSettingByTaskType(TaskType taskType){
		return taskType_tasks_mapping.get(taskType);
	}

}
