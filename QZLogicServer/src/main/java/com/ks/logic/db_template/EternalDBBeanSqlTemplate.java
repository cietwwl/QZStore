package com.ks.logic.db_template;
public final class EternalDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Eternal>{
public EternalDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Eternal.class;
mapper = new com.ks.table.EternalTable.DBRowMapper_Eternal();
sqlMap.put("queryEternals","select * from t_eternal");
paramMethodMap.put("queryEternals", new DynamicSelect_queryEternals());
}
public final class DynamicSelect_queryEternals implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Eternal>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Eternal bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}