package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.ActivityZone;

public class ActivityZoneDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryActivityZone", dbbean=ActivityZone.class)})
	public List<ActivityZone> queryActivityZone(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ActivityZone.class, "queryActivityZone");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ActivityZone.class));
	}
}
