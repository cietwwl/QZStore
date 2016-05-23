package com.ks.logic.db_template;
public final class OnlineReportLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.OnlineReportLogger>{
public OnlineReportLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.OnlineReportLogger.class;
mapper = new com.ks.table.OnlineReportLoggerTable.DBRowMapper_OnlineReportLogger();
sqlMap.put("addOnlineReportLogger","insert t_online_report_logger (`id`,`amount`,`time`) values (?,?,?)");
paramMethodMap.put("addOnlineReportLogger", new DynamicInsert_addOnlineReportLogger());
}
public final class DynamicInsert_addOnlineReportLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.OnlineReportLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.OnlineReportLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getAmount());
list.add(bean.getTime());
return list;
}
}
}