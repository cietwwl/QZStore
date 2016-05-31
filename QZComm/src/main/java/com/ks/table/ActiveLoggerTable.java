package com.ks.table;
public final class ActiveLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.ActiveLogger>{
public static ActiveLoggerTable instance;
public static final String TABLE_NAME="t_active_logger";
public static final String ID="id";
public static final String PARTNER="partner";
public static final String UID="uid";
public static final String USERNAME="username";
public static final String PLAYERNAME="playername";
public static final String LOGINTIME="loginTime";
public static final String TOTALONLINETIME="totalOnlineTime";

public static final String J_ID="id";
public static final String J_PARTNER="partner";
public static final String J_UID="uid";
public static final String J_USERNAME="username";
public static final String J_PLAYERNAME="playername";
public static final String J_LOGINTIME="loginTime";
public static final String J_TOTALONLINETIME="totalOnlineTime";

public ActiveLoggerTable(){
mapper=new DBRowMapper_ActiveLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.ActiveLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(PARTNER.equals(fname)){
return bean.getPartner();
}
if(UID.equals(fname)){
return bean.getUid();
}
if(USERNAME.equals(fname)){
return bean.getUsername();
}
if(PLAYERNAME.equals(fname)){
return bean.getPlayername();
}
if(LOGINTIME.equals(fname)){
return bean.getLoginTime();
}
if(TOTALONLINETIME.equals(fname)){
return bean.getTotalOnlineTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.log.ActiveLogger.class;
}
public final static class DBRowMapper_ActiveLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.ActiveLogger>{
@Override
public com.ks.db.log.ActiveLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.ActiveLogger bean = new com.ks.db.log.ActiveLogger();
bean.setId(rs.getInt("id"));
bean.setPartner(rs.getInt("partner"));
bean.setUid(rs.getInt("uid"));
bean.setUsername(rs.getString("username"));
bean.setPlayername(rs.getString("playername"));
bean.setLoginTime(rs.getInt("loginTime"));
bean.setTotalOnlineTime(rs.getInt("totalOnlineTime"));
return bean;
}
}
}
