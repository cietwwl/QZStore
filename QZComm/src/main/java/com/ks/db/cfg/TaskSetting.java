package com.ks.db.cfg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.jexl2.Expression;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.model.task.constant.TaskType;
import com.ks.util.ScriptManager;
/**
 * 任务配置表
 * @author hanjie.l
 *
 */
@DBBeanSet(tablename="t_task_setting", imports={"com.ks.util.JSONUtil", "org.codehaus.jackson.type.TypeReference", "java.util.List", "com.ks.model.task.constant.TaskType"}, createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class TaskSetting {
	/**主键id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**任务类型 */
	@DBFieldSet(dbfname="taskType", parseJavaField="TaskType.valueOf(rs.getString(\"taskType\"))")
	private TaskType taskType;
	/**前置任务(-1表示默认领取)*/
	@DBFieldSet(dbfname="leadTaskId")
	private int leadTaskId = -1;
	/**是否自动领取任务(默认true)*/
	private boolean autoReceive = true;
	/**任务具体行为{@link TaskActionSetting#getId()}}*/
	@DBFieldSet(dbfname="taskActionList", parseJavaField="JSONUtil.toObject(rs.getString(\"taskActionList\"), new TypeReference<List<Integer>>(){})")
	private List<Integer> taskActionList;
	/**任务需要玩家等级*/
	@DBFieldSet(dbfname="needPlayerLevel")
	private int needPlayerLevel;
	/**需要名望值*/
	@DBFieldSet(dbfname="needFame")
	private int needFame;
	/**奖励活跃度(日常任务特有奖励)*/
	@DBFieldSet(dbfname="rewardActive")
	private int rewardActive;
	/**排他ID为0可忽略,非零情况下，同一ID组下的任务在整个任务的生命周期内只能领取完成其中一个*/
	@DBFieldSet(dbfname="distinctId")
	private int distinctId;
	/**任务领取条件(本来有了这个字段可以干掉needPlayerLevel和needFame，但由于这两个字段前端在使用，所以算了~~)*/
	@DBFieldSet(dbfname="conditions", parseJavaField="rs.getString(\"conditions\")")
	private Expression conditions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Expression getConditions() {
		return conditions;
	}
	
	public void setConditions(String conditions) {
		if(conditions != null && !conditions.trim().equals("")){
			this.conditions = ScriptManager.createExpression(conditions);
		}
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public int getLeadTaskId() {
		return leadTaskId;
	}

	public void setLeadTaskId(int leadTaskId) {
		this.leadTaskId = leadTaskId;
	}

	public boolean isAutoReceive() {
		return autoReceive;
	}

	public void setAutoReceive(boolean autoReceive) {
		this.autoReceive = autoReceive;
	}

	public List<Integer> getTaskActionList() {
		return taskActionList;
	}

	public void setTaskActionList(List<Integer> taskActionList) {
		this.taskActionList = taskActionList;
	}

	public int getNeedPlayerLevel() {
		return needPlayerLevel;
	}

	public void setNeedPlayerLevel(int needPlayerLevel) {
		this.needPlayerLevel = needPlayerLevel;
	}

	public int getNeedFame() {
		return needFame;
	}

	public void setNeedFame(int needFame) {
		this.needFame = needFame;
	}

	public int getRewardActive() {
		return rewardActive;
	}

	public void setRewardActive(int rewardActive) {
		this.rewardActive = rewardActive;
	}

	public int getDistinctId() {
		return distinctId;
	}

	public void setDistinctId(int distinctId) {
		this.distinctId = distinctId;
	}

	/**
	 * 产生一个任务行为的map
	 * @return
	 */
	public Map<Integer, Integer> generateTaskActionsMap(){
		if(taskActionList != null){
			Map<Integer, Integer> actionValueMap = new HashMap<Integer, Integer>();
			for(int id : taskActionList){
				//默认值为0，倘若有任务一接收就完成的需求可以改这里
				actionValueMap.put(id, 0);
			}
			return actionValueMap;
		}
		return null;
	}
}
