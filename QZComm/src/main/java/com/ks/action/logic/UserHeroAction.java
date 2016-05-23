package com.ks.action.logic;

import java.util.List;

import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.hero.EvolutionHeroResultVO;
import com.ks.protocol.vo.hero.HeroOptResultVO;
import com.ks.protocol.vo.hero.UserExploreVO;
import com.ks.protocol.vo.hero.UserHeroVO;

public interface UserHeroAction {
	
	/**
	 * 增加影响容量
	 * @param userId 用户编号
	 * @param type 要增加的背包
	 */
	void addBackageCapacity(int userId,int type);
	/**
	 * 锁定英雄
	 * @param userId 用户编号
	 * @param userHeroId 用户英雄编号
	 */
	void lockedHero(int userId,int userHeroId);
	
	/**
	 * 解锁英雄
	 * @param userId 用户编号
	 * @param userHeroId 用户英雄编号
	 */
	void unLockedHero(int userId,int userHeroId);
	
	/**
	 * 升级英雄
	 * @param userId 用户编号
	 * @param userHeroId 要升级的英雄编号
	 * @param num 升级材料
	 */
	HeroOptResultVO levelUpHero(int userId,int userHeroId,int num);
	/**
	 * 英雄进化
	 * @param userId 用户编号
	 * @param evoId 进化编号
	 * @param userHeroId 要进化的战魂编号
	 * @return 操作结果
	 */
	EvolutionHeroResultVO evolutionHero(int userId,int evoId,int userHeroId);
	/***
	 * 召唤英雄
	 * @param userId 用户编号
	 * @param type 类型
	 * @param num 数量
	 * @return 召唤到的英雄
	 */
	List<UserHeroVO> callHero(int userId,int type,int num);
	/**
	 * 出售英雄
	 * @param userId 用户编号
	 * @param sellHeros 出售英雄编号
	 */
	void sellHero(int userId,List<Integer> sellHeros);
	
//	/**
//	 * 获得用户英雄图鉴
//	 * @param userId 用户编号
//	 * @return 图鉴
//	 */
//	List<Integer> gainUserHeroMap(int userId);
	
	/**
	 * 获得探索
	 * @param userId 用户编号
	 * @return 探索
	 */
	List<UserExploreVO> gainUserExplore(int userId);
	/**
	 * 开始探索
	 * @param userId 用户编号
	 * @param exploreId 探索编号
	 * @param exploreType 探索类型
	 * @param userHeroId 用户英雄编号
	 */
	void startExplore(int userId,int exploreId,int exploreType,int userHeroId);
	/**
	 * 获得探索奖励
	 * @param userId 用户编号
	 * @param exploreId 探索编号
	 * @return 探索奖励
	 */
	GainGameAwardVO gainExploreAward(int userId,int exploreId);
	/**
	 * 分解英雄
	 * @param userId 用户编号
	 * @param heros 英雄
	 */
	HeroOptResultVO resolveHero(int userId,List<Integer> heros);
}
