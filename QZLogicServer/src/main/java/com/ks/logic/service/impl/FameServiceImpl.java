package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.Fame;
import com.ks.db.cfg.FameAward;
import com.ks.db.cfg.FameBuff;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.FameService;

public class FameServiceImpl extends BaseService implements FameService {

	@Override
	public List<Fame> queryFame() {
		return fameDAO.queryFame();
	}

	@Override
	public List<FameBuff> queryFameBuff() {
		return fameDAO.queryFameBuff();
	}

	@Override
	public List<FameAward> queryFameAward() {
		return fameDAO.queryFameAward();
	}

}
