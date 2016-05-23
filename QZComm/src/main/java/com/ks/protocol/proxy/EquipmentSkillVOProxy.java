package com.ks.protocol.proxy;
public final class EquipmentSkillVOProxy extends com.ks.protocol.vo.equment.EquipmentSkillVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getEquipmentSkillId());
		channelBuff.writeDouble(getSkillValue());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setEquipmentSkillId(channelBuff.readInt());
		setSkillValue(channelBuff.readDouble());
	}
	public Object copy(){return new EquipmentSkillVOProxy();}
}