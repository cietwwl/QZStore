package com.ks.logic.db_template;
public final class UserTeamDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserTeam>{
public UserTeamDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserTeam.class;
mapper = new com.ks.table.UserTeamTable.DBRowMapper_UserTeam();
sqlMap.put("addUserTeam","insert t_user_team (`user_id`,`heros`,`pos`,`create_time`,`update_time`) values (?,?,?,?,?)");
sqlMap.put("queryUserTeam","select * from t_user_team where `user_id`=?");
sqlMap.put("updateUserTeam","update t_user_team set `user_id`=?,`heros`=?,`pos`=?,`create_time`=?,`update_time`=? where `user_id`=?");
paramMethodMap.put("addUserTeam", new DynamicInsert_addUserTeam());
paramMethodMap.put("queryUserTeam", new DynamicSelect_queryUserTeam());
paramMethodMap.put("updateUserTeam", new DynamicUpdata_updateUserTeam());
}
public final class DynamicInsert_addUserTeam implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserTeam>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserTeam bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getHeros());
list.add(bean.getPos());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryUserTeam implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserTeam>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserTeam bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateUserTeam implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserTeam>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserTeam bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getHeros());
list.add(bean.getPos());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
return list;
}
}
}