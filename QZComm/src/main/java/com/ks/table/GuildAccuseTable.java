package com.ks.table;
public final class GuildAccuseTable extends com.ks.access.DBBeanTable<com.ks.db.model.GuildAccuse>{
public static GuildAccuseTable instance;
public static final String TABLE_NAME="t_guild_accuse";
public static final String GUILDID="guild_id";
public static final String ORIGINATOR="originator";
public static final String PLAYERNAME="player_name";
public static final String RESPER="resper";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_GUILDID="guildId";
public static final String J_ORIGINATOR="originator";
public static final String J_PLAYERNAME="playerName";
public static final String J_RESPER="resper";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public GuildAccuseTable(){
mapper=new DBRowMapper_GuildAccuse();
}
@Override
public Object getDBFieldValue(com.ks.db.model.GuildAccuse bean, String fname){
if(GUILDID.equals(fname)){
return bean.getGuildId();
}
if(ORIGINATOR.equals(fname)){
return bean.getOriginator();
}
if(PLAYERNAME.equals(fname)){
return bean.getPlayerName();
}
if(RESPER.equals(fname)){
return bean.getResper();
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
return com.ks.db.model.GuildAccuse.class;
}
public final static class DBRowMapper_GuildAccuse implements com.ks.access.mapper.RowMapper<com.ks.db.model.GuildAccuse>{
@Override
public com.ks.db.model.GuildAccuse rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.GuildAccuse bean = new com.ks.db.model.GuildAccuse();
bean.setGuildId(rs.getInt("guild_id"));
bean.setOriginator(rs.getInt("originator"));
bean.setPlayerName(rs.getString("player_name"));
bean.setResper(rs.getString("resper"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
