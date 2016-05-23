package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.protocol.web.HttpResult;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;

/**
 * 重新加载缓存
 * @author Administrator
 *
 */
public class ReloadCacheAction extends AdminWorkAction {

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e,
			Map<String, List<String>> parammaps, HttpResult result) {
		int type = HttpUtils.getParamInt("type", parammaps);
		AdminAction action = adminAction();
		result = action.reloadCache(type, result);
		return result;
	}

}
