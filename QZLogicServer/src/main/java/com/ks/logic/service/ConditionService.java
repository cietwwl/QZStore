package com.ks.logic.service;

import com.ks.db.model.User;
import com.ks.object.ConditionParams;

public interface ConditionService {

	/**
	 * 校验条件
	 * @param user
	 * @param params
	 * @return
	 */
	int validCondition(User user, ConditionParams params);
}
