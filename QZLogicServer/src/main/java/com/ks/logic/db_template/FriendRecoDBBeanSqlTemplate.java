package com.ks.logic.db_template;
public final class FriendRecoDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.FriendReco>{
public FriendRecoDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.FriendReco.class;
mapper = new com.ks.table.FriendRecoTable.DBRowMapper_FriendReco();
sqlMap.put("updateFriendReco","update t_friend_reco set `user_id`=?,`reco_friends`=?,`create_time`=?,`update_time`=? where `user_id`=?");
sqlMap.put("addFriendReco","insert t_friend_reco (`user_id`,`reco_friends`,`create_time`,`update_time`) values (?,?,?,?)");
sqlMap.put("queryFriendReco","select * from t_friend_reco where `user_id`=?");
paramMethodMap.put("updateFriendReco", new DynamicUpdata_updateFriendReco());
paramMethodMap.put("addFriendReco", new DynamicInsert_addFriendReco());
paramMethodMap.put("queryFriendReco", new DynamicSelect_queryFriendReco());
}
public final class DynamicUpdata_updateFriendReco implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendReco>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendReco bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getRecoFriends());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addFriendReco implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendReco>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendReco bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getRecoFriends());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryFriendReco implements com.ks.access.DBBeanParamMethod<com.ks.db.model.FriendReco>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.FriendReco bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
}