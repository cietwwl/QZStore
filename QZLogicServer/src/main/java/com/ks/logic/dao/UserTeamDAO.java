package com.ks.logic.dao;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.cache.JedisBeanManager;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserTeam;
import com.ks.table.UserTeamTable;

public class UserTeamDAO extends GameDAOTemplate {

	private static final String USER_TEAM = "USER_TEAM_";
	
	private static final String getUserTeamKey(int userId){
		return USER_TEAM+userId;
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserTeam", dbbean=UserTeam.class, wheres={UserTeamTable.USERID})})
	public UserTeam queryUserTeam(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserTeam.class, "queryUserTeam");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserTeam.class), userId);
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserTeam", dbbean=UserTeam.class, wheres={UserTeamTable.USERID})})
	public void updateUserTeam(UserTeam ut){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserTeam.class, "updateUserTeam");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserTeam.class, "updateUserTeam", ut);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserTeam", dbbean=UserTeam.class)})
	public void addUserTeam(UserTeam ut){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserTeam.class, "addUserTeam");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserTeam.class, "addUserTeam", ut);
		saveOrUpdate(sql, params.toArray());
	}
	
	/*******************************************************user_team cache********************************************************************/
	/**
	 * 查询缓存
	 */
	public UserTeam queryUserTeamCache(int userId){
		String key = getUserTeamKey(userId);
		expire(key, SystemConstant.CACHE_EXPIRE_TIME);
		return hgetAll(key, JedisBeanManager.getRowMapper(UserTeam.class));
	}

	/**
	 * 添加缓存
	 */
	public void setUserTeamCache(UserTeam team, boolean cache){
		if(team != null){
			if(cache){
				setCacheSign();
			}
			try{
				String key = getUserTeamKey(team.getUserId());
				hmset(key, JedisBeanManager.getObjMapper(UserTeam.class).objectToMap(team));
				expire(key, SystemConstant.CACHE_EXPIRE_TIME);
			}finally{
				if(cache){
					clearCacheSign();
				}
			}
		}
	}
	/**
	 * 更新缓存
	 */
	public void updateUserTeamCache(UserTeam team){
		String key = getUserTeamKey(team.getUserId());
		hmset(key, JedisBeanManager.getObjMapper(UserTeam.class).objectToMap(team));
		expire(key, SystemConstant.CACHE_EXPIRE_TIME);
	}
	/**
	 * 清理缓存
	 */
	public void clearUserTeamCache(int userId){
		del(getUserTeamKey(userId));
	}
}
