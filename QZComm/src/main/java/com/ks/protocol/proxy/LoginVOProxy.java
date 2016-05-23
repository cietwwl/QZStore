package com.ks.protocol.proxy;
public final class LoginVOProxy extends com.ks.protocol.vo.login.LoginVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeString(channelBuff,getUsername());
		channelBuff.writeInt(getPartner());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUsername(readString(channelBuff));
		setPartner(channelBuff.readInt());
	}
	public Object copy(){return new LoginVOProxy();}
}