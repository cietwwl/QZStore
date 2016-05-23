package com.ks.logic.db_template;
public final class AchieveDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Achieve>{
public AchieveDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Achieve.class;
mapper = new com.ks.table.AchieveTable.DBRowMapper_Achieve();
sqlMap.put("queryAchieves","select * from t_achieve order by achieve_id asc");
paramMethodMap.put("queryAchieves", new DynamicSelect_queryAchieves());
}
public final class DynamicSelect_queryAchieves implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Achieve>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Achieve bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}