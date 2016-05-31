package com.ks.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.codehaus.jackson.type.TypeReference;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.model.user.AssStat;
import com.ks.model.user.BlackMarketGoods;
import com.ks.object.CycleCard;
import com.ks.util.JSONUtil;
import com.ks.util.StringUtil;
import com.ks.util.XyStringUtil;
import com.ks.util.XyTimeUtil;
/**
 * 用户统计
 * @author ks
 */
@DBBeanSet(tablename="t_user_stat", primaryKey={"user_id"})
@Data
public class UserStat implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet
	private int userId;
	/**竞技场挑战次数*/
	@DBFieldSet(dbfname="arena_count")
	@JedisFieldSet
	private int arenaCount;
	/**竞技场购买次数*/
	@DBFieldSet(dbfname="arena_buy_count")
	@JedisFieldSet
	private int arenaBuyCount;
	@DBFieldSet(dbfname="arena_refresh_count")
	@JedisFieldSet
	/**竞技场刷新次数*/
	private int arenaRefreshCount;
	/**商城购买*/
	@DBFieldSet(dbfname="mall_buy_count")
	@JedisFieldSet
	private String mallBuyCount;
	/**赠送过的好友*/
	@DBFieldSet(dbfname="giving_friend")
	@JedisFieldSet
	private String givingFriend;
	/**退出公会时间*/
	@DBFieldSet(dbfname="exit_guild_time")
	@JedisFieldSet
	private Date exitGuildTime = new Date();
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet
	private Date updateTime = new Date();
	/**收取的体力*/
	@DBFieldSet(dbfname="collect_stamina")
	@JedisFieldSet
	private int collectStamina;
	/**是否领取登录礼包*/
	@DBFieldSet(dbfname="draw_login_award")
	@JedisFieldSet
	private boolean drawLoginAward;
	/**领取VIP礼包*/
	@DBFieldSet(dbfname="draw_vip_gifis")
	@JedisFieldSet
	private String drawVIPGifis;
	/**活动副本胜利次数*/
	@DBFieldSet(dbfname="activity_zone_count")
	@JedisFieldSet
	private String activityZoneCount;
	/**雇佣GP*/
	@DBFieldSet(dbfname="hire_gp")
	@JedisFieldSet
	private int hireGp;
	/**免费金币召唤*/
	@DBFieldSet(dbfname="gold_call")
	@JedisFieldSet
	private int goldCall;
	/**最后金币召唤时间*/
	@DBFieldSet(dbfname="last_gold_call_time")
	@JedisFieldSet
	private Date lastGoldCallTime = new Date();
	/**免费钻石召唤*/
	@DBFieldSet(dbfname="diamond_call")
	@JedisFieldSet
	private int diamondCall;
	/**最后钻石召唤时间*/
	@DBFieldSet(dbfname="last_diamond_call_time")
	@JedisFieldSet
	private Date lastDiamondCallTime = new Date();
	/**武道大会次数*/
	@DBFieldSet(dbfname="martial_way_count")
	@JedisFieldSet
	private byte martialWayCount;
	/**武道大会购买次数*/
	@DBFieldSet(dbfname="martial_way_buy_count")
	@JedisFieldSet
	private byte martialWayBuyCount;
	/**购买金币次数*/
	@DBFieldSet(dbfname="buy_gold_count")
	@JedisFieldSet
	private byte buyGoldCount;
	/**购买体力次数*/
	@DBFieldSet(dbfname="buy_stamina_count")
	@JedisFieldSet
	private byte buyStaminaCount;
