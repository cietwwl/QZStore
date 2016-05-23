package com.ks.protocol.proxy;
public final class ArenaVOProxy extends com.ks.protocol.vo.arena.ArenaVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserId());
		channelBuff.writeLong(getCdTime());
		if(getShopping()==null){
			setShopping(new java.util.ArrayList<com.ks.protocol.vo.arena.ArenaShoppingVO>());
		}		channelBuff.writeShort(getShopping().size());
		for(com.ks.protocol.vo.arena.ArenaShoppingVO p1000 : getShopping()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeInt(getValour());
		writeObject(channelBuff,getInfo());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserId(channelBuff.readInt());
		setCdTime(channelBuff.readLong());
		setShopping(new java.util.ArrayList<com.ks.protocol.vo.arena.ArenaShoppingVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getShopping().add(readObject(channelBuff,com.ks.protocol.vo.arena.ArenaShoppingVO.class));
		}
		setValour(channelBuff.readInt());
		setInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
	}
	public Object copy(){return new ArenaVOProxy();}
}