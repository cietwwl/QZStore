package com.ks.object;

import lombok.Data;

@Data
public class ChatMsg{
	/**聊天类型(1世界)*/
	private int type;
	/**消息*/
	private String content;
	/**发送者id*/
	private int senderId;
	/**发送者名称*/
	private String sender;
	/**发送者等级*/
	private int senderLv;
	/**发送者vip*/
	private int senderVip;
	/**发送者时间*/
	private int senderTime;
}
