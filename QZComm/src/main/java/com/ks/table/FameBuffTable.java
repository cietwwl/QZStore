package com.ks.table;
public final class FameBuffTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.FameBuff>{
public static FameBuffTable instance;
public static final String TABLE_NAME="t_fame_buff";
public static final String FAMELEVEL="fame_level";
public static final String EFFECTID="effect_id";
public static final String SCORE="score";
public static final String CONS="cons";

public static final String J_FAMELEVEL="fameLevel";
public static final String J_EFFECTID="effectId";
public static final String J_SCORE="score";
public static final String J_CONS="cons";

public FameBuffTable(){
mapper=new DBRowMapper_FameBuff();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.FameBuff bean, String fname){
if(FAMELEVEL.equals(fname)){
return bean.getFameLevel();
}
if(EFFECTID.equals(fname)){
return bean.getEffectId();
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
return com.ks.db.cfg.FameBuff.class;
}
public final static class DBRowMapper_FameBuff implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.FameBuff>{
@Override
public com.ks.db.cfg.FameBuff rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.FameBuff bean = new com.ks.db.cfg.FameBuff();
bean.setFameLevel(rs.getInt("fame_level"));
bean.setEffectId(rs.getInt("effect_id"));
bean.setScore(rs.getInt("score"));
bean.setCons(rs.getInt("cons"));
return bean;
}
}
}
