package com.ks.logic.db_template;
public final class ActiveLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.ActiveLogger>{
public ActiveLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.ActiveLogger.class;
mapper = new com.ks.table.ActiveLoggerTable.DBRowMapper_ActiveLogger();
sqlMap.put("queryActiveLogger","select * from t_active_logger where `uid`=? and `partner`=?");
sqlMap.put("updateActiveLogger","update t_active_logger set `id`=?,`partner`=?,`uid`=?,`username`=?,`playername`=?,`loginTime`=?,`totalOnlineTime`=? where `id`=?");
sqlMap.put("addActiveLogger","insert t_active_logger (`id`,`partner`,`uid`,`username`,`playername`,`loginTime`,`totalOnlineTime`) values (?,?,?,?,?,?,?)");
paramMethodMap.put("queryActiveLogger", new DynamicSelect_queryActiveLogger());
paramMethodMap.put("updateActiveLogger", new DynamicUpdata_updateActiveLogger());
paramMethodMap.put("addActiveLogger", new DynamicInsert_addActiveLogger());
}
public final class DynamicSelect_queryActiveLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.ActiveLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.ActiveLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUid());
list.add(bean.getPartner());
return list;
}
}
public final class DynamicUpdata_updateActiveLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.ActiveLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.ActiveLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getPartner());
list.add(bean.getUid());
list.add(bean.getUsername());
list.add(bean.getPlayername());
list.add(bean.getLoginTime());
list.add(bean.getTotalOnlineTime());
list.add(bean.getId());
return list;
}
}
public final class DynamicInsert_addActiveLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.ActiveLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.ActiveLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getPartner());
list.add(bean.getUid());
list.add(bean.getUsername());
list.add(bean.getPlayername());
list.add(bean.getLoginTime());
list.add(bean.getTotalOnlineTime());
return list;
}
}
}