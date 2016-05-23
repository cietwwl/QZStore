package com.ks.logic.action;

import com.ks.action.logic.HeroBreakAction;
import com.ks.logic.service.HeroBreakService;
import com.ks.logic.service.ServiceFactory;
import com.ks.protocol.vo.hero.UserHeroVO;
/**
 * 英雄突破
 * @author hanjie.l
 *
 */
public class HeroBreakActionImpl implements HeroBreakAction {
	
	private static final HeroBreakService heroBreakService = ServiceFactory.getService(HeroBreakService.class);

	@Override
	public UserHeroVO activeBreakSlot(int userId, int userheroId, int slot) {
		return heroBreakService.activeBreakSlot(userId, userheroId, slot);
	}

	@Override
	public UserHeroVO breakHero(int userId, int userheroId) {
		return heroBreakService.breakHero(userId, userheroId);
	}

}
