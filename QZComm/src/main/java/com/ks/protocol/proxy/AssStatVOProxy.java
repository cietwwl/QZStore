package com.ks.protocol.proxy;
public final class AssStatVOProxy extends com.ks.protocol.vo.mall.AssStatVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getAssId());
		channelBuff.writeInt(getNum());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setAssId(channelBuff.readInt());
		setNum(channelBuff.readInt());
	}
	public Object copy(){return new AssStatVOProxy();}
}