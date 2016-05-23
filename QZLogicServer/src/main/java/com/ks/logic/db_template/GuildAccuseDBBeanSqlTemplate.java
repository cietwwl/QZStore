package com.ks.logic.db_template;
public final class GuildAccuseDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.GuildAccuse>{
public GuildAccuseDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.GuildAccuse.class;
mapper = new com.ks.table.GuildAccuseTable.DBRowMapper_GuildAccuse();
sqlMap.put("addGuildAccuse","insert t_guild_accuse (`guild_id`,`originator`,`player_name`,`resper`,`create_time`,`update_time`) values (?,?,?,?,?,?)");
sqlMap.put("deleteGuildAccuse","delete from t_guild_accuse where `guild_id`=?");
sqlMap.put("queryGuildAccuse","select * from t_guild_accuse where `guild_id`=?");
sqlMap.put("updateGuildAccuse","update t_guild_accuse set `update_time`=?,`resper`=? where `guild_id`=?");
paramMethodMap.put("addGuildAccuse", new DynamicInsert_addGuildAccuse());
paramMethodMap.put("deleteGuildAccuse", new DynamicDelete_deleteGuildAccuse());
paramMethodMap.put("queryGuildAccuse", new DynamicSelect_queryGuildAccuse());
paramMethodMap.put("updateGuildAccuse", new DynamicUpdata_updateGuildAccuse());
}
public final class DynamicInsert_addGuildAccuse implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildAccuse>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildAccuse bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
list.add(bean.getOriginator());
list.add(bean.getPlayerName());
list.add(bean.getResper());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicDelete_deleteGuildAccuse implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildAccuse>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildAccuse bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicSelect_queryGuildAccuse implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildAccuse>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildAccuse bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicUpdata_updateGuildAccuse implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildAccuse>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildAccuse bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUpdateTime());
list.add(bean.getResper());
list.add(bean.getGuildId());
return list;
}
}
}