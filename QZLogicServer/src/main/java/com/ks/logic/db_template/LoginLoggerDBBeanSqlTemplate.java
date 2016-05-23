package com.ks.logic.db_template;
public final class LoginLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.LoginLogger>{
public LoginLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.LoginLogger.class;
mapper = new com.ks.table.LoginLoggerTable.DBRowMapper_LoginLogger();
sqlMap.put("addLoginLogger","insert t_login_logger (`id`,`userId`,`playername`,`type`,`time`) values (?,?,?,?,?)");
paramMethodMap.put("addLoginLogger", new DynamicInsert_addLoginLogger());
}
public final class DynamicInsert_addLoginLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.LoginLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.LoginLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getPlayername());
list.add(bean.getType());
list.add(bean.getTime());
return list;
}
}
}