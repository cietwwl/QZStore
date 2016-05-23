package com.ks.logic.db_template;
public final class EternalEffectDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.EternalEffect>{
public EternalEffectDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.EternalEffect.class;
mapper = new com.ks.table.EternalEffectTable.DBRowMapper_EternalEffect();
sqlMap.put("queryEternalEffects","select * from t_eternal_effect");
paramMethodMap.put("queryEternalEffects", new DynamicSelect_queryEternalEffects());
}
public final class DynamicSelect_queryEternalEffects implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.EternalEffect>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.EternalEffect bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}