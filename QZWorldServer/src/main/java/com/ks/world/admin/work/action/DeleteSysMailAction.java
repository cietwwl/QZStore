package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.action.logic.AdminAction;
import com.ks.app.Application;
import com.ks.protocol.web.HttpResult;
import com.ks.rpc.RPCKernel;
import com.ks.util.XyStringUtil;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;

/**
 * 删除系统邮件
 *
 */
public class DeleteSysMailAction extends AdminWorkAction{

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		String mailIds = HttpUtils.getParam("mailIds", parammaps);  //系统邮件ids(id_id)
		List<Integer> list = XyStringUtil.parseList(mailIds, XyStringUtil.SPLIT_UNDERLINE);
		AdminAction admin = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class);
		return admin.deleteSysMail(list, result);
	}

}
