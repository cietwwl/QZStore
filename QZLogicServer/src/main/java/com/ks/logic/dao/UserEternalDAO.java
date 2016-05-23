package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserProp;
import com.ks.table.UserEternalTable;
import com.ks.util.JSONUtil;

public class UserEternalDAO extends GameDAOTemplate{
	private static final String USER_ETERNAL_KEY = "USER_ETERNAL_";
	private static final String LOAD = "LOAD";
	
	private static class UserEternalMapMapper{
		public static Map<Integer, UserEternal> rowMapper(Map<String, String> map) {
			Map<Integer, UserEternal> result = new HashMap<Integer, UserEternal>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					UserEternal bean = JSONUtil.toObject(entry.getValue(), UserEternal.class);
					result.put(bean.getUserEternalId(), bean);
				}
			}
			return result;
		}
	}
	
	private static class UserEternalObjMapper{
		public static Map<String, String> objMapper(Map<Integer, UserEternal> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, UserEternal> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	private static final String getTableName(int userId){
		return "t_user_eternal_"+(userId%10);
	}
	private static final String getUserEternalSetKey(int userId){
		return USER_ETERNAL_KEY + userId;
	}
	
	public List<UserEternal> queryUserEternals(int userId){
		String sql = "select * from "+getTableName(userId)+" where user_id=?";
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserEternal.class), userId);
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserEternal", dbbean=UserEternal.class, wheres={UserEternalTable.USERID, UserEternalTable.USERETERNALID})})
	public void updateUserEternal(UserEternal userEternal){
		userEternal.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(UserEternal.class, "updateUserEternal", getTableName(userEternal.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserEternal.class, "updateUserEternal", userEternal);
		saveOrUpdate(sql, params.toArray());
	}

	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserEternals", dbbean=UserEternal.class, wheres={UserEternalTable.USERETERNALID})})
	public void updateUserEternals(List<UserEternal> usereternals){
		if(usereternals.size() == 0){
			return;
		}
		String sql = DBBeanRowMapperManager.getDynamicSql(UserProp.class, "updateUserEternals", getTableName(usereternals.get(0).getUserId()));
		List<Object[]> args = new ArrayList<>();
		for(UserEternal eternal : usereternals){
			eternal.setUpdateTime(new Date());
			Object[] arg = DBBeanRowMapperManager.getDynamicParams(UserEternal.class, "updateUserEternals", eternal).toArray();
			args.add(arg);
		}
		executeBatch(sql, args);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserEternal", dbbean=UserEternal.class)})
	public void addUserEternal(UserEternal userEternal){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserEternal.class, "addUserEternal", getTableName(userEternal.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserEternal.class, "addUserEternal", userEternal);
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		userEternal.setUserEternalId(id);
	}
	
	public void deleteUserEternal(int userEternalId,int userId){
		String sql = "delete from "+getTableName(userId)+" where user_eternal_id=? and user_id=?";
		saveOrUpdate(sql, userEternalId,userId);
	}
	public UserEternal queryUserEternal(int userEternalId,int userId){
		String sql = "select * from "+getTableName(userId)+" where user_eternal_id=? and user_id=?";
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserEternal.class), userEternalId,userId);
	}

	/**
	 * 查询缓存武魂
	 */
	public Map<Integer, UserEternal> queryUserEternalsCache(int userId, boolean checkload){
		String setKey = getUserEternalSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(!checkload || isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return UserEternalMapMapper.rowMapper(map);
		}
		return null;
	}
	
	/**
	 * 添加缓存道具
	 */
	public void addUserEternalCache(UserEternal userEternal){
		String setKey = getUserEternalSetKey(userEternal.getUserId());
		hset(setKey, String.valueOf(userEternal.getUserEternalId()), JSONUtil.toJson(userEternal));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 删除缓存中的武魂
	 */
	public void deleteUserEternalCache(int userId,int userEternalId){
		String setKey = getUserEternalSetKey(userId);
		hdel(setKey, String.valueOf(userEternalId));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}

	/**
	 * 添加武魂到缓存
	 */
	public void setUserEternalCache(int userId, Map<Integer, UserEternal> eternalmap){
		setCacheSign();
		try{
			String setKey = getUserEternalSetKey(userId);
			del(setKey);
			if(!eternalmap.isEmpty()){
				hmset(setKey, UserEternalObjMapper.objMapper(eternalmap));
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
	public void updateUserEternalCache(UserEternal userEternal){
		userEternal.setUpdateTime(new Date());
		userEternal.setUpdate(true);
		String setKey = getUserEternalSetKey(userEternal.getUserId());
		hset(setKey, String.valueOf(userEternal.getUserEternalId()), JSONUtil.toJson(userEternal));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理道具缓存
	 */
	public void clearUserEternalCache(int userId){
//		Map<Integer, UserEternal> eternalmap = queryUserEternalsCache(userId, false);
//		if(eternalmap != null){
//			List<UserEternal> updateEternals = new ArrayList<UserEternal>();
//			for(UserEternal eternal : eternalmap.values()){
//				if(eternal.isUpdate()){
//					updateEternals.add(eternal);
//				}
//			}
//			updateUserEternals(updateEternals);
//			del(getUserEternalSetKey(userId));
//		}
		del(getUserEternalSetKey(userId));
	}
	
	/**
	 * 获取道具数量
	 */
	public int getEternalSize(int userId){
		String setKey = getUserEternalSetKey(userId);
		if(exists(setKey)){
			int value =  hlen(setKey).intValue() - 1;
			if(value >= 0){
				return value;
			}
		}
		return 0;
	}
}
