package com.ks.protocol.proxy;
public final class EaternalSkillVOProxy extends com.ks.protocol.vo.eternal.EaternalSkillVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getEnternalSkillId());
		channelBuff.writeDouble(getSkillValue());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setEnternalSkillId(channelBuff.readInt());
		setSkillValue(channelBuff.readDouble());
	}
	public Object copy(){return new EaternalSkillVOProxy();}
}