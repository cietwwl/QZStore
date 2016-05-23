package com.ks.logic.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Achieve;
import com.ks.db.cfg.AchieveAward;
import com.ks.db.cfg.ActivityZone;
import com.ks.db.cfg.ArenaAward;
import com.ks.db.cfg.ArenaBuy;
import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.BlowingRule;
import com.ks.db.cfg.CallHero;
import com.ks.db.cfg.CallHeroRule;
import com.ks.db.cfg.CommonRewardConfig;
import com.ks.db.cfg.ConstantConfig;
import com.ks.db.cfg.Drop;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.EquipmentProperty;
import com.ks.db.cfg.EquipmentUp;
import com.ks.db.cfg.EquipmentUpRate;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalEffect;
import com.ks.db.cfg.EternalProperty;
import com.ks.db.cfg.ExploreAward;
import com.ks.db.cfg.Fame;
import com.ks.db.cfg.FameAward;
import com.ks.db.cfg.FameBuff;
import com.ks.db.cfg.GuildRankAward;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroBreakAttrSetting;
import com.ks.db.cfg.HeroBreakSetting;
import com.ks.db.cfg.HeroEvo;
import com.ks.db.cfg.HeroEvoMaterial;
import com.ks.db.cfg.HeroRelation;
import com.ks.db.cfg.HeroRule;
import com.ks.db.cfg.Mall;
import com.ks.db.cfg.MallGoods;
import com.ks.db.cfg.MartialWayAwardExp;
import com.ks.db.cfg.Monster;
import com.ks.db.cfg.MonsterAtkMode;
import com.ks.db.cfg.PassiveSkill;
import com.ks.db.cfg.PayGoods;
import com.ks.db.cfg.PeriodActivityTime;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.PropEffect;
import com.ks.db.cfg.Signin;
import com.ks.db.cfg.Skill;
import com.ks.db.cfg.SkillEffect;
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
import com.ks.exceptions.GameException;
import com.ks.logic.service.AchieveService;
import com.ks.logic.service.ActivityService;
import com.ks.logic.service.ActivityZoneService;
import com.ks.logic.service.ArenaService;
import com.ks.logic.service.CommonRewardService;
import com.ks.logic.service.ConstantService;
import com.ks.logic.service.EquipmentService;
import com.ks.logic.service.EternalService;
import com.ks.logic.service.FameService;
import com.ks.logic.service.GuildService;
import com.ks.logic.service.HeroBreakService;
import com.ks.logic.service.HeroService;
import com.ks.logic.service.MallService;
import com.ks.logic.service.MartialWayService;
import com.ks.logic.service.MonsterService;
import com.ks.logic.service.PropService;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.SigninService;
import com.ks.logic.service.SkillService;
import com.ks.logic.service.TaskService;
import com.ks.logic.service.UserService;
import com.ks.logic.service.VIPService;
import com.ks.logic.service.ZoneService;
import com.ks.object.Privileges;

public class LoadCache extends GameCache{
	
	public void load()throws Exception{
		initConstantConfigs();
		initUserRules();
		initBlowingRule();
		initProps();
		initHeros();
		initHeroRules();
		initCallHeroRules();
		initHeroRelation();
		initHeroBreak();
		initheroEvos();
		initMonsters();
		initZones();
		initZoneBattles();
		initBattleRounds();
		initZoneAwards();
		initActivityZone();  //没用
		initSkills();
		initGuildRankAwards();
		initExploreAwards();
		initAchieve();
		initAchieveAward();
		initEquipment();
		initEquipmentUp();
		initEquipmentUpRate();
		initEquipmentPropertys();
		initEternals();
		initEternalProperty();
		initArenaAwards();
		initArenaAwardExp();
		initMartialWayAwardExp();
		initSgnins();
		initSumSignins();
		initMalls();
		initFame();
		initFameAward();
		initFameBuffs();
		initBaseTask();
		initVipConfig();
		initPeriodActivityTimes();
		initBreadStoreRuleList();
		initCommonRewardConfigs();
		initPayGoods();
		initArenaBuys();
	}
	
