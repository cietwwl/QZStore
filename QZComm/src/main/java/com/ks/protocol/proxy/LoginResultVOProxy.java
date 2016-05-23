package com.ks.protocol.proxy;
public final class LoginResultVOProxy extends com.ks.protocol.vo.login.LoginResultVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserId());
		writeString(channelBuff,getPlayerName());
		writeString(channelBuff,getSessionId());
		writeString(channelBuff,getGameServerHost());
		channelBuff.writeInt(getGameServerPort());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserId(channelBuff.readInt());
		setPlayerName(readString(channelBuff));
		setSessionId(readString(channelBuff));
		setGameServerHost(readString(channelBuff));
		setGameServerPort(channelBuff.readInt());
	}
	public Object copy(){return new LoginResultVOProxy();}
}