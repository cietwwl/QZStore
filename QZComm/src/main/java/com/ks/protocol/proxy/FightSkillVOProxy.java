package com.ks.protocol.proxy;
public final class FightSkillVOProxy extends com.ks.protocol.vo.fight.skill.FightSkillVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getSkillId());
		channelBuff.writeInt(getSkillLv());
		channelBuff.writeInt(getCurrRound());
		channelBuff.writeInt(getShotUserId());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setSkillId(channelBuff.readInt());
		setSkillLv(channelBuff.readInt());
		setCurrRound(channelBuff.readInt());
		setShotUserId(channelBuff.readInt());
	}
	public Object copy(){return new FightSkillVOProxy();}
}