package com.ks.constant;

import java.util.Map;

import com.ks.db.cfg.ConstantConfig;

public class SystemConstant {
	/********************************** 缓存  ****************************************/
	/**时间10分钟*/
	public static final int CACHE_EXPIRE_TIME = 10 * 60;
	/********************************** 聊天  ************************************************/
	public static final int CHAT_CHANNEL_WORLD = 1;
	
	/********************************** 初始化英雄  *******************************************/
	public static final int[] INIT_HEROS = new int[] { 82041,82042,82043 };
	
	/********************************** 成就  ************************************************/
	public static final int ACHIEVE_STATE_未完成 = 1;
	public static final int ACHIEVE_STATE_已完成 = 2;
	public static final int ACHIEVE_STATE_已领取 = 3;
	/********************************** 装备  ************************************************/
	public static final int EQUIP_RARITY_非稀有 = 1;
	public static final int EQUIP_RARITY_稀有 = 2;
	/**通用属性*/
	public static final int EQUIP_ELE_COMMON = 0;

	/********************************** 装备属性 ************************************************/
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_增加攻击力=1;
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_增加血上限=2;
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_格挡率=3;
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_格挡伤害=4;
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_增加暴击率=5;
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_暴击伤害=6;
	public static final int EQUIPMENT_PROPERTY_SKILLTYPE_增加闪避率=7;
	/********************************** 装备升级  ************************************************/
	public static final int EQUIPMENT_UP_RATE_SUCCESS_成功 = 1;
	public static final int EQUIPMENT_UP_RATE_SUCCESS_大成功 = 2;
	public static final int EQUIPMENT_UP_RATE_SUCCESS_超成功 = 5;
	public static final int EQUIPMENT_UP_RATE_LOSE_失败 = 0;
	/********************************** 武魂  ************************************************/
	///**火*/
	//public static final int ELE_FIRE = 1;
	///**木*/
	//public static final int ELE_WOOD =2;
	///**水*/
	//public static final int ELE_WATER = 3;
	///**光*/
	//public static final int ELE_LIGHT = 4;
	///**暗*/
	//public static final int ELE_DARK = 5;
	///**通*/
	//public static final int ELE_COMMON = 6;
	//public static final int EFFECT_TYPE_增加攻击次数 = 10;
	//public static final int EFFECT_TYPE_增加移动格子 = 11;
	//public static final int EFFECT_TYPE_提升火属性等级 = 12;
	//public static final int EFFECT_TYPE_提升木属性等级 = 13;
	//public static final int EFFECT_TYPE_提升水属性等级 = 14;
	//public static final int EFFECT_TYPE_提升光属性等级 = 15;
	//public static final int EFFECT_TYPE_提升暗属性等级 = 16;
	//public static final int EFFECT_TYPE_增加HP上限 = 17;
	//public static final int EFFECT_TYPE_增加攻击力 = 18;
	//public static final int EFFECT_TYPE_增加左上方攻击方向 = 19;
	//public static final int EFFECT_TYPE_增加右上方攻击方向 = 21;
	//public static final int EFFECT_TYPE_增加右方攻击方向 = 22;
	//public static final int EFFECT_TYPE_增加右下方攻击方向 = 23;
	//public static final int EFFECT_TYPE_增加左下方攻击方向 = 25;
	//public static final int EFFECT_TYPE_增加左方攻击方向 = 26;
	public static final int ETERNAL_EFFECT_TYPE_免疫陷阱 = 27;
	public static final int ETERNAL_EFFECT_TYPE_免疫debuff = 28;
	public static final int ETERNAL_EFFECT_TYPE_免疫对克制属性的百分比伤害 = 29;
	public static final int ETERNAL_EFFECT_TYPE_免疫敌方技能伤害 = 30;
	//public static final int EFFECT_TYPE_使佩戴者拥有飞行能力 = 31;
	//public static final int EFFECT_TYPE_是佩戴者拥有团队能力 = 32;
	//public static final int EFFECT_TYPE_为伙伴增肌弹射能力 = 33;
	//public static final int EFFECT_TYPE_增加格挡率 = 34;
	//public static final int EFFECT_TYPE_增强格挡效果 = 35;
	//public static final int EFFECT_TYPE_增加暴击率 = 36;
	//public static final int EFFECT_TYPE_增加暴击伤害 = 37;
	//public static final int EFFECT_TYPE_增加闪避率 = 38;
	///**基本属性100-1000之间id*/
	//public static final int EFFECT_TYPE_增加攻击值 = 100;
	//public static final int EFFECT_TYPE_增加装备百分比= 101;
	//public static final int EFFECT_TYPE_增加生命值= 102;
	//public static final int EFFECT_TYPE_增加装备生命值得百分比= 103;
	//public static final int EFFECT_TYPE_增加攻击方向= 104;
	//public static final int EFFECT_TYPE_增加攻击移动范围= 105;
	///**附加属性1000之间id*/
	//public static final int EFFECT_PROPERTY_格挡率= 1000;
	//public static final int EFFECT_PROPERTY_格挡效果= 1001;
	//public static final int EFFECT_PROPERTY_暴击率= 1002;
	//public static final int EFFECT_PROPERTY_暴击伤害= 1003;
	//public static final int EFFECT_PROPERTY_闪避率= 1004;

	/**武魂熔炼最大值*/
	public static final int[] ETERNAL_SMELTING_MAX_VAL = new int[]{300,800,1500};
	/**武魂基本属性100-1000之间id*/
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加攻击值 = 100;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加装备攻击力百分比= 101;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加生命值= 102;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加装备生命值得百分比= 103;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加攻击方向= 104;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加移动范围= 105;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加左上方攻击方向 = 19;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加右上方攻击方向 = 21;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加右方攻击方向 = 22;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加右下方攻击方向 = 23;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加左下方攻击方向 = 25;
	public static final int ETERNAL_PROPERTY_EFFECT_TYPE_增加左方攻击方向 = 26;
	/**武魂附加属性1000之间id*/
	public static final int ETERNAL_PROPERTY_EFFECT_PROPERTY_格挡率= 1000;
	public static final int ETERNAL_PROPERTY_EFFECT_PROPERTY_格挡效果= 1001;
	public static final int ETERNAL_PROPERTY_EFFECT_PROPERTY_暴击率= 1002;
	public static final int ETERNAL_PROPERTY_EFFECT_PROPERTY_暴击伤害= 1003;
	public static final int ETERNAL_PROPERTY_EFFECT_PROPERTY_闪避率= 1004;


	public static final int ETERNAL_PROPERTY_TYPE_基础属性=1;
	public static final int ETERNAL_PROPERTY_TYPE_附加属性=2;

