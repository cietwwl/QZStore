package com.ks.table;
public final class ArenaLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.model.ArenaLogger>{
public static ArenaLoggerTable instance;
public static final String ID="id";
public static final String USERID="user_id";
public static final String USERNAME="user_name";
public static final String MATCHUSERNAME="match_user_name";
public static final String MATCHLEVEL="match_level";
public static final String MATCHUSERID="match_user_id";
public static final String WINLOS="win_los";
public static final String CAPID="cap_id";
public static final String CREATETIME="create_time";
public static final String TYPE="type";

public static final String J_ID="id";
public static final String J_USERID="userId";
public static final String J_USERNAME="userName";
public static final String J_MATCHUSERNAME="matchUserName";
public static final String J_MATCHLEVEL="matchLevel";
public static final String J_MATCHUSERID="matchUserId";
public static final String J_WINLOS="winLos";
public static final String J_CAPID="capId";
public static final String J_CREATETIME="createTime";
public static final String J_TYPE="type";

public ArenaLoggerTable(){
mapper=new DBRowMapper_ArenaLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.model.ArenaLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(USERNAME.equals(fname)){
return bean.getUserName();
}
if(MATCHUSERNAME.equals(fname)){
return bean.getMatchUserName();
}
if(MATCHLEVEL.equals(fname)){
return bean.getMatchLevel();
}
if(MATCHUSERID.equals(fname)){
return bean.getMatchUserId();
}
if(WINLOS.equals(fname)){
return bean.getWinLos();
}
if(CAPID.equals(fname)){
return bean.getCapId();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(TYPE.equals(fname)){
return bean.getType();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.ArenaLogger.class;
}
public final static class DBRowMapper_ArenaLogger implements com.ks.access.mapper.RowMapper<com.ks.db.model.ArenaLogger>{
@Override
public com.ks.db.model.ArenaLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.ArenaLogger bean = new com.ks.db.model.ArenaLogger();
bean.setId(rs.getInt("id"));
bean.setUserId(rs.getInt("user_id"));
bean.setUserName(rs.getString("user_name"));
bean.setMatchUserName(rs.getString("match_user_name"));
bean.setMatchLevel(rs.getInt("match_level"));
bean.setMatchUserId(rs.getInt("match_user_id"));
bean.setWinLos(rs.getInt("win_los"));
bean.setCapId(rs.getInt("cap_id"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setType(rs.getInt("type"));
return bean;
}
}
}
