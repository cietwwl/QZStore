package com.ks.table;
public final class UserTeamTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserTeam>{
public static UserTeamTable instance;
public static final String TABLE_NAME="t_user_team";
public static final String USERID="user_id";
public static final String HEROS="heros";
public static final String POS="pos";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";

public static final String J_USERID="userId";
public static final String J_HEROS="heros";
public static final String J_POS="pos";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";

public UserTeamTable(){
mapper=new DBRowMapper_UserTeam();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserTeam bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(HEROS.equals(fname)){
return bean.getHeros();
}
if(POS.equals(fname)){
return bean.getPos();
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
return com.ks.db.model.UserTeam.class;
}
public final static class DBRowMapper_UserTeam implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserTeam>{
@Override
public com.ks.db.model.UserTeam rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserTeam bean = new com.ks.db.model.UserTeam();
bean.setUserId(rs.getInt("user_id"));
bean.setHeros(rs.getString("heros"));
bean.setPos(rs.getString("pos"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
return bean;
}
}
}
