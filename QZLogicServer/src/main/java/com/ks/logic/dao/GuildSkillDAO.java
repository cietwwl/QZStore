package com.ks.logic.dao;

import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.GuildSkill;
import com.ks.table.GuildSkillTable;

public class GuildSkillDAO extends GameDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildSkills", dbbean=GuildSkill.class, wheres={GuildSkillTable.GUILDID})})
	public List<GuildSkill> queryGuildSkills(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildSkill.class, "queryGuildSkills");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(GuildSkill.class), guildId);
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildSkill", dbbean=GuildSkill.class, wheres={GuildSkillTable.GUILDID, GuildSkillTable.SKILLID})})
	public GuildSkill queryGuildSkill(int guildId,int skillId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildSkill.class, "queryGuildSkill");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(GuildSkill.class), guildId,skillId);
	}
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addGuildSkill", dbbean=GuildSkill.class)})
	public void addGuildSkill(GuildSkill gs){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildSkill.class, "addGuildSkill");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildSkill.class, "addGuildSkill", gs);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateGuildSkill", dbbean=GuildSkill.class, wheres={GuildSkillTable.GUILDID, GuildSkillTable.SKILLID})})
	public void updateGuildSkill(GuildSkill gs){
		gs.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildSkill.class, "updateGuildSkill");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildSkill.class, "updateGuildSkill", gs);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteGuildSkill", dbbean=GuildSkill.class, wheres={GuildSkillTable.GUILDID})})
	public void deleteGuildSkill(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildSkill.class, "deleteGuildSkill");
		saveOrUpdate(sql, guildId);
	}
	
}