package com.ks.logic.db_template;
public final class ArenaLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.ArenaLogger>{
public ArenaLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.ArenaLogger.class;
mapper = new com.ks.table.ArenaLoggerTable.DBRowMapper_ArenaLogger();
sqlMap.put("addArenaLogger","insert $tablename (`id`,`user_id`,`user_name`,`match_user_name`,`match_level`,`match_user_id`,`win_los`,`cap_id`,`create_time`,`type`) values (?,?,?,?,?,?,?,?,?,?)");
sqlMap.put("queryArenaLogger","select * from $tablename where `user_id`=? and `type`=? limit 30");
paramMethodMap.put("addArenaLogger", new DynamicInsert_addArenaLogger());
paramMethodMap.put("queryArenaLogger", new DynamicSelect_queryArenaLogger());
}
public final class DynamicInsert_addArenaLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.model.ArenaLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.ArenaLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getUserName());
list.add(bean.getMatchUserName());
list.add(bean.getMatchLevel());
list.add(bean.getMatchUserId());
list.add(bean.getWinLos());
list.add(bean.getCapId());
list.add(bean.getCreateTime());
list.add(bean.getType());
return list;
}
}
public final class DynamicSelect_queryArenaLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.model.ArenaLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.ArenaLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getType());
return list;
}
}
}