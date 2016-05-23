package com.ks.logic.db_template;
public final class UserHeroDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserHero>{
public UserHeroDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserHero.class;
mapper = new com.ks.table.UserHeroTable.DBRowMapper_UserHero();
sqlMap.put("addUserHero","insert $tablename (`id`,`user_id`,`hero_id`,`level`,`exp`,`ele_level`,`state`,`skill_level`,`cap_skill_level`,`create_time`,`update_time`,`eternal`,`breakLevel`,`breakedSlots`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
sqlMap.put("queryUserHero","select * from $tablename where `user_id`=? and `id`=?");
sqlMap.put("queryUserHeros","select * from $tablename where `user_id`=?");
sqlMap.put("updateUserHero","update $tablename set `id`=?,`user_id`=?,`hero_id`=?,`level`=?,`exp`=?,`ele_level`=?,`state`=?,`skill_level`=?,`cap_skill_level`=?,`create_time`=?,`update_time`=?,`eternal`=?,`breakLevel`=?,`breakedSlots`=? where `user_id`=? and `id`=?");
sqlMap.put("deleteUserHero","delete from $tablename where `user_id`=? and `id`=?");
sqlMap.put("updateUserHeros","update $tablename set `id`=?,`user_id`=?,`hero_id`=?,`level`=?,`exp`=?,`ele_level`=?,`state`=?,`skill_level`=?,`cap_skill_level`=?,`create_time`=?,`update_time`=?,`eternal`=?,`breakLevel`=?,`breakedSlots`=? where `user_id`=? and `id`=?");
paramMethodMap.put("addUserHero", new DynamicInsert_addUserHero());
paramMethodMap.put("queryUserHero", new DynamicSelect_queryUserHero());
paramMethodMap.put("queryUserHeros", new DynamicSelect_queryUserHeros());
paramMethodMap.put("updateUserHero", new DynamicUpdata_updateUserHero());
paramMethodMap.put("deleteUserHero", new DynamicDelete_deleteUserHero());
paramMethodMap.put("updateUserHeros", new DynamicUpdata_updateUserHeros());
}
public final class DynamicInsert_addUserHero implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getHeroId());
list.add(bean.getLevel());
list.add(bean.getExp());
list.add(bean.getEleLevel());
list.add(bean.getState());
list.add(bean.getSkillLevel());
list.add(bean.getCapSkillLevel());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getEternal());
list.add(bean.getBreakLevel());
list.add(bean.getBreakedSlots());
return list;
}
}
public final class DynamicSelect_queryUserHero implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getId());
return list;
}
}
public final class DynamicSelect_queryUserHeros implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateUserHero implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getHeroId());
list.add(bean.getLevel());
list.add(bean.getExp());
list.add(bean.getEleLevel());
list.add(bean.getState());
list.add(bean.getSkillLevel());
list.add(bean.getCapSkillLevel());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getEternal());
list.add(bean.getBreakLevel());
list.add(bean.getBreakedSlots());
list.add(bean.getUserId());
list.add(bean.getId());
return list;
}
}
public final class DynamicDelete_deleteUserHero implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getId());
return list;
}
}
public final class DynamicUpdata_updateUserHeros implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserHero>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserHero bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getId());
list.add(bean.getUserId());
list.add(bean.getHeroId());
list.add(bean.getLevel());
list.add(bean.getExp());
list.add(bean.getEleLevel());
list.add(bean.getState());
list.add(bean.getSkillLevel());
list.add(bean.getCapSkillLevel());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getEternal());
list.add(bean.getBreakLevel());
list.add(bean.getBreakedSlots());
list.add(bean.getUserId());
list.add(bean.getId());
return list;
}
}
}