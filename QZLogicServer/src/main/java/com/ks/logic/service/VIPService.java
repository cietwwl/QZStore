package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.VipConfig;
import com.ks.db.model.User;


/**
 * vip
 * @author ks
 */
public interface VIPService {
	
	/**
	 * 获取vip配置
	 */
	List<VipConfig> queryVipConfigs();
		
	/**
	 * 更新vip
	 */
	@Transaction
	void updateVip(User user, int oldVip);
	
	/**
	 * 修复vip
	 * @param user
	 */
	@Transaction
	void repairVip(User user);
}
