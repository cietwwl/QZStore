package com.ks.table;
public final class ZoneBattleLoggerTable extends com.ks.access.DBBeanTable<com.ks.db.log.ZoneBattleLogger>{
public static ZoneBattleLoggerTable instance;
public static final String TABLE_NAME="t_zone_battle_logger";
public static final String ID="id";
public static final String ZONEID="zoneId";
public static final String ZONEBATTLEID="zoneBattleId";
public static final String USERID="userId";
public static final String FIRSTSTATE="firstState";
public static final String STATE="state";
public static final String BATTLENUM="battleNum";
public static final String CREATETIME="createTime";
public static final String UPDATETIME="updateTime";

public static final String J_ID="id";
public static final String J_ZONEID="zoneId";
public static final String J_ZONEBATTLEID="zoneBattleId";
public static final String J_USERID="userId";
public static final String J_FIRSTSTATE="firstState";
public static final String J_STATE="state";
public static final String J_BATTLENUM="battleNum";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public ZoneBattleLoggerTable(){
mapper=new DBRowMapper_ZoneBattleLogger();
}
@Override
public Object getDBFieldValue(com.ks.db.log.ZoneBattleLogger bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(ZONEBATTLEID.equals(fname)){
return bean.getZoneBattleId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(FIRSTSTATE.equals(fname)){
return bean.getFirstState();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(BATTLENUM.equals(fname)){
return bean.getBattleNum();
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
return com.ks.db.log.ZoneBattleLogger.class;
}
public final static class DBRowMapper_ZoneBattleLogger implements com.ks.access.mapper.RowMapper<com.ks.db.log.ZoneBattleLogger>{
@Override
public com.ks.db.log.ZoneBattleLogger rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.log.ZoneBattleLogger bean = new com.ks.db.log.ZoneBattleLogger();
bean.setId(rs.getInt("id"));
bean.setZoneId(rs.getInt("zoneId"));
bean.setZoneBattleId(rs.getInt("zoneBattleId"));
bean.setUserId(rs.getInt("userId"));
bean.setFirstState(rs.getInt("firstState"));
bean.setState(rs.getInt("state"));
bean.setBattleNum(rs.getInt("battleNum"));
bean.setCreateTime(rs.getInt("createTime"));
bean.setUpdateTime(rs.getInt("updateTime"));
return bean;
}
}
}
