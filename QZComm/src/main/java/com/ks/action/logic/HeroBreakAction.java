package com.ks.action.logic;

import com.ks.protocol.vo.hero.UserHeroVO;

/**
 * 英雄突破
 * @author hanjie.l
 *
 */
public interface HeroBreakAction {
	
	/**
	 * 激活灵元突破点
	 * @param userId
	 * @param userheroId
	 * @param slot
	 */
	public UserHeroVO activeBreakSlot(int userId, int userheroId, int slot);
	
	/**
	 * 英雄突破
	 * @param userId
	 * @param userheroId
	 * @param slot
	 */
	public UserHeroVO breakHero(int userId, int userheroId);

}
