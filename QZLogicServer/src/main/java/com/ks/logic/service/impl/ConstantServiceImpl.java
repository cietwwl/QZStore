package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.ConstantConfig;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.ConstantService;

public class ConstantServiceImpl extends BaseService implements ConstantService {

	@Override
	public List<ConstantConfig> queryConstantConfigs() {
		return constantDao.queryConstantConfigs();
	}

}
