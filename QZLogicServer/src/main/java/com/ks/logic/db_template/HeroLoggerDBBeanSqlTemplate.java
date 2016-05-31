package com.ks.logic.db_template;
public final class HeroLoggerDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.log.HeroLogger>{
public HeroLoggerDBBeanSqlTemplate(){
super();
clazz=com.ks.db.log.HeroLogger.class;
mapper = new com.ks.table.HeroLoggerTable.DBRowMapper_HeroLogger();
sqlMap.put("addGameLogger","insert t_hero_logger (`id`,`user_id`,`playername`,`logger_type`,`type`,`ass_id`,`num`,`description`,`create_time`,`originalAmount`,`surplusAmount`) values (?,?,?,?,?,?,?,?,?,?,?)");
paramMethodMap.put("addGameLogger", new DynamicInsert_addGameLogger());
}
public final class DynamicInsert_addGameLogger implements com.ks.access.DBBeanParamMethod<com.ks.db.log.HeroLogger>{
@Override
public java.util.List<Object> getParams(com.ks.db.log.HeroLogger bean){
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