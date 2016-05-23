package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.BreadStoreRule;
import com.ks.db.cfg.Zone;
import com.ks.db.cfg.ZoneAward;
import com.ks.db.cfg.ZoneBattle;

public interface ZoneService {
	/**
	 * 查询所有副本
	 * @return 所有副本
	 */
	List<Zone> queryZone();
	/**
	 * 查询所有副本战场
	 * @return 所有副本战场
	 */
	List<ZoneBattle> queryZoneBattle();
	/**
	 * 查询所有副本回合
	 * @return 所有副本回合
	 */
	List<BattleRound> queryBattleRound();
	/**
	 * 获得副本奖励
	 * @return 副本奖励
	 */
	List<ZoneAward> queryZoneAward();
	
	/**
	 * 查询包子铺规则
	 */
	List<BreadStoreRule> queryBreadStoreRules();
}
