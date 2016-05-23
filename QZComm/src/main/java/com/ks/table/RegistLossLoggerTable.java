package com.ks.table;
public final class RegistLossLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.RegistLossLogger>{
public static RegistLossLoggerTable instance;
public static final String TABLE_NAME="t_regist_loss_logger";
public static final String ID="id";
public static final String TYPE="type";
public static final String USERNAME="username";
public static final String PARTNER="partner";
public static final String TIME="time";

public static final String J_ID="id";
public static final String J_TYPE="type";
public static final String J_USERNAME="username";
public static final String J_PARTNER="partner";
public static final String J_TIME="time";

public RegistLossLoggerTable(){
mapper=new DBRowMapper_RegistLossLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.RegistLossLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(USERNAME.equals(fname)){
return bean.getUsername();
}
if(PARTNER.equals(fname)){
return bean.getPartner();
}
if(TIME.equals(fname)){
return bean.getTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.log.RegistLossLogger.class;
}
public final static class DBRowMapper_RegistLossLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.RegistLossLogger>{
@Override
public com.ks.db.log.RegistLossLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.RegistLossLogger bean = new com.ks.db.log.RegistLossLogger();
bean.setId(rs.getInt("id"));
bean.setType(rs.getInt("type"));
bean.setUsername(rs.getString("username"));
bean.setPartner(rs.getInt("partner"));
bean.setTime(rs.getInt("time"));
return bean;
}
}
}
