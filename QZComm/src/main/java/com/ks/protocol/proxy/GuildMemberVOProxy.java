package com.ks.protocol.proxy;
public final class GuildMemberVOProxy extends com.ks.protocol.vo.guild.GuildMemberVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserId());
		channelBuff.writeInt(getGuildId());
		channelBuff.writeInt(getProperty());
		channelBuff.writeInt(getDevote());
		channelBuff.writeInt(getTodayDevote());
		writeObject(channelBuff,getInfo());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserId(channelBuff.readInt());
		setGuildId(channelBuff.readInt());
		setProperty(channelBuff.readInt());
		setDevote(channelBuff.readInt());
		setTodayDevote(channelBuff.readInt());
		setInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
	}
	public Object copy(){return new GuildMemberVOProxy();}
}