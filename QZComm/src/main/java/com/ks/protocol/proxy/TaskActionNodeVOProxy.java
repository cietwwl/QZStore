package com.ks.protocol.proxy;
public final class TaskActionNodeVOProxy extends com.ks.protocol.vo.task.TaskActionNodeVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getTaskActionId());
		channelBuff.writeInt(getCurValue());
		channelBuff.writeInt(getGoalValue());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setTaskActionId(channelBuff.readInt());
		setCurValue(channelBuff.readInt());
		setGoalValue(channelBuff.readInt());
	}
	public Object copy(){return new TaskActionNodeVOProxy();}
}