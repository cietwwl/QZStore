package com.ks.logic.db_template;
public final class EquipmentLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.EquipmentLogger>{
public EquipmentLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.EquipmentLogger.class;
mapper = new com.ks.table.EquipmentLoggerTable.DBRowMapper_EquipmentLogger();
sqlMap.put("addGameLogger","insert t_equipment_logger (`id`,`user_id`,`playername`,`logger_type`,`type`,`ass_id`,`num`,`description`,`create_time`,`originalAmount`,`surplusAmount`) values (?,?,?,?,?,?,?,?,?,?,?)");
paramMethodMap.put("addGameLogger", new DynamicInsert_addGameLogger());
}
public final class DynamicInsert_addGameLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.EquipmentLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.EquipmentLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getPlayername());
list.add(bean.getLoggerType());
list.add(bean.getType());
list.add(bean.getAssId());
list.add(bean.getNum());
list.add(bean.getDescription());
list.add(bean.getCreateTime());
list.add(bean.getOriginalAmount());
list.add(bean.getSurplusAmount());
return list;
}
}
}