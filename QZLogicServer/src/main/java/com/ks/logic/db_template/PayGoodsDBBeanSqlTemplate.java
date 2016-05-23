package com.ks.logic.db_template;
public final class PayGoodsDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.PayGoods>{
public PayGoodsDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.PayGoods.class;
mapper = new com.ks.table.PayGoodsTable.DBRowMapper_PayGoods();
sqlMap.put("queryPayGoodses","select * from t_pay_goods");
paramMethodMap.put("queryPayGoodses", new DynamicSelect_queryPayGoodses());
}
public final class DynamicSelect_queryPayGoodses implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.PayGoods>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.PayGoods bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}