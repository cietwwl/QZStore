package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.arena.ArenaInfoVO;
import com.ks.protocol.vo.arena.ArenaLoggerVO;
import com.ks.protocol.vo.arena.ArenaShoppingVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public interface ArenaAction {
	/**
	 * 查询竞技场
	 * @param userId 用户编号
	 * @return 用户竞技场信息
	 */
	ArenaInfoVO queryArena(int userId);
	/**
	 * 竞技场战斗
	 * @param userId 用户编号
	 * @param rivalUserId 对手用户编号
	 * @return 战斗结果
	 */
	FightVO playArena(int userId,int rivalUserId);
	/**
	 * 清除cd时间
	 * @param userId 用户编号
	 */
	void clearCdTime(int userId);
	/**
	 * 增加竞技场次数
	 * @param userId 用户编号
	 */
	void buyArenaCount(int userId);
	/**
	 * 获得竞技场排名
	 * @return 竞技场排名
	 */
	List<UserBaseinfoVO> queryArenaRank(int type,int userId);
	
	/**
	 * 刷新对手
	 * @param userId 用户编号
	 * @return 刷新的对手
	 */
	List<UserBaseinfoVO> refRival(int userId);

	/**
	 * 商场奖励兑换
	 * @param userId
	 * @param shoppingId
	 */
	GainAwardVO ExchangeAward(int userId,int shoppingId);
	/**
	 * 刷新商城
	 * @param userId
	 */
	List<ArenaShoppingVO> RefreshShopping(int userId);
	/**
	 * 竞技场日志
	 * @param userId
	 * @return
	 */
	public List<ArenaLoggerVO> queryArenaLogger(int userId,int type);
	
	/**
	 * 重置挑战次数
	 */
	public void clearArena();
	/**
	 * 每天定时刷新商城
	 * @param list
	 */
	public void refArenaShopping();
	/**
	 * 定时清理排行榜
	 */
	public void delArenaRank();
}
