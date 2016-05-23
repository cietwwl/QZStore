package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.TaskActionSetting;
import com.ks.db.cfg.TaskBoxReward;
import com.ks.db.cfg.TaskReward;
import com.ks.db.cfg.TaskSetting;
import com.ks.db.model.User;
import com.ks.db.model.UserDailyTask;
import com.ks.db.model.UserRenownTask;
import com.ks.db.model.UserTask;
import com.ks.exceptions.GameException;
import com.ks.logger.LoggerFactory;
import com.ks.logic.cache.GameCache;
import com.ks.logic.cache.TaskHolder;
import com.ks.logic.converter.TaskConverter;
import com.ks.logic.event.task.AbstractTaskEvent;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.TaskService;
import com.ks.logic.service.impl.PrepareMethodServiceImpl.PrepareMethodInvoker;
import com.ks.model.task.constant.ConditionKey;
import com.ks.model.task.constant.TaskType;
import com.ks.object.ItemEffects;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.task.DailyTaskRewardVO;
import com.ks.protocol.vo.task.RenownTaskRewardVO;
import com.ks.protocol.vo.task.UserDailyTaskInfoVO;
import com.ks.protocol.vo.task.UserRenownTaskInfoVO;
import com.ks.protocol.vo.task.UserTaskInfoVO;
import com.ks.util.ScriptManager;
/**
 * 任务
 * @author hanjie.l
 *
 */
public class TaskServiceImpl extends BaseService implements TaskService {
	
	private static final Logger LOGGER = LoggerFactory.get(TaskService.class);
	
	@Override
	public List<TaskSetting> queryTaskSettings() {
		return taskBaseSettingDao.queryTaskSettings();
	}

	@Override
	public List<TaskActionSetting> queryTaskActionSettings() {
		return taskBaseSettingDao.queryTaskActionSettings();
	}
	
	@Override
	public List<TaskReward> queryTaskRewards(){
		return taskBaseSettingDao.queryTaskRewards();
	}
	
	@Override
	public List<TaskBoxReward> queryTaskBoxRewards(){
		return taskBaseSettingDao.queryTaskBoxRewards();
	}
	
	public UserDailyTaskInfoVO getDailyTaskInfo(User user){

		UserDailyTask taskInfo = (UserDailyTask)getTaskInfo(user, TaskType.DAILY_TASK);
		
		UserDailyTaskInfoVO message = MessageFactory.getMessage(UserDailyTaskInfoVO.class);
		message.setActiveValue(taskInfo.getActiveValue());
		message.setUserTaskInfoVO(TaskConverter.convertToUserTaskInfoVO(taskInfo));
		
		List<Integer> rewardedBox = new ArrayList<>();
		for(int box : taskInfo.getRewardedBoxList()){
			rewardedBox.add(box);
		}
		message.setRewardedBox(rewardedBox);
		
		return message;
	}
	
	@Override
	public UserDailyTaskInfoVO getDailyTaskInfo(int userId){
		User user = userService.getUser(userId);
		return getDailyTaskInfo(user);
	}
	
	public UserRenownTaskInfoVO getRenownTaskInfo(User user){
		UserRenownTask renownTask = (UserRenownTask) getTaskInfo(user, TaskType.RENOWN_TASK);
		
		UserRenownTaskInfoVO renownTaskInfoVO = MessageFactory.getMessage(UserRenownTaskInfoVO.class);
		renownTaskInfoVO.setUserTaskInfoVO(TaskConverter.convertToUserTaskInfoVO(renownTask));
		
		return renownTaskInfoVO;
	}
	
	@Override
	public UserRenownTaskInfoVO getRenownTaskInfo(int userId){
		User user = userService.getUser(userId);
		return getRenownTaskInfo(user);
	}


	/**
	 * 获取任务信息
	 * @param userId
	 * @param taskType
	 * @return
	 */
	private UserTask getTaskInfo(User user, TaskType taskType) {
		
		//是否需要更新
		boolean isUpdate = false;
		
		//获取用户任务对象
		UserTask userTask = getOrCreateUserTask(user, taskType);
		
		//刷新任务
		if(refreshUserTask(user, userTask)){
			isUpdate = true;
		}

		//更新
		if(isUpdate){
			updateUserTask(userTask);
		}
		
		return userTask;
	}
	
