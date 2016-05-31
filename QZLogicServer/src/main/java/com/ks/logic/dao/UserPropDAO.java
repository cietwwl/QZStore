package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserProp;
import com.ks.table.UserPropTable;
import com.ks.util.JSONUtil;

public class UserPropDAO extends GameDAOTemplate {
	
	private static final String USER_PROP_KEY = "USER_PROP_";
	private static final String LOAD = "LOAD";
	
	public static class UserPropMapMapper{
		public static Map<Integer, UserProp> rowMapper(Map<String, String> map) {
			Map<Integer, UserProp> result = new HashMap<Integer, UserProp>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					com.ks.db.model.UserProp bean = JSONUtil.toObject(entry.getValue(), UserProp.class);
					result.put(bean.getId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class UserPropObjMapper{
		public static Map<String, String> objMapper(Map<Integer, UserProp> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, UserProp> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	private static final String getTableName(int userId){
		return "t_user_prop_"+(userId%10);
	}
	
	private static final String getUserPropSetKey(int userId){
		return USER_PROP_KEY+userId;
	}

	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="delUserProp", dbbean=UserProp.class, wheres={UserPropTable.ID})})
	public void delUserProp(int userId, UserProp prop){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserProp.class, "delUserProp", getTableName(userId));
		saveOrUpdate(sql, prop.getId());
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserProps", dbbean=UserProp.class, wheres={UserPropTable.USERID})})
	public List<UserProp> queryUserProps(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserProp.class, "queryUserProps", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserProp.class), userId);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserProp", dbbean=UserProp.class)})
	public void addUserProp(UserProp userProp){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserProp.class, "addUserProp", getTableName(userProp.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserProp.class, "addUserProp", userProp);
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		userProp.setId(id);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserProps", dbbean=UserProp.class, wheres={UserPropTable.ID})})
	public void updateUserProps(List<UserProp> userProps){
		if(userProps.size() == 0){
			return;
		}
		String sql = DBBeanRowMapperManager.getDynamicSql(UserProp.class, "updateUserProps", getTableName(userProps.get(0).getUserId()));
		List<Object[]> args = new ArrayList<>();
		for(UserProp prop : userProps){
			prop.setUpdateTime(new Date());
			Object[] arg = DBBeanRowMapperManager.getDynamicParams(UserProp.class, "updateUserProps", prop).toArray();
			args.add(arg);
		}
		executeBatch(sql, args);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserProp", dbbean=UserProp.class, wheres={UserPropTable.ID})})
	public void updateUserProp(UserProp userProp){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserProp.class, "updateUserProp", getTableName(userProp.getUserId()));
		Object[] args = DBBeanRowMapperManager.getDynamicParams(UserProp.class, "updateUserProp", userProp).toArray();
		saveOrUpdate(sql, args);
	}

	/**
	 * 是否已经加载了好友缓存
	 * @param userId
	 * @return
	 */
	public boolean isLoad(Map<String, String> map){
		return map.get(LOAD) != null;
	}
	
	public void delUserPropCache(int userId, UserProp prop){
		String setKey = getUserPropSetKey(userId);
		hdel(setKey, String.valueOf(prop.getId()));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	/**
	 * 查询缓存道具
	 */
	public Map<Integer, UserProp> queryUserPropsCache(int userId, boolean checkload){
		String setKey = getUserPropSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(!checkload || isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return UserPropMapMapper.rowMapper(map);
		}
		return null;
	}
	
	/**
	 * 添加缓存道具
	 */
	public void addUserPropCache(UserProp userProp){
		int userId = userProp.getUserId();
		String setKey = getUserPropSetKey(userId);
		hset(setKey, String.valueOf(userProp.getId()), JSONUtil.toJson(userProp));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 添加道具到缓存
	 */
	public void setUserPropsCache(int userId, Map<Integer, UserProp> propmap){
		setCacheSign();
		try{
			String setKey = getUserPropSetKey(userId);
			del(setKey);
			if(!propmap.isEmpty()){
				hmset(setKey, UserPropObjMapper.objMapper(propmap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 更新缓存道具
	 */
	public void updateUserPropCache(UserProp userProp){
		userProp.setUpdateTime(new Date());
		userProp.setUpdate(true);
		String setKey = getUserPropSetKey(userProp.getUserId());
		hset(setKey, String.valueOf(userProp.getId()), JSONUtil.toJson(userProp));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理道具缓存
	 */
	public void clearUserPropCache(int userId){
//		Map<Integer, UserProp> propmap = queryUserPropsCache(userId, false);
//		if(propmap != null){
//			List<UserProp> updateProps = new ArrayList<UserProp>();
//			for(UserProp prop : propmap.values()){
//				if(prop.isUpdate()){
//					updateProps.add(prop);
//				}
//			}
//			updateUserProps(updateProps);
//			del(getUserPropSetKey(userId));
//		}
		del(getUserPropSetKey(userId));
	}
	
	/**
	 * 获取道具数量
	 */
	public int getPropSize(int userId){
		String setKey = getUserPropSetKey(userId);
		if(exists(setKey)){
			int value =  hlen(setKey).intValue() - 1;
			if(value >= 0){
				return value;
			}
		}
		return 0;
	}
}
