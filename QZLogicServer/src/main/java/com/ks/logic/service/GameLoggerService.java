package com.ks.logic.service;

import com.ks.access.Transaction;
import com.ks.db.log.GameLogger;

/**
 * 游戏日志
 * @author ks
 */
public interface GameLoggerService {
	/**
	 * 增加游戏日志
	 * @param logger
	 */
	@Transaction
	void addGameLogger(GameLogger logger);
}
