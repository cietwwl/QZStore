package com.ks.logic.db_template;
public final class PropEffectDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.PropEffect>{
public PropEffectDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.PropEffect.class;
mapper = new com.ks.table.PropEffectTable.DBRowMapper_PropEffect();
sqlMap.put("queryPropEffects","select * from t_prop_effect");
paramMethodMap.put("queryPropEffects", new DynamicSelect_queryPropEffects());
}
public final class DynamicSelect_queryPropEffects implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.PropEffect>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.PropEffect bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}