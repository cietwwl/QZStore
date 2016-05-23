package com.ks.logic.db_template;
public final class GuildMemberDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.GuildMember>{
public GuildMemberDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.GuildMember.class;
mapper = new com.ks.table.GuildMemberTable.DBRowMapper_GuildMember();
sqlMap.put("updateGuildMemberByOpt","update t_guild_member set $fieldname where `user_id`=?");
sqlMap.put("addGuildMember","insert t_guild_member (`user_id`,`guild_id`,`player_name`,`level`,`property`,`devote`,`today_devote`,`create_time`,`update_time`) values (?,?,?,?,?,?,?,?,?)");
sqlMap.put("updateGuildMember","update t_guild_member set `user_id`=?,`guild_id`=?,`player_name`=?,`level`=?,`property`=?,`devote`=?,`today_devote`=?,`create_time`=?,`update_time`=? where `user_id`=?");
paramMethodMap.put("updateGuildMemberByOpt", new DynamicUpdata_updateGuildMemberByOpt());
paramMethodMap.put("addGuildMember", new DynamicInsert_addGuildMember());
paramMethodMap.put("updateGuildMember", new DynamicUpdata_updateGuildMember());
}
public final class DynamicUpdata_updateGuildMemberByOpt implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildMember>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildMember bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addGuildMember implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildMember>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildMember bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getGuildId());
list.add(bean.getPlayerName());
list.add(bean.getLevel());
list.add(bean.getProperty());
list.add(bean.getDevote());
list.add(bean.getTodayDevote());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicUpdata_updateGuildMember implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildMember>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildMember bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getGuildId());
list.add(bean.getPlayerName());
list.add(bean.getLevel());
list.add(bean.getProperty());
list.add(bean.getDevote());
list.add(bean.getTodayDevote());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getUserId());
return list;
}
}
}