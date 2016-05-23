package com.ks.protocol.proxy;
public final class MailVOProxy extends com.ks.protocol.vo.mail.MailVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getMailId());
		channelBuff.writeInt(getType());
		writeString(channelBuff,getTitle());
		writeString(channelBuff,getContext());
		channelBuff.writeInt(getState());
		if(getGoodses()==null){
			setGoodses(new java.util.ArrayList<com.ks.protocol.vo.goods.GoodsVO>());
		}		channelBuff.writeShort(getGoodses().size());
		for(com.ks.protocol.vo.goods.GoodsVO p1000 : getGoodses()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeLong(getCreateTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setMailId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setTitle(readString(channelBuff));
		setContext(readString(channelBuff));
		setState(channelBuff.readInt());
		setGoodses(new java.util.ArrayList<com.ks.protocol.vo.goods.GoodsVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getGoodses().add(readObject(channelBuff,com.ks.protocol.vo.goods.GoodsVO.class));
		}
		setCreateTime(channelBuff.readLong());
	}
	public Object copy(){return new MailVOProxy();}
}