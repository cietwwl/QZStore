package com.ks.protocol.proxy;
public final class UserRecordVOProxy extends com.ks.protocol.vo.user.UserRecordVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getFirstRechangeIds()==null){
			setFirstRechangeIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getFirstRechangeIds().size());
		for(java.lang.Integer p1000 : getFirstRechangeIds()){
			channelBuff.writeInt(p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFirstRechangeIds(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getFirstRechangeIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new UserRecordVOProxy();}
}