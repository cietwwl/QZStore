package com.ks.protocol.proxy;
public final class EternalSmeltingVOProxy extends com.ks.protocol.vo.prop.EternalSmeltingVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getVal());
		channelBuff.writeInt(getAddEternalVal());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setType(channelBuff.readInt());
		setVal(channelBuff.readInt());
		setAddEternalVal(channelBuff.readInt());
	}
	public Object copy(){return new EternalSmeltingVOProxy();}
}