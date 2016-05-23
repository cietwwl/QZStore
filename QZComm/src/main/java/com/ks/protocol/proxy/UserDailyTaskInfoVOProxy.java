package com.ks.protocol.proxy;
public final class UserDailyTaskInfoVOProxy extends com.ks.protocol.vo.task.UserDailyTaskInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getActiveValue());
		if(getRewardedBox()==null){
			setRewardedBox(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getRewardedBox().size());
		for(java.lang.Integer p1000 : getRewardedBox()){
			channelBuff.writeInt(p1000);
		}
		writeObject(channelBuff,getUserTaskInfoVO());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setActiveValue(channelBuff.readInt());
		setRewardedBox(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getRewardedBox().add(channelBuff.readInt());
		}
		setUserTaskInfoVO(readObject(channelBuff,com.ks.protocol.vo.task.UserTaskInfoVO.class));
	}
	public Object copy(){return new UserDailyTaskInfoVOProxy();}
}