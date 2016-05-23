package com.ks.logic.db_template;
public final class UserBuffDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserBuff>{
public UserBuffDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserBuff.class;
mapper = new com.ks.table.UserBuffTable.DBRowMapper_UserBuff();
sqlMap.put("addUserBuff","insert t_user_buff (`user_id`,`effect_id`,`val`,`cd`,`create_time`,`update_time`) values (?,?,?,?,?,?)");
sqlMap.put("queryUserBuffs","select * from t_user_buff where `user_id`=?");
sqlMap.put("queryUserBuff","select * from t_user_buff where `user_id`=? and `effect_id`=?");
sqlMap.put("updateUserBuff","update t_user_buff set `user_id`=?,`effect_id`=?,`val`=?,`cd`=?,`create_time`=?,`update_time`=? where `user_id`=? and `effect_id`=?");
sqlMap.put("deleteUserBuff","delete from t_user_buff where `user_id`=? and `effect_id`=?");
paramMethodMap.put("addUserBuff", new DynamicInsert_addUserBuff());
paramMethodMap.put("queryUserBuffs", new DynamicSelect_queryUserBuffs());
paramMethodMap.put("queryUserBuff", new DynamicSelect_queryUserBuff());
paramMethodMap.put("updateUserBuff", new DynamicUpdata_updateUserBuff());
paramMethodMap.put("deleteUserBuff", new DynamicDelete_deleteUserBuff());
}
public final class DynamicInsert_addUserBuff implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserBuff>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserBuff bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getEffectId());
list.add(bean.getVal());
list.add(bean.getCd());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryUserBuffs implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserBuff>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserBuff bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_queryUserBuff implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserBuff>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserBuff bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getEffectId());
return list;
}
}
public final class DynamicUpdata_updateUserBuff implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserBuff>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserBuff bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getEffectId());
list.add(bean.getVal());
list.add(bean.getCd());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getEffectId());
return list;
}
}
public final class DynamicDelete_deleteUserBuff implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserBuff>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserBuff bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getEffectId());
return list;
}
}
}