	/**
	 * 初始化常数
	 */
	private void initConstantConfigs(){
		ConstantService service = ServiceFactory.getService(ConstantService.class);
		List<ConstantConfig> configs = service.queryConstantConfigs();
		constantConfigMap = new HashMap<>();
		for(ConstantConfig config : configs){
			constantConfigMap.put(config.getName(), config);
		}
		SystemConstant.init(constantConfigMap);
	}
	
	/**
	 * 初始化用户规则
	 */
	private void initUserRules() {
		UserService userService = ServiceFactory.getService(UserService.class);
		userRules = new HashMap<Integer, UserRule>();
		List<UserRule> rules = userService.queryUserRules();
		for(UserRule rule : rules){
			userRules.put(rule.getLevel(), rule);
		}
	}
	
	private void initBlowingRule() {
		blowingRules = new HashMap<>();
		PropService service = ServiceFactory.getService(PropService.class);
		List<BlowingRule> azs = service.queryBlowingRule();
		for(BlowingRule az : azs){
			List<BlowingRule> hrs = blowingRules.get(az.getType());
			if(hrs == null){
				hrs = new ArrayList<BlowingRule>();
				blowingRules.put(az.getType(), hrs);
			}
			hrs.add(az);
		}
	}
	
	/**
	 * 初始化道具
	 */
	private void initProps() {
		PropService propService = ServiceFactory.getService(PropService.class);
		props = new HashMap<Integer, Prop>();
		List<Prop> ps = propService.queryProps();
		List<PropEffect> effects = propService.queryPropEffects();
		for(Prop prop : ps){
			prop.setEffects(new ArrayList<PropEffect>());
			for(PropEffect pe : effects){
				if(prop.getPropId() == pe.getPropId()){
					prop.getEffects().add(pe);
				}
			}
			props.put(prop.getPropId(), prop);
		}
	}
	
	/**
	 * 初始化伙伴
	 */
	private void initHeros()throws Exception{
		HeroService service = ServiceFactory.getService(HeroService.class);
		heros = new HashMap<Integer, Hero>();
		List<Hero> hs = service.queryHeros();
		for(Hero h : hs){
			heros.put(h.getHeroId(), h);
		}
	}
	
	/**
	 * 初始化伙伴规则
	 */
	private void initHeroRules() {
		HeroService heroService = ServiceFactory.getService(HeroService.class);
		heroRules = new HashMap<Integer, HeroRule>();
		List<HeroRule> rules = heroService.queryHeroRule();
		for(HeroRule rule : rules){
			heroRules.put(rule.getLevel(), rule);
		}
	}
	
	/**
	 * 初始化召唤伙伴规则
	 */
	private void initCallHeroRules() {
		HeroService heroService = ServiceFactory.getService(HeroService.class);
		callHeroRules = new HashMap<Integer, List<CallHeroRule>>();
		List<CallHeroRule> rules = heroService.queryCallHeroRule();
		List<CallHero> heros = heroService.queryCallHero();
		for(CallHeroRule rule : rules){
			rule.setHeros(new ArrayList<CallHero>());
			List<CallHeroRule> list = callHeroRules.get(rule.getType());
			if(list == null){
				list = new ArrayList<CallHeroRule>();
				callHeroRules.put(rule.getType(), list);
			}
			list.add(rule);
			for(CallHero hero : heros){
				if(hero.getArrayId() == rule.getArrayId()){
					rule.getHeros().add(hero);
				}
			}
		}
	}
	
	private void initHeroRelation() {
		heroRelations = new HashMap<>();
		HeroService service = ServiceFactory.getService(HeroService.class);
		List<HeroRelation> azs = service.queryHeroRelation();
		for(HeroRelation az : azs){
			List<HeroRelation> hrs = heroRelations.get(az.getAssHero().get(0));
			if(hrs == null){
				hrs = new ArrayList<HeroRelation>();
				heroRelations.put(az.getAssHero().get(0), hrs);
			}
			hrs.add(az);
		}
	}
	
