package com.ks.table;
public final class ZoneTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Zone>{
public static ZoneTable instance;
public static final String TABLE_NAME="t_zone";
public static final String ZONEID="zone_id";
public static final String TYPE="type";
public static final String LEVEL="level";
public static final String PEVZONE="pev_zone";
public static final String NEXTZONE="next_zone";

public static final String J_ZONEID="zoneId";
public static final String J_TYPE="type";
public static final String J_LEVEL="level";
public static final String J_PEVZONE="pevZone";
public static final String J_NEXTZONE="nextZone";

public ZoneTable(){
mapper=new DBRowMapper_Zone();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Zone bean, String fname){
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(PEVZONE.equals(fname)){
return bean.getPevZone();
}
if(NEXTZONE.equals(fname)){
return bean.getNextZone();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Zone.class;
}
public final static class DBRowMapper_Zone implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Zone>{
@Override
public com.ks.db.cfg.Zone rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Zone bean = new com.ks.db.cfg.Zone();
bean.setZoneId(rs.getInt("zone_id"));
bean.setType(rs.getInt("type"));
bean.setLevel(rs.getInt("level"));
bean.setPevZone(rs.getInt("pev_zone"));
bean.setNextZone(rs.getInt("next_zone"));
return bean;
}
}
}