	/********************************** 好友 ************************************************/
	/**最大好友数*/
	public static int FRIEND_MAX_FRIEND_COUNT;
	/**好友开放等级*/
	public static int FRIEND_OPEN_LEVEL = 10;
	/**好友推荐等级浮动值*/
	public static int FRIEND_RECO_LEVEL_FLOAT = 5;
	/********************************** 公会 ************************************************/
	/**进入公会类型*/
	public static final int GUILD_STAT_手动 = 0;
	public static final int GUILD_STAT_自动 = 1;
	/**升级经验*/
	public static final int[] GUILD_LEVEL_EXP = new int[]{100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600,1700,1800,1900,2000};
	/**公会成员类型*/
	public static final int GUILD_MEMBER_成员 = 1;
	public static final int GUILD_MEMBER_会长  = 2;
	/**公会技能*/
	public static final int GUILD_SKILL_ID_攻击力强化 = 1;
	public static final int GUILD_SKILL_ID_生命强化 = 2;
	public static final int GUILD_SKILL_ID_暴击强化 = 3;
	/**公会技能 */
	public static final int[] GUILD_SKILLS = new int[] {GUILD_SKILL_ID_攻击力强化, GUILD_SKILL_ID_生命强化, GUILD_SKILL_ID_暴击强化};
	/**技能等级*/
	public static final int[][] GUILD_SKILL_LEVEL = new int[][] {
		{ 1, 100, 10, 100, 50 }, { 2, 200, 20, 200, 100 },
		{ 3, 300, 30, 300, 150 }, { 4, 400, 40, 400, 200 },
		{ 5, 500, 50, 500, 250 }, { 6, 600, 60, 600, 300 },
		{ 7, 700, 70, 700, 350 }, { 8, 800, 80, 800, 400 },
		{ 9, 900, 90, 900, 450 }, { 10, 1000, 100, 1000, 500 }};
	
	/**创建公会金币消耗*/
	public static int GUILD_CREATE_GOLD_PRICE;
	/**创建公会钻石消耗*/
	public static int GUILD_CREATE_DIAMOND_PRICE;
	/**修改公会名称*/
	public static int GUILD_AMEND_NAME_DIAMOND;


	/********************************** 探索  ************************************************/
	public static final int EXPLORE_STATE_未开始 = 1;
	public static final int EXPLORE_STATE_已开始 = 2;
	/**1小时*/
	public static final int EXPLORE_TYPE_1_HOUR = 1;
	/**3小时*/
	public static final int EXPLORE_TYPE_3_HOUR = 2;
	/**10小时*/
	public static final int EXPLORE_TYPE_10_HOUR = 3;
	/**20小时*/
	public static final int EXPLORE_TYPE_20_HOUR = 4;
	/**锁定*/
	public static final int EXPLORE_STATE_LOCKING = 0b1;
	/**探索*/
	public static final int EXPLORE_STATE_EXPLORE = 0b10;
	
	/********************************** 邮件 ************************************************/
	/**未读*/
	public static final int MAIL_STATE_UNREAD = 1;
	/**已读*/
	public static final int MAIL_STATE_READ = 2;
	/**邮件类型*/
	public static final int MAIL_TYPE_系统邮件 = 1;
	public static final int MAIL_TYPE_竞技场奖励 = 2;
	public static final int MAIL_TYPE_公会解散 = 3;
	public static final int MAIL_TYPE_更换会长 = 4;
	public static final int MAIL_TYPE_公会改名 = 5;
	public static final int MAIL_TYPE_公会技能升级 = 6;
	public static final int MAIL_TYPE_弹劾会长 = 7;
	public static final int MAIL_TYPE_公会奖励 = 8;
	public static final int MAIL_TYPE_武道大会每天奖励 = 9;
	
	/********************************** 系统邮件 ************************************************/
	/**指定用户*/
	public static final int SYS_MAIL_TYPE_USER = 1;
	/**登录（未使用）*/
	public static final int SYS_MAIL_TYPE_LOGIN = 2;
	/**指定时间*/
	public static final int SYS_MAIL_TYPE_TIMES = 3;
	/**当前全服*/
	public static final int SYS_MAIL_TYPE_CUR_SERVER = 4;
	/**永久全服*/
	public static final int SYS_MAIL_TYPE_SERVER_FOREVER = 5;
	
	/********************************** 商店 ************************************************/
	/**商店消费类型-金币*/
	public static final int MALL_MONEY_TYPE_GOLD = 1;
	/**商店消费类型-钻石*/
	public static final int MALL_MONEY_TYPE_DIAMOND = 2;
	/**商店类型*/
	public static final int MALL_TYPE_普通 = 1;
	public static final int MALL_TYPE_黑市 = 2;
	/**黑市刷新时间(小时)*/
	public static final int MALL_BLACK_MARKET_REFRESH_HOURS[] = {0, 12, 18, 21};

	/**刷新黑市钻石消耗*/
	public static int MALL_REFRESH_BLACK_MARKET; 
	/**每日刷新黑市次数*/
	public static int MALL_REFRESH_BLACK_MARKET_NUMBER = 20;
	
	/********************************** 怪物 ************************************************/
	/**普通怪*/
	public static final int MONSTER_TYPE_GENERAL = 0;
	/**boss*/
	public static final int MONSTER_TYPE_BOSS = 1;

	/********************************** 道具 ************************************************/
	/** 道具 */
	public static final int PROP_TYPE_ITEM = 1;
	/** 宝箱 */
	public static final int PROP_TYPE_BOX = 2;
	
	public static final int PROP_ID_经验药水 = 4020001;
	public static final int PROP_ID_小体力药水 = 4020002;
	public static final int PROP_ID_体力药水 = 4020003;
	public static final int PROP_ID_金钱卡 = 4020004;
	public static final int PROP_ID_经验卡 = 4020005;
	public static final int PROP_ID_背包扩充卡 = 4020006;
	public static final int PROP_ID_复活药水 = 4020007;
	public static final int PROP_ID_秘银棒 = 4020008;
	public static final int PROP_ID_补签卡 = 4020011;
	public static final int PROP_ID_扫荡券 = 4020012;

	public static final int PROP_EFFECT_ID_获得经验 = 1;
	public static final int PROP_EFFECT_ID_获得体力 = 2;
	public static final int PROP_EFFECT_ID_体力全满 = 3;
	public static final int PROP_EFFECT_ID_金钱加成 = 4;
	public static final int PROP_EFFECT_ID_经验加成 = 5;
	public static final int PROP_EFFECT_ID_背包扩充 = 6;
	public static final int PROP_EFFECT_ID_复活 = 7;
	public static final int PROP_EFFECT_ID_特殊召唤 = 8;
	public static final int PROP_EFFECT_ID_增加经验池上限 = 9;
	public static final int PROP_EFFECT_ID_增加熔炼池上限 = 10;

