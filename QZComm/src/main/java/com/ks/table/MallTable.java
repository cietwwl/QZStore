package com.ks.table;
public final class MallTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Mall>{
public static MallTable instance;
public static final String TABLE_NAME="t_mall";
public static final String ID="id";
public static final String TYPE="type";
public static final String VIP="vip";
public static final String STATE="state";
public static final String MONEYTYPE="money_type";
public static final String ORIGINALMONEY="original_money";
public static final String MONEY="money";
public static final String BUYCOUNT="buy_count";
public static final String POOLID="pool_id";
public static final String PUTAWAYTIME="putaway_time";
public static final String SHELVESTIME="shelves_time";
public static final String TOLECOUNT="tole_count";
public static final String RATE="rate";

public static final String J_ID="id";
public static final String J_TYPE="type";
public static final String J_VIP="vip";
public static final String J_STATE="state";
public static final String J_MONEYTYPE="moneyType";
public static final String J_ORIGINALMONEY="originalMoney";
public static final String J_MONEY="money";
public static final String J_BUYCOUNT="buyCount";
public static final String J_POOLID="poolId";
public static final String J_PUTAWAYTIME="putawayTime";
public static final String J_SHELVESTIME="shelvesTime";
public static final String J_TOLECOUNT="toleCount";
public static final String J_RATE="rate";

public MallTable(){
mapper=new DBRowMapper_Mall();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Mall bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(VIP.equals(fname)){
return bean.getVip();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(MONEYTYPE.equals(fname)){
return bean.getMoneyType();
}
if(ORIGINALMONEY.equals(fname)){
return bean.getOriginalMoney();
}
if(MONEY.equals(fname)){
return bean.getMoney();
}
if(BUYCOUNT.equals(fname)){
return bean.getBuyCount();
}
if(POOLID.equals(fname)){
return bean.getPoolId();
}
if(PUTAWAYTIME.equals(fname)){
return bean.getPutawayTime();
}
if(SHELVESTIME.equals(fname)){
return bean.getShelvesTime();
}
if(TOLECOUNT.equals(fname)){
return bean.getToleCount();
}
if(RATE.equals(fname)){
return bean.getRate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Mall.class;
}
public final static class DBRowMapper_Mall implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Mall>{
@Override
public com.ks.db.cfg.Mall rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Mall bean = new com.ks.db.cfg.Mall();
bean.setId(rs.getInt("id"));
bean.setType(rs.getInt("type"));
bean.setVip(rs.getInt("vip"));
bean.setState(rs.getInt("state"));
bean.setMoneyType(rs.getInt("money_type"));
bean.setOriginalMoney(rs.getInt("original_money"));
bean.setMoney(rs.getInt("money"));
bean.setBuyCount(rs.getInt("buy_count"));
bean.setPoolId(rs.getInt("pool_id"));
bean.setPutawayTime(rs.getTimestamp("putaway_time"));
bean.setShelvesTime(rs.getTimestamp("shelves_time"));
bean.setToleCount(rs.getInt("tole_count"));
bean.setRate(rs.getInt("rate"));
return bean;
}
}
}
