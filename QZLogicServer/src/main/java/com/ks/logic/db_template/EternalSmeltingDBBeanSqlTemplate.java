package com.ks.logic.db_template;
public final class EternalSmeltingDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.EternalSmelting>{
public EternalSmeltingDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.EternalSmelting.class;
mapper = new com.ks.table.EternalSmeltingTable.DBRowMapper_EternalSmelting();
sqlMap.put("updateEternalSmelting","update t_eternal_smelting set `user_id`=?,`type`=?,`val`=?,`addEternalVal`=?,`create_time`=?,`update_time`=? where `user_id`=? and `type`=?");
sqlMap.put("addEternalSmeltings","insert t_eternal_smelting (`user_id`,`type`,`val`,`addEternalVal`,`create_time`,`update_time`) values (?,?,?,?,?,?)");
sqlMap.put("queryEternalSmeltings","select * from t_eternal_smelting where `user_id`=?");
sqlMap.put("queryEternalSmelting","select * from t_eternal_smelting where `user_id`=? and `type`=?");
paramMethodMap.put("updateEternalSmelting", new DynamicUpdata_updateEternalSmelting());
paramMethodMap.put("addEternalSmeltings", new DynamicInsert_addEternalSmeltings());
paramMethodMap.put("queryEternalSmeltings", new DynamicSelect_queryEternalSmeltings());
paramMethodMap.put("queryEternalSmelting", new DynamicSelect_queryEternalSmelting());
}
public final class DynamicUpdata_updateEternalSmelting implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EternalSmelting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EternalSmelting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getType());
list.add(bean.getVal());
list.add(bean.getAddEternalVal());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getType());
return list;
}
}
public final class DynamicInsert_addEternalSmeltings implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EternalSmelting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EternalSmelting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getType());
list.add(bean.getVal());
list.add(bean.getAddEternalVal());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryEternalSmeltings implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EternalSmelting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EternalSmelting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_queryEternalSmelting implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EternalSmelting>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EternalSmelting bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getType());
return list;
}
}
}