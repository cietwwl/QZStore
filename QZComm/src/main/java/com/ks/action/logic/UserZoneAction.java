package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.fight.FightVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.zone.ActivityZoneVO;
import com.ks.protocol.vo.zone.TrialsZoneVO;
import com.ks.protocol.vo.zone.UserZoneBattleVO;
import com.ks.protocol.vo.zone.UserZoneVO;

public interface UserZoneAction {
	
	/**
	 * 查询当前副本
	 * @param userId 用户编号
	 * @return 副本编号
	 */
	List<UserZoneVO> queryCurrZone(int userId);
	/**
	 * 进入副本
	 * @param userId 用户编号
	 * @param battleId 战场编号
	 * @param friendId 好友编号
	 * @return 战斗
	 */
	FightVO intoZone(int userId,int battleId);
	
	/**
	 * 查询当前精英副本
	 * @param userId 用户编号
	 * @param zoneId 副本编号
	 * @return 副本编号
	 */
	UserZoneVO queryCurrEliteZone(int userId,int zoneId);
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
	List<UserZoneBattleVO> queryUserZoneBattle(int userId,int zoneId);
	
	/**
	 * 获得副本奖励
	 * @param userId
	 * @param zoneId
	 * @param star
	 * @return
	 */
	GainGameAwardVO gainZoneAward(int userId,int zoneId,int star);
	
	/**
	 * 获取试练副本
	 * @param userId
	 * @param zoneId
	 * @return
	 */
	TrialsZoneVO gainTrialZones(int userId, int zoneId);
	
	/**
	 * 包子铺刷新
	 * @param userId
	 * @return
	 */
	TrialsZoneVO refreshBreadStore(int userId);
}
