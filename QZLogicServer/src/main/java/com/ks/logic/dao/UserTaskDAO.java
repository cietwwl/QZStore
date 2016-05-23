package com.ks.logic.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserDailyTask;
import com.ks.db.model.UserRenownTask;
import com.ks.db.model.UserTask;
import com.ks.model.task.constant.TaskType;
import com.ks.table.UserDailyTaskTable;
import com.ks.table.UserRenownTaskTable;
import com.ks.util.JSONUtil;

/**
 * 任务DAO
 * @author zck
 *
 */
public class UserTaskDAO extends GameDAOTemplate {
	private static final String USER_TASK_KEY = "USER_TASK_";
	
	public String getUserTaskSetKey(int userId){
		return USER_TASK_KEY + userId;
	}

	@SuppressWarnings("unchecked")
	public static class UserTaskMapMapper{
		public static Map<String, UserTask> rowMapper(Map<String, String> map) {
			if(map == null || map.isEmpty()){
				return null;
			}
			Map<String, UserTask> result = new HashMap<String, UserTask>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				UserTask bean = (UserTask)JSONUtil.toObject(entry.getValue(), getUserTaskClass(entry.getKey()));
				result.put(bean.getTaskType(), bean);
			}
			return result;
		}
	}
	
	public static class UserTaskObjMapper{
		public static Map<String, String> objMapper(Map<String, UserTask> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<String, UserTask> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	/**
	 * 创建一个新的任务实体
	 * @param userTask
	 */
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserDailyTask", dbbean=UserDailyTask.class)})
	public void addUserDailyTask(UserDailyTask userTask){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserDailyTask.class, "addUserDailyTask");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserDailyTask.class, "addUserDailyTask", userTask);
		saveOrUpdate(sql, params.toArray());
	}
	
	/**
	 * 获取一个任务实体
	 * @param userId
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="getUserDailyTask", dbbean=UserDailyTask.class, wheres={UserDailyTaskTable.USERID}, limit={"1"})})
	public UserDailyTask getUserDailyTask(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserDailyTask.class, "getUserDailyTask");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserDailyTask.class), userId);
	}
	
	/**
	 * 更新任务实体
	 * @param userTask
	 */
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserDailyTask", dbbean=UserDailyTask.class, wheres={UserDailyTaskTable.USERID})})
	public void updateUserDailyTask(UserDailyTask userTask){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserDailyTask.class, "updateUserDailyTask");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserDailyTask.class, "updateUserDailyTask", userTask);
		saveOrUpdate(sql, params.toArray());
	}
	
	/**
	 * 创建一个新的任务实体
	 * @param userTask
	 */
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserRenownTask", dbbean=UserRenownTask.class)})
	public void addUserRenownTask(UserRenownTask userTask){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserRenownTask.class, "addUserRenownTask");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserRenownTask.class, "addUserRenownTask", userTask);
		saveOrUpdate(sql, params.toArray());
	}
	
	/**
	 * 获取一个任务实体
	 * @param userId
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="getUserRenownTask", dbbean=UserRenownTask.class, wheres={UserRenownTaskTable.USERID}, limit={"1"})})
	public UserRenownTask getUserRenownTask(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserRenownTask.class, "getUserRenownTask");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserRenownTask.class), userId);
	}
	
	/**
	 * 更新任务实体
	 * @param userTask
	 */
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserRenownTask", dbbean=UserRenownTask.class, wheres={UserRenownTaskTable.USERID})})
	public void updateUserRenownTask(UserRenownTask userTask){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserRenownTask.class, "updateUserRenownTask");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserRenownTask.class, "updateUserRenownTask", userTask);
		saveOrUpdate(sql, params.toArray());
	}
	
	/**
	 * 查询缓存任务
	 */
	public Map<String, UserTask> queryUserTasksCache(int userId){
		String setKey = getUserTaskSetKey(userId);
//		if(exists(setKey)){
			Map<String, String> map = hgetAll(setKey);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return UserTaskMapMapper.rowMapper(map);
//		}
//		return null;
	}
	
	/**
	 * 设置缓存任务
	 * @param userId
	 * @param taskmap
	 */
	public void setUserTasksCache(int userId, Map<String, UserTask> taskmap){
		String setKey = getUserTaskSetKey(userId);
		del(setKey);
		if(!taskmap.isEmpty()){
			hmset(setKey, UserTaskObjMapper.objMapper(taskmap));
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}
	}
	
	/**
	 * 获取缓存任务
	 * @param userId
	 * @param userTask
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserTask getUserTaskCache(int userId, String taskType){
		String setKey = getUserTaskSetKey(userId);
		String str = hget(setKey, taskType);
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		if(str != null){
			Class clazz = getUserTaskClass(taskType);
			return (UserTask)JSONUtil.toObject(str, clazz);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getUserTaskClass(String taskType){
		Class clazz = null;
		if(taskType.equals(TaskType.DAILY_TASK.toString())){
			clazz = UserDailyTask.class;
		}else if(taskType.equals(TaskType.RENOWN_TASK.toString())){
			clazz = UserRenownTask.class;
		}
		return clazz;
	}
	
	/**
	 * 添加缓存任务
	 */
	public void addUserTaskCache(UserTask userTask){
		String setKey = getUserTaskSetKey(userTask.getUserId());
		hset(setKey, String.valueOf(userTask.getTaskType()), JSONUtil.toJson(userTask));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 更新缓存任务
	 */
	public void updateUserTaskCache(UserTask userTask){
		String setKey = getUserTaskSetKey(userTask.getUserId());
		hset(setKey, String.valueOf(userTask.getTaskType()), JSONUtil.toJson(userTask));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理任务缓存
	 */
	public void clearUserTasksCache(int userId){
		del(getUserTaskSetKey(userId));
	}
	
}
