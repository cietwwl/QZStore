package com.ks.logic.db_template;
public final class UserRecordDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserRecord>{
public UserRecordDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserRecord.class;
mapper = new com.ks.table.UserRecordTable.DBRowMapper_UserRecord();
sqlMap.put("getUserRecord","select * from t_user_record where `id`=?");
sqlMap.put("updateUserRecord","update t_user_record set $fieldname where `id`=?");
sqlMap.put("addUserRecord","insert t_user_record (`id`,`sysMailIds`,`commonRewards`,`firstRecharges`,`trialsIds`) values (?,?,?,?,?)");
paramMethodMap.put("getUserRecord", new DynamicSelect_getUserRecord());
paramMethodMap.put("updateUserRecord", new DynamicUpdata_updateUserRecord());
paramMethodMap.put("addUserRecord", new DynamicInsert_addUserRecord());
}
public final class DynamicSelect_getUserRecord implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserRecord>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserRecord bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicUpdata_updateUserRecord implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserRecord>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserRecord bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicInsert_addUserRecord implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserRecord>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserRecord bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getSysMailIds());
list.add(bean.getCommonRewards());
list.add(bean.getFirstRecharges());
list.add(bean.getTrialsIds());
return list;
}
}
}