package com.ks.logic.db_template;
public final class UserZoneBattleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserZoneBattle>{
public UserZoneBattleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserZoneBattle.class;
mapper = new com.ks.table.UserZoneBattleTable.DBRowMapper_UserZoneBattle();
sqlMap.put("addUserZoneBattle","insert $tablename (`user_id`,`zone_id`,`zone_battle_id`,`challenge_count`,`pass_count`,`star`,`last_challenge_time`,`create_time`) values (?,?,?,?,?,?,?,?)");
sqlMap.put("queryUserZoneBattles","select * from $tablename where `user_id`=?");
sqlMap.put("updateUserZoneBattle","update $tablename set `user_id`=?,`zone_id`=?,`zone_battle_id`=?,`challenge_count`=?,`pass_count`=?,`star`=?,`last_challenge_time`=?,`create_time`=? where `user_id`=? and `zone_id`=? and `zone_battle_id`=?");
paramMethodMap.put("addUserZoneBattle", new DynamicInsert_addUserZoneBattle());
paramMethodMap.put("queryUserZoneBattles", new DynamicSelect_queryUserZoneBattles());
paramMethodMap.put("updateUserZoneBattle", new DynamicUpdata_updateUserZoneBattle());
}
public final class DynamicInsert_addUserZoneBattle implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserZoneBattle>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserZoneBattle bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getZoneId());
list.add(bean.getZoneBattleId());
list.add(bean.getChallengeCount());
list.add(bean.getPassCount());
list.add(bean.getStar());
list.add(bean.getLastChallengeTime());
list.add(bean.getCreateTime());
return list;
}
}
public final class DynamicSelect_queryUserZoneBattles implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserZoneBattle>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserZoneBattle bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateUserZoneBattle implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserZoneBattle>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserZoneBattle bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getZoneId());
list.add(bean.getZoneBattleId());
list.add(bean.getChallengeCount());
list.add(bean.getPassCount());
list.add(bean.getStar());
list.add(bean.getLastChallengeTime());
list.add(bean.getCreateTime());
list.add(bean.getUserId());
list.add(bean.getZoneId());
list.add(bean.getZoneBattleId());
return list;
}
}
}