package com.ks.logic.db_template;
public final class ConstantConfigDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ConstantConfig>{
public ConstantConfigDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ConstantConfig.class;
mapper = new com.ks.table.ConstantConfigTable.DBRowMapper_ConstantConfig();
sqlMap.put("queryConstantConfigs","select * from t_constant");
paramMethodMap.put("queryConstantConfigs", new DynamicSelect_queryConstantConfigs());
}
public final class DynamicSelect_queryConstantConfigs implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ConstantConfig>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ConstantConfig bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}