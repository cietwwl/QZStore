package com.ks.logic.db_template;
public final class ArenaAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ArenaAward>{
public ArenaAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ArenaAward.class;
mapper = new com.ks.table.ArenaAwardTable.DBRowMapper_ArenaAward();
sqlMap.put("queryArenaAward","select * from t_arena_award");
paramMethodMap.put("queryArenaAward", new DynamicSelect_queryArenaAward());
}
public final class DynamicSelect_queryArenaAward implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ArenaAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ArenaAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}