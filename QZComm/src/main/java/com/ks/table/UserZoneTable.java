package com.ks.table;
public final class UserZoneTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserZone>{
public static UserZoneTable instance;
public static final String USERID="user_id";
public static final String ZONEID="zone_id";
public static final String ZONETYPE="zone_type";
public static final String CURRBATTLE="curr_battle";
public static final String GAINAWARDSTAR="gain_award_star";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_ZONEID="zoneId";
public static final String J_ZONETYPE="zoneType";
public static final String J_CURRBATTLE="currBattle";
public static final String J_GAINAWARDSTAR="gainAwardStar";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public UserZoneTable(){
mapper=new DBRowMapper_UserZone();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserZone bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(ZONETYPE.equals(fname)){
return bean.getZoneType();
}
if(CURRBATTLE.equals(fname)){
return bean.getCurrBattle();
}
if(GAINAWARDSTAR.equals(fname)){
return bean.getGainAwardStar();
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
return com.ks.db.model.UserZone.class;
}
public final static class DBRowMapper_UserZone implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserZone>{
@Override
public com.ks.db.model.UserZone rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserZone bean = new com.ks.db.model.UserZone();
bean.setUserId(rs.getInt("user_id"));
bean.setZoneId(rs.getInt("zone_id"));
bean.setZoneType(rs.getInt("zone_type"));
bean.setCurrBattle(rs.getInt("curr_battle"));
bean.setGainAwardStar(rs.getString("gain_award_star"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
