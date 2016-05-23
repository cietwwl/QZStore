package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.HeroBreakAttrSetting;
import com.ks.db.cfg.HeroBreakSetting;
import com.ks.db.model.UserHero;
import com.ks.model.fight.FightAttr;
import com.ks.protocol.vo.hero.UserHeroVO;

/**
 * 英雄突破服务
 * @author hanjie.l
 *
 */
public interface HeroBreakService {
	
	
	/**
	 * 激活灵元突破点
	 * @param userId
	 * @param userheroId
	 * @param slot
	 */
	@Transaction
	public UserHeroVO activeBreakSlot(int userId, int userheroId, int slot);
	
	/**
	 * 英雄突破
	 * @param userId
	 * @param userheroId
	 * @param slot
	 */
	@Transaction
	public UserHeroVO breakHero(int userId, int userheroId);
	
	/**
	 * 获取突破属性加成
	 * @param userHero
	 */
	public FightAttr getBreakFightAttr(UserHero userHero);
	
	
	//================================华丽分割线=====================================================
	
	/**
	 * 查询所有突破消耗数据
	 * @return
	 */

	public List<HeroBreakSetting> queryHeroBreakSettings();
	
	/**
	 * 查询所有突破属性增加数据
	 * @return
	 */
	public List<HeroBreakAttrSetting> queryHeroBreakAttrSettings();

}
