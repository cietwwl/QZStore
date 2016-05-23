package com.ks.table;
public final class SumSigninTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.SumSignin>{
public static SumSigninTable instance;
public static final String TABLE_NAME="t_sum_signin";
public static final String DAYNUM="day_num";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_DAYNUM="dayNum";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public SumSigninTable(){
mapper=new DBRowMapper_SumSignin();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.SumSignin bean, String fname){
if(DAYNUM.equals(fname)){
return bean.getDayNum();
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
return com.ks.db.cfg.SumSignin.class;
}
public final static class DBRowMapper_SumSignin implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.SumSignin>{
@Override
public com.ks.db.cfg.SumSignin rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.SumSignin bean = new com.ks.db.cfg.SumSignin();
bean.setDayNum(rs.getInt("day_num"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