	private void initHeroBreak(){
		HeroBreakService service = ServiceFactory.getService(HeroBreakService.class);
		List<HeroBreakSetting> queryHeroBreakSettings = service.queryHeroBreakSettings();
		heroBreakMap = new HashMap<>();
		for(HeroBreakSetting breakSetting : queryHeroBreakSettings){
			Map<Integer, Map<Integer, HeroBreakSetting>> map1 = heroBreakMap.get(breakSetting.getGroupId());
			if(map1 == null){
				map1 = new HashMap<>();
				heroBreakMap.put(breakSetting.getGroupId(), map1);
			}
			Map<Integer, HeroBreakSetting> map2 = map1.get(breakSetting.getBreakLevel());
			if(map2 == null){
				map2 = new HashMap<>();
				map1.put(breakSetting.getBreakLevel(), map2);
			}
			map2.put(breakSetting.getSlot(), breakSetting);
		}
		List<HeroBreakAttrSetting> queryHeroBreakAttrSettings = service.queryHeroBreakAttrSettings();
		heroBreakAttrMap = new HashMap<>();
		for(HeroBreakAttrSetting breakSetting : queryHeroBreakAttrSettings){
			Map<Integer, Map<Integer, HeroBreakAttrSetting>> map1 = heroBreakAttrMap.get(breakSetting.getGroupId());
			if(map1 == null){
				map1 = new HashMap<>();
				heroBreakAttrMap.put(breakSetting.getGroupId(), map1);
			}
			Map<Integer, HeroBreakAttrSetting> map2 = map1.get(breakSetting.getBreakLevel());
			if(map2 == null){
				map2 = new HashMap<>();
				map1.put(breakSetting.getBreakLevel(), map2);
			}
			map2.put(breakSetting.getSlot(), breakSetting);
		}
	}
	
	/**
	 * 初始化伙伴进化规则
	 */
	private void initheroEvos() {
		HeroService heroService = ServiceFactory.getService(HeroService.class);
		heroEvos = new HashMap<>();
		List<HeroEvo> evos = heroService.queryHeroEvo();
		List<HeroEvoMaterial> mats = heroService.queryHeroEvoMaterial();
		Map<Integer, List<HeroEvoMaterial>> map = new HashMap<>();
		for(HeroEvoMaterial item : mats){
			List<HeroEvoMaterial> list = map.get(item.getEvoId());
			if(list == null){
				list = new ArrayList<>();
				map.put(item.getEvoId(), list);
			}
			list.add(item);
		}
		for(HeroEvo evo : evos){
			List<HeroEvoMaterial> items = map.get(evo.getEvoId());
			if(items == null){
				evo.setMaterials(new ArrayList<HeroEvoMaterial>());
			}else{
				evo.setMaterials(items);
			}
			heroEvos.put(evo.getHeroId(), evo);
		}
	}
	
	/**
	 * 初始化章节
	 */
	private void initZones() {
		ZoneService zoneService = ServiceFactory.getService(ZoneService.class);
		zones = new HashMap<Integer, Zone>();
		List<Zone> zs = zoneService.queryZone();
		for(Zone zone : zs){
			zones.put(zone.getZoneId(), zone);
		}
	}

	/**
	 * 初始副本战斗
	 */
	private void initZoneBattles() {
		ZoneService zoneService = ServiceFactory.getService(ZoneService.class);
		zoneBattles = new HashMap<Integer, ZoneBattle>();
		zoneBattleByZoneIdMap = new HashMap<>();
		zonesMaxBattles = new HashMap<>();
		List<ZoneBattle> zs = zoneService.queryZoneBattle();
		for(ZoneBattle battle : zs){
			zoneBattles.put(battle.getBattleId(), battle);
			Integer maxBattleId = zonesMaxBattles.get(battle.getZoneId());
			if(maxBattleId == null || battle.getBattleId() > maxBattleId){
				zonesMaxBattles.put(battle.getZoneId(), battle.getBattleId());
			}
			List<ZoneBattle> zones = zoneBattleByZoneIdMap.get(battle.getZoneId());
			if(zones == null){
				zones = new ArrayList<ZoneBattle>();
				zoneBattleByZoneIdMap.put(battle.getZoneId(), zones);
			}
			zones.add(battle);
		}
	}
	
