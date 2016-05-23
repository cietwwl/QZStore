package com.ks.logic.db_template;
public final class CommonRewardConfigDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.CommonRewardConfig>{
public CommonRewardConfigDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.CommonRewardConfig.class;
mapper = new com.ks.table.CommonRewardConfigTable.DBRowMapper_CommonRewardConfig();
sqlMap.put("queryCommonRewardConfigs","select * from t_common_reward");
paramMethodMap.put("queryCommonRewardConfigs", new DynamicSelect_queryCommonRewardConfigs());
}
public final class DynamicSelect_queryCommonRewardConfigs implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.CommonRewardConfig>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.CommonRewardConfig bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}