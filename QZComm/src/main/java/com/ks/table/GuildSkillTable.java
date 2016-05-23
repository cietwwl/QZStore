package com.ks.table;
public final class GuildSkillTable extends com.ks.access.DBBeanTable<com.ks.db.model.GuildSkill>{
public static GuildSkillTable instance;
public static final String TABLE_NAME="t_guild_skill";
public static final String GUILDID="guild_id";
public static final String SKILLID="skill_id";
public static final String GP="gp";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_GUILDID="guildId";
public static final String J_SKILLID="skillId";
public static final String J_GP="gp";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public GuildSkillTable(){
mapper=new DBRowMapper_GuildSkill();
}
@Override
public Object getDBFieldValue(com.ks.db.model.GuildSkill bean, String fname){
if(GUILDID.equals(fname)){
return bean.getGuildId();
}
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
if(GP.equals(fname)){
return bean.getGp();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.GuildSkill.class;
}
public final static class DBRowMapper_GuildSkill implements com.ks.access.mapper.RowMapper<com.ks.db.model.GuildSkill>{
@Override
public com.ks.db.model.GuildSkill rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.GuildSkill bean = new com.ks.db.model.GuildSkill();
bean.setGuildId(rs.getInt("guild_id"));
bean.setSkillId(rs.getInt("skill_id"));
bean.setGp(rs.getInt("gp"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
