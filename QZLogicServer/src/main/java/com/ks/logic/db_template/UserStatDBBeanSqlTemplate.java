package com.ks.logic.db_template;
public final class UserStatDBBeanSqlTemplate extends com.ks.access.DBBeanSqlTemplate<com.ks.db.model.UserStat>{
public UserStatDBBeanSqlTemplate(){
super();
clazz=com.ks.db.model.UserStat.class;
mapper = new com.ks.table.UserStatTable.DBRowMapper_UserStat();
sqlMap.put("updateUserStat","update t_user_stat set $fieldname where `user_id`=?");
sqlMap.put("queryUserStat","select * from t_user_stat where `user_id`=?");
sqlMap.put("addUserStat","insert t_user_stat (`user_id`,`arena_count`,`arena_buy_count`,`arena_refresh_count`,`mall_buy_count`,`giving_friend`,`exit_guild_time`,`create_time`,`update_time`,`collect_stamina`,`draw_login_award`,`draw_vip_gifis`,`activity_zone_count`,`hire_gp`,`gold_call`,`last_gold_call_time`,`diamond_call`,`last_diamond_call_time`,`martial_way_count`,`martial_way_buy_count`,`buy_gold_count`,`buy_stamina_count`,`signin_days`,`fill_signin`,`sum_signin_days`,`last_black_refresh_time`,`black_market_goods`,`black_market_ref_count`,`mall_totle_buy_count`,`slate_gain_time`,`today_equip_count_level`,`today_hero_count_level`,`equip_count_level`,`hero_count_level`,`arena_fight_count`,`martialway_fight_count`,`add_item_count`,`breadStoreCount`,`godWealthCount`,`animaTempleCount`,`breadStoreFreeRefreshCount`,`breadStoreDiamondRefreshCount`,`breadStoreZones`,`firstCallHero`,`cycleCards`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
paramMethodMap.put("updateUserStat", new DynamicUpdata_updateUserStat());
paramMethodMap.put("queryUserStat", new DynamicSelect_queryUserStat());
paramMethodMap.put("addUserStat", new DynamicInsert_addUserStat());
}
public final class DynamicUpdata_updateUserStat implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserStat>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserStat bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicSelect_queryUserStat implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserStat>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserStat bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
return list;
}
}
public final class DynamicInsert_addUserStat implements com.ks.access.DBBeanParamMethod<com.ks.db.model.UserStat>{
@Override
public java.util.List<Object> getParams(com.ks.db.model.UserStat bean){
java.util.List<Object> list = new java.util.ArrayList<Object>();
list.add(bean.getUserId());
list.add(bean.getArenaCount());
list.add(bean.getArenaBuyCount());
list.add(bean.getArenaRefreshCount());
list.add(bean.getMallBuyCount());
list.add(bean.getGivingFriend());
list.add(bean.getExitGuildTime());
list.add(bean.getCreateTime());
list.add(bean.getUpdateTime());
list.add(bean.getCollectStamina());
list.add(bean.isDrawLoginAward());
list.add(bean.getDrawVIPGifis());
list.add(bean.getActivityZoneCount());
list.add(bean.getHireGp());
list.add(bean.getGoldCall());
list.add(bean.getLastGoldCallTime());
list.add(bean.getDiamondCall());
list.add(bean.getLastDiamondCallTime());
list.add(bean.getMartialWayCount());
list.add(bean.getMartialWayBuyCount());
list.add(bean.getBuyGoldCount());
list.add(bean.getBuyStaminaCount());
list.add(bean.getSigninDays());
list.add(bean.getFillSignin());
list.add(bean.getSumSigninDays());
list.add(bean.getLastBlackRefreshTime());
list.add(bean.getBlackMarketGoods());
list.add(bean.getBlackMarketRefCount());
list.add(bean.getMallTotleBuyCount());
list.add(bean.getSlateGainTime());
list.add(bean.getTodayEquipCountLevel());
list.add(bean.getTodayHeroCountLevel());
list.add(bean.getEquipCountLevel());
list.add(bean.getHeroCountLevel());
list.add(bean.getArenaFightCount());
list.add(bean.getMartialwayFightCount());
list.add(bean.getAddItemCount());
list.add(bean.getBreadStoreCount());
list.add(bean.getGodWealthCount());
list.add(bean.getAnimaTempleCount());
list.add(bean.getBreadStoreFreeRefreshCount());
list.add(bean.getBreadStoreDiamondRefreshCount());
list.add(bean.getBreadStoreZones());
list.add(bean.isFirstCallHero());
list.add(bean.getCycleCards());
return list;
}
}
}