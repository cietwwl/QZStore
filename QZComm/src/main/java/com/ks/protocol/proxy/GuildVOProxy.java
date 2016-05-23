package com.ks.protocol.proxy;
public final class GuildVOProxy extends com.ks.protocol.vo.guild.GuildVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getGuildId());
		writeString(channelBuff,getName());
		channelBuff.writeInt(getMemberNum());
		channelBuff.writeInt(getExp());
		channelBuff.writeInt(getSkillPoint());
		channelBuff.writeInt(getRank());
		channelBuff.writeInt(getState());
		writeObject(channelBuff,getCdrBaseInfo());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setGuildId(channelBuff.readInt());
		setName(readString(channelBuff));
		setMemberNum(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setSkillPoint(channelBuff.readInt());
		setRank(channelBuff.readInt());
		setState(channelBuff.readInt());
		setCdrBaseInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
	}
	public Object copy(){return new GuildVOProxy();}
}