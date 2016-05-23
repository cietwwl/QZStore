package com.ks.table;
public final class ArenaBuyTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.ArenaBuy>{
public static ArenaBuyTable instance;
public static final String TABLE_NAME="t_arena_buy";
public static final String COUNT="count";
public static final String BUYBATTLEPRICE="buy_count";
public static final String BUYREFRESHPRICE="shopping_money";

public static final String J_COUNT="count";
public static final String J_BUYBATTLEPRICE="buyBattlePrice";
public static final String J_BUYREFRESHPRICE="buyRefreshPrice";

public ArenaBuyTable(){
mapper=new DBRowMapper_ArenaBuy();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.ArenaBuy bean, String fname){
if(COUNT.equals(fname)){
return bean.getCount();
}
if(BUYBATTLEPRICE.equals(fname)){
return bean.getBuyBattlePrice();
}
if(BUYREFRESHPRICE.equals(fname)){
return bean.getBuyRefreshPrice();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.ArenaBuy.class;
}
public final static class DBRowMapper_ArenaBuy implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.ArenaBuy>{
@Override
public com.ks.db.cfg.ArenaBuy rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.ArenaBuy bean = new com.ks.db.cfg.ArenaBuy();
bean.setCount(rs.getInt("count"));
bean.setBuyBattlePrice(rs.getInt("buy_count"));
bean.setBuyRefreshPrice(rs.getInt("shopping_money"));
return bean;
}
}
}
