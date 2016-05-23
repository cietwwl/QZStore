package com.ks.table;
public final class GuildApplyTable extends com.ks.access.DBBeanTable<com.ks.db.model.GuildApply>{
public static GuildApplyTable instance;
public static final String TABLE_NAME="t_guild_apply";
public static final String USERID="user_id";
public static final String GUILDID="guild_id";
public static final String CREATETIME="create_time";

public static final String J_USERID="userId";
public static final String J_GUILDID="guildId";
public static final String J_CREATETIME="createTime";

public GuildApplyTable(){
mapper=new DBRowMapper_GuildApply();
}
@Override
public Object getDBFieldValue(com.ks.db.model.GuildApply bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(GUILDID.equals(fname)){
return bean.getGuildId();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.GuildApply.class;
}
public final static class DBRowMapper_GuildApply implements com.ks.access.mapper.RowMapper<com.ks.db.model.GuildApply>{
@Override
public com.ks.db.model.GuildApply rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.GuildApply bean = new com.ks.db.model.GuildApply();
bean.setUserId(rs.getInt("user_id"));
bean.setGuildId(rs.getInt("guild_id"));
bean.setCreateTime(rs.getTimestamp("create_time"));
return bean;
}
}
}
