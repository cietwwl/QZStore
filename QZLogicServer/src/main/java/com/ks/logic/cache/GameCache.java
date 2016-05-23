package com.ks.logic.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ks.db.cfg.Achieve;
import com.ks.db.cfg.AchieveAward;
import com.ks.db.cfg.ActivityZone;
import com.ks.db.cfg.ArenaAward;
import com.ks.db.cfg.ArenaBuy;
import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.BlowingRule;
import com.ks.db.cfg.BreadStoreRule;
import com.ks.db.cfg.CallHeroRule;
import com.ks.db.cfg.CommonRewardConfig;
import com.ks.db.cfg.ConstantConfig;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentProperty;
import com.ks.db.cfg.EquipmentUp;
import com.ks.db.cfg.EquipmentUpRate;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalProperty;
import com.ks.db.cfg.ExploreAward;
import com.ks.db.cfg.Fame;
import com.ks.db.cfg.FameBuff;
import com.ks.db.cfg.GuildRankAward;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroBreakAttrSetting;
import com.ks.db.cfg.HeroBreakSetting;
import com.ks.db.cfg.HeroEvo;
import com.ks.db.cfg.HeroRelation;
import com.ks.db.cfg.HeroRule;
import com.ks.db.cfg.Mall;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.PassiveSkill;
import com.ks.db.cfg.PayGoods;
import com.ks.db.cfg.PeriodActivityTime;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.Signin;
import com.ks.db.cfg.Skill;
import com.ks.db.cfg.SumSignin;
import com.ks.db.cfg.TaskActionSetting;
import com.ks.db.cfg.TaskBoxReward;
import com.ks.db.cfg.TaskReward;
import com.ks.db.cfg.TaskSetting;
import com.ks.db.cfg.UserRule;
import com.ks.db.cfg.VipConfig;
import com.ks.db.cfg.Zone;
import com.ks.db.cfg.ZoneAward;
import com.ks.db.cfg.ZoneBattle;
import com.ks.db.model.Goods;
import com.ks.db.model.UserTeam;
import com.ks.exceptions.GameException;


/**
 * 游戏缓存
 * @author ks
 */
public class GameCache {
	/**游戏配置缓存*/
	private static LoadCache instance;
	
	/**英雄*/
	protected Map<Integer,Hero> heros;
	/**怪物*/
	protected Map<Integer,Monster> monsters;
	/**用户规则*/
	protected Map<Integer,UserRule> userRules;
	/**战魂规则*/
	protected Map<Integer,HeroRule> heroRules;
	/**英雄进化(key=heroId)*/
	protected Map<Integer, HeroEvo> heroEvos;
	/**召唤战魂规则 key=type value=召唤规则*/
	protected Map<Integer,List<CallHeroRule>> callHeroRules;
	/**副本*/
	protected Map<Integer,Zone> zones;
	/**副本最高关卡id*/
	protected Map<Integer,Integer> zonesMaxBattles;
	/**副本战场*/
	protected Map<Integer,ZoneBattle> zoneBattles;
	/**副本战场*/
	protected Map<Integer, List<ZoneBattle>> zoneBattleByZoneIdMap;
	/**战场回合数*/
	protected Map<Integer,Map<Integer,BattleRound>> battleRounds;
	/**所有技能*/
	protected Map<Integer,Map<Integer,Skill>> skills;
	/**公会排名奖励*/
	protected Map<Integer,List<GuildRankAward>> guildRankAwards;
	/**道具*/
	protected Map<Integer,Prop> props;
	/**探索奖励*/
	protected Map<Integer,List<ExploreAward>> exploreAwards;
	/**成就*/
	protected Map<Integer,Achieve> achieves;
	/**成就分类 key=成就编号，value=[key=关联编号,value=成就数组]*/
	protected Map<Integer,Map<Integer,List<Achieve>>> achievesTypeMap;
	/**成就奖励*/
	protected Map<Integer,List<AchieveAward>> achieveAwards;
	/**活动副本*/
	protected Map<Integer,ActivityZone> activityZone;
	/**英雄关联*/
	protected Map<Integer,List<HeroRelation>> heroRelations;
	/**装备*/
	protected Map<Integer,Equipment> equipments;
	/**装备*/
	protected Map<Integer,EquipmentUpRate> equipmentUpRates;
	/**装备*/
	protected Map<Integer,List<EquipmentUp>> equipmentUps;
	/**装备*/
	protected Map<Integer,List<EquipmentProperty>> equipmentPropertys;
	/**开炉规则*/
	protected Map<Integer,List<BlowingRule>> blowingRules;
	/**武魂*/
	protected Map<Integer,Eternal> eternals;
	/**被动技能*/
	protected Map<Integer,PassiveSkill>PASSIVE_SKILLS;
	
