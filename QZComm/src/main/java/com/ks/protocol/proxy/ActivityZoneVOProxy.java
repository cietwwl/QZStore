package com.ks.protocol.proxy;
public final class ActivityZoneVOProxy extends com.ks.protocol.vo.zone.ActivityZoneVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getZoneId());
		channelBuff.writeInt(getType());
		channelBuff.writeLong(getStartTime());
		channelBuff.writeLong(getEndTime());
		channelBuff.writeInt(getNum());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setZoneId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setStartTime(channelBuff.readLong());
		setEndTime(channelBuff.readLong());
		setNum(channelBuff.readInt());
	}
	public Object copy(){return new ActivityZoneVOProxy();}
}