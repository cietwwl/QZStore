package com.ks.logic.db_template;
public final class AchieveAwardDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.AchieveAward>{
public AchieveAwardDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.AchieveAward.class;
mapper = new com.ks.table.AchieveAwardTable.DBRowMapper_AchieveAward();
sqlMap.put("queryAchieveAwards","select * from t_achieve_award");
paramMethodMap.put("queryAchieveAwards", new DynamicSelect_queryAchieveAwards());
}
public final class DynamicSelect_queryAchieveAwards implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.AchieveAward>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.AchieveAward bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}