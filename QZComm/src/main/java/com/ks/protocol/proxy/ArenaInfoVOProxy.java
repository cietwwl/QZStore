package com.ks.protocol.proxy;
public final class ArenaInfoVOProxy extends com.ks.protocol.vo.arena.ArenaInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getMyArena());
		if(getRivals()==null){
			setRivals(new java.util.ArrayList<com.ks.protocol.vo.user.UserBaseinfoVO>());
		}		channelBuff.writeShort(getRivals().size());
		for(com.ks.protocol.vo.user.UserBaseinfoVO p1000 : getRivals()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeLong(getRivalRefTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setMyArena(readObject(channelBuff,com.ks.protocol.vo.arena.ArenaVO.class));
		setRivals(new java.util.ArrayList<com.ks.protocol.vo.user.UserBaseinfoVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getRivals().add(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
		}
		setRivalRefTime(channelBuff.readLong());
	}
	public Object copy(){return new ArenaInfoVOProxy();}
}