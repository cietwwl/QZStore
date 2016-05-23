package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.ConstantConfig;

public class ConstantDAO extends GameCfgDAOTemplate{

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryConstantConfigs", dbbean=ConstantConfig.class)})
	public List<ConstantConfig> queryConstantConfigs(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ConstantConfig.class, "queryConstantConfigs");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ConstantConfig.class));
	}
}
