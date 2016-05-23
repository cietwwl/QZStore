package com.ks.logic.db_template;
public final class CallHeroRuleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.CallHeroRule>{
public CallHeroRuleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.CallHeroRule.class;
mapper = new com.ks.table.CallHeroRuleTable.DBRowMapper_CallHeroRule();
sqlMap.put("queryCallHeroRule","select * from t_call_hero_rule");
paramMethodMap.put("queryCallHeroRule", new DynamicSelect_queryCallHeroRule());
}
public final class DynamicSelect_queryCallHeroRule implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.CallHeroRule>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.CallHeroRule bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}