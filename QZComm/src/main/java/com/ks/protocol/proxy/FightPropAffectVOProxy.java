package com.ks.protocol.proxy;
public final class FightPropAffectVOProxy extends com.ks.protocol.vo.fight.prop.FightPropAffectVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightPropId());
		channelBuff.writeInt(getFightId());
		channelBuff.writeInt(getValue());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightPropId(channelBuff.readInt());
		setFightId(channelBuff.readInt());
		setValue(channelBuff.readInt());
	}
	public Object copy(){return new FightPropAffectVOProxy();}
}