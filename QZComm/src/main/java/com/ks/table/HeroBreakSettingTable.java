package com.ks.table;
public final class HeroBreakSettingTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.HeroBreakSetting>{
public static HeroBreakSettingTable instance;
public static final String TABLE_NAME="t_hero_break_setting";
public static final String GROUPID="groupId";
public static final String BREAKLEVEL="breakLevel";
public static final String SLOT="slot";
public static final String NEEDLEVEL="needLevel";
public static final String TYPE="type";
public static final String GOODS_ID="goods_id";
public static final String NUM="num";

public static final String J_GROUPID="groupId";
public static final String J_BREAKLEVEL="breakLevel";
public static final String J_SLOT="slot";
public static final String J_NEEDLEVEL="needLevel";
public static final String J_TYPE="type";
public static final String J_GOODS_ID="goods_id";
public static final String J_NUM="num";

public HeroBreakSettingTable(){
mapper=new DBRowMapper_HeroBreakSetting();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.HeroBreakSetting bean, String fname){
if(GROUPID.equals(fname)){
return bean.getGroupId();
}
if(BREAKLEVEL.equals(fname)){
return bean.getBreakLevel();
}
if(SLOT.equals(fname)){
return bean.getSlot();
}
if(NEEDLEVEL.equals(fname)){
return bean.getNeedLevel();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(GOODS_ID.equals(fname)){
return bean.getGoods_id();
}
if(NUM.equals(fname)){
return bean.getNum();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.HeroBreakSetting.class;
}
public final static class DBRowMapper_HeroBreakSetting implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.HeroBreakSetting>{
@Override
public com.ks.db.cfg.HeroBreakSetting rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.HeroBreakSetting bean = new com.ks.db.cfg.HeroBreakSetting();
bean.setGroupId(rs.getInt("groupId"));
bean.setBreakLevel(rs.getInt("breakLevel"));
bean.setSlot(rs.getInt("slot"));
bean.setNeedLevel(rs.getInt("needLevel"));
bean.setType(rs.getInt("type"));
bean.setGoods_id(rs.getInt("goods_id"));
bean.setNum(rs.getInt("num"));
return bean;
}
}
}
