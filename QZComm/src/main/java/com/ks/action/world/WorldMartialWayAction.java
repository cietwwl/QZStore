package com.ks.action.world;

import com.ks.model.martial.MartialWay;

public interface WorldMartialWayAction {
	/**
	 * 匹配
	 * @param way
	 */
	void match(MartialWay way);
	/**
	 * 取消匹配
	 * @param way
	 */
	void cancelMatch(int userId);
}
