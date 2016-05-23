package com.ks.action.world;

import java.util.Queue;
import com.ks.protocol.vo.Head;
import com.ks.protocol.vo.chat.ChatMessageVO;

public interface WorldChatAction {

	/**
	 * 发送聊天信息
	 * @param sendUserId
	 * @param head
	 * @param chatMessage
	 * @param targetIds 消息发送目标人群(世界聊天 和 私聊可以不用)
	 */
	void chat(int sendUserId, Head head,ChatMessageVO chatMessage, int ... targetIds);
	/**
	 * 获得聊天信息
	 * @return
	 */
	Queue<ChatMessageVO> gainChatMessages();
	
	/**
	 * 玩家禁言
	 * @param banTime
	 */
	void banChat(int userId, int banTime);
}
