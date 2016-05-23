package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.PeriodActivityTime;

public interface ActivityService {
	
	/**
	 * 查询周期活动时间
	 */
	List<PeriodActivityTime> queryPeriodActivityTimes();
	
	/**
	 * 是否多倍活动时间
	 * @param zoneId
	 * @return
	 */
	boolean isMultTime(int zoneId);
	
	/**
	 * 是否开启活动时间
	 * @param zoneId
	 * @return
	 */
	boolean isOpenTime(int zoneId);
	
	/**
	 * 获取倍数
	 * @param zoneId
	 * @return
	 */
	int getMultNumByZoneId(int zoneId);

}
