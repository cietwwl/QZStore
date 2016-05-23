package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalEffect;
import com.ks.db.cfg.EternalProperty;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.EternalService;

public class EternalServiceImpl extends BaseService implements EternalService {

	@Override
	public List<Eternal> queryEternals() {
		return eternalDAO.queryEternals();
	}

	@Override
	public List<EternalEffect> queryEternalEffects() {
		return eternalDAO.queryEternalEffects();
	}

	@Override
	public List<EternalProperty> queryEnternalPropertys() {
		return eternalDAO.queryEnternalPropertys();
	}

}