	/**
	 * 初始化副本宝箱奖励
	 */
	private void initZoneAwards() {
		ZoneService zoneService = ServiceFactory.getService(ZoneService.class);
		zoneAwards = new HashMap<>();
		List<ZoneAward> zs = zoneService.queryZoneAward();
		for(ZoneAward award : zs){
			Map<Integer,List<ZoneAward>> zas = zoneAwards.get(award.getZoneId());
			if(zas==null){
				zas=new HashMap<Integer, List<ZoneAward>>();
				zoneAwards.put(award.getZoneId(), zas);
			}
			List<ZoneAward> list = zas.get(award.getStar());
			if(list == null){
				list = new ArrayList<ZoneAward>();
				zas.put(award.getStar(), list);
			}
			list.add(award);
		}
	}

	/**
	 * 初始化战斗波次
	 */
	private void initBattleRounds() {
		ZoneService zoneService = ServiceFactory.getService(ZoneService.class);
		battleRounds = new HashMap<>();
		List<BattleRound> zs = zoneService.queryBattleRound();
		for(BattleRound round : zs){
			if(round.getMonsters().size()>1){
				for(int monsterId : round.getMonsters()){
					Monster monster = monsters.get(monsterId);
					if(monster == null){
						if(monsterId != 0)
						throw new GameException(GameException.CODE_参数错误, "monster NULL : " + round.getBattleId()+","+round.getRoundId()+" , "+monsterId);
					}else if(monster.getBodyType() == SystemConstant.MONSTER_TYPE_BOSS){
						throw new GameException(GameException.CODE_参数错误, "monster NULL : " + round.getBattleId()+","+round.getRoundId()+" , "+monsterId);
					}
				}
			}
			Map<Integer,BattleRound> rounds = battleRounds.get(round.getBattleId());
			if(rounds == null){
				rounds = new HashMap<Integer, BattleRound>();
				battleRounds.put(round.getBattleId(), rounds);
			}
			rounds.put(round.getRoundId(), round);
		}
	}
	
	/**
	 * 初始化活动副本
	 */
	private void initActivityZone() {
		activityZone = new HashMap<Integer, ActivityZone>();
		ActivityZoneService service = ServiceFactory.getService(ActivityZoneService.class);
		List<ActivityZone> azs = service.queryZoneActivity();
		for(ActivityZone az : azs){
			activityZone.put(az.getZoneId(), az);
		}
	}

	/**
	 * 初始化怪物
	 */
	private void initMonsters() {
		MonsterService service = ServiceFactory.getService(MonsterService.class);
		List<Monster> ms = service.queryMonster();
		List<MonsterAtkMode> modes = service.queryMonsterAtkMode();
		List<Drop> drops = service.queryDrops();
		monsters = new HashMap<Integer, Monster>();
		for(Monster m : ms){
			m.setBodyType(SystemConstant.MONSTER_TYPE_GENERAL);
			monsters.put(m.getMonsterId(), m);
			m.setModes(new ArrayList<MonsterAtkMode>());
			m.setDrops(new ArrayList<Drop>());
			for(MonsterAtkMode mam : modes){
				if(mam.getMonsterId() == m.getMonsterId()){
					m.getModes().add(mam);
				}
			}
			for(Drop d : drops){
				if(d.getMonsterId() == m.getMonsterId()){
					m.getDrops().add(d);
				}
			}
		}
	}

