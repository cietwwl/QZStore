package com.ks.protocol.proxy;
public final class ArenaShoppingVOProxy extends com.ks.protocol.vo.arena.ArenaShoppingVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getShoppingId());
		channelBuff.writeInt(getGoodsId());
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getNum());
		channelBuff.writeInt(getMoney());
		channelBuff.writeInt(getLevel());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setShoppingId(channelBuff.readInt());
		setGoodsId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setNum(channelBuff.readInt());
		setMoney(channelBuff.readInt());
		setLevel(channelBuff.readInt());
	}
	public Object copy(){return new ArenaShoppingVOProxy();}
}