package com.ks.jedis.model;
public final class ObjectFieldMap_User implements com.ks.cache.ObjectFieldMap<com.ks.db.model.User>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.User bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userId",String.valueOf(bean.getUserId()));
map.put("username",String.valueOf(bean.getUsername()));
map.put("partner",String.valueOf(bean.getPartner()));
map.put("playerName",String.valueOf(bean.getPlayerName()));
map.put("level",String.valueOf(bean.getLevel()));
map.put("exp",String.valueOf(bean.getExp()));
map.put("stamina",String.valueOf(bean.getStamina()));
map.put("gold",String.valueOf(bean.getGold()));
map.put("diamond",String.valueOf(bean.getDiamond()));
map.put("gp",String.valueOf(bean.getGp()));
map.put("fightId",String.valueOf(bean.getFightId()));
map.put("chargeDiamond",String.valueOf(bean.getChargeDiamond()));
map.put("lastRegainStaminaTime",String.valueOf(bean.getLastRegainStaminaTime().getTime()));
map.put("lastLoginTime",String.valueOf(bean.getLastLoginTime().getTime()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
map.put("plotStep",String.valueOf(bean.getPlotStep()));
map.put("slate",String.valueOf(bean.getSlate()));
map.put("fame",String.valueOf(bean.getFame()));
map.put("renamed",String.valueOf(bean.isRenamed()));
map.put("online",String.valueOf(bean.getOnline()));
map.put("firstOnlineTime",String.valueOf(bean.getFirstOnlineTime()));
map.put("dailyOnlineTime",String.valueOf(bean.getDailyOnlineTime()));
map.put("banChatTime",String.valueOf(bean.getBanChatTime()));
map.put("banLoginTime",String.valueOf(bean.getBanLoginTime()));
map.put("accessTime",String.valueOf(bean.getAccessTime()));
map.put("fighting",String.valueOf(bean.getFighting()));
map.put("vip",String.valueOf(bean.getVip()));
map.put("heroCapacity",String.valueOf(bean.getHeroCapacity()));
map.put("equipmentCapacity",String.valueOf(bean.getEquipmentCapacity()));
map.put("eternalCapacity",String.valueOf(bean.getEternalCapacity()));
map.put("heroExpPool",String.valueOf(bean.getHeroExpPool()));
map.put("addExpPool",String.valueOf(bean.getAddExpPool()));
map.put("smeltingExp",String.valueOf(bean.getSmeltingExp()));
map.put("addSmeltingVal",String.valueOf(bean.getAddSmeltingVal()));
map.put("guideStep",String.valueOf(bean.getGuideStep()));
map.put("funUnlock",String.valueOf(bean.getFunUnlock()));
map.put("propSize",String.valueOf(bean.getPropSize()));
map.put("eternalSize",String.valueOf(bean.getEternalSize()));
map.put("heroSize",String.valueOf(bean.getHeroSize()));
map.put("equipmentSize",String.valueOf(bean.getEquipmentSize()));
return map;
}
}
