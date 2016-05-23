package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Drop;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.MonsterAtkMode;

public class MonsterDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMonster", dbbean=Monster.class)})
	public List<Monster> queryMonster(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Monster.class, "queryMonster");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Monster.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryMonsterAtkMode", dbbean=MonsterAtkMode.class)})
	public List<MonsterAtkMode> queryMonsterAtkMode(){
		String sql = DBBeanRowMapperManager.getDynamicSql(MonsterAtkMode.class, "queryMonsterAtkMode");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(MonsterAtkMode.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryDrops", dbbean=Drop.class)})
	public List<Drop> queryDrops(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Drop.class, "queryDrops");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Drop.class));
	}
}
