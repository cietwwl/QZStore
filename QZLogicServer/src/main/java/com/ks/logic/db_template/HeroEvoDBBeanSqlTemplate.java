package com.ks.logic.db_template;
public final class HeroEvoDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.HeroEvo>{
public HeroEvoDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.HeroEvo.class;
mapper = new com.ks.table.HeroEvoTable.DBRowMapper_HeroEvo();
sqlMap.put("queryHeroEvo","select * from t_hero_evo");
paramMethodMap.put("queryHeroEvo", new DynamicSelect_queryHeroEvo());
}
public final class DynamicSelect_queryHeroEvo implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.HeroEvo>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.HeroEvo bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}