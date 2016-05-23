package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.Achieve;
import com.ks.db.cfg.AchieveAward;
import com.ks.logic.service.AchieveService;
import com.ks.logic.service.BaseService;

public class AchieveServiceImpl extends BaseService implements AchieveService {

	@Override
	public List<Achieve> queryAchieves() {
		return achieveDAO.queryAchieves();
	}

	@Override
	public List<AchieveAward> queryAchieveAwards() {
		return achieveDAO.queryAchieveAwards();
	}
}
