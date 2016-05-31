package com.ks.action.logic;

import java.util.List;
import java.util.Map;

import com.ks.protocol.web.HttpResult;

public interface AdminAction {
	
	/**
	 * 充值钻石
	 * @param username
	 * @param partner
	 * @param amount
	 * @param result
	 * @return
	 */
	HttpResult rechargeDiamond(String username, int partner, int amount, HttpResult result);
	
	/**
	 * 发送系统邮件
	 * @param partner
	 * @param sendType
	 * @param usernames
	 * @param times
	 * @param title
	 * @param content
	 * @param items
	 * @param uids
	 * @param result
	 * @return
	 */
	HttpResult sendSysMail(Map<String, String> paramMap, HttpResult result);

	/**
	 * 删除系统邮件
	 * @param list
	 * @param result
	 * @return
	 */
	HttpResult deleteSysMail(List<Integer> list, HttpResult result);
	
	/**
	 * 封号/禁言
	 * @param banType
	 * @param banTime
	 * @return
	 */
	HttpResult banAccounts(int partner, String username, int banType, int banTime, HttpResult result);

	/**
	 * 重新加载缓存
	 * @param type(0为全部,1为玩家等级,2为玩家战力)
	 * @return
	 */
	HttpResult reloadCache(int type, HttpResult result);
	
	/**
	 * 发货
	 * @param bill
	 * @return
	 */
	HttpResult sendGoods(int userId, int payGoodsId, int logSubType, HttpResult result);
	
	/**
	 * 添加items
	 * @param username
	 * @param items
	 * @return
	 */
	HttpResult addItems(int partner, String username, String items, String delItems, HttpResult result);
	
	/**
	 * 停服
	 * @param result
	 * @return
	 */
	HttpResult stopServer(HttpResult result);
	
	/**
	 * 测试指令
	 * @param partner
	 * @param username
	 * @param params
	 * @param result
	 * @return
	 */
	HttpResult testCmd(int partner, String username, String params, HttpResult result);
	
	/**
	 * 初始化逻辑缓存
	 */
	void initLogicCache();
	
	/**
	 * 提升
	 * @param partner
	 * @param username
	 * @param level
	 * @param result
	 * @return
	 */
	HttpResult upgrade(int partner, String username, int level, HttpResult result);
	
	/**
	 * 加载游戏配置缓存
	 */
	HttpResult loadGameCache(HttpResult result);
	
	/**
	 * 跳过引导
	 * @param partner
	 * @param username
	 * @param guideId
	 * @param result
	 * @return
	 */
	HttpResult skipGuide(int partner, String username, int guideId, HttpResult result);
}
