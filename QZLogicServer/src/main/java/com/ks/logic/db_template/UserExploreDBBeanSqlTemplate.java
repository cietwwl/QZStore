package com.ks.logic.db_template;
public final class UserExploreDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserExplore>{
public UserExploreDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserExplore.class;
mapper = new com.ks.table.UserExploreTable.DBRowMapper_UserExplore();
sqlMap.put("queryUserExplore","select * from t_user_explore where `user_id`=? and `explore_id`=?");
sqlMap.put("updateUserExplore","update t_user_explore set `user_id`=?,`explore_id`=?,`user_hero_id`=?,`explore_type`=?,`state`=?,`end_time`=?,`create_time`=?,`update_time`=? where `user_id`=? and `explore_id`=?");
sqlMap.put("queryUserExplores","select * from t_user_explore where `user_id`=?");
sqlMap.put("addUserExplore","insert t_user_explore (`user_id`,`explore_id`,`user_hero_id`,`explore_type`,`state`,`end_time`,`create_time`,`update_time`) values (?,?,?,?,?,?,?,?)");
paramMethodMap.put("queryUserExplore", new DynamicSelect_queryUserExplore());
paramMethodMap.put("updateUserExplore", new DynamicUpdata_updateUserExplore());
paramMethodMap.put("queryUserExplores", new DynamicSelect_queryUserExplores());
paramMethodMap.put("addUserExplore", new DynamicInsert_addUserExplore());
}
public final class DynamicSelect_queryUserExplore implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserExplore>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserExplore bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getExploreId());
return list;
}
}
public final class DynamicUpdata_updateUserExplore implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserExplore>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserExplore bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getExploreId());
list.add(bean.getUserHeroId());
list.add(bean.getExploreType());
list.add(bean.getState());
list.add(bean.getEndTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getExploreId());
return list;
}
}
public final class DynamicSelect_queryUserExplores implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserExplore>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserExplore bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addUserExplore implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserExplore>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserExplore bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getExploreId());
list.add(bean.getUserHeroId());
list.add(bean.getExploreType());
list.add(bean.getState());
list.add(bean.getEndTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
}