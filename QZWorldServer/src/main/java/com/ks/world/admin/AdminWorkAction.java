package com.ks.world.admin;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.app.Application;
import com.ks.protocol.web.HttpResult;
import com.ks.rpc.RPCKernel;

/**
 * 后台服务端口
 * @author zck
 *
 */
public abstract class AdminWorkAction {
	public AdminAction adminAction(){
		return RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class);
	}
	public abstract HttpResult done(ChannelHandlerContext ctx, final MessageEvent e, Map<String, List<String>> parammaps, HttpResult result);
}
