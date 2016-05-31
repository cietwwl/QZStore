package com.ks.table;
public final class UserHeroTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserHero>{
public static UserHeroTable instance;
public static final String TABLE_NAME_PREFIX="t_user_hero_";
public static final String ID="id";
public static final String USERID="user_id";
public static final String HEROID="hero_id";
public static final String LEVEL="level";
public static final String EXP="exp";
public static final String ELELEVEL="ele_level";
public static final String STATE="state";
public static final String SKILLLEVEL="skill_level";
public static final String CAPSKILLLEVEL="cap_skill_level";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";
public static final String ETERNAL="eternal";
public static final String BREAKLEVEL="breakLevel";
public static final String BREAKEDSLOTS="breakedSlots";

public static final String J_ID="id";
public static final String J_USERID="userId";
public static final String J_HEROID="heroId";
public static final String J_LEVEL="level";
public static final String J_EXP="exp";
public static final String J_ELELEVEL="eleLevel";
public static final String J_STATE="state";
public static final String J_SKILLLEVEL="skillLevel";
public static final String J_CAPSKILLLEVEL="capSkillLevel";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";
public static final String J_ETERNAL="eternal";
public static final String J_BREAKLEVEL="breakLevel";
public static final String J_BREAKEDSLOTS="breakedSlots";

public static String getTableName(int index){return TABLE_NAME_PREFIX + (index % 10);}
public UserHeroTable(){
mapper=new DBRowMapper_UserHero();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserHero bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(HEROID.equals(fname)){
return bean.getHeroId();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(EXP.equals(fname)){
return bean.getExp();
}
if(ELELEVEL.equals(fname)){
return bean.getEleLevel();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(SKILLLEVEL.equals(fname)){
return bean.getSkillLevel();
}
if(CAPSKILLLEVEL.equals(fname)){
return bean.getCapSkillLevel();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
if(ETERNAL.equals(fname)){
return bean.getEternal();
}
if(BREAKLEVEL.equals(fname)){
return bean.getBreakLevel();
}
if(BREAKEDSLOTS.equals(fname)){
return bean.getBreakedSlots();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserHero.class;
}
public final static class DBRowMapper_UserHero implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserHero>{
@Override
public com.ks.db.model.UserHero rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserHero bean = new com.ks.db.model.UserHero();
bean.setId(rs.getInt("id"));
bean.setUserId(rs.getInt("user_id"));
bean.setHeroId(rs.getInt("hero_id"));
bean.setLevel(rs.getInt("level"));
bean.setExp(rs.getInt("exp"));
bean.setEleLevel(rs.getInt("ele_level"));
bean.setState(rs.getInt("state"));
bean.setSkillLevel(rs.getInt("skill_level"));
bean.setCapSkillLevel(rs.getInt("cap_skill_level"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
bean.setEternal(rs.getInt("eternal"));
bean.setBreakLevel(rs.getInt("breakLevel"));
bean.setBreakedSlots(rs.getString("breakedSlots"));
return bean;
}
}
}
