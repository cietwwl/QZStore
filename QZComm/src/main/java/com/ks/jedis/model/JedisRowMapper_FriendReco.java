package com.ks.jedis.model;
public final class JedisRowMapper_FriendReco implements com.ks.cache.JedisRowMapper<com.ks.db.model.FriendReco>{
@Override
public com.ks.db.model.FriendReco rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.FriendReco bean = new com.ks.db.model.FriendReco();
bean.setUserId(jrs.getInt("userId"));
bean.setRecoFriends(jrs.getString("recoFriends"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
return bean;}
}
