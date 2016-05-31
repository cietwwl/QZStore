package com.ks.logic.service.impl;

import com.ks.db.log.ActiveLogger;
import com.ks.db.log.GameLogger;
import com.ks.db.log.ZoneBattleLogger;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.GameLoggerService;

public class GameLoggerServiceImpl extends BaseService implements GameLoggerService {

	@Override
	public void addGameLogger(GameLogger logger) {
		gameLoggerDAO.addGameLogger(logger);
	}

	@Override
	public ActiveLogger queryActiveLogger(int userId, int partner, int startTime, int endTime){
		return gameLoggerDAO.queryActiveLogger(userId, partner, startTime, endTime);
	}
	
	@Override
	public void updateActiveLogger(ActiveLogger logger){
		gameLoggerDAO.updateActiveLogger(logger);
	}

	@Override
	public void addZoneBattleLogger(ZoneBattleLogger logger){
		gameLoggerDAO.addZoneBattleLogger(logger);
	}

	@Override
	public ZoneBattleLogger queryZoneBattleLogger(int userId, int zoneBattleId){
		return gameLoggerDAO.queryZoneBattleLogger(userId, zoneBattleId);
	}

	@Override
	public void updateZoneBattleLogger(ZoneBattleLogger logger){
		gameLoggerDAO.updateZoneBattleLogger(logger);
	}

}