	/**
	 * 初始化技能
	 */
	private void initSkills() {
		SkillService service = ServiceFactory.getService(SkillService.class);
		skills = new HashMap<Integer, Map<Integer,Skill>>();
		List<Skill> list = service.querySkills();
		List<SkillEffect> effects = service.querySkillEffects();
		for(Skill s : list){
			s.setEffects(new ArrayList<SkillEffect>());
			Map<Integer,Skill> smap = skills.get(s.getSkillId());
			if(smap == null){
				smap = new HashMap<Integer, Skill>();
				skills.put(s.getSkillId(), smap);
			}
			for(SkillEffect se : effects){
				if(se.getSkillId()==s.getSkillId()&&se.getLv() == s.getLv()){
					s.getEffects().add(se);
				}
			}
			smap.put(s.getLv(), s);
		}
		PASSIVE_SKILLS = new HashMap<Integer, PassiveSkill>();
		List<PassiveSkill> plist = service.queryPassiveSkill();
		for(PassiveSkill ps : plist){
			ps.setEffects(new ArrayList<SkillEffect>());
			PASSIVE_SKILLS.put(ps.getPassiveSkillId(), ps);
			for(SkillEffect se : effects){
				if(ps.getPassiveSkillId()==se.getSkillId()&&se.getLv() == 1){
					ps.getEffects().add(se);
				}
			}
			
		}
	}
	
	private void initGuildRankAwards() {
		GuildService guildService = ServiceFactory.getService(GuildService.class);
		guildRankAwards = new HashMap<Integer,List<GuildRankAward>>();
		List<GuildRankAward> awards = guildService.queryAwards();
		for(GuildRankAward award : awards){
			List<GuildRankAward> as = guildRankAwards.get(award.getRank());
			if(as == null){
				as = new ArrayList<>();
				guildRankAwards.put(award.getRank(), as);
			}
			as.add(award);
		}
	}

	private void initExploreAwards() {
		HeroService heroService = ServiceFactory.getService(HeroService.class);
		List<ExploreAward> list = heroService.queryExploreAwards();
		exploreAwards = new HashMap<Integer, List<ExploreAward>>();
		for(ExploreAward ea : list){
			List<ExploreAward> eaList = exploreAwards.get(ea.getArrayId());
			if(eaList == null){
				eaList = new ArrayList<ExploreAward>();
				exploreAwards.put(ea.getArrayId(), eaList);
			}
			eaList.add(ea);
		}
	}

	/**
	 * 初始化成就
	 */
	private void initAchieve() {
		AchieveService achieveService = ServiceFactory.getService(AchieveService.class);
		achieves = new HashMap<Integer, Achieve>();
		achievesTypeMap = new HashMap<Integer, Map<Integer,List<Achieve>>>();
		List<Achieve> list = achieveService.queryAchieves();
		for(Achieve a : list){
			achieves.put(a.getAchieveId(), a);
			Map<Integer,List<Achieve>> map = achievesTypeMap.get(a.getType());
			if(map == null){
				map = new HashMap<Integer, List<Achieve>>();
				achievesTypeMap.put(a.getType(), map);
			}
			List<Achieve> ls = map.get(a.getAssId());
			if(ls == null){
				ls = new ArrayList<Achieve>();
				map.put(a.getAssId(), ls);
			}
			ls.add(a);
		}
	}

	/**
	 * 初始化成就奖励
	 */
	private void initAchieveAward() {
		AchieveService achieveService = ServiceFactory.getService(AchieveService.class);
		achieveAwards = new HashMap<Integer, List<AchieveAward>>();
		List<AchieveAward> list = achieveService.queryAchieveAwards();
		for(AchieveAward aa : list){
			List<AchieveAward> aaList = achieveAwards.get(aa.getAchieveId());
			if(aaList == null){
				aaList = new ArrayList<AchieveAward>();
				achieveAwards.put(aa.getAchieveId(), aaList);
			}
			aaList.add(aa);
		}
	}
	
	/**
	 * 初始化装备
	 */
	private void initEquipment() {
		equipments = new HashMap<Integer, Equipment>();
		EquipmentService service = ServiceFactory.getService(EquipmentService.class);
		List<Equipment> azs = service.queryEquipment();
		for(Equipment az : azs){
			equipments.put(az.getEquipmentId(), az);
		}
	}

