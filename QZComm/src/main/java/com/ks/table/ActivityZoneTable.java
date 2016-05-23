package com.ks.table;
public final class ActivityZoneTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ActivityZone>{
public static ActivityZoneTable instance;
public static final String TABLE_NAME="t_activity_zone";
public static final String ZONEID="zone_id";
public static final String TYPE="type";
public static final String STARTTIME="start_time";
public static final String ENDTIME="end_time";
public static final String NUM="num";

public static final String J_ZONEID="zoneId";
public static final String J_TYPE="type";
public static final String J_STARTTIME="startTime";
public static final String J_ENDTIME="endTime";
public static final String J_NUM="num";

public ActivityZoneTable(){
mapper=new DBRowMapper_ActivityZone();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ActivityZone bean, String fname){
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(STARTTIME.equals(fname)){
return bean.getStartTime();
}
if(ENDTIME.equals(fname)){
return bean.getEndTime();
}
if(NUM.equals(fname)){
return bean.getNum();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.ActivityZone.class;
}
public final static class DBRowMapper_ActivityZone implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ActivityZone>{
@Override
public com.ks.db.cfg.ActivityZone rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ActivityZone bean = new com.ks.db.cfg.ActivityZone();
bean.setZoneId(rs.getInt("zone_id"));
bean.setType(rs.getInt("type"));
bean.setStartTime(com.ks.util.XyTimeUtil.getTime(rs.getString("start_time")));
bean.setEndTime(com.ks.util.XyTimeUtil.getTime(rs.getString("start_time")));
bean.setNum(rs.getInt("num"));
return bean;
}
}
}
