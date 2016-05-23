package com.ks.table;
public final class CallHeroRuleTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.CallHeroRule>{
public static CallHeroRuleTable instance;
public static final String TABLE_NAME="t_call_hero_rule";
public static final String ARRAYID="array_id";
public static final String TYPE="type";
public static final String RATE="rate";

public static final String J_ARRAYID="arrayId";
public static final String J_TYPE="type";
public static final String J_RATE="rate";

public CallHeroRuleTable(){
mapper=new DBRowMapper_CallHeroRule();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.CallHeroRule bean, String fname){
if(ARRAYID.equals(fname)){
return bean.getArrayId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(RATE.equals(fname)){
return bean.getRate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.CallHeroRule.class;
}
public final static class DBRowMapper_CallHeroRule implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.CallHeroRule>{
@Override
public com.ks.db.cfg.CallHeroRule rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.CallHeroRule bean = new com.ks.db.cfg.CallHeroRule();
bean.setArrayId(rs.getInt("array_id"));
bean.setType(rs.getInt("type"));
bean.setRate(rs.getInt("rate"));
return bean;
}
}
}