//	/**签到月份*/
//	@DBFieldSet(dbfname="signin_month")
//	private byte signinMonth;
	/**签到天数*/
	@DBFieldSet(dbfname="signin_days")
	@JedisFieldSet
	private String signinDays;
	/**补签次数*/
	@DBFieldSet(dbfname="fill_signin")
	@JedisFieldSet
	private int fillSignin;
	/**累计签到奖励领取*/
	@DBFieldSet(dbfname="sum_signin_days")
	@JedisFieldSet
	private String sumSigninDays;
	/**上一次黑市自动刷新时间*/
	@DBFieldSet(dbfname="last_black_refresh_time")
	@JedisFieldSet
	private int lastBlackRefreshTime;
	/**黑市道具*/
	@DBFieldSet(dbfname="black_market_goods")
	@JedisFieldSet
	private String blackMarketGoods;
	/**黑市刷新次数*/
	@DBFieldSet(dbfname="black_market_ref_count")
	@JedisFieldSet
	private int blackMarketRefCount;
	/**商城购买*/
	@DBFieldSet(dbfname="mall_totle_buy_count")
	@JedisFieldSet
	private String mallTotleBuyCount;
	/**领取石板时间*/
	@DBFieldSet(dbfname="slate_gain_time")
	@JedisFieldSet
	private Date slateGainTime = new Date();
	/**今日装备累计提升等级*/
	@DBFieldSet(dbfname="today_equip_count_level")
	@JedisFieldSet
	private int todayEquipCountLevel;
	/**今日伙伴累计提升等级*/
	@DBFieldSet(dbfname="today_hero_count_level")
	@JedisFieldSet
	private int todayHeroCountLevel;
	/**装备累计提升等级*/
	@DBFieldSet(dbfname="equip_count_level")
	@JedisFieldSet
	private int equipCountLevel;
	/**伙伴累计提升等级*/
	@DBFieldSet(dbfname="hero_count_level")
	@JedisFieldSet
	private int heroCountLevel;
	/**累计竞技场挑战次数*/
	@DBFieldSet(dbfname="arena_fight_count")
	@JedisFieldSet
	private int arenaFightCount;
	/**累计武道大会挑战次数*/
	@DBFieldSet(dbfname="martialway_fight_count")
	@JedisFieldSet
	private int martialwayFightCount;
	/**累计获得道具数量*/
	@DBFieldSet(dbfname="add_item_count")
	@JedisFieldSet
	private int addItemCount;
	/**包子铺已参加次数*/
	@DBFieldSet(dbfname="breadStoreCount")
	@JedisFieldSet
	private int breadStoreCount;
	/**财神殿已参加次数*/
	@DBFieldSet(dbfname="godWealthCount")
	@JedisFieldSet
	private int godWealthCount;
	/**灵气殿已参加次数*/
	@DBFieldSet(dbfname="animaTempleCount")
	@JedisFieldSet
	private int animaTempleCount;
	/**包子铺免费已刷新次数*/
	@DBFieldSet(dbfname="breadStoreFreeRefreshCount")
	@JedisFieldSet
	private int breadStoreFreeRefreshCount;
	/**包子铺钻石已刷新次数*/
	@DBFieldSet(dbfname="breadStoreDiamondRefreshCount")
	@JedisFieldSet
	private int breadStoreDiamondRefreshCount;
	/**包子铺副本*/
	@DBFieldSet(dbfname="breadStoreZones")
	@JedisFieldSet
	private String breadStoreZones = "";
	/**是否已首次召唤*/
	@DBFieldSet(dbfname="firstCallHero")
	@JedisFieldSet
	private boolean firstCallHero;
	/**周期卡*/
	@DBFieldSet(dbfname="cycleCards")
	@JedisFieldSet
	private String cycleCards = "";
	
	private List<AssStat> mallBuyCountList = new ArrayList<AssStat>();
	private List<Integer> givingFriendList = new ArrayList<Integer>();
	private List<Integer> drawVIPGifisList = new ArrayList<Integer>();
	private List<AssStat> activityZoneCountList = new ArrayList<AssStat>();
	private List<Integer> signinDaysList = new ArrayList<Integer>();
	private List<Integer> sumSigninDaysList = new ArrayList<Integer>();
	private List<BlackMarketGoods> blackMarketGoodsList = new ArrayList<BlackMarketGoods>();
	private List<AssStat> mallTotleBuyCountList = new ArrayList<AssStat>();
	private Map<Integer, CycleCard> cycleCardMap;

	public UserStat() {
		super();
	}
	
	public static final UserStat createUserStat(int userId){
		UserStat stat = new UserStat();
		stat.setUserId(userId);
		stat.setArenaCount(SystemConstant.ARENA_DAILY_NUMBER);
		stat.setMallBuyCountList(new ArrayList<AssStat>());
		stat.setGivingFriendList(new ArrayList<Integer>());
		stat.setExitGuildTime(new Date(System.currentTimeMillis()-(25*60*60*1000L)));
		stat.setCreateTime(new Date());
		stat.setUpdateTime(new Date());
		stat.setDrawVIPGifisList(new ArrayList<Integer>());
		stat.setActivityZoneCountList(new ArrayList<AssStat>());
		stat.lastGoldCallTime = XyTimeUtil.parse("1979-01-01 00:00:00", XyTimeUtil.yyyy_MM_dd_HH_mm_ss1);
		stat.lastDiamondCallTime = XyTimeUtil.parse("1979-01-01 00:00:00", XyTimeUtil.yyyy_MM_dd_HH_mm_ss1);
		stat.signinDaysList = new ArrayList<Integer>();
		stat.sumSigninDaysList = new ArrayList<Integer>();
		stat.blackMarketGoodsList = new ArrayList<BlackMarketGoods>();
		stat.blackMarketRefCount=0;
		stat.mallTotleBuyCountList = new ArrayList<AssStat>();
		stat.slateGainTime = new Date();
		stat.cycleCardMap = new HashMap<Integer, CycleCard>();
		stat.setFirstCallHero(true);
		return stat;
	}
	
	
	private void initMallBuyCountList(){
		mallBuyCountList = JSONUtil.toObject(mallBuyCount, new TypeReference<List<AssStat>>(){});
	}
	private void initMallBuyCount(){
		mallBuyCount = JSONUtil.toJson(mallBuyCountList);
	}
	public String getMallBuyCount() {
		initMallBuyCount();
		return mallBuyCount;
	}
	public void setMallBuyCount(String mallBuyCount) {
		this.mallBuyCount = mallBuyCount;
		initMallBuyCountList();
	}
	
	private void initGivingFriendList(){
		givingFriendList = StringUtil.stringToList(givingFriend);
	}
	private void initGivingFriend(){
		givingFriend = StringUtil.listToString(givingFriendList);
	}
	public String getGivingFriend() {
		initGivingFriend();
		return givingFriend;
	}
	public void setGivingFriend(String givingFriend) {
		this.givingFriend = givingFriend;
		initGivingFriendList();
	}
	
	private void initDrawVIPGifisList(){
		drawVIPGifisList = StringUtil.stringToList(drawVIPGifis);
	}
	private void initDrawVIPGifis(){
		drawVIPGifis = StringUtil.listToString(drawVIPGifisList);
	}
	public String getDrawVIPGifis() {
		initDrawVIPGifis();
		return drawVIPGifis;
	}
	public void setDrawVIPGifis(String drawVIPGifis) {
		this.drawVIPGifis = drawVIPGifis;
		initDrawVIPGifisList();
	}
	
	private void initActivityZoneCountList(){
		activityZoneCountList = JSONUtil.toObject(activityZoneCount, new TypeReference<List<AssStat>>(){});
	}
	private void initActivityZoneCount(){
		activityZoneCount = JSONUtil.toJson(activityZoneCountList);
	}
	public String getActivityZoneCount() {
		initActivityZoneCount();
		return activityZoneCount;
	}
	public void setActivityZoneCount(String activityZoneCount) {
		this.activityZoneCount = activityZoneCount;
		initActivityZoneCountList();
	}
	
	private void initSigninDaysList(){
		signinDaysList = StringUtil.stringToList(signinDays);
	}
	private void initSigninDays(){
		signinDays = StringUtil.listToString(signinDaysList);
	}
	public String getSigninDays() {
		initSigninDays();
		return signinDays;
	}
	public void setSigninDays(String signinDays) {
		this.signinDays = signinDays;
		initSigninDaysList();
	}
	
	private void initSumSigninDaysList(){
		sumSigninDaysList = StringUtil.stringToList(sumSigninDays);
	}
	private void initSumSigninDays(){
		sumSigninDays = StringUtil.listToString(sumSigninDaysList);
	}
	public String getSumSigninDays() {
		initSumSigninDays();
		return sumSigninDays;
	}
	public void setSumSigninDays(String sumSigninDays) {
		this.sumSigninDays = sumSigninDays;
		initSumSigninDaysList();
	}
	
	private void initBlackMarketGoodsList(){
		blackMarketGoodsList = JSONUtil.toObject(blackMarketGoods, new TypeReference<List<BlackMarketGoods>>(){});
	}
	private void initBlackMarketGoods(){
		blackMarketGoods = JSONUtil.toJson(blackMarketGoodsList);
	}
	public String getBlackMarketGoods() {
		initBlackMarketGoods();
		return blackMarketGoods;
	}
	public void setBlackMarketGoods(String blackMarketGoods) {
		this.blackMarketGoods = blackMarketGoods;
		initBlackMarketGoodsList();
	}
	
	private void initMallTotleBuyCountList(){
		mallTotleBuyCountList = JSONUtil.toObject(mallTotleBuyCount, new TypeReference<List<AssStat>>(){});
	}
	private void initMallTotleBuyCount(){
		mallTotleBuyCount = JSONUtil.toJson(mallTotleBuyCountList);
	}
	public String getMallTotleBuyCount() {
		initMallTotleBuyCount();
		return mallTotleBuyCount;
	}
	public void setMallTotleBuyCount(String mallTotleBuyCount) {
		this.mallTotleBuyCount = mallTotleBuyCount;
		initMallTotleBuyCountList();
	}
	
	public List<Integer> getBreadStoreZoneIds(){
		return XyStringUtil.parseList(breadStoreZones, XyStringUtil.SPLIT_UNDERLINE);
	}
	public void setCycleCards(String cycleCards){
		this.cycleCards = cycleCards;
		initCycleCardMap();
	}
	public String getCycleCards(){
		initCycleCards();
		return cycleCards;
	}
	private void initCycleCardMap(){
		cycleCardMap = new HashMap<Integer, CycleCard>();
		if(cycleCards.length() > 0){
			List<List<Integer>> lists = XyStringUtil.parseLists(cycleCards, XyStringUtil.SPLIT_VERTICALLINE, XyStringUtil.SPLIT_UNDERLINE);
			for(List<Integer> list : lists){
				if(list.size() >= 3){
					cycleCardMap.put(list.get(0), new CycleCard(list));
				}
			}
		}
	}
	private void initCycleCards(){
		if(cycleCardMap != null && !cycleCardMap.isEmpty()){
			List<List<Integer>> lists = new ArrayList<>();
			for(CycleCard card : cycleCardMap.values()){
				List<Integer> list = new ArrayList<>();
				list.add(card.getPayId());
				list.add(card.getEndTime());
				list.add(card.getReceiveTime());
				lists.add(list);
			}
			this.cycleCards = XyStringUtil.parseString(lists, XyStringUtil.JOIN_VERTICALLINE, XyStringUtil.JOIN_UNDERLINE);
		}
	}
	public CycleCard getCycleCard(int payId){
		return cycleCardMap.get(payId);
	}
	
	/**
	 * 是否拥有指定类型的周期卡
	 * @param payId
	 * @return
	 */
	public boolean hasCycleCard(int payId){
		CycleCard card = getCycleCard(payId);
		return card != null && !card.isOutTime();
	}
	
	/**
	 * 是否拥有月卡
	 * @param payId
	 * @return
	 */
	public boolean isMonthCardUser(){
		return hasCycleCard(SystemConstant.PAY_MONTH_CARD_ID);
	}
	
	/**
	 * 是否拥有周卡
	 * @param payId
	 * @return
	 */
	public boolean isWeekCardUser(){
		return hasCycleCard(SystemConstant.PAY_WEEK_CARD);
	}
	
	/**
	 * 是否有武道大会次数
	 */
	public boolean hasMartialWayNum(){
		return martialWayCount < SystemConstant.MARTIAL_WAY_BUY_GAIN_NUMBER * martialWayBuyCount + SystemConstant.MARTIAL_WAY_DAILY_NUMBER;
	}
}
