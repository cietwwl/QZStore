package com.ks.table;
public final class UserStatTable extends com.ks.access.DBBeanTable<com.ks.db.model.UserStat>{
public static UserStatTable instance;
public static final String TABLE_NAME="t_user_stat";
public static final String USERID="user_id";
public static final String ARENACOUNT="arena_count";
public static final String ARENABUYCOUNT="arena_buy_count";
public static final String ARENAREFRESHCOUNT="arena_refresh_count";
public static final String MALLBUYCOUNT="mall_buy_count";
public static final String GIVINGFRIEND="giving_friend";
public static final String EXITGUILDTIME="exit_guild_time";
public static final String CREATETIME="create_time";
public static final String UPDATETIME="update_time";
public static final String COLLECTSTAMINA="collect_stamina";
public static final String DRAWLOGINAWARD="draw_login_award";
public static final String DRAWVIPGIFIS="draw_vip_gifis";
public static final String ACTIVITYZONECOUNT="activity_zone_count";
public static final String HIREGP="hire_gp";
public static final String GOLDCALL="gold_call";
public static final String LASTGOLDCALLTIME="last_gold_call_time";
public static final String DIAMONDCALL="diamond_call";
public static final String LASTDIAMONDCALLTIME="last_diamond_call_time";
public static final String MARTIALWAYCOUNT="martial_way_count";
public static final String MARTIALWAYBUYCOUNT="martial_way_buy_count";
public static final String BUYGOLDCOUNT="buy_gold_count";
public static final String BUYSTAMINACOUNT="buy_stamina_count";
public static final String SIGNINDAYS="signin_days";
public static final String FILLSIGNIN="fill_signin";
public static final String SUMSIGNINDAYS="sum_signin_days";
public static final String BLACKMARKETGOODS="black_market_goods";
public static final String BLACKMARKETREFCOUNT="black_market_ref_count";
public static final String MALLTOTLEBUYCOUNT="mall_totle_buy_count";
public static final String SLATEGAINTIME="slate_gain_time";
public static final String TODAYEQUIPCOUNTLEVEL="today_equip_count_level";
public static final String TODAYHEROCOUNTLEVEL="today_hero_count_level";
public static final String EQUIPCOUNTLEVEL="equip_count_level";
public static final String HEROCOUNTLEVEL="hero_count_level";
public static final String ARENAFIGHTCOUNT="arena_fight_count";
public static final String MARTIALWAYFIGHTCOUNT="martialway_fight_count";
public static final String ADDITEMCOUNT="add_item_count";
public static final String BREADSTORECOUNT="breadStoreCount";
public static final String GODWEALTHCOUNT="godWealthCount";
public static final String ANIMATEMPLECOUNT="animaTempleCount";
public static final String BREADSTOREFREEREFRESHCOUNT="breadStoreFreeRefreshCount";
public static final String BREADSTOREDIAMONDREFRESHCOUNT="breadStoreDiamondRefreshCount";
public static final String BREADSTOREZONES="breadStoreZones";
public static final String FIRSTCALLHERO="firstCallHero";
public static final String CYCLECARDS="cycleCards";

public static final String J_USERID="userId";
public static final String J_ARENACOUNT="arenaCount";
public static final String J_ARENABUYCOUNT="arenaBuyCount";
public static final String J_ARENAREFRESHCOUNT="arenaRefreshCount";
public static final String J_MALLBUYCOUNT="mallBuyCount";
public static final String J_GIVINGFRIEND="givingFriend";
public static final String J_EXITGUILDTIME="exitGuildTime";
public static final String J_CREATETIME="createTime";
public static final String J_UPDATETIME="updateTime";
public static final String J_COLLECTSTAMINA="collectStamina";
public static final String J_DRAWLOGINAWARD="drawLoginAward";
public static final String J_DRAWVIPGIFIS="drawVIPGifis";
public static final String J_ACTIVITYZONECOUNT="activityZoneCount";
public static final String J_HIREGP="hireGp";
public static final String J_GOLDCALL="goldCall";
public static final String J_LASTGOLDCALLTIME="lastGoldCallTime";
public static final String J_DIAMONDCALL="diamondCall";
public static final String J_LASTDIAMONDCALLTIME="lastDiamondCallTime";
public static final String J_MARTIALWAYCOUNT="martialWayCount";
public static final String J_MARTIALWAYBUYCOUNT="martialWayBuyCount";
public static final String J_BUYGOLDCOUNT="buyGoldCount";
public static final String J_BUYSTAMINACOUNT="buyStaminaCount";
public static final String J_SIGNINDAYS="signinDays";
public static final String J_FILLSIGNIN="fillSignin";
public static final String J_SUMSIGNINDAYS="sumSigninDays";
public static final String J_BLACKMARKETGOODS="blackMarketGoods";
public static final String J_BLACKMARKETREFCOUNT="blackMarketRefCount";
public static final String J_MALLTOTLEBUYCOUNT="mallTotleBuyCount";
public static final String J_SLATEGAINTIME="slateGainTime";
public static final String J_TODAYEQUIPCOUNTLEVEL="todayEquipCountLevel";
public static final String J_TODAYHEROCOUNTLEVEL="todayHeroCountLevel";
public static final String J_EQUIPCOUNTLEVEL="equipCountLevel";
public static final String J_HEROCOUNTLEVEL="heroCountLevel";
public static final String J_ARENAFIGHTCOUNT="arenaFightCount";
public static final String J_MARTIALWAYFIGHTCOUNT="martialwayFightCount";
public static final String J_ADDITEMCOUNT="addItemCount";
public static final String J_BREADSTORECOUNT="breadStoreCount";
public static final String J_GODWEALTHCOUNT="godWealthCount";
public static final String J_ANIMATEMPLECOUNT="animaTempleCount";
public static final String J_BREADSTOREFREEREFRESHCOUNT="breadStoreFreeRefreshCount";
public static final String J_BREADSTOREDIAMONDREFRESHCOUNT="breadStoreDiamondRefreshCount";
public static final String J_BREADSTOREZONES="breadStoreZones";
public static final String J_FIRSTCALLHERO="firstCallHero";
public static final String J_CYCLECARDS="cycleCards";

public UserStatTable(){
mapper=new DBRowMapper_UserStat();
}
@Override
public Object getDBFieldValue(com.ks.db.model.UserStat bean, String fname){
if(USERID.equals(fname)){
return bean.getUserId();
}
if(ARENACOUNT.equals(fname)){
return bean.getArenaCount();
}
if(ARENABUYCOUNT.equals(fname)){
return bean.getArenaBuyCount();
}
if(ARENAREFRESHCOUNT.equals(fname)){
return bean.getArenaRefreshCount();
}
if(MALLBUYCOUNT.equals(fname)){
return bean.getMallBuyCount();
}
if(GIVINGFRIEND.equals(fname)){
return bean.getGivingFriend();
}
if(EXITGUILDTIME.equals(fname)){
return bean.getExitGuildTime();
}
if(CREATETIME.equals(fname)){
return bean.getCreateTime();
}
if(UPDATETIME.equals(fname)){
return bean.getUpdateTime();
}
if(COLLECTSTAMINA.equals(fname)){
return bean.getCollectStamina();
}
if(DRAWLOGINAWARD.equals(fname)){
return bean.isDrawLoginAward();
}
if(DRAWVIPGIFIS.equals(fname)){
return bean.getDrawVIPGifis();
}
if(ACTIVITYZONECOUNT.equals(fname)){
return bean.getActivityZoneCount();
}
if(HIREGP.equals(fname)){
return bean.getHireGp();
}
if(GOLDCALL.equals(fname)){
return bean.getGoldCall();
}
if(LASTGOLDCALLTIME.equals(fname)){
return bean.getLastGoldCallTime();
}
if(DIAMONDCALL.equals(fname)){
return bean.getDiamondCall();
}
if(LASTDIAMONDCALLTIME.equals(fname)){
return bean.getLastDiamondCallTime();
}
if(MARTIALWAYCOUNT.equals(fname)){
return bean.getMartialWayCount();
}
if(MARTIALWAYBUYCOUNT.equals(fname)){
return bean.getMartialWayBuyCount();
}
if(BUYGOLDCOUNT.equals(fname)){
return bean.getBuyGoldCount();
}
if(BUYSTAMINACOUNT.equals(fname)){
return bean.getBuyStaminaCount();
}
if(SIGNINDAYS.equals(fname)){
return bean.getSigninDays();
}
if(FILLSIGNIN.equals(fname)){
return bean.getFillSignin();
}
if(SUMSIGNINDAYS.equals(fname)){
return bean.getSumSigninDays();
}
if(BLACKMARKETGOODS.equals(fname)){
return bean.getBlackMarketGoods();
}
if(BLACKMARKETREFCOUNT.equals(fname)){
return bean.getBlackMarketRefCount();
}
if(MALLTOTLEBUYCOUNT.equals(fname)){
return bean.getMallTotleBuyCount();
}
if(SLATEGAINTIME.equals(fname)){
return bean.getSlateGainTime();
}
if(TODAYEQUIPCOUNTLEVEL.equals(fname)){
return bean.getTodayEquipCountLevel();
}
if(TODAYHEROCOUNTLEVEL.equals(fname)){
return bean.getTodayHeroCountLevel();
}
if(EQUIPCOUNTLEVEL.equals(fname)){
return bean.getEquipCountLevel();
}
if(HEROCOUNTLEVEL.equals(fname)){
return bean.getHeroCountLevel();
}
if(ARENAFIGHTCOUNT.equals(fname)){
return bean.getArenaFightCount();
}
if(MARTIALWAYFIGHTCOUNT.equals(fname)){
return bean.getMartialwayFightCount();
}
if(ADDITEMCOUNT.equals(fname)){
return bean.getAddItemCount();
}
if(BREADSTORECOUNT.equals(fname)){
return bean.getBreadStoreCount();
}
if(GODWEALTHCOUNT.equals(fname)){
return bean.getGodWealthCount();
}
if(ANIMATEMPLECOUNT.equals(fname)){
return bean.getAnimaTempleCount();
}
if(BREADSTOREFREEREFRESHCOUNT.equals(fname)){
return bean.getBreadStoreFreeRefreshCount();
}
if(BREADSTOREDIAMONDREFRESHCOUNT.equals(fname)){
return bean.getBreadStoreDiamondRefreshCount();
}
if(BREADSTOREZONES.equals(fname)){
return bean.getBreadStoreZones();
}
if(FIRSTCALLHERO.equals(fname)){
return bean.isFirstCallHero();
}
if(CYCLECARDS.equals(fname)){
return bean.getCycleCards();
}
return null;
}
@Override
public Class getClazz(){
return com.ks.db.model.UserStat.class;
}
public final static class DBRowMapper_UserStat implements com.ks.access.mapper.RowMapper<com.ks.db.model.UserStat>{
@Override
public com.ks.db.model.UserStat rowMapper(java.sql.ResultSet rs) throws java.sql.SQLException{
com.ks.db.model.UserStat bean = new com.ks.db.model.UserStat();
bean.setUserId(rs.getInt("user_id"));
bean.setArenaCount(rs.getInt("arena_count"));
bean.setArenaBuyCount(rs.getInt("arena_buy_count"));
bean.setArenaRefreshCount(rs.getInt("arena_refresh_count"));
bean.setMallBuyCount(rs.getString("mall_buy_count"));
bean.setGivingFriend(rs.getString("giving_friend"));
bean.setExitGuildTime(rs.getTimestamp("exit_guild_time"));
bean.setCreateTime(rs.getTimestamp("create_time"));
bean.setUpdateTime(rs.getTimestamp("update_time"));
bean.setCollectStamina(rs.getInt("collect_stamina"));
bean.setDrawLoginAward(rs.getBoolean("draw_login_award"));
bean.setDrawVIPGifis(rs.getString("draw_vip_gifis"));
bean.setActivityZoneCount(rs.getString("activity_zone_count"));
bean.setHireGp(rs.getInt("hire_gp"));
bean.setGoldCall(rs.getInt("gold_call"));
bean.setLastGoldCallTime(rs.getTimestamp("last_gold_call_time"));
bean.setDiamondCall(rs.getInt("diamond_call"));
bean.setLastDiamondCallTime(rs.getTimestamp("last_diamond_call_time"));
bean.setMartialWayCount(rs.getByte("martial_way_count"));
bean.setMartialWayBuyCount(rs.getByte("martial_way_buy_count"));
bean.setBuyGoldCount(rs.getByte("buy_gold_count"));
bean.setBuyStaminaCount(rs.getByte("buy_stamina_count"));
bean.setSigninDays(rs.getString("signin_days"));
bean.setFillSignin(rs.getInt("fill_signin"));
bean.setSumSigninDays(rs.getString("sum_signin_days"));
bean.setBlackMarketGoods(rs.getString("black_market_goods"));
bean.setBlackMarketRefCount(rs.getInt("black_market_ref_count"));
bean.setMallTotleBuyCount(rs.getString("mall_totle_buy_count"));
bean.setSlateGainTime(rs.getTimestamp("slate_gain_time"));
bean.setTodayEquipCountLevel(rs.getInt("today_equip_count_level"));
bean.setTodayHeroCountLevel(rs.getInt("today_hero_count_level"));
bean.setEquipCountLevel(rs.getInt("equip_count_level"));
bean.setHeroCountLevel(rs.getInt("hero_count_level"));
bean.setArenaFightCount(rs.getInt("arena_fight_count"));
bean.setMartialwayFightCount(rs.getInt("martialway_fight_count"));
bean.setAddItemCount(rs.getInt("add_item_count"));
bean.setBreadStoreCount(rs.getInt("breadStoreCount"));
bean.setGodWealthCount(rs.getInt("godWealthCount"));
bean.setAnimaTempleCount(rs.getInt("animaTempleCount"));
bean.setBreadStoreFreeRefreshCount(rs.getInt("breadStoreFreeRefreshCount"));
bean.setBreadStoreDiamondRefreshCount(rs.getInt("breadStoreDiamondRefreshCount"));
bean.setBreadStoreZones(rs.getString("breadStoreZones"));
bean.setFirstCallHero(rs.getBoolean("firstCallHero"));
bean.setCycleCards(rs.getString("cycleCards"));
return bean;
}
}
}
