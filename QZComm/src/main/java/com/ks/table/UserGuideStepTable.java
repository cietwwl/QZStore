package com.ks.table;
public final class UserGuideStepTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserGuideStep>{
public static UserGuideStepTable instance;
public static final String TABLE_NAME="t_user_guide_step";
public static final String ID="id";
public static final String GUIDEIDS="guide_ids";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_ID="id";
public static final String J_GUIDEIDS="guideIds";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public UserGuideStepTable(){
mapper=new DBRowMapper_UserGuideStep();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserGuideStep bean, String fname){
if(ID.equals(fname)){
return bean.getId();
}
if(GUIDEIDS.equals(fname)){
return bean.getGuideIds();
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
return com.ks.db.model.UserGuideStep.class;
}
public final static class DBRowMapper_UserGuideStep implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserGuideStep>{
@Override
public com.ks.db.model.UserGuideStep rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserGuideStep bean = new com.ks.db.model.UserGuideStep();
bean.setId(rs.getInt("id"));
bean.setGuideIds(rs.getString("guide_ids"));
bean.setCreateTime(rs.getInt("create_time"));
bean.setUpdateTime(rs.getInt("update_time"));
return bean;
}
}
}
