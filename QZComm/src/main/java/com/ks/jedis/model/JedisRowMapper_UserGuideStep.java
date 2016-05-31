package com.ks.jedis.model;
public final class JedisRowMapper_UserGuideStep implements com.ks.cache.JedisRowMapper<com.ks.db.model.UserGuideStep>{
@Override
public com.ks.db.model.UserGuideStep rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.UserGuideStep bean = new com.ks.db.model.UserGuideStep();
bean.setId(jrs.getInt("id"));
bean.setGuideIds(jrs.getString("guideIds"));
bean.setCreateTime(jrs.getInt("createTime"));
bean.setUpdateTime(jrs.getInt("updateTime"));
return bean;}
}
