package com.ks.protocol.proxy;
public final class UserRenownTaskInfoVOProxy extends com.ks.protocol.vo.task.UserRenownTaskInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getUserTaskInfoVO());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserTaskInfoVO(readObject(channelBuff,com.ks.protocol.vo.task.UserTaskInfoVO.class));
	}
	public Object copy(){return new UserRenownTaskInfoVOProxy();}
}