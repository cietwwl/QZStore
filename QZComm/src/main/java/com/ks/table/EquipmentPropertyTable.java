package com.ks.table;
public final class EquipmentPropertyTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.EquipmentProperty>{
public static EquipmentPropertyTable instance;
public static final String TABLE_NAME="t_equipment_property";
public static final String QUALITY="quality";
public static final String SKILLTYPE="skill_type";
public static final String SKILLRATE="skill_rate";
public static final String STARTNUM="start_num";
public static final String ENDNUM="end_num";

public static final String J_QUALITY="quality";
public static final String J_SKILLTYPE="skillType";
public static final String J_SKILLRATE="skillRate";
public static final String J_STARTNUM="startNum";
public static final String J_ENDNUM="endNum";

public EquipmentPropertyTable(){
mapper=new DBRowMapper_EquipmentProperty();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.EquipmentProperty bean, String fname){
if(QUALITY.equals(fname)){
return bean.getQuality();
}
if(SKILLTYPE.equals(fname)){
return bean.getSkillType();
}
if(SKILLRATE.equals(fname)){
return bean.getSkillRate();
}
if(STARTNUM.equals(fname)){
return bean.getStartNum();
}
if(ENDNUM.equals(fname)){
return bean.getEndNum();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.EquipmentProperty.class;
}
public final static class DBRowMapper_EquipmentProperty implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.EquipmentProperty>{
@Override
public com.ks.db.cfg.EquipmentProperty rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.EquipmentProperty bean = new com.ks.db.cfg.EquipmentProperty();
bean.setQuality(rs.getInt("quality"));
bean.setSkillType(rs.getInt("skill_type"));
bean.setSkillRate(rs.getDouble("skill_rate"));
bean.setStartNum(rs.getDouble("start_num"));
bean.setEndNum(rs.getDouble("end_num"));
return bean;
}
}
}
