package com.ks.logic.db_template;
import com.ks.util.StringUtil;
public final class PassiveSkillDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.PassiveSkill>{
public PassiveSkillDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.PassiveSkill.class;
mapper = new com.ks.table.PassiveSkillTable.DBRowMapper_PassiveSkill();
sqlMap.put("queryPassiveSkill","select * from t_passive_skill");
paramMethodMap.put("queryPassiveSkill", new DynamicSelect_queryPassiveSkill());
}
public final class DynamicSelect_queryPassiveSkill implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.PassiveSkill>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.PassiveSkill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}