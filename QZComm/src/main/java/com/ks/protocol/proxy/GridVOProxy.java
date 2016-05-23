package com.ks.protocol.proxy;
public final class GridVOProxy extends com.ks.protocol.vo.fight.GridVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getCoor());
		channelBuff.writeInt(getGridItem());
		channelBuff.writeInt(getFightId());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setCoor(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
		setGridItem(channelBuff.readInt());
		setFightId(channelBuff.readInt());
	}
	public Object copy(){return new GridVOProxy();}
}