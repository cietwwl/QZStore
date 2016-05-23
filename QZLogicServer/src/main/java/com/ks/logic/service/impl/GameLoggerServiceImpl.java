package com.ks.logic.service.impl;

import com.ks.db.log.GameLogger;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.GameLoggerService;

public class GameLoggerServiceImpl extends BaseService implements
		GameLoggerService {

	@Override
	public void addGameLogger(GameLogger logger) {
		gameLoggerDAO.addGameLogger(logger);
	}

}
