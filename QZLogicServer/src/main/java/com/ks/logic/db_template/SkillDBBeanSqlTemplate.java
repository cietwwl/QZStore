package com.ks.logic.db_template;
public final class SkillDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Skill>{
public SkillDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Skill.class;
mapper = new com.ks.table.SkillTable.DBRowMapper_Skill();
sqlMap.put("querySkills","select * from t_skill");
paramMethodMap.put("querySkills", new DynamicSelect_querySkills());
}
public final class DynamicSelect_querySkills implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Skill>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Skill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}