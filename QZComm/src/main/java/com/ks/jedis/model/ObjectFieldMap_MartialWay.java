package com.ks.jedis.model;
public final class ObjectFieldMap_MartialWay implements com.ks.cache.ObjectFieldMap<com.ks.model.martial.MartialWay>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.model.martial.MartialWay bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userId",String.valueOf(bean.getUserId()));
map.put("score",String.valueOf(bean.getScore()));
map.put("winCount",String.valueOf(bean.getWinCount()));
map.put("winStreak",String.valueOf(bean.getWinStreak()));
map.put("lastWinTime",String.valueOf(bean.getLastWinTime().getTime()));
return map;
}
}
