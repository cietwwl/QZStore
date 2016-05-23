package com.ks.protocol.proxy;
public final class UserBaseinfoVOProxy extends com.ks.protocol.vo.user.UserBaseinfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserId());
		channelBuff.writeInt(getLevel());
		writeString(channelBuff,getPlayerName());
		channelBuff.writeInt(getHeroId());
		channelBuff.writeInt(getTodayWins());
		channelBuff.writeInt(getTodayMaxWins());
		channelBuff.writeInt(getFighting());
		channelBuff.writeInt(getStreakWin());
		channelBuff.writeInt(getChargeDiamond());
		channelBuff.writeByte(isOnline()?(byte)1:(byte)0);
		writeString(channelBuff,getGuildName());
		channelBuff.writeInt(getVip());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserId(channelBuff.readInt());
		setLevel(channelBuff.readInt());
		setPlayerName(readString(channelBuff));
		setHeroId(channelBuff.readInt());
		setTodayWins(channelBuff.readInt());
		setTodayMaxWins(channelBuff.readInt());
		setFighting(channelBuff.readInt());
		setStreakWin(channelBuff.readInt());
		setChargeDiamond(channelBuff.readInt());
		setOnline(channelBuff.readByte()==1);
		setGuildName(readString(channelBuff));
		setVip(channelBuff.readInt());
	}
	public Object copy(){return new UserBaseinfoVOProxy();}
}