package com.ks.table;
public final class MartialWayAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.MartialWayAward>{
public static MartialWayAwardTable instance;
public static final String TABLE_NAME="t_martial_way_award";
public static final String MINRANK="min_rank";
public static final String MAXRANK="max_rank";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_MINRANK="minRank";
public static final String J_MAXRANK="maxRank";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public MartialWayAwardTable(){
mapper=new DBRowMapper_MartialWayAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.MartialWayAward bean, String fname){
if(MINRANK.equals(fname)){
return bean.getMinRank();
}
if(MAXRANK.equals(fname)){
return bean.getMaxRank();
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
return com.ks.db.cfg.MartialWayAward.class;
}
public final static class DBRowMapper_MartialWayAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.MartialWayAward>{
@Override
public com.ks.db.cfg.MartialWayAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.MartialWayAward bean = new com.ks.db.cfg.MartialWayAward();
bean.setMinRank(rs.getInt("min_rank"));
bean.setMaxRank(rs.getInt("max_rank"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
