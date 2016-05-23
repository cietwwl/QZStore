package com.ks.protocol.proxy;
public final class UserAchieveVOProxy extends com.ks.protocol.vo.achieve.UserAchieveVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getAchieveId());
		channelBuff.writeInt(getNum());
		channelBuff.writeInt(getState());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setAchieveId(channelBuff.readInt());
		setNum(channelBuff.readInt());
		setState(channelBuff.readInt());
	}
	public Object copy(){return new UserAchieveVOProxy();}
}