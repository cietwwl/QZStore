package com.ks.protocol.proxy;
public final class SellPropVOProxy extends com.ks.protocol.vo.prop.SellPropVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getPropId());
		channelBuff.writeInt(getNum());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setPropId(channelBuff.readInt());
		setNum(channelBuff.readInt());
	}
	public Object copy(){return new SellPropVOProxy();}
}