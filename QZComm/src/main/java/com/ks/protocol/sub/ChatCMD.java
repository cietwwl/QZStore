package com.ks.protocol.sub;

public interface ChatCMD {
	
	/**
	 * 聊天
	 */
	short CHAT = 1;
	
	/**
	 * 加入聊天频道
	 */
	short JOIN_CHAT_CHANNEL = 2;
	
	/**
	 * 离开聊天频道
	 */
	short LEAVE_CHAT_CHANNEL = 3;
	
	/**
	 * 战斗聊天
	 */
	short FIGHT_CHAT = 4;
	
}
