package com.ks.logic.db_template;
public final class SigninDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.Signin>{
public SigninDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.Signin.class;
mapper = new com.ks.table.SigninTable.DBRowMapper_Signin();
sqlMap.put("querySignins","select * from t_signin");
paramMethodMap.put("querySignins", new DynamicSelect_querySignins());
}
public final class DynamicSelect_querySignins implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.Signin>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.Signin bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}