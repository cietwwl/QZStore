package com.ks.protocol.proxy;
public final class MallVOProxy extends com.ks.protocol.vo.mall.MallVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getId());
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getVip());
		channelBuff.writeInt(getState());
		channelBuff.writeInt(getMoneyType());
		channelBuff.writeInt(getOriginalMoney());
		channelBuff.writeInt(getMoney());
		channelBuff.writeInt(getBuyCount());
		channelBuff.writeLong(getShelvesTime());
		if(getGoods()==null){
			setGoods(new java.util.ArrayList<com.ks.protocol.vo.mall.MallGoodsVO>());
		}		channelBuff.writeShort(getGoods().size());
		for(com.ks.protocol.vo.mall.MallGoodsVO p1000 : getGoods()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeInt(getToleCount());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setVip(channelBuff.readInt());
		setState(channelBuff.readInt());
		setMoneyType(channelBuff.readInt());
		setOriginalMoney(channelBuff.readInt());
		setMoney(channelBuff.readInt());
		setBuyCount(channelBuff.readInt());
		setShelvesTime(channelBuff.readLong());
		setGoods(new java.util.ArrayList<com.ks.protocol.vo.mall.MallGoodsVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getGoods().add(readObject(channelBuff,com.ks.protocol.vo.mall.MallGoodsVO.class));
		}
		setToleCount(channelBuff.readInt());
	}
	public Object copy(){return new MallVOProxy();}
}