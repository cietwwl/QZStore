package com.ks.logic.dao;

import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.UserAchieve;
import com.ks.table.UserAchieveTable;

public class UserAchieveDAO extends GameDAOTemplate {
	private static final String getTableName(int userId){
		return "t_user_achieve_"+(userId%10);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserAchieves", dbbean=UserAchieve.class, wheres={UserAchieveTable.USERID})})
	public List<UserAchieve> queryUserAchieves(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserAchieve.class, "queryUserAchieves", getTableName(userId));
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserAchieve.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserAchieve", dbbean=UserAchieve.class, wheres={UserAchieveTable.USERID, UserAchieveTable.ACHIEVEID})})
	public UserAchieve queryUserAchieve(int userId,int achieveId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserAchieve.class, "queryUserAchieve", getTableName(userId));
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserAchieve.class), userId,achieveId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryCurrAchieve", dbbean=UserAchieve.class, wheres={UserAchieveTable.USERID, UserAchieveTable.ACHIEVETYPE, UserAchieveTable.ASSID}, oderby=UserAchieveTable.ACHIEVEID + " desc", limit={"1"})})
	public UserAchieve queryCurrAchieve(int userId,int achieveType,int assId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserAchieve.class, "queryCurrAchieve", getTableName(userId));
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserAchieve.class), userId,achieveType,assId);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserAchieve", dbbean=UserAchieve.class, wheres={UserAchieveTable.USERID, UserAchieveTable.ACHIEVEID})})
	public void updateUserAchieve(UserAchieve achieve){
		achieve.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(UserAchieve.class, "updateUserAchieve", getTableName(achieve.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserAchieve.class, "updateUserAchieve", achieve);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserAchieve", dbbean=UserAchieve.class)})
	public void addUserAchieve(UserAchieve achieve){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserAchieve.class, "addUserAchieve", getTableName(achieve.getUserId()));
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserAchieve.class, "addUserAchieve", achieve);
		saveOrUpdate(sql, params.toArray());
	}
}
