package com.ks.logic.db_template;
public final class ArenaBuyDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ArenaBuy>{
public ArenaBuyDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ArenaBuy.class;
mapper = new com.ks.table.ArenaBuyTable.DBRowMapper_ArenaBuy();
sqlMap.put("queryArenaBuys","select * from t_arena_buy");
paramMethodMap.put("queryArenaBuys", new DynamicSelect_queryArenaBuys());
}
public final class DynamicSelect_queryArenaBuys implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ArenaBuy>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ArenaBuy bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}