package com.ks.world.admin.work.action;

import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

import com.ks.object.ChatMsg;
import com.ks.protocol.web.HttpResult;
import com.ks.util.XyTimeUtil;
import com.ks.world.admin.AdminWorkAction;
import com.ks.world.admin.HttpUtils;
import com.ks.world.kernel.WorldServerCache;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 聊天监控
 *
 */
public class MonitorChatAction extends AdminWorkAction{

	@Override
	public HttpResult done(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps, HttpResult result){
		int type = HttpUtils.getParamInt("type", parammaps);
		int time = HttpUtils.getParamInt("time", parammaps);
		List<ChatMsg> msgs = WorldServerCache.getChatMsgs(type, time);
		JSONObject resp = new JSONObject();
		JSONArray array = new JSONArray();
		for(ChatMsg msg : msgs){
			JSONObject json = new JSONObject();
			json.put("type", msg.getType());
			json.put("content", msg.getContent());
			json.put("senderId", msg.getSenderId());
			json.put("sender", msg.getSender());
			json.put("senderLv", msg.getSenderLv());
			json.put("senderVip", msg.getSenderVip());
			json.put("senderTime", msg.getSenderTime());
			array.add(json);
		}
		resp.put("time", XyTimeUtil.getNowSecond());
		resp.put("msgs", array);
		result.setData(resp);
		return result;
	}

}
