package com.ks.table;
public final class EternalSmeltingTable extends com.ks.access.DBBeanTable<com.ks.db.cfg.EternalSmelting>{
public static EternalSmeltingTable instance;
public static final String TABLE_NAME="t_eternal_smelting";
public static final String USERID="user_id";
public static final String TYPE="type";
public static final String VAL="val";
public static final String ADDETERNALVAL="addEternalVal";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_TYPE="type";
public static final String J_VAL="val";
public static final String J_ADDETERNALVAL="addEternalVal";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public EternalSmeltingTable(){
mapper=new DBRowMapper_EternalSmelting();
}
@Override
public Object getDBFieldValue(com.ks.db.cfg.EternalSmelting bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(TYPE.equals(fname)){
return bean.getType();
}
if(VAL.equals(fname)){
return bean.getVal();
}
if(ADDETERNALVAL.equals(fname)){
return bean.getAddEternalVal();
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
return com.ks.db.cfg.EternalSmelting.class;
}
public final static class DBRowMapper_EternalSmelting implements com.ks.access.mapper.RowMapper<com.ks.db.cfg.EternalSmelting>{
@Override
public com.ks.db.cfg.EternalSmelting rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.cfg.EternalSmelting bean = new com.ks.db.cfg.EternalSmelting();
bean.setUserId(rs.getInt("user_id"));
bean.setType(rs.getInt("type"));
bean.setVal(rs.getInt("val"));
bean.setAddEternalVal(rs.getInt("addEternalVal"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
