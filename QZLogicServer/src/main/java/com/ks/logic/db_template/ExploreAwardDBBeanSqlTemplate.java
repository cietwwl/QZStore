package com.ks.logic.db_template;
public final class ExploreAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.ExploreAward>{
public ExploreAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.ExploreAward.class;
mapper = new com.ks.table.ExploreAwardTable.DBRowMapper_ExploreAward();
sqlMap.put("queryExploreAwards","select * from t_explore_award");
paramMethodMap.put("queryExploreAwards", new DynamicSelect_queryExploreAwards());
}
public final class DynamicSelect_queryExploreAwards implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.ExploreAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.ExploreAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}