package com.ks.protocol.proxy;
public final class FightBuffVOProxy extends com.ks.protocol.vo.fight.skill.FightBuffVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getId());
		channelBuff.writeInt(getEffectId());
		channelBuff.writeInt(getScore());
		channelBuff.writeInt(getCons());
		channelBuff.writeInt(getRound());
		channelBuff.writeInt(getState());
		writeString(channelBuff,getUuid());
		channelBuff.writeInt(getShotUserId());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setId(channelBuff.readInt());
		setEffectId(channelBuff.readInt());
		setScore(channelBuff.readInt());
		setCons(channelBuff.readInt());
		setRound(channelBuff.readInt());
		setState(channelBuff.readInt());
		setUuid(readString(channelBuff));
		setShotUserId(channelBuff.readInt());
	}
	public Object copy(){return new FightBuffVOProxy();}
}