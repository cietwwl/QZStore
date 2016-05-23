package com.ks.protocol.proxy;
public final class FriendApplyVOProxy extends com.ks.protocol.vo.friend.FriendApplyVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeLong(getTime());
		writeObject(channelBuff,getInfos());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setTime(channelBuff.readLong());
		setInfos(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
	}
	public Object copy(){return new FriendApplyVOProxy();}
}