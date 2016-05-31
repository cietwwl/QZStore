package com.ks.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;

import com.ks.constant.SystemConstant;
import com.ks.game.model.Player;

public class PlayerManager {
	
	/**在线玩家 key=sessionId*/
	private static Map<String,Player> onlinePlayers = new ConcurrentHashMap<>();
	/**聊天channel*/
	private static final Map<Integer,ChannelGroup> chatChannelGroup = new HashMap<Integer, ChannelGroup>();
	
	static{
		chatChannelGroup.put(SystemConstant.CHAT_CHANNEL_WORLD, new DefaultChannelGroup());
	}
	
	/**
	 * 增加在线玩家
	 * @param sessionId 会话编号
	 * @param player 玩家
	 */
	public static void addOnlinePlayer(String sessionId,Player player){
		player.setLock(new ReentrantLock());
		onlinePlayers.put(sessionId, player);
	}
	
	/**
	 * 获取在线玩家
	 * @param sessionId 会话编号
	 * @return 在线玩家
	 */
	public static Player getOnlinePlayer(String sessionId){
		return onlinePlayers.get(sessionId);
	}
	/**
	 * 删除在线玩家
	 * @param sessionId 会话编号
	 */
	public static void removeOnlinePlayer(String sessionId){
		onlinePlayers.remove(sessionId);
	}
	
	public static Map<String,Player> getAllOnlinePlayer(){
		return onlinePlayers;
	}
	/**
	 * 获得聊天频道
	 * @param channelId
	 * @return
	 */
	public static ChannelGroup getChatChannel(int channelId){
		return chatChannelGroup.get(channelId);
	}
	
	/**
	 * 加入聊天频道
	 * @param channelId
	 * @param channel
	 */
	public static void joinChatChannel(int channelId,Channel channel){
		chatChannelGroup.get(channelId).add(channel);
	}
	/**
	 * 离开聊天频道
	 * @param channelId
	 * @param channel
	 */
	public static void leaveChatChannel(int channelId,Channel channel){
		chatChannelGroup.get(channelId).remove(channel);
	}
	
	public static Collection<ChannelGroup> getChatChannels(){
		return chatChannelGroup.values();
	}
}
