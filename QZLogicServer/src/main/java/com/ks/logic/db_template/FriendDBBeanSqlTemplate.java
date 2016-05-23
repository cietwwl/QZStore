package com.ks.logic.db_template;
public final class FriendDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.Friend>{
public FriendDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.Friend.class;
mapper = new com.ks.table.FriendTable.DBRowMapper_Friend();
sqlMap.put("updateFriend","update $tablename set `user_id`=?,`friend_id`=?,`state`=?,`use_count`=?,`friendly_degrees`=?,`last_ref_time`=?,`create_time`=?,`update_time`=? where `user_id`=? and `friend_id`=?");
sqlMap.put("queryFriends","select * from $tablename where `user_id`=?");
sqlMap.put("deleteFriend","delete from $tablename where `user_id`=? and `friend_id`=?");
sqlMap.put("addFriend","insert $tablename (`user_id`,`friend_id`,`state`,`use_count`,`friendly_degrees`,`last_ref_time`,`create_time`,`update_time`) values (?,?,?,?,?,?,?,?)");
paramMethodMap.put("updateFriend", new DynamicUpdata_updateFriend());
paramMethodMap.put("queryFriends", new DynamicSelect_queryFriends());
paramMethodMap.put("deleteFriend", new DynamicDelete_deleteFriend());
paramMethodMap.put("addFriend", new DynamicInsert_addFriend());
}
public final class DynamicUpdata_updateFriend implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Friend>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Friend bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getFriendId());
list.add(bean.getState());
list.add(bean.getUseCount());
list.add(bean.getFriendlyDegrees());
list.add(bean.getLastRefTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getFriendId());
return list;
}
}
public final class DynamicSelect_queryFriends implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Friend>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Friend bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicDelete_deleteFriend implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Friend>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Friend bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getFriendId());
return list;
}
}
public final class DynamicInsert_addFriend implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Friend>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Friend bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getFriendId());
list.add(bean.getState());
list.add(bean.getUseCount());
list.add(bean.getFriendlyDegrees());
list.add(bean.getLastRefTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
}