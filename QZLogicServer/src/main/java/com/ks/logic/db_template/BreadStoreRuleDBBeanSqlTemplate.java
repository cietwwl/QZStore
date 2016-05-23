package com.ks.logic.db_template;
public final class BreadStoreRuleDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.BreadStoreRule>{
public BreadStoreRuleDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.BreadStoreRule.class;
mapper = new com.ks.table.BreadStoreRuleTable.DBRowMapper_BreadStoreRule();
sqlMap.put("queryBreadStoreRules","select * from t_bread_store_rule");
paramMethodMap.put("queryBreadStoreRules", new DynamicSelect_queryBreadStoreRules());
}
public final class DynamicSelect_queryBreadStoreRules implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.BreadStoreRule>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.BreadStoreRule bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}