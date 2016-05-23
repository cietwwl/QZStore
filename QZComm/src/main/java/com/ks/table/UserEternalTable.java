package com.ks.table;
public final class UserEternalTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserEternal>{
public static UserEternalTable instance;
public static final String TABLE_NAME_PREFIX="t_user_eternal_";
public static final String USERETERNALID="user_eternal_id";
public static final String USERID="user_id";
public static final String ETERNALID="eternal_id";
public static final String USE="use";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";
public static final String PROPERTYSKILLS="property_skill";

public static final String J_USERETERNALID="userEternalId";
public static final String J_USERID="userId";
public static final String J_ETERNALID="eternalId";
public static final String J_USE="use";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";
public static final String J_PROPERTYSKILLS="propertySkills";

public static String getTableName(int index){return TABLE_NAME_PREFIX + (index % 10);}
public UserEternalTable(){
mapper=new DBRowMapper_UserEternal();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserEternal bean, String fname){
if(USERETERNALID.equals(fname)){
return bean.getUserEternalId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(ETERNALID.equals(fname)){
return bean.getEternalId();
}
if(USE.equals(fname)){
return bean.isUse();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
if(PROPERTYSKILLS.equals(fname)){
return bean.getPropertySkills();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserEternal.class;
}
public final static class DBRowMapper_UserEternal implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserEternal>{
@Override
public com.ks.db.model.UserEternal rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserEternal bean = new com.ks.db.model.UserEternal();
bean.setUserEternalId(rs.getInt("user_eternal_id"));
bean.setUserId(rs.getInt("user_id"));
bean.setEternalId(rs.getInt("eternal_id"));
bean.setUse(rs.getBoolean("use"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
bean.setPropertySkills(rs.getString("property_skill"));
return bean;
}
}
}
