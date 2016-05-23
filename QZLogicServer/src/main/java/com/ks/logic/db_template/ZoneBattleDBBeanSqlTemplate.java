package com.ks.logic.db_template;
import com.ks.util.StringUtil;
public final class ZoneBattleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ZoneBattle>{
public ZoneBattleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ZoneBattle.class;
mapper = new com.ks.table.ZoneBattleTable.DBRowMapper_ZoneBattle();
sqlMap.put("queryZoneBattle","select * from t_zone_battle");
paramMethodMap.put("queryZoneBattle", new DynamicSelect_queryZoneBattle());
}
public final class DynamicSelect_queryZoneBattle implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ZoneBattle>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ZoneBattle bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}