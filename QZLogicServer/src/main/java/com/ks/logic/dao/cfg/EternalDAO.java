package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalEffect;
import com.ks.db.cfg.EternalProperty;
/**
 * 武魂
 * @author ks
 */
public class EternalDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEternals", dbbean=Eternal.class)})
	public List<Eternal> queryEternals(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Eternal.class, "queryEternals");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Eternal.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEternalEffects", dbbean=EternalEffect.class)})
	public List<EternalEffect> queryEternalEffects(){
		String sql = DBBeanRowMapperManager.getDynamicSql(EternalEffect.class, "queryEternalEffects");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(EternalEffect.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryEnternalPropertys", dbbean=EternalProperty.class)})
	public List<EternalProperty> queryEnternalPropertys(){
		String sql = DBBeanRowMapperManager.getDynamicSql(EternalProperty.class, "queryEnternalPropertys");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(EternalProperty.class));
	}
}
