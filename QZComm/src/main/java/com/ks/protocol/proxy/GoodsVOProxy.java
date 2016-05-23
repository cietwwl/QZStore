package com.ks.protocol.proxy;
public final class GoodsVOProxy extends com.ks.protocol.vo.goods.GoodsVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getGoodsId());
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getNum());
		channelBuff.writeInt(getLevel());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setGoodsId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setNum(channelBuff.readInt());
		setLevel(channelBuff.readInt());
	}
	public Object copy(){return new GoodsVOProxy();}
}