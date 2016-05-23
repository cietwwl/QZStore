package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.ConstantConfig;

public interface ConstantService {

	/**
	 * 查询常数
	 */
	List<ConstantConfig> queryConstantConfigs();
}
