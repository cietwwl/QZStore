package com.ks.table;
public final class EternalTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.Eternal>{
public static EternalTable instance;
public static final String TABLE_NAME="t_eternal";
public static final String ETERNALID="eternal_id";
public static final String NAME="name";
public static final String ELE="ele";
public static final String QUALITY="quality";
public static final String SELLPRICE="sell_price";
public static final String RARITY="rarity";
public static final String SKILLID="skill_id";
public static final String ETERNALVAL="eternal_val";

public static final String J_ETERNALID="eternalId";
public static final String J_NAME="name";
public static final String J_ELE="ele";
public static final String J_QUALITY="quality";
public static final String J_SELLPRICE="sellPrice";
public static final String J_RARITY="rarity";
public static final String J_SKILLID="skillId";
public static final String J_ETERNALVAL="eternalVal";

public EternalTable(){
mapper=new DBRowMapper_Eternal();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.Eternal bean, String fname){
if(ETERNALID.equals(fname)){
return bean.getEternalId();
}
if(NAME.equals(fname)){
return bean.getName();
}
if(ELE.equals(fname)){
return bean.getEle();
}
if(QUALITY.equals(fname)){
return bean.getQuality();
}
if(SELLPRICE.equals(fname)){
return bean.getSellPrice();
}
if(RARITY.equals(fname)){
return bean.getRarity();
}
if(SKILLID.equals(fname)){
return bean.getSkillId();
}
if(ETERNALVAL.equals(fname)){
return bean.getEternalVal();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.Eternal.class;
}
public final static class DBRowMapper_Eternal implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.Eternal>{
@Override
public com.ks.db.cfg.Eternal rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.Eternal bean = new com.ks.db.cfg.Eternal();
bean.setEternalId(rs.getInt("eternal_id"));
bean.setName(rs.getString("name"));
bean.setEle(rs.getInt("ele"));
bean.setQuality(rs.getInt("quality"));
bean.setSellPrice(rs.getInt("sell_price"));
bean.setRarity(rs.getInt("rarity"));
bean.setSkillId(rs.getInt("skill_id"));
bean.setEternalVal(rs.getInt("eternal_val"));
return bean;
}
}
}
