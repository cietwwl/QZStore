package com.ks.logic.db_template;
public final class FameDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Fame>{
public FameDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Fame.class;
mapper = new com.ks.table.FameTable.DBRowMapper_Fame();
sqlMap.put("queryFame","select * from t_fame");
paramMethodMap.put("queryFame", new DynamicSelect_queryFame());
}
public final class DynamicSelect_queryFame implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Fame>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Fame bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}