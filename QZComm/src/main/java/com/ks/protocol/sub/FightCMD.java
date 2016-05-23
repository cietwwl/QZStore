package com.ks.protocol.sub;

public interface FightCMD {
	/**移动*/
	short MOVE = 2;
	/**获得战斗奖励*/
	short GAIN_FIGHT_AWARD = 3;
	/**放弃战斗*/
	short GIVE_UP_FIGHT = 4;
	/**释放技能*/
	short RELEASE_SKILL = 5;
	/**托管*/
	short HOSTING = 6;
	/**获得战斗*/
	short GAIN_FIGHT = 7;
	/**发起战斗*/
	short AGAINST_FIGHT = 8;
	/**取消战斗*/
	short CANCEL_FIGHT = 9;
	/**同意战斗*/
	short AGREED_FIGHT = 10;
	/**请求战斗*/
	short REQUSTER_FIGHT = 11;
	/**战场复活*/
	short FIGHT_REVIVE = 12;
	/**开始在线战斗*/
	short START_ONLINE_FIGHT = 13;
	/**开始在线战斗准备就绪*/
	short START_ONLINE_FIGHT_READY = 14;
	/**扫荡*/
	short SWEEP = 15;
	/**观战*/
	short WATCH = 16;
}
                                                  