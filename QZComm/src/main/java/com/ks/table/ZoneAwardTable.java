package com.ks.table;
public final class ZoneAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ZoneAward>{
public static ZoneAwardTable instance;
public static final String TABLE_NAME="t_zone_award";
public static final String ZONEID="zone_id";
public static final String STAR="star";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_ZONEID="zoneId";
public static final String J_STAR="star";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public ZoneAwardTable(){
mapper=new DBRowMapper_ZoneAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ZoneAward bean, String fname){
if(ZONEID.equals(fname)){
return bean.getZoneId();
}
if(STAR.equals(fname)){
return bean.getStar();
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
return com.ks.db.cfg.ZoneAward.class;
}
public final static class DBRowMapper_ZoneAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ZoneAward>{
@Override
public com.ks.db.cfg.ZoneAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ZoneAward bean = new com.ks.db.cfg.ZoneAward();
bean.setZoneId(rs.getInt("zone_id"));
bean.setStar(rs.getInt("star"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
