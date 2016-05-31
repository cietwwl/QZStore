package com.ks.table;
public final class UserTable extends com.ks.access.DBBeanTable<com.ks.db.model.User>{
public static UserTable instance;
public static final String TABLE_NAME="t_user";
public static final String USERID="user_id";
public static final String USERNAME="username";
public static final String PARTNER="partner";
public static final String PLAYERNAME="player_name";
public static final String LEVEL="level";
public static final String EXP="exp";
public static final String STAMINA="stamina";
public static final String GOLD="gold";
public static final String DIAMOND="diamond";
public static final String GP="gp";
public static final String FIGHTID="fight_id";
public static final String CHARGEDIAMOND="charge_diamond";
public static final String LASTREGAINSTAMINATIME="last_regain_stamina_time";
public static final String LASTLOGINTIME="last_login_time";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";
public static final String PLOTSTEP="plot_step";
public static final String SLATE="slate";
public static final String FAME="fame";
public static final String RENAMED="renamed";
public static final String ONLINE="online";
public static final String FIRSTONLINETIME="firstOnlineTime";
public static final String DAILYONLINETIME="dailyOnlineTime";
public static final String BANCHATTIME="banChatTime";
public static final String BANLOGINTIME="banLoginTime";
public static final String ACCESSTIME="accessTime";
public static final String FIGHTING="fighting";
public static final String VIP="vip";
public static final String HEROCAPACITY="hero_capacity";
public static final String EQUIPMENTCAPACITY="equipment_capacity";
public static final String ETERNALCAPACITY="eternal_capacity";
public static final String HEROEXPPOOL="hero_exp_pool";
public static final String ADDEXPPOOL="add_exp_pool";
public static final String SMELTINGEXP="smelting_exp";
public static final String ADDSMELTINGVAL="add_smelting_val";
public static final String GUIDESTEP="guide_step";
public static final String FUNUNLOCK="fun_unlock";

public static final String J_USERID="userId";
public static final String J_USERNAME="username";
public static final String J_PARTNER="partner";
public static final String J_PLAYERNAME="playerName";
public static final String J_LEVEL="level";
public static final String J_EXP="exp";
public static final String J_STAMINA="stamina";
public static final String J_GOLD="gold";
public static final String J_DIAMOND="diamond";
public static final String J_GP="gp";
public static final String J_FIGHTID="fightId";
public static final String J_CHARGEDIAMOND="chargeDiamond";
public static final String J_LASTREGAINSTAMINATIME="lastRegainStaminaTime";
public static final String J_LASTLOGINTIME="lastLoginTime";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";
public static final String J_PLOTSTEP="plotStep";
public static final String J_SLATE="slate";
public static final String J_FAME="fame";
public static final String J_RENAMED="renamed";
public static final String J_ONLINE="online";
public static final String J_FIRSTONLINETIME="firstOnlineTime";
public static final String J_DAILYONLINETIME="dailyOnlineTime";
public static final String J_BANCHATTIME="banChatTime";
public static final String J_BANLOGINTIME="banLoginTime";
public static final String J_ACCESSTIME="accessTime";
public static final String J_FIGHTING="fighting";
public static final String J_VIP="vip";
public static final String J_HEROCAPACITY="heroCapacity";
public static final String J_EQUIPMENTCAPACITY="equipmentCapacity";
public static final String J_ETERNALCAPACITY="eternalCapacity";
public static final String J_HEROEXPPOOL="heroExpPool";
public static final String J_ADDEXPPOOL="addExpPool";
public static final String J_SMELTINGEXP="smeltingExp";
public static final String J_ADDSMELTINGVAL="addSmeltingVal";
public static final String J_GUIDESTEP="guideStep";
public static final String J_FUNUNLOCK="funUnlock";

public UserTable(){
mapper=new DBRowMapper_User();
}
@Override
public Object getDBFieldValue(com.ks.db.model.User bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(USERNAME.equals(fname)){
return bean.getUsername();
}
if(PARTNER.equals(fname)){
return bean.getPartner();
}
if(PLAYERNAME.equals(fname)){
return bean.getPlayerName();
}
if(LEVEL.equals(fname)){
return bean.getLevel();
}
if(EXP.equals(fname)){
return bean.getExp();
}
if(STAMINA.equals(fname)){
return bean.getStamina();
}
if(GOLD.equals(fname)){
return bean.getGold();
}
if(DIAMOND.equals(fname)){
return bean.getDiamond();
}
if(GP.equals(fname)){
return bean.getGp();
}
if(FIGHTID.equals(fname)){
return bean.getFightId();
}
if(CHARGEDIAMOND.equals(fname)){
return bean.getChargeDiamond();
}
if(LASTREGAINSTAMINATIME.equals(fname)){
return bean.getLastRegainStaminaTime();
}
if(LASTLOGINTIME.equals(fname)){
return bean.getLastLoginTime();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
if(PLOTSTEP.equals(fname)){
return bean.getPlotStep();
}
if(SLATE.equals(fname)){
return bean.getSlate();
}
if(FAME.equals(fname)){
return bean.getFame();
}
if(RENAMED.equals(fname)){
return bean.isRenamed();
}
if(ONLINE.equals(fname)){
return bean.getOnline();
}
if(FIRSTONLINETIME.equals(fname)){
return bean.getFirstOnlineTime();
}
if(DAILYONLINETIME.equals(fname)){
return bean.getDailyOnlineTime();
}
if(BANCHATTIME.equals(fname)){
return bean.getBanChatTime();
}
if(BANLOGINTIME.equals(fname)){
return bean.getBanLoginTime();
}
if(ACCESSTIME.equals(fname)){
return bean.getAccessTime();
}
if(FIGHTING.equals(fname)){
return bean.getFighting();
}
if(VIP.equals(fname)){
return bean.getVip();
}
if(HEROCAPACITY.equals(fname)){
return bean.getHeroCapacity();
}
if(EQUIPMENTCAPACITY.equals(fname)){
return bean.getEquipmentCapacity();
}
if(ETERNALCAPACITY.equals(fname)){
return bean.getEternalCapacity();
}
if(HEROEXPPOOL.equals(fname)){
return bean.getHeroExpPool();
}
if(ADDEXPPOOL.equals(fname)){
return bean.getAddExpPool();
}
if(SMELTINGEXP.equals(fname)){
return bean.getSmeltingExp();
}
if(ADDSMELTINGVAL.equals(fname)){
return bean.getAddSmeltingVal();
}
if(GUIDESTEP.equals(fname)){
return bean.getGuideStep();
}
if(FUNUNLOCK.equals(fname)){
return bean.getFunUnlock();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.User.class;
}
public final static class DBRowMapper_User implements com.ks.access.mapper.RowMapper<com.ks.db.model.User>{
@Override
public com.ks.db.model.User rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.User bean = new com.ks.db.model.User();
bean.setUserId(rs.getInt("user_id"));
bean.setUsername(rs.getString("username"));
bean.setPartner(rs.getInt("partner"));
bean.setPlayerName(rs.getString("player_name"));
bean.setLevel(rs.getInt("level"));
bean.setExp(rs.getInt("exp"));
bean.setStamina(rs.getInt("stamina"));
bean.setGold(rs.getInt("gold"));
bean.setDiamond(rs.getInt("diamond"));
bean.setGp(rs.getInt("gp"));
bean.setFightId(rs.getString("fight_id"));
bean.setChargeDiamond(rs.getInt("charge_diamond"));
bean.setLastRegainStaminaTime(rs.getTimestamp("last_regain_stamina_time"));
bean.setLastLoginTime(rs.getTimestamp("last_login_time"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
bean.setPlotStep(rs.getInt("plot_step"));
bean.setSlate(rs.getInt("slate"));
bean.setFame(rs.getInt("fame"));
bean.setRenamed(rs.getBoolean("renamed"));
bean.setOnline(rs.getInt("online"));
bean.setFirstOnlineTime(rs.getInt("firstOnlineTime"));
bean.setDailyOnlineTime(rs.getInt("dailyOnlineTime"));
bean.setBanChatTime(rs.getInt("banChatTime"));
bean.setBanLoginTime(rs.getInt("banLoginTime"));
bean.setAccessTime(rs.getInt("accessTime"));
bean.setFighting(rs.getInt("fighting"));
bean.setVip(rs.getInt("vip"));
bean.setHeroCapacity(rs.getInt("hero_capacity"));
bean.setEquipmentCapacity(rs.getInt("equipment_capacity"));
bean.setEternalCapacity(rs.getInt("eternal_capacity"));
bean.setHeroExpPool(rs.getInt("hero_exp_pool"));
bean.setAddExpPool(rs.getInt("add_exp_pool"));
bean.setSmeltingExp(rs.getInt("smelting_exp"));
bean.setAddSmeltingVal(rs.getInt("add_smelting_val"));
bean.setGuideStep(rs.getInt("guide_step"));
bean.setFunUnlock(rs.getInt("fun_unlock"));
return bean;
}
}
}
