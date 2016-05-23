package com.ks.protocol.sub;


public interface ArenaCMD {
	
	/**查询竞技场*/
	short QUERY_ARENA=1;
	/**竞技场战斗*/
	short PLAY_ARENA=2;
	/**清除cd时间*/
	short CLEAR_CD_TIME=3;
	/**增加竞技场次数*/
	short ADD_ARENA_COUNT=4;
	/**获得竞技场排名*/
	short QUERY_ARENA_RANK=5;
	/**刷新对手*/
	short REF_RIVAL=6;
	/**刷新商城*/
	short REF_SHOPPING=7;
	/**兑换奖励*/
	short EXCHANGE_AWARD=8;
	/**日志查询*/
	short QUERY_ARENALOGGER=9;
	/**竞技场奖励*/
	short FIGHTING_AWARD=10;
}
