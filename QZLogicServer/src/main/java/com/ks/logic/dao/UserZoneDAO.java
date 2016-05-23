package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.cache.JedisNoLoadException;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserZone;
import com.ks.db.model.UserZoneBattle;
import com.ks.table.UserZoneBattleTable;
import com.ks.table.UserZoneTable;
import com.ks.util.JSONUtil;

public class UserZoneDAO extends GameDAOTemplate {

	private static final String USER_ZONE_KEY = "USER_ZONE_";
	private static final String USER_ZONE_BATTLE_KEY = "USER_ZONE_BATTLE";
	
	private static final String getTableName(int userId){
		return "t_user_zone_"+(userId%10);
	}
	
	private static final String getUserZoneBattleTableName(int userId){
		return "t_user_zone_battle_"+(userId%10);
	}
	
	private static final String getUserZoneSetKey(int userId){
		return USER_ZONE_KEY + userId;
	}
	
	private static final String getUserZoneBattleSetKey(int userId){
		return USER_ZONE_BATTLE_KEY + userId;
	}
	
	public static final String getUserZoneBattleKey(UserZoneBattle battle){
		return getUserZoneBattleKey(battle.getZoneId(), battle.getZoneBattleId());
	}
	
	public static final String getUserZoneBattleKey(int zoneId, int battleId){
		return zoneId + "_" + battleId;
	}
	
