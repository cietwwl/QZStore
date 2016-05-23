package com.ks.logic.db_template;
public final class SkillEffectDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.SkillEffect>{
public SkillEffectDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.SkillEffect.class;
mapper = new com.ks.table.SkillEffectTable.DBRowMapper_SkillEffect();
sqlMap.put("querySkillEffects","select * from t_skill_effect");
paramMethodMap.put("querySkillEffects", new DynamicSelect_querySkillEffects());
}
public final class DynamicSelect_querySkillEffects implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.SkillEffect>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.SkillEffect bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}