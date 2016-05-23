package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.VipConfig;
/**
 * vip
 * @author ks
 */
public class VIPDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryVipConfigs", dbbean=VipConfig.class)})
	public List<VipConfig> queryVipConfigs(){
		String sql = DBBeanRowMapperManager.getDynamicSql(VipConfig.class, "queryVipConfigs");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(VipConfig.class));
	}
}
