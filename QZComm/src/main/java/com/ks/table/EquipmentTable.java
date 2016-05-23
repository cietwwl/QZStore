package com.ks.table;
public final class EquipmentTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Equipment>{
public static EquipmentTable instance;
public static final String TABLE_NAME="t_equipment";
public static final String EQUIPMENTID="equipment_id";
public static final String NAME="name";
public static final String TYPE="type";
public static final String HP="hp";
public static final String HPUP="hp_up";
public static final String ATK="atk";
public static final String ATKUP="atk_up";
public static final String BLOCKRATE="block_rate";
public static final String CRITRATE="crit_rate";
public static final String CRITHIT="crit_hit";
public static final String DODGERATE="dodge_rate";
public static final String SELLPRICE="sell_price";
public static final String ELE="ele";
public static final String QUALITY="quality";
public static final String RARITY="rarity";
public static final String MAXLEVEL="max_level";
public static final String ETERNALVAL="eternal_val";

public static final String J_EQUIPMENTID="equipmentId";
public static final String J_NAME="name";
public static final String J_TYPE="type";
public static final String J_HP="hp";
public static final String J_HPUP="hpUp";
public static final String J_ATK="atk";
public static final String J_ATKUP="atkUp";
public static final String J_BLOCKRATE="blockRate";
public static final String J_CRITRATE="critRate";
public static final String J_CRITHIT="critHit";
public static final String J_DODGERATE="dodgeRate";
public static final String J_SELLPRICE="sellPrice";
public static final String J_ELE="ele";
public static final String J_QUALITY="quality";
public static final String J_RARITY="rarity";
public static final String J_MAXLEVEL="maxLevel";
public static final String J_ETERNALVAL="eternalVal";

public EquipmentTable(){
mapper=new DBRowMapper_Equipment();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Equipment bean, String fname){
if(EQUIPMENTID.equals(fname)){
return bean.getEquipmentId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(HP.equals(fname)){
return bean.getHp();
}
if(HPUP.equals(fname)){
return bean.getHpUp();
}
if(ATK.equals(fname)){
return bean.getAtk();
}
if(ATKUP.equals(fname)){
return bean.getAtkUp();
}
if(BLOCKRATE.equals(fname)){
return bean.getBlockRate();
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
if(SELLPRICE.equals(fname)){
return bean.getSellPrice();
}
if(ELE.equals(fname)){
return bean.getEle();
}
if(QUALITY.equals(fname)){
return bean.getQuality();
}
if(RARITY.equals(fname)){
return bean.getRarity();
}
if(MAXLEVEL.equals(fname)){
return bean.getMaxLevel();
}
if(ETERNALVAL.equals(fname)){
return bean.getEternalVal();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Equipment.class;
}
public final static class DBRowMapper_Equipment implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Equipment>{
@Override
public com.ks.db.cfg.Equipment rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Equipment bean = new com.ks.db.cfg.Equipment();
bean.setEquipmentId(rs.getInt("equipment_id"));
bean.setName(rs.getString("name"));
bean.setType(rs.getInt("type"));
bean.setHp(rs.getInt("hp"));
bean.setHpUp(rs.getFloat("hp_up"));
bean.setAtk(rs.getInt("atk"));
bean.setAtkUp(rs.getFloat("atk_up"));
bean.setBlockRate(rs.getInt("block_rate"));
bean.setCritRate(rs.getInt("crit_rate"));
bean.setCritHit(rs.getInt("crit_hit"));
bean.setDodgeRate(rs.getInt("dodge_rate"));
bean.setSellPrice(rs.getInt("sell_price"));
bean.setEle(rs.getInt("ele"));
bean.setQuality(rs.getInt("quality"));
bean.setRarity(rs.getInt("rarity"));
bean.setMaxLevel(rs.getInt("max_level"));
bean.setEternalVal(rs.getInt("eternal_val"));
return bean;
}
}
}
