package com.ks.jedis.model;
public final class JedisRowMapper_User implements com.ks.cache.JedisRowMapper<com.ks.db.model.User>{
@Override
public com.ks.db.model.User rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.User bean = new com.ks.db.model.User();
bean.setUserId(jrs.getInt("userId"));
bean.setUsername(jrs.getString("username"));
bean.setPartner(jrs.getInt("partner"));
bean.setPlayerName(jrs.getString("playerName"));
bean.setLevel(jrs.getInt("level"));
bean.setExp(jrs.getInt("exp"));
bean.setAddExpPool(jrs.getInt("addExpPool"));
bean.setStamina(jrs.getInt("stamina"));
bean.setGold(jrs.getInt("gold"));
bean.setDiamond(jrs.getInt("diamond"));
bean.setGp(jrs.getInt("gp"));
bean.setHeroCapacity(jrs.getInt("heroCapacity"));
bean.setFightId(jrs.getString("fightId"));
bean.setChargeDiamond(jrs.getInt("chargeDiamond"));
bean.setLastRegainStaminaTime(jrs.getDate("lastRegainStaminaTime"));
bean.setLastLoginTime(jrs.getDate("lastLoginTime"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
bean.setHeroExpPool(jrs.getInt("heroExpPool"));
bean.setEquipmentCapacity(jrs.getInt("equipmentCapacity"));
bean.setEternalCapacity(jrs.getInt("eternalCapacity"));
bean.setPlotStep(jrs.getInt("plotStep"));
bean.setGuideStep(jrs.getInt("guideStep"));
bean.setFunUnlock(jrs.getInt("funUnlock"));
bean.setSlate(jrs.getInt("slate"));
bean.setHeroSize(jrs.getInt("heroSize"));
bean.setEquipmentSize(jrs.getInt("equipmentSize"));
bean.setFame(jrs.getInt("fame"));
bean.setRenamed(jrs.getBoolean("renamed"));
bean.setOnline(jrs.getInt("online"));
bean.setFirstOnlineTime(jrs.getInt("firstOnlineTime"));
bean.setDailyOnlineTime(jrs.getInt("dailyOnlineTime"));
bean.setBanChatTime(jrs.getInt("banChatTime"));
bean.setBanLoginTime(jrs.getInt("banLoginTime"));
bean.setAccessTime(jrs.getInt("accessTime"));
bean.setFighting(jrs.getInt("fighting"));
bean.setVip(jrs.getInt("vip"));
return bean;}
}
