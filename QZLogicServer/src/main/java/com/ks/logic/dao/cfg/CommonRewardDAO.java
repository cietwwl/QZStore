package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.CommonRewardConfig;

public class CommonRewardDAO extends GameCfgDAOTemplate{
	
	/**
	 * 查询通用奖励配置
	 */
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryCommonRewardConfigs", dbbean=CommonRewardConfig.class)})
	public List<CommonRewardConfig> queryCommonRewardConfigs(){
		String sql = DBBeanRowMapperManager.getDynamicSql(CommonRewardConfig.class, "queryCommonRewardConfigs");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(CommonRewardConfig.class));
	}

}
