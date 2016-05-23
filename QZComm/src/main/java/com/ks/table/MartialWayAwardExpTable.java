package com.ks.table;
public final class MartialWayAwardExpTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.MartialWayAwardExp>{
public static MartialWayAwardExpTable instance;
public static final String TABLE_NAME="t_martial_way_exp";
public static final String LEVEL="level";
public static final String EXP="exp";

public static final String J_LEVEL="level";
public static final String J_EXP="exp";

public MartialWayAwardExpTable(){
mapper=new DBRowMapper_MartialWayAwardExp();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.MartialWayAwardExp bean, String fname){
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(EXP.equals(fname)){
return bean.getExp();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.MartialWayAwardExp.class;
}
public final static class DBRowMapper_MartialWayAwardExp implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.MartialWayAwardExp>{
@Override
public com.ks.db.cfg.MartialWayAwardExp rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.MartialWayAwardExp bean = new com.ks.db.cfg.MartialWayAwardExp();
bean.setLevel(rs.getInt("level"));
bean.setExp(rs.getInt("exp"));
return bean;
}
}
}
