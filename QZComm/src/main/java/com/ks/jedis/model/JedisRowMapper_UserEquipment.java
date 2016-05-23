package com.ks.jedis.model;
public final class JedisRowMapper_UserEquipment implements com.ks.cache.JedisRowMapper<com.ks.db.model.UserEquipment>{
@Override
public com.ks.db.model.UserEquipment rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.UserEquipment bean = new com.ks.db.model.UserEquipment();
bean.setUserEquipmentId(jrs.getInt("userEquipmentId"));
bean.setUserId(jrs.getInt("userId"));
bean.setEquipmentId(jrs.getInt("equipmentId"));
bean.setLevel(jrs.getInt("level"));
bean.setUserHeroId(jrs.getInt("userHeroId"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
bean.setSkills(jrs.getString("skills"));
bean.setAddAtk(jrs.getDouble("addAtk"));
bean.setUpdate(jrs.getBoolean("update"));
return bean;}
}
