package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentProperty;
import com.ks.db.cfg.EquipmentUp;
import com.ks.db.cfg.EquipmentUpRate;

public class EquipmentDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEquipment", dbbean=Equipment.class)})
	public List<Equipment> queryEquipment(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Equipment.class, "queryEquipment");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Equipment.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEquipmentUp", dbbean=EquipmentUp.class)})
	public List<EquipmentUp> queryEquipmentUp(){
		String sql = DBBeanRowMapperManager.getDynamicSql(EquipmentUp.class, "queryEquipmentUp");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(EquipmentUp.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEquipmentUpRate", dbbean=EquipmentUpRate.class)})
	public List<EquipmentUpRate> queryEquipmentUpRate(){
		String sql = DBBeanRowMapperManager.getDynamicSql(EquipmentUpRate.class, "queryEquipmentUpRate");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(EquipmentUpRate.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEquipmentProperty", dbbean=EquipmentProperty.class)})
	public List<EquipmentProperty> queryEquipmentProperty(){
		String sql = DBBeanRowMapperManager.getDynamicSql(EquipmentProperty.class, "queryEquipmentProperty");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(EquipmentProperty.class));
	}
	
}
