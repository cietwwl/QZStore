package com.ks.logic.db_template;
public final class PropDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Prop>{
public PropDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Prop.class;
mapper = new com.ks.table.PropTable.DBRowMapper_Prop();
sqlMap.put("queryProps","select * from t_prop");
paramMethodMap.put("queryProps", new DynamicSelect_queryProps());
}
public final class DynamicSelect_queryProps implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Prop>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Prop bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}