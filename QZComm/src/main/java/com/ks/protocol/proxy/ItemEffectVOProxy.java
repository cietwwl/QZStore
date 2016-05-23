package com.ks.protocol.proxy;
public final class ItemEffectVOProxy extends com.ks.protocol.vo.reward.ItemEffectVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getId());
		channelBuff.writeInt(getValue1());
		channelBuff.writeInt(getValue2());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setType(channelBuff.readInt());
		setId(channelBuff.readInt());
		setValue1(channelBuff.readInt());
		setValue2(channelBuff.readInt());
	}
	public Object copy(){return new ItemEffectVOProxy();}
}