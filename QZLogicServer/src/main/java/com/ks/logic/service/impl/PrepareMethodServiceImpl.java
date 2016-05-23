package com.ks.logic.service.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.ZoneBattle;
import com.ks.db.model.User;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserZone;
import com.ks.db.model.UserZoneBattle;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.PrepareMethodService;
import com.ks.model.task.constant.EventPrepareMethod;
/**
 * 任务准备需要的方法
 * @author hanjie.l
 *
 */
public class PrepareMethodServiceImpl extends BaseService implements PrepareMethodService {
	
	/**
	 * 准备方法集合
	 */
	public static ConcurrentHashMap<String, PrepareMethodInvoker> prepareMethodMap = new ConcurrentHashMap<String, PrepareMethodInvoker>();

	
	/**
	 * 注册执行器
	 * @param method
	 * @param invoker
	 */
	public static void registerInvoker(String method, PrepareMethodInvoker invoker){
		if(method != null && invoker != null){
			prepareMethodMap.putIfAbsent(method, invoker);
		}
	}
	
	/**
	 * 获取方法执行器
	 * @param method
	 * @return
	 */
	public PrepareMethodInvoker getPrepareInvoker(String method){
		return prepareMethodMap.get(method);
	}
	
	static{
		
		// 获取玩家等级
		registerInvoker(EventPrepareMethod.GET_PLAYERLEVEL, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				return user.getLevel();
			}
		});
		
		//是否通关指定关卡
		registerInvoker(EventPrepareMethod.ISPASS_BATTLE, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				if(methodParams.size() >= 2){
					int zoneId = Integer.parseInt(methodParams.get(0));
					int battleId = Integer.parseInt(methodParams.get(1));
					UserZoneBattle battle = userZoneService.getUserZoneBattle(user.getUserId(), zoneId, battleId);
					if(battle != null && battle.getPassCount() > 0){
						return 1;
					}
				}
				return 0;
			}
		});
		
		//是否通关章节
		registerInvoker(EventPrepareMethod.ISPASS_ZONE, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				if(methodParams.size() >= 1){
					int zoneId = Integer.parseInt(methodParams.get(0));
					UserZone queryUserZone = userZoneService.getUserZone(user.getUserId(), zoneId);
					if(queryUserZone.getCurrBattle() >= GameCache.getZoneMaxBattleId(zoneId)){
						return 1;
					}
				}
				return 0;
			}
		});
		
		//获取指定章节的星星数
		registerInvoker(EventPrepareMethod.GET_ZONE_STAR, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				if(methodParams.size() >= 1){
					int zoneId = Integer.parseInt(methodParams.get(0));
					List<UserZoneBattle> zoneBattles = userZoneService.getUserZoneBattle(user.getUserId(), zoneId);
					int s = 0;
					for(UserZoneBattle uz : zoneBattles){
						ZoneBattle b = GameCache.getZoneBattle(uz.getZoneBattleId());
						if(b.getBattleType() == SystemConstant.ZONE_TOLLGATE_TYPE_BOSS){
							s+=uz.getStar();
						}
					}
					return s;
				}
				return 0;
			}
		});
		
		//获取拥有X品质(星)以上的伙伴数量
		registerInvoker(EventPrepareMethod.GET_HERO_BYQUALITY, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				if(methodParams.size() >= 1){
					int quality = Integer.parseInt(methodParams.get(0));
					List<UserHero> heros = userHeroDAO.queryUserHeros(user.getUserId());
					if(heros == null || heros.isEmpty()){
						return 0;
					}
					int num = 0;
					for(UserHero userHero : heros){
						Hero hero = GameCache.getHero(userHero.getHeroId());
						if(hero.getQuality() >= quality){
							num++;
						}
					}
					return num;
				}
				return 0;
			}
		});
		
		//获取今日装备提升等级之和
		registerInvoker(EventPrepareMethod.TODAY_EQUIP_LEVELUP_TIMES, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getTodayEquipCountLevel();
			}
		});
		
		//获取今日英雄提升等级之和
		registerInvoker(EventPrepareMethod.TODAY_HERO_LEVELUP_TIMES, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getTodayHeroCountLevel();
			}
		});
		
		//获取累计装备提升等级之和
		registerInvoker(EventPrepareMethod.EQUIP_LEVELUP_TIMES, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getEquipCountLevel();
			}
		});
		
		//获取累计英雄提升等级之和
		registerInvoker(EventPrepareMethod.HERO_LEVELUP_TIMES, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getHeroCountLevel();
			}
		});
		
		//获取累计竞技场挑战次数
		registerInvoker(EventPrepareMethod.ARENAFIGHT_COUNT, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getArenaFightCount();
			}
		});
		
		//累计武道大会挑战次数
		registerInvoker(EventPrepareMethod.MARTIALWAY_FIGHTCOUNT, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getMartialwayFightCount();
			}
		});
		
		// 累计获得道具数量
		registerInvoker(EventPrepareMethod.ADDITEM_COUNT, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat == null){
					return 0;
				}
				return userStat.getAddItemCount();
			}
		});
		
		// 是否为月卡用户
		registerInvoker(EventPrepareMethod.IS_CYCLECARDUSER, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				/**
				 * cardType {@link 指向PayGoods#id, 并且PayGoods#type一定为2周期卡类型}
				 */
				int cardType = Integer.parseInt(methodParams.get(0));
				UserStat userStat = userService.getUserStat(user.getUserId());
				if(userStat.hasCycleCard(cardType)){
					return 1;
				}
				return 0;
			}
		});
		
		// 是否vip大于XX级的用户
		registerInvoker(EventPrepareMethod.IS_VIPUSER, new PrepareMethodInvoker() {
			
			@Override
			public int invoke(User user, List<String> methodParams) {
				int vipLevel = Integer.parseInt(methodParams.get(0));
				if(user.getVip() >= vipLevel){
					return 1;
				}
				return 0;
			}
		});
	}
	
	/**
	 * 准备方法执行器
	 * @author hanjie.l
	 *
	 */
	public interface PrepareMethodInvoker{
		public int invoke(User user, List<String> methodParams);
	}
}
