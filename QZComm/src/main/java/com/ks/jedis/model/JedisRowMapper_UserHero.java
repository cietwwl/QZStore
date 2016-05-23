package com.ks.jedis.model;
public final class JedisRowMapper_UserHero implements com.ks.cache.JedisRowMapper<com.ks.db.model.UserHero>{
@Override
public com.ks.db.model.UserHero rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.UserHero bean = new com.ks.db.model.UserHero();
bean.setId(jrs.getInt("id"));
bean.setUserId(jrs.getInt("userId"));
bean.setHeroId(jrs.getInt("heroId"));
bean.setLevel(jrs.getInt("level"));
bean.setExp(jrs.getInt("exp"));
bean.setEleLevel(jrs.getInt("eleLevel"));
bean.setState(jrs.getInt("state"));
bean.setSkillLevel(jrs.getInt("skillLevel"));
bean.setCapSkillLevel(jrs.getInt("capSkillLevel"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
bean.setUpdate(jrs.getBoolean("update"));
bean.setEternal(jrs.getInt("eternal"));
bean.setBreakLevel(jrs.getInt("breakLevel"));
bean.setBreakedSlots(jrs.getString("breakedSlots"));
return bean;}
}
