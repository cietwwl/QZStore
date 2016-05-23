package com.ks.jedis.model;
public final class ObjectFieldMap_UserBaseinfo implements com.ks.cache.ObjectFieldMap<com.ks.model.user.UserBaseinfo>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.model.user.UserBaseinfo bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userId",String.valueOf(bean.getUserId()));
map.put("level",String.valueOf(bean.getLevel()));
map.put("playerName",String.valueOf(bean.getPlayerName()));
map.put("heroId",String.valueOf(bean.getHeroId()));
map.put("todayWins",String.valueOf(bean.getTodayWins()));
map.put("todayMaxWins",String.valueOf(bean.getTodayMaxWins()));
map.put("fighting",String.valueOf(bean.getFighting()));
map.put("streakWin",String.valueOf(bean.getStreakWin()));
map.put("chargeDiamond",String.valueOf(bean.getChargeDiamond()));
map.put("online",String.valueOf(bean.isOnline()));
map.put("guildName",String.valueOf(bean.getGuildName()));
return map;
}
}
