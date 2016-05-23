package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.ExploreAward;
/**
 * 探索奖励配置表
 * @author hanjie.l
 *
 */
public class ExploreSettingDAO extends GameCfgDAOTemplate{
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryExploreAwards", dbbean=ExploreAward.class)})
	public List<ExploreAward> queryExploreAwards(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ExploreAward.class, "queryExploreAwards");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ExploreAward.class));
	}

}
