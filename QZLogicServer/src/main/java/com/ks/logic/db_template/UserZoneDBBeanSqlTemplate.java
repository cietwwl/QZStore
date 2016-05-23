package com.ks.logic.db_template;
public final class UserZoneDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserZone>{
public UserZoneDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserZone.class;
mapper = new com.ks.table.UserZoneTable.DBRowMapper_UserZone();
sqlMap.put("updateUserZone","update $tablename set `user_id`=?,`zone_id`=?,`zone_type`=?,`curr_battle`=?,`gain_award_star`=?,`create_time`=?,`update_time`=? where `user_id`=? and `zone_id`=?");
sqlMap.put("addUserZone","insert $tablename (`user_id`,`zone_id`,`zone_type`,`curr_battle`,`gain_award_star`,`create_time`,`update_time`) values (?,?,?,?,?,?,?)");
sqlMap.put("queryZone","select * from $tablename where `user_id`=?");
paramMethodMap.put("updateUserZone", new DynamicUpdata_updateUserZone());
paramMethodMap.put("addUserZone", new DynamicInsert_addUserZone());
paramMethodMap.put("queryZone", new DynamicSelect_queryZone());
}
public final class DynamicUpdata_updateUserZone implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserZone>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserZone bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getZoneId());
list.add(bean.getZoneType());
list.add(bean.getCurrBattle());
list.add(bean.getGainAwardStar());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getZoneId());
return list;
}
}
public final class DynamicInsert_addUserZone implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserZone>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserZone bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getZoneId());
list.add(bean.getZoneType());
list.add(bean.getCurrBattle());
list.add(bean.getGainAwardStar());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryZone implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserZone>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserZone bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
}