	/**武魂基础属性池*/
	protected Map<Integer,List<EternalProperty>> eternalBsis;
	
	/**武魂附加属性池*/
	protected Map<Integer,List<EternalProperty>> eternalAppends;
	
	/**商场奖励池*/
	protected Map<Integer,List<ArenaAward>> arenaAwards;
	/**商场奖励池*/
	protected Map<Integer,Integer> arenaExpAward;
	/**副本奖励*/
	protected Map<Integer,Map<Integer,List<ZoneAward>>> zoneAwards;
	/**商场奖励池*/
	protected Map<Integer,Integer> martiaWayExpAward;
	/**签到奖励*/
	protected Map<Integer,Signin> sgnins;
	/**签到奖励*/
	protected Map<Integer,List<SumSignin>> sumSignins;
	/**商城*/
	protected Map<Integer,Mall> malls;
	/**黑市*/
	protected Map<Integer,List<Mall>> blackMarketMall;
	/**名望*/
	protected Map<Integer,Fame> fames;
	/**名望奖励*/
	protected Map<Integer,List<Goods>> fameAward;
	/**名望BUFF*/
	protected Map<Integer,List<FameBuff>> fameBuffs;
	/**任务表*/
	protected Map<Integer, TaskSetting> taskSettingMap;
	/**任务表配置表*/
	protected Map<Integer, TaskActionSetting> taskActionSettingMap;
	/**任务奖励配置表*/
	protected Map<Integer, List<TaskReward>> taskRewadsMap;
	/**活跃度宝箱奖励配置表<活跃度值,所有奖励>*/
	protected Map<Integer, List<TaskBoxReward>> taskBoxRewadsMap;
	/**英雄突破配置表<组id,<突破等级,<灵元槽位, 突破配置>>>*/
	protected Map<Integer, Map<Integer, Map<Integer, HeroBreakSetting>>> heroBreakMap;
	/**英雄突破配置表<组id,<突破等级,<灵元槽位, 突破属性配置>>>*/
	protected Map<Integer, Map<Integer, Map<Integer, HeroBreakAttrSetting>>> heroBreakAttrMap;
	/**vip*/
	protected Map<Integer, VipConfig> vipConfigMap;
	/**周期活动时间*/
	protected Map<Integer, PeriodActivityTime> periodActivityTimeMap; 
	/**包子铺随机规则*/
	protected List<BreadStoreRule> breadStoreRuleList;
	/**通用奖励*/
	protected Map<Integer, CommonRewardConfig> commonRewardConfigMap;
	/**通用奖励*/
	protected Map<Integer, Map<Integer, CommonRewardConfig>> commonRewardConfigTypeMap;
	/**支付商品*/
	protected Map<Integer, PayGoods> payGoodsMap;
	/**常数配置*/
	protected Map<String, ConstantConfig> constantConfigMap;
	/**竞技场购买次数*/
	protected Map<Integer, ArenaBuy> arenaBuyMap;
	
	public static void init() throws Exception{
		instance = new LoadCache();
		instance.load();
	}
	
