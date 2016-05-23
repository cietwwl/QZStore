package com.ks.protocol.proxy;
public final class GuildApplyVOProxy extends com.ks.protocol.vo.guild.GuildApplyVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getGuildId());
		writeObject(channelBuff,getBaseinfo());
		channelBuff.writeLong(getCreateTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setGuildId(channelBuff.readInt());
		setBaseinfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
		setCreateTime(channelBuff.readLong());
	}
	public Object copy(){return new GuildApplyVOProxy();}
}