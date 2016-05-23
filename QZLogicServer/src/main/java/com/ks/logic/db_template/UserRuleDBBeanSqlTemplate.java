package com.ks.logic.db_template;
public final class UserRuleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.UserRule>{
public UserRuleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.UserRule.class;
mapper = new com.ks.table.UserRuleTable.DBRowMapper_UserRule();
sqlMap.put("queryUserRule","select * from t_user_rule");
paramMethodMap.put("queryUserRule", new DynamicSelect_queryUserRule());
}
public final class DynamicSelect_queryUserRule implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.UserRule>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.UserRule bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}