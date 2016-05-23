package com.ks.table;
public final class UserBuffTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserBuff>{
public static UserBuffTable instance;
public static final String TABLE_NAME="t_user_buff";
public static final String USERID="user_id";
public static final String EFFECTID="effect_id";
public static final String VAL="val";
public static final String CD="cd";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_EFFECTID="effectId";
public static final String J_VAL="val";
public static final String J_CD="cd";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public UserBuffTable(){
mapper=new DBRowMapper_UserBuff();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserBuff bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(EFFECTID.equals(fname)){
return bean.getEffectId();
}
if(VAL.equals(fname)){
return bean.getVal();
}
if(CD.equals(fname)){
return bean.getCd();
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
return com.ks.db.model.UserBuff.class;
}
public final static class DBRowMapper_UserBuff implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserBuff>{
@Override
public com.ks.db.model.UserBuff rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserBuff bean = new com.ks.db.model.UserBuff();
bean.setUserId(rs.getInt("user_id"));
bean.setEffectId(rs.getInt("effect_id"));
bean.setVal(rs.getInt("val"));
bean.setCd(rs.getInt("cd"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
