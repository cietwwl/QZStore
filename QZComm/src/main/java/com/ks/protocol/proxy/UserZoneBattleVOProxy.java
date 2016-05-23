package com.ks.protocol.proxy;
public final class UserZoneBattleVOProxy extends com.ks.protocol.vo.zone.UserZoneBattleVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getZoneId());
		channelBuff.writeInt(getZoneBattleId());
		channelBuff.writeInt(getChallengeCount());
		channelBuff.writeInt(getPassCount());
		channelBuff.writeInt(getStar());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setZoneId(channelBuff.readInt());
		setZoneBattleId(channelBuff.readInt());
		setChallengeCount(channelBuff.readInt());
		setPassCount(channelBuff.readInt());
		setStar(channelBuff.readInt());
	}
	public Object copy(){return new UserZoneBattleVOProxy();}
}