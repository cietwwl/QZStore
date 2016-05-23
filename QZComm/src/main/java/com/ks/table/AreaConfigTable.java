package com.ks.table;
public final class AreaConfigTable extends com.ks.access.DBBeanTable<com.ks.db.model.AreaConfig>{
public static AreaConfigTable instance;
public static final String TABLE_NAME="t_area_config";
public static final String ID="id";
public static final String VALUE="value";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_ID="id";
public static final String J_VALUE="value";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public AreaConfigTable(){
mapper=new DBRowMapper_AreaConfig();
}
@Override
public Object getDBFieldValue(com.ks.db.model.AreaConfig bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(VALUE.equals(fname)){
return bean.getValue();
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
return com.ks.db.model.AreaConfig.class;
}
public final static class DBRowMapper_AreaConfig implements com.ks.access.mapper.RowMapper<com.ks.db.model.AreaConfig>{
@Override
public com.ks.db.model.AreaConfig rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.AreaConfig bean = new com.ks.db.model.AreaConfig();
bean.setId(rs.getInt("id"));
bean.setValue(rs.getInt("value"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
