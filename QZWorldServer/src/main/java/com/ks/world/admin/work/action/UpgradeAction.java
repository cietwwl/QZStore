package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.app.Application;
import com.ks.protocol.web.HttpResult;
import com.ks.rpc.RPCKernel;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;
import com.ks.world.manager.GameLockManager;

/**
 * 提升
 * @author szsf
 *
 */
public class UpgradeAction extends AdminWorkAction {

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		int partner = HttpUtils.getParamInt("partner", parammaps);
		String username = HttpUtils.getParam("username", parammaps);
		Long keyId = GameLockManager.getInstance().lockUser(username, partner);
		try{
			int level = HttpUtils.getParamInt("level", parammaps);
			AdminAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class);
			return action.upgrade(partner, username, level, result);
		}finally{
			GameLockManager.getInstance().unlockKey(keyId);
		}
	}

}
