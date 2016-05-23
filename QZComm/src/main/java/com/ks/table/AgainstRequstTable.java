package com.ks.table;
public final class AgainstRequstTable extends com.ks.access.DBBeanTable<com.ks.db.model.AgainstRequst>{
public static AgainstRequstTable instance;
public static final String TABLE_NAME="t_against_requst";
public static final String USERID="user_id";
public static final String AGAINSTUSERID="against_user_id";
public static final String AGAINSTTYPE="against_type";
public static final String AGAINSTTIME="against_time";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_AGAINSTUSERID="againstUserId";
public static final String J_AGAINSTTYPE="againstType";
public static final String J_AGAINSTTIME="againstTime";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public AgainstRequstTable(){
mapper=new DBRowMapper_AgainstRequst();
}
@Override
public Object getDBFieldValue(com.ks.db.model.AgainstRequst bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(AGAINSTUSERID.equals(fname)){
return bean.getAgainstUserId();
}
if(AGAINSTTYPE.equals(fname)){
return bean.getAgainstType();
}
if(AGAINSTTIME.equals(fname)){
return bean.getAgainstTime();
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
return com.ks.db.model.AgainstRequst.class;
}
public final static class DBRowMapper_AgainstRequst implements com.ks.access.mapper.RowMapper<com.ks.db.model.AgainstRequst>{
@Override
public com.ks.db.model.AgainstRequst rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.AgainstRequst bean = new com.ks.db.model.AgainstRequst();
bean.setUserId(rs.getInt("user_id"));
bean.setAgainstUserId(rs.getInt("against_user_id"));
bean.setAgainstType(rs.getInt("against_type"));
bean.setAgainstTime(rs.getTimestamp("against_time"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
