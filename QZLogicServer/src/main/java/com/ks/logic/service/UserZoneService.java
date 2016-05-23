package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.UserZone;
import com.ks.db.model.UserZoneBattle;
import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.zone.ActivityZoneVO;
import com.ks.protocol.vo.zone.TrialsZoneVO;
import com.ks.protocol.vo.zone.UserZoneBattleVO;
import com.ks.protocol.vo.zone.UserZoneVO;

/**
 * 用户副本
 * @author ks
 */
public interface UserZoneService {
	/**
	 * 返回副本
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	UserZone getUserZone(int userId, int zoneId);
	/**
	 * 添加玩家副本
	 * @param zone
	 */
	@Transaction
	void addUserZone(UserZone zone);
	/**
	 * 更新副本
	 * @param zone
	 */
	@Transaction
	void updateUserZone(UserZone zone);
	
	/**
	 * 更新副本
	 * @param battle
	 */
	@Transaction
	void addUserZoneBattle(UserZoneBattle battle);
	
	/**
	 * 更新副本
	 * @param battle
	 */
	@Transaction
	void updateUserZoneBattle(UserZoneBattle battle);
	
	/**
	 * 加载副本战斗
	 * @param userId
	 * @param zoneId
	 * @param battleId
	 */
	UserZoneBattle getUserZoneBattle(int userId, int zoneId, int battleId);
	/**
	 * 加载副本战斗
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	List<UserZoneBattle> getUserZoneBattle(int userId, int zoneId);
	/**
	 * 查询当前副本
	 * @param userId 用户编号
	 * @return 副本编号
	 */
	@Transaction
	List<UserZoneVO> queryCurrZone(int userId);
	
	/**
	 * 查询当前精英副本
	 * @param userId 用户编号
	 * @param zoneId 副本编号
	 * @return 副本编号
	 */
	UserZoneVO queryCurrEliteZone(int userId,int zoneId);
	/**
	 * 进入副本
	 * @param userId 用户编号
	 * @param battleId 战场编号
	 * @param friendId 好友编号
	 * @return 战斗
	 */
	@Transaction
	FightVO intoZone(int userId,int battleId);
	/**
	 * 查询所有活动副本
	 * @param userId 用户编号
	 * @return 所有可用的活动副本
	 */
	List<ActivityZoneVO> queryActivityZones(int userId);
	
	/**
	 * 查询用户副本战场
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	@Transaction
	List<UserZoneBattleVO> queryUserZoneBattle(int userId,int zoneId);
	
	/**
	 * 获得副本奖励
	 * @param userId
	 * @param zoneId
	 * @param star
	 * @return
	 */
	@Transaction
	GainGameAwardVO gainZoneAward(int userId,int zoneId,int star);
	
	/**
	 * 获取试炼副本
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	@Transaction
	TrialsZoneVO gainTrialZones(int userId, int zoneId);
	
	/**
	 * 刷新包子铺
	 * @param userId
	 * @return
	 */
	@Transaction
	TrialsZoneVO refreshBreadStore(int userId);
	
}
