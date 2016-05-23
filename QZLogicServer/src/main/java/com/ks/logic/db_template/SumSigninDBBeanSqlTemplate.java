package com.ks.logic.db_template;
public final class SumSigninDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.SumSignin>{
public SumSigninDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.SumSignin.class;
mapper = new com.ks.table.SumSigninTable.DBRowMapper_SumSignin();
sqlMap.put("querySumSignins","select * from t_sum_signin");
paramMethodMap.put("querySumSignins", new DynamicSelect_querySumSignins());
}
public final class DynamicSelect_querySumSignins implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.SumSignin>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.SumSignin bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}