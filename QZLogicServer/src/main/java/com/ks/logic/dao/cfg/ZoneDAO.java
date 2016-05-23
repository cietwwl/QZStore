package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.BreadStoreRule;
import com.ks.db.cfg.Zone;
import com.ks.db.cfg.ZoneAward;
import com.ks.db.cfg.ZoneBattle;
/**
 * 副本
 * @author ks
 */
public class ZoneDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryZoneAward", dbbean=ZoneAward.class)})
	public List<ZoneAward> queryZoneAward(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ZoneAward.class, "queryZoneAward");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ZoneAward.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryZone", dbbean=Zone.class)})
	public List<Zone> queryZone(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Zone.class, "queryZone");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Zone.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryZoneBattle", dbbean=ZoneBattle.class)})
	public List<ZoneBattle> queryZoneBattle(){
		String sql = DBBeanRowMapperManager.getDynamicSql(ZoneBattle.class, "queryZoneBattle");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(ZoneBattle.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryBattleRound", dbbean=BattleRound.class)})
	public List<BattleRound> queryBattleRound(){
		String sql = DBBeanRowMapperManager.getDynamicSql(BattleRound.class, "queryBattleRound");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(BattleRound.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryBreadStoreRules", dbbean=BreadStoreRule.class)})
	public List<BreadStoreRule> queryBreadStoreRules(){
		String sql = DBBeanRowMapperManager.getDynamicSql(BreadStoreRule.class, "queryBreadStoreRules");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(BreadStoreRule.class));
	}
}
