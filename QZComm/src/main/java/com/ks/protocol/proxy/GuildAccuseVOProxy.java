package com.ks.protocol.proxy;
public final class GuildAccuseVOProxy extends com.ks.protocol.vo.guild.GuildAccuseVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getOriginator());
		writeString(channelBuff,getPlayerName());
		if(getResper()==null){
			setResper(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getResper().size());
		for(java.lang.Integer p1000 : getResper()){
			channelBuff.writeInt(p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setOriginator(channelBuff.readInt());
		setPlayerName(readString(channelBuff));
		setResper(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getResper().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new GuildAccuseVOProxy();}
}