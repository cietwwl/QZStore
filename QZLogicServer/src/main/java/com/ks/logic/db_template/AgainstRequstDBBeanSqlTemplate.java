package com.ks.logic.db_template;
public final class AgainstRequstDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.AgainstRequst>{
public AgainstRequstDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.AgainstRequst.class;
mapper = new com.ks.table.AgainstRequstTable.DBRowMapper_AgainstRequst();
sqlMap.put("queryAgainstRequst","select * from t_against_requst where `user_id`=?");
sqlMap.put("addAgainstRequst","insert t_against_requst (`user_id`,`against_user_id`,`against_type`,`against_time`,`create_time`,`update_time`) values (?,?,?,?,?,?)");
sqlMap.put("queryAgainstRequstLock","select * from t_against_requst where `user_id`=? for update");
sqlMap.put("updateAgainstRequst","update t_against_requst set `user_id`=?,`against_user_id`=?,`against_type`=?,`against_time`=?,`create_time`=?,`update_time`=? where `user_id`=?");
paramMethodMap.put("queryAgainstRequst", new DynamicSelect_queryAgainstRequst());
paramMethodMap.put("addAgainstRequst", new DynamicInsert_addAgainstRequst());
paramMethodMap.put("queryAgainstRequstLock", new DynamicSelect_queryAgainstRequstLock());
paramMethodMap.put("updateAgainstRequst", new DynamicUpdata_updateAgainstRequst());
}
public final class DynamicSelect_queryAgainstRequst implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AgainstRequst>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AgainstRequst bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addAgainstRequst implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AgainstRequst>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AgainstRequst bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getAgainstUserId());
list.add(bean.getAgainstType());
list.add(bean.getAgainstTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryAgainstRequstLock implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AgainstRequst>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AgainstRequst bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateAgainstRequst implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AgainstRequst>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AgainstRequst bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getAgainstUserId());
list.add(bean.getAgainstType());
list.add(bean.getAgainstTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
return list;
}
}
}