package com.ks.action.world;

import java.util.List;

import com.ks.protocol.vo.Head;
import com.ks.rpc.Async;
import com.ks.rpc.Timeout;


/**
 * 世界服务器处理
 * @author ks
 *
 */
public interface WorldServerAction{
	/**
	 * 游戏服务器连接
	 * @param host 游戏服务器外网地址
	 * @param port 游戏服务器外网端口
	 * @param rpcHost 游戏服务器远程调用地址
	 * @param rpcPort 游戏服务器远程调用端口
	 * @throws Exception 
	 */
	@Timeout(time=20*1000L)
	void gameServerConnected(String host,int port,String rpcHost,int rpcPort,String serverId) throws Exception;
	/**
	 * 数据库服务器连接
	 * @param host 数据库服务器地址
	 * @param port 数据库服务器端口
	 * @throws Exception 
	 */
	@Timeout(time=20*1000L)
	void logicServerConndeted(String host,int port,String serverId) throws Exception;
	
	/**
	 * 发送消息
	 * @param userId 用户id
	 * @param head 消息头
	 * @param args 消息体
	 */
	@Async
	void sendMessage(int userId , Head head , Object ...args);
	
	
	/**
	 * 发送消息
	 * @param userId 用户id
	 * @param head 消息头
	 * @param args 消息体
	 */
	@Async
	void sendMessage(List<Integer> userIds, Head head , Object ...args);
	
}