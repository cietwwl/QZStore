package com.ks.world.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.jboss.netty.handler.codec.http.multipart.Attribute;
import org.jboss.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import org.jboss.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import org.jboss.netty.handler.codec.http.multipart.InterfaceHttpData;
import org.jboss.netty.handler.codec.http.multipart.InterfaceHttpData.HttpDataType;

import com.ks.app.GameWorkExecutor;

/**
 * 后台管理接口
 * @author zck
 *
 */
public class AdminHandler extends SimpleChannelHandler {
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		 ctx.getChannel().close();
	}
	@Override
	public void messageReceived(ChannelHandlerContext ctx, final MessageEvent e)
			throws Exception {
		HttpRequest req = (HttpRequest)e.getMessage();
		Map<String, List<String>> parammaps = null;
		if(req.getMethod() == HttpMethod.GET){
			parammaps = getGetParams(req);
		}else{
			parammaps = getPostParams(req);
		}
		GameWorkExecutor.execute(new AdminWork(ctx, e, parammaps));
//		super.messageReceived(ctx, e);
	}
	


	private Map<String, List<String>> getGetParams(HttpRequest req){
		String url = req.getUri();
		QueryStringDecoder queryString = new QueryStringDecoder(url);
		Map<String, List<String>> params = queryString.getParameters();
		return params;
	}
	
	private Map<String, List<String>> getPostParams(HttpRequest req) throws Exception{
		Map<String, List<String>> params = new HashMap<String, List<String>>();
		HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), req);
		for(InterfaceHttpData data : decoder.getBodyHttpDatas()){
			if(data.getHttpDataType() == HttpDataType.Attribute){
				Attribute attribute = (Attribute) data;
				List<String> list = params.get(attribute.getName());
				if(list == null){
					list = new ArrayList<String>();
					params.put(attribute.getName(), list);
				}
				list.add(attribute.getValue());
			}
		}
		return params;
	}
}
