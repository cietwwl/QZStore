package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.ArenaAction;
import com.ks.logic.service.ArenaService;
import com.ks.logic.service.ServiceFactory;
import com.ks.protocol.vo.arena.ArenaInfoVO;
import com.ks.protocol.vo.arena.ArenaLoggerVO;
import com.ks.protocol.vo.arena.ArenaShoppingVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public class ArenaActionImpl implements ArenaAction {
	
	private static final ArenaService arenaService = ServiceFactory.getService(ArenaService.class);
	
	@Override
	public ArenaInfoVO queryArena(int userId) {
		return arenaService.queryArena(userId);
	}

	@Override
	public FightVO playArena(int userId, int rivalUserId) {
		return arenaService.playArena(userId, rivalUserId);
	}

	@Override
	public void clearCdTime(int userId) {
		arenaService.clearCdTime(userId);
	}

	@Override
	public void buyArenaCount(int userId) {
		arenaService.buyArenaCount(userId);
	}

	@Override
	public List<UserBaseinfoVO> queryArenaRank(int type,int userId) {
		return arenaService.queryArenaRankTop50(type,userId);
	}

	@Override
	public List<UserBaseinfoVO> refRival(int userId) {
		return arenaService.refRival(userId, false);
	}

	@Override
	public GainAwardVO ExchangeAward(int userId, int shoppingId) {
		return arenaService.ExchangeAward(userId, shoppingId);
		
	}

	@Override
	public List<ArenaShoppingVO> RefreshShopping(int userId) {
		return arenaService.RefreshShopping(userId);
	}

	@Override
	public List<ArenaLoggerVO> queryArenaLogger(int userId,int type) {
		return arenaService.queryArenaLogger(userId,type);
	}

	@Override
	public void clearArena() {
		arenaService.clearArena();
	}

	@Override
	public void refArenaShopping() {
		arenaService.refArenaShopping();
	}

	@Override
	public void delArenaRank() {
		arenaService.delArenaRank();
	}

}
