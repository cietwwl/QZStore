package com.ks.protocol.proxy;
public final class MartialWayUserVOProxy extends com.ks.protocol.vo.martial.MartialWayUserVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getBaseInfo());
		channelBuff.writeInt(getRank());
		channelBuff.writeInt(getFightingCapacity());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setBaseInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
		setRank(channelBuff.readInt());
		setFightingCapacity(channelBuff.readInt());
	}
	public Object copy(){return new MartialWayUserVOProxy();}
}