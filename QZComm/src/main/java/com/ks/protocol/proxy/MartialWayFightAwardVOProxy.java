package com.ks.protocol.proxy;
public final class MartialWayFightAwardVOProxy extends com.ks.protocol.vo.martial.MartialWayFightAwardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getScore());
		channelBuff.writeByte(isFirstWin()?(byte)1:(byte)0);
		channelBuff.writeInt(getExp());
		channelBuff.writeByte(isWin()?(byte)1:(byte)0);
		channelBuff.writeInt(getWinStreak());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setScore(channelBuff.readInt());
		setFirstWin(channelBuff.readByte()==1);
		setExp(channelBuff.readInt());
		setWin(channelBuff.readByte()==1);
		setWinStreak(channelBuff.readInt());
	}
	public Object copy(){return new MartialWayFightAwardVOProxy();}
}