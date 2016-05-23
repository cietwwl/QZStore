package com.ks.logic.service;

import java.util.List;
import java.util.Map;

import com.ks.access.Transaction;


public interface AdminService {

	/**
	 * 充值钻石
	 * @param username
	 * @param partner
	 * @param amount
	 * @return
	 */
	@Transaction
	int rechargeDiamond(String username, int partner, int amount);
	
	/**
	 * 发送系统邮件
	 * @param partner
	 * @param sendType
	 * @param uids
	 * @param times
	 * @param title
	 * @param content
	 * @param items
	 * @param uids
	 * @param result
	 * @return
	 */
	@Transaction
	int sendSysMail(Map<String, String> paramMap);
	
	/**
	 * 删除系统邮件
	 * @param id
	 */
	@Transaction
	int deleteSysMail(List<Integer> list);
	
	/**
	 * 封号/禁言
	 * @param banType
	 * @param banTime
	 * @return
	 */
	@Transaction
	int banAccounts(int partner, String username, int banType, int banTime);
	
	/**
	 * 重新加载缓存
	 * @param type
	 * @return
	 */
	int reloadCache(int type);
	
	/**
	 * 发货
	 * @param userId
	 * payGoodsId
	 * @return
	 */
	@Transaction
	int sendGoods(int userId, int payGoodsId, int logSubType);
	
	/**
	 * 添加道具效果
	 * @param userId
	 * @param items
	 * @return
	 */
	@Transaction
	int addItems(int partner, String username, String items);
	
	/**
	 * 停服
	 * @return
	 */
	@Transaction
	int stopServer();
	
	/**
	 * 测试指令
	 * @param partner
	 * @param username
	 * @param params
	 * @return
	 */
	@Transaction
	int testCmd(int partner, String username, String params);
	
	/**
	 * 初始化逻辑缓存
	 */
	@Transaction
	void initLogicCache();
	
	/**
	 * 提升
	 * @param partner
	 * @param username
	 * @param level
	 * @return
	 */
	@Transaction
	int upgrade(int partner, String username, int level);
	
	/**
	 * 加载游戏配置缓存
	 */
	@Transaction
	int loadGameCache();
	
	/**
	 * 跳过引导
	 * @param partner
	 * @param username
	 * @param guideId
	 */
	@Transaction
	int skipGuide(int partner, String username, int guideId);
}
