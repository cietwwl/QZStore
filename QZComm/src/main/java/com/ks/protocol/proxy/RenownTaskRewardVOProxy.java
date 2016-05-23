package com.ks.protocol.proxy;
public final class RenownTaskRewardVOProxy extends com.ks.protocol.vo.task.RenownTaskRewardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getRenownTaskInfoVO());
		writeObject(channelBuff,getGainAwardVO());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setRenownTaskInfoVO(readObject(channelBuff,com.ks.protocol.vo.task.UserRenownTaskInfoVO.class));
		setGainAwardVO(readObject(channelBuff,com.ks.protocol.vo.goods.GainAwardVO.class));
	}
	public Object copy(){return new RenownTaskRewardVOProxy();}
}