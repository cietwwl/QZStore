package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.BlowingRule;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.PropEffect;

public class PropDAO extends GameCfgDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryProps", dbbean=Prop.class)})
	public List<Prop> queryProps(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Prop.class, "queryProps");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Prop.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryPropEffects", dbbean=PropEffect.class)})
	public List<PropEffect> queryPropEffects(){
		String sql = DBBeanRowMapperManager.getDynamicSql(PropEffect.class, "queryPropEffects");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(PropEffect.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryBlowingRule", dbbean=BlowingRule.class)})
	public List<BlowingRule> queryBlowingRule(){
		String sql = DBBeanRowMapperManager.getDynamicSql(BlowingRule.class, "queryBlowingRule");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(BlowingRule.class));
	}
}