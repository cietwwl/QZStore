package com.ks.logic.db_template;
public final class HeroEvoMaterialDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.HeroEvoMaterial>{
public HeroEvoMaterialDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.HeroEvoMaterial.class;
mapper = new com.ks.table.HeroEvoMaterialTable.DBRowMapper_HeroEvoMaterial();
sqlMap.put("queryHeroEvoMaterial","select * from t_hero_evo_material");
paramMethodMap.put("queryHeroEvoMaterial", new DynamicSelect_queryHeroEvoMaterial());
}
public final class DynamicSelect_queryHeroEvoMaterial implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.HeroEvoMaterial>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.HeroEvoMaterial bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}