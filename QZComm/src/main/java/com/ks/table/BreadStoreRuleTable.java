package com.ks.table;
public final class BreadStoreRuleTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.BreadStoreRule>{
public static BreadStoreRuleTable instance;
public static final String TABLE_NAME="t_bread_store_rule";
public static final String LEVELS="n_levels";
public static final String STARPROBABILITYS="n_starProbabilitys";

public static final String J_LEVELS="levels";
public static final String J_STARPROBABILITYS="starProbabilitys";

public BreadStoreRuleTable(){
mapper=new DBRowMapper_BreadStoreRule();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.BreadStoreRule bean, String fname){
if(LEVELS.equals(fname)){
return bean.getLevels();
}
if(STARPROBABILITYS.equals(fname)){
return bean.getStarProbabilitys();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.BreadStoreRule.class;
}
public final static class DBRowMapper_BreadStoreRule implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.BreadStoreRule>{
@Override
public com.ks.db.cfg.BreadStoreRule rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.BreadStoreRule bean = new com.ks.db.cfg.BreadStoreRule();
bean.setLevels(rs.getString("n_levels"));
bean.setStarProbabilitys(rs.getString("n_starProbabilitys"));
return bean;
}
}
}
