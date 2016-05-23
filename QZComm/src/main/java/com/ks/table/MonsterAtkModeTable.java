package com.ks.table;
public final class MonsterAtkModeTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.MonsterAtkMode>{
public static MonsterAtkModeTable instance;
public static final String TABLE_NAME="t_monster_atk_mode";
public static final String ID="id";
public static final String MONSTERID="monster_id";
public static final String ATKMODE="atk_mode";
public static final String MOVEMODE="move_mode";
public static final String SKILLID="skill_id";
public static final String CD="cd";

public static final String J_ID="id";
public static final String J_MONSTERID="monsterId";
public static final String J_ATKMODE="atkMode";
public static final String J_MOVEMODE="moveMode";
public static final String J_SKILLID="skillId";
public static final String J_CD="cd";

public MonsterAtkModeTable(){
mapper=new DBRowMapper_MonsterAtkMode();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.MonsterAtkMode bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(MONSTERID.equals(fname)){
return bean.getMonsterId();
}
if(ATKMODE.equals(fname)){
return bean.getAtkMode();
}
if(MOVEMODE.equals(fname)){
return bean.getMoveMode();
}
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
if(CD.equals(fname)){
return bean.getCd();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.MonsterAtkMode.class;
}
public final static class DBRowMapper_MonsterAtkMode implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.MonsterAtkMode>{
@Override
public com.ks.db.cfg.MonsterAtkMode rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.MonsterAtkMode bean = new com.ks.db.cfg.MonsterAtkMode();
bean.setId(rs.getInt("id"));
bean.setMonsterId(rs.getInt("monster_id"));
bean.setAtkMode(rs.getString("atk_mode"));
bean.setMoveMode(rs.getString("move_mode"));
bean.setSkillId(rs.getInt("skill_id"));
bean.setCd(rs.getInt("cd"));
return bean;
}
}
}
