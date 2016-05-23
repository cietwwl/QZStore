package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.UserZoneAction;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserZoneService;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.zone.ActivityZoneVO;
import com.ks.protocol.vo.zone.TrialsZoneVO;
import com.ks.protocol.vo.zone.UserZoneBattleVO;
import com.ks.protocol.vo.zone.UserZoneVO;

public class UserZoneActionImpl implements UserZoneAction {
	
	private static final UserZoneService userZoneService = ServiceFactory.getService(UserZoneService.class);
	
	@Override
	public List<UserZoneVO> queryCurrZone(int userId) {
		return userZoneService.queryCurrZone(userId);
	}

	@Override
	public FightVO intoZone(int userId, int battleId) {
		return userZoneService.intoZone(userId, battleId);
	}

	@Override
	public UserZoneVO queryCurrEliteZone(int userId, int zoneId) {
		return userZoneService.queryCurrEliteZone(userId, zoneId);
	}

	@Override
	public List<ActivityZoneVO> queryActivityZones(int userId) {
		return userZoneService.queryActivityZones(userId);
	}

	@Override
	public List<UserZoneBattleVO> queryUserZoneBattle(int userId, int zoneId) {
		return userZoneService.queryUserZoneBattle(userId, zoneId);
	}

	@Override
	public GainGameAwardVO gainZoneAward(int userId, int zoneId, int star) {
		return userZoneService.gainZoneAward(userId, zoneId, star);
	}

	@Override
	public TrialsZoneVO gainTrialZones(int userId, int zoneId) {
		return userZoneService.gainTrialZones(userId, zoneId);
	}

	@Override
	public TrialsZoneVO refreshBreadStore(int userId) {
		return userZoneService.refreshBreadStore(userId);
	}

}
