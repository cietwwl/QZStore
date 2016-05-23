package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.BlowingRule;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.PropEffect;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.PropService;

public class PropServiceImpl extends BaseService implements PropService {

	@Override
	public List<Prop> queryProps() {
		return propDAO.queryProps();
	}

	@Override
	public List<PropEffect> queryPropEffects() {
		return propDAO.queryPropEffects();
	}
	@Override
	public List<BlowingRule> queryBlowingRule() {
		return propDAO.queryBlowingRule();
	}
}
