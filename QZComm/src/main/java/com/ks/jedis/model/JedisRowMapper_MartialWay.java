package com.ks.jedis.model;
public final class JedisRowMapper_MartialWay implements com.ks.cache.JedisRowMapper<com.ks.model.martial.MartialWay>{
@Override
public com.ks.model.martial.MartialWay rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.model.martial.MartialWay bean = new com.ks.model.martial.MartialWay();
bean.setUserId(jrs.getInt("userId"));
bean.setScore(jrs.getShort("score"));
bean.setWinCount(jrs.getShort("winCount"));
bean.setWinStreak(jrs.getShort("winStreak"));
bean.setLastWinTime(jrs.getDate("lastWinTime"));
return bean;}
}
