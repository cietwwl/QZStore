package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.TaskActionSetting;
import com.ks.db.cfg.TaskBoxReward;
import com.ks.db.cfg.TaskReward;
import com.ks.db.cfg.TaskSetting;
/**
 * 任务基础数据dao
 * @author hanjie.l
 *
 */
public class TaskBaseSettingDAO extends GameCfgDAOTemplate{
	
	public static final String TASKRBOXEWARD_FIELDS = " id,active,goods_id,type,num,level ";
	
	public static final String TASKREWARD_FIELDS = " id,taskId,goods_id,type,num,level ";
	
	public static final String TASKSETTING_FIELDS = " id,taskType,leadTaskId,taskActionList,needPlayerLevel,needFame,rewardActive ";
	
	public static final String TASKSACTIONETTING_FIELDS = " id,goalValue,event,prepareMethod,methodParams,field,dealautValue,eventCondition ";
	
	/**
	 * 查询所有任务
	 * @return
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryTaskSettings", dbbean=TaskSetting.class)})
	public List<TaskSetting> queryTaskSettings(){
		String sql = DBBeanRowMapperManager.getDynamicSql(TaskSetting.class, "queryTaskSettings");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(TaskSetting.class));
	}
	
	/**
	 * 查询所有任务配置表
	 * @return
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryTaskActionSettings", dbbean=TaskActionSetting.class)})
	public List<TaskActionSetting> queryTaskActionSettings(){
		String sql = DBBeanRowMapperManager.getDynamicSql(TaskActionSetting.class, "queryTaskActionSettings");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(TaskActionSetting.class));
	}
	
	/**
	 * 查询所有任务奖励
	 * @return
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryTaskRewards", dbbean=TaskReward.class)})
	public List<TaskReward> queryTaskRewards(){
		String sql = DBBeanRowMapperManager.getDynamicSql(TaskReward.class, "queryTaskRewards");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(TaskReward.class));
	}
	
	/**
	 * 查询所有任务奖励
	 * @return
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryTaskBoxRewards", dbbean=TaskBoxReward.class)})
	public List<TaskBoxReward> queryTaskBoxRewards(){
		String sql = DBBeanRowMapperManager.getDynamicSql(TaskBoxReward.class, "queryTaskBoxRewards");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(TaskBoxReward.class));
	}
}