	/**
	 * 获取并创建用户任务对象
	 * @param userId
	 * @param taskType
	 * @return
	 */
	private UserTask getOrCreateUserTask(User user, TaskType taskType){
		UserTask task = getUserTask(user, taskType);
		switch (taskType) {
		case DAILY_TASK:
			UserDailyTask userDailyTask;
			if(task == null){
				userDailyTask = new UserDailyTask();
				userDailyTask.init(user.getUserId());
				userTaskDAO.addUserDailyTask(userDailyTask);
				userDailyTask = (UserDailyTask) getUserTask(user, taskType);
			}else{
				userDailyTask = (UserDailyTask)task;
			}
			
			if(userDailyTask.needReset()){
				userDailyTask.clear();
				updateUserTask(userDailyTask);
			}
			return userDailyTask;
		case RENOWN_TASK:
			UserRenownTask userRenownTask;
			if(task == null){
				userRenownTask = new UserRenownTask();
				userRenownTask.init(user.getUserId());
				userTaskDAO.addUserRenownTask(userRenownTask);
				userRenownTask = (UserRenownTask) getUserTask(user, taskType);
			}else{
				userRenownTask = (UserRenownTask)task;
			}
			return userRenownTask;
		default:
			return null;
		}
	}
	
	/**
	 * 获取任务对象<br>
	 * 有则获取返回，并缓存到user中<br>
	 * 没有则返回null<br>
	 * @param user
	 * @param taskType
	 * @return
	 */
	private UserTask getUserTask(User user, TaskType taskType){
		if(user.getTasks() == null){
			user.setTasks(new HashMap<String, UserTask>());
		}
		
		UserTask userTask = user.getTasks().get(taskType.toString());
		//user中没有任务缓存
		if(userTask == null){
			//从缓存和数据查找，并放入user
			userTask = getAndCacheUserTask(user.getUserId(), taskType);
			if(userTask != null){
				user.getTasks().put(taskType.toString(), userTask);
			}
		}
		
		return user.getTasks().get(taskType.toString());
	}
	
	/**
	 * 先从缓存获取，没有则从数据库获取并缓存<br>
	 * 本接口仅供getUserTask方法调用，业务请调用getUserTask获取任务对象
	 * @param userId
	 * @param taskType
	 * @return
	 */
	private UserTask getAndCacheUserTask(int userId, TaskType taskType){
		UserTask task = userTaskDAO.getUserTaskCache(userId, taskType.toString());
		if(task == null){
			switch (taskType) {
			case DAILY_TASK:
				task = userTaskDAO.getUserDailyTask(userId);break;
			case RENOWN_TASK:
				task =  userTaskDAO.getUserRenownTask(userId);break;
			}
			if(task != null){
				userTaskDAO.addUserTaskCache(task);
			}
		}
		return task;
	}
	
	/**
	 * 更新用户任务对象,并更新缓存
	 * @param userTask
	 */
	private void updateUserTask(UserTask userTask){
		switch (userTask.getTType()) {
		case DAILY_TASK:
			userTaskDAO.updateUserDailyTask((UserDailyTask)userTask);
			break;
		case RENOWN_TASK:
			userTaskDAO.updateUserRenownTask((UserRenownTask)userTask);
			break;
		default:
			break;
		}
		userTaskDAO.updateUserTaskCache(userTask);
	}
	
