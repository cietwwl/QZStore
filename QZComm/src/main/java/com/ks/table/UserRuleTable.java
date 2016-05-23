package com.ks.table;
public final class UserRuleTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.UserRule>{
public static UserRuleTable instance;
public static final String TABLE_NAME="t_user_rule";
public static final String LEVEL="level";
public static final String NEXTEXP="next_exp";
public static final String COST="cost";
public static final String STAMINA="stamina";
public static final String EXPPOOL="exp_pool";
public static final String EQUIPMENTCAPACITY="equipment_capacity";
public static final String HEROCAPACITY="hero_capacity";
public static final String ETERNALCAPACITY="eternal_capacity";
public static final String ETERNALVAL="eternal_val";

public static final String J_LEVEL="level";
public static final String J_NEXTEXP="nextExp";
public static final String J_COST="cost";
public static final String J_STAMINA="stamina";
public static final String J_EXPPOOL="expPool";
public static final String J_EQUIPMENTCAPACITY="equipmentCapacity";
public static final String J_HEROCAPACITY="heroCapacity";
public static final String J_ETERNALCAPACITY="eternalCapacity";
public static final String J_ETERNALVAL="eternalVal";

public UserRuleTable(){
mapper=new DBRowMapper_UserRule();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.UserRule bean, String fname){
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(NEXTEXP.equals(fname)){
return bean.getNextExp();
}
if(COST.equals(fname)){
return bean.getCost();
}
if(STAMINA.equals(fname)){
return bean.getStamina();
}
if(EXPPOOL.equals(fname)){
return bean.getExpPool();
}
if(EQUIPMENTCAPACITY.equals(fname)){
return bean.getEquipmentCapacity();
}
if(HEROCAPACITY.equals(fname)){
return bean.getHeroCapacity();
}
if(ETERNALCAPACITY.equals(fname)){
return bean.getEternalCapacity();
}
if(ETERNALVAL.equals(fname)){
return bean.getEternalVal();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.cfg.UserRule.class;
}
public final static class DBRowMapper_UserRule implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.UserRule>{
@Override
public com.ks.db.cfg.UserRule rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.UserRule bean = new com.ks.db.cfg.UserRule();
bean.setLevel(rs.getInt("level"));
bean.setNextExp(rs.getInt("next_exp"));
bean.setCost(rs.getInt("cost"));
bean.setStamina(rs.getInt("stamina"));
bean.setExpPool(rs.getInt("exp_pool"));
bean.setEquipmentCapacity(rs.getInt("equipment_capacity"));
bean.setHeroCapacity(rs.getInt("hero_capacity"));
bean.setEternalCapacity(rs.getInt("eternal_capacity"));
bean.setEternalVal(rs.getInt("eternal_val"));
return bean;
}
}
}
