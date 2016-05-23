package com.ks.protocol.proxy;
public final class UserPropVOProxy extends com.ks.protocol.vo.prop.UserPropVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getId());
		channelBuff.writeInt(getPropId());
		channelBuff.writeInt(getNum());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setId(channelBuff.readInt());
		setPropId(channelBuff.readInt());
		setNum(channelBuff.readInt());
	}
	public Object copy(){return new UserPropVOProxy();}
}