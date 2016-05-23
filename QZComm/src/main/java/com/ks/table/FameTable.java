package com.ks.table;
public final class FameTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Fame>{
public static FameTable instance;
public static final String TABLE_NAME="t_fame";
public static final String FAMELEVEL="fame_level";
public static final String SLATE="slate";

public static final String J_FAMELEVEL="fameLevel";
public static final String J_SLATE="slate";

public FameTable(){
mapper=new DBRowMapper_Fame();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Fame bean, String fname){
if(FAMELEVEL.equals(fname)){
return bean.getFameLevel();
}
if(SLATE.equals(fname)){
return bean.getSlate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Fame.class;
}
public final static class DBRowMapper_Fame implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Fame>{
@Override
public com.ks.db.cfg.Fame rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Fame bean = new com.ks.db.cfg.Fame();
bean.setFameLevel(rs.getInt("fame_level"));
bean.setSlate(rs.getInt("slate"));
return bean;
}
}
}
