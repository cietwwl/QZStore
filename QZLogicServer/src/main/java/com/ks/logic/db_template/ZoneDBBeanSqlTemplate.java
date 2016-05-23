package com.ks.logic.db_template;
public final class ZoneDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Zone>{
public ZoneDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Zone.class;
mapper = new com.ks.table.ZoneTable.DBRowMapper_Zone();
sqlMap.put("queryZone","select * from t_zone");
paramMethodMap.put("queryZone", new DynamicSelect_queryZone());
}
public final class DynamicSelect_queryZone implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Zone>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Zone bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}