package com.ks.table;
public final class FameAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.FameAward>{
public static FameAwardTable instance;
public static final String TABLE_NAME="t_fame_award";
public static final String FAMELEVEL="fame_level";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_FAMELEVEL="fameLevel";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public FameAwardTable(){
mapper=new DBRowMapper_FameAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.FameAward bean, String fname){
if(FAMELEVEL.equals(fname)){
return bean.getFameLevel();
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
return com.ks.db.cfg.FameAward.class;
}
public final static class DBRowMapper_FameAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.FameAward>{
@Override
public com.ks.db.cfg.FameAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.FameAward bean = new com.ks.db.cfg.FameAward();
bean.setFameLevel(rs.getInt("fame_level"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
