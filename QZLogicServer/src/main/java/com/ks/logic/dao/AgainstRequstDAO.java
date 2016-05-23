package com.ks.logic.dao;

import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.AgainstRequst;
import com.ks.table.AgainstRequstTable;
/**
 * 对战请求
 * @author ks
 */
public class AgainstRequstDAO extends GameDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAgainstRequst", dbbean=AgainstRequst.class, wheres={AgainstRequstTable.USERID})})
	public AgainstRequst queryAgainstRequst(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(AgainstRequst.class, "queryAgainstRequst");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(AgainstRequst.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAgainstRequstLock", dbbean=AgainstRequst.class, wheres={AgainstRequstTable.USERID}, forupdate=true)})
	public AgainstRequst queryAgainstRequstLock(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(AgainstRequst.class, "queryAgainstRequstLock");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(AgainstRequst.class), userId);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addAgainstRequst", dbbean=AgainstRequst.class)})
	public void addAgainstRequst(AgainstRequst ar){
		String sql = DBBeanRowMapperManager.getDynamicSql(AgainstRequst.class, "addAgainstRequst");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(AgainstRequst.class, "addAgainstRequst", ar);
		saveOrUpdate(sql, params.toArray());
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateAgainstRequst", dbbean=AgainstRequst.class, wheres={AgainstRequstTable.USERID})})
	public void updateAgainstRequst(AgainstRequst ar){
		ar.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(AgainstRequst.class, "updateAgainstRequst");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(AgainstRequst.class, "addAgainstRequst", ar);
		saveOrUpdate(sql, params.toArray());
	}
}
