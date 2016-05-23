package com.ks.game.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.ks.app.Application;
import com.ks.exceptions.GameException;
import com.ks.game.model.Player;
import com.ks.handler.GameHandler;
import com.ks.manager.PlayerManager;
import com.ks.protocol.MainCmd;
import com.ks.protocol.SubCmd;
import com.ks.protocol.main.MainCMD;
import com.ks.protocol.sub.ChatCMD;
import com.ks.protocol.vo.chat.ChatMessageVO;

/**
 * 聊天
 * */
@MainCmd(mainCmd=MainCMD.CHAT)
public class ChatHandler extends ActionAdapter{
	
	/**
	 * 聊天
	 * @param handler
	 * @param chatMessage
	 */
	@SubCmd(subCmd=ChatCMD.CHAT,args={"chatMessage"})
	public void chat(GameHandler handler,ChatMessageVO chatMessage){
		worldChatAction().chat(handler.getPlayer().getUserId(), handler.getHead(), chatMessage);
	}
	
	/**
	 * 加入聊天频道
	 * @param channelId
	 * @param channel
	 */
	@SubCmd(subCmd=ChatCMD.JOIN_CHAT_CHANNEL,args={"int"})
	public static void joinChatChannel(GameHandler handler,int channelId){
		Player player = handler.getPlayer();
		if(channelId==0){
			throw new GameException(GameException.CODE_参数错误, "channel id : 0");
		}
		player.setChatChannelId(channelId);
		PlayerManager.joinChatChannel(player.getChatChannelId(), handler.getChannel());
		
		Queue<ChatMessageVO> messages = worldChatAction().gainChatMessages();
		List<ChatMessageVO> ms = new ArrayList<>();
		for(ChatMessageVO m : messages){
			ms.add(m);
		}
		Application.sendMessage(handler.getChannel(), handler.getHead(),ms);
	}
	/**
	 * 离开聊天频道
	 * @param channelId
	 * @param channel
	 */
	@SubCmd(subCmd=ChatCMD.LEAVE_CHAT_CHANNEL)
	public static void leaveChatChannel(GameHandler handler){
		Player player = handler.getPlayer();
		if(player.getChatChannelId()==0){
			throw new GameException(GameException.CODE_参数错误, "channel id : 0");
		}
		PlayerManager.leaveChatChannel(player.getChatChannelId(), handler.getChannel());
		
		Application.sendMessage(handler.getChannel(), handler.getHead());
	}
	
	/**
	 * 战斗聊天
	 * @param channelId
	 * @param channel
	 */
	@SubCmd(subCmd=ChatCMD.FIGHT_CHAT, args={"chatMessage"})
	public static void fightChat(GameHandler handler, ChatMessageVO chatMessage){
		Player player = handler.getPlayer();
		worldChatAction().chat(player.getUserId(), handler.getHead(), chatMessage);
	}
	
}
