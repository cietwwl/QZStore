package com.ks.logic.db_template;
public final class FriendApplyDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.FriendApply>{
public FriendApplyDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.FriendApply.class;
mapper = new com.ks.table.FriendApplyTable.DBRowMapper_FriendApply();
sqlMap.put("queryFriendApply","select * from t_friend_apply where `user_id`=? and `apply_user_id`=?");
sqlMap.put("queryFriendApplys","select * from t_friend_apply where `user_id`=?");
sqlMap.put("addFriendApply","insert t_friend_apply (`user_id`,`apply_user_id`,`create_time`) values (?,?,?)");
sqlMap.put("deleteFriendApply","delete from t_friend_apply where `user_id`=? and `apply_user_id`=?");
paramMethodMap.put("queryFriendApply", new DynamicSelect_queryFriendApply());
paramMethodMap.put("queryFriendApplys", new DynamicSelect_queryFriendApplys());
paramMethodMap.put("addFriendApply", new DynamicInsert_addFriendApply());
paramMethodMap.put("deleteFriendApply", new DynamicDelete_deleteFriendApply());
}
public final class DynamicSelect_queryFriendApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getApplyUserId());
return list;
}
}
public final class DynamicSelect_queryFriendApplys implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addFriendApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getApplyUserId());
list.add(bean.getCreateTime());
return list;
}
}
public final class DynamicDelete_deleteFriendApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getApplyUserId());
return list;
}
}
}