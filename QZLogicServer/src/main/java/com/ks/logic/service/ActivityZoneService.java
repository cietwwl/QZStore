package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.ActivityZone;

/**
 * 获得副本
 * @author ks
 */
public interface ActivityZoneService {
	/**
	 * 查询所有活动副本
	 * @return 所有活动副本
	 */
	List<ActivityZone> queryZoneActivity();
}
