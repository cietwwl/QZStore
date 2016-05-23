package com.ks.jedis.model;
public final class ObjectFieldMap_UserTeam implements com.ks.cache.ObjectFieldMap<com.ks.db.model.UserTeam>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.UserTeam bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userId",String.valueOf(bean.getUserId()));
map.put("heros",String.valueOf(bean.getHeros()));
map.put("pos",String.valueOf(bean.getPos()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
return map;
}
}
