package com.ks.logic.db_template;
public final class ActivityZoneDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ActivityZone>{
public ActivityZoneDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ActivityZone.class;
mapper = new com.ks.table.ActivityZoneTable.DBRowMapper_ActivityZone();
sqlMap.put("queryActivityZone","select * from t_activity_zone");
paramMethodMap.put("queryActivityZone", new DynamicSelect_queryActivityZone());
}
public final class DynamicSelect_queryActivityZone implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ActivityZone>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ActivityZone bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}