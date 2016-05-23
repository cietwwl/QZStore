package com.ks.protocol.proxy;
public final class MallGoodsVOProxy extends com.ks.protocol.vo.mall.MallGoodsVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getMallId());
		channelBuff.writeInt(getGoodsId());
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getNum());
		channelBuff.writeInt(getLevel());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setMallId(channelBuff.readInt());
		setGoodsId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setNum(channelBuff.readInt());
		setLevel(channelBuff.readInt());
	}
	public Object copy(){return new MallGoodsVOProxy();}
}