package com.ks.jedis.model;
public final class JedisRowMapper_UserStat implements com.ks.cache.JedisRowMapper<com.ks.db.model.UserStat>{
@Override
public com.ks.db.model.UserStat rowMapper(com.ks.cache.JedisResultSet jrs) {
com.ks.db.model.UserStat bean = new com.ks.db.model.UserStat();
bean.setUserId(jrs.getInt("userId"));
bean.setArenaCount(jrs.getInt("arenaCount"));
bean.setArenaBuyCount(jrs.getInt("arenaBuyCount"));
bean.setArenaRefreshCount(jrs.getInt("arenaRefreshCount"));
bean.setMallBuyCount(jrs.getString("mallBuyCount"));
bean.setGivingFriend(jrs.getString("givingFriend"));
bean.setExitGuildTime(jrs.getDate("exitGuildTime"));
bean.setCreateTime(jrs.getDate("createTime"));
bean.setUpdateTime(jrs.getDate("updateTime"));
bean.setCollectStamina(jrs.getInt("collectStamina"));
bean.setDrawLoginAward(jrs.getBoolean("drawLoginAward"));
bean.setDrawVIPGifis(jrs.getString("drawVIPGifis"));
bean.setActivityZoneCount(jrs.getString("activityZoneCount"));
bean.setHireGp(jrs.getInt("hireGp"));
bean.setGoldCall(jrs.getInt("goldCall"));
bean.setLastGoldCallTime(jrs.getDate("lastGoldCallTime"));
bean.setDiamondCall(jrs.getInt("diamondCall"));
bean.setLastDiamondCallTime(jrs.getDate("lastDiamondCallTime"));
bean.setMartialWayCount(jrs.getByte("martialWayCount"));
bean.setMartialWayBuyCount(jrs.getByte("martialWayBuyCount"));
bean.setBuyGoldCount(jrs.getByte("buyGoldCount"));
bean.setBuyStaminaCount(jrs.getByte("buyStaminaCount"));
bean.setSigninDays(jrs.getString("signinDays"));
bean.setFillSignin(jrs.getInt("fillSignin"));
bean.setSumSigninDays(jrs.getString("sumSigninDays"));
bean.setLastBlackRefreshTime(jrs.getInt("lastBlackRefreshTime"));
bean.setBlackMarketGoods(jrs.getString("blackMarketGoods"));
bean.setBlackMarketRefCount(jrs.getInt("blackMarketRefCount"));
bean.setMallTotleBuyCount(jrs.getString("mallTotleBuyCount"));
bean.setSlateGainTime(jrs.getDate("slateGainTime"));
bean.setTodayEquipCountLevel(jrs.getInt("todayEquipCountLevel"));
bean.setTodayHeroCountLevel(jrs.getInt("todayHeroCountLevel"));
bean.setEquipCountLevel(jrs.getInt("equipCountLevel"));
bean.setHeroCountLevel(jrs.getInt("heroCountLevel"));
bean.setArenaFightCount(jrs.getInt("arenaFightCount"));
bean.setMartialwayFightCount(jrs.getInt("martialwayFightCount"));
bean.setAddItemCount(jrs.getInt("addItemCount"));
bean.setBreadStoreCount(jrs.getInt("breadStoreCount"));
bean.setGodWealthCount(jrs.getInt("godWealthCount"));
bean.setAnimaTempleCount(jrs.getInt("animaTempleCount"));
bean.setBreadStoreFreeRefreshCount(jrs.getInt("breadStoreFreeRefreshCount"));
bean.setBreadStoreDiamondRefreshCount(jrs.getInt("breadStoreDiamondRefreshCount"));
bean.setBreadStoreZones(jrs.getString("breadStoreZones"));
bean.setFirstCallHero(jrs.getBoolean("firstCallHero"));
bean.setCycleCards(jrs.getString("cycleCards"));
return bean;}
}
