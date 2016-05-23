package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.ActivityZone;
import com.ks.logic.service.ActivityZoneService;
import com.ks.logic.service.BaseService;

public class ActivityZoneServiceImpl extends BaseService implements
		ActivityZoneService {

	@Override
	public List<ActivityZone> queryZoneActivity() {
		return activityZoneDAO.queryActivityZone();
	}

}