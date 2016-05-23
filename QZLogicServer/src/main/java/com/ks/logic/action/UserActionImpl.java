package com.ks.logic.action;

import com.ks.action.logic.UserAction;
import com.ks.db.model.User;
import com.ks.logic.service.ServiceFactory;
import com.ks.logic.service.UserService;

public class UserActionImpl implements UserAction{
	
	public static final UserService userService = ServiceFactory.getService(UserService.class);

	@Override
	public void onlineReport(int amount, int time) {
		userService.onlineReport(amount, time);
	}
	
	@Override
	public User findUserByUsername(String username, int partner) {
		return userService.findUserByUsername(username, partner);
	}
	
	public int findUserIdByUsername(String username, int partner) {
		return userService.findUserIdByUsername(username, partner);
	}
}
