package com.ks.jedis.model;
public final class JedisRowMapper_UserTeam implements com.ks.cache.JedisRowMapper<com.ks.db.model.UserTeam>{
@Override
public com.ks.db.model.UserTeam rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.UserTeam bean = new com.ks.db.model.UserTeam();
bean.setUserId(jrs.getInt("userId"));
bean.setHeros(jrs.getString("heros"));
bean.setPos(jrs.getString("pos"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
return bean;}
}
