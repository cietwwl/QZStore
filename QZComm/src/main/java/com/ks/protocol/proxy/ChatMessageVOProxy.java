package com.ks.protocol.proxy;
public final class ChatMessageVOProxy extends com.ks.protocol.vo.chat.ChatMessageVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getAssId());
		writeString(channelBuff,getMessage());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setType(channelBuff.readInt());
		setAssId(channelBuff.readInt());
		setMessage(readString(channelBuff));
	}
	public Object copy(){return new ChatMessageVOProxy();}
}