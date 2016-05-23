package com.ks.logic.db_template;
public final class UserAchieveDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserAchieve>{
public UserAchieveDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserAchieve.class;
mapper = new com.ks.table.UserAchieveTable.DBRowMapper_UserAchieve();
sqlMap.put("queryUserAchieve","select * from $tablename where `user_id`=? and `achieve_id`=?");
sqlMap.put("updateUserAchieve","update $tablename set `user_id`=?,`achieve_id`=?,`achieve_type`=?,`ass_id`=?,`num`=?,`state`=?,`create_time`=?,`update_time`=? where `user_id`=? and `achieve_id`=?");
sqlMap.put("queryUserAchieves","select * from $tablename where `user_id`=?");
sqlMap.put("addUserAchieve","insert $tablename (`user_id`,`achieve_id`,`achieve_type`,`ass_id`,`num`,`state`,`create_time`,`update_time`) values (?,?,?,?,?,?,?,?)");
sqlMap.put("queryCurrAchieve","select * from $tablename where `user_id`=? and `achieve_type`=? and `ass_id`=? order by achieve_id desc limit 1");
paramMethodMap.put("queryUserAchieve", new DynamicSelect_queryUserAchieve());
paramMethodMap.put("updateUserAchieve", new DynamicUpdata_updateUserAchieve());
paramMethodMap.put("queryUserAchieves", new DynamicSelect_queryUserAchieves());
paramMethodMap.put("addUserAchieve", new DynamicInsert_addUserAchieve());
paramMethodMap.put("queryCurrAchieve", new DynamicSelect_queryCurrAchieve());
}
public final class DynamicSelect_queryUserAchieve implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserAchieve>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserAchieve bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getAchieveId());
return list;
}
}
public final class DynamicUpdata_updateUserAchieve implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserAchieve>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserAchieve bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getAchieveId());
list.add(bean.getAchieveType());
list.add(bean.getAssId());
list.add(bean.getNum());
list.add(bean.getState());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
list.add(bean.getAchieveId());
return list;
}
}
public final class DynamicSelect_queryUserAchieves implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserAchieve>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserAchieve bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addUserAchieve implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserAchieve>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserAchieve bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getAchieveId());
list.add(bean.getAchieveType());
list.add(bean.getAssId());
list.add(bean.getNum());
list.add(bean.getState());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicSelect_queryCurrAchieve implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserAchieve>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserAchieve bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getAchieveType());
list.add(bean.getAssId());
return list;
}
}
}