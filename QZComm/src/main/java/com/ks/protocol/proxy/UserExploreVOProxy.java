package com.ks.protocol.proxy;
public final class UserExploreVOProxy extends com.ks.protocol.vo.hero.UserExploreVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getExploreId());
		channelBuff.writeInt(getUserHeroId());
		channelBuff.writeInt(getExploreType());
		channelBuff.writeInt(getState());
		channelBuff.writeLong(getEndTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setExploreId(channelBuff.readInt());
		setUserHeroId(channelBuff.readInt());
		setExploreType(channelBuff.readInt());
		setState(channelBuff.readInt());
		setEndTime(channelBuff.readLong());
	}
	public Object copy(){return new UserExploreVOProxy();}
}