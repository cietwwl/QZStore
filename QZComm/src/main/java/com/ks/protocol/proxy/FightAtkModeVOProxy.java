package com.ks.protocol.proxy;
public final class FightAtkModeVOProxy extends com.ks.protocol.vo.fight.FightAtkModeVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getId());
		writeString(channelBuff,getAtkMode());
		writeString(channelBuff,getMoveModel());
		channelBuff.writeInt(getCd());
		channelBuff.writeInt(getRound());
		writeObject(channelBuff,getSkill());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setId(channelBuff.readInt());
		setAtkMode(readString(channelBuff));
		setMoveModel(readString(channelBuff));
		setCd(channelBuff.readInt());
		setRound(channelBuff.readInt());
		setSkill(readObject(channelBuff,com.ks.protocol.vo.fight.skill.FightSkillVO.class));
	}
	public Object copy(){return new FightAtkModeVOProxy();}
}