package com.ks.logic.db_template;
public final class MartialWayAwardExpDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.MartialWayAwardExp>{
public MartialWayAwardExpDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.MartialWayAwardExp.class;
mapper = new com.ks.table.MartialWayAwardExpTable.DBRowMapper_MartialWayAwardExp();
sqlMap.put("queryArenaAwardExp","select * from t_martial_way_exp");
sqlMap.put("queryMartialWayAwardExp","select * from t_martial_way_exp");
paramMethodMap.put("queryArenaAwardExp", new DynamicSelect_queryArenaAwardExp());
paramMethodMap.put("queryMartialWayAwardExp", new DynamicSelect_queryMartialWayAwardExp());
}
public final class DynamicSelect_queryArenaAwardExp implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.MartialWayAwardExp>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.MartialWayAwardExp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
public final class DynamicSelect_queryMartialWayAwardExp implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.MartialWayAwardExp>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.MartialWayAwardExp bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}