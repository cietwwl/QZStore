package com.ks.protocol.proxy;
public final class TaskNodeVOProxy extends com.ks.protocol.vo.task.TaskNodeVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getTaskId());
		if(getActionNodes()==null){
			setActionNodes(new java.util.ArrayList<com.ks.protocol.vo.task.TaskActionNodeVO>());
		}		channelBuff.writeShort(getActionNodes().size());
		for(com.ks.protocol.vo.task.TaskActionNodeVO p1000 : getActionNodes()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setTaskId(channelBuff.readInt());
		setActionNodes(new java.util.ArrayList<com.ks.protocol.vo.task.TaskActionNodeVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getActionNodes().add(readObject(channelBuff,com.ks.protocol.vo.task.TaskActionNodeVO.class));
		}
	}
	public Object copy(){return new TaskNodeVOProxy();}
}