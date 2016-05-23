package com.ks.logic.service;

import java.util.Collection;
import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.model.User;
import com.ks.db.model.UserExplore;
import com.ks.db.model.UserHero;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.hero.EvolutionHeroResultVO;
import com.ks.protocol.vo.hero.HeroOptResultVO;
import com.ks.protocol.vo.hero.UserHeroVO;

public interface UserHeroService {
	/**
	 * 添加英雄
	 * @param hero
	 */
	@Transaction
	public void addHero(User user, UserHero hero);
	
	/**
	 * 删除伙伴
	 * @param user
	 * @param userHeroId
	 */
	@Transaction
	void deleteHero(User user, int userHeroId);
	/**
	 * 更新英雄
	 * @param hero
	 */
	@Transaction
	public void updateHero(UserHero hero);
	/**
	 * 初始化用户英雄
	 * @param userId 用户编号 
	 * @return 所有用户英雄
	 */
	@Transaction
	Collection<UserHero> initUserHeros(int userId);

	/**
	 * 获得所有英雄
	 * @param userId 用户编号
	 * @return 所有英雄
	 */
	List<UserHero> getUserHeros(User user);
	/**
	 * 查询用户英雄
	 * @param userId 用户编号
	 * @param userHeroId 用户英雄编号
	 * @return 用户英雄
	 */
	UserHero getUserHero(User user,int userHeroId);
	
	/**
	 * 增加影响容量
	 * @param userId 用户编号
	 * @param type 要增加的背包
	 */
	@Transaction
	void addBackageCapacity(int userId,int type);
	/**
	 * 锁定英雄
	 * @param userId 用户编号
	 * @param userHeroId 用户英雄编号
	 */
	@Transaction
	void lockedHero(int userId,int userHeroId);
	
	/**
	 * 解锁英雄
	 * @param userId 用户编号
	 * @param userHeroId 用户英雄编号
	 */
	@Transaction
	void unLockedHero(int userId,int userHeroId);
	/**
	 * 升级英雄
	 * @param userId 用户编号
	 * @param userHeroId 要升级的英雄编号
	 * @param num 升级材料
	 */
	@Transaction
	HeroOptResultVO levelUpHero(int userId,int userHeroId, int type);
	/**
	 * 英雄进化
	 * @param userId 用户编号
	 * @param evoId 进化编号
	 * @param userHeroId 要进化的战魂编号
	 * @return 操作结果
	 */
	@Transaction
	EvolutionHeroResultVO evolutionHero(int userId,int evoId,int userHeroId);
	/***
	 * 召唤英雄
	 * @param userId 用户编号
	 * @param type 类型
	 * @param num 数量
	 * @return 召唤到的英雄
	 */
	@Transaction
	List<UserHeroVO> callHero(int userId,int type,int num);
	/**
	 * 出售英雄
	 * @param userId 用户编号
	 * @param sellHeros 出售英雄编号
	 */
	@Transaction
	void sellHero(int userId,List<Integer> sellHeros);
//	/**
//	 * 获得用户英雄图鉴
//	 * @param userId 用户编号
//	 * @return 图鉴
//	 */
//	List<Integer> gainUserHeroMap(int userId);
//	/**
//	 * 增加用户英雄图鉴
//	 * @param userId 用户编号
//	 * @param heroId 英雄编号
//	 */
//	@Transaction
//	void addUserHeroMap(int userId,int heroId);
	/**
	 * 获得探索
	 * @param userId 用户编号
	 * @return 探索
	 */
	@Transaction
	List<UserExplore> gainUserExplore(int userId);
	/**
	 * 开始探索
	 * @param userId 用户编号
	 * @param exploreId 探索编号
	 * @param exploreType 探索类型
	 * @param userHeroId 用户英雄编号
	 */
	@Transaction
	void startExplore(int userId,int exploreId,int exploreType,int userHeroId);
	/**
	 * 获得探索奖励
	 * @param userId 用户编号
	 * @param exploreId 探索编号
	 * @return 探索奖励
	 */
	@Transaction
	GainGameAwardVO gainExploreAward(int userId,int exploreId);
	/**
	 * 英雄分解
	 * @param userId 用户编号
	 * @param heros 要分解的英雄
	 */
	@Transaction
	HeroOptResultVO resolveHero(int userId,List<Integer> heros);
}
