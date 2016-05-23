package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.EternalEffect;
import com.ks.db.cfg.EternalProperty;

public interface EternalService {
	/**
	 * 查询所有武魂
	 * @return 所有武魂
	 */
	List<Eternal> queryEternals();
	/**
	 * 查询所有武魂效果
	 * @return 所有武魂效果
	 */
	List<EternalEffect> queryEternalEffects();
	
	/**
	 * 查询所有武魂随机池
	 * 
	 * @return 武魂随机池
	 */
	public List<EternalProperty> queryEnternalPropertys();
}
