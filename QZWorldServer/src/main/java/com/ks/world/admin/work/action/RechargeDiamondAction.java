package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.app.Application;
import com.ks.exceptions.GameException;
import com.ks.protocol.web.HttpResult;
import com.ks.rpc.RPCKernel;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;
import com.ks.world.manager.GameLockManager;

/**
 * 充值钻石
 *
 */
public class RechargeDiamondAction extends AdminWorkAction {

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		String username = HttpUtils.getParam("username", parammaps);
		int partner = HttpUtils.getParamInt("partner", parammaps);
		if(username.length() == 0 || partner == 0){
			result.setCode(GameException.CODE_渠道或用户名不能为空);
		}else{
			long keyId = GameLockManager.getInstance().lockUser(username, partner);
			try{
				int amount = HttpUtils.getParamInt("amount", parammaps);
				AdminAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class);
				result = action.rechargeDiamond(username, new Integer(partner), new Integer(amount), result);
			}finally{
				GameLockManager.getInstance().unlockKey(keyId);
			}
		}
		return result;
	}

}
