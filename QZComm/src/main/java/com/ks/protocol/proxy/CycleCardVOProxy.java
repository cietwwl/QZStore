package com.ks.protocol.proxy;
public final class CycleCardVOProxy extends com.ks.protocol.vo.user.CycleCardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getPayId());
		channelBuff.writeInt(getEndTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setPayId(channelBuff.readInt());
		setEndTime(channelBuff.readInt());
	}
	public Object copy(){return new CycleCardVOProxy();}
}