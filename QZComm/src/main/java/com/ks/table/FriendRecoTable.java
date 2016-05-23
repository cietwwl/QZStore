package com.ks.table;
public final class FriendRecoTable extends com.ks.access.DBBeanTable<com.ks.db.model.FriendReco>{
public static FriendRecoTable instance;
public static final String TABLE_NAME="t_friend_reco";
public static final String USERID="user_id";
public static final String RECOFRIENDS="reco_friends";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_RECOFRIENDS="recoFriends";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public FriendRecoTable(){
mapper=new DBRowMapper_FriendReco();
}
@Override
public Object getDBFieldValue(com.ks.db.model.FriendReco bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(RECOFRIENDS.equals(fname)){
return bean.getRecoFriends();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.FriendReco.class;
}
public final static class DBRowMapper_FriendReco implements com.ks.access.mapper.RowMapper<com.ks.db.model.FriendReco>{
@Override
public com.ks.db.model.FriendReco rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.FriendReco bean = new com.ks.db.model.FriendReco();
bean.setUserId(rs.getInt("user_id"));
bean.setRecoFriends(rs.getString("reco_friends"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
