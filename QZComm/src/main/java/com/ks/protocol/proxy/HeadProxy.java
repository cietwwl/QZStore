package com.ks.protocol.proxy;
public final class HeadProxy extends com.ks.protocol.vo.Head{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeShort(getLength());
		channelBuff.writeShort(getMainCmd());
		channelBuff.writeShort(getSubCmd());
		writeString(channelBuff,getSessionId());
		channelBuff.writeShort(getCheckVal());
		channelBuff.writeByte(isCompressed()?(byte)1:(byte)0);
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setLength(channelBuff.readShort());
		setMainCmd(channelBuff.readShort());
		setSubCmd(channelBuff.readShort());
		setSessionId(readString(channelBuff));
		setCheckVal(channelBuff.readShort());
		setCompressed(channelBuff.readByte()==1);
	}
	public Object copy(){return new HeadProxy();}
}