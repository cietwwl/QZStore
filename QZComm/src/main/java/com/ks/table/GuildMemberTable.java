package com.ks.table;
public final class GuildMemberTable extends com.ks.access.DBBeanTable<com.ks.db.model.GuildMember>{
public static GuildMemberTable instance;
public static final String TABLE_NAME="t_guild_member";
public static final String USERID="user_id";
public static final String GUILDID="guild_id";
public static final String PLAYERNAME="player_name";
public static final String LEVEL="level";
public static final String PROPERTY="property";
public static final String DEVOTE="devote";
public static final String TODAYDEVOTE="today_devote";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_GUILDID="guildId";
public static final String J_PLAYERNAME="playerName";
public static final String J_LEVEL="level";
public static final String J_PROPERTY="property";
public static final String J_DEVOTE="devote";
public static final String J_TODAYDEVOTE="todayDevote";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public GuildMemberTable(){
mapper=new DBRowMapper_GuildMember();
}
@Override
public Object getDBFieldValue(com.ks.db.model.GuildMember bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(GUILDID.equals(fname)){
return bean.getGuildId();
}
if(PLAYERNAME.equals(fname)){
return bean.getPlayerName();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(PROPERTY.equals(fname)){
return bean.getProperty();
}
if(DEVOTE.equals(fname)){
return bean.getDevote();
}
if(TODAYDEVOTE.equals(fname)){
return bean.getTodayDevote();
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
return com.ks.db.model.GuildMember.class;
}
public final static class DBRowMapper_GuildMember implements com.ks.access.mapper.RowMapper<com.ks.db.model.GuildMember>{
@Override
public com.ks.db.model.GuildMember rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.GuildMember bean = new com.ks.db.model.GuildMember();
bean.setUserId(rs.getInt("user_id"));
bean.setGuildId(rs.getInt("guild_id"));
bean.setPlayerName(rs.getString("player_name"));
bean.setLevel(rs.getInt("level"));
bean.setProperty(rs.getInt("property"));
bean.setDevote(rs.getInt("devote"));
bean.setTodayDevote(rs.getInt("today_devote"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
