package com.ks.table;
public final class UserExploreTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserExplore>{
public static UserExploreTable instance;
public static final String TABLE_NAME="t_user_explore";
public static final String USERID="user_id";
public static final String EXPLOREID="explore_id";
public static final String USERHEROID="user_hero_id";
public static final String EXPLORETYPE="explore_type";
public static final String STATE="state";
public static final String ENDTIME="end_time";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_EXPLOREID="exploreId";
public static final String J_USERHEROID="userHeroId";
public static final String J_EXPLORETYPE="exploreType";
public static final String J_STATE="state";
public static final String J_ENDTIME="endTime";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public UserExploreTable(){
mapper=new DBRowMapper_UserExplore();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserExplore bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(EXPLOREID.equals(fname)){
return bean.getExploreId();
}
if(USERHEROID.equals(fname)){
return bean.getUserHeroId();
}
if(EXPLORETYPE.equals(fname)){
return bean.getExploreType();
}
if(STATE.equals(fname)){
return bean.getState();
}
if(ENDTIME.equals(fname)){
return bean.getEndTime();
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
return com.ks.db.model.UserExplore.class;
}
public final static class DBRowMapper_UserExplore implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserExplore>{
@Override
public com.ks.db.model.UserExplore rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserExplore bean = new com.ks.db.model.UserExplore();
bean.setUserId(rs.getInt("user_id"));
bean.setExploreId(rs.getInt("explore_id"));
bean.setUserHeroId(rs.getInt("user_hero_id"));
bean.setExploreType(rs.getInt("explore_type"));
bean.setState(rs.getInt("state"));
bean.setEndTime(rs.getTimestamp("end_time"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
