package com.ks.action.logic;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.login.LoginResultVO;
import com.ks.protocol.vo.login.LoginVO;
import com.ks.protocol.vo.login.RegisterVO;
import com.ks.protocol.vo.user.UserInfoVO;
import com.ks.protocol.vo.user.UserStatVO;
import com.ks.protocol.vo.user.UserVO;
import com.ks.protocol.vo.user.ViewUserVO;
import com.ks.rpc.Timeout;

/**
 * 
 * @author ks
 *
 */
public interface PlayerAction{
	
	/**
	 * 用户登录
	 * @param login 登陆信息
	 * @return 用户登录结果
	 */
	LoginResultVO userLogin(LoginVO login);
	/**
	 * 用户下线
	 * @param userId 用户编号
	 */
	@Timeout(time=1000L)
	void logout(int userId);
	/**
	 * 用户注册
	 * @param register 注册信息
	 */
	void userRegister(RegisterVO register);
	/**
	 * 获取用户信息
	 * @param userId 用户编号
	 * @return 用户信息
	 */
	UserInfoVO gainUserInfo(int userId);
	/**
	 * 获得用户简单信息
	 * @param userId 用户编号
	 * @return 用户简单信息
	 */
	UserVO gainUserSimpleInfo(int userId);
	/**
	 * 查看用户信息
	 * @param userId 用户编号
	 * @return 用户信息
	 */
	ViewUserVO viewUser(int userId);
	
	/**
	 * 获得用户统计
	 * @param userId 用户编号
	 * @return 用户统计
	 */
	UserStatVO gainUserStat(int userId);
	
	/**
	 * 领取登录奖励
	 * @param userId 用户
	 * @return 获得的奖励
	 */
	GainGameAwardVO drawLoginAwards(int userId);
	
	/**
	 * 领取vip礼包
	 * @param userId 用户
	 * @param vipLevel vip等级
	 * @return 获得的奖励
	 */
	GainGameAwardVO drawVIPGifi(int userId,int vipLevel);
	
	/**
	 * 修改剧情步骤
	 * @param userId
	 * @param plotStep
	 */
	void updatePlotStep(int userId,int plotStep);
	
	/**
	 * 修改新手步骤
	 * @param userId
	 * @param guideStep
	 */
	void updateGuideStep(int userId,int guideStep);

	/**
	 * 获取引导
	 * @param userId
	 * @return
	 */
	List<Integer> getGuideSteps(int userId);
	
	/**
	 * 购买金币
	 * @param userId
	 */
	void buyGold(int userId);
	/**
	 * 购买体力
	 * @param userId
	 */
	void buyStamina(int userId);
	
	/**
	 * 签到
	 * @param userId
	 * @param day
	 * @return
	 */
	GainAwardVO signin(int userId,int day);
	/**
	 * 领取累计签到奖励
	 * @param userId
	 * @param sumDay
	 * @return
	 */
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
	void setUserOnline(int userId);
	
	/**
	 * 升级名望
	 * @param userId
	 */
	GainGameAwardVO levelUpFame(int userId);
	/**
	 * 领取石板
	 * @param userId
	 */
	void gainSlate(int userId);
	
	/**
	 * 重新取名
	 * @param userId
	 */
	void givePlayerName(int userId, String playerName);
	
	/**
	 * 增加经验池上限
	 * @param userId
	 */
	void increExpPool(int userId, int times);
	
	/**
	 * 增加熔炼池上限
	 * @param userId
	 */
	void increEternalSmelting(int userId, int times);
	
	/**
	 * 心跳
	 * @param userId
	 */
	@Transaction
	void heard(int userId);
}