	public static int loadCache(){
		int code = GameException.CODE_正常;
		LoadCache cache = new LoadCache();
		try{
			cache.load();
			instance = cache;
		}catch(Exception e){
			code = GameException.CODE_缓存加载失败;
			e.printStackTrace();
		}
		return code;
	}
	
	
	//TODO get分界线
	/**
	 * 获得英雄
	 * @param heroId 英雄编号
	 * @return 英雄
	 */
	public static Hero getHero(int heroId){
		return instance.heros.get(heroId);
	}
	/**
	 * 获得怪物
	 * @param monsterId 怪物编号
	 * @return 怪物
	 */
	public static Monster getMonster(int monsterId){
		return instance.monsters.get(monsterId);
	}
	/**
	 * 获得用户规则
	 * @param level 等级
	 * @return 用户规则
	 */
	public static UserRule getUserRule(int level){
		return instance.userRules.get(level);
	}
	/**
	 * 获得英雄规则
	 * @param level 等级
	 * @return 英雄规则
	 */
	public static HeroRule getHeroRule(int level){
		return instance.heroRules.get(level);
	}
	/**
	 * 获取伙伴进化规则
	 * @param heroId 进化伙伴编号
	 * @return 战魂进化规则
	 */
	public static HeroEvo getHeroEvo(int heroId){
		return instance.heroEvos.get(heroId);
	}
	/**
	 * 获得召唤规则
	 * @param type 召唤类型
	 * @return 召唤规则
	 */
	public static List<CallHeroRule> getCallHeroRule(int type){
		return instance.callHeroRules.get(type);
	}
	/**
	 * 获得副本
	 * @param zoneId 副本编号
	 * @return 副本
	 */
	public static Zone getZone(int zoneId){
		return instance.zones.get(zoneId);
	}
	/**
	 * 获得副本战场
	 * @param battleId 战场编号
	 * @return 副本战场
	 */
	public static ZoneBattle getZoneBattle(int battleId){
		return instance.zoneBattles.get(battleId);
	}
	
	public static List<ZoneBattle> getZoneBattles(int zoneId){
		List<ZoneBattle> zones = new ArrayList<>();
		List<ZoneBattle> list = instance.zoneBattleByZoneIdMap.get(zoneId);
		if(list != null){
			zones.addAll(list);
		}
		return zones;
	}
	
	/**
	 * 获取章节最高关卡id
	 * @param zoneId
	 * @return
	 */
	public static int getZoneMaxBattleId(int zoneId){
		return instance.zonesMaxBattles.get(zoneId);
	}
	
	/**
	 * 获取战场回合
	 * @param battleId 战场编号
	 * @param roundId 战场回合编号
	 * @return 战场回合
	 */
	public static BattleRound getBattleRound(int battleId,int roundId){
		Map<Integer, BattleRound> map = instance.battleRounds.get(battleId);
		if(map == null){
			throw new GameException(GameException.CODE_参数错误, "");
		}
		return map.get(roundId);
	}
	/**
	 * 获得技能
	 * @param skillId 技能编号
	 * @param lv 技能等级
	 * @return 技能
	 */
	public static Skill getSkill(int skillId,int lv){
		return instance.skills.get(skillId).get(lv);
	}
	/**
	 * 获得排名奖励
	 * @param rank 排名
	 * @return 排名奖励
	 */
	public static List<GuildRankAward> getGuildRankAwards(int rank){
		return instance.guildRankAwards.get(rank);
	}
	/**
	 * 获得道具
	 * @param propId 道具编号
	 * @return 道具
	 */
	public static Prop getProp(int propId){
		return instance.props.get(propId);
	}
	
	/**
	 * 获得探索奖励
	 * @param arrayId 数组编号
	 * @return 探索奖励
	 */
	public static List<ExploreAward> getExploreAward(int arrayId){
		return instance.exploreAwards.get(arrayId);
	}
	/**
	 * 获得成就
	 * @param achieveId 成就编号
	 * @return 成就
	 */
	public static Achieve getAchieve(int achieveId){
		return instance.achieves.get(achieveId);
	}
	/**
	 * 获得第一个成就
	 * @param type 类型
	 * @param assId 关联编号
	 * @return 第一个成就
	 */
	public static Achieve getFristAchieve(int type,int assId){
		return instance.achievesTypeMap.get(type).get(assId).get(0);
	}
	/**
	 * 获得下一个成就
	 * @param achieveId 成就编号
	 * @return 成就
	 */
	public static Achieve getNextAchieve(int achieveId){
		Achieve achieve = instance.achieves.get(achieveId);
		List<Achieve> as = instance.achievesTypeMap.get(achieve.getType()).get(achieve.getAssId());
		int index = as.indexOf(achieve);
		if(index >=as.size()-1){
			return null;
		}
		return as.get(index+1); 
	}
	/**
	 * 获得成就奖励
	 * @param achieveId 成就编号
	 * @return 成就奖励
	 */
	public static List<AchieveAward> getAchieveAward(int achieveId){
		return instance.achieveAwards.get(achieveId);
	}
	
