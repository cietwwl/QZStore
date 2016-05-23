package com.ks.protocol.sub;

public interface MartialWayCMD {
	/**进入武道大会*/
	short ENTER_MARTIAL_WAY = 1;
	/**匹配*/
	short MACH = 2;
	/**取消匹配*/
	short CANCEL_MATCH = 3;
	/**获得武道大会用户*/
	short GAIN_MARTIAL_WAY_USER = 4;
	/**购买次数*/
	short BUY_COUNT = 5;
	/**获得武道大会排名*/
	short GET_MARTIAL_WAY_RANK = 6;
	/**获得武道大会战斗奖励*/
	short GET_MARTIAL_WAY_FIGHT_AWARD = 7;
	
}
