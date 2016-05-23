package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.CallHero;
import com.ks.db.cfg.CallHeroRule;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroEvo;
import com.ks.db.cfg.HeroEvoMaterial;
import com.ks.db.cfg.HeroRelation;
import com.ks.db.cfg.HeroRule;

public class HeroDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeros", dbbean=Hero.class)})
	public List<Hero> queryHeros(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Hero.class, "queryHeros");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Hero.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeroRule", dbbean=HeroRule.class)})
	public List<HeroRule> queryHeroRule(){
		String sql = DBBeanRowMapperManager.getDynamicSql(HeroRule.class, "queryHeroRule");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(HeroRule.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeroEvo", dbbean=HeroEvo.class)})
	public List<HeroEvo> queryHeroEvo(){
		String sql = DBBeanRowMapperManager.getDynamicSql(HeroEvo.class, "queryHeroEvo");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(HeroEvo.class));
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeroEvoMaterial", dbbean=HeroEvoMaterial.class)})
	public List<HeroEvoMaterial> queryHeroEvoMaterial(){
		String sql = DBBeanRowMapperManager.getDynamicSql(HeroEvoMaterial.class, "queryHeroEvoMaterial");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(HeroEvoMaterial.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryCallHeroRule", dbbean=CallHeroRule.class)})
	public List<CallHeroRule> queryCallHeroRule(){
		String sql = DBBeanRowMapperManager.getDynamicSql(CallHeroRule.class, "queryCallHeroRule");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(CallHeroRule.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryCallHero", dbbean=CallHero.class)})
	public List<CallHero> queryCallHero(){
		String sql = DBBeanRowMapperManager.getDynamicSql(CallHero.class, "queryCallHero");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(CallHero.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryHeroRelation", dbbean=HeroRelation.class)})
	public List<HeroRelation> queryHeroRelation(){
		String sql = DBBeanRowMapperManager.getDynamicSql(HeroRelation.class, "queryHeroRelation");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(HeroRelation.class));
	}
	
}
