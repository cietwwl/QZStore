package com.ks.logic.dao.cfg;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameCfgDAOTemplate;
import com.ks.db.cfg.PassiveSkill;
import com.ks.db.cfg.Skill;
import com.ks.db.cfg.SkillEffect;

public class SkillDAO extends GameCfgDAOTemplate {

	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="querySkills", dbbean=Skill.class)})
	public List<Skill> querySkills(){
		String sql = DBBeanRowMapperManager.getDynamicSql(Skill.class, "querySkills");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Skill.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="querySkillEffects", dbbean=SkillEffect.class)})
	public List<SkillEffect> querySkillEffects(){
		String sql = DBBeanRowMapperManager.getDynamicSql(SkillEffect.class, "querySkillEffects");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(SkillEffect.class));
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryPassiveSkill", dbbean=PassiveSkill.class)})
	public List<PassiveSkill> queryPassiveSkill(){
		String sql = DBBeanRowMapperManager.getDynamicSql(PassiveSkill.class, "queryPassiveSkill");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(PassiveSkill.class));
	}
}
