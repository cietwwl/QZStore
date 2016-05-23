package com.ks.protocol.proxy;
public final class GainGameAwardVOProxy extends com.ks.protocol.vo.goods.GainGameAwardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getGoodses()==null){
			setGoodses(new java.util.ArrayList<com.ks.protocol.vo.goods.GoodsVO>());
		}		channelBuff.writeShort(getGoodses().size());
		for(com.ks.protocol.vo.goods.GoodsVO p1000 : getGoodses()){
			writeObject(channelBuff,p1000);
		}
		writeObject(channelBuff,getAwards());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setGoodses(new java.util.ArrayList<com.ks.protocol.vo.goods.GoodsVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getGoodses().add(readObject(channelBuff,com.ks.protocol.vo.goods.GoodsVO.class));
		}
		setAwards(readObject(channelBuff,com.ks.protocol.vo.goods.GainAwardVO.class));
	}
	public Object copy(){return new GainGameAwardVOProxy();}
}