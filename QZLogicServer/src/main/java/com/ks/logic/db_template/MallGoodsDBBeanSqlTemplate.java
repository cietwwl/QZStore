package com.ks.logic.db_template;
public final class MallGoodsDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.cfg.MallGoods>{
public MallGoodsDBBeanSqlTemplate(){
super();
clazz=com.ks.db.cfg.MallGoods.class;
mapper = new com.ks.table.MallGoodsTable.DBRowMapper_MallGoods();
sqlMap.put("queryAllMallGoods","select * from t_mall_goods");
paramMethodMap.put("queryAllMallGoods", new DynamicSelect_queryAllMallGoods());
}
public final class DynamicSelect_queryAllMallGoods implements com.ks.access.DBBeanParamMethod<com.ks.db.cfg.MallGoods>{
@Override
public java.util.List<Object> getParams(com.ks.db.cfg.MallGoods bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
}