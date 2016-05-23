package com.ks.protocol.proxy;
public final class BlackMarketGoodsVOProxy extends com.ks.protocol.vo.mall.BlackMarketGoodsVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeByte(isBuy()?(byte)1:(byte)0);
		writeObject(channelBuff,getGoods());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setBuy(channelBuff.readByte()==1);
		setGoods(readObject(channelBuff,com.ks.protocol.vo.mall.MallGoodsVO.class));
	}
	public Object copy(){return new BlackMarketGoodsVOProxy();}
}