package com.ks.logic.db_template;
public final class UserGuideStepDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserGuideStep>{
public UserGuideStepDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserGuideStep.class;
mapper = new com.ks.table.UserGuideStepTable.DBRowMapper_UserGuideStep();
sqlMap.put("addUserGuideStep","insert t_user_guide_step (`id`,`guide_ids`,`create_time`,`update_time`) values (?,?,?,?)");
sqlMap.put("queryUserGuideStep","select * from t_user_guide_step where `id`=?");
sqlMap.put("updateUserGuideStep","update t_user_guide_step set `id`=?,`guide_ids`=?,`create_time`=?,`update_time`=? where `id`=?");
paramMethodMap.put("addUserGuideStep", new DynamicInsert_addUserGuideStep());
paramMethodMap.put("queryUserGuideStep", new DynamicSelect_queryUserGuideStep());
paramMethodMap.put("updateUserGuideStep", new DynamicUpdata_updateUserGuideStep());
}
public final class DynamicInsert_addUserGuideStep implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserGuideStep>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserGuideStep bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getGuideIds());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryUserGuideStep implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserGuideStep>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserGuideStep bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicUpdata_updateUserGuideStep implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserGuideStep>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserGuideStep bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getGuideIds());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getId());
return list;
}
}
}