package com.ks.protocol.proxy;
public final class UserTeamVOProxy extends com.ks.protocol.vo.user.UserTeamVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getHeros()==null){
			setHeros(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getHeros().size());
		for(java.lang.Integer p1000 : getHeros()){
			channelBuff.writeInt(p1000);
		}
		if(getPos()==null){
			setPos(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getPos().size());
		for(java.lang.Integer p2000 : getPos()){
			channelBuff.writeInt(p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setHeros(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getHeros().add(channelBuff.readInt());
		}
		setPos(new java.util.ArrayList<java.lang.Integer>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getPos().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new UserTeamVOProxy();}
}