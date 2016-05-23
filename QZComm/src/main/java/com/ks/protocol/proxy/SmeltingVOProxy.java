package com.ks.protocol.proxy;
public final class SmeltingVOProxy extends com.ks.protocol.vo.prop.SmeltingVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getGainPoint());
		writeObject(channelBuff,getEs());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setType(channelBuff.readInt());
		setGainPoint(channelBuff.readInt());
		setEs(readObject(channelBuff,com.ks.protocol.vo.prop.EternalSmeltingVO.class));
	}
	public Object copy(){return new SmeltingVOProxy();}
}