	/**
	 * 刷新任务最新进度，检查是否有新任务
	 * @return
	 */
	private boolean refreshUserTask(User user, UserTask userTask){
		boolean isUpdate = false;
		
		if(userTask != null){
			//领取最新可领取的任务
			Set<TaskSetting> canReceieveTask = getAllCanReceieveTasks(user, userTask);
			for(TaskSetting taskSetting : canReceieveTask){
				if(taskSetting.getNeedPlayerLevel() <= user.getLevel()){
					Map<Integer, Integer> taskActionsMap = taskSetting.generateTaskActionsMap();
					if(taskActionsMap!=null && !taskActionsMap.isEmpty()){
						userTask.addNodeIfAbsent(taskSetting.getId(), taskActionsMap);
						isUpdate = true;
					}
				}
			}
			
			//刷下任务action
			for(int taskId : userTask.getCurrentTaskMap().keySet()){
				Map<Integer, TaskActionSetting> actionSettingsMap = TaskHolder.getActionMapByTaskId(taskId);
				for(TaskActionSetting actionSetting : actionSettingsMap.values()){
					if(!isEmpty(actionSetting.getPrepareMethod())){
						int result = executePrepareMethod(user, actionSetting.getPrepareMethod(), actionSetting.getMethodParams());
						userTask.setActionValues(taskId, actionSetting.getId(), result);
						isUpdate = true;
					}
				}
			}
			
			//检查是否有已完成任务
			checkFinishTask(user, userTask);
		}
		return isUpdate;
	}
	
	
	/**
	 * 检查是否有已完成任务
	 */
	private void checkFinishTask(User user, UserTask userTask){
		Set<Integer> finishTaskIds = new HashSet<Integer>();
		//刷下任务action
		for(int taskId : userTask.getCurrentTaskMap().keySet()){
			TaskSetting task = GameCache.getTaskSetting(taskId);
			if(task != null && task.getNeedPlayerLevel() <= user.getLevel()){
				boolean isFinish = true;
				Map<Integer, TaskActionSetting> actionSettingsMap = TaskHolder.getActionMapByTaskId(taskId);
				for(TaskActionSetting actionSetting : actionSettingsMap.values()){
					// 任务未完成
					if(userTask.getActionValue(taskId, actionSetting.getId()) < actionSetting.getGoalValue()){
						isFinish = false;
						break;
					}
				}
				//该任务已完成
				if(isFinish){
					finishTaskIds.add(taskId);
				}
			}
		}
		
		//将任务移到已完成
		for(int taskId : finishTaskIds){
			userTask.moveToFinished(taskId);
		}
	}
	
	
	/**
	 * 执行对应的方法
	 * @param method
	 */
	private int executePrepareMethod(User user, String method, List<String> methodParams){
		
		//获取准备方法
		PrepareMethodInvoker prepareInvoker = prepareMethodService.getPrepareInvoker(method);
		if(prepareInvoker != null){
			return prepareInvoker.invoke(user, methodParams);
		}else{
			LOGGER.error(String.format("不存在该准备方法执行器:{%s}", method));
		}
		
		return 0;
	}
	
	/**
	 * 获取所有开启，并且还没有领取的任务
	 * @param userTask
	 * @return
	 */
	private Set<TaskSetting> getAllCanReceieveTasks(User user, UserTask userTask){
		//用户上下文信息
		Map<String, Object> conditionContext = getConditionContext(user);
		
		Set<TaskSetting> canReceieveTask = new HashSet<>(); 
		Set<TaskSetting> taskSettings = TaskHolder.getTaskSettingByTaskType(userTask.getTType());
		if(taskSettings != null){
			for(TaskSetting taskSetting : taskSettings){
				if(taskSetting.getNeedPlayerLevel() <= user.getLevel()){
					//判断是否满足开启条件
					if(taskSetting.getConditions()!=null && !ScriptManager.invokeBooleanExpression(taskSetting.getConditions(), conditionContext)){
						continue;
					}
					//判断任务是否达到开启等级
					if(user.getLevel() < taskSetting.getNeedPlayerLevel()){
						continue;
					}
					//判断是否达到名望开启等级
					if(user.getFame() < taskSetting.getNeedFame()){
						continue;
					}
					//排他id不为0时需要进行排他判断
					if(taskSetting.getDistinctId()!=0 && userTask.isReceievedDistinctId(taskSetting.getDistinctId())){
						continue;
					}
					//前置任务为-1，并且没有领取过该任务
					if(taskSetting.getLeadTaskId() == -1 && !userTask.isReceievedTask(taskSetting.getId())){
						canReceieveTask.add(taskSetting);
						userTask.addDistinctId(taskSetting.getDistinctId());
						continue;
					}
					//没有领取过该任务，并且前置任务已完成并领奖
					if(!userTask.isReceievedTask(taskSetting.getId()) && userTask.isRewardedTask(taskSetting.getLeadTaskId())){
						canReceieveTask.add(taskSetting);
						userTask.addDistinctId(taskSetting.getDistinctId());
						continue;
					}
				}
			}
		}
		return canReceieveTask;
	}
	
