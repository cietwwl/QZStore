package com.ks.protocol.proxy;
public final class UserBuffVOProxy extends com.ks.protocol.vo.user.UserBuffVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getEffectId());
		channelBuff.writeInt(getVal());
		channelBuff.writeInt(getCd());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setEffectId(channelBuff.readInt());
		setVal(channelBuff.readInt());
		setCd(channelBuff.readInt());
	}
	public Object copy(){return new UserBuffVOProxy();}
}