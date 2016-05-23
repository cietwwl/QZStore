package com.ks.table;
public final class SkillTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Skill>{
public static SkillTable instance;
public static final String TABLE_NAME="t_skill";
public static final String SKILLID="skill_id";
public static final String LV="lv";
public static final String NAME="name";
public static final String DELAY="delay";
public static final String CD="cd";

public static final String J_SKILLID="skillId";
public static final String J_LV="lv";
public static final String J_NAME="name";
public static final String J_DELAY="delay";
public static final String J_CD="cd";

public SkillTable(){
mapper=new DBRowMapper_Skill();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Skill bean, String fname){
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
if(LV.equals(fname)){
return bean.getLv();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(DELAY.equals(fname)){
return bean.isDelay();
}
if(CD.equals(fname)){
return bean.getCd();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Skill.class;
}
public final static class DBRowMapper_Skill implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Skill>{
@Override
public com.ks.db.cfg.Skill rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Skill bean = new com.ks.db.cfg.Skill();
bean.setSkillId(rs.getInt("skill_id"));
bean.setLv(rs.getInt("lv"));
bean.setName(rs.getString("name"));
bean.setDelay(rs.getBoolean("delay"));
bean.setCd(rs.getInt("cd"));
return bean;
}
}
}
