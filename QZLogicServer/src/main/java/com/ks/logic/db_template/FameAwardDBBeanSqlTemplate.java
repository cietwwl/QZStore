package com.ks.logic.db_template;
public final class FameAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.FameAward>{
public FameAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.FameAward.class;
mapper = new com.ks.table.FameAwardTable.DBRowMapper_FameAward();
sqlMap.put("queryFameAward","select * from t_fame_award");
paramMethodMap.put("queryFameAward", new DynamicSelect_queryFameAward());
}
public final class DynamicSelect_queryFameAward implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.FameAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.FameAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}