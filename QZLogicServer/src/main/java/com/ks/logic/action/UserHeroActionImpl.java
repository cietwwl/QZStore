package com.ks.logic.action;

import java.util.ArrayList;
import java.util.List;

import com.ks.action.logic.UserHeroAction;
import com.ks.db.model.UserExplore;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserHeroService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.hero.EvolutionHeroResultVO;
import com.ks.protocol.vo.hero.HeroOptResultVO;
import com.ks.protocol.vo.hero.UserExploreVO;
import com.ks.protocol.vo.hero.UserHeroVO;

public class UserHeroActionImpl implements UserHeroAction {
	
	private static final UserHeroService userHeroService = ServiceFactory.getService(UserHeroService.class);
	
	@Override
	public void addBackageCapacity(int userId,int type) {
		userHeroService.addBackageCapacity(userId,type);
	}

	@Override
	public void lockedHero(int userId, int userHeroId) {
		userHeroService.lockedHero(userId, userHeroId);
	}

	@Override
	public void unLockedHero(int userId, int userHeroId) {
		userHeroService.unLockedHero(userId, userHeroId);
	}

	@Override
	public HeroOptResultVO levelUpHero(int userId, int userHeroId,
			int num) {
		return userHeroService.levelUpHero(userId, userHeroId, num);
	}

	@Override
	public EvolutionHeroResultVO evolutionHero(int userId, int evoId,
			int userHeroId) {
		return userHeroService.evolutionHero(userId, evoId, userHeroId);
	}

	@Override
	public List<UserHeroVO> callHero(int userId, int type, int num) {
		return userHeroService.callHero(userId, type, num);
	}

	@Override
	public void sellHero(int userId, List<Integer> sellHeros) {
		userHeroService.sellHero(userId, sellHeros);
	}

//	@Override
//	public List<Integer> gainUserHeroMap(int userId) {
//		return userHeroService.gainUserHeroMap(userId);
//	}

	@Override
	public List<UserExploreVO> gainUserExplore(int userId) {
		List<UserExplore> ues = userHeroService.gainUserExplore(userId);;
		List<UserExploreVO> vos = new ArrayList<UserExploreVO>();
		for(UserExplore ue : ues){
			UserExploreVO vo = MessageFactory.getMessage(UserExploreVO.class);
			vo.init(ue);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public void startExplore(int userId, int exploreId, int exploreType,
			int userHeroId) {
		userHeroService.startExplore(userId, exploreId, exploreType, userHeroId);
	}

	@Override
	public GainGameAwardVO gainExploreAward(int userId, int exploreId) {
		return userHeroService.gainExploreAward(userId, exploreId);
	}

	@Override
	public HeroOptResultVO resolveHero(int userId, List<Integer> heros) {
		return userHeroService.resolveHero(userId, heros);
	}

}
