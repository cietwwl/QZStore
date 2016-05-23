package com.ks.table;
public final class EternalPropertyTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.EternalProperty>{
public static EternalPropertyTable instance;
public static final String TABLE_NAME="t_eternal_property";
public static final String QUALITY="quality";
public static final String SKILLTYPE="skill_type";
public static final String SKILLRATE="skill_rate";
public static final String STARTNUM="start_num";
public static final String ENDNUM="end_num";
public static final String ATKMODE="atk_mode";
public static final String TYPE="type";

public static final String J_QUALITY="quality";
public static final String J_SKILLTYPE="skillType";
public static final String J_SKILLRATE="skillRate";
public static final String J_STARTNUM="startNum";
public static final String J_ENDNUM="endNum";
public static final String J_ATKMODE="atkMode";
public static final String J_TYPE="type";

public EternalPropertyTable(){
mapper=new DBRowMapper_EternalProperty();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.EternalProperty bean, String fname){
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
if(ATKMODE.equals(fname)){
return bean.getAtkMode();
}
if(TYPE.equals(fname)){
return bean.getType();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.EternalProperty.class;
}
public final static class DBRowMapper_EternalProperty implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.EternalProperty>{
@Override
public com.ks.db.cfg.EternalProperty rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.EternalProperty bean = new com.ks.db.cfg.EternalProperty();
bean.setQuality(rs.getInt("quality"));
bean.setSkillType(rs.getInt("skill_type"));
bean.setSkillRate(rs.getDouble("skill_rate"));
bean.setStartNum(rs.getDouble("start_num"));
bean.setEndNum(rs.getDouble("end_num"));
bean.setAtkMode(rs.getString("atk_mode"));
bean.setType(rs.getInt("type"));
return bean;
}
}
}
