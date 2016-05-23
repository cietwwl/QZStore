package com.ks.logic.service.impl;

import java.util.Date;

import com.ks.access.SQLOpt;
import com.ks.constant.SystemConstant;
import com.ks.db.cfg.VipConfig;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.logic.cache.GameCache;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.PrivilegeService;
import com.ks.object.Privileges;
import com.ks.table.UserStatTable;
import com.ks.util.XyTimeUtil;

/**
 * 特权
 *
 */
public class PrivilegeServiceImpl extends BaseService implements PrivilegeService{

	@Override
	public int getPrivilegesValue(User user, int type){
		Privileges privileges = getPrivileges(user);
		int value = privileges.getValueInt(type);
		if(type == SystemConstant.PRIVILEGE_TYPE_MAX_FRIEND_NUMBER){
			value += SystemConstant.FRIEND_MAX_FRIEND_COUNT;
		}
		return value;
	}
	
	@Override
	public Privileges getPrivileges(int vip){
		Privileges privileges = new Privileges();
		VipConfig config = GameCache.getVipConfig(vip);
		if(config != null){
			privileges.merge(config.getVipPrivilege());
		}
		return privileges;
	}
	
	@Override
	public Privileges getPrivileges(User user){
		Privileges privileges = user.getPrivileges();
		if(privileges == null){
			privileges = getPrivileges(user.getVip());
			user.setPrivileges(privileges);
		}
		return privileges;
	}
	
	/**
	 * 更新特权数据(数据处理)
	 */
	@Override
	public void updateDate(User user, Privileges olds, Privileges news){
		
	}
	
	/**
	 * 重置特权数据
	 */
	@Override
	public void resetDate(User user, Date lastReset){
		Date reset = XyTimeUtil.getDate(5, 0, 0);
		if(XyTimeUtil.before(lastReset, reset)){
			UserStat stat = userService.getUserStat(user.getUserId());
			if(stat != null){
				SQLOpt opt = new SQLOpt();
				Date now = XyTimeUtil.getNowDate();
				Date monthZero = XyTimeUtil.getDateOfMonthDay(now, 1, 0, 0, 0);
				if(XyTimeUtil.before(lastReset, monthZero)){
					stat.setSigninDays("");  //签到日期
					stat.setFillSignin(0);   //补签次数
					stat.setSumSigninDays("");  //累计签到奖励
					opt.putFieldOpt(UserStatTable.SIGNINDAYS, SQLOpt.EQUAL);
					opt.putFieldOpt(UserStatTable.FILLSIGNIN, SQLOpt.EQUAL);
					opt.putFieldOpt(UserStatTable.SUMSIGNINDAYS, SQLOpt.EQUAL);
				}
				stat.setBuyGoldCount((byte) 0);   //可购买金币次数
				stat.setBuyStaminaCount((byte) 0);  //可购买体力次数
				stat.setMartialWayCount((byte)0);   //武道大会已挑战次数
				stat.setMartialWayBuyCount((byte) 0);  //武道大会已购买次数
				stat.setBlackMarketRefCount(0);  //黑市刷新次数
				stat.setDrawLoginAward(false);  //每日登录奖励
				stat.setTodayEquipCountLevel(0);  //今日装备累计提升等级
				stat.setTodayHeroCountLevel(0);  //今日伙伴累计提升等级
				stat.setArenaCount(SystemConstant.ARENA_DAILY_NUMBER);  //竞技场挑战次数
				stat.setArenaBuyCount(0);  //竞技场已购买次数
				stat.setArenaRefreshCount(0);  //竞技场商店刷新次数
				stat.setMallBuyCount("[]");  //商城已购买
				stat.setGivingFriend("");  //赠送过的好友
				stat.setCollectStamina(0);  //收取体力
				stat.setActivityZoneCount("[]"); //活动副本次数
				stat.setGoldCall(0);   //免费金币召唤
				stat.setLastGoldCallTime(XyTimeUtil.getDate(XyTimeUtil.getNowSecond() - SystemConstant.HERO_CALL_GOLD_FREE_CD));   //上一次金币召唤时间
				stat.setUpdateTime(now);  //更新时间
				stat.setBreadStoreCount(0);  //包子铺已挑战次数
				stat.setGodWealthCount(0);  //财神殿已挑战次数
				stat.setAnimaTempleCount(0); //灵气殿已挑战次数
				stat.setBreadStoreFreeRefreshCount(0);  //包子铺已使用免费刷新次数
				stat.setBreadStoreDiamondRefreshCount(0);   //包子铺已使用钻石刷新次数
				opt.putFieldOpt(UserStatTable.BUYGOLDCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.BUYSTAMINACOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.MARTIALWAYCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.MARTIALWAYBUYCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.BLACKMARKETREFCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.DRAWLOGINAWARD, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.TODAYEQUIPCOUNTLEVEL, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.TODAYHEROCOUNTLEVEL, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.ARENACOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.ARENABUYCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.ARENAREFRESHCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.MALLBUYCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.GIVINGFRIEND, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.COLLECTSTAMINA, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.ACTIVITYZONECOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.GOLDCALL, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.LASTGOLDCALLTIME, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.UPDATETIME, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.BREADSTORECOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.GODWEALTHCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.ANIMATEMPLECOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.BREADSTOREFREEREFRESHCOUNT, SQLOpt.EQUAL);
				opt.putFieldOpt(UserStatTable.BREADSTOREDIAMONDREFRESHCOUNT, SQLOpt.EQUAL);
				userService.updateUserStat(stat, opt);
			}
		}
	}
	
}
