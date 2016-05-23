package com.ks.protocol.proxy;
public final class PayBillVOProxy extends com.ks.protocol.vo.mall.PayBillVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeString(channelBuff,getBill());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setBill(readString(channelBuff));
	}
	public Object copy(){return new PayBillVOProxy();}
}