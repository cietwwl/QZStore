package com.ks.protocol.proxy;
public final class ArenaLoggerVOProxy extends com.ks.protocol.vo.arena.ArenaLoggerVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getId());
		channelBuff.writeInt(getUserId());
		writeString(channelBuff,getUserName());
		writeString(channelBuff,getMatchUserName());
		channelBuff.writeInt(getMatchLevel());
		channelBuff.writeInt(getMatchUserId());
		channelBuff.writeInt(getWinLos());
		channelBuff.writeInt(getCapId());
		channelBuff.writeLong(getCreateTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setId(channelBuff.readInt());
		setUserId(channelBuff.readInt());
		setUserName(readString(channelBuff));
		setMatchUserName(readString(channelBuff));
		setMatchLevel(channelBuff.readInt());
		setMatchUserId(channelBuff.readInt());
		setWinLos(channelBuff.readInt());
		setCapId(channelBuff.readInt());
		setCreateTime(channelBuff.readLong());
	}
	public Object copy(){return new ArenaLoggerVOProxy();}
}