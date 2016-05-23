package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.app.Application;
import com.ks.constant.SystemConstant;
import com.ks.lock.KeyLock;
import com.ks.protocol.web.HttpResult;
import com.ks.rpc.RPCKernel;
import com.ks.util.LockKeyUtil;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;
import com.ks.world.manager.GameLockManager;

/**
 * 后台发货
 */
public class SendGoodsAction extends AdminWorkAction{

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		int userId = HttpUtils.getParamInt("userId", parammaps);
		KeyLock key = GameLockManager.getInstance().lockKey(LockKeyUtil.getUserLockKey(userId));
		try{
			int payGoodsId = HttpUtils.getParamInt("payGoodsId", parammaps);
			AdminAction admin = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class);
			return admin.sendGoods(userId, payGoodsId, SystemConstant.LOGGER_APPROACH_后台操作, result);
		}finally{
			GameLockManager.getInstance().unlockKey(key);
		}
	}

}