	/**
	 * 获得获得副本
	 * @param zoneId 活动副本编号
	 * @return 获得副本
	 */
	public static ActivityZone getActivityZone(int zoneId){
		return instance.activityZone.get(zoneId);
	}
	/**
	 * 获得所有活动副本
	 * @return 所有活动副本
	 */
	public static Collection<ActivityZone> getActivityZones(){
		return instance.activityZone.values();
	}
	
	public static Collection<Hero> getHeros(){
		return instance.heros.values();
	}
	
	public static List<HeroRelation> getHeroRelation(int heroId){
		return instance.heroRelations.get(heroId);
	}
	/**
	 * 获得装备
	 * @param equipmentId 装备编号
	 * @return 装备
	 */
	public static Equipment getEquipment(int equipmentId){
		return instance.equipments.get(equipmentId);
	}
	
	public static Collection<Equipment> getEquipments(){
		return instance.equipments.values();
	}
	
	/**
	 * 获得开炉规则
	 * @param type 类型
	 * @return 开炉规则
	 */
	public static List<BlowingRule> queryBlowingRule(int type){
		return instance.blowingRules.get(type);
	}
	/**
	 * 获得武魂
	 * @param eternalId 武魂编号
	 * @return 武魂
	 */
	public static Eternal getEternal(int eternalId){
		return instance.eternals.get(eternalId);
	}
	/**
	 * 获得升级消耗的物品
	 * 
	 * @param level 装备等级
	 * @return
	 */
	public static List<EquipmentUp> getEquipmentUps(int level){
		return instance.equipmentUps.get(level);
	}
	/**
	 * 获得装备升级成功概率
	 * 
	 * @param level 装备等级 
	 * @return
	 */
	public static EquipmentUpRate getEquipmentUpRate(int level){
		return instance.equipmentUpRates.get(level);
	}
	
	/**
	 * 获得装备附加属性
	 * 
	 * @param quality 装备星级
	 * @return
	 */
	public static List<EquipmentProperty> getEquipmentProperty(int quality){
		return instance.equipmentPropertys.get(quality);
	}
	public static PassiveSkill getPassiveSkill(int passiveSkillId){
		return instance.PASSIVE_SKILLS.get(passiveSkillId);
	}
	/**
	 * 获得基础属性
	 * @param quality
	 * @return
	 */
	public static List<EternalProperty> getetErnalBsisProperty(int quality){
		return instance.eternalBsis.get(quality);
	}
	/**
	 * 获得附加属性
	 * @param quality
	 * @return
	 */
	public static List<EternalProperty> getetErnalAppendsProperty(int quality){
		return instance.eternalAppends.get(quality);
	}
	public static List<ArenaAward> getShoppingAward(int shoppingId){
		return instance.arenaAwards.get(shoppingId);
	}
	public static int getArenaExpAward(int level){
		return instance.arenaExpAward.get(level);
		
	}
	
	public static List<ZoneAward> getZoneAwards(int zoneId,int star){
		return instance.zoneAwards.get(zoneId).get(star);
	}
	
	public static Signin getSignin(int day){
		return instance.sgnins.get(day);
	}
	public static List<SumSignin> getSumSignin(int sumDay){
		return instance.sumSignins.get(sumDay);
	}
	
	public static UserTeam getUserTeam(int userId){
		Map<Integer,UserTeam> map=new HashMap<Integer, UserTeam>();
		UserTeam ut1=new UserTeam();
		List<Integer> heros1=new ArrayList<Integer>();
		UserTeam ut2=new UserTeam();
		List<Integer> heros2=new ArrayList<Integer>();
		
		UserTeam ut3=new UserTeam();
		List<Integer> heros3=new ArrayList<Integer>();
		heros1.add(82003);
		heros1.add(0);
		heros1.add(0);
		heros1.add(0);
		heros2.add(82024);
		heros2.add(0);
		heros2.add(0);
		heros2.add(0);
		
		heros3.add(82028);
		heros3.add(82033);
		heros3.add(82034);
		heros3.add(82029);
		List<Integer> pos=new ArrayList<Integer>();
		pos.add(0);
		pos.add(1);
		pos.add(2);
		pos.add(3);
		ut1.setUserId(-1);
		ut1.setHeroList(heros1);
		ut1.setPosList(pos);
		map.put(-1, ut1);
		
		ut2.setUserId(-2);
		ut2.setHeroList(heros2);
		ut2.setPosList(pos);
		map.put(-2, ut2);
		
		ut3.setUserId(-3);
		ut3.setHeroList(heros3);
		ut3.setPosList(pos);
		map.put(-3, ut3);
		
		return map.get(userId);
	}
	public static int getMartialWayExpAward(int level){
		return instance.martiaWayExpAward.get(level);
		
	}
	
