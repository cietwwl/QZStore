package com.ks.jedis.model;
public final class ObjectFieldMap_UserEquipment implements com.ks.cache.ObjectFieldMap<com.ks.db.model.UserEquipment>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.UserEquipment bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userEquipmentId",String.valueOf(bean.getUserEquipmentId()));
map.put("userId",String.valueOf(bean.getUserId()));
map.put("equipmentId",String.valueOf(bean.getEquipmentId()));
map.put("level",String.valueOf(bean.getLevel()));
map.put("userHeroId",String.valueOf(bean.getUserHeroId()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
map.put("skills",String.valueOf(bean.getSkills()));
map.put("addAtk",String.valueOf(bean.getAddAtk()));
map.put("update",String.valueOf(bean.isUpdate()));
return map;
}
}
