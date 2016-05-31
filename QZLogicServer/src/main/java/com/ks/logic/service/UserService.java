package com.ks.logic.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ks.access.SQLOpt;
import com.ks.access.Transaction;
import com.ks.db.cfg.UserRule;
import com.ks.db.model.User;
import com.ks.db.model.UserRecord;
import com.ks.db.model.UserStat;
import com.ks.model.user.UserBaseinfo;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.login.LoginResultVO;
import com.ks.protocol.vo.login.LoginVO;
import com.ks.protocol.vo.login.RegisterVO;
import com.ks.protocol.vo.user.UserInfoVO;
import com.ks.protocol.vo.user.ViewUserVO;


/**
 * 用户服务
 * @author ks
 */
public interface UserService {
	
	/**
	 * 更新玩家数据
	 * @param user
	 * @param hash
	 */
	@Transaction
	void updateUser(User user, 	Map<String,String> hash, boolean updatedb);
	
	/**
	 * 更新用户统计
	 * @param stat
	 */
	@Transaction
	void updateUserStat(UserStat stat, SQLOpt opt);
	
	/**
	 * 添加用户统计
	 * @param stat
	 */
	@Transaction
	void addUserStat(UserStat stat);
	
	/**
	 * 更新用户记录
	 * @param record
	 * @param opt
	 */
	@Transaction
	void updateUserRecord(UserRecord record, SQLOpt opt);
	
	/**
	 * 用户登录
	 * @param login 登陆信息
	 * @return 用户登录结果
	 */
	@Transaction
	LoginResultVO userLogin(LoginVO login);
	/**
	 * 用户退出
	 * @param userId 用户编号
	 */
	@Transaction
	void logout(int userId);
	
	/**
	 * 用户注册
	 * @param register 注册信息
	 */
	@Transaction
	void userRegister(RegisterVO register);
	/**
	 * 获取用户信息
	 * @param userId 用户编号
	 * @return 用户信息
	 */
	@Transaction
	UserInfoVO gainUserInfo(int userId);
	/**
	 * 获得在线用户
	 * @param userId 用户编号
	 * @return 在线用户
	 */
	User getOnlineUser(int userId);
	
	/**
	 * 查询缓存玩家
	 * @param userId
	 * @return
	 */
	User queryCacheUser(int userId);
	
	/**
	 * 获得用户
	 * @param userId 用户编号
	 * @return 用户
	 */
	User getUser(int userId);
	
	/**
	 * 获取用户(缓存拿不到直接返回dbUser);
	 * @param userId
	 * @param dbUser
	 * @return
	 */
	User getUser(int userId, User dbUser);
	/**
	 * 查询用户规则
	 * @return 用户规则
	 */
	List<UserRule> queryUserRules();
	
	/**
	 * 获得用户统计
	 * @param userId 用户编号
	 * @return 用户统计
	 */
	@Transaction
	UserStat getUserStat(int userId);
	
	/**
	 * 查看用户
	 * @param userId 用户编号
	 * @return 查看的用户
	 */
	ViewUserVO viewUser(int userId);
	
	/**
	 * 检查体力
	 * @param user 用户
	 */
	void checkStamina(User user);
	/**
	 * 获得用户基本信息
	 * @param userId 用户编号
	 * @return 基本信息
	 */
	@Transaction
	UserBaseinfo getUserBaseInfo(int userId);
	
	/**
	 * 获得用户基本信息
	 * @param userIds 用户编号
	 * @return 基本信息
	 */
	@Transaction
	List<UserBaseinfo> getUserBaseInfo(Collection<Integer> userIds);
	/**
	 * 领取登录奖励
	 * @param userId 用户
	 * @return 获得的奖励
	 */
	@Transaction
	GainGameAwardVO drawLoginAwards(int userId);
	
	/**
	 * 领取vip礼包
	 * @param userId 用户
	 * @param vipLevel vip等级
	 * @return 获得的奖励
	 */
	@Transaction
	GainGameAwardVO drawVIPGifi(int userId,int vipLevel);
	
