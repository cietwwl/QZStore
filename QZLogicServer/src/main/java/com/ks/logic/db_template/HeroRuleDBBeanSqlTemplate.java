package com.ks.logic.db_template;
public final class HeroRuleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.HeroRule>{
public HeroRuleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.HeroRule.class;
mapper = new com.ks.table.HeroRuleTable.DBRowMapper_HeroRule();
sqlMap.put("queryHeroRule","select * from t_hero_rule");
paramMethodMap.put("queryHeroRule", new DynamicSelect_queryHeroRule());
}
public final class DynamicSelect_queryHeroRule implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.HeroRule>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.HeroRule bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}