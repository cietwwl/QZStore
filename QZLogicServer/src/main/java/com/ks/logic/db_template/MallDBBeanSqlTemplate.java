package com.ks.logic.db_template;
public final class MallDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Mall>{
public MallDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Mall.class;
mapper = new com.ks.table.MallTable.DBRowMapper_Mall();
sqlMap.put("queryAllMall","select * from t_mall");
paramMethodMap.put("queryAllMall", new DynamicSelect_queryAllMall());
}
public final class DynamicSelect_queryAllMall implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Mall>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Mall bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}