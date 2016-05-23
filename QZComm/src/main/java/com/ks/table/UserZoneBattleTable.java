package com.ks.table;
public final class UserZoneBattleTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserZoneBattle>{
public static UserZoneBattleTable instance;
public static final String USERID="user_id";
public static final String ZONEID="zone_id";
public static final String ZONEBATTLEID="zone_battle_id";
public static final String CHALLENGECOUNT="challenge_count";
public static final String PASSCOUNT="pass_count";
public static final String STAR="star";
public static final String LASTCHALLENGETIME="last_challenge_time";
public static final String CREATETIME="create_time";

public static final String J_USERID="userId";
public static final String J_ZONEID="zoneId";
public static final String J_ZONEBATTLEID="zoneBattleId";
public static final String J_CHALLENGECOUNT="challengeCount";
public static final String J_PASSCOUNT="passCount";
public static final String J_STAR="star";
public static final String J_LASTCHALLENGETIME="lastChallengeTime";
public static final String J_CREATETIME="createTime";

public UserZoneBattleTable(){
mapper=new DBRowMapper_UserZoneBattle();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserZoneBattle bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(ZONEBATTLEID.equals(fname)){
return bean.getZoneBattleId();
}
if(CHALLENGECOUNT.equals(fname)){
return bean.getChallengeCount();
}
if(PASSCOUNT.equals(fname)){
return bean.getPassCount();
}
if(STAR.equals(fname)){
return bean.getStar();
}
if(LASTCHALLENGETIME.equals(fname)){
return bean.getLastChallengeTime();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserZoneBattle.class;
}
public final static class DBRowMapper_UserZoneBattle implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserZoneBattle>{
@Override
public com.ks.db.model.UserZoneBattle rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserZoneBattle bean = new com.ks.db.model.UserZoneBattle();
bean.setUserId(rs.getInt("user_id"));
bean.setZoneId(rs.getInt("zone_id"));
bean.setZoneBattleId(rs.getInt("zone_battle_id"));
bean.setChallengeCount(rs.getInt("challenge_count"));
bean.setPassCount(rs.getInt("pass_count"));
bean.setStar(rs.getInt("star"));
bean.setLastChallengeTime(rs.getTimestamp("last_challenge_time"));
bean.setCreateTime(rs.getTimestamp("create_time"));
return bean;
}
}
}
