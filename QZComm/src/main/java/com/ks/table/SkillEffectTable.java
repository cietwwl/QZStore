package com.ks.table;
public final class SkillEffectTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.SkillEffect>{
public static SkillEffectTable instance;
public static final String TABLE_NAME="t_skill_effect";
public static final String ID="id";
public static final String SKILLID="skill_id";
public static final String LV="lv";
public static final String STATE="state";
public static final String EFFECTID="effect_id";
public static final String SCORE="score";
public static final String CONS="cons";
public static final String ROUND="round";
public static final String TARGET="target";
public static final String RANGE="range";
public static final String RANDOM="random";

public static final String J_ID="id";
public static final String J_SKILLID="skillId";
public static final String J_LV="lv";
public static final String J_STATE="state";
public static final String J_EFFECTID="effectId";
public static final String J_SCORE="score";
public static final String J_CONS="cons";
public static final String J_ROUND="round";
public static final String J_TARGET="target";
public static final String J_RANGE="range";
public static final String J_RANDOM="random";

public SkillEffectTable(){
mapper=new DBRowMapper_SkillEffect();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.SkillEffect bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
if(LV.equals(fname)){
return bean.getLv();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(EFFECTID.equals(fname)){
return bean.getEffectId();
}
if(SCORE.equals(fname)){
return bean.getScore();
}
if(CONS.equals(fname)){
return bean.getCons();
}
if(ROUND.equals(fname)){
return bean.getRound();
}
if(TARGET.equals(fname)){
return bean.getTarget();
}
if(RANGE.equals(fname)){
return bean.getRange();
}
if(RANDOM.equals(fname)){
return bean.getRandom();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.SkillEffect.class;
}
public final static class DBRowMapper_SkillEffect implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.SkillEffect>{
@Override
public com.ks.db.cfg.SkillEffect rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.SkillEffect bean = new com.ks.db.cfg.SkillEffect();
bean.setId(rs.getInt("id"));
bean.setSkillId(rs.getInt("skill_id"));
bean.setLv(rs.getInt("lv"));
bean.setState(rs.getInt("state"));
bean.setEffectId(rs.getInt("effect_id"));
bean.setScore(rs.getInt("score"));
bean.setCons(rs.getInt("cons"));
bean.setRound(rs.getInt("round"));
bean.setTarget(rs.getInt("target"));
bean.setRange(rs.getString("range"));
bean.setRandom(rs.getInt("random"));
return bean;
}
}
}
