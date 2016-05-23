package com.ks.logic.service;

import java.util.List;

import com.ks.db.model.UserBuff;

public interface UserBuffService {
	/**
	 * 用的用户buff
	 * @param userId 用户编号
	 * @return 用户buff
	 */
	List<UserBuff> gainUserBuffs(int userId);
}
