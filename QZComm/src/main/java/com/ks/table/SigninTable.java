package com.ks.table;
public final class SigninTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Signin>{
public static SigninTable instance;
public static final String TABLE_NAME="t_signin";
public static final String DAY="day";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String LEVEL="level";

public static final String J_DAY="day";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_LEVEL="level";

public SigninTable(){
mapper=new DBRowMapper_Signin();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Signin bean, String fname){
if(DAY.equals(fname)){
return bean.getDay();
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
return com.ks.db.cfg.Signin.class;
}
public final static class DBRowMapper_Signin implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Signin>{
@Override
public com.ks.db.cfg.Signin rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Signin bean = new com.ks.db.cfg.Signin();
bean.setDay(rs.getInt("day"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setLevel(rs.getInt("level"));
return bean;
}
}
}
