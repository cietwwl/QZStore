package com.ks.logic.db_template;
public final class ZoneAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ZoneAward>{
public ZoneAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ZoneAward.class;
mapper = new com.ks.table.ZoneAwardTable.DBRowMapper_ZoneAward();
sqlMap.put("queryZoneAward","select * from t_zone_award");
paramMethodMap.put("queryZoneAward", new DynamicSelect_queryZoneAward());
}
public final class DynamicSelect_queryZoneAward implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ZoneAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ZoneAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}