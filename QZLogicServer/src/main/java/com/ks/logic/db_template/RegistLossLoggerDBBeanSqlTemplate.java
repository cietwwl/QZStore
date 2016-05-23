package com.ks.logic.db_template;
public final class RegistLossLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.RegistLossLogger>{
public RegistLossLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.RegistLossLogger.class;
mapper = new com.ks.table.RegistLossLoggerTable.DBRowMapper_RegistLossLogger();
sqlMap.put("addRegistLossLogger","insert t_regist_loss_logger (`id`,`type`,`username`,`partner`,`time`) values (?,?,?,?,?)");
paramMethodMap.put("addRegistLossLogger", new DynamicInsert_addRegistLossLogger());
}
public final class DynamicInsert_addRegistLossLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.RegistLossLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.RegistLossLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getType());
list.add(bean.getUsername());
list.add(bean.getPartner());
list.add(bean.getTime());
return list;
}
}
}