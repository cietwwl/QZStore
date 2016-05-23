package com.ks.logic.db_template;
public final class BlowingRuleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.BlowingRule>{
public BlowingRuleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.BlowingRule.class;
mapper = new com.ks.table.BlowingRuleTable.DBRowMapper_BlowingRule();
sqlMap.put("queryBlowingRule","select * from t_blowing_rule");
paramMethodMap.put("queryBlowingRule", new DynamicSelect_queryBlowingRule());
}
public final class DynamicSelect_queryBlowingRule implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.BlowingRule>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.BlowingRule bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}