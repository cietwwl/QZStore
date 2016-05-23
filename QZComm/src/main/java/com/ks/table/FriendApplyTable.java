package com.ks.table;
public final class FriendApplyTable extends com.ks.access.DBBeanTable<com.ks.db.model.FriendApply>{
public static FriendApplyTable instance;
public static final String TABLE_NAME="t_friend_apply";
public static final String USERID="user_id";
public static final String APPLYUSERID="apply_user_id";
public static final String CREATETIME="create_time";

public static final String J_USERID="userId";
public static final String J_APPLYUSERID="applyUserId";
public static final String J_CREATETIME="createTime";

public FriendApplyTable(){
mapper=new DBRowMapper_FriendApply();
}
@Override
public Object getDBFieldValue(com.ks.db.model.FriendApply bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(APPLYUSERID.equals(fname)){
return bean.getApplyUserId();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.FriendApply.class;
}
public final static class DBRowMapper_FriendApply implements com.ks.access.mapper.RowMapper<com.ks.db.model.FriendApply>{
@Override
public com.ks.db.model.FriendApply rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.FriendApply bean = new com.ks.db.model.FriendApply();
bean.setUserId(rs.getInt("user_id"));
bean.setApplyUserId(rs.getInt("apply_user_id"));
bean.setCreateTime(rs.getTimestamp("create_time"));
return bean;
}
}
}
