package com.ks.logic.dao;

import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.UserBuff;
import com.ks.table.UserBuffTable;

public class UserBuffDAO extends GameDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserBuffs", dbbean=UserBuff.class, wheres={UserBuffTable.USERID})})
	public List<UserBuff> queryUserBuffs(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserBuff.class, "queryUserBuffs");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(UserBuff.class), userId);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addUserBuff", dbbean=UserBuff.class)})
	public void addUserBuff(UserBuff buff){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserBuff.class, "addUserBuff");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserBuff.class, "addUserBuff", buff);
		saveOrUpdate(sql, params.toArray());
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateUserBuff", dbbean=UserBuff.class, wheres={UserBuffTable.USERID, UserBuffTable.EFFECTID})})
	public void updateUserBuff(UserBuff buff){
		buff.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(UserBuff.class, "updateUserBuff");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(UserBuff.class, "updateUserBuff", buff);
		saveOrUpdate(sql, params.toArray());
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryUserBuff", dbbean=UserBuff.class, wheres={UserBuffTable.USERID, UserBuffTable.EFFECTID})})
	public UserBuff queryUserBuff(int userId,int effectId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserBuff.class, "queryUserBuff");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(UserBuff.class), userId,effectId);
	}
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteUserBuff", dbbean=UserBuff.class, wheres={UserBuffTable.USERID, UserBuffTable.EFFECTID})})
	public void deleteUserBuff(int userId,int effectId){
		String sql = DBBeanRowMapperManager.getDynamicSql(UserBuff.class, "deleteUserBuff");
		saveOrUpdate(sql, userId,effectId);
	}
}
