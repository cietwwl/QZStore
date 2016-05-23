package com.ks.table;
public final class EternalEffectTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.EternalEffect>{
public static EternalEffectTable instance;
public static final String TABLE_NAME="t_eternal_effect";
public static final String ETERNALID="eternal_id";
public static final String EFFECTTYPE="effect_type";
public static final String SCORE="score";
public static final String CONS="cons";

public static final String J_ETERNALID="eternalId";
public static final String J_EFFECTTYPE="effectType";
public static final String J_SCORE="score";
public static final String J_CONS="cons";

public EternalEffectTable(){
mapper=new DBRowMapper_EternalEffect();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.EternalEffect bean, String fname){
if(ETERNALID.equals(fname)){
return bean.getEternalId();
}
if(EFFECTTYPE.equals(fname)){
return bean.getEffectType();
}
if(SCORE.equals(fname)){
return bean.getScore();
}
if(CONS.equals(fname)){
return bean.getCons();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.EternalEffect.class;
}
public final static class DBRowMapper_EternalEffect implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.EternalEffect>{
@Override
public com.ks.db.cfg.EternalEffect rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.EternalEffect bean = new com.ks.db.cfg.EternalEffect();
bean.setEternalId(rs.getInt("eternal_id"));
bean.setEffectType(rs.getInt("effect_type"));
bean.setScore(rs.getInt("score"));
bean.setCons(rs.getInt("cons"));
return bean;
}
}
}
