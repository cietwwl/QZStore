package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.ArenaAward;
import com.ks.db.cfg.ArenaBuy;
import com.ks.db.cfg.MartialWayAwardExp;

/**
 * 竞技场配置
 * @author zck
 *
 */
public class ArenaCfgDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryArenaAward", dbbean=ArenaAward.class)})
	public List<ArenaAward> queryArenaAward(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ArenaAward.class, "queryArenaAward");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ArenaAward.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryArenaAwardExp", dbbean=MartialWayAwardExp.class)})
	public List<MartialWayAwardExp> queryArenaAwardExp(){
		String sql = DBBeanRowMapperManager.getDynamicSql(MartialWayAwardExp.class, "queryArenaAwardExp");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(MartialWayAwardExp.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryArenaBuys", dbbean=ArenaBuy.class)})
	public List<ArenaBuy> queryArenaBuys(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ArenaBuy.class, "queryArenaBuys");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ArenaBuy.class));
	}
}
