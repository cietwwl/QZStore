package com.ks.logic.dao;

import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.GameDAOTemplate;
import com.ks.db.model.GuildApply;
import com.ks.table.GuildApplyTable;

public class GuildApplyDAO extends GameDAOTemplate {
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildApply", dbbean=GuildApply.class, wheres={GuildApplyTable.USERID})})
	public GuildApply queryGuildApply(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildApply.class, "queryGuildApply");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(GuildApply.class), userId);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildApplys", dbbean=GuildApply.class, wheres={GuildApplyTable.GUILDID}, oderby=GuildApplyTable.CREATETIME + " desc", limit={"?", "10"})})
	public List<GuildApply> queryGuildApplys(int guildId,int pageIndex){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildApply.class, "queryGuildApplys");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(GuildApply.class), guildId,pageIndex*10);
	}
	
	public int queryGuildApplyCount(int guildId){
		String sql = "select count(1) from " + GuildApplyTable.TABLE_NAME + " where " + GuildApplyTable.GUILDID + "=?";
		return queryForEntity(sql, INT_ROW_MAPPER, guildId);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addGuildApply", dbbean=GuildApply.class)})
	public void addGuildApply(GuildApply guildApply){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildApply.class, "addGuildApply");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildApply.class, "addGuildApply", guildApply);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteGuildApply", dbbean=GuildApply.class, wheres={GuildApplyTable.USERID})})
	public void deleteGuildApply(int userId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildApply.class, "deleteGuildApply");
		saveOrUpdate(sql, userId);
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteAllGuildApply", dbbean=GuildApply.class, wheres={GuildApplyTable.GUILDID})})
	public void deleteAllGuildApply(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildApply.class, "deleteAllGuildApply");
		saveOrUpdate(sql, guildId);
	}
}
