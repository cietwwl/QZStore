package com.ks.logic.db_template;
public final class VipConfigDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.VipConfig>{
public VipConfigDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.VipConfig.class;
mapper = new com.ks.table.VipConfigTable.DBRowMapper_VipConfig();
sqlMap.put("queryVipConfigs","select * from t_vip_config");
paramMethodMap.put("queryVipConfigs", new DynamicSelect_queryVipConfigs());
}
public final class DynamicSelect_queryVipConfigs implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.VipConfig>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.VipConfig bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}