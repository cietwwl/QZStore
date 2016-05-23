package com.ks.logic.db_template;
public final class GuildSkillDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.GuildSkill>{
public GuildSkillDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.GuildSkill.class;
mapper = new com.ks.table.GuildSkillTable.DBRowMapper_GuildSkill();
sqlMap.put("queryGuildSkill","select * from t_guild_skill where `guild_id`=? and `skill_id`=?");
sqlMap.put("updateGuildSkill","update t_guild_skill set `guild_id`=?,`skill_id`=?,`gp`=?,`create_time`=?,`update_time`=? where `guild_id`=? and `skill_id`=?");
sqlMap.put("addGuildSkill","insert t_guild_skill (`guild_id`,`skill_id`,`gp`,`create_time`,`update_time`) values (?,?,?,?,?)");
sqlMap.put("deleteGuildSkill","delete from t_guild_skill where `guild_id`=?");
sqlMap.put("queryGuildSkills","select * from t_guild_skill where `guild_id`=?");
paramMethodMap.put("queryGuildSkill", new DynamicSelect_queryGuildSkill());
paramMethodMap.put("updateGuildSkill", new DynamicUpdata_updateGuildSkill());
paramMethodMap.put("addGuildSkill", new DynamicInsert_addGuildSkill());
paramMethodMap.put("deleteGuildSkill", new DynamicDelete_deleteGuildSkill());
paramMethodMap.put("queryGuildSkills", new DynamicSelect_queryGuildSkills());
}
public final class DynamicSelect_queryGuildSkill implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildSkill>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildSkill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
list.add(bean.getSkillId());
return list;
}
}
public final class DynamicUpdata_updateGuildSkill implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildSkill>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildSkill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
list.add(bean.getSkillId());
list.add(bean.getGp());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getGuildId());
list.add(bean.getSkillId());
return list;
}
}
public final class DynamicInsert_addGuildSkill implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildSkill>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildSkill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
list.add(bean.getSkillId());
list.add(bean.getGp());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
return list;
}
}
public final class DynamicDelete_deleteGuildSkill implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildSkill>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildSkill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
public final class DynamicSelect_queryGuildSkills implements com.ks.access.DBBeanParamMethod<com.ks.db.model.GuildSkill>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.GuildSkill bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getGuildId());
return list;
}
}
}