	/**
	 * 初始装备升级
	 */
	private void initEquipmentUp() {
		equipmentUps = new HashMap<Integer, List<EquipmentUp>>();
		EquipmentService service = ServiceFactory.getService(EquipmentService.class);
		List<EquipmentUp> azs = service.queryEquipmentUp();
		for(EquipmentUp eu : azs){
			List<EquipmentUp> list = equipmentUps.get(eu.getEquipmentLevel());
			if(list==null){
				list=new ArrayList<EquipmentUp>();
				equipmentUps.put(eu.getEquipmentLevel(), list);
			}
			list.add(eu);
		}
	}
	
	/**
	 * 初始化装备升级概率
	 */
	private void initEquipmentUpRate() {
		equipmentUpRates = new HashMap<Integer, EquipmentUpRate>();
		EquipmentService service = ServiceFactory.getService(EquipmentService.class);
		List<EquipmentUpRate> azs = service.queryEquipmentUpRate();
		for(EquipmentUpRate az : azs){
			equipmentUpRates.put(az.getLevel(), az);
		}
	}
	
	/**
	 * 初始化装备属性
	 */
	private void initEquipmentPropertys(){
		equipmentPropertys = new HashMap<Integer, List<EquipmentProperty>>();
		EquipmentService service = ServiceFactory.getService(EquipmentService.class);
		List<EquipmentProperty> azs = service.queryEquipmentProperty();
		for(EquipmentProperty ep:azs){
			List<EquipmentProperty> list = equipmentPropertys.get(ep.getQuality());
			if(list==null){
				list=new ArrayList<EquipmentProperty>();
				equipmentPropertys.put(ep.getQuality(), list);
			}
			list.add(ep);
		}
	}
	
	/**
	 * 初始化武魂
	 */
	private void initEternals() {
		eternals = new HashMap<Integer, Eternal>();
		EternalService service = ServiceFactory.getService(EternalService.class);
		List<Eternal> es = service.queryEternals();
		List<EternalEffect> ees = service.queryEternalEffects();
		for(Eternal e : es){
			e.setEffects(new ArrayList<EternalEffect>());
			for(EternalEffect ee : ees){
				if(e.getEternalId() == ee.getEternalId()){
					e.getEffects().add(ee);
				}
			}
			eternals.put(e.getEternalId(), e);
		}
	}

	/**
	 * 初始化武魂属性
	 */
	private void initEternalProperty() {
		EternalService service = ServiceFactory.getService(EternalService.class);
		eternalBsis = new HashMap<>();
		eternalAppends = new HashMap<>();
		List<EternalProperty> listPropertys=service.queryEnternalPropertys();
		for(EternalProperty ep:listPropertys){
			if(ep.getType() == SystemConstant.ETERNAL_PROPERTY_TYPE_基础属性){
				List<EternalProperty> listBsis = eternalBsis.get(ep.getQuality());
				if(listBsis == null){
					listBsis = new ArrayList<EternalProperty>();
					eternalBsis.put(ep.getQuality(), listBsis);
				}
				listBsis.add(ep);
			}else{
				List<EternalProperty> listAppends = eternalAppends.get(ep.getQuality());
				if(listAppends == null){
					listAppends = new ArrayList<EternalProperty>();
					eternalAppends.put(ep.getQuality(), listAppends);
				}
				listAppends.add(ep);
			}
		}
	}
	
	/**
	 * 初始化竞技场奖励
	 */
	private void initArenaAwards(){
		arenaAwards = new HashMap<>();
		ArenaService service = ServiceFactory.getService(ArenaService.class);
		List<ArenaAward> aws=service.queryArenaAward();
		for (ArenaAward aw:aws) {
			List<ArenaAward> list = arenaAwards.get(aw.getShoppingId());
			if(list == null){
				list = new ArrayList<ArenaAward>();
				arenaAwards.put(aw.getShoppingId(), list);
			}
			list.add(aw);
		}
	}

