package com.ks.table;
public final class ExploreAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ExploreAward>{
public static ExploreAwardTable instance;
public static final String TABLE_NAME="t_explore_award";
public static final String ARRAYID="array_id";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";
public static final String RATE="rate";

public static final String J_ARRAYID="arrayId";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";
public static final String J_RATE="rate";

public ExploreAwardTable(){
mapper=new DBRowMapper_ExploreAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ExploreAward bean, String fname){
if(ARRAYID.equals(fname)){
return bean.getArrayId();
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
if(RATE.equals(fname)){
return bean.getRate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.ExploreAward.class;
}
public final static class DBRowMapper_ExploreAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ExploreAward>{
@Override
public com.ks.db.cfg.ExploreAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ExploreAward bean = new com.ks.db.cfg.ExploreAward();
bean.setArrayId(rs.getInt("array_id"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
bean.setRate(rs.getInt("rate"));
return bean;
}
}
}
