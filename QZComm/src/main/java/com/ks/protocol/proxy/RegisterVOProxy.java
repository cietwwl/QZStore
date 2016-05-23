package com.ks.protocol.proxy;
public final class RegisterVOProxy extends com.ks.protocol.vo.login.RegisterVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeString(channelBuff,getUsername());
		channelBuff.writeInt(getPartner());
		writeString(channelBuff,getPlayerName());
		channelBuff.writeInt(getInitHeroId());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUsername(readString(channelBuff));
		setPartner(channelBuff.readInt());
		setPlayerName(readString(channelBuff));
		setInitHeroId(channelBuff.readInt());
	}
	public Object copy(){return new RegisterVOProxy();}
}