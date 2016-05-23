package com.ks.logic.db_template;
public final class CallHeroDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.CallHero>{
public CallHeroDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.CallHero.class;
mapper = new com.ks.table.CallHeroTable.DBRowMapper_CallHero();
sqlMap.put("queryCallHero","select * from t_call_hero");
paramMethodMap.put("queryCallHero", new DynamicSelect_queryCallHero());
}
public final class DynamicSelect_queryCallHero implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.CallHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.CallHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}