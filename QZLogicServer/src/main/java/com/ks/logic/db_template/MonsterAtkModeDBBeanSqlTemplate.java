package com.ks.logic.db_template;
public final class MonsterAtkModeDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.MonsterAtkMode>{
public MonsterAtkModeDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.MonsterAtkMode.class;
mapper = new com.ks.table.MonsterAtkModeTable.DBRowMapper_MonsterAtkMode();
sqlMap.put("queryMonsterAtkMode","select * from t_monster_atk_mode");
paramMethodMap.put("queryMonsterAtkMode", new DynamicSelect_queryMonsterAtkMode());
}
public final class DynamicSelect_queryMonsterAtkMode implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.MonsterAtkMode>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.MonsterAtkMode bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}