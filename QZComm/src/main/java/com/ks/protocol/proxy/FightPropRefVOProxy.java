package com.ks.protocol.proxy;
public final class FightPropRefVOProxy extends com.ks.protocol.vo.fight.prop.FightPropRefVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getPropId());
		writeObject(channelBuff,getCoor());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setPropId(channelBuff.readInt());
		setCoor(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
	}
	public Object copy(){return new FightPropRefVOProxy();}
}