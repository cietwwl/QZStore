package com.ks.protocol.proxy;
public final class UserEternalVOProxy extends com.ks.protocol.vo.eternal.UserEternalVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserEternalId());
		channelBuff.writeInt(getEternalId());
		channelBuff.writeByte(isUse()?(byte)1:(byte)0);
		if(getPropertySkills()==null){
			setPropertySkills(new java.util.ArrayList<com.ks.protocol.vo.eternal.EaternalSkillVO>());
		}		channelBuff.writeShort(getPropertySkills().size());
		for(com.ks.protocol.vo.eternal.EaternalSkillVO p1000 : getPropertySkills()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserEternalId(channelBuff.readInt());
		setEternalId(channelBuff.readInt());
		setUse(channelBuff.readByte()==1);
		setPropertySkills(new java.util.ArrayList<com.ks.protocol.vo.eternal.EaternalSkillVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getPropertySkills().add(readObject(channelBuff,com.ks.protocol.vo.eternal.EaternalSkillVO.class));
		}
	}
	public Object copy(){return new UserEternalVOProxy();}
}