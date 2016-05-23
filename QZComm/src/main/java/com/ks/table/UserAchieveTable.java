package com.ks.table;
public final class UserAchieveTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserAchieve>{
public static UserAchieveTable instance;
public static final String USERID="user_id";
public static final String ACHIEVEID="achieve_id";
public static final String ACHIEVETYPE="achieve_type";
public static final String ASSID="ass_id";
public static final String NUM="num";
public static final String STATE="state";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_ACHIEVEID="achieveId";
public static final String J_ACHIEVETYPE="achieveType";
public static final String J_ASSID="assId";
public static final String J_NUM="num";
public static final String J_STATE="state";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public UserAchieveTable(){
mapper=new DBRowMapper_UserAchieve();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserAchieve bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(ACHIEVEID.equals(fname)){
return bean.getAchieveId();
}
if(ACHIEVETYPE.equals(fname)){
return bean.getAchieveType();
}
if(ASSID.equals(fname)){
return bean.getAssId();
}
if(NUM.equals(fname)){
return bean.getNum();
}
if(STATE.equals(fname)){
return bean.getState();
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
return com.ks.db.model.UserAchieve.class;
}
public final static class DBRowMapper_UserAchieve implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserAchieve>{
@Override
public com.ks.db.model.UserAchieve rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserAchieve bean = new com.ks.db.model.UserAchieve();
bean.setUserId(rs.getInt("user_id"));
bean.setAchieveId(rs.getInt("achieve_id"));
bean.setAchieveType(rs.getInt("achieve_type"));
bean.setAssId(rs.getInt("ass_id"));
bean.setNum(rs.getInt("num"));
bean.setState(rs.getInt("state"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
