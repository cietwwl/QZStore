package com.ks.logic.db_template;
public final class GuildApplyDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.GuildApply>{
public GuildApplyDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.GuildApply.class;
mapper = new com.ks.table.GuildApplyTable.DBRowMapper_GuildApply();
sqlMap.put("queryGuildApply","select * from t_guild_apply where `user_id`=?");
sqlMap.put("addGuildApply","insert t_guild_apply (`user_id`,`guild_id`,`create_time`) values (?,?,?)");
sqlMap.put("queryGuildApplys","select * from t_guild_apply where `guild_id`=? order by create_time desc limit ?,10");
sqlMap.put("deleteGuildApply","delete from t_guild_apply where `user_id`=?");
sqlMap.put("deleteAllGuildApply","delete from t_guild_apply where `guild_id`=?");
paramMethodMap.put("queryGuildApply", new DynamicSelect_queryGuildApply());
paramMethodMap.put("addGuildApply", new DynamicInsert_addGuildApply());
paramMethodMap.put("queryGuildApplys", new DynamicSelect_queryGuildApplys());
paramMethodMap.put("deleteGuildApply", new DynamicDelete_deleteGuildApply());
paramMethodMap.put("deleteAllGuildApply", new DynamicDelete_deleteAllGuildApply());
}
public final class DynamicSelect_queryGuildApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addGuildApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getGuildId());
list.add(bean.getCreateTime());
return list;
}
}
public final class DynamicSelect_queryGuildApplys implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicDelete_deleteGuildApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicDelete_deleteAllGuildApply implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildApply>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildApply bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
}