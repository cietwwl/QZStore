package com.ks.logic.db_template;
public final class UserDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.User>{
public UserDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.User.class;
mapper = new com.ks.table.UserTable.DBRowMapper_User();
sqlMap.put("findUserByPlayerName","select * from t_user where `player_name`=? limit 1");
sqlMap.put("updatePlayerName","update t_user set `player_name`=? where `user_id`=?");
sqlMap.put("findUserByUsername","select * from t_user where `username`=? and `partner`=? limit 1");
sqlMap.put("findUserByUserId","select * from t_user where `user_id`=? limit 1");
sqlMap.put("addUser","insert t_user (`user_id`,`username`,`partner`,`player_name`,`level`,`exp`,`add_exp_pool`,`stamina`,`gold`,`diamond`,`gp`,`hero_capacity`,`fight_id`,`charge_diamond`,`last_regain_stamina_time`,`last_login_time`,`create_time`,`update_time`,`hero_exp_pool`,`equipment_capacity`,`eternal_capacity`,`plot_step`,`guide_step`,`fun_unlock`,`slate`,`fame`,`renamed`,`online`,`firstOnlineTime`,`dailyOnlineTime`,`banChatTime`,`banLoginTime`,`accessTime`,`fighting`,`vip`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
sqlMap.put("clearUserFightId","update t_user set `user_id`=?,`username`=?,`partner`=?,`player_name`=?,`level`=?,`exp`=?,`add_exp_pool`=?,`stamina`=?,`gold`=?,`diamond`=?,`gp`=?,`hero_capacity`=?,`fight_id`=?,`charge_diamond`=?,`last_regain_stamina_time`=?,`last_login_time`=?,`create_time`=?,`update_time`=?,`hero_exp_pool`=?,`equipment_capacity`=?,`eternal_capacity`=?,`plot_step`=?,`guide_step`=?,`fun_unlock`=?,`slate`=?,`fame`=?,`renamed`=?,`online`=?,`firstOnlineTime`=?,`dailyOnlineTime`=?,`banChatTime`=?,`banLoginTime`=?,`accessTime`=?,`fighting`=?,`vip`=? where `user_id`=?");
sqlMap.put("updateUser","update t_user set `user_id`=?,`username`=?,`partner`=?,`player_name`=?,`level`=?,`exp`=?,`add_exp_pool`=?,`stamina`=?,`gold`=?,`diamond`=?,`gp`=?,`hero_capacity`=?,`fight_id`=?,`charge_diamond`=?,`last_regain_stamina_time`=?,`last_login_time`=?,`create_time`=?,`update_time`=?,`hero_exp_pool`=?,`equipment_capacity`=?,`eternal_capacity`=?,`plot_step`=?,`guide_step`=?,`fun_unlock`=?,`slate`=?,`fame`=?,`renamed`=?,`online`=?,`firstOnlineTime`=?,`dailyOnlineTime`=?,`banChatTime`=?,`banLoginTime`=?,`accessTime`=?,`fighting`=?,`vip`=? where `user_id`=?");
paramMethodMap.put("findUserByPlayerName", new DynamicSelect_findUserByPlayerName());
paramMethodMap.put("updatePlayerName", new DynamicUpdata_updatePlayerName());
paramMethodMap.put("findUserByUsername", new DynamicSelect_findUserByUsername());
paramMethodMap.put("findUserByUserId", new DynamicSelect_findUserByUserId());
paramMethodMap.put("addUser", new DynamicInsert_addUser());
paramMethodMap.put("clearUserFightId", new DynamicUpdata_clearUserFightId());
paramMethodMap.put("updateUser", new DynamicUpdata_updateUser());
}
public final class DynamicSelect_findUserByPlayerName implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getPlayerName());
return list;
}
}
public final class DynamicUpdata_updatePlayerName implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getPlayerName());
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_findUserByUsername implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUsername());
list.add(bean.getPartner());
return list;
}
}
public final class DynamicSelect_findUserByUserId implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addUser implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getUsername());
list.add(bean.getPartner());
list.add(bean.getPlayerName());
list.add(bean.getLevel());
list.add(bean.getExp());
list.add(bean.getAddExpPool());
list.add(bean.getStamina());
list.add(bean.getGold());
list.add(bean.getDiamond());
list.add(bean.getGp());
list.add(bean.getHeroCapacity());
list.add(bean.getFightId());
list.add(bean.getChargeDiamond());
list.add(bean.getLastRegainStaminaTime());
list.add(bean.getLastLoginTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getHeroExpPool());
list.add(bean.getEquipmentCapacity());
list.add(bean.getEternalCapacity());
list.add(bean.getPlotStep());
list.add(bean.getGuideStep());
list.add(bean.getFunUnlock());
list.add(bean.getSlate());
list.add(bean.getFame());
list.add(bean.isRenamed());
list.add(bean.getOnline());
list.add(bean.getFirstOnlineTime());
list.add(bean.getDailyOnlineTime());
list.add(bean.getBanChatTime());
list.add(bean.getBanLoginTime());
list.add(bean.getAccessTime());
list.add(bean.getFighting());
list.add(bean.getVip());
return list;
}
}
public final class DynamicUpdata_clearUserFightId implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getUsername());
list.add(bean.getPartner());
list.add(bean.getPlayerName());
list.add(bean.getLevel());
list.add(bean.getExp());
list.add(bean.getAddExpPool());
list.add(bean.getStamina());
list.add(bean.getGold());
list.add(bean.getDiamond());
list.add(bean.getGp());
list.add(bean.getHeroCapacity());
list.add(bean.getFightId());
list.add(bean.getChargeDiamond());
list.add(bean.getLastRegainStaminaTime());
list.add(bean.getLastLoginTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getHeroExpPool());
list.add(bean.getEquipmentCapacity());
list.add(bean.getEternalCapacity());
list.add(bean.getPlotStep());
list.add(bean.getGuideStep());
list.add(bean.getFunUnlock());
list.add(bean.getSlate());
list.add(bean.getFame());
list.add(bean.isRenamed());
list.add(bean.getOnline());
list.add(bean.getFirstOnlineTime());
list.add(bean.getDailyOnlineTime());
list.add(bean.getBanChatTime());
list.add(bean.getBanLoginTime());
list.add(bean.getAccessTime());
list.add(bean.getFighting());
list.add(bean.getVip());
list.add(bean.getUserId());
return list;
}
}
public final class DynamicUpdata_updateUser implements com.ks.access.DBBeanParamMethod<com.ks.db.model.User>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.User bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getUsername());
list.add(bean.getPartner());
list.add(bean.getPlayerName());
list.add(bean.getLevel());
list.add(bean.getExp());
list.add(bean.getAddExpPool());
list.add(bean.getStamina());
list.add(bean.getGold());
list.add(bean.getDiamond());
list.add(bean.getGp());
list.add(bean.getHeroCapacity());
list.add(bean.getFightId());
list.add(bean.getChargeDiamond());
list.add(bean.getLastRegainStaminaTime());
list.add(bean.getLastLoginTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getHeroExpPool());
list.add(bean.getEquipmentCapacity());
list.add(bean.getEternalCapacity());
list.add(bean.getPlotStep());
list.add(bean.getGuideStep());
list.add(bean.getFunUnlock());
list.add(bean.getSlate());
list.add(bean.getFame());
list.add(bean.isRenamed());
list.add(bean.getOnline());
list.add(bean.getFirstOnlineTime());
list.add(bean.getDailyOnlineTime());
list.add(bean.getBanChatTime());
list.add(bean.getBanLoginTime());
list.add(bean.getAccessTime());
list.add(bean.getFighting());
list.add(bean.getVip());
list.add(bean.getUserId());
return list;
}
}
}