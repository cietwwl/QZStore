package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.Achieve;
import com.ks.db.cfg.AchieveAward;
/**
 * 成就
 * @author ks
 */
public interface AchieveService {
	/**
	 * 查询成就
	 * @return 所有成就
	 */
	public List<Achieve> queryAchieves();
	/**
	 * 查询成就奖励
	 * @return 所有成就奖励
	 */
	public List<AchieveAward> queryAchieveAwards();
	
}
