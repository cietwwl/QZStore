package com.ks.logic.db_template;
public final class EternalPropertyDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.EternalProperty>{
public EternalPropertyDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.EternalProperty.class;
mapper = new com.ks.table.EternalPropertyTable.DBRowMapper_EternalProperty();
sqlMap.put("queryEnternalPropertys","select * from t_eternal_property");
paramMethodMap.put("queryEnternalPropertys", new DynamicSelect_queryEnternalPropertys());
}
public final class DynamicSelect_queryEnternalPropertys implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EternalProperty>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EternalProperty bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}