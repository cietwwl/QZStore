package com.ks.protocol.vo.chat;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 聊天消息
 * @author ks
 */
public class ChatMessageVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="聊天频道编号(如果是私聊则表示玩家编号)")
	private int assId;
	@FieldDesc(desc="消息")
	private String message;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
