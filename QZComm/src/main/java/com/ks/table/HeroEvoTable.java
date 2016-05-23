package com.ks.table;
public final class HeroEvoTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.HeroEvo>{
public static HeroEvoTable instance;
public static final String TABLE_NAME="t_hero_evo";
public static final String EVOID="evo_id";
public static final String HEROID="hero_id";
public static final String EVOHEROID="evo_hero_id";

public static final String J_EVOID="evoId";
public static final String J_HEROID="heroId";
public static final String J_EVOHEROID="evoHeroId";

public HeroEvoTable(){
mapper=new DBRowMapper_HeroEvo();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.HeroEvo bean, String fname){
if(EVOID.equals(fname)){
return bean.getEvoId();
}
if(HEROID.equals(fname)){
return bean.getHeroId();
}
if(EVOHEROID.equals(fname)){
return bean.getEvoHeroId();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.HeroEvo.class;
}
public final static class DBRowMapper_HeroEvo implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.HeroEvo>{
@Override
public com.ks.db.cfg.HeroEvo rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.HeroEvo bean = new com.ks.db.cfg.HeroEvo();
bean.setEvoId(rs.getInt("evo_id"));
bean.setHeroId(rs.getInt("hero_id"));
bean.setEvoHeroId(rs.getInt("evo_hero_id"));
return bean;
}
}
}
