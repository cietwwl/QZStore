package com.ks.logic.db_template;
public final class PeriodActivityTimeDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.PeriodActivityTime>{
public PeriodActivityTimeDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.PeriodActivityTime.class;
mapper = new com.ks.table.PeriodActivityTimeTable.DBRowMapper_PeriodActivityTime();
sqlMap.put("queryPeriodActivityTimes","select * from t_period_activity_time");
paramMethodMap.put("queryPeriodActivityTimes", new DynamicSelect_queryPeriodActivityTimes());
}
public final class DynamicSelect_queryPeriodActivityTimes implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.PeriodActivityTime>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.PeriodActivityTime bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}