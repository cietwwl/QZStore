package com.ks.jedis.model;
public final class ObjectFieldMap_FriendReco implements com.ks.cache.ObjectFieldMap<com.ks.db.model.FriendReco>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.FriendReco bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userId",String.valueOf(bean.getUserId()));
map.put("recoFriends",String.valueOf(bean.getRecoFriends()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
return map;
}
}