	/**
	 * 修改剧情步骤
	 * @param userId
	 * @param plotStep
	 */
	@Transaction
	void updatePlotStep(int userId,int plotStep);
	/**
	 * 修改新手步骤
	 * @param userId
	 * @param guideStep
	 */
	@Transaction
	void updateGuideStep(int userId,int guideStep);
	
	/**
	 * 获取引导
	 * @param userId
	 * @return
	 */
	List<Integer> getGuideSteps(int userId);
	
	
	/**
	 * 增加今日装备提升等级之和
	 * @param userId
	 */
	@Transaction
	void increTodayEquipLevelUpTimes(int userId, int upLevel);
	
	/**
	 * 增加今日英雄提升等级之和
	 * @param userId
	 */
	@Transaction
	void increTodayHeroLevelUpTimes(int userId, int upLevel);
	
	/**
	 * 增加累计竞技场挑战次数
	 * @param userId
	 */
	@Transaction
	void increArenaFightCount(int userId, int count);
	
	/**
	 * 增加武道大会挑战次数
	 * @param userId
	 */
	@Transaction
	void increMartialwayFightCount(int userId, int count);
	
	/**
	 * 增加获得道具数量
	 * @param userId
	 */
	@Transaction
	void increAddItemCount(int userId, int count);
	
	
	/**
	 * 购买金币
	 * @param userId
	 */
	@Transaction
	void buyGold(int userId);
	/**
	 * 购买体力
	 * @param userId
	 */
	@Transaction
	void buyStamina(int userId);
	/**
	 * 签到/补签
	 * @param userId
	 * @param day
	 * @return
	 */
	@Transaction
	GainAwardVO signin(int userId,int day);
	/**
	 * 领取累计签到奖励
	 * @param userId
	 * @param sumDay
	 * @return
	 */
	@Transaction
	GainAwardVO drawSumSignin(int userId , int sumDay);
	/**
	 * 修改功能解锁
	 * @param userId 用户编号
	 * @param funUnlock 功能解锁
	 */
	void updateFunUnlock(int userId, int funUnlock);
	/**
	 * 
	 * @param userId
	 */
	@Transaction
	void setUserOnline(int userId);
	
	/**
	 * 升级名望
	 * @param userId
	 */
	@Transaction
	GainGameAwardVO levelUpFame(int userId);
	/**
	 * 领取石板
	 * @param userId
	 */
	@Transaction
	void gainSlate(int userId);
	
	/**
	 * 重新取名
	 * @param userId
	 */
	@Transaction
	void givePlayerName(int userId, String playerName);
	
	/**
	 * 增加经验池上限
	 * @param userId
	 */
	@Transaction
	void increExpPool(int userId, int times);
	
	/**
	 * 增加熔炼池上限
	 * @param userId
	 */
	@Transaction
	void increEternalSmelting(int userId, int times);
	
	/**
	 * 在线人数统计
	 * @param amount 人数
	 */
	@Transaction
	void onlineReport(int amount, int time);
	
	/**
	 * 查找玩家
	 * @return
	 */
	User findUserByUsername(String username, int partner);
	
	/**
	 * 查找玩家id
	 * @param username
	 * @param partner
	 * @return
	 */
	int findUserIdByUsername(String username, int partner);
	
	/**
	 * 心跳
	 * @param userId
	 */
	@Transaction
	void heard(int userId);
	
	/**
	 * 查询用户战力
	 * @param userId
	 * @return
	 */
	int getUserFighting(int userId);
	
	/**
	 * 刷新战斗力缓存
	 */
	void reloadUserFightingCache();
	
	/**
	 * 刷新等级缓存
	 */
	void reloadUserLevelCache();
	
	/**
	 * 充值钻石
	 */
	@Transaction
	void recharge(User user, int diamond, boolean dbUp, int logType);
	
	/**
	 * 校验试炼次数
	 * @param user
	 * @param stat
	 * @param zoneId
	 * @param number
	 */
	void validTrialsNumber(User user, UserStat stat, int zoneId, int number);
	
	/**
	 * 添加累计次数
	 * @param userId
	 * @param zoneId
	 * @param number
	 */
	@Transaction
	void addTrialsCountNumber(User user, int zoneId, int number);
	
	/**
	 * 清理缓存中玩家
	 */
	@Transaction
	void clearCacheUsers();
}