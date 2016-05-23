package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.model.UserBuff;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.UserBuffService;

public class UserBuffServiceImpl extends BaseService implements UserBuffService {

	@Override
	public List<UserBuff> gainUserBuffs(int userId) {
		return userBuffDAO.queryUserBuffs(userId);
	}

}
