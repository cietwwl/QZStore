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
import com.ks.db.model.GuildAccuse;
import com.ks.table.GuildAccuseTable;

public class GuildAccuseDAO extends GameDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildAccuse", dbbean=GuildAccuse.class, wheres={GuildAccuseTable.GUILDID})})
	public GuildAccuse queryGuildAccuse(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildAccuse.class, "queryGuildAccuse");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(GuildAccuse.class), guildId);
	}
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateGuildAccuse", dbbean=GuildAccuse.class, fields={GuildAccuseTable.UPDATETIME, GuildAccuseTable.RESPER}, wheres={GuildAccuseTable.GUILDID})})
	public void updateGuildAccuse(GuildAccuse ga){
		ga.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildAccuse.class, "updateGuildAccuse");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildAccuse.class, "updateGuildAccuse", ga);
		saveOrUpdate(sql, params.toArray());
	}
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteGuildAccuse", dbbean=GuildAccuse.class, wheres={GuildAccuseTable.GUILDID})})
	public void deleteGuildAccuse(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildAccuse.class, "deleteGuildAccuse");
		saveOrUpdate(sql, guildId);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addGuildAccuse", dbbean=GuildAccuse.class)})
	public void addGuildAccuse(GuildAccuse ga){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildAccuse.class, "addGuildAccuse");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildAccuse.class, "addGuildAccuse", ga);
		saveOrUpdate(sql, params.toArray());
	}
}
