package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.GuildRankAward;
/**
 * 工会排名奖励dao
 * @author hanjie.l
 *
 */
public class GuildRankAwardDao extends GameCfgDAOTemplate{
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryAwards", dbbean=GuildRankAward.class)})
	public List<GuildRankAward> queryAwards(){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildRankAward.class, "queryAwards");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(GuildRankAward.class));
	}

}
