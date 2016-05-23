package com.ks.jedis.model;
public final class JedisRowMapper_UserBaseinfo implements com.ks.cache.JedisRowMapper<com.ks.model.user.UserBaseinfo>{
@Override
public com.ks.model.user.UserBaseinfo rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.model.user.UserBaseinfo bean = new com.ks.model.user.UserBaseinfo();
bean.setUserId(jrs.getInt("userId"));
bean.setLevel(jrs.getInt("level"));
bean.setPlayerName(jrs.getString("playerName"));
bean.setHeroId(jrs.getInt("heroId"));
bean.setTodayWins(jrs.getInt("todayWins"));
bean.setTodayMaxWins(jrs.getInt("todayMaxWins"));
bean.setFighting(jrs.getInt("fighting"));
bean.setStreakWin(jrs.getInt("streakWin"));
bean.setChargeDiamond(jrs.getInt("chargeDiamond"));
bean.setOnline(jrs.getBoolean("online"));
bean.setGuildName(jrs.getString("guildName"));
return bean;}
}
