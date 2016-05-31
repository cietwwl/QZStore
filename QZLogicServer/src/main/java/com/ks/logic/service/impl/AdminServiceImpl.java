package com.ks.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.action.world.LoginAction;
import com.ks.action.world.WorldChatAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.Equipment;
import com.ks.db.cfg.Eternal;
import com.ks.db.cfg.Hero;
import com.ks.db.cfg.PayGoods;
import com.ks.db.model.SysMail;
import com.ks.db.model.User;
import com.ks.db.model.UserEquipment;
import com.ks.db.model.UserEternal;
import com.ks.db.model.UserHero;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;
import com.ks.db.model.UserTeam;
import com.ks.exceptions.GameException;
import com.ks.logic.cache.GameCache;
import com.ks.logic.event.ReloadFightingCacheEvent;
import com.ks.logic.event.ReloadLevelCacheEvent;
import com.ks.logic.event.task.BuyCycleCardEvent;
import com.ks.logic.service.AdminService;
import com.ks.logic.service.BaseService;
import com.ks.object.CycleCard;
import com.ks.object.ItemEffect;
import com.ks.object.ItemEffects;
import com.ks.rpc.RPCKernel;
import com.ks.table.UserRecordTable;
import com.ks.table.UserStatTable;
import com.ks.table.UserTable;
import com.ks.timer.TimerController;
import com.ks.util.XyStringUtil;
import com.ks.util.XyTimeUtil;

public class AdminServiceImpl extends BaseService implements AdminService{

	@Override
	public int rechargeDiamond(String username, int partner, int amount) {
		User user = getUser(partner, username);
		if(user == null){
			return GameException.CODE_用户不存在;
		}else{
			userService.recharge(user, amount, true, SystemConstant.LOGGER_APPROACH_后台操作);
		}
		return GameException.CODE_正常;
	}

	@Override
	public int sendSysMail(Map<String, String> paramMap){
		int partner = 0;
		int sendType = 0;
		int endId = 0;
		int startTime = 0;
		int endTime = 0;
		List<Integer> ids = null;
		try{
			partner = new Integer(paramMap.get("partner"));
			sendType = new Integer(paramMap.get("sendType"));
			if(sendType == SystemConstant.SYS_MAIL_TYPE_CUR_SERVER){
				endId = userDAO.queryUserByMaxId();
			}else if(sendType == SystemConstant.SYS_MAIL_TYPE_TIMES){
				List<Integer> list = XyStringUtil.parseList(paramMap.get("times"), XyStringUtil.SPLIT_UNDERLINE);
				if(list.size() >= 2){
					startTime = list.get(0);
					endTime = list.get(1);
				}
			}else if(sendType == SystemConstant.SYS_MAIL_TYPE_USER){
				ids = new ArrayList<Integer>();
				List<String> usernames = XyStringUtil.parseListByString(paramMap.get("openids"), XyStringUtil.SPLIT_SEMICOLON);
				for(String username : usernames){
					User user = userDAO.findUserByUsername(username, partner);
					if(user != null){
						ids.add(user.getUserId());
					}
				}
				if(ids.isEmpty()){
					return GameException.CODE_用户不存在;
				}
			}
		}catch(Exception e){
			return GameException.CODE_参数错误;
		}
		SysMail sysMail = new SysMail();
		sysMail.setPartner(partner);
		sysMail.setSendType(sendType);
		sysMail.setTitle(paramMap.get("title"));
		sysMail.setContent(paramMap.get("content"));
		sysMail.setItems(paramMap.get("items"));
		sysMail.setTime(XyTimeUtil.getNowSecond());
		sysMail.setEndId(endId);
		sysMail.setStartTime(startTime);
		sysMail.setEndTime(endTime);
		if(ids != null && !ids.isEmpty()){
			sysMail.initUids(ids);
		}
		mailService.addSysMail(sysMail);
		return GameException.CODE_正常;
	}