	/********************************** 技能 ************************************************/
	public static final int SKILL_TARGET_自身 = 0b1;
	public static final int SKILL_TARGET_队友 = 0b10;
	public static final int SKILL_TARGET_敌方目标 = 0b100;
	public static final int SKILL_TARGET_敌方群体 = 0b1000;
	public static final int SKILL_TARGET_火 =0b10000 ;
	public static final int SKILL_TARGET_木 =0b100000 ;
	public static final int SKILL_TARGET_水 =0b1000000 ;
	public static final int SKILL_TARGET_光 =0b10000000 ;
	public static final int SKILL_TARGET_暗 =0b100000000 ;
	public static final int SKILL_TARGET_是否受范围影响 = 0b1000000000;
	/**最高等级*/
	public static int SKILL_MAX_LEVEL;
	/**升级概率*/
	public static final double[] SKILL_LEVEL_UP_RATE = new double[]{0.2,0.05,0.001};

	/**装备BUFF*/
	public static final int SKILL_EFFECT_TYPE_EQUIP = 1;
	
	public static final int SKILL_EFFECT_ID_即时伤害 = 1;
	public static final int SKILL_EFFECT_ID_持续伤害 = 2;
	public static final int SKILL_EFFECT_ID_攻击变更 = 3;
	public static final int SKILL_EFFECT_ID_暴击率变更 = 4;
	public static final int SKILL_EFFECT_ID_闪避率变更 = 5;
	public static final int SKILL_EFFECT_ID_移动力提升 = 6;
	public static final int SKILL_EFFECT_ID_飞行 = 7;
	public static final int SKILL_EFFECT_ID_减伤 = 8;
	public static final int SKILL_EFFECT_ID_攻击次数变更 = 9;
	public static final int SKILL_EFFECT_ID_即时恢复 = 10;
	public static final int SKILL_EFFECT_ID_持续恢复 = 11;
	public static final int SKILL_EFFECT_ID_攻击范围提升 = 12;
	public static final int SKILL_EFFECT_ID_缴械 = 13;
	public static final int SKILL_EFFECT_ID_沉默 = 14;
	public static final int SKILL_EFFECT_ID_眩晕 = 15;
	public static final int SKILL_EFFECT_ID_护盾 = 16;
	public static final int SKILL_EFFECT_ID_击退 = 17;
	public static final int SKILL_EFFECT_ID_格挡效果变更 = 18;
	public static final int SKILL_EFFECT_ID_造成伤害变更 = 19;
	public static final int SKILL_EFFECT_ID_弹射 = 20;
	public static final int SKILL_EFFECT_ID_穿透弹射 = 21;
	public static final int SKILL_EFFECT_ID_道具效果扩散 = 22;
	public static final int SKILL_EFFECT_ID_溅射 = 23;
	public static final int SKILL_EFFECT_ID_金钱增加 = 24;
	public static final int SKILL_EFFECT_ID_经验增加 = 25;
	public static final int SKILL_EFFECT_ID_暴击伤害变更 = 26;
	public static final int SKILL_EFFECT_ID_生命变更 = 27;
	public static final int SKILL_EFFECT_ID_格挡率变更 = 28;
	public static final int SKILL_EFFECT_ID_格挡率 = 28;
	public static final int SKILL_EFFECT_ID_格挡伤害 = 29;
	public static final int SKILL_EFFECT_ID_穿刺 = 30;
	public static final int SKILL_EFFECT_ID_血量上限 = 31;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_陷阱 = 101;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_据点 = 102;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_泉水 = 103;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_敏捷 = 301;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_暴击 = 302;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_双倍 = 303;
	public static final int SKILL_EFFECT_ID_GRID_ITEM_减伤 = 304;

	/********************************** 玩家  ************************************************/
//	/**玩家初始伙伴容量 */
//	public static int USER_INIT_HERO_CAPACITY = 20;
	/**玩家初始金币*/
	public static int USER_INIT_GOLD;
	/**玩家初始钻石*/
	public static int USER_INIT_DIAMOND;
	/**玩家初始灵值*/
	public static int USER_INIT_GP;
	/**玩家初始累计充值*/
	public static int USER_INIT_CHARGE_DIAMOND;
	/**体力恢复所需时间(秒) */
	public static int USER_REGAIN_STAMINA_TIME;
	/**玩家初始等级 */
	public static int USER_MIN_LEVEL;
	/**玩家最大等级 */
	public static int USER_MAX_LEVEL;
	/**可购买金币次数*/
	public static int USER_BUY_GOLD_NUMBER;
	/**购买金币获得*/
	public static int USER_BUY_GOLD_GAIN;
	/**购买金币钻石上限*/
	public static int USER_BUY_GOLD_MAX_DIAMOND;
	/**可购买体力次数*/
	public static int USER_BUY_STAMINA_NUMBER;
	/**购买体力获得*/
	public static int USER_BUY_STAMINA_GAIN;
	/**购买体力钻石上限*/
	public static int USER_BUY_STAMINA_MAX_DIAMOND;
	/**玩家每升1级获得体力*/
	public static int USER_UP_LEVEL_GAIN_STAMINA;
	/**补签消耗*/
	public static int USER_SIGNIN_DIAMOND;
	/**改名消耗*/
	public static int USER_CHANGE_NAME_DIAMOND;
	/**增加伙伴格子上限 */
	public static int USER_MAX_HERO_CAPACITY;
	/**增加装备格子上限 */
	public static int USER_MAX_EQUIPMENT_CAPACITY;
	/**增加武魂格子上限 */
	public static int USER_MAX_ETERNAL_CAPACITY;
	/**扩充背包容量单次价格(钻石)*/
	public static int USER_HERO_ADD_CAPACITY_PRICE;
	/**扩充背包容量单次格子数*/
	public static int USER_HERO_ADD_CAPACITY_NUMBER;
	/**背包格子上限*/
	public static int USER_BACK_PACK_LIMIT = 60;
	
	
	/********************************** 副本 ************************************************/
	/**副本类型-定时*/
	public static final int ZONE_TYPE_TIME = 0;
	/**章节类型-普通*/
	public static final int ZONE_TYPE_SIMPLE = 1;
	/**章节类型-精英*/
	public static final int ZONE_TYPE_ELITE = 2;
	/**章节类型-试炼*/
	public static final int ZONE_TYPE_TRIALS = 3;

