package com.ks.logic.db_template;
public final class MonsterDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Monster>{
public MonsterDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Monster.class;
mapper = new com.ks.table.MonsterTable.DBRowMapper_Monster();
sqlMap.put("queryMonster","select * from t_monster");
paramMethodMap.put("queryMonster", new DynamicSelect_queryMonster());
}
public final class DynamicSelect_queryMonster implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Monster>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Monster bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}