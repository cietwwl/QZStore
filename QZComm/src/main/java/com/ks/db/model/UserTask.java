package com.ks.db.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Data;

import com.ks.access.DBFieldSet;
import com.ks.db.cfg.TaskSetting;
import com.ks.model.task.constant.TaskType;
import com.ks.util.StringUtils;
/**
 * 任务实体类
 * @author hanjie.l
 *
 */
@Data
public abstract class UserTask {
	/**玩家id*/
	@DBFieldSet(dbfname="userId")
	protected int userId;
	/**任务类型*/
	@DBFieldSet(dbfname="tasktype")
	protected String taskType;
	/**当前领取的任务<taskId, taskActionId, finishedTimes>*/
	@DBFieldSet(dbfname="currentTask")
	protected String currentTask;
	/**已完成任务id*/
	@DBFieldSet(dbfname="finishedTaskIds")
	protected String finishedTaskIds;
	/**已领取奖励id*/
	@DBFieldSet(dbfname="rewardedTaskIds")
	protected String rewardedTaskIds;
	/**已领取排他Id,详细说明{@link TaskSetting#getDistinctId()}*/
	@DBFieldSet(dbfname="hasDisTinctIds")
	protected String hasDisTinctIds;
	
	protected TaskType tType;
	protected Map<Integer, Map<Integer, Integer>> currentTaskMap;
	protected Set<Integer> finishedTaskIdList;
	protected Set<Integer> rewardedTaskIdList;
	protected Set<Integer> hasDisTinctIdList;
	
	/**
	 * 构造函数
	 */
	protected UserTask(){
		setCurrentTaskMap(new ConcurrentHashMap<Integer, Map<Integer, Integer>>());
		setFinishedTaskIdList(new HashSet<Integer>());
		setRewardedTaskIdList(new HashSet<Integer>());
		setHasDisTinctIdList(new HashSet<Integer>());
	}
	
	/**
	 * 抽象初始化函数
	 * @param userId
	 */
	public abstract void init(int userId);
	