	@Override
	public int deleteSysMail(List<Integer> list) {
		for(Integer id : list){
			mailService.deleteSysMail(id);
		}
		return GameException.CODE_正常;
	}

	@Override
	public int banAccounts(int partner, String username, int banType, int banTime) {
		User user = getUser(partner, username);
		if(user == null){
			return GameException.CODE_用户不存在;
		}else if(banType < 0 || banType > 2 || (banTime > 0 && banTime < XyTimeUtil.getNowSecond())){
			return GameException.CODE_参数错误;
		}else{
			Map<String, String> hash = new HashMap<String, String>();
			if(banType == 1){
				WorldChatAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, WorldChatAction.class);
				action.banChat(user.getUserId(), banTime);
				user.setBanChatTime(banTime);
				hash.put(UserTable.J_BANCHATTIME, String.valueOf(user.getBanChatTime()));
				userService.updateUser(user, hash, true);
			}else if(banType == 2){
				if(banTime > 0){
					LoginAction action = RPCKernel.getRemoteByServerType(Application.WORLD_SERVER, LoginAction.class);
					action.logout(user.getUserId());
					userService.logout(user.getUserId());
				}
				user.setBanLoginTime(banTime);
				userDAO.updateUser(user);
			}
		}
		return GameException.CODE_正常;
	}

	@Override
	public int reloadCache(int type){
		if(type == 0 || type == 1){
			ReloadLevelCacheEvent event = new ReloadLevelCacheEvent();
			TimerController.submitGameEvent(event);
		}
		if(type == 0 || type == 2){
			ReloadFightingCacheEvent event = new ReloadFightingCacheEvent();
			TimerController.submitGameEvent(event);
		}
		return GameException.CODE_正常;
	}
	
	/**
	 * 玩家
	 * @param partner
	 * @param username
	 * @return
	 */
	private User getUser(int partner, String username){
		User user = userDAO.findUserByUsername(username, partner);
		if(user != null){
			user = userService.getUser(user.getUserId(), user);
		}
		return user;
	}

	@Override
	public int sendGoods(int userId, int payGoodsId, int logSubType){
		PayGoods goods = GameCache.getPayGoods(payGoodsId);
		if(goods == null){
			return GameException.CODE_商品不存在;
		}else{
			User user = userService.getUser(userId);
			if(user == null){
				return GameException.CODE_用户不存在;
			}else if(goods.getType() == SystemConstant.PAY_TYPE_CYCLE_CARD){
				UserStat stat = userService.getUserStat(userId);
				CycleCard card = stat.getCycleCard(payGoodsId);
				if(card == null){
					stat.getCycleCardMap().put(payGoodsId, new CycleCard(payGoodsId, goods.getGainDay()));
				}else{
					card.updateEndTime(goods.getGainDay());
				}
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(UserStatTable.CYCLECARDS, SQLOpt.EQUAL);
				userService.updateUserStat(stat, opt);
				//抛出购买月卡事件
				BuyCycleCardEvent event = BuyCycleCardEvent.valueOf(user);
				TimerController.submitGameEvent(event);
			}
			List<ItemEffect> rechanges = effectService.parseItemEffects(goods.getItems(), logSubType);
			ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_订单发货_额外获得);
			UserRecord record = userDAO.getUserRecord(userId);
			if(record.isFirstRecharge(payGoodsId)){
				record.addFirstRecharge(payGoodsId);
				record.initFirstRecharges();
				SQLOpt opt = new SQLOpt();
				opt.putFieldOpt(UserRecordTable.FIRSTRECHARGES, SQLOpt.EQUAL);
				userService.updateUserRecord(record, opt);
				if(goods.getFirstItems().length() > 0){
					effects.appendStrs(goods.getFirstItems());
				}
			}else if(goods.getExtraItems().length() > 0){
				effects.appendStrs(goods.getExtraItems());
			}
			int diamond = 0;
			for(ItemEffect item : rechanges){
				if(item.getType() == SystemConstant.ITEM_EFFECT_TYPE_DIAMOND){
					diamond += item.getValue1();
				}else{
					effects.appendItem(item.getType(), item.getId(), item.getValue1(), item.getValue2());
				}
			}
			int code = effectService.validAdds(user, effects);
			if(code != GameException.CODE_正常){
				throw new GameException(code, "");
			}
			userService.recharge(user, diamond, true, logSubType);
			effects.setDbUp(true);
			effectService.addIncome(user, effects, null);
		}
		return 0;
	}
	
	@Override
	public int addItems(int partner, String username, String items, String delItems){
		User user = getUser(partner, username);
		if(user == null){
			return GameException.CODE_用户不存在;
		}else{
			if(delItems != null && delItems.length() > 0){
				ItemEffects dels = new ItemEffects(SystemConstant.LOGGER_APPROACH_后台操作);
				dels.appendStrs(delItems);
				dels.setDbUp(true);
				effectService.delIncome(user, dels);
			}
			if(items != null && items.length() > 0){
				ItemEffects effects = new ItemEffects(SystemConstant.LOGGER_APPROACH_后台操作);
				effects.appendStrs(items);
				int code = effectService.validAdds(user, effects);
				if(code != GameException.CODE_正常){
					new GameException(code, "");
				}
				effects.setDbUp(true);
				effectService.addIncome(user, effects, null);
			}
		}
		return GameException.CODE_正常;
	}

	@Override
	public int stopServer() {
		userService.clearCacheUsers();
		return GameException.CODE_正常;
	}
	
	@Override
	public int testCmd(int partner, String username, String params){
		User user = getUser(partner, username);
		List<String> list = XyStringUtil.parseListByString(params, XyStringUtil.SPLIT_WELL);
		int zoneId = new Integer(list.get(0));
		System.err.println(userZoneService.gainTrialZones(user.getUserId(), zoneId));
		return 0;
	}

	@Override
	public void initLogicCache() {
		userService.clearCacheUsers();
		mailService.initSysMallCache();
	}
	
	@Override
	public int upgrade(int partner, String username, int level){
		User user = getUser(partner, username);
		if(user == null){
			return GameException.CODE_用户不存在;
		}else{
			int exp = user.getExp();
			if(level < user.getLevel()){
				level = user.getLevel();
			}else if(level > SystemConstant.USER_MAX_LEVEL){
				level = SystemConstant.USER_MAX_LEVEL;
				exp = 0;
			}
			Map<String, String> hash = new HashMap<>();
			if(level != user.getLevel()){
				user.setLevel(level);
				user.setExp(exp);
				hash.put(UserTable.J_LEVEL, String.valueOf(user.getLevel()));
				userDAO.updateUserLevel(user.getLevel(), user.getUserId());
				fightService.computeFightingEvent(user.getUserId());
				userService.updateUser(user, hash, true);
			}
			user.setHeroCapacity(SystemConstant.USER_MAX_HERO_CAPACITY);
			user.setEquipmentCapacity(SystemConstant.USER_MAX_EQUIPMENT_CAPACITY);
			user.setEternalCapacity(SystemConstant.USER_MAX_ETERNAL_CAPACITY);
			hash.put(UserTable.J_HEROCAPACITY, String.valueOf(user.getHeroCapacity()));
			hash.put(UserTable.J_EQUIPMENTCAPACITY, String.valueOf(user.getEquipmentCapacity()));
			hash.put(UserTable.J_ETERNALCAPACITY, String.valueOf(user.getEternalCapacity()));
			ItemEffects removes = new ItemEffects(SystemConstant.LOGGER_APPROACH_后台操作);
			UserTeam team = userTeamService.queryUserTeam(user.getUserId());
			Collection<UserEquipment> equips = userEquipmentService.getUserEquipments(user);
			Iterator<UserEquipment> it = equips.iterator();
			while(it.hasNext()){
				UserEquipment target = it.next();
				if(target.getUserHeroId() == 0){
					removes.appendDelObj(target);
					it.remove();
				}
			}
			Collection<UserEternal> eternals = userEternalService.getUserEternals(user);
			Iterator<UserEternal> itt = eternals.iterator();
			while(itt.hasNext()){
				UserEternal target = itt.next();
				if(!target.isUse()){
					removes.appendDelObj(target);
					itt.remove();
				}
			}
			List<UserHero> heros = userHeroService.getUserHeros(user);
			for(UserHero hero : heros){
				if(team.getHeroList().indexOf(hero.getId()) == -1){
					removes.appendDelObj(hero);
					for(UserEquipment equip : equips){
						if(equip.getUserHeroId() == hero.getId()){
							removes.appendDelObj(equip);
							break;
						}
					}
					for(UserEternal eternal : eternals){
						if(eternal.getUserEternalId() == hero.getEternal()){
							removes.appendDelObj(eternal);
							break;
						}
					}
				}
			}
			
			ItemEffects adds = new ItemEffects(SystemConstant.LOGGER_APPROACH_后台操作);
			List<Integer> eles = new ArrayList<>();
			Collection<Hero> list = GameCache.getHeros();
			for(Hero hero : list){
				if(hero.getQuality() >= 5 && hero.getAtkMode().equals("10101010")
						&& hero.getMoveMode().equals("30333033") && !eles.contains(hero.getEle())){
					eles.add(hero.getEle());
					adds.appendItem(SystemConstant.ITEM_EFFECT_TYPE_HERO, hero.getHeroId(), 1, hero.getMaxLevel());
				}
			}
			Map<Integer, List<Equipment>> map = new HashMap<>();
			Collection<Equipment> list1 = GameCache.getEquipments();
			for(Equipment equip : list1){
				if(equip.getEle() != 0){
					List<Equipment> list2 = map.get(equip.getEle());
					if(list2 == null){
						list2 = new ArrayList<>();
						map.put(equip.getEle(), list2);
					}
					boolean add = true;
					Iterator<Equipment> it1 = list2.iterator();
					while(it1.hasNext()){
						Equipment old = it1.next();
						if(old.getType() == equip.getType()){
							if(old.getQuality() < equip.getQuality()){
								it1.remove();
							}else{
								add = false;
							}
							break;
						}
					}
					if(add){
						list2.add(equip);
					}
				}
			}
			for(List<Equipment> list3 : map.values()){
				for(Equipment equip : list3){
					adds.appendItem(SystemConstant.ITEM_EFFECT_TYPE_EQUIPMENT, equip.getEquipmentId(), 1, equip.getMaxLevel());
				}
			}
			Eternal eternal = GameCache.getEternal(5020012);
			if(eternal != null){
				adds.appendItem(SystemConstant.ITEM_EFFECT_TYPE_ETERNAL, 5020012, eles.size(), 0);
			}
			effectService.delIncome(user, removes);
			effectService.addIncome(user, adds, null);
		}
		return GameException.CODE_正常;
	}
	
	@Override
	public int loadGameCache(){
		return GameCache.loadCache();
	}
	
	@Override
	public int skipGuide(int partner, String username, int guideId){
		User user = getUser(partner, username);
		if(user == null){
			return GameException.CODE_用户不存在;
		}else{
			if(guideId <= 0){
				guideId = 99999999;
			}
			user.setPlotStep(guideId);
			Map<String, String> hash = new HashMap<>();
			hash.put(UserTable.J_PLOTSTEP, String.valueOf(guideId));
			user.setGuideStep(guideId);
			hash.put(UserTable.J_GUIDESTEP, String.valueOf(guideId));
			userService.updateUser(user, hash, true);
		}
		return GameException.CODE_正常;
	}


}
