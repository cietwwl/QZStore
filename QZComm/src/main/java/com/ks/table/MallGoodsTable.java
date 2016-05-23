package com.ks.table;
public final class MallGoodsTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.MallGoods>{
public static MallGoodsTable instance;
public static final String TABLE_NAME="t_mall_goods";
public static final String ID="id";
public static final String MALLID="mall_id";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_ID="id";
public static final String J_MALLID="mallId";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public MallGoodsTable(){
mapper=new DBRowMapper_MallGoods();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.MallGoods bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(MALLID.equals(fname)){
return bean.getMallId();
}
if(GOODSID.equals(fname)){
return bean.getGoodsId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(NUM.equals(fname)){
return bean.getNum();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.MallGoods.class;
}
public final static class DBRowMapper_MallGoods implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.MallGoods>{
@Override
public com.ks.db.cfg.MallGoods rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.MallGoods bean = new com.ks.db.cfg.MallGoods();
bean.setId(rs.getInt("id"));
bean.setMallId(rs.getInt("mall_id"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
