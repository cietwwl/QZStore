package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.UserTeam;
import com.ks.model.fight.Battle;
import com.ks.protocol.Message;
import com.ks.protocol.vo.fight.AttackRoundVO;
import com.ks.protocol.vo.fight.FightResultVO;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.fight.MoveVO;
import com.ks.protocol.vo.fight.SweepAwardVO;

public interface FightService {
	/**
	 * 计算战斗力事件
	 * @param userId
	 */
	void computeFightingEvent(int userId);
	
	/**
	 * 计算战斗力
	 * @param userId
	 */
	@Transaction
	void computeFighting(int userId);
	/**
	 * 释放技能
	 * @param userId 用户编号
	 * @param fightId 战斗编号
	 */
	@Transaction
	AttackRoundVO releaseSkill(int userId,int fightId);
	/**
	 * 移动
	 * @param userId 用户编号
	 * @param battleId 战场编号
	 * @param moveVO 移动VO
	 * @return 战斗结果
	 */
	@Transaction
	List<AttackRoundVO> move(int userId,MoveVO moveVO);
	/**
	 * 副本打怪
	 * @param userId 用户编号
	 * @param battleId 战场编号
	 * @return 战场
	 */
	Battle startZoneFight(int userId,int battleId);
	
	/**
	 * 竞技场PK
	 * @param attTeam 攻击方队伍
	 * @param defTeam 防守方队伍
	 * @return 战场
	 */
	Battle startArenaFight(UserTeam attTeam,UserTeam defTeam);
	
	/**
	 * 获得战斗奖励
	 * @param userId 用户编号
	 * @param 战斗结果
	 */
	@Transaction
	FightResultVO gainFightAward(int userId);
	/**
	 * 放弃战斗
	 * @param userId
	 */
	@Transaction
	int giveUpFight(int userId);
	
	/**
	 * 获得战斗
	 * @param userId 用户编号
	 * @return 战斗vo
	 */
	FightVO gainFight(int userId);
	/**
	 * 执行战斗AI
	 * @param battle 战场
	 * @return 战斗AI
	 */
	@Transaction
	List<AttackRoundVO> execFightAI(Battle battle);
	
	/**
	 * 执行战斗AI
	 * @param userId 战场
	 * @param flag 
	 * @return 战斗AI
	 */
	@Transaction
	List<AttackRoundVO> execFightAI(int userId, boolean flag);
	
	/**
	 * 托管
	 * @param userId 用户编号
	 * @return 托管回合
	 */
	@Transaction
	List<AttackRoundVO> hosting(int userId);
	/**
	 * 开始在线战斗
	 * @param attUserId 攻击方用户编号
	 * @param defUserId 防守方用户编号
	 */
	@Transaction
	Battle startOnlinePVPFight(int attUserId,int defUserId,int battleType,int maxRound);
	/**
	 * 检查战斗
	 * @param userId
	 */
	@Transaction
	void checkFight(int userId);
	/**
	 * 请求对战
	 * @param userId 用户编号
	 * @param againstUserId 请求用户编号
	 */
	@Transaction
	void againstFight(int userId,int againstUserId);
	/**
	 * 取消战斗
	 * @param userId
	 */
	@Transaction
	void cancelFight(int userId);
	/**
	 * 战场复活
	 * @param userId 用户编号
	 * @return 复活后的战斗模型
	 */
	FightVO fightRevive(int userId);
	
	/**
	 * 竞技场PK
	 * @param attTeam 攻击方队伍
	 * @param defTeam 防守方队伍 npc
	 * @return 战场
	 */
	Battle startArneaPK(UserTeam attTeam,UserTeam defTeam);
	
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
	@Transaction
	SweepAwardVO sweep(int userId,int battleId,int count);
	
	/**
	 * 观战
	 * @param userId
	 * @param fightId
	 * @return
	 */
	FightVO watch(int userId, String fightId);
	
	/**
	 * 获取当前的战场对象
	 * @param userId
	 * @return
	 */
	Battle getBattle(int userId);
	
	/**
	 * 获得战斗加成
	 * @param battle
	 * @param seId
	 * @param peId
	 * @return
	 */
	public int getBattleAddition(Battle battle, int seId, int peId);
	
}