	/**
	 * 获取条件用户的条件上下文信息
	 * @return
	 */
	private Map<String, Object> getConditionContext(User user){
		Map<String, Object> context = new HashMap<String, Object>();
		context.put(ConditionKey.PLAYERLEVEL, user.getLevel());
		context.put(ConditionKey.FAME, user.getFame());
		context.put(ConditionKey.VIPLEVEL, user.getVip());
		return context;
	}
	
	
	@Override
	public DailyTaskRewardVO receieveDailyTaskReward(int userId, int taskId){
		
		DailyTaskRewardVO dailyTaskRewardVO = MessageFactory.getMessage(DailyTaskRewardVO.class);
		

		User user = userService.getOnlineUser(userId);
		
		GainAwardVO gainAwardVO = receieveTaskReward(user, taskId, TaskType.DAILY_TASK);
		UserDailyTaskInfoVO dailyTaskInfoVO = getDailyTaskInfo(user);
		
		dailyTaskRewardVO.setGainAwardVO(gainAwardVO);
		dailyTaskRewardVO.setDailyTaskInfoVO(dailyTaskInfoVO);
		
		return dailyTaskRewardVO;
	}
	
	@Override
	public RenownTaskRewardVO receieveRenownTaskReward(int userId, int taskId){
		
		RenownTaskRewardVO renownTaskRewardVO = MessageFactory.getMessage(RenownTaskRewardVO.class);

		
		User user = userService.getOnlineUser(userId);
		
		GainAwardVO gainAwardVO = receieveTaskReward(user, taskId, TaskType.RENOWN_TASK);
		UserRenownTaskInfoVO renownTaskInfoVO = getRenownTaskInfo(user);
		
		renownTaskRewardVO.setGainAwardVO(gainAwardVO);
		renownTaskRewardVO.setRenownTaskInfoVO(renownTaskInfoVO);
		
		return renownTaskRewardVO;
	}
	

	/**
	 * 领取任务奖励
	 * @param userId
	 * @param taskId
	 * @param taskType
	 * @return
	 */
	private GainAwardVO receieveTaskReward(User user, int taskId, TaskType taskType) { 
		UserTask userTask = getUserTask(user, taskType);
		
		// 未开启
		if(userTask == null){
			throw new GameException(GameException.CODE_参数错误, "no open task");
		}
		
		//奖励已领取
		if(userTask.isRewardedTask(taskId)){
			throw new GameException(GameException.CODE_奖励已领取, "task has rewarded");
		}
		
		//任务未完成
		if(!userTask.getFinishedTaskIdList().contains(taskId)){
			throw new GameException(GameException.CODE_任务未完成, "task no finish");
		}
		
		//基础数据不存在
		List<TaskReward> taskRewards = GameCache.getTaskRewards(taskId);
		if(taskRewards == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "TaskSetting:"+taskId);
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_任务奖励);
		effects.addItems(taskRewards, 0);
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		// 发放奖励
		GainAwardVO awards = effectService.addGainAwardVo(user, effects);
		
		// 日常任务有其特有的活跃度奖励
		if(taskType.equals(TaskType.DAILY_TASK)){
			
			//基础数据不存在
			TaskSetting taskSetting = GameCache.getTaskSetting(taskId);
			if(taskSetting == null){
				throw new GameException(GameException.CODE_配置表数据不存在, "TaskSetting:"+taskId);
			}
			
			((UserDailyTask)userTask).addActiveValue(taskSetting.getRewardActive());
		}
		
		//将任务移到已完成
		userTask.moveToRewarded(taskId);
		
		//检查是否有新的任务
		refreshUserTask(user, userTask);

		//更新
		updateUserTask(userTask);
		
