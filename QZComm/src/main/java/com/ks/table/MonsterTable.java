package com.ks.table;
public final class MonsterTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Monster>{
public static MonsterTable instance;
public static final String TABLE_NAME="t_monster";
public static final String MONSTERID="monster_id";
public static final String NAME="name";
public static final String ELE="ele";
public static final String ELELV="ele_lv";
public static final String ABILITY="ability";
public static final String HP="hp";
public static final String ATK="atk";
public static final String ATKCOUNT="atk_count";
public static final String CRITRATE="crit_rate";
public static final String CRITHIT="crit_hit";
public static final String DODGERATE="dodge_rate";
public static final String BODYTYPE="body_type";

public static final String J_MONSTERID="monsterId";
public static final String J_NAME="name";
public static final String J_ELE="ele";
public static final String J_ELELV="eleLv";
public static final String J_ABILITY="ability";
public static final String J_HP="hp";
public static final String J_ATK="atk";
public static final String J_ATKCOUNT="atkCount";
public static final String J_CRITRATE="critRate";
public static final String J_CRITHIT="critHit";
public static final String J_DODGERATE="dodgeRate";
public static final String J_BODYTYPE="bodyType";

public MonsterTable(){
mapper=new DBRowMapper_Monster();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Monster bean, String fname){
if(MONSTERID.equals(fname)){
return bean.getMonsterId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(ELE.equals(fname)){
return bean.getEle();
}
if(ELELV.equals(fname)){
return bean.getEleLv();
}
if(ABILITY.equals(fname)){
return bean.getAbility();
}
if(HP.equals(fname)){
return bean.getHp();
}
if(ATK.equals(fname)){
return bean.getAtk();
}
if(ATKCOUNT.equals(fname)){
return bean.getAtkCount();
}
if(CRITRATE.equals(fname)){
return bean.getCritRate();
}
if(CRITHIT.equals(fname)){
return bean.getCritHit();
}
if(DODGERATE.equals(fname)){
return bean.getDodgeRate();
}
if(BODYTYPE.equals(fname)){
return bean.getBodyType();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Monster.class;
}
public final static class DBRowMapper_Monster implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Monster>{
@Override
public com.ks.db.cfg.Monster rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Monster bean = new com.ks.db.cfg.Monster();
bean.setMonsterId(rs.getInt("monster_id"));
bean.setName(rs.getString("name"));
bean.setEle(rs.getInt("ele"));
bean.setEleLv(rs.getInt("ele_lv"));
bean.setAbility(rs.getInt("ability"));
bean.setHp(rs.getInt("hp"));
bean.setAtk(rs.getInt("atk"));
bean.setAtkCount(rs.getInt("atk_count"));
bean.setCritRate(rs.getInt("crit_rate"));
bean.setCritHit(rs.getInt("crit_hit"));
bean.setDodgeRate(rs.getInt("dodge_rate"));
bean.setBodyType(rs.getInt("body_type"));
return bean;
}
}
}
