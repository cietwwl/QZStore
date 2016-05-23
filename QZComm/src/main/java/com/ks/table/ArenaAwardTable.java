package com.ks.table;
public final class ArenaAwardTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ArenaAward>{
public static ArenaAwardTable instance;
public static final String TABLE_NAME="t_arena_award";
public static final String SHOPPINGID="shopping_id";
public static final String GOODSID="goods_id";
public static final String TYPE="type";
public static final String NUM="num";
public static final String MONEY="money";
public static final String LEVEL="level";
public static final String RATE="rate";

public static final String J_SHOPPINGID="shoppingId";
public static final String J_GOODSID="goodsId";
public static final String J_TYPE="type";
public static final String J_NUM="num";
public static final String J_MONEY="money";
public static final String J_LEVEL="level";
public static final String J_RATE="rate";

public ArenaAwardTable(){
mapper=new DBRowMapper_ArenaAward();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ArenaAward bean, String fname){
if(SHOPPINGID.equals(fname)){
return bean.getShoppingId();
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
if(MONEY.equals(fname)){
return bean.getMoney();
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
return com.ks.db.cfg.ArenaAward.class;
}
public final static class DBRowMapper_ArenaAward implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ArenaAward>{
@Override
public com.ks.db.cfg.ArenaAward rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ArenaAward bean = new com.ks.db.cfg.ArenaAward();
bean.setShoppingId(rs.getInt("shopping_id"));
bean.setGoodsId(rs.getInt("goods_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
bean.setMoney(rs.getInt("money"));
bean.setLevel(rs.getInt("level"));
bean.setRate(rs.getInt("rate"));
return bean;
}
}
}
