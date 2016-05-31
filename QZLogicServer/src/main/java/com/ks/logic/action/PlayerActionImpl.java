package com.ks.logic.action;

import java.util.List;

import com.ks.action.logic.PlayerAction;
import com.ks.db.model.User;
import com.ks.db.model.UserStat;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserService;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.goods.GainAwardVO;
import com.ks.protocol.vo.goods.GainGameAwardVO;
import com.ks.protocol.vo.login.LoginResultVO;
import com.ks.protocol.vo.login.LoginVO;
import com.ks.protocol.vo.login.RegisterVO;
import com.ks.protocol.vo.user.UserInfoVO;
import com.ks.protocol.vo.user.UserStatVO;
import com.ks.protocol.vo.user.UserVO;
import com.ks.protocol.vo.user.ViewUserVO;

public final class PlayerActionImpl implements PlayerAction {

	private static UserService userService = ServiceFactory.getService(UserService.class);

	@Override	
	public LoginResultVO userLogin(LoginVO login) {
		return userService.userLogin(login);
	}

	@Override
	public void logout(int userId) {
		userService.logout(userId);
	}

	@Override
	public void userRegister(RegisterVO register) {
		userService.userRegister(register);
	}

	@Override
	public UserInfoVO gainUserInfo(int userId) {
		return userService.gainUserInfo(userId);
	}

	@Override
	public UserVO gainUserSimpleInfo(int userId) {
		UserVO vo = MessageFactory.getMessage(UserVO.class);
		User user = userService.getOnlineUser(userId);
		userService.checkStamina(user);
		vo.init(user);
		return vo;
	}

	@Override
	public ViewUserVO viewUser(int userId) {
		return userService.viewUser(userId);
	}

	@Override
	public UserStatVO gainUserStat(int userId) {
		UserStat stat = userService.getUserStat(userId);
		UserStatVO vo = MessageFactory.getMessage(UserStatVO.class);
		vo.init(stat);
		return vo;
	}

	@Override
	public GainGameAwardVO drawLoginAwards(int userId) {
		return userService.drawLoginAwards(userId);
	}

	@Override
	public GainGameAwardVO drawVIPGifi(int userId, int vipLevel) {
		return userService.drawVIPGifi(userId, vipLevel);
	}

	@Override
	public void updatePlotStep(int userId, int plotStep) {
		userService.updatePlotStep(userId, plotStep);
	}

	@Override
	public void updateGuideStep(int userId, int guideStep) {
		userService.updateGuideStep(userId, guideStep);
	}

	@Override
	public List<Integer> getGuideSteps(int userId){
		return userService.getGuideSteps(userId);
	}

	@Override
	public void buyGold(int userId) {
		userService.buyGold(userId);
	}

	@Override
	public void buyStamina(int userId) {
		userService.buyStamina(userId);
	}

	@Override
	public GainAwardVO signin(int userId, int day) {
		return userService.signin(userId, day);
	}

	@Override
	public GainAwardVO drawSumSignin(int userId, int sumDay) {
		return userService.drawSumSignin(userId, sumDay);
	}

	@Override
	public void updateFunUnlock(int userId, int funUnlock) {
		userService.updateFunUnlock(userId, funUnlock);
	}

	@Override
	public void setUserOnline(int userId) {
		userService.setUserOnline(userId);
	}

	@Override
	public GainGameAwardVO levelUpFame(int userId) {
		return userService.levelUpFame(userId);
	}

	@Override
	public void gainSlate(int userId) {
		userService.gainSlate(userId);
	}

	@Override
	public void givePlayerName(int userId, String playerName) {
		userService.givePlayerName(userId, playerName);
	}

	@Override
	public void increExpPool(int userId, int times) {
		userService.increExpPool(userId, times);
	}

	@Override
	public void increEternalSmelting(int userId, int times) {
		userService.increEternalSmelting(userId, times);
	}

	@Override
	public void heard(int userId) {
		userService.heard(userId);
	}
}