	/**
	 * 初始化竞技场奖励经验
	 */
	private void initArenaAwardExp(){
		arenaExpAward = new HashMap<>();
		ArenaService service = ServiceFactory.getService(ArenaService.class);
		List<MartialWayAwardExp> aws=service.queryArenaAwardExp();
		for (MartialWayAwardExp aw:aws) {
			arenaExpAward.put(aw.getLevel(), aw.getExp());
		}
	}

	/**
	 * 初始化武道大会奖励经验
	 */
	private void initMartialWayAwardExp(){
		martiaWayExpAward = new HashMap<>();
		MartialWayService service = ServiceFactory.getService(MartialWayService.class);
		List<MartialWayAwardExp> aws=service.queryMartialWayAwardExp();
		for (MartialWayAwardExp aw:aws) {
			martiaWayExpAward.put(aw.getLevel(), aw.getExp());
		}
	}
	
	/**
	 * 初始化签到奖励
	 */
	private void initSgnins() {
		sgnins = new HashMap<>();
		SigninService service = ServiceFactory.getService(SigninService.class);
		List<Signin> aws=service.querySignins();
		for (Signin aw:aws) {
			sgnins.put(aw.getDay(), aw);
		}
	}
	
	/**
	 * 初始化补签奖励
	 */
	private void initSumSignins() {
		sumSignins = new HashMap<>();
		SigninService service = ServiceFactory.getService(SigninService.class);
		List<SumSignin> aws=service.querySumSignins();
		for (SumSignin aw:aws) {
			List<SumSignin> list = sumSignins.get(aw.getDayNum());
			if(list == null){
				list = new ArrayList<SumSignin>();
				sumSignins.put(aw.getDayNum(), list);
			}
			list.add(aw);
		}
	}
	
	/**
	 * 初始化商城
	 */
	private void initMalls() {
		malls = new HashMap<>();
		MallService service = ServiceFactory.getService(MallService.class);
		List<Mall> aws=service.gainMall();
		List<MallGoods> goods =service.queryAllMallGoods();
		blackMarketMall = new HashMap<>();
		for (Mall aw:aws) {
			malls.put(aw.getId(), aw);
			aw.setGoodses(new ArrayList<MallGoods>());
			for(MallGoods g : goods){
				if(g.getMallId() == aw.getId()){
					aw.getGoodses().add(g);
				}
			}
			if(aw.getType() == SystemConstant.MALL_TYPE_黑市){
				List<Mall> ll = blackMarketMall.get(aw.getPoolId());
				if(ll == null){
					ll = new ArrayList<Mall>();
					blackMarketMall.put(aw.getPoolId(), ll);
				}
				ll.add(aw);
			}
		}
	}

	private void initFame() {
		fames = new HashMap<>();
		FameService service = ServiceFactory.getService(FameService.class);
		List<Fame> aws=service.queryFame();
		for (Fame aw:aws) {
			fames.put(aw.getFameLevel(), aw);
		}
	}

	private void initFameAward() {
		fameAward = new HashMap<>();
		FameService service = ServiceFactory.getService(FameService.class);
		List<FameAward> aws=service.queryFameAward();
		for (FameAward aw:aws) {
			List<Goods> g = fameAward.get(aw.getFameLevel());
			if(g == null){
				g = new ArrayList<Goods>();
				fameAward.put(aw.getFameLevel(), g);
			}
			g.add(aw);
		}
	}
	
	private void initFameBuffs() {
		fameBuffs = new HashMap<>();
		FameService service = ServiceFactory.getService(FameService.class);
		List<FameBuff> aws=service.queryFameBuff();
		for (FameBuff aw:aws) {
			List<FameBuff> g = fameBuffs.get(aw.getFameLevel());
			if(g == null){
				g = new ArrayList<FameBuff>();
				fameBuffs.put(aw.getFameLevel(), g);
			}
			g.add(aw);
		}
	}

