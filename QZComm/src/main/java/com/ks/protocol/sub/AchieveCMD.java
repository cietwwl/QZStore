package com.ks.protocol.sub;

public interface AchieveCMD {
	
	/**查询成就*/
	short QUERY_USER_ACHIEVE = 1;
	/**成就修改*/
	short ACHIEVE_UPDATE = 2;
	/**获得成就奖励*/
	short GAIN_ACHIEVE_AWARD = 3;
}