	/**章节id-包子铺*/
	public static final int ZONE_ID_BREAD_STORE = 3001;
	/**章节id-财神殿*/
	public static final int ZONE_ID_GOD_WEALTH = 3002;
	/**章节id-灵气殿*/
	public static final int ZONE_ID_ANIMA_TEMPLE = 3003;
	
	/**关卡类型-普通关卡*/
	public static final int ZONE_TOLLGATE_TYPE_SIMPLE = 1;
	/**关卡类型-boss关卡*/
	public static final int ZONE_TOLLGATE_TYPE_BOSS = 2;
	
	/**副本扫荡一次钻石消耗*/
	public static int ZONE_SWEEP_PRICE;

	/********************************** 道具效果类型  ************************************************/
	/** 货币 */
	public static final int ITEM_TYPE_CURRENCY = 1001;
	/**道具效果类型(后台充值) */
	public static final int ITEM_EFFECT_TYPE_RECHARGE = -2;
	/**道具效果类型(等级) */
	public static final int ITEM_EFFECT_TYPE_LEVEL = -1;
	/**道具效果类型(英雄/伙伴)*/
	public static final int ITEM_EFFECT_TYPE_HERO = 1;
	/**道具效果类型(金币)*/
	public static final int ITEM_EFFECT_TYPE_GOLD = 2;
	/**道具效果类型(钻石)*/
	public static final int ITEM_EFFECT_TYPE_DIAMOND = 3;
	/**道具效果类型(道具)*/
	public static final int ITEM_EFFECT_TYPE_PROP = 4;
	/**道具效果类型(灵气/神之召唤点)*/
	public static final int ITEM_EFFECT_TYPE_GP = 5;
	/**道具效果类型(装备)*/
	public static final int ITEM_EFFECT_TYPE_EQUIPMENT = 6;
	/**道具效果类型(武魂)*/
	public static final int ITEM_EFFECT_TYPE_ETERNAL = 7;
	/**道具效果类型(伙伴经验点)*/
	public static final int ITEM_EFFECT_TYPE_HERO_EXP_POOL = 8;
	/**道具效果类型(熔炼点数)*/
	public static final int ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT = 9;
	/**道具效果类型(上古石板 )*/
	public static final int ITEM_EFFECT_TYPE_SLATE = 10;
	/**道具效果类型(经验) */
	public static final int ITEM_EFFECT_TYPE_EXP = 101;
	/**道具效果类型(体力) */
	public static final int ITEM_EFFECT_TYPE_STAMINA = 102;
	/**道具效果类型(添加伙伴池经验上限)*/
	public static final int ITEM_EFFECT_TYPE_ADD_HERO_POOL_EXP_LIMIT = 103;
	/**道具效果类型(添加熔炼池经验上限)*/
	public static final int ITEM_EFFECT_TYPE_ADD_SMELTING_POOL_EXP_LIMIT = 104;
	/**物品类型*/
	public static final int[] ITEM_EFFECT_TYPES = {
		ITEM_EFFECT_TYPE_HERO,
		ITEM_EFFECT_TYPE_PROP,
		ITEM_EFFECT_TYPE_EQUIPMENT,
		ITEM_EFFECT_TYPE_ETERNAL,
	};
	public static final String[] ITEM_EFFECTS_TYPE_NAMES = {
		"英雄",
		"道具",
		"装备",
		"武魂"
	};
	/**货币类型*/
	public static final int[] ITEM_EFFECTS_TYPE_CURRENCY = {
		ITEM_EFFECT_TYPE_GOLD,
		ITEM_EFFECT_TYPE_DIAMOND,
		ITEM_EFFECT_TYPE_GP,
		ITEM_EFFECT_TYPE_HERO_EXP_POOL,
		ITEM_EFFECT_TYPE_ETERNAL_SMELTING_POINT,
		ITEM_EFFECT_TYPE_SLATE
	};
	public static final String[] ITEM_EFFECTS_TYPE_CURRENCY_NAMES = {
		"金币",
		"钻石",
		"灵气",
		"伙伴经验",
		"熔炼点数",
		"上古石板"
	};
	/**
	 * 得到道具类型名称
	 * @param goodsType
	 * @return
	 */
	public static String getGoodsTypeName(int goodsType){
		String name = getTypeName(goodsType, ITEM_EFFECT_TYPES, ITEM_EFFECTS_TYPE_NAMES);
		if(name.length() <= 0){
			name = getTypeName(goodsType, ITEM_EFFECTS_TYPE_CURRENCY, ITEM_EFFECTS_TYPE_CURRENCY_NAMES);
		}
		return name;
	}

	/********************************** 系统系数  ************************************************/
	public static final int STOP_SERVER_CODE = -101010;
	/**比值基数10000(double)*/
	public static final double PERCENT_BASE_DOUBLE = 10000d;
	/**比值基数10000(int)*/
	public static final int PERCENT_BASE_INT = 10000;

	/********************************** 日志  ************************************************/
	/**日志类型(英雄/伙伴)*/
	public static final int LOGGER_TYPE_HERO = 1;
	/**日志类型(钻石)*/
	public static final int LOGGER_TYPE_DIAMOND = 2;
	/**日志类型(金币)*/
	public static final int LOGGER_TYPE_GOLD = 3;
	/**日志类型(灵值/神之召唤点)*/
	public static final int LOGGER_TYPE_GP = 4;
	/**日志类型(经验)*/
	public static final int LOGGER_TYPE_EXP = 5;
	/**日志类型(道具)*/
	public static final int LOGGER_TYPE_PROP = 6;
	/**日志类型(体力)*/
	public static final int LOGGER_TYPE_STAMINA = 7;
	/**日志类型(英雄经验池)*/
	public static final int LOGGER_TYPE_HERO_EXP_POOL = 8;
	/**日志类型(装备)*/
	public static final int LOGGER_TYPE_EQUIPMENT = 9;
	/**日志类型(武魂)*/
	public static final int LOGGER_TYPE_ETERNAL = 10;
	/**日志类型(石板)*/
	public static final int LOGGER_TYPE_SLATE = 11;
	
