package com.ks.logic.db_template;
public final class FameBuffDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.FameBuff>{
public FameBuffDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.FameBuff.class;
mapper = new com.ks.table.FameBuffTable.DBRowMapper_FameBuff();
sqlMap.put("queryFameBuff","select * from t_fame_buff");
paramMethodMap.put("queryFameBuff", new DynamicSelect_queryFameBuff());
}
public final class DynamicSelect_queryFameBuff implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.FameBuff>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.FameBuff bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}