package com.ks.logic.db_template;
import com.ks.util.StringUtil;
public final class HeroRelationDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.HeroRelation>{
public HeroRelationDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.HeroRelation.class;
mapper = new com.ks.table.HeroRelationTable.DBRowMapper_HeroRelation();
sqlMap.put("queryHeroRelation","select * from t_hero_relation");
paramMethodMap.put("queryHeroRelation", new DynamicSelect_queryHeroRelation());
}
public final class DynamicSelect_queryHeroRelation implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.HeroRelation>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.HeroRelation bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}