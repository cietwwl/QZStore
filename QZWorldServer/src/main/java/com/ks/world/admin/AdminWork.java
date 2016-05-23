package com.ks.world.admin;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.DynamicChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;

import com.ks.exceptions.GameException;
import com.ks.protocol.web.HttpResult;
import com.ks.util.JSONUtil;

public class AdminWork implements Runnable {
	private ChannelHandlerContext ctx; 
	private MessageEvent e;
	private Map<String, List<String>> parammaps;
	
	public AdminWork(ChannelHandlerContext ctx, MessageEvent e, Map<String, List<String>> parammaps) {
		super();
		this.ctx = ctx;
		this.e = e;
		this.parammaps = parammaps;
	}

	@Override
	public void run() {
//		final HttpRequest request = (HttpRequest) e.getMessage();
//		final String uri =request.getUri();
//		Map<String, List<String>> parammaps = getParams(uri);
		String action = HttpUtils.getParam("action", parammaps);
		if(action.length() > 0){
			AdminWorkAction work = AdminWorkActionCache.getAction(action);
			HttpResult result = new HttpResult();
			if(work != null){
				result = work.done(ctx, e, parammaps, result);
			}else{
				result.setCode(GameException.CODE_参数错误);
			}
			HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
			response.setHeader("Content-Type", "text/html; charset=UTF-8");
			ChannelBuffer buffer=new DynamicChannelBuffer(2048);
			try {
				buffer.writeBytes(JSONUtil.toJson(result).getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			response.setContent(buffer);
			response.setHeader("Content-Length", response.getContent().writerIndex());
			Channel ch = e.getChannel();
			ch.write(response);
			if(action != null && action.equals("StopServerAction")){
				System.exit(0);
			}
		}
	}
}
