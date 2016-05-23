package com.ks.protocol.proxy;
public final class MoveVOProxy extends com.ks.protocol.vo.fight.MoveVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		writeObject(channelBuff,getPoint());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setPoint(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
	}
	public Object copy(){return new MoveVOProxy();}
}