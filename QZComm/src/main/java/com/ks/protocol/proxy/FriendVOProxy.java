package com.ks.protocol.proxy;
public final class FriendVOProxy extends com.ks.protocol.vo.friend.FriendVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getState());
		channelBuff.writeInt(getUseCount());
		channelBuff.writeInt(getFriendlyDegrees());
		channelBuff.writeLong(getLastRefTime());
		writeObject(channelBuff,getInfo());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setState(channelBuff.readInt());
		setUseCount(channelBuff.readInt());
		setFriendlyDegrees(channelBuff.readInt());
		setLastRefTime(channelBuff.readLong());
		setInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
	}
	public Object copy(){return new FriendVOProxy();}
}