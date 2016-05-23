package com.ks.protocol.proxy;
public final class PointVOProxy extends com.ks.protocol.vo.fight.PointVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getX());
		channelBuff.writeInt(getY());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setX(channelBuff.readInt());
		setY(channelBuff.readInt());
	}
	public Object copy(){return new PointVOProxy();}
}