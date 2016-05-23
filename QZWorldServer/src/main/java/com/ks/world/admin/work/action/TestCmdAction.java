package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.protocol.web.HttpResult;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;
import com.ks.world.manager.GameLockManager;

public class TestCmdAction extends AdminWorkAction{

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		String username = HttpUtils.getParam("username", parammaps);
		int partner = HttpUtils.getParamInt("partner", parammaps);
		Long keyId = GameLockManager.getInstance().lockUser(username, partner);
		try{
			String params = HttpUtils.getParam("PRS", parammaps);
			return adminAction().testCmd(partner, username, params, result);
		}finally{
			GameLockManager.getInstance().unlockKey(keyId);
		}
	}

}
