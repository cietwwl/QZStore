package com.ks.jedis.model;
public final class ObjectFieldMap_UserHero implements com.ks.cache.ObjectFieldMap<com.ks.db.model.UserHero>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.UserHero bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("id",String.valueOf(bean.getId()));
map.put("userId",String.valueOf(bean.getUserId()));
map.put("heroId",String.valueOf(bean.getHeroId()));
map.put("level",String.valueOf(bean.getLevel()));
map.put("exp",String.valueOf(bean.getExp()));
map.put("eleLevel",String.valueOf(bean.getEleLevel()));
map.put("state",String.valueOf(bean.getState()));
map.put("skillLevel",String.valueOf(bean.getSkillLevel()));
map.put("capSkillLevel",String.valueOf(bean.getCapSkillLevel()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
map.put("update",String.valueOf(bean.isUpdate()));
map.put("eternal",String.valueOf(bean.getEternal()));
map.put("breakLevel",String.valueOf(bean.getBreakLevel()));
map.put("breakedSlots",String.valueOf(bean.getBreakedSlots()));
return map;
}
}
