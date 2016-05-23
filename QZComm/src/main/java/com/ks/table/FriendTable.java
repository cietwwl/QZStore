package com.ks.table;
public final class FriendTable extends com.ks.access.DBBeanTable<com.ks.db.model.Friend>{
public static FriendTable instance;
public static final String USERID="user_id";
public static final String FRIENDID="friend_id";
public static final String STATE="state";
public static final String USECOUNT="use_count";
public static final String FRIENDLYDEGREES="friendly_degrees";
public static final String LASTREFTIME="last_ref_time";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_FRIENDID="friendId";
public static final String J_STATE="state";
public static final String J_USECOUNT="useCount";
public static final String J_FRIENDLYDEGREES="friendlyDegrees";
public static final String J_LASTREFTIME="lastRefTime";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public FriendTable(){
mapper=new DBRowMapper_Friend();
}
@Override
public Object getDBFieldValue(com.ks.db.model.Friend bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(FRIENDID.equals(fname)){
return bean.getFriendId();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(USECOUNT.equals(fname)){
return bean.getUseCount();
}
if(FRIENDLYDEGREES.equals(fname)){
return bean.getFriendlyDegrees();
}
if(LASTREFTIME.equals(fname)){
return bean.getLastRefTime();
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
return com.ks.db.model.Friend.class;
}
public final static class DBRowMapper_Friend implements com.ks.access.mapper.RowMapper<com.ks.db.model.Friend>{
@Override
public com.ks.db.model.Friend rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.Friend bean = new com.ks.db.model.Friend();
bean.setUserId(rs.getInt("user_id"));
bean.setFriendId(rs.getInt("friend_id"));
bean.setState(rs.getInt("state"));
bean.setUseCount(rs.getInt("use_count"));
bean.setFriendlyDegrees(rs.getInt("friendly_degrees"));
bean.setLastRefTime(rs.getTimestamp("last_ref_time"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
