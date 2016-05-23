package com.ks.protocol.proxy;
public final class UserTaskInfoVOProxy extends com.ks.protocol.vo.task.UserTaskInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeString(channelBuff,getTaskType());
		if(getCurrentTask()==null){
			setCurrentTask(new java.util.ArrayList<com.ks.protocol.vo.task.TaskNodeVO>());
		}		channelBuff.writeShort(getCurrentTask().size());
		for(com.ks.protocol.vo.task.TaskNodeVO p1000 : getCurrentTask()){
			writeObject(channelBuff,p1000);
		}
		if(getFinishedTaskIds()==null){
			setFinishedTaskIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getFinishedTaskIds().size());
		for(java.lang.Integer p2000 : getFinishedTaskIds()){
			channelBuff.writeInt(p2000);
		}
		if(getRewardedTaskIds()==null){
			setRewardedTaskIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getRewardedTaskIds().size());
		for(java.lang.Integer p3000 : getRewardedTaskIds()){
			channelBuff.writeInt(p3000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setTaskType(readString(channelBuff));
		setCurrentTask(new java.util.ArrayList<com.ks.protocol.vo.task.TaskNodeVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getCurrentTask().add(readObject(channelBuff,com.ks.protocol.vo.task.TaskNodeVO.class));
		}
		setFinishedTaskIds(new java.util.ArrayList<java.lang.Integer>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getFinishedTaskIds().add(channelBuff.readInt());
		}
		setRewardedTaskIds(new java.util.ArrayList<java.lang.Integer>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getRewardedTaskIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new UserTaskInfoVOProxy();}
}