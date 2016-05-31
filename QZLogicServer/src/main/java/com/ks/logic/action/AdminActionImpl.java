package com.ks.logic.action;

import java.util.List;
import java.util.Map;

import com.ks.action.logic.AdminAction;
import com.ks.logic.service.AdminService;
import com.ks.logic.service.ServiceFactory;
import com.ks.protocol.web.HttpResult;


public class AdminActionImpl implements AdminAction{
	
	private static final AdminService adminService = ServiceFactory.getService(AdminService.class);

	@Override
	public HttpResult rechargeDiamond(String username, int partner, int amount, HttpResult result){
		result.setCode(adminService.rechargeDiamond(username, partner, amount));
		return result;
	}

	@Override
	public HttpResult sendSysMail(Map<String, String> paramMap, HttpResult result) {
		result.setCode(adminService.sendSysMail(paramMap));
		return result;
	}

	@Override
	public HttpResult deleteSysMail(List<Integer> list, HttpResult result) {
		result.setCode(adminService.deleteSysMail(list));
		return result;
	}

	@Override
	public HttpResult banAccounts(int partner, String username, int banType, int banTime, HttpResult result) {
		result.setCode(adminService.banAccounts(partner, username, banType, banTime));
		return result;
	}
	
	@Override
	public HttpResult reloadCache(int type, HttpResult result){
		result.setCode(adminService.reloadCache(type));
		return result;
	}

	@Override
	public HttpResult sendGoods(int userId, int payGoodsId, int logSubType, HttpResult result) {
		result.setCode(adminService.sendGoods(userId, payGoodsId, logSubType));
		return result;
	}

	@Override
	public HttpResult addItems(int partner, String username, String items, String delItems, HttpResult result) {
		result.setCode(adminService.addItems(partner, username, items, delItems));
		return result;
	}

	@Override
	public HttpResult stopServer(HttpResult result) {
		result.setCode(adminService.stopServer());
		return result;
	}

	@Override
	public HttpResult testCmd(int partner, String username, String params, HttpResult result) {
		result.setCode(adminService.testCmd(partner, username, params));
		return result;
	}

	@Override
	public void initLogicCache() {
		adminService.initLogicCache();
	}

	@Override
	public HttpResult upgrade(int partner, String username, int level, HttpResult result) {
		result.setCode(adminService.upgrade(partner, username, level));
		return result;
	}

	@Override
	public HttpResult loadGameCache(HttpResult result) {
		result.setCode(adminService.loadGameCache());
		return result;
	}

	@Override
	public HttpResult skipGuide(int partner, String username, int guideId, HttpResult result) {
		result.setCode(adminService.skipGuide(partner, username, guideId));
		return result;
	}


}
