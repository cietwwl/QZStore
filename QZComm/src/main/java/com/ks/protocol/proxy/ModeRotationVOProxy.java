package com.ks.protocol.proxy;
public final class ModeRotationVOProxy extends com.ks.protocol.vo.fight.ModeRotationVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		channelBuff.writeInt(getModeId());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setModeId(channelBuff.readInt());
	}
	public Object copy(){return new ModeRotationVOProxy();}
}