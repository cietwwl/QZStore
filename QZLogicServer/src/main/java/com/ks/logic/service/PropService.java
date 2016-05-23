package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.BlowingRule;
import com.ks.db.cfg.Prop;
import com.ks.db.cfg.PropEffect;

public interface PropService {
	/**
	 * 查询所有道具
	 * @return 所有道具
	 */
	List<Prop> queryProps();
	/**
	 * 查询所有道具效果
	 * @return 所有道具效果
	 */
	List<PropEffect> queryPropEffects();
	
	/**
	 * 查询开炉规则
	 * @return 开炉规则
	 */
	List<BlowingRule> queryBlowingRule();
}