	public static class UserZoneMapMapper{
		public static Map<Integer, UserZone> rowMapper(Map<String, String> map) {
			Map<Integer, UserZone> result = new HashMap<Integer, UserZone>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					UserZone bean = JSONUtil.toObject(entry.getValue(), UserZone.class);
					result.put(bean.getZoneId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class UserZoneObjMapper{
		public static Map<String, String> objMapper(Map<Integer, UserZone> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, UserZone> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	public static class UserZoneBattleMapMapper{
		public static Map<String, UserZoneBattle> rowMapper(Map<String, String> map) {
			Map<String, UserZoneBattle> result = new HashMap<String, UserZoneBattle>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					UserZoneBattle bean = JSONUtil.toObject(entry.getValue(), UserZoneBattle.class);
					result.put(entry.getValue(), bean);
				}
			}
			return result;
		}
	}
	
	public static class UserZoneBattleObjMapper{
		public static Map<String, String> objMapper(Map<String, UserZoneBattle> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<String, UserZoneBattle> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserZoneBattles", dbbean=UserZoneBattle.class, wheres={UserZoneBattleTable.USERID})})
	public List<UserZoneBattle> queryUserZoneBattles(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserZoneBattle.class, "queryUserZoneBattles", getUserZoneBattleTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserZoneBattle.class), userId);
	}
	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserZoneBattles", dbbean=UserZoneBattle.class, wheres={UserZoneBattleTable.USERID, UserZoneBattleTable.ZONEID})})
//	public List<UserZoneBattle> queryUserZoneBattles(int userId,int zoneId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserZoneBattle.class, "queryUserZoneBattles", getUserZoneBattleTableName(userId));
//		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserZoneBattle.class), userId,zoneId);
//	}
//	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserZoneBattle", dbbean=UserZoneBattle.class, wheres={UserZoneBattleTable.USERID, UserZoneBattleTable.ZONEID, UserZoneBattleTable.ZONEBATTLEID})})
//	public UserZoneBattle queryUserZoneBattle(int userId,int zoneId,int battleId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserZoneBattle.class, "queryUserZoneBattle", getUserZoneBattleTableName(userId));
//		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserZoneBattle.class), userId,zoneId,battleId);
//	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserZoneBattle", dbbean=UserZoneBattle.class)})
	public void addUserZoneBattle(UserZoneBattle userZoneBattle){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserZoneBattle.class, "addUserZoneBattle", getUserZoneBattleTableName(userZoneBattle.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserZoneBattle.class,"addUserZoneBattle", userZoneBattle);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserZoneBattle", dbbean=UserZoneBattle.class, wheres={UserZoneBattleTable.USERID, UserZoneBattleTable.ZONEID, UserZoneBattleTable.ZONEBATTLEID})})
	public void updateUserZoneBattle(UserZoneBattle userZoneBattle){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserZoneBattle.class, "updateUserZoneBattle", getUserZoneBattleTableName(userZoneBattle.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserZoneBattle.class, "updateUserZoneBattle", userZoneBattle);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryZone", dbbean=UserZone.class, wheres={UserZoneTable.USERID})})
	public List<UserZone> queryZone(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserZone.class, "queryZone", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserZone.class), userId);
	}
	
//	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserZone", dbbean=UserZone.class, wheres={UserZoneTable.USERID, UserZoneTable.ZONEID})})
//	public UserZone queryUserZone(int userId,int zoneId){
//		String sql = DBBeanRowMapperManager.getDynamicSql(UserZone.class, "queryUserZone", getTableName(userId));
//		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserZone.class), userId,zoneId);
//	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserZone", dbbean=UserZone.class)})
	public void addUserZone(UserZone zone){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserZone.class, "addUserZone", getTableName(zone.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserZone.class, "addUserZone", zone);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserZone", dbbean=UserZone.class, wheres={UserZoneTable.USERID, UserZoneTable.ZONEID})})
	public void updateUserZone(UserZone zone){
		zone.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(UserZone.class, "updateUserZone", getTableName(zone.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserZone.class, "updateUserZone", zone);
		saveOrUpdate(sql, params.toArray());
	}
	
	/**
	 * 是否已经加载了缓存
	 * @param userId
	 * @return
	 */
	public boolean isLoad(Map<String, String> map){
		return map.get(LOAD) != null;
	}
	
	/**
	 * 设置缓存副本
	 * @param userId
	 * @param zonemap
	 */
	public void setUserZonesCache(int userId, Map<Integer, UserZone> zonemap){
		setCacheSign();
		try{
			String setKey = getUserZoneSetKey(userId);
			if(!zonemap.isEmpty()){
				hmset(setKey, UserZoneObjMapper.objMapper(zonemap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 查询缓存副本
	 */
	public Map<Integer, UserZone> queryUserZonesCache(int userId){
		String setKey = getUserZoneSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return UserZoneMapMapper.rowMapper(map);
		}
		return null;
	}
	
	/**
	 * 获得副本缓存
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	public UserZone getUserZoneCache(int userId, int zoneId) throws JedisNoLoadException{
		String setKey = getUserZoneSetKey(userId);
		String str = hget(setKey, String.valueOf(zoneId));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		if(str != null){
			return JSONUtil.toObject(str, UserZone.class);
		}else if(!isLoad(setKey)){
			throw new JedisNoLoadException();
		}
		return null;
	}
	
	/**
	 * 添加缓存副本
	 */
	public void addUserZoneCache(UserZone userZone){
		String setKey = getUserZoneSetKey(userZone.getUserId());
		hset(setKey, String.valueOf(userZone.getZoneId()), JSONUtil.toJson(userZone));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 更新缓存副本
	 */
	public void updateUserZoneCache(UserZone userZone){
		String setKey = getUserZoneSetKey(userZone.getUserId());
		hset(setKey, String.valueOf(userZone.getZoneId()), JSONUtil.toJson(userZone));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理副本缓存
	 */
	public void clearUserZonesCache(int userId){
		del(getUserZoneSetKey(userId));
	}
	
	/**
	 * 设置缓存副本
	 * @param userId
	 * @param zonemap
	 */
	public void setUserZoneBattlesCache(int userId, Map<String, UserZoneBattle> battlemap){
		setCacheSign();
		try{
			String setKey = getUserZoneBattleSetKey(userId);
			if(!battlemap.isEmpty()){
				hmset(setKey, UserZoneBattleObjMapper.objMapper(battlemap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 查询缓存副本
	 */
	public Map<String, UserZoneBattle> queryUserZoneBattlesCache(int userId){
		String setKey = getUserZoneBattleSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		if(isLoad(map)){
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
			return UserZoneBattleMapMapper.rowMapper(map);
		}
		return null;
	}
	
	/**
	 * 获得副本缓存
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	public UserZoneBattle getUserZoneBattleCache(int userId, int zoneId, int battleId) throws JedisNoLoadException{
		String setKey = getUserZoneBattleSetKey(userId);
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		String str = hget(setKey, getUserZoneBattleKey(zoneId, battleId));
		if(str != null){
			return JSONUtil.toObject(str, UserZoneBattle.class);
		}else if(!isLoad(setKey)){
			throw new JedisNoLoadException();
		}
		return null;
	}
	
	/**
	 * 获得副本缓存
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	public List<UserZoneBattle> getUserZoneBattleCache(int userId, List<String> keys) throws JedisNoLoadException{
		String setKey = getUserZoneBattleSetKey(userId);
		String[] arr = {};
		Map<String, String> map = hmget(setKey, keys.toArray(arr));
		List<UserZoneBattle> list = new ArrayList<UserZoneBattle>();
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		for(Map.Entry<String, String> entry : map.entrySet()){
			if(entry.getValue() != null){
				list.add(JSONUtil.toObject(entry.getValue(), UserZoneBattle.class));
			}
		}
		if(!isLoad(setKey)){
			throw new JedisNoLoadException();
		}
		return list;
	}
	
	/**
	 * 添加缓存副本
	 */
	public void addUserZoneBattleCache(UserZoneBattle battle){
		String setKey = getUserZoneBattleSetKey(battle.getUserId());
		hset(setKey, getUserZoneBattleKey(battle.getZoneId(), battle.getZoneBattleId()), JSONUtil.toJson(battle));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 更新缓存副本
	 */
	public void updateUserZoneBattleCache(UserZoneBattle battle){
		String setKey = getUserZoneBattleSetKey(battle.getUserId());
		hset(setKey, getUserZoneBattleKey(battle.getZoneId(), battle.getZoneBattleId()), JSONUtil.toJson(battle));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理副本缓存
	 */
	public void clearUserZoneBattlesCache(int userId){
		del(getUserZoneBattleSetKey(userId));
	}
}