	private void initTaskType(){
		tType = TaskType.valueOf(taskType);
	}
	private void initTaskTypes(){
		taskType = tType.toString();
	}
	private void initCurrentTaskMap(){
		currentTaskMap = StringUtils.stringToIntMap(currentTask);
	}
	private void initCurrentTasks(){
		currentTask = StringUtils.intMapToString(currentTaskMap);
	}
	private void initFinishedTaskIdList(){
		finishedTaskIdList = StringUtils.stringToSet(finishedTaskIds);
	}
	private void initFinishedTaskIds(){
		finishedTaskIds = StringUtils.setToString(finishedTaskIdList);
	}
	private void initRewardedTaskIdList(){
		rewardedTaskIdList = StringUtils.stringToSet(rewardedTaskIds);
	}
	private void initRewardedTaskIds(){
		rewardedTaskIds = StringUtils.setToString(rewardedTaskIdList);
	}
	private void initDisTinctIdList(){
		hasDisTinctIdList = StringUtils.stringToSet(hasDisTinctIds);
	}
	private void initDisTinctIds(){
		hasDisTinctIds = StringUtils.setToString(hasDisTinctIdList);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCurrentTask() {
		initCurrentTasks();
		return currentTask;
	}

	public void setCurrentTask(String currentTask) {
		this.currentTask = currentTask;
		initCurrentTaskMap();
	}

	public String getFinishedTaskIds() {
		initFinishedTaskIds();
		return finishedTaskIds;
	}

	public void setFinishedTaskIds(String finishedTaskIds) {
		this.finishedTaskIds = finishedTaskIds;
		initFinishedTaskIdList();
	}

	public String getRewardedTaskIds() {
		initRewardedTaskIds();
		return rewardedTaskIds;
	}

	public void setRewardedTaskIds(String rewardedTaskIds) {
		this.rewardedTaskIds = rewardedTaskIds;
		initRewardedTaskIdList();
	}
	
	public String getTaskType() {
		initTaskTypes();
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
		initTaskType();
	}
	
	public String getHasDisTinctIds(){
		initDisTinctIds();
		return hasDisTinctIds;
	}
	
	public void setHasDisTinctIds(String hasDisTinctIds){
		this.hasDisTinctIds = hasDisTinctIds;
		initDisTinctIdList();
	}
	

	/**
	 * 是否已经领取过该任务
	 * @param taskId
	 * @return
	 */
	public boolean isReceievedTask(int taskId){
		if(currentTaskMap.keySet().contains(taskId)){
			return true;
		}
		if(finishedTaskIdList.contains(taskId)){
			return true;
		}
		if(rewardedTaskIdList.contains(taskId)){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否已经完成并领取该任务奖励
	 * @param taskId
	 * @return
	 */
	public boolean isRewardedTask(int taskId){
		if(rewardedTaskIdList.contains(taskId)){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否已经领取完成过相同的排他id
	 * @param distinctId
	 * @return
	 */
	public boolean isReceievedDistinctId(int distinctId){
		if(hasDisTinctIdList.contains(distinctId)){
			return true;
		}
		return false;
	}
	
	/**
	 * 添加排他id
	 * @param distinctId
	 */
	public void addDistinctId(int distinctId){
		if(distinctId > 0){
			hasDisTinctIdList.add(distinctId);
		}
	}
	
	/**
	 * 领取一个新任务
	 * @param taskId
	 * @param node
	 */
	public void addNodeIfAbsent(int taskId, Map<Integer, Integer> node){
		if(!currentTaskMap.keySet().contains(taskId)){
			currentTaskMap.put(taskId, node);
		}
	}
	
	/**
	 * 完成任务
	 * @param taskId
	 */
	public void moveToFinished(int taskId){
		if(currentTaskMap.remove(taskId)!=null){
			finishedTaskIdList.add(taskId);
		}
	}
	
	/**
	 * 领取任务奖励
	 * @param taskId
	 */
	public void moveToRewarded(int taskId){
		if(finishedTaskIdList.remove(taskId)){
			rewardedTaskIdList.add(taskId);
		}
	}
	
	/**
	 * 改变任务行为值
	 * @param taskId
	 * @param actionId
	 * @param value
	 */
	public void setActionValues(int taskId, int actionId, int value){
		Map<Integer, Integer> map = currentTaskMap.get(taskId);
		if(map != null){
			map.put(actionId, value);
		}
	}
	
	/**
	 * 获取指定任务的完成度
	 * @param taskId
	 * @param actionId
	 */
	public int getCurActionValues(int taskId, int actionId){
		Map<Integer, Integer> map = currentTaskMap.get(taskId);
		if(map != null){
			return map.get(actionId);
		}
		return 0;
	}
	
	/**
	 * 增加任务行为值
	 * @param taskId
	 * @param actionId
	 * @param value
	 */
	public void increActionValues(int taskId, int actionId, int value){
		Map<Integer, Integer> map = currentTaskMap.get(taskId);
		if(map != null){
			Integer initValue = map.get(actionId);
			initValue = initValue == null? 0 : initValue;
			map.put(actionId, initValue + value);
		}
	}
	
	/**
	 * 获取任务行为值
	 * @param actionId
	 * @param goalValue
	 * @return
	 */
	public int getActionValue(int taskId, int actionId){
		Map<Integer, Integer> map = currentTaskMap.get(taskId);
		if(map != null){
			return map.get(actionId);
		}
		return 0;
	}
	
	/**
	 * 是否被重置了
	 * @return
	 */
	public boolean isReseted(){
		if(currentTask != null && !currentTask.isEmpty()){
			return false;
		}
		if(finishedTaskIds != null && !finishedTaskIds.isEmpty()){
			return false;
		}
		if(rewardedTaskIds != null && !rewardedTaskIds.isEmpty()){
			return false;
		}
		return true;
	}
}
