package com.ks.table;
public final class UserPropTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserProp>{
public static UserPropTable instance;
public static final String TABLE_NAME_PREFIX="t_user_prop_";
public static final String ID="id";
public static final String USERID="user_id";
public static final String PROPID="prop_id";
public static final String NUM="num";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_ID="id";
public static final String J_USERID="userId";
public static final String J_PROPID="propId";
public static final String J_NUM="num";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public static String getTableName(int index){return TABLE_NAME_PREFIX + (index % 10);}
public UserPropTable(){
mapper=new DBRowMapper_UserProp();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserProp bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(USERID.equals(fname)){
return bean.getUserId();
}
if(PROPID.equals(fname)){
return bean.getPropId();
}
if(NUM.equals(fname)){
return bean.getNum();
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
return com.ks.db.model.UserProp.class;
}
public final static class DBRowMapper_UserProp implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserProp>{
@Override
public com.ks.db.model.UserProp rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserProp bean = new com.ks.db.model.UserProp();
bean.setId(rs.getInt("id"));
bean.setUserId(rs.getInt("user_id"));
bean.setPropId(rs.getInt("prop_id"));
bean.setNum(rs.getInt("num"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
