package com.ks.table;
public final class AchieveAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.AchieveAward>{
public static AchieveAwardTable instance;
public static final String TABLE_NAME="t_achieve_award";
public static final String ACHIEVEID="achieve_id";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_ACHIEVEID="achieveId";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public AchieveAwardTable(){
mapper=new DBRowMapper_AchieveAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.AchieveAward bean, String fname){
if(ACHIEVEID.equals(fname)){
return bean.getAchieveId();
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
return com.ks.db.cfg.AchieveAward.class;
}
public final static class DBRowMapper_AchieveAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.AchieveAward>{
@Override
public com.ks.db.cfg.AchieveAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.AchieveAward bean = new com.ks.db.cfg.AchieveAward();
bean.setAchieveId(rs.getInt("achieve_id"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
