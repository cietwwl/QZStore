package com.ks.protocol.sub;

public interface UserZoneCMD {
	/**查询当前副本*/
	short QUERY_CURR_ZONE = 1;
	/**进入副本*/
	short INTO_ZONE = 2;
	/**查询当前精英副本*/
	short QUERY_CURR_ELITE_ZONE = 3;
	/**查询所有活动副本*/
	short QUERY_ACTIVITY_ZONES = 4;
	/**查询用户副本战场*/
	short QUERY_USER_ZONE_BATTLE = 5;
	/**获得副本奖励*/
	short GAIN_ZONE_AWARD = 7;
	/**获取试练副本*/
	short GAIN_TRIALS_ZONE = 8;
	/**刷新包子铺*/
	short REFRESH_BREAD_STORE = 9;
}
