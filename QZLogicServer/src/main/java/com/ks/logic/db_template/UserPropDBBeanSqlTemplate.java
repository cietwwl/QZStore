package com.ks.logic.db_template;
public final class UserPropDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserProp>{
public UserPropDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserProp.class;
mapper = new com.ks.table.UserPropTable.DBRowMapper_UserProp();
sqlMap.put("addUserProp","insert $tablename (`id`,`user_id`,`prop_id`,`num`,`create_time`,`update_time`) values (?,?,?,?,?,?)");
sqlMap.put("updateUserProps","update $tablename set `id`=?,`user_id`=?,`prop_id`=?,`num`=?,`create_time`=?,`update_time`=? where `id`=?");
sqlMap.put("delUserProp","delete from $tablename where `id`=?");
sqlMap.put("queryUserProps","select * from $tablename where `user_id`=?");
sqlMap.put("updateUserProp","update $tablename set `id`=?,`user_id`=?,`prop_id`=?,`num`=?,`create_time`=?,`update_time`=? where `id`=?");
paramMethodMap.put("addUserProp", new DynamicInsert_addUserProp());
paramMethodMap.put("updateUserProps", new DynamicUpdata_updateUserProps());
paramMethodMap.put("delUserProp", new DynamicDelete_delUserProp());
paramMethodMap.put("queryUserProps", new DynamicSelect_queryUserProps());
paramMethodMap.put("updateUserProp", new DynamicUpdata_updateUserProp());
}
public final class DynamicInsert_addUserProp implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserProp>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserProp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getPropId());
list.add(bean.getNum());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicUpdata_updateUserProps implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserProp>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserProp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getPropId());
list.add(bean.getNum());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getId());
return list;
}
}
public final class DynamicDelete_delUserProp implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserProp>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserProp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicSelect_queryUserProps implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserProp>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserProp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateUserProp implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserProp>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserProp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getPropId());
list.add(bean.getNum());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getId());
return list;
}
}
}