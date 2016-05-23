package com.ks.jedis.model;
public final class ObjectFieldMap_UserProp implements com.ks.cache.ObjectFieldMap<com.ks.db.model.UserProp>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.UserProp bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("id",String.valueOf(bean.getId()));
map.put("userId",String.valueOf(bean.getUserId()));
map.put("propId",String.valueOf(bean.getPropId()));
map.put("num",String.valueOf(bean.getNum()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
map.put("update",String.valueOf(bean.isUpdate()));
return map;
}
}
