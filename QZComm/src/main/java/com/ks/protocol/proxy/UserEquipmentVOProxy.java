package com.ks.protocol.proxy;
public final class UserEquipmentVOProxy extends com.ks.protocol.vo.equment.UserEquipmentVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserEquipmentId());
		channelBuff.writeInt(getEquipmentId());
		channelBuff.writeInt(getLevel());
		channelBuff.writeInt(getUserHeroId());
		if(getSkills()==null){
			setSkills(new java.util.ArrayList<com.ks.protocol.vo.equment.EquipmentSkillVO>());
		}		channelBuff.writeShort(getSkills().size());
		for(com.ks.protocol.vo.equment.EquipmentSkillVO p1000 : getSkills()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeDouble(getAddAtk());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserEquipmentId(channelBuff.readInt());
		setEquipmentId(channelBuff.readInt());
		setLevel(channelBuff.readInt());
		setUserHeroId(channelBuff.readInt());
		setSkills(new java.util.ArrayList<com.ks.protocol.vo.equment.EquipmentSkillVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getSkills().add(readObject(channelBuff,com.ks.protocol.vo.equment.EquipmentSkillVO.class));
		}
		setAddAtk(channelBuff.readDouble());
	}
	public Object copy(){return new UserEquipmentVOProxy();}
}