package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.BattleRound;
import com.ks.db.cfg.BreadStoreRule;
import com.ks.db.cfg.Zone;
import com.ks.db.cfg.ZoneAward;
import com.ks.db.cfg.ZoneBattle;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.ZoneService;

public class ZoneServiceImpl extends BaseService implements ZoneService {

	@Override
	public List<Zone> queryZone() {
		return zoneDAO.queryZone();
	}

	@Override
	public List<ZoneBattle> queryZoneBattle() {
		return zoneDAO.queryZoneBattle();
	}

	@Override
	public List<BattleRound> queryBattleRound() {
		return zoneDAO.queryBattleRound();
	}

	@Override
	public List<ZoneAward> queryZoneAward() {
		return zoneDAO.queryZoneAward();
	}

	@Override
	public List<BreadStoreRule> queryBreadStoreRules() {
		return zoneDAO.queryBreadStoreRules();
	}
}
