package com.ks.logic.dao;

import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetDeleteSqlSet;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSelectSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.DBBeanSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.access.SQLOpt;
import com.ks.db.model.Guild;
import com.ks.table.GuildTable;
/**
 * 工会dao
 * @author hanjie.l
 *
 */
public class GuildDAO extends GameDAOTemplate {
	
	String QUERYGUILDCOUNT_SQL = "select count(1) from " + GuildTable.TABLE_NAME + " where " + GuildTable.NAME + "=?";
	public int queryGuildCount(String name){
		return queryForEntity(QUERYGUILDCOUNT_SQL, INT_ROW_MAPPER, name);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuild", dbbean=Guild.class, wheres={GuildTable.GUILDID})})
	public Guild queryGuild(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Guild.class, "queryGuild");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(Guild.class), guildId);
	}
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildLock", dbbean=Guild.class, wheres={GuildTable.GUILDID}, forupdate=true)})
	public Guild queryGuildLock(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Guild.class, "queryGuildLock");
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(Guild.class), guildId);
	}
	
	String QUERYMYGUILDRANK_SQL = "select count(1) from " + GuildTable.TABLE_NAME + " where `" + GuildTable.EXP + "`>?";
	public int queryMyGuildRank(int exp){	
		return queryForEntity(QUERYMYGUILDRANK_SQL, INT_ROW_MAPPER, exp);
	}
	
	@DBBeanSetSqlSetList(selects={@DBBeanSetSelectSqlSet(name="queryGuildRank", dbbean=Guild.class, oderby=GuildTable.EXP + " desc," + GuildTable.CREATETIME + " asc" ,  limit={"?", "10"})})
	public List<Guild> queryGuildRank(int pageIndex){
		String sql = DBBeanRowMapperManager.getDynamicSql(Guild.class, "queryGuildRank");
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(Guild.class), pageIndex*10);
	}

	String sql = "select count(1) from " + GuildTable.TABLE_NAME;
	public int queryGuildCount(){
		return queryForEntity(sql, INT_ROW_MAPPER);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addGuild", dbbean=Guild.class)})
	public void addGuild(Guild guild){
		String sql = DBBeanRowMapperManager.getDynamicSql(Guild.class, "addGuild");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(Guild.class, "addGuild", guild);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(deletes={@DBBeanSetDeleteSqlSet(name="deleteGuild", dbbean=Guild.class, wheres={GuildTable.GUILDID})})
	public void deleteGuild(int guildId){
		String sql = DBBeanRowMapperManager.getDynamicSql(Guild.class, "deleteGuild");
		saveOrUpdate(sql, guildId);
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateGuild", dbbean=Guild.class, auto_fields=true, wheres={GuildTable.GUILDID})})
	public void updateGuild(SQLOpt opt,Guild guild){
		guild.setUpdateTime(new Date());
		opt.putFieldOpt(GuildTable.UPDATETIME, SQLOpt.EQUAL);
		DBBeanSqlSet set = DBBeanRowMapperManager.getDynamicUpdateDBBeanSqlSet(Guild.class, "updateGuild", guild, opt);
		saveOrUpdate(set.getSql(), set.getParams().toArray());
	}
	

}
