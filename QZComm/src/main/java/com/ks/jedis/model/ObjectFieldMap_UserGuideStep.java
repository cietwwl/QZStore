package com.ks.jedis.model;
public final class ObjectFieldMap_UserGuideStep implements com.ks.cache.ObjectFieldMap<com.ks.db.model.UserGuideStep>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.UserGuideStep bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("id",String.valueOf(bean.getId()));
map.put("guideIds",String.valueOf(bean.getGuideIds()));
map.put("createTime",String.valueOf(bean.getCreateTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime()));
return map;
}
}
