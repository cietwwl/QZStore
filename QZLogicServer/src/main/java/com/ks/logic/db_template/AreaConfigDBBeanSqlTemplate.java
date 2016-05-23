package com.ks.logic.db_template;
public final class AreaConfigDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.AreaConfig>{
public AreaConfigDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.AreaConfig.class;
mapper = new com.ks.table.AreaConfigTable.DBRowMapper_AreaConfig();
sqlMap.put("queryAreaConfig","select * from t_area_config where `id`=?");
sqlMap.put("updateAreaConfig","select * from t_area_config where `id`=?");
sqlMap.put("queryLockAreaConfig","select * from t_area_config where `id`=?");
paramMethodMap.put("queryAreaConfig", new DynamicSelect_queryAreaConfig());
paramMethodMap.put("updateAreaConfig", new DynamicSelect_updateAreaConfig());
paramMethodMap.put("queryLockAreaConfig", new DynamicSelect_queryLockAreaConfig());
}
public final class DynamicSelect_queryAreaConfig implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AreaConfig>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AreaConfig bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicSelect_updateAreaConfig implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AreaConfig>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AreaConfig bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
public final class DynamicSelect_queryLockAreaConfig implements com.ks.access.DBBeanParamMethod<com.ks.db.model.AreaConfig>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.AreaConfig bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
return list;
}
}
}