	/********************************** 日志产生途径 ************************************************/
	public static final int LOGGER_APPROACH = -1;
	public static final int LOGGER_APPROACH_扩充背包容量 = 1;
	public static final int LOGGER_APPROACH_进化消耗 = 2;
	public static final int LOGGER_APPROACH_召唤消耗 = 3;
	public static final int LOGGER_APPROACH_邮件获得 = 4;
	public static final int LOGGER_APPROACH_清除竞技场CD时间 = 5;
	public static final int LOGGER_APPROACH_增加竞技场次数 = 6;
	public static final int LOGGER_APPROACH_创建公会 = 7;
	public static final int LOGGER_APPROACH_修改公会名称 = 8;
	public static final int LOGGER_APPROACH_商城购买 = 9;
	public static final int LOGGER_APPROACH_探索获得 = 10;
	public static final int LOGGER_APPROACH_成就奖励 = 11;
	public static final int LOGGER_APPROACH_登录奖励 = 12;
	public static final int LOGGER_APPROACH_刷新商场 = 13;
	public static final int LOGGER_APPROACH_勇气商店兑换 = 14;
	public static final int LOGGER_APPROACH_购买武道大会次数 = 15;
	public static final int LOGGER_APPROACH_副本星数奖励 = 16;
	public static final int LOGGER_APPROACH_购买金币 = 17;
	public static final int LOGGER_APPROACH_购买体力 = 18;
	public static final int LOGGER_APPROACH_补签消耗 = 19;
	public static final int LOGGER_APPROACH_签到获得 = 20;
	public static final int LOGGER_APPROACH_扫荡消耗 = 21;
	public static final int LOGGER_APPROACH_刷新黑市 = 22;
	public static final int LOGGER_APPROACH_升级名望奖励 = 23;
	public static final int LOGGER_APPROACH_任务活跃度宝箱奖励 = 24;
	public static final int LOGGER_APPROACH_任务奖励 = 25;
	public static final int LOGGER_APPROACH_改玩家名字 = 26;
	public static final int LOGGER_APPROACH_增加经验池上限 = 27;
	public static final int LOGGER_APPROACH_增加熔炼池上限 = 28;
	public static final int LOGGER_APPROACH_出售装备 = 29;
	public static final int LOGGER_APPROACH_登陆奖励 = 30;
	public static final int LOGGER_APPROACH_竞技场兑换 = 31;
	public static final int LOGGER_APPROACH_熔炼消耗 = 32;
	public static final int LOGGER_APPROACH_拆下武魂 = 33;
	public static final int LOGGER_APPROACH_开炉获得 = 34;
	public static final int LOGGER_APPROACH_出售武魂 = 35;
	public static final int LOGGER_APPROACH_副本获得 = 36;
	public static final int LOGGER_APPROACH_使用道具获得 = 37;
	public static final int LOGGER_APPROACH_竞技场获得 = 38;
	public static final int LOGGER_APPROACH_武道大会= 39;
	public static final int LOGGER_APPROACH_扫荡获得 = 40;
	public static final int LOGGER_APPROACH_强化消耗 = 41;
	public static final int LOGGER_APPROACH_出售英雄获得 = 42;
	public static final int LOGGER_APPROACH_副本掉落 = 43;
	public static final int LOGGER_APPROACH_竞技场挑战奖励 = 44;
	public static final int LOGGER_APPROACH_强化装备消耗 = 45;
	public static final int LOGGER_APPROACH_出售道具 = 46;
	public static final int LOGGER_APPROACH_出售武魂获得 = 47;
	public static final int LOGGER_APPROACH_勇气兑换= 48;
	public static final int LOGGER_APPROACH_购买金币获得 = 49;
	public static final int LOGGER_APPROACH_突破激活灵元点 = 50;
	public static final int LOGGER_APPROACH_领取雇佣GP = 51;
	public static final int LOGGER_APPROACH_分解获得 = 52;
	public static final int LOGGER_APPROACH_升级消耗 = 53;
	public static final int LOGGER_APPROACH_掉落获得 = 54;
	public static final int LOGGER_APPROACH_注册赠送 = 55;
	public static final int LOGGER_APPROACH_英雄升级 = 56;
	public static final int LOGGER_APPROACH_英雄进化消耗 = 57;
	public static final int LOGGER_APPROACH_英雄进化 = 58;
	public static final int LOGGER_APPROACH_召唤获得 = 59;
	public static final int LOGGER_APPROACH_出售英雄 = 60;
	public static final int LOGGER_APPROACH_分解消耗 = 61;
	public static final int LOGGER_APPROACH_武魂熔炼 = 62;
	public static final int LOGGER_APPROACH_使用道具 = 63;
	public static final int LOGGER_APPROACH_战场复活 = 64;
	public static final int LOGGER_APPROACH_装备武魂 = 65;
	public static final int LOGGER_APPROACH_升级装备消耗 = 66;
	public static final int LOGGER_APPROACH_战斗获得 = 67;
	public static final int LOGGER_APPROACH_免费领取 = 68;
	public static final int LOGGER_APPROACH_战斗消耗 = 69;
	public static final int LOGGER_APPROACH_自动回体 = 70;
	public static final int LOGGER_APPROACH_好友赠送 = 71;
	public static final int LOGGER_APPROACH_购买体力获得 = 72;
	public static final int LOGGER_APPROACH_后台操作 = 73;
	public static final int LOGGER_APPROACH_玩家升级 = 74;
	public static final int LOGGER_APPROACH_刷新包子铺 = 75;
	public static final int LOGGER_APPROACH_特权获得 = 76;
	public static final int LOGGER_APPROACH_领取通用奖励 = 77;
	public static final int LOGGER_APPROACH_自动获得通用奖励 = 78;
	public static final int LOGGER_APPROACH_开启宝箱 = 79;
	public static final int LOGGER_APPROACH_订单发货 = 80;
	public static final int LOGGER_APPROACH_订单发货_额外获得 = 81;
	
