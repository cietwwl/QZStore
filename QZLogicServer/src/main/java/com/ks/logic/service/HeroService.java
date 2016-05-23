package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.CallHero;
import com.ks.db.cfg.CallHeroRule;
import com.ks.db.cfg.ExploreAward;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroEvo;
import com.ks.db.cfg.HeroEvoMaterial;
import com.ks.db.cfg.HeroRelation;
import com.ks.db.cfg.HeroRule;

public interface HeroService {
	/**
	 * 查询所有英雄
	 * @return 所有英雄
	 */
	List<Hero> queryHeros();
	
	/**
	 * 查询所有英雄规则
	 * @return 英雄规则
	 */
	List<HeroRule> queryHeroRule();
	/**
	 * 查询英雄进化
	 * @return 英雄进化
	 */
	List<HeroEvo> queryHeroEvo();
	
	/**
	 * 查询英雄进化材料
	 * @return 英雄进化材料
	 */
	List<HeroEvoMaterial> queryHeroEvoMaterial();
	/**
	 * 查询英雄召唤规则
	 * @return 英雄召唤规则
	 */
	List<CallHeroRule> queryCallHeroRule();
	/**
	 * 查询英雄召唤
	 * @return 英雄召唤
	 */
	List<CallHero> queryCallHero();
	/**
	 * 获得探索奖励
	 * @return 探索奖励
	 */
	List<ExploreAward> queryExploreAwards();
	/**
	 * 获得英雄关联
	 * @return 英雄关联
	 */
	List<HeroRelation> queryHeroRelation();
}