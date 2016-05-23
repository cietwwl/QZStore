package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.ArenaAward;
import com.ks.db.cfg.ArenaBuy;
import com.ks.db.cfg.MartialWayAwardExp;
import com.ks.db.model.ArenaLogger;
import com.ks.protocol.vo.arena.ArenaInfoVO;
import com.ks.protocol.vo.arena.ArenaLoggerVO;
import com.ks.protocol.vo.arena.ArenaShoppingVO;
import com.ks.protocol.vo.arena.ArenaVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public interface ArenaService {
	/**
	 * 添加竞技场记录
	 * @param al
	 */
	@Transaction
	void addArenaLogger(ArenaLogger al);
	/**
	 * 查询竞技场
	 * @param userId 用户编号
	 * @return 用户竞技场信息
	 */
	@Transaction
	ArenaInfoVO queryArena(int userId);
	/**
	 * 竞技场战斗
	 * @param userId 用户编号
	 * @param rivalUserId 对手用户编号
	 * @return 战斗结果
	 */
	@Transaction
	FightVO playArena(int userId,int rivalUserId);
	/**
	 * 清除cd时间
	 * @param userId 用户编号
	 */
	@Transaction
	void clearCdTime(int userId);
	
	/**
	 * 购买竞技场次数
	 * @param userId 用户编号
	 */
	@Transaction
	void buyArenaCount(int userId);
	
	/**
	 * 刷新商店
	 * @param userId 用户编号
	 */
	@Transaction
	List<ArenaShoppingVO> RefreshShopping(int userId);
	/**
	 * 兑换物品
	 * 
	 * @param userId 
	 */
	@Transaction
	GainAwardVO ExchangeAward(int userId,int shoppingId);
	/**
	 * 获得竞技场排名
	 * @return 竞技场排名
	 */
	List<ArenaVO> queryArenaRank();
	/**
	 * 刷新对手
	 * @param userId 用户编号
	 * @return 刷新的对手
	 */
	@Transaction
	List<UserBaseinfoVO> refRival(int userId, boolean flush);
	/**
	 * 获得前1000名
	 * @return 前1000名
	 */
	List<UserBaseinfoVO> queryArenaRankTop50(int type, int userId);
	/**
	 * 商场奖励池
	 * @return
	 */
	
	List<ArenaAward> queryArenaAward();
	/**
	 * 经验奖励
	 * @return
	 */
	public List<MartialWayAwardExp> queryArenaAwardExp();

	/**
	 * 查询战斗日志
	 * @param userId
	 * @return
	 */
	@Transaction
	List<ArenaLoggerVO> queryArenaLogger(int userId,int type);
	/**
	 * 重置挑战次数
	 */
	@Transaction
	public void clearArena();
	/**
	 * 每天定时刷新商城
	 * @param list
	 */
	@Transaction
	public void refArenaShopping();
	/**
	 * 定时清理排行榜
	 */
	@Transaction
	public void delArenaRank();
	
	/**
	 * 查询竞技场购买次数配置
	 */
	List<ArenaBuy> queryArenaBuys();
	
}
