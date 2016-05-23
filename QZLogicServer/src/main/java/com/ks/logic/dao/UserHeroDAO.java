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
import com.ks.db.model.UserHero;
import com.ks.table.UserHeroTable;
import com.ks.util.JSONUtil;

public class UserHeroDAO extends GameDAOTemplate {
	
	
	private static final String USER_HERO_KEY = "USER_HERO_";
	private static final String LOAD = "LOAD";
	
//	private static final String getUserHeroKey(int userId,int id){
//		return USER_HERO_KEY+userId+SPEET+id;
//	}
	private static final String getUserHeroSetKey(int userId){
		return USER_HERO_KEY+userId;
	}
	
	private static final String getTableName(int userId){
		return "t_user_hero_"+(userId%10);
	}
	
	public static class UserHeroMapMapper{
		public static Map<Integer, UserHero> rowMapper(Map<String, String> map) {
			Map<Integer, UserHero> result = new HashMap<Integer, UserHero>();
			for(Map.Entry<String, String> entry : map.entrySet()){
				if(!entry.getKey().equals(LOAD)){
					UserHero bean = JSONUtil.toObject(entry.getValue(), UserHero.class);
					result.put(bean.getId(), bean);
				}
			}
			return result;
		}
	}
	
	public static class UserHeroObjMapper{
		public static Map<String, String> objMapper(Map<Integer, UserHero> map) {
			Map<String, String> result = new HashMap<String, String>();
			for(Map.Entry<Integer, UserHero> entry : map.entrySet()){
				result.put(entry.getKey().toString(), JSONUtil.toJson(entry.getValue()));
			}
			return result;
		}
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserHeros", dbbean=UserHero.class, wheres={UserHeroTable.USERID})})
	public List<UserHero> queryUserHeros(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserHero.class, "queryUserHeros", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserHero.class), userId);
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserHero", dbbean=UserHero.class, wheres={UserHeroTable.USERID, UserHeroTable.ID})})
	public UserHero queryUserHero(int userId,int userHeroId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserHero.class, "queryUserHero", getTableName(userId));
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserHero.class), userId,userHeroId);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserHero", dbbean=UserHero.class)})
	public void addUserHero(UserHero hero){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserHero.class, "addUserHero", getTableName(hero.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserHero.class, "addUserHero", hero);
		int id = insertAndReturnId(sql, INT_KEY, params.toArray());
		hero.setId(id);
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserHeros", dbbean=UserHero.class, wheres={UserHeroTable.USERID, UserHeroTable.ID})})
	public void updateUserHeros(List<UserHero> userHeros){
		if(userHeros.size()==0){
			return;
		}
		String sql = DBBeanRowMapperManager.getDynamicSql(UserHero.class, "updateUserHeros", getTableName(userHeros.get(0).getUserId()));
		List<Object[]> args = new ArrayList<>();
		for(UserHero hero : userHeros){
			hero.setUpdateTime(new Date());
			Object[] arg = DBBeanRowMapperManager.getDynamicParams(UserHero.class, "updateUserHeros", hero).toArray();
			args.add(arg);
		}
		executeBatch(sql, args);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserHero", dbbean=UserHero.class, wheres={UserHeroTable.USERID, UserHeroTable.ID})})
	public void updateUserHero(UserHero userHero){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserHero.class, "updateUserHero", getTableName(userHero.getUserId()));
		Object[] args = DBBeanRowMapperManager.getDynamicParams(UserHero.class, "updateUserHero", userHero).toArray();
		saveOrUpdate(sql, args);
	}
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteUserHero", dbbean=UserHero.class, wheres={UserHeroTable.USERID, UserHeroTable.ID})})
	public void deleteUserHero(int userId,int id){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserHero.class, "deleteUserHero", getTableName(userId));
		saveOrUpdate(sql, userId,id);
	}
	
	/**
	 * 查询缓存
	 */
	public Map<Integer, UserHero> queryUserHerosCache(int userId, boolean checkload){
		String setKey = getUserHeroSetKey(userId);
		Map<String, String> map = hgetAll(setKey);
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		if(!checkload || isLoad(map)){
			return UserHeroMapMapper.rowMapper(map);
		}
		return null;
	}
	
	/**
	 * 添加伙伴到缓存
	 */
	public void addUserHeroCache(UserHero userHero){
		String setKey = getUserHeroSetKey(userHero.getUserId());
		hset(setKey, String.valueOf(userHero.getId()), JSONUtil.toJson(userHero));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 添加装备到缓存
	 */
	public void setUserHeroCache(int userId, Map<Integer, UserHero> heromap){
		setCacheSign();
		try{
			String setKey = getUserHeroSetKey(userId);
			del(setKey);
			if(!heromap.isEmpty()){
				hmset(setKey, UserHeroObjMapper.objMapper(heromap));
			}
			hset(setKey, LOAD, LOAD);
			expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
		}finally{
			clearCacheSign();
		}
	}
	
	/**
	 * 删除缓存伙伴
	 */
	public void deleteUserHeroCache(int userId,int id){
		String setKey = getUserHeroSetKey(userId);
		hdel(setKey, String.valueOf(id));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 更新伙伴
	 */
	public void updateUserHeroCache(UserHero userHero){
		userHero.setUpdate(true);
		userHero.setUpdateTime(new Date());
		String setKey = getUserHeroSetKey(userHero.getUserId());
		hset(setKey, String.valueOf(userHero.getId()), JSONUtil.toJson(userHero));
		expire(setKey, SystemConstant.CACHE_EXPIRE_TIME);
	}
	
	/**
	 * 清理伙伴缓存
	 */
	public void clearUserHeroCache(int userId){
//		Map<Integer, UserHero> heromap = queryUserHerosCache(userId, false);
//		if(heromap != null){
//			List<UserHero> hs = new ArrayList<UserHero>();
//			for(UserHero h : heromap.values()){
//				if(h.isUpdate()){
//					hs.add(h);
//				}
//			}
//			updateUserHeros(hs);
//			del(getUserHeroSetKey(userId));
//		}
		del(getUserHeroSetKey(userId));
	}
	
	/**
	 * 获取伙伴数量
	 */
	public int getUserHeroSize(int userId){
		String setKey = getUserHeroSetKey(userId);
		if(exists(setKey)){
			int value =  hlen(setKey).intValue() - 1;
			if(value >= 0){
				return value;
			}
		}
		return 0;
	}
	
}
