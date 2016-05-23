package com.ks.table;
public final class HeroRuleTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.HeroRule>{
public static HeroRuleTable instance;
public static final String TABLE_NAME="t_hero_rule";
public static final String LEVEL="level";
public static final String NEXTEXP="next_exp";
public static final String MONEY="money";
public static final String RONGLIANEXP="rong_lian_exp";
public static final String FENJIEEXP="fen_jie_exp";

public static final String J_LEVEL="level";
public static final String J_NEXTEXP="nextExp";
public static final String J_MONEY="money";
public static final String J_RONGLIANEXP="rongLianExp";
public static final String J_FENJIEEXP="fenjieExp";

public HeroRuleTable(){
mapper=new DBRowMapper_HeroRule();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.HeroRule bean, String fname){
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(NEXTEXP.equals(fname)){
return bean.getNextExp();
}
if(MONEY.equals(fname)){
return bean.getMoney();
}
if(RONGLIANEXP.equals(fname)){
return bean.getRongLianExp();
}
if(FENJIEEXP.equals(fname)){
return bean.getFenjieExp();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.HeroRule.class;
}
public final static class DBRowMapper_HeroRule implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.HeroRule>{
@Override
public com.ks.db.cfg.HeroRule rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.HeroRule bean = new com.ks.db.cfg.HeroRule();
bean.setLevel(rs.getInt("level"));
bean.setNextExp(rs.getInt("next_exp"));
bean.setMoney(rs.getInt("money"));
bean.setRongLianExp(rs.getInt("rong_lian_exp"));
bean.setFenjieExp(rs.getInt("fen_jie_exp"));
return bean;
}
}
}
