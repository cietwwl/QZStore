package com.ks.protocol.sub;


/**
 * 用户命令
 * @author ks
 */
public interface UserCMD {
	
	/**获取用户数据*/
	short GAIN_USER_INFO = 1;
	/**心跳*/
	short USER_HEART = 2;
	/**获得用户简单信息*/
	short GAIN_USER_SIMPLE_INFO = 3;
	/**查看用户*/
	short VIEW_USER = 4;
	/**获得用户统计*/
	short GAIN_USER_STAT = 5;
	/**领取登录奖励*/
	short DRAW_LOGIN_AWARDS = 6;
	/**领取vip礼包*/
	short DRAW_VIP_GIFI = 7;
	/**修改剧情步骤*/
	short UPDATE_PLOT_STEP = 8;
	/**修改新手步骤*/
	short UPDATE_GUIDE_STEP = 9;
	/**购买金币*/
	short BUY_GOLD = 10;
	/** 购买体力*/
	short BUY_STAMINA=11;
	/**签到*/
	short SIGNIN = 12;
	/**领取签到奖励*/
	short DRAW_SUM_SIGNIN=13;
	/**修改功能解锁*/
	short UPDATE_FUN_UNLOCK=14;
	/**升级声望*/
	short LEVEL_UP_FAME=15;
	/**领取石板*/
	short GAIN_SLATE=16;
	/**取名*/
	short USER_RENAME = 17;
	/**提升英雄经验池上限*/
	short INCRE_EXPPOOL = 18;
	/**提升熔炼池上限*/
	short INCRE_ETERNALSMELTING = 19;
	
	
	
}
