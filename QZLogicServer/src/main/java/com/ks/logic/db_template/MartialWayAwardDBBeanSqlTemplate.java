package com.ks.logic.db_template;
public final class MartialWayAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.MartialWayAward>{
public MartialWayAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.MartialWayAward.class;
mapper = new com.ks.table.MartialWayAwardTable.DBRowMapper_MartialWayAward();
sqlMap.put("queryMartialWayAwards","select * from t_martial_way_award");
paramMethodMap.put("queryMartialWayAwards", new DynamicSelect_queryMartialWayAwards());
}
public final class DynamicSelect_queryMartialWayAwards implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.MartialWayAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.MartialWayAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}