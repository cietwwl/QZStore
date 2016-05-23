package com.ks.logic.dao;

import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.DBBeanSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.access.SQLOpt;
import com.ks.cache.JedisBeanManager;
import com.ks.constant.SystemConstant;
import com.ks.db.model.UserStat;
import com.ks.table.UserStatTable;

public class UserStatDAO extends GameDAOTemplate {

	private static final String USER_STAT = "USER_STAT_";
	
	private static final String getUserStatKey(int userId){
		return USER_STAT+userId;
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserStat", dbbean=UserStat.class, wheres={UserStatTable.USERID})})
	public UserStat queryUserStat(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserStat.class, "queryUserStat");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserStat.class), userId);
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserStat", dbbean=UserStat.class, auto_fields=true, wheres={UserStatTable.USERID})})
	public void updateUserStat(SQLOpt opt,UserStat stat){
		stat.setUpdateTime(new Date());
		opt.putFieldOpt(UserStatTable.UPDATETIME, SQLOpt.EQUAL);
		DBBeanSqlSet set = DBBeanRowMapperManager.getDynamicUpdateDBBeanSqlSet(UserStat.class, "updateUserStat", stat, opt);
		saveOrUpdate(set.getSql(), set.getParams().toArray());
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserStat", dbbean=UserStat.class)})
	public void addUserStat(UserStat stat){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserStat.class, "addUserStat");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserStat.class, "addUserStat", stat);
		saveOrUpdate(sql, params.toArray());
	}
	
	/*******************************************************user_stat cache********************************************************************/
	/**
	 * 查询缓存
	 */
	public UserStat queryUserStatCache(int userId){
		String key = getUserStatKey(userId);
		expire(key, SystemConstant.CACHE_EXPIRE_TIME);
		return hgetAll(key, JedisBeanManager.getRowMapper(UserStat.class));
	}

	/**
	 * 添加缓存
	 */
	public void setUserStatCache(UserStat stat, boolean cache){
		if(stat != null){
			if(cache){
				setCacheSign();
			}
			try{
				String key = getUserStatKey(stat.getUserId());
				hmset(key, JedisBeanManager.getObjMapper(UserStat.class).objectToMap(stat));
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
	public void updateUserStatCache(UserStat stat){
		setUserStatCache(stat, exists(getUserStatKey(stat.getUserId())));
	}
	/**
	 * 清理缓存
	 */
	public void clearUserStatCache(int userId){
		del(getUserStatKey(userId));
	}
}
