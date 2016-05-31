package com.ks.logic.service;

import com.ks.access.Transaction;
import com.ks.db.log.ActiveLogger;
import com.ks.db.log.GameLogger;
import com.ks.db.log.ZoneBattleLogger;

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
	
	/**
	 * 查询活跃日志
	 * @param userId
	 * @param partner
	 * @return
	 */
	ActiveLogger queryActiveLogger(int userId, int partner, int startTime, int endTime);
	
	/**
	 * 更新活跃日志
	 * @param logger
	 */
	@Transaction
	void updateActiveLogger(ActiveLogger logger);
	
	/**
	 * 添加副本日志
	 * @param logger
	 */
	@Transaction
	void addZoneBattleLogger(ZoneBattleLogger logger);
	
	/**
	 * 查询副本日志
	 * @param userId
	 * @param zoneBattleId
	 * @return
	 */
	ZoneBattleLogger queryZoneBattleLogger(int userId, int zoneBattleId);
	
	/**
	 * 更新副本日志
	 * @param logger
	 */
	@Transaction
	void updateZoneBattleLogger(ZoneBattleLogger logger);
}
