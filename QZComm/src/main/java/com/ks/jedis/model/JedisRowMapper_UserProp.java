package com.ks.jedis.model;
public final class JedisRowMapper_UserProp implements com.ks.cache.JedisRowMapper<com.ks.db.model.UserProp>{
@Override
public com.ks.db.model.UserProp rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.UserProp bean = new com.ks.db.model.UserProp();
bean.setId(jrs.getInt("id"));
bean.setUserId(jrs.getInt("userId"));
bean.setPropId(jrs.getInt("propId"));
bean.setNum(jrs.getInt("num"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
bean.setUpdate(jrs.getBoolean("update"));
return bean;}
}
