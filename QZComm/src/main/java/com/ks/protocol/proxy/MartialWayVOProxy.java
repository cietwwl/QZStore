package com.ks.protocol.proxy;
public final class MartialWayVOProxy extends com.ks.protocol.vo.martial.MartialWayVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeShort(getScore());
		channelBuff.writeShort(getWinCount());
		channelBuff.writeShort(getWinStreak());
		channelBuff.writeInt(getRank());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setScore(channelBuff.readShort());
		setWinCount(channelBuff.readShort());
		setWinStreak(channelBuff.readShort());
		setRank(channelBuff.readInt());
	}
	public Object copy(){return new MartialWayVOProxy();}
}