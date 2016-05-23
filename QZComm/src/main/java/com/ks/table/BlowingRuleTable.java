package com.ks.table;
public final class BlowingRuleTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.BlowingRule>{
public static BlowingRuleTable instance;
public static final String TABLE_NAME="t_blowing_rule";
public static final String TYPE="type";
public static final String PROPID="prop_id";
public static final String RATE="rate";

public static final String J_TYPE="type";
public static final String J_PROPID="propId";
public static final String J_RATE="rate";

public BlowingRuleTable(){
mapper=new DBRowMapper_BlowingRule();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.BlowingRule bean, String fname){
if(TYPE.equals(fname)){
return bean.getType();
}
if(PROPID.equals(fname)){
return bean.getPropId();
}
if(RATE.equals(fname)){
return bean.getRate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.BlowingRule.class;
}
public final static class DBRowMapper_BlowingRule implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.BlowingRule>{
@Override
public com.ks.db.cfg.BlowingRule rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.BlowingRule bean = new com.ks.db.cfg.BlowingRule();
bean.setType(rs.getInt("type"));
bean.setPropId(rs.getInt("prop_id"));
bean.setRate(rs.getInt("rate"));
return bean;
}
}
}
