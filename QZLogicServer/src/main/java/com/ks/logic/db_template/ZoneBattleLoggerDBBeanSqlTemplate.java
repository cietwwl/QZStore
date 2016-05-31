package com.ks.logic.db_template;
public final class ZoneBattleLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.ZoneBattleLogger>{
public ZoneBattleLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.ZoneBattleLogger.class;
mapper = new com.ks.table.ZoneBattleLoggerTable.DBRowMapper_ZoneBattleLogger();
sqlMap.put("addZoneBattleLogger","insert t_zone_battle_logger (`id`,`zoneId`,`zoneBattleId`,`userId`,`firstState`,`state`,`battleNum`,`createTime`,`updateTime`) values (?,?,?,?,?,?,?,?,?)");
sqlMap.put("updateZoneBattleLogger","update t_zone_battle_logger set `id`=?,`zoneId`=?,`zoneBattleId`=?,`userId`=?,`firstState`=?,`state`=?,`battleNum`=?,`createTime`=?,`updateTime`=? where `id`=?");
sqlMap.put("queryZoneBattleLogger","select * from t_zone_battle_logger where `userId`=? and `zoneBattleId`=?");
paramMethodMap.put("addZoneBattleLogger", new DynamicInsert_addZoneBattleLogger());
paramMethodMap.put("updateZoneBattleLogger", new DynamicUpdata_updateZoneBattleLogger());
paramMethodMap.put("queryZoneBattleLogger", new DynamicSelect_queryZoneBattleLogger());
}
public final class DynamicInsert_addZoneBattleLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.ZoneBattleLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.ZoneBattleLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getZoneId());
list.add(bean.getZoneBattleId());
list.add(bean.getUserId());
list.add(bean.getFirstState());
list.add(bean.getState());
list.add(bean.getBattleNum());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicUpdata_updateZoneBattleLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.ZoneBattleLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.ZoneBattleLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getZoneId());
list.add(bean.getZoneBattleId());
list.add(bean.getUserId());
list.add(bean.getFirstState());
list.add(bean.getState());
list.add(bean.getBattleNum());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getId());
return list;
}
}
public final class DynamicSelect_queryZoneBattleLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.ZoneBattleLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.ZoneBattleLogger bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getZoneBattleId());
return list;
}
}
}