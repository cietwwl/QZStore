package com.ks.protocol.proxy;
public final class GuildSkillVOProxy extends com.ks.protocol.vo.guild.GuildSkillVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getSkillId());
		channelBuff.writeInt(getGp());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setSkillId(channelBuff.readInt());
		setGp(channelBuff.readInt());
	}
	public Object copy(){return new GuildSkillVOProxy();}
}