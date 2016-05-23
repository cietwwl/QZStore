package com.ks.table;
public final class PeriodActivityTimeTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.PeriodActivityTime>{
public static PeriodActivityTimeTable instance;
public static final String TABLE_NAME="t_period_activity_time";
public static final String TYPE="n_type";
public static final String OPENTIMES="n_openTimes";

public static final String J_TYPE="type";
public static final String J_OPENTIMES="openTimes";

public PeriodActivityTimeTable(){
mapper=new DBRowMapper_PeriodActivityTime();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.PeriodActivityTime bean, String fname){
if(TYPE.equals(fname)){
return bean.getType();
}
if(OPENTIMES.equals(fname)){
return bean.getOpenTimes();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.PeriodActivityTime.class;
}
public final static class DBRowMapper_PeriodActivityTime implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.PeriodActivityTime>{
@Override
public com.ks.db.cfg.PeriodActivityTime rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.PeriodActivityTime bean = new com.ks.db.cfg.PeriodActivityTime();
bean.setType(rs.getInt("n_type"));
bean.setOpenTimes(rs.getString("n_openTimes"));
return bean;
}
}
}
