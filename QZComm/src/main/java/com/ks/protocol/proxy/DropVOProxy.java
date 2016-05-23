package com.ks.protocol.proxy;
public final class DropVOProxy extends com.ks.protocol.vo.fight.DropVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getAssId());
		channelBuff.writeInt(getNum());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setType(channelBuff.readInt());
		setAssId(channelBuff.readInt());
		setNum(channelBuff.readInt());
	}
	public Object copy(){return new DropVOProxy();}
}