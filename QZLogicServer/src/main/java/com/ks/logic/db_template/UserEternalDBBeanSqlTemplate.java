package com.ks.logic.db_template;
public final class UserEternalDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserEternal>{
public UserEternalDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserEternal.class;
mapper = new com.ks.table.UserEternalTable.DBRowMapper_UserEternal();
sqlMap.put("updateUserEternal","update $tablename set `user_eternal_id`=?,`user_id`=?,`eternal_id`=?,`use`=?,`create_time`=?,`update_time`=?,`property_skill`=? where `user_id`=? and `user_eternal_id`=?");
sqlMap.put("addUserEternal","insert $tablename (`user_eternal_id`,`user_id`,`eternal_id`,`use`,`create_time`,`update_time`,`property_skill`) values (?,?,?,?,?,?,?)");
sqlMap.put("updateUserEternals","update $tablename set `user_eternal_id`=?,`user_id`=?,`eternal_id`=?,`use`=?,`create_time`=?,`update_time`=?,`property_skill`=? where `user_eternal_id`=?");
paramMethodMap.put("updateUserEternal", new DynamicUpdata_updateUserEternal());
paramMethodMap.put("addUserEternal", new DynamicInsert_addUserEternal());
paramMethodMap.put("updateUserEternals", new DynamicUpdata_updateUserEternals());
}
public final class DynamicUpdata_updateUserEternal implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEternal>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEternal bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEternalId());
list.add(bean.getUserId());
list.add(bean.getEternalId());
list.add(bean.isUse());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getPropertySkills());
list.add(bean.getUserId());
list.add(bean.getUserEternalId());
return list;
}
}
public final class DynamicInsert_addUserEternal implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEternal>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEternal bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEternalId());
list.add(bean.getUserId());
list.add(bean.getEternalId());
list.add(bean.isUse());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getPropertySkills());
return list;
}
}
public final class DynamicUpdata_updateUserEternals implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserEternal>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserEternal bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserEternalId());
list.add(bean.getUserId());
list.add(bean.getEternalId());
list.add(bean.isUse());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getPropertySkills());
list.add(bean.getUserEternalId());
return list;
}
}
}