	/**日志类型*/
	public static final int[] LOGGER_APPROACH_TYPES = {
		LOGGER_APPROACH_扩充背包容量,
		LOGGER_APPROACH_进化消耗,
		LOGGER_APPROACH_召唤消耗,
		LOGGER_APPROACH_邮件获得,
		LOGGER_APPROACH_清除竞技场CD时间,
		LOGGER_APPROACH_增加竞技场次数,
		LOGGER_APPROACH_创建公会,
		LOGGER_APPROACH_修改公会名称,
		LOGGER_APPROACH_商城购买,
		LOGGER_APPROACH_探索获得,
		LOGGER_APPROACH_成就奖励,
		LOGGER_APPROACH_登录奖励,
		LOGGER_APPROACH_刷新商场,
		LOGGER_APPROACH_勇气商店兑换,
		LOGGER_APPROACH_购买武道大会次数,
		LOGGER_APPROACH_副本星数奖励,
		LOGGER_APPROACH_购买金币,
		LOGGER_APPROACH_购买体力,
		LOGGER_APPROACH_补签消耗,
		LOGGER_APPROACH_签到获得,
		LOGGER_APPROACH_扫荡消耗,
		LOGGER_APPROACH_刷新黑市,
		LOGGER_APPROACH_升级名望奖励,
		LOGGER_APPROACH_任务活跃度宝箱奖励,
		LOGGER_APPROACH_任务奖励,
		LOGGER_APPROACH_改玩家名字,
		LOGGER_APPROACH_增加经验池上限,
		LOGGER_APPROACH_增加熔炼池上限,
		LOGGER_APPROACH_出售装备,
		LOGGER_APPROACH_登陆奖励,
		LOGGER_APPROACH_竞技场兑换,
		LOGGER_APPROACH_熔炼消耗,
		LOGGER_APPROACH_拆下武魂,
		LOGGER_APPROACH_开炉获得,
		LOGGER_APPROACH_出售武魂,
		LOGGER_APPROACH_副本获得,
		LOGGER_APPROACH_使用道具获得,
		LOGGER_APPROACH_竞技场获得,
		LOGGER_APPROACH_武道大会,
		LOGGER_APPROACH_扫荡获得,
		LOGGER_APPROACH_强化消耗,
		LOGGER_APPROACH_出售英雄获得,
		LOGGER_APPROACH_副本掉落,
		LOGGER_APPROACH_竞技场挑战奖励,
		LOGGER_APPROACH_强化装备消耗,
		LOGGER_APPROACH_出售道具,
		LOGGER_APPROACH_出售武魂获得,
		LOGGER_APPROACH_勇气兑换,
		LOGGER_APPROACH_购买金币获得,
		LOGGER_APPROACH_突破激活灵元点,
		LOGGER_APPROACH_领取雇佣GP,
		LOGGER_APPROACH_分解获得,
		LOGGER_APPROACH_升级消耗,
		LOGGER_APPROACH_掉落获得,
		LOGGER_APPROACH_注册赠送,
		LOGGER_APPROACH_英雄升级,
		LOGGER_APPROACH_英雄进化消耗,
		LOGGER_APPROACH_英雄进化,
		LOGGER_APPROACH_召唤获得,
		LOGGER_APPROACH_出售英雄,
		LOGGER_APPROACH_分解消耗,
		LOGGER_APPROACH_武魂熔炼,
		LOGGER_APPROACH_使用道具,
		LOGGER_APPROACH_战场复活,
		LOGGER_APPROACH_装备武魂,
		LOGGER_APPROACH_升级装备消耗,
		LOGGER_APPROACH_战斗获得,
		LOGGER_APPROACH_免费领取,
		LOGGER_APPROACH_战斗消耗,
		LOGGER_APPROACH_自动回体,
		LOGGER_APPROACH_好友赠送,
		LOGGER_APPROACH_购买体力获得,
		LOGGER_APPROACH_后台操作,
		LOGGER_APPROACH_玩家升级,
		LOGGER_APPROACH_刷新包子铺,
		LOGGER_APPROACH_特权获得,
		LOGGER_APPROACH_领取通用奖励,
		LOGGER_APPROACH_自动获得通用奖励,
		LOGGER_APPROACH_开启宝箱,
		LOGGER_APPROACH_订单发货,
		LOGGER_APPROACH_订单发货_额外获得
	};
	/**日志类型*/
	public static final String[] LOGGER_APPROACH_TYPE_NAMES = {
		"扩充背包容量",
		"进化消耗",
		"召唤消耗",
		"邮件获得",
		"清除竞技场CD时间",
		"增加竞技场次数",
		"创建公会",
		"修改公会名称",
		"商城购买",
		"探索获得",
		"成就奖励",
		"登录奖励",
		"刷新商场",
		"勇气商店兑换",
		"购买武道大会次数",
		"副本星数奖励",
		"购买金币",
		"购买体力",
		"补签消耗",
		"签到获得",
		"扫荡消耗",
		"刷新黑市",
		"升级名望奖励",
		"任务活跃度宝箱奖励",
		"任务奖励",
		"改玩家名字",
		"增加经验池上限",
		"增加熔炼池上限",
		"出售装备",
		"登陆奖励",
		"竞技场兑换",
		"熔炼消耗",
		"拆下武魂",
		"开炉获得",
		"出售武魂",
		"副本获得",
		"使用道具获得",
		"竞技场获得",
		"武道大会",
		"扫荡获得",
		"强化消耗",
		"出售英雄获得",
		"副本掉落",
		"竞技场挑战奖励",
		"强化装备消耗",
		"出售道具",
		"出售武魂获得",
		"勇气兑换",
		"购买金币获得",
		"突破激活灵元点",
		"领取雇佣GP",
		"分解获得",
		"升级消耗",
		"掉落获得",
		"注册赠送",
		"英雄升级",
		"英雄进化消耗",
		"英雄进化",
		"召唤获得",
		"出售英雄",
		"分解消耗",
		"武魂熔炼",
		"使用道具",
		"战场复活",
		"装备武魂",
		"升级装备消耗",
		"战斗获得",
		"免费领取",
		"战斗消耗",
		"自动回体",
		"好友赠送",
		"购买体力获得",
		"后台操作",
		"玩家升级",
		"刷新包子铺",
		"特权获得",
		"领取通用奖励",
		"自动获得通用奖励",
		"开启宝箱",
		"订单发货",
		"订单发货(额外获得)"
	};
	/**
	 * 得到日志类型名称
	 * @param goodsType
	 * @return
	 */
	public static String getLoggerApproachName(int type){
		return getTypeName(type, LOGGER_APPROACH_TYPES, LOGGER_APPROACH_TYPE_NAMES);
	}

	/********************************** 日志事件 ************************************************/
	/**日志事件（游戏）*/
	public static final int LOG_EVENT_TYPE_GAME = 0;
	/**日志事件（用户活跃）*/
	public static  final int LOG_EVENT_TYPE_ACTICE = 1;
	/**日志事件（副本战斗）*/
	public static final int LOG_EVENT_TYPE_BATTLE = 2;
	
	/********************************** 竞技场 ************************************************/
	public static final int ARENA_LOGGER_TYPE_竞技场 = 1;
	public static final int ARENA_LOGGER_TYPE_武道大会 = 2;
	public static final int[] ARENA_LOGGER_TYPES = {ARENA_LOGGER_TYPE_竞技场, ARENA_LOGGER_TYPE_武道大会};
	/**购买挑战次数获得数量*/
	public static int ARENA_BUY_NUMBER_ADD;
	/**可购买挑战次数*/
	public static int ARENA_BUY_NUMBER;
	/**竞技场可挑战次数上限*/
	public static int ARENA_MAX_NUMBER;
	/**竞技场每日可挑战次数*/
	public static int ARENA_DAILY_NUMBER;
	/**竞技场商店可刷新次数*/
	public static int ARENA_MALL_REFRESH_NUMBER;
	/**清除冷却CD所需钻石*/
	public static int ARENA_CLEAR_CD_DIAMOND;
	/**竞技场获胜获得勇气值*/
	public static int ARENA_WIN_AWARD_VALOUR;
	/**竞技场开放等级*/
	public static int ARENA_OPEN_LEVEL;
	
