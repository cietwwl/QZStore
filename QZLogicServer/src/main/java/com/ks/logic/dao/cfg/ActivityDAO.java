package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.PeriodActivityTime;

public class ActivityDAO extends GameCfgDAOTemplate{
	
	/**
	 * 查询周期活动时间
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryPeriodActivityTimes", dbbean=PeriodActivityTime.class)})
	public List<PeriodActivityTime> queryPeriodActivityTimes(){
		String sql = DBBeanRowMapperManager.getDynamicSql(PeriodActivityTime.class, "queryPeriodActivityTimes");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(PeriodActivityTime.class));
	}

}
