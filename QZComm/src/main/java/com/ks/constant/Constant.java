package com.ks.constant;
import com.ks.db.cfg.ConstantConfig;
import java.util.Map;
public class Constant{

	public static int getValue(ConstantConfig config){
		if(config == null){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
				System.exit(0);
			}
		}
		return config.getValue();
	}
	public static void init(Map<String, ConstantConfig> cache){
		/**1-最大好友数*/
		SystemConstant.FRIEND_MAX_FRIEND_COUNT = getValue(cache.get("FRIEND_MAX_FRIEND_COUNT"));
		/**2-金币创建公会消耗*/
		SystemConstant.GUILD_CREATE_GOLD_PRICE = getValue(cache.get("GUILD_CREATE_GOLD_PRICE"));
		/**3-钻石创建公会消耗*/
		SystemConstant.GUILD_CREATE_DIAMOND_PRICE = getValue(cache.get("GUILD_CREATE_DIAMOND_PRICE"));
		/**4-修改公会名称消耗钻石*/
		SystemConstant.GUILD_AMEND_NAME_DIAMOND = getValue(cache.get("GUILD_AMEND_NAME_DIAMOND"));
		/**5-刷新黑市钻石消耗*/
		SystemConstant.MALL_REFRESH_BLACK_MARKET = getValue(cache.get("MALL_REFRESH_BLACK_MARKET"));
		/**6-技能最高等级*/
		SystemConstant.SKILL_MAX_LEVEL = getValue(cache.get("SKILL_MAX_LEVEL"));
		/**7-玩家初始金币*/
		SystemConstant.USER_INIT_GOLD = getValue(cache.get("USER_INIT_GOLD"));
		/**8-玩家初始钻石*/
		SystemConstant.USER_INIT_DIAMOND = getValue(cache.get("USER_INIT_DIAMOND"));
		/**9-玩家初始灵值*/
		SystemConstant.USER_INIT_GP = getValue(cache.get("USER_INIT_GP"));
		/**10-玩家初始累计充值*/
		SystemConstant.USER_INIT_CHARGE_DIAMOND = getValue(cache.get("USER_INIT_CHARGE_DIAMOND"));
		/**11-体力恢复所需时间(秒)*/
		SystemConstant.USER_REGAIN_STAMINA_TIME = getValue(cache.get("USER_REGAIN_STAMINA_TIME"));
		/**12-玩家初始等级*/
		SystemConstant.USER_MIN_LEVEL = getValue(cache.get("USER_MIN_LEVEL"));
		/**13-玩家最大等级*/
		SystemConstant.USER_MAX_LEVEL = getValue(cache.get("USER_MAX_LEVEL"));
		/**14-可购买金币次数*/
		SystemConstant.USER_BUY_GOLD_NUMBER = getValue(cache.get("USER_BUY_GOLD_NUMBER"));
		/**15-购买金币获得*/
		SystemConstant.USER_BUY_GOLD_GAIN = getValue(cache.get("USER_BUY_GOLD_GAIN"));
		/**16-购买金币消耗钻石上限*/
		SystemConstant.USER_BUY_GOLD_MAX_DIAMOND = getValue(cache.get("USER_BUY_GOLD_MAX_DIAMOND"));
		/**17-可购买体力次数*/
		SystemConstant.USER_BUY_STAMINA_NUMBER = getValue(cache.get("USER_BUY_STAMINA_NUMBER"));
		/**18-购买体力获得*/
		SystemConstant.USER_BUY_STAMINA_GAIN = getValue(cache.get("USER_BUY_STAMINA_GAIN"));
		/**19-购买体力消耗钻石上限*/
		SystemConstant.USER_BUY_STAMINA_MAX_DIAMOND = getValue(cache.get("USER_BUY_STAMINA_MAX_DIAMOND"));
		/**20-玩家每升1级获得体力*/
		SystemConstant.USER_UP_LEVEL_GAIN_STAMINA = getValue(cache.get("USER_UP_LEVEL_GAIN_STAMINA"));
		/**21-补签消耗钻石*/
		SystemConstant.USER_SIGNIN_DIAMOND = getValue(cache.get("USER_SIGNIN_DIAMOND"));
		/**22-改名消耗钻石*/
		SystemConstant.USER_CHANGE_NAME_DIAMOND = getValue(cache.get("USER_CHANGE_NAME_DIAMOND"));
		/**23-最大伙伴容量*/
		SystemConstant.USER_MAX_HERO_CAPACITY = getValue(cache.get("USER_MAX_HERO_CAPACITY"));
		/**24-最大装备容量*/
		SystemConstant.USER_MAX_EQUIPMENT_CAPACITY = getValue(cache.get("USER_MAX_EQUIPMENT_CAPACITY"));
		/**25-最大武魂容量*/
		SystemConstant.USER_MAX_ETERNAL_CAPACITY = getValue(cache.get("USER_MAX_ETERNAL_CAPACITY"));
		/**26-扩充背包容量单次价格(钻石)*/
		SystemConstant.USER_HERO_ADD_CAPACITY_PRICE = getValue(cache.get("USER_HERO_ADD_CAPACITY_PRICE"));
		/**27-扩充背包容量单次格子数*/
		SystemConstant.USER_HERO_ADD_CAPACITY_NUMBER = getValue(cache.get("USER_HERO_ADD_CAPACITY_NUMBER"));
		/**28-副本扫荡一次钻石消耗*/
		SystemConstant.ZONE_SWEEP_PRICE = getValue(cache.get("ZONE_SWEEP_PRICE"));
		/**29-竞技场每日挑战次数*/
		SystemConstant.ARENA_DAILY_NUMBER = getValue(cache.get("ARENA_DAILY_NUMBER"));
		/**30-购买一次竞技场挑战次数获得数量*/
		SystemConstant.ARENA_BUY_NUMBER_ADD = getValue(cache.get("ARENA_BUY_NUMBER_ADD"));
		/**31-可购买竞技场挑战次数*/
		SystemConstant.ARENA_BUY_NUMBER = getValue(cache.get("ARENA_BUY_NUMBER"));
		/**32-竞技场可挑战次数上限*/
		SystemConstant.ARENA_MAX_NUMBER = getValue(cache.get("ARENA_MAX_NUMBER"));
		/**33-竞技场商店可刷新次数*/
		SystemConstant.ARENA_MALL_REFRESH_NUMBER = getValue(cache.get("ARENA_MALL_REFRESH_NUMBER"));
		/**34-清除冷却CD所需钻石*/
		SystemConstant.ARENA_CLEAR_CD_DIAMOND = getValue(cache.get("ARENA_CLEAR_CD_DIAMOND"));
		/**35-竞技场获胜获得勇气值*/
		SystemConstant.ARENA_WIN_AWARD_VALOUR = getValue(cache.get("ARENA_WIN_AWARD_VALOUR"));
		/**36-竞技场开放等级*/
		SystemConstant.ARENA_OPEN_LEVEL = getValue(cache.get("ARENA_OPEN_LEVEL"));
		/**37-武道会胜利积分*/
		SystemConstant.MARTIAL_WAY_WIN_SCORE = getValue(cache.get("MARTIAL_WAY_WIN_SCORE"));
		/**38-武道会失败积分*/
		SystemConstant.MARTIAL_WAY_LOSE_SCORE = getValue(cache.get("MARTIAL_WAY_LOSE_SCORE"));
		/**39-武道大会开放等级*/
		SystemConstant.MARTIAL_WAY_OPEN_LEVEL = getValue(cache.get("MARTIAL_WAY_OPEN_LEVEL"));
		/**40-武道大会每日参加次数*/
		SystemConstant.MARTIAL_WAY_DAILY_NUMBER = getValue(cache.get("MARTIAL_WAY_DAILY_NUMBER"));
		/**41-武道大会购买获得次数*/
		SystemConstant.MARTIAL_WAY_BUY_GAIN_NUMBER = getValue(cache.get("MARTIAL_WAY_BUY_GAIN_NUMBER"));
		/**42-武道大会最大购买次数*/
		SystemConstant.MARTIAL_WAY_MAX_BUY_NUMBER = getValue(cache.get("MARTIAL_WAY_MAX_BUY_NUMBER"));
		/**43-金币召唤一次伙伴消耗*/
		SystemConstant.HERO_CALL_ONE_GOLD = getValue(cache.get("HERO_CALL_ONE_GOLD"));
		/**44-金币召唤十次伙伴消耗*/
		SystemConstant.HERO_CALL_TEN_GOLD = getValue(cache.get("HERO_CALL_TEN_GOLD"));
		/**45-钻石召唤一次伙伴消耗*/
		SystemConstant.HERO_CALL_ONE_DIAMOND = getValue(cache.get("HERO_CALL_ONE_DIAMOND"));
		/**46-钻石召唤十次伙伴消耗*/
		SystemConstant.HERO_CALL_TEN_DIAMOND = getValue(cache.get("HERO_CALL_TEN_DIAMOND"));
		/**47-首次钻石召唤伙伴id*/
		SystemConstant.HERO_FIRST_DIAMOND_CALL_ID = getValue(cache.get("HERO_FIRST_DIAMOND_CALL_ID"));
		/**48-包子铺免费刷新次数*/
		SystemConstant.TRIALS_BREAD_STORE_REFRESH_NUMBER = getValue(cache.get("TRIALS_BREAD_STORE_REFRESH_NUMBER"));
		/**49-包子铺钻石刷新价格*/
		SystemConstant.TRIALS_BREAD_STORE_DIAMOND_REFRESH_PRICE = getValue(cache.get("TRIALS_BREAD_STORE_DIAMOND_REFRESH_PRICE"));
		/**50-包子铺元素概率(10000表示100%)*/
		SystemConstant.TRIALS_BREAD_STORE_DIAMOND_ELEMENT_PROBABILITY = getValue(cache.get("TRIALS_BREAD_STORE_DIAMOND_ELEMENT_PROBABILITY"));
			}

}