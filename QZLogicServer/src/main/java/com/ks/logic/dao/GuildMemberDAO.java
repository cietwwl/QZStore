package com.ks.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ks.access.DBBeanRowMapperManager;
import com.ks.access.DBBeanSetInsertSqlSet;
import com.ks.access.DBBeanSetSqlSetList;
import com.ks.access.DBBeanSetUpdateSqlSet;
import com.ks.access.DBBeanSqlSet;
import com.ks.access.GameDAOTemplate;
import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.model.GuildMember;
import com.ks.table.GuildMemberTable;

public class GuildMemberDAO extends GameDAOTemplate {
	
	public GuildMember queryCdr(int guildId){
		String sql = "select * from t_guild_member where guild_id=? and property=?";
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(GuildMember.class), guildId, SystemConstant.GUILD_MEMBER_会长);
	}
	
	public GuildMember queryGuildMember(int userId){
		String sql = "select * from t_guild_member where user_id=?";
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(GuildMember.class), userId);
	}
	public GuildMember queryGuildMemberLock(int userId){
		String sql = "select * from t_guild_member where user_id=? for update";
		return queryForEntity(sql, DBBeanRowMapperManager.getRowMapper(GuildMember.class), userId);
	}
	public List<GuildMember> queryGuildMembers(int guildId){
		String sql = "select * from t_guild_member where guild_id=? order by today_devote desc,create_time asc";
		return queryForList(sql, DBBeanRowMapperManager.getRowMapper(GuildMember.class), guildId);
	}
	
	@DBBeanSetSqlSetList(inserts={@DBBeanSetInsertSqlSet(name="addGuildMember", dbbean=GuildMember.class)})
	public void addGuildMember(GuildMember gm) {
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildMember.class, "addGuildMember");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildMember.class, "addGuildMember", gm);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateGuildMember", dbbean=GuildMember.class, wheres={GuildMemberTable.USERID})})
	public void updateGuildMember(GuildMember gm) {
		gm.setUpdateTime(new Date());
		String sql = DBBeanRowMapperManager.getDynamicSql(GuildMember.class, "updateGuildMember");
		List<Object> params = DBBeanRowMapperManager.getDynamicParams(GuildMember.class, "updateGuildMember", gm);
		saveOrUpdate(sql, params.toArray());
	}
	
	@DBBeanSetSqlSetList(updates={@DBBeanSetUpdateSqlSet(name="updateGuildMemberByOpt", dbbean=GuildMember.class, auto_fields=true, wheres={GuildMemberTable.USERID})})
	public void updateGuildMemberByOpt(SQLOpt opt, GuildMember member){
		member.setUpdateTime(new Date());
		opt.putFieldOpt(GuildMemberTable.UPDATETIME, SQLOpt.EQUAL);
		DBBeanSqlSet set = DBBeanRowMapperManager.getDynamicUpdateDBBeanSqlSet(GuildMember.class, "updateGuildMemberByOpt", member, opt);
		saveOrUpdate(set.getSql(), set.getParams().toArray());
	}
	
	public void deleteGuildMember(int userId){
		String sql = "delete from t_guild_member where user_id=?";
		saveOrUpdate(sql, userId);
	}
	public void deleteAllGuildMember(int guildId){
		String sql = "delete from t_guild_member where guild_id=?";
		saveOrUpdate(sql, guildId);
	}
	
	public List<Integer> queryAllMemberId(){
		String sql = "select user_id from t_guild_member where today_devote!=0";
		return queryForList(sql, INT_ROW_MAPPER);
	}
	
	public void clearTodayDevote(List<Integer> userIds){
		String sql = "update t_guild_member set today_devote=0 where user_id=?";
		List<Object[]> args = new ArrayList<Object[]>();
		for(int userId : userIds){
			Object[] arg = new Object[]{userId};
			args.add(arg);
		}
		executeBatch(sql, args);
	}
}
