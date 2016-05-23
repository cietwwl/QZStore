package com.ks.jedis.model;
public final class ObjectFieldMap_UserStat implements com.ks.cache.ObjectFieldMap<com.ks.db.model.UserStat>{
@Override
public java.util.Map<String, String> objectToMap(com.ks.db.model.UserStat bean) {
java.util.Map<String, String> map = new java.util.HashMap<String, String>();
map.put("userId",String.valueOf(bean.getUserId()));
map.put("arenaCount",String.valueOf(bean.getArenaCount()));
map.put("arenaBuyCount",String.valueOf(bean.getArenaBuyCount()));
map.put("arenaRefreshCount",String.valueOf(bean.getArenaRefreshCount()));
map.put("mallBuyCount",String.valueOf(bean.getMallBuyCount()));
map.put("givingFriend",String.valueOf(bean.getGivingFriend()));
map.put("exitGuildTime",String.valueOf(bean.getExitGuildTime().getTime()));
map.put("createTime",String.valueOf(bean.getCreateTime().getTime()));
map.put("updateTime",String.valueOf(bean.getUpdateTime().getTime()));
map.put("collectStamina",String.valueOf(bean.getCollectStamina()));
map.put("drawLoginAward",String.valueOf(bean.isDrawLoginAward()));
map.put("drawVIPGifis",String.valueOf(bean.getDrawVIPGifis()));
map.put("activityZoneCount",String.valueOf(bean.getActivityZoneCount()));
map.put("hireGp",String.valueOf(bean.getHireGp()));
map.put("goldCall",String.valueOf(bean.getGoldCall()));
map.put("lastGoldCallTime",String.valueOf(bean.getLastGoldCallTime().getTime()));
map.put("diamondCall",String.valueOf(bean.getDiamondCall()));
map.put("lastDiamondCallTime",String.valueOf(bean.getLastDiamondCallTime().getTime()));
map.put("martialWayCount",String.valueOf(bean.getMartialWayCount()));
map.put("martialWayBuyCount",String.valueOf(bean.getMartialWayBuyCount()));
map.put("buyGoldCount",String.valueOf(bean.getBuyGoldCount()));
map.put("buyStaminaCount",String.valueOf(bean.getBuyStaminaCount()));
map.put("signinDays",String.valueOf(bean.getSigninDays()));
map.put("fillSignin",String.valueOf(bean.getFillSignin()));
map.put("sumSigninDays",String.valueOf(bean.getSumSigninDays()));
map.put("blackMarketGoods",String.valueOf(bean.getBlackMarketGoods()));
map.put("blackMarketRefCount",String.valueOf(bean.getBlackMarketRefCount()));
map.put("mallTotleBuyCount",String.valueOf(bean.getMallTotleBuyCount()));
map.put("slateGainTime",String.valueOf(bean.getSlateGainTime().getTime()));
map.put("todayEquipCountLevel",String.valueOf(bean.getTodayEquipCountLevel()));
map.put("todayHeroCountLevel",String.valueOf(bean.getTodayHeroCountLevel()));
map.put("equipCountLevel",String.valueOf(bean.getEquipCountLevel()));
map.put("heroCountLevel",String.valueOf(bean.getHeroCountLevel()));
map.put("arenaFightCount",String.valueOf(bean.getArenaFightCount()));
map.put("martialwayFightCount",String.valueOf(bean.getMartialwayFightCount()));
map.put("addItemCount",String.valueOf(bean.getAddItemCount()));
map.put("breadStoreCount",String.valueOf(bean.getBreadStoreCount()));
map.put("godWealthCount",String.valueOf(bean.getGodWealthCount()));
map.put("animaTempleCount",String.valueOf(bean.getAnimaTempleCount()));
map.put("breadStoreFreeRefreshCount",String.valueOf(bean.getBreadStoreFreeRefreshCount()));
map.put("breadStoreDiamondRefreshCount",String.valueOf(bean.getBreadStoreDiamondRefreshCount()));
map.put("breadStoreZones",String.valueOf(bean.getBreadStoreZones()));
map.put("firstCallHero",String.valueOf(bean.isFirstCallHero()));
map.put("cycleCards",String.valueOf(bean.getCycleCards()));
return map;
}
}
