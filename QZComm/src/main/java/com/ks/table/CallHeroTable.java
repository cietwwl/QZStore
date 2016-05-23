package com.ks.table;
public final class CallHeroTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.CallHero>{
public static CallHeroTable instance;
public static final String TABLE_NAME="t_call_hero";
public static final String ARRAYID="array_id";
public static final String HEROID="hero_id";

public static final String J_ARRAYID="arrayId";
public static final String J_HEROID="heroId";

public CallHeroTable(){
mapper=new DBRowMapper_CallHero();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.CallHero bean, String fname){
if(ARRAYID.equals(fname)){
return bean.getArrayId();
}
if(HEROID.equals(fname)){
return bean.getHeroId();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.CallHero.class;
}
public final static class DBRowMapper_CallHero implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.CallHero>{
@Override
public com.ks.db.cfg.CallHero rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.CallHero bean = new com.ks.db.cfg.CallHero();
bean.setArrayId(rs.getInt("array_id"));
bean.setHeroId(rs.getInt("hero_id"));
return bean;
}
}
}
