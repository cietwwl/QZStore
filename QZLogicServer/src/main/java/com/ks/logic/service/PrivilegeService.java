package com.ks.logic.service;

import java.util.Date;

import com.ks.access.Transaction;
import com.ks.db.model.User;
import com.ks.object.Privileges;

public interface PrivilegeService {
	
	/**
	 * 获取特权值
	 * @param user
	 * @param type
	 * @return
	 */
	int getPrivilegesValue(User user, int type);
	
	

	/**
	 * 获取特权
	 * @param vip
	 * @return
	 */
	Privileges getPrivileges(int vip);
	
	/**
	 * 获取特权
	 * @param user
	 * @return
	 */
	Privileges getPrivileges(User user);
	
	/**
	 * 更新数据
	 * @param user
	 * @param olds
	 * @param news
	 */
	@Transaction
	void updateDate(User user, Privileges olds, Privileges news);
	
	/**
	 * 重置数据
	 * @param user
	 */
	@Transaction
	void resetDate(User user, Date lastReset);

}
