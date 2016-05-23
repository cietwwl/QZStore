package com.ks.protocol.sub;

public interface UserHeroCMD {
	/**增加背包容量*/
	short ADD_BACKAGE_CAPACITY = 1;
	/**锁定*/
	short LOCKED_HERO = 2;
	/**解锁*/
	short UN_LOCKED_HERO = 3;
	/**升级英雄*/
	short LEVEL_UP_HERO = 4;
	/**进化英雄*/
	short EVOLUTION_HERO = 5;
	/**召唤英雄*/
	short CALL_HERO = 6;
	/**召唤英雄*/
	short SELL_HERO = 7;
	/**获得用户英雄图鉴*/
	short GAIN_USER_HERO_MAP = 8;
	/**获得探索*/
	short GAIN_USER_EXPLORE = 9;
	/**开始探索*/
	short START_EXPLORE = 10;
	/**获得探索奖励*/
	short GAIN_EXPLORE_AWARD = 11;
	/**分解英雄*/
	short RESOLVE_HERO = 12;
	/**激活突破灵元点*/
	short ACTIVE_BREAK_SLOT = 13;
	/**英雄突破*/
	short HERO_BREAK = 14;
}