	private void initBaseTask(){
		TaskService service = ServiceFactory.getService(TaskService.class);
		//任务基础表
		taskSettingMap = new HashMap<>();
		List<TaskSetting> queryTaskSettings = service.queryTaskSettings();
		for(TaskSetting taskSetting : queryTaskSettings){
			taskSettingMap.put(taskSetting.getId(), taskSetting);
		}
		//任务行为表
		taskActionSettingMap = new HashMap<>();
		List<TaskActionSetting> queryTaskActionSettings = service.queryTaskActionSettings();
		for(TaskActionSetting taskSetting : queryTaskActionSettings){
			taskActionSettingMap.put(taskSetting.getId(), taskSetting);
		}
		//任务奖励
		taskRewadsMap = new HashMap<>();
		List<TaskReward> queryTaskRewards = service.queryTaskRewards();
		for(TaskReward taskReward : queryTaskRewards){
			List<TaskReward> list = taskRewadsMap.get(taskReward.getTaskId());
			if(list == null){
				list = new ArrayList<>();
				taskRewadsMap.put(taskReward.getTaskId(), list);
			}
			list.add(taskReward);
		}
		//活跃度宝箱奖励
		taskBoxRewadsMap = new HashMap<>();
		List<TaskBoxReward> queryTaskBoxRewards = service.queryTaskBoxRewards();
		for(TaskBoxReward boxReward : queryTaskBoxRewards){
			List<TaskBoxReward> list = taskBoxRewadsMap.get(boxReward.getActive());
			if(list == null){
				list = new ArrayList<>();
				taskBoxRewadsMap.put(boxReward.getActive(), list);
			}
			list.add(boxReward);
		}
		TaskHolder.init(taskSettingMap, taskActionSettingMap); 
	}

	private void initVipConfig() throws Exception{
		VIPService service = ServiceFactory.getService(VIPService.class);
		vipConfigMap = new HashMap<>();
		List<VipConfig> configs = service.queryVipConfigs();
		for(VipConfig config : configs){
			Privileges privileges = new Privileges(config.getPrivileges());
			config.setVipPrivileges(privileges);
			vipConfigMap.put(config.getVipLevel(), config);
		}
	}
	
	private void initPeriodActivityTimes(){
		ActivityService service = ServiceFactory.getService(ActivityService.class);
		periodActivityTimeMap = new HashMap<Integer, PeriodActivityTime>();
		List<PeriodActivityTime> configs = service.queryPeriodActivityTimes();
		for(PeriodActivityTime time : configs){
			periodActivityTimeMap.put(time.getType(), time);
		}
	}
	
	private void initBreadStoreRuleList(){
		ZoneService service = ServiceFactory.getService(ZoneService.class);
		breadStoreRuleList = service.queryBreadStoreRules();
	}
	
	private void initCommonRewardConfigs(){
		CommonRewardService service = ServiceFactory.getService(CommonRewardService.class);
		List<CommonRewardConfig> configs = service.queryCommonRewardConfigs();
		commonRewardConfigTypeMap = new ConcurrentHashMap<Integer, Map<Integer,CommonRewardConfig>>();
		commonRewardConfigMap = new ConcurrentHashMap<Integer, CommonRewardConfig>();
		for(CommonRewardConfig config : configs){
			Map<Integer, CommonRewardConfig> map = commonRewardConfigTypeMap.get(config.getType());
			if(map == null){
				map = new ConcurrentHashMap<Integer, CommonRewardConfig>();
				commonRewardConfigTypeMap.put(config.getType(), map);
			}
			map.put(config.getId(), config);
			commonRewardConfigMap.put(config.getId(), config);
		}
	}
	
	private void initPayGoods(){
		MallService service = ServiceFactory.getService(MallService.class);
		List<PayGoods> configs = service.queryPayGoods();
		payGoodsMap = new HashMap<>();
		for(PayGoods config : configs){
			payGoodsMap.put(config.getId(), config);
		}
	}
	
	private void initArenaBuys(){
		ArenaService service = ServiceFactory.getService(ArenaService.class);
		List<ArenaBuy> list = service.queryArenaBuys();
		arenaBuyMap = new HashMap<>();
		for(ArenaBuy buy : list){
			arenaBuyMap.put(buy.getCount(), buy);
		}
	}

}
