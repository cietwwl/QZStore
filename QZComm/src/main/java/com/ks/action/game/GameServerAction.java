package com.ks.action.game;

import java.util.List;

import com.ks.protocol.vo.Head;
import com.ks.rpc.Async;
import com.ks.rpc.ServerInfo;
import com.ks.rpc.Timeout;

public interface GameServerAction{
	/**
	 * 增加数据库远程调用
	 * @param databaseServerInfos 数据库远程调用
	 * @throws Exception 
	 */
	@Timeout(time=20*1000L)
	void addLogicServerRPC(List<ServerInfo> logicServerInfos,String serverId) throws Exception;
	/**
	 * 增加数据库服务器远程调用
	 * @param dataInfoServerInfo 数据库服务器信息
	 * @throws Exception 
	 */
	@Timeout(time=20*1000L)
	void addLogicServerRPC(ServerInfo logicServerInfo) throws Exception;
	   
	/**
	 * 发送消息
	 * @param sessionId 会话编号
	 * @param head 消息头
	 * @param args 消息体
	 */
	@Async
	void sendMessage(String sessionId, Head head , Object ...args);
	
	
	/**
	 * 发送消息
	 * @param sessionIds 会话编号
	 * @param head 消息头
	 * @param args 消息体
	 */
	@Async
	void sendMessage(List<String> sessionIds, Head head , Object ...args);
	/**
	 * 发送聊天频道信息
	 * @param channelId
	 * @param head
	 * @param args
	 */
	@Async
	void sendChatChannelMessage(int channelId,Head head , Object ...args);
	
}