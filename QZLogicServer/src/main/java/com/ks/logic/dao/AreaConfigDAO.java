package com.ks.logic.dao;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.AreaConfig;
import com.ks.table.AreaConfigTable;

public class AreaConfigDAO extends GameDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAreaConfig", dbbean=AreaConfig.class, wheres={AreaConfigTable.ID})})
	public AreaConfig queryAreaConfig(int id){
		String sql = DBBeanRowMapperManager.getDynamicSql(AreaConfig.class, "queryAreaConfig");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(AreaConfig.class), id);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryLockAreaConfig", dbbean=AreaConfig.class, wheres={AreaConfigTable.ID})})
	public AreaConfig queryLockAreaConfig(int id){
		String sql = DBBeanRowMapperManager.getDynamicSql(AreaConfig.class, "queryLockAreaConfig");
		sql += " for update";
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(AreaConfig.class), id);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="updateAreaConfig", dbbean=AreaConfig.class, wheres={AreaConfigTable.ID})})
	public void updateAreaConfig(AreaConfig config){
		String sql = DBBeanRowMapperManager.getDynamicSql(AreaConfig.class, "updateAreaConfig");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(AreaConfig.class, "updateAreaConfig", config);
		saveOrUpdate(sql, params.toArray());
	}
}