		return awards;
	}
	
	@Override
	public DailyTaskRewardVO receieveTaskBoxReward(int userId, int active){  
		
		User user = userService.getOnlineUser(userId);
		
		UserTask userTask = getUserTask(user, TaskType.DAILY_TASK);
		if(userTask == null){
			throw new GameException(GameException.CODE_活跃度宝箱未开启, "");
		}
		
		UserDailyTask userDailyTask = (UserDailyTask) userTask;
		
		// 未达到宝箱开启活跃度
		if(userDailyTask.getActiveValue() < active){
			throw new GameException(GameException.CODE_活跃度宝箱未开启, "");
		}
		
		//宝箱已领取
		if(userDailyTask.isReceieveBox(active)){
			throw new GameException(GameException.CODE_宝箱已领取, "");
		}
		
		
		//基础数据不存在
		List<TaskBoxReward> taskBoxRewards = GameCache.getTaskBoxRewards(active);
		if(taskBoxRewards == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_任务活跃度宝箱奖励);
		effects.addItems(taskBoxRewards, 0);
		int code = effectService.validAdds(user, effects);
		if(code != GameException.CODE_正常){
			throw new GameException(code, "");
		}
		// 发放奖励
		GainAwardVO awards = effectService.addGainAwardVo(user, effects); 
		
		//添加已领取宝箱
		userDailyTask.addRewardedBox(active);
		
		//更新
		updateUserTask(userDailyTask);
		
		
		DailyTaskRewardVO dailyTaskRewardVO = MessageFactory.getMessage(DailyTaskRewardVO.class);
		UserDailyTaskInfoVO dailyTaskInfoVO = getDailyTaskInfo(user);
		dailyTaskRewardVO.setGainAwardVO(awards);
		dailyTaskRewardVO.setDailyTaskInfoVO(dailyTaskInfoVO);
		
		return dailyTaskRewardVO;
	}

	@Override
	public List<UserTaskInfoVO> handlerEvent(AbstractTaskEvent event) {
		
		User user = event.getUser();
		
		List<UserTaskInfoVO> infoVOs = new ArrayList<>();
		for(TaskType taskType : TaskType.values()){
			UserTask userTask = getUserTask(user, taskType);
			if(userTask != null){
				boolean update = checkAndRefreshAction(user, userTask, event);
				//更新
				if(update){
					updateUserTask(userTask);
					infoVOs.add(TaskConverter.convertToUserTaskInfoVO(userTask));
				}
			}
		}
		return infoVOs;
	}
	
	/**
	 * 检查刷新action
	 * @param userTask
	 * @param event
	 */
	private boolean checkAndRefreshAction(User user, UserTask userTask, AbstractTaskEvent event){
		boolean isupdate =false;
		
		if(event.mayBringNewTask()){
			isupdate = refreshUserTask(user, userTask);
		}
		
		//找出所有对事件响应的action
		for(int taskId : userTask.getCurrentTaskMap().keySet()){
			TaskSetting task = GameCache.getTaskSetting(taskId);
			if(task.getNeedPlayerLevel() <= user.getLevel()){
				Map<Integer, TaskActionSetting> actionMap = TaskHolder.getActionMapByTaskId(taskId);
				for(TaskActionSetting actionSetting : actionMap.values()){
					// 判断行为是否关心这个事件
					if(!actionSetting.getEvent().equals(event.getEventName())){
						continue;
					}

					// 事件不满足该筛选条件
					if(actionSetting.getEventCondition()!=null && !ScriptManager.invokeBooleanExpression(actionSetting.getEventCondition(), event.getContext())){
						continue;
					}

					//优先级1
					if(!isEmpty(actionSetting.getPrepareMethod())){
						int result = executePrepareMethod(user, actionSetting.getPrepareMethod(), actionSetting.getMethodParams());
						int oldValue = userTask.getCurActionValues(taskId, actionSetting.getId());
						if(result != oldValue){
							userTask.setActionValues(taskId, actionSetting.getId(), result);
							isupdate = true;
						}
						continue;
					}
					//优先级2
					if(!isEmpty(actionSetting.getField())){
						Object value = event.getContext().get(actionSetting.getField());
						if(value != null && value instanceof Number){
							userTask.increActionValues(taskId, actionSetting.getId(), ((Number)value).intValue());
							isupdate = true;
						}else{
							LOGGER.error(String.format("事件上下文数据中不存在该字段数据:{%s}", actionSetting.getField()));
						}
						continue;
					}
					//优先级3
					if(actionSetting.getDealautValue() > 0){
						userTask.increActionValues(taskId, actionSetting.getId(), actionSetting.getDealautValue());
						isupdate = true;
					}
				}
			}
		}
		//检查是否有已完成任务
		checkFinishTask(user, userTask);
		
		return isupdate;
	}
	
	/**
	 * 判断是否为空串
	 * @param str
	 * @return
	 */
	private static boolean isEmpty(String str) {
		return (str == null || "".equals(str.trim()));
	}
}
