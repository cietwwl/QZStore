package com.ks.action.logic;

import java.util.List;

import com.ks.model.fight.Battle;
import com.ks.protocol.Message;
import com.ks.protocol.vo.fight.AttackRoundVO;
import com.ks.protocol.vo.fight.FightResultVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.protocol.vo.fight.SweepAwardVO;

public interface FightAction {
	
	/**
	 * 移动
	 * @param userId 用户编号
	 * @param battleId 战场编号
	 * @param moveVO 移动VO
	 * @param 战斗结果
	 */
	List<AttackRoundVO> move(int userId,MoveVO moveVO);
	
	/**
	 * 获得战斗奖励
	 * @param userId 用户编号
	 * @param 战斗结果
	 */
	FightResultVO gainFightAward(int userId);
	
	/**
	 * 放弃战斗
	 * @param userId
	 */
	int giveUpFight(int userId);
	/**
	 * 释放技能
	 * @param userId 用户编号
	 * @param fightId 释放的模型
	 * @return 战斗回合
	 */
	AttackRoundVO releaseSkill(int userId, int fightId);
	
	/**
	 * 托管
	 * @param userId 用户编号
	 * @return 托管回合
	 */
	List<AttackRoundVO> hosting(int userId);
	/**
	 * 执行战斗AI
	 * @param userId
	 * @param flag 
	 * @return
	 */
	List<AttackRoundVO> execFightAI(int userId, boolean flag);
	/**
	 * 获得战斗
	 * @param userId 用户编号
	 * @return 战斗vo
	 */
	FightVO gainFight(int userId);
	/**
	 * 开始在线pvp
	 * @param attUserId 攻击方编号
	 * @param defUserId 防守方编号
	 */
	Battle startOnlinePVPFight(int attUserId, int defUserId,int battleType,int maxRound);
	/**
	 * 检查战斗
	 * @param userId 用户编号
	 */
	void checkFight(int userId);
	
	/**
	 * 请求对战
	 * @param userId 用户编号
	 * @param againstUserId 请求用户编号
	 */
	void againstFight(int userId,int againstUserId);
	/**
	 * 取消战斗
	 * @param userId
	 */
	void cancelFight(int userId);
	
	/**
	 * 战场复活
	 * @param userId 用户编号
	 * @return 复活后的战斗模型
	 */
	FightVO fightRevive(int userId);
	
	/**
	 * 获得战斗结果
	 * @param userId
	 * @return
	 */
	Message getFightRes(int userId);
	/**
	 * 扫荡
	 * @param userId
	 * @param battleId
	 * @param count
	 * @return
	 */
	SweepAwardVO sweep(int userId, int battleId, int count);
	
	/**
	 * 获取当前的战场对象
	 * @param userId
	 * @return
	 */
	Battle getBattle(int userId);
	
	/**
	 * 观战
	 * @param userId
	 * @param fightId
	 * @return
	 */
	FightVO watch(int userId, String fightId);
	
}
