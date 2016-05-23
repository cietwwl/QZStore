package com.ks.table;
public final class EquipmentUpTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.EquipmentUp>{
public static EquipmentUpTable instance;
public static final String TABLE_NAME="t_equipment_up";
public static final String ID="id";
public static final String EQUIPMENTLEVEL="equipment_level";
public static final String ASSID="ass_id";
public static final String TYPE="type";
public static final String NUM="num";

public static final String J_ID="id";
public static final String J_EQUIPMENTLEVEL="equipmentLevel";
public static final String J_ASSID="assId";
public static final String J_TYPE="type";
public static final String J_NUM="num";

public EquipmentUpTable(){
mapper=new DBRowMapper_EquipmentUp();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.EquipmentUp bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(EQUIPMENTLEVEL.equals(fname)){
return bean.getEquipmentLevel();
}
if(ASSID.equals(fname)){
return bean.getAssId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(NUM.equals(fname)){
return bean.getNum();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.EquipmentUp.class;
}
public final static class DBRowMapper_EquipmentUp implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.EquipmentUp>{
@Override
public com.ks.db.cfg.EquipmentUp rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.EquipmentUp bean = new com.ks.db.cfg.EquipmentUp();
bean.setId(rs.getInt("id"));
bean.setEquipmentLevel(rs.getInt("equipment_level"));
bean.setAssId(rs.getInt("ass_id"));
bean.setType(rs.getInt("type"));
bean.setNum(rs.getInt("num"));
return bean;
}
}
}
