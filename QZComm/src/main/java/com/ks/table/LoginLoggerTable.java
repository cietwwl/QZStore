package com.ks.table;
public final class LoginLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.LoginLogger>{
public static LoginLoggerTable instance;
public static final String TABLE_NAME="t_login_logger";
public static final String ID="id";
public static final String USERID="userId";
public static final String PLAYERNAME="playername";
public static final String TYPE="type";
public static final String TIME="time";

public static final String J_ID="id";
public static final String J_USERID="userId";
public static final String J_PLAYERNAME="playername";
public static final String J_TYPE="type";
public static final String J_TIME="time";

public LoginLoggerTable(){
mapper=new DBRowMapper_LoginLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.LoginLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(PLAYERNAME.equals(fname)){
return bean.getPlayername();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(TIME.equals(fname)){
return bean.getTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.log.LoginLogger.class;
}
public final static class DBRowMapper_LoginLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.LoginLogger>{
@Override
public com.ks.db.log.LoginLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.LoginLogger bean = new com.ks.db.log.LoginLogger();
bean.setId(rs.getInt("id"));
bean.setUserId(rs.getInt("userId"));
bean.setPlayername(rs.getString("playername"));
bean.setType(rs.getInt("type"));
bean.setTime(rs.getInt("time"));
return bean;
}
}
}
