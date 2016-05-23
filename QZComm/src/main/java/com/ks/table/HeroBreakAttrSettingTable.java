package com.ks.table;
public final class HeroBreakAttrSettingTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.HeroBreakAttrSetting>{
public static HeroBreakAttrSettingTable instance;
public static final String TABLE_NAME="t_hero_break_attr_setting";
public static final String GROUPID="groupId";
public static final String BREAKLEVEL="breakLevel";
public static final String SLOT="slot";
public static final String HP="hp";
public static final String ATK="atk";

public static final String J_GROUPID="groupId";
public static final String J_BREAKLEVEL="breakLevel";
public static final String J_SLOT="slot";
public static final String J_HP="hp";
public static final String J_ATK="atk";

public HeroBreakAttrSettingTable(){
mapper=new DBRowMapper_HeroBreakAttrSetting();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.HeroBreakAttrSetting bean, String fname){
if(GROUPID.equals(fname)){
return bean.getGroupId();
}
if(BREAKLEVEL.equals(fname)){
return bean.getBreakLevel();
}
if(SLOT.equals(fname)){
return bean.getSlot();
}
if(HP.equals(fname)){
return bean.getHp();
}
if(ATK.equals(fname)){
return bean.getAtk();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.HeroBreakAttrSetting.class;
}
public final static class DBRowMapper_HeroBreakAttrSetting implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.HeroBreakAttrSetting>{
@Override
public com.ks.db.cfg.HeroBreakAttrSetting rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.HeroBreakAttrSetting bean = new com.ks.db.cfg.HeroBreakAttrSetting();
bean.setGroupId(rs.getInt("groupId"));
bean.setBreakLevel(rs.getInt("breakLevel"));
bean.setSlot(rs.getInt("slot"));
bean.setHp(rs.getInt("hp"));
bean.setAtk(rs.getInt("atk"));
return bean;
}
}
}
