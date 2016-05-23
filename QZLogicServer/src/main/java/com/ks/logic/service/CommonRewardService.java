package com.ks.logic.service;

import java.util.List;

import com.ks.access.Transaction;
import com.ks.db.cfg.CommonRewardConfig;
import com.ks.db.model.User;
import com.ks.protocol.vo.goods.GainAwardVO;

public interface CommonRewardService {
	
	/**
	 * 查询通用奖励配置
	 */
	List<CommonRewardConfig> queryCommonRewardConfigs();
	
	/**
	 * 领取奖励
	 */
	@Transaction
	GainAwardVO receiveReward(User user, int id);

}
