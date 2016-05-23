package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.CallHero;
import com.ks.db.cfg.CallHeroRule;
import com.ks.db.cfg.ExploreAward;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroEvo;
import com.ks.db.cfg.HeroEvoMaterial;
import com.ks.db.cfg.HeroRelation;
import com.ks.db.cfg.HeroRule;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.HeroService;

public class HeroServiceImpl extends BaseService implements HeroService {

	@Override
	public List<Hero> queryHeros() {
		return heroDAO.queryHeros();
	}

	@Override
	public List<HeroRule> queryHeroRule() {
		return heroDAO.queryHeroRule();
	}

	@Override
	public List<HeroEvo> queryHeroEvo() {
		return heroDAO.queryHeroEvo();
	}

	@Override
	public List<HeroEvoMaterial> queryHeroEvoMaterial() {
		return heroDAO.queryHeroEvoMaterial();
	}

	@Override
	public List<CallHeroRule> queryCallHeroRule() {
		return heroDAO.queryCallHeroRule();
	}

	@Override
	public List<CallHero> queryCallHero() {
		return heroDAO.queryCallHero();
	}

	@Override
	public List<ExploreAward> queryExploreAwards() {
		return exploreSettingDao.queryExploreAwards();
	}

	@Override
	public List<HeroRelation> queryHeroRelation() {
		return heroDAO.queryHeroRelation();
	}

}