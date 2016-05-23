package com.ks.protocol.proxy;
public final class DailyTaskRewardVOProxy extends com.ks.protocol.vo.task.DailyTaskRewardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getDailyTaskInfoVO());
		writeObject(channelBuff,getGainAwardVO());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setDailyTaskInfoVO(readObject(channelBuff,com.ks.protocol.vo.task.UserDailyTaskInfoVO.class));
		setGainAwardVO(readObject(channelBuff,com.ks.protocol.vo.goods.GainAwardVO.class));
	}
	public Object copy(){return new DailyTaskRewardVOProxy();}
}