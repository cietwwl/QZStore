package com.ks.protocol.proxy;
public final class FriendRecoVOProxy extends com.ks.protocol.vo.friend.FriendRecoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getRecoFriends()==null){
			setRecoFriends(new java.util.ArrayList<com.ks.protocol.vo.user.UserBaseinfoVO>());
		}		channelBuff.writeShort(getRecoFriends().size());
		for(com.ks.protocol.vo.user.UserBaseinfoVO p1000 : getRecoFriends()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeLong(getUpdateTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setRecoFriends(new java.util.ArrayList<com.ks.protocol.vo.user.UserBaseinfoVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getRecoFriends().add(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
		}
		setUpdateTime(channelBuff.readLong());
	}
	public Object copy(){return new FriendRecoVOProxy();}
}