	/********************************** 战斗 ************************************************/
	public static final int FIGHT_TYPE_普通攻击 = 1;
	public static final int FIGHT_TYPE_暴击 = 2;
	public static final int FIGHT_TYPE_闪避 = 3;
	public static final int FIGHT_TYPE_格挡 = 4;
	/**连击加成*/
	public static final double[] FIGHT_ATTACK_ADDITION = new double[]{100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400};
	/**对战发起者*/
	public static final int FIGHT_AGAINST_TYPE_发起者 = 1;
	/**对战发起者*/
	public static final int FIGHT_AGAINST_TYPE_接受者 = 2;
	/**怪物ai*/
	public static final String FIGHT_AI_MONSTER_AI = "monsterAI";
	/**计算战斗力*/
	public static final int FIGHT_TYPE_TEST = -1;
	/**副本战斗*/
	public static final int FIGHT_TYPE_ZONE = 1;
	/**对战*/
	public static final int FIGHT_TYPE_PVP = 2;
	/**在线对战*/
	public static final int FIGHT_TYPE_ONLINE_PVP = 3;
	/**武道大会*/
	public static final int FIGHT_TYPE_MARTIAL_WAY=4;
	/**fight model*/
	public static final int FIGHT_MODEL_STATE_正常 = 1;
	public static final int FIGHT_MODEL_STATE_死亡 = 2;
	/**atk mode*/
	public static final int FIGHT_ATK_MODE_DIR_左上 = 0;
	//public static final int FIGHT_ATK_MODE_DIR_上 = 1;
	public static final int FIGHT_ATK_MODE_DIR_右上 = 2;
	public static final int FIGHT_ATK_MODE_DIR_右 = 3;
	public static final int FIGHT_ATK_MODE_DIR_右下 = 4;
	//public static final int FIGHT_ATK_MODE_DIR_下 = 5;
	public static final int FIGHT_ATK_MODE_DIR_左下 = 6;
	public static final int FIGHT_ATK_MODE_DIR_左 = 7;
	/**战斗格子*/
	public static final int FIGHT_GRID_ITEM_障碍物 = 100;
	public static final int FIGHT_GRID_ITEM_陷阱 = 101;
	public static final int FIGHT_GRID_ITEM_据点 = 102;
	public static final int FIGHT_GRID_ITEM_泉水 = 103;
	public static final int FIGHT_GRID_ITEM_石板 = 200;
	public static final int FIGHT_GRID_ITEM_红心 = 300;
	public static final int FIGHT_GRID_ITEM_敏捷 = 301;
	public static final int FIGHT_GRID_ITEM_暴击 = 302;
	public static final int FIGHT_GRID_ITEM_双倍 = 303;
	public static final int FIGHT_GRID_ITEM_减伤= 304;
	public static final int[] FIGHT_GRID_ITEMS = new int[]{FIGHT_GRID_ITEM_红心, FIGHT_GRID_ITEM_敏捷, FIGHT_GRID_ITEM_暴击, FIGHT_GRID_ITEM_双倍, FIGHT_GRID_ITEM_减伤};

	public static final char FIGHT_MODE_不能移动 = '0';
	public static final char FIGHT_MODE_移动一格 = '1';
	public static final char FIGHT_MODE_移动多格 = '2';
	/**火*/
	public static final int FIGHT_ELE_FIRE = 1;
	/**木*/
	public static final int FIGHT_ELE_WOOD =2;
	/**水*/
	public static final int FIGHT_ELE_WATER = 3;
	/**光*/
	public static final int FIGHT_ELE_LIGHT = 4;
	/**暗*/
	public static final int FIGHT_ELE_DARK = 5;
	/**防守方攻击模型数组*/
	public static final int[] FIGHT_DEF_ATK_MODEL = new int[]{2,1,0,7,6,5,4,3};
	/**属性克制 RESTRAINT[x][0] 伤害加成 RESTRAINT[x][1] 伤害减免  RESTRAINT[x]属性等级*/
	public static final double[][] FIGHT_RESTRAINT = new double[][]{{1.2,1},{1.25,0.95},{1.3,0.85}};
	/**buff状态*/
	public static final int FIGHT_BUFF_STATE_强 = 1;
	public static final int FIGHT_BUFF_STATE_普通 = 2;
	public static final int FIGHT_BUFF_STATE_边缘 = 3;

	/********************************** 武道大会  ************************************************/
	/**武道会胜利积分*/
	public static int MARTIAL_WAY_WIN_SCORE;
	/**武道会失败积分*/
	public static int MARTIAL_WAY_LOSE_SCORE;
	/**武道大会开放等级*/
	public static int MARTIAL_WAY_OPEN_LEVEL;
	/**武道大会每日参加次数*/
	public static int MARTIAL_WAY_DAILY_NUMBER;
	/**武道大会购买获得次数*/
	public static int MARTIAL_WAY_BUY_GAIN_NUMBER;
	/**武道大会最大购买次数*/
	public static int MARTIAL_WAY_MAX_BUY_NUMBER;
	
	
	/********************************** 伙伴 ************************************************/
	/**gold召唤*/
	public static final int HERO_TYPE_GOLD_CALL = 1;
	/**钻石召唤*/
	public static final int HERO_TYPE_DIAMOND_CALL = 2;
	/**免费gold召唤*/
	public static final int HERO_TYPE_FREE_GOLD_CALL = 3;
	/**免费钻石召唤*/
	public static final int HERO_TYPE_FREE_DIAMOND_CALL = 4;
	/**金币召唤一次伙伴消耗*/
	public static int HERO_CALL_ONE_GOLD;
	/**金币召唤十次伙伴消耗*/
	public static int HERO_CALL_TEN_GOLD;
	/**钻石召唤一次伙伴消耗*/
	public static int HERO_CALL_ONE_DIAMOND;
	/**钻石召唤十次伙伴消耗*/
	public static int HERO_CALL_TEN_DIAMOND;
	/**免费金币召唤次数*/
	public static int HERO_CALL_GOLD_FREE = 3;
	/**免费金币召唤次数CD(秒)*/
	public static int HERO_CALL_GOLD_FREE_CD = 30 * 60;
	/**免费钻石召唤次数CD*/
	public static int HERO_CALL_DIAMOND_FREE_CD = 48 * 60 * 60;
	/**首次钻石召唤伙伴id*/
	public static int HERO_FIRST_DIAMOND_CALL_ID;
	/**伙伴规则*/
	public static double[][] HERO_RULE_LEVEL_UP = new double[][]{{1, 1},{1.1, 1},{1.3, 1},{1.5, 1.2},
		{1.7, 1.2},{1.9, 1.2},{2.1, 1.4},{2.3, 1.4},{2.5, 1.4},{2.7, 1.6}};
	/**升级类型加成*/
	public static final int[] HERO_UP_TYPE_VAL = new int[]{100, 120, 130};
	
	
	public static String getTypeName(int type, int[] types, String[] names){
		for(int index = 0; index < names.length; index++){
			if(types[index] == type){
				return names[index];
			}
		}
		return "";
	}
	
	/********************************** 特权类型  ************************************************/
	/**1.购买体力次数*/
	public static final int PRIVILEGE_TYPE_BUY_STAMINA_NUMBER = 1;
	/**2.购买金币次数*/
	public static final int PRIVILEGE_TYPE_BUY_GOLD_NUMBER = 2;
	/**3.竞技场挑战次数可购买次数*/
	public static final int PRIVILEGE_TYPE_BUY_ATHLETICS_NUMBER = 3;
	/**4.竞技场商店刷新次数*/
	public static final int PRIVILEGE_TYPE_ATHLETICS_REFRESH_NUMBER = 4;
	/**5.武道大会购买次数*/
	public static final int PRIVILEGE_TYPE_BUY_MARTIAL_WAY_NUMBER = 5;
	/**6.好友上限*/
	public static final int PRIVILEGE_TYPE_MAX_FRIEND_NUMBER = 6;
	/**7.经验池上限*/
	public static final int PRIVILEGE_TYPE_EXP_POOL_MAX_LIMIT = 7;
	/**8.熔炼池上限*/
	public static final int PRIVILEGE_TYPE_ETERNAL_SMELTING_MAX_LIMIT = 8;
	/**9.黑市刷新次数*/
	public static final int PRIVILEGE_TYPE_BLACK_SHOP_REFRESH_NUMBER = 9;
	/**10.签到双倍宝箱天数*/
	public static final int PRIVILEGE_TYPE_SIGN_BOX_DOUBLE_DAY = 10;
	/**11.包子铺可参与次数*/
	public static final int PRIVILEGE_TYPE_BREAD_STORE_NUMBER = 11;
	/**12.财神殿可参与次数*/
	public static final int PRIVILEGE_TYPE_GOD_WEALTH_NUMBER = 12;
	/**13.灵气殿可参与次数*/
	public static final int PRIVILEGE_TYPE_ANIMA_TEMPLE_NUMBER = 13;
	/**14.包子铺钻石刷新次数*/
	public static final int PRIVILEGE_TYPE_BREAD_STORE_DIAMOND_REFRESH_NUMBER = 14;
	/**15.补签次数*/
	public static final int PRIVILEGE_TYPE_FILL_SIGNIN_NUMBER = 15;
	/**16.赠送道具(服务端不处理)*/
	public static final int PRIVILEGE_TYPE_SEND_DROP = 16;
	/**17.是否开启十次扫荡功能*/
	public static final int PRIVILEGE_TYPE_OPEN_TEN_SWEEP = 17;
	
	
	/********************************** 试练系统  ************************************************/
	/**包子铺免费刷新次数*/
	public static int TRIALS_BREAD_STORE_REFRESH_NUMBER;
	/**包子铺钻石刷新价格*/
	public static int TRIALS_BREAD_STORE_DIAMOND_REFRESH_PRICE;
	/**包子铺元素概率*/
	public static int TRIALS_BREAD_STORE_DIAMOND_ELEMENT_PROBABILITY;
	

	/********************************** 条件  ************************************************/
	/**条件类型-玩家等级*/
	public static final int CONDITION_TYPE_USER_LEVEL = 1;
	/**条件类型-vip等级*/
	public static final int CONDITION_TYPE_VIP_LEVEL = 2;
	/**条件类型-指定vip等级*/
	public static final int CONDITION_TYPE_APPOINT_VIP_LEVEL = 3;
	
	/********************************** 活动  ************************************************/
	/**周期活动类型-开启财神殿*/
	public static final int PERIOD_TYPE_OPEN_GOD_WEALTH = 1;
	/**周期活动类型-开启灵气殿*/
	public static final int PERIOD_TYPE_OPEN_ANIMA_TEMPLE = 2;
	/**周期活动类型-包子铺双倍时间*/
	public static final int PERIOD_TYPE_DOUBLE_BREAD_STORE = 3;
	/**周期活动类型-财神殿双倍时间*/
	public static final int PERIOD_TYPE_DOUBLE_GOD_WEALTH = 4;
	/**周期活动类型-灵气殿双倍时间*/
	public static final int PERIOD_TYPE_DOUBLE_ANIMA_TEMPLE = 5;
	
	/********************************** 支付商品  ************************************************/
	/**支付类型(钻石)*/
	public static final int PAY_TYPE_DIAMOND = 1;
	/**支付类型(周期卡)*/
	public static final int PAY_TYPE_CYCLE_CARD = 2;
	/**支付订单状态(二次验证失败)*/
	public static final int PAY_BILL_TOW_VALID_LOSS = -2;
	/**支付订单状态(订单服务器不存在)*/
	public static final int PAY_BILL_STATE_NO_SERVER = -1;
	/**支付订单状态(初始)*/
	public static final int PAY_BILL_STATE0 = 0;
	/**支付订单状态(确认)*/
	public static final int PAY_BILL_STATE1 = 1;
	/**支付订单状态(完成)*/
	public static final int PAY_BILL_STATE2 = 2;
	/**月卡ID*/
	public static final int PAY_MONTH_CARD_ID = 7;
	/**周卡ID*/
	public static final int PAY_WEEK_CARD = 8;

	/********************************** 服务器类型  ************************************************/
	/**服务器类型（测试）-web使用*/
	public static final int SERVER_TYPE_DEBUG = 0;
	/**服务器类型（正式）*/
	public static final int SERVER_TYPE_OFFICIAL = 1;
	
	/**
	 *  //TODO 初始化常数
	 * @param cache 
	 */
	public static void init(Map<String, ConstantConfig> cache){
		Constant.init(cache);
	}
}
