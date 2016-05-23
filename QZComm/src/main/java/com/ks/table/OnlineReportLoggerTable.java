package com.ks.table;
public final class OnlineReportLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.OnlineReportLogger>{
public static OnlineReportLoggerTable instance;
public static final String TABLE_NAME="t_online_report_logger";
public static final String ID="id";
public static final String AMOUNT="amount";
public static final String TIME="time";

public static final String J_ID="id";
public static final String J_AMOUNT="amount";
public static final String J_TIME="time";

public OnlineReportLoggerTable(){
mapper=new DBRowMapper_OnlineReportLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.OnlineReportLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(AMOUNT.equals(fname)){
return bean.getAmount();
}
if(TIME.equals(fname)){
return bean.getTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.log.OnlineReportLogger.class;
}
public final static class DBRowMapper_OnlineReportLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.OnlineReportLogger>{
@Override
public com.ks.db.log.OnlineReportLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.OnlineReportLogger bean = new com.ks.db.log.OnlineReportLogger();
bean.setId(rs.getInt("id"));
bean.setAmount(rs.getInt("amount"));
bean.setTime(rs.getInt("time"));
return bean;
}
}
}
