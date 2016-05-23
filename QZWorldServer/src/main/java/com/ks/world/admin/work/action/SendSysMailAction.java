package com.ks.world.admin.work.action;

import java.util.HashMap;
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

/**
 * 发送系统邮件
 */
public class SendSysMailAction extends AdminWorkAction{

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("check", HttpUtils.getParam("check", parammaps));
		paramMap.put("partner", HttpUtils.getParam("partner", parammaps));  //平台编号(0不检查)
		paramMap.put("sendType", HttpUtils.getParam("sendType", parammaps));//发送类型:1指定玩家，3指定时间段, 4当前全服，5长期全服
		paramMap.put("title", HttpUtils.getParam("title", parammaps));   //标题
		paramMap.put("content", HttpUtils.getParam("content", parammaps)); //内容
		paramMap.put("openids", HttpUtils.getParam("openids", parammaps));   //指定用户(openid;openid)
		paramMap.put("times", HttpUtils.getParam("times", parammaps)); //指定有效时间段(startTime_endTime)
		paramMap.put("items", HttpUtils.getParam("items", parammaps));  //物品(type_id_amount_value|type_id_amount_value)
		AdminAction action = RPCKernel.getRemoteByServerType(Application.LOGIC_SERVER, AdminAction.class);
		return action.sendSysMail(paramMap, result);
	}

}
