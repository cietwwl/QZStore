package com.ks.logic.db_template;
public final class DropDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Drop>{
public DropDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Drop.class;
mapper = new com.ks.table.DropTable.DBRowMapper_Drop();
sqlMap.put("queryDrops","select * from t_drop");
paramMethodMap.put("queryDrops", new DynamicSelect_queryDrops());
}
public final class DynamicSelect_queryDrops implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Drop>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Drop bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}