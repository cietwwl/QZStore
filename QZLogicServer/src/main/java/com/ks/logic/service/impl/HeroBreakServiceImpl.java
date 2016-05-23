package com.ks.logic.service.impl;

import java.util.List;
import java.util.Map;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.HeroBreakAttrSetting;
import com.ks.db.cfg.HeroBreakSetting;
import com.ks.db.model.User;
import com.ks.db.model.UserHero;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.HeroBreakService;
import com.ks.model.fight.FightAttr;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.hero.UserHeroVO;
/**
 * 英雄突破
 * @author hanjie.l
 *
 */
public class HeroBreakServiceImpl extends BaseService implements HeroBreakService {
	
	public List<HeroBreakSetting> queryHeroBreakSettings(){
		return heroBreakDao.queryHeroBreakSettings();
	}
	
	public List<HeroBreakAttrSetting> queryHeroBreakAttrSettings(){
		return heroBreakDao.queryHeroBreakAttrSettings();
	}

	@Override
	public UserHeroVO activeBreakSlot(int userId, int userheroId, int slot) {
		
		if(slot <= 0 || slot >= 7){
			throw new GameException(GameException.CODE_参数错误, "");
		}

		User user = userService.getOnlineUser(userId);
		
		UserHero userHero = userHeroService.getUserHero(user, userheroId);
		
		//已经激活该灵元点
		if(userHero.getBreakedSlotList().contains(slot)){
			throw new GameException(GameException.CODE_灵元点已激活, "");
		}
		
		Hero hero = GameCache.getHero(userHero.getHeroId());
		if(hero == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		
		Map<Integer, HeroBreakSetting> heroBreakMap = GameCache.getHeroBreakMap(hero.getBreakGroup(), userHero.getBreakLevel()+1);
		if(heroBreakMap == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		
		HeroBreakSetting heroBreakSetting = heroBreakMap.get(slot);
		if(heroBreakSetting == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		
		if(userHero.getLevel() < heroBreakSetting.getNeedLevel()){
			throw new GameException(GameException.CODE_伙伴等级不足, "");
		}
		effectService.delIncome(user, heroBreakSetting.getType(), heroBreakSetting.getGoods_id(), heroBreakSetting.getNum(), SystemConstant.LOGGER_APPROACH_突破激活灵元点);
		//激活灵元点
		userHero.getBreakedSlotList().add(slot);
//		userHeroDAO.updateUserHeroCache(userHero);
		userHeroService.updateHero(userHero);
		
		//刷新战斗力
		fightService.computeFightingEvent(user.getUserId());
		
		UserHeroVO message = MessageFactory.getMessage(UserHeroVO.class);
		message.init(userHero);
		
		return message;
	}

	@Override
	public UserHeroVO breakHero(int userId, int userheroId) {
		
		User user = userService.getOnlineUser(userId);
		
		UserHero userHero = userHeroService.getUserHero(user, userheroId);
		
		if(userHero.getBreakedSlotList().size() < 6){
			throw new GameException(GameException.CODE_请先激活所有灵元点, "");
		}
		
		Hero hero = GameCache.getHero(userHero.getHeroId());
		if(hero == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		
		Map<Integer, HeroBreakAttrSetting> heroBreakAttrMap = GameCache.getHeroBreakAttrMap(hero.getBreakGroup(), userHero.getBreakLevel()+1);
		if(heroBreakAttrMap == null){
			throw new GameException(GameException.CODE_突破已达到最高等级, "");
		}
		
		userHero.setBreakLevel(userHero.getBreakLevel() + 1);
		userHero.getBreakedSlotList().clear();
//		userHeroDAO.updateUserHeroCache(userHero);
		userHeroService.updateHero(userHero);
		
		//刷新战斗力
		fightService.computeFightingEvent(user.getUserId());
		
		UserHeroVO message = MessageFactory.getMessage(UserHeroVO.class);
		message.init(userHero);
		
		return message;
		
	}

	@Override
	public FightAttr getBreakFightAttr(UserHero userHero) {
		
		Hero hero = GameCache.getHero(userHero.getHeroId());
		if(hero == null){
			throw new GameException(GameException.CODE_配置表数据不存在, "");
		}
		
		FightAttr fightAttr = new FightAttr();
		
		for(int i=1; i<=(userHero.getBreakLevel()+1); i++){
			Map<Integer, HeroBreakAttrSetting> heroBreakAttrMap = GameCache.getHeroBreakAttrMap(hero.getBreakGroup(), i);
			if(heroBreakAttrMap != null){
				if(i != (userHero.getBreakLevel()+1)){
					for(HeroBreakAttrSetting attrSetting : heroBreakAttrMap.values()){
						fightAttr.addHp(attrSetting.getHp());
						fightAttr.addAtk(attrSetting.getAtk());
					}
				}else{
					//灵元点增加属性
					for(int slot : userHero.getBreakedSlotList()){
						HeroBreakAttrSetting attrSetting = heroBreakAttrMap.get(slot);
						if(attrSetting != null){
							fightAttr.addHp(attrSetting.getHp());
							fightAttr.addAtk(attrSetting.getAtk());
						}
					}
				}
			}
		}
		
		return fightAttr;
	}

}
