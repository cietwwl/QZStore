package com.ks.table;
public final class EquipmentUpRateTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.EquipmentUpRate>{
public static EquipmentUpRateTable instance;
public static final String TABLE_NAME="t_equipment_up_rate";
public static final String LEVEL="level";
public static final String SUCCESSRATE="success_rate";
public static final String MAXSUCCESSRATE="max_success_rate";
public static final String SUPERSUCCESSRATE="super_success_rate";
public static final String LOSERATE="lose_rate";

public static final String J_LEVEL="level";
public static final String J_SUCCESSRATE="successRate";
public static final String J_MAXSUCCESSRATE="maxSuccessRate";
public static final String J_SUPERSUCCESSRATE="superSuccessRate";
public static final String J_LOSERATE="loseRate";

public EquipmentUpRateTable(){
mapper=new DBRowMapper_EquipmentUpRate();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.EquipmentUpRate bean, String fname){
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(SUCCESSRATE.equals(fname)){
return bean.getSuccessRate();
}
if(MAXSUCCESSRATE.equals(fname)){
return bean.getMaxSuccessRate();
}
if(SUPERSUCCESSRATE.equals(fname)){
return bean.getSuperSuccessRate();
}
if(LOSERATE.equals(fname)){
return bean.getLoseRate();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.EquipmentUpRate.class;
}
public final static class DBRowMapper_EquipmentUpRate implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.EquipmentUpRate>{
@Override
public com.ks.db.cfg.EquipmentUpRate rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.EquipmentUpRate bean = new com.ks.db.cfg.EquipmentUpRate();
bean.setLevel(rs.getInt("level"));
bean.setSuccessRate(rs.getDouble("success_rate"));
bean.setMaxSuccessRate(rs.getDouble("max_success_rate"));
bean.setSuperSuccessRate(rs.getDouble("super_success_rate"));
bean.setLoseRate(rs.getDouble("lose_rate"));
return bean;
}
}
}
