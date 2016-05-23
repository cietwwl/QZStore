package com.ks.logic.db_template;
public final class GuildDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.Guild>{
public GuildDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.Guild.class;
mapper = new com.ks.table.GuildTable.DBRowMapper_Guild();
sqlMap.put("queryGuild","select * from t_guild where `guild_id`=?");
sqlMap.put("addGuild","insert t_guild (`guild_id`,`name`,`cdr_user_id`,`member_num`,`exp`,`skill_point`,`state`,`create_time`,`update_time`) values (?,?,?,?,?,?,?,?,?)");
sqlMap.put("deleteGuild","delete from t_guild where `guild_id`=?");
sqlMap.put("queryGuildRank","select * from t_guild order by exp desc,create_time asc limit ?,10");
sqlMap.put("updateGuild","update t_guild set $fieldname where `guild_id`=?");
sqlMap.put("queryGuildLock","select * from t_guild where `guild_id`=? for update");
paramMethodMap.put("queryGuild", new DynamicSelect_queryGuild());
paramMethodMap.put("addGuild", new DynamicInsert_addGuild());
paramMethodMap.put("deleteGuild", new DynamicDelete_deleteGuild());
paramMethodMap.put("queryGuildRank", new DynamicSelect_queryGuildRank());
paramMethodMap.put("updateGuild", new DynamicUpdata_updateGuild());
paramMethodMap.put("queryGuildLock", new DynamicSelect_queryGuildLock());
}
public final class DynamicSelect_queryGuild implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Guild>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Guild bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicInsert_addGuild implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Guild>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Guild bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
list.add(bean.getName());
list.add(bean.getCdrUserId());
list.add(bean.getMemberNum());
list.add(bean.getExp());
list.add(bean.getSkillPoint());
list.add(bean.getState());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicDelete_deleteGuild implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Guild>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Guild bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicSelect_queryGuildRank implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Guild>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Guild bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
return list;
}
}
public final class DynamicUpdata_updateGuild implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Guild>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Guild bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicSelect_queryGuildLock implements com.ks.access.DBBeanParamMethod<com.ks.db.model.Guild>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.Guild bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
}