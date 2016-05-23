package com.ks.table;
public final class UserRecordTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserRecord>{
public static UserRecordTable instance;
public static final String TABLE_NAME="t_user_record";
public static final String ID="id";
public static final String SYSMAILIDS="sysMailIds";
public static final String COMMONREWARDS="commonRewards";
public static final String FIRSTRECHARGES="firstRecharges";
public static final String TRIALSIDS="trialsIds";

public static final String J_ID="id";
public static final String J_SYSMAILIDS="sysMailIds";
public static final String J_COMMONREWARDS="commonRewards";
public static final String J_FIRSTRECHARGES="firstRecharges";
public static final String J_TRIALSIDS="trialsIds";

public UserRecordTable(){
mapper=new DBRowMapper_UserRecord();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserRecord bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(SYSMAILIDS.equals(fname)){
return bean.getSysMailIds();
}
if(COMMONREWARDS.equals(fname)){
return bean.getCommonRewards();
}
if(FIRSTRECHARGES.equals(fname)){
return bean.getFirstRecharges();
}
if(TRIALSIDS.equals(fname)){
return bean.getTrialsIds();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserRecord.class;
}
public final static class DBRowMapper_UserRecord implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserRecord>{
@Override
public com.ks.db.model.UserRecord rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserRecord bean = new com.ks.db.model.UserRecord();
bean.setId(rs.getInt("id"));
bean.setSysMailIds(rs.getString("sysMailIds"));
bean.setCommonRewards(rs.getString("commonRewards"));
bean.setFirstRecharges(rs.getString("firstRecharges"));
bean.setTrialsIds(rs.getString("trialsIds"));
return bean;
}
}
}