	public static Mall getMall(int mallId){
		return instance.malls.get(mallId);
	}
	
	public static Map<Integer,List<Mall>> getBlackMarketMalls(){
		return instance.blackMarketMall;
	}
	
	public static Collection<Mall> getMall(){
		return instance.malls.values();
	}
	
	public static Fame getFame(int fameLevel){
		return instance.fames.get(fameLevel);
	}
	
	public static List<Goods> getFameAward(int fameLevel){
		return instance.fameAward.get(fameLevel);
	}
	
	public static List<FameBuff> getFameBuffs(int fameLevel){
		return instance.fameBuffs.get(fameLevel);
	}
	
	public static TaskSetting getTaskSetting(int id){
		return instance.taskSettingMap.get(id);
	}
	
	public static List<TaskReward> getTaskRewards(int taskId){
		return instance.taskRewadsMap.get(taskId);
	}
	
	public static List<TaskBoxReward> getTaskBoxRewards(int active){
		return instance.taskBoxRewadsMap.get(active);
	}
	
	public static Map<Integer, HeroBreakSetting> getHeroBreakMap(int groupId, int breakLevel){
		Map<Integer, Map<Integer, HeroBreakSetting>> map = instance.heroBreakMap.get(groupId);
		if(map != null){
			return map.get(breakLevel);
		}
		return null;
	}
	
	public static Map<Integer, HeroBreakAttrSetting> getHeroBreakAttrMap(int groupId, int breakLevel){
		Map<Integer, Map<Integer, HeroBreakAttrSetting>> map = instance.heroBreakAttrMap.get(groupId);
		if(map != null){
			return map.get(breakLevel);
		}
		return null;
	}
	
	public static VipConfig getVipConfig(int vipLevel){
		return instance.vipConfigMap.get(vipLevel);
	}
	public static VipConfig getVipConfigByMoney(int money){
		VipConfig vip = null;
		for(VipConfig config : instance.vipConfigMap.values()){
			if(config.getMoney() <= money){
				if(vip == null || config.getMoney() > vip.getMoney()){
					vip = config;
				}
			}
		}
		return vip;
	}
	public static PeriodActivityTime getPeriodActivityTime(int type){
		return instance.periodActivityTimeMap.get(type);
	}
	public static BreadStoreRule getBreadStoreRule(int level){
		for(BreadStoreRule rule : instance.breadStoreRuleList){
			if(rule.hasLevel(level)){
				return rule;
			}
		}
		return null;
	}
	public static CommonRewardConfig getCommonRewardConfig(int id){
		return instance.commonRewardConfigMap.get(id);
	}
	public static List<CommonRewardConfig> getCommonRewardConfigs(int type){
		List<CommonRewardConfig> configs = new ArrayList<>();
		Map<Integer, CommonRewardConfig> map = instance.commonRewardConfigTypeMap.get(type);
		if(map != null){
			configs.addAll(map.values());
		}
		return configs;
	}
	public static PayGoods getPayGoods(int id){
		return instance.payGoodsMap.get(id);
	}
	public static ConstantConfig getConstanConfig(String name){
		return instance.constantConfigMap.get(name);
	}
	public static ArenaBuy getArenaBuy(int count){
		ArenaBuy target = instance.arenaBuyMap.get(count);
		if(target == null){
			for(ArenaBuy buy : instance.arenaBuyMap.values()){
				if(target == null || target.getCount() < buy.getCount()){
					target = buy;
				}
			}
		}
		return target;
	}
	
	
}
