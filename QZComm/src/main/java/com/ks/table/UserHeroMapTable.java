package com.ks.table;
public final class UserHeroMapTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserHeroMap>{
public static UserHeroMapTable instance;
public static final String USERID="user_id";
public static final String HEROID="hero_id";
public static final String CREATETIME="create_time";

public static final String J_USERID="userId";
public static final String J_HEROID="heroId";
public static final String J_CREATETIME="createTime";

public UserHeroMapTable(){
mapper=new DBRowMapper_UserHeroMap();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserHeroMap bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(HEROID.equals(fname)){
return bean.getHeroId();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserHeroMap.class;
}
public final static class DBRowMapper_UserHeroMap implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserHeroMap>{
@Override
public com.ks.db.model.UserHeroMap rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserHeroMap bean = new com.ks.db.model.UserHeroMap();
bean.setUserId(rs.getInt("user_id"));
bean.setHeroId(rs.getInt("hero_id"));
bean.setCreateTime(rs.getTimestamp("create_time"));
return bean;
}
}
}
