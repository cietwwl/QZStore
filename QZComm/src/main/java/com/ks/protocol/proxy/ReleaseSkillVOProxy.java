package com.ks.protocol.proxy;
public final class ReleaseSkillVOProxy extends com.ks.protocol.vo.fight.skill.ReleaseSkillVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getSkillId());
		channelBuff.writeInt(getSkillLevel());
		channelBuff.writeInt(getFightId());
		channelBuff.writeInt(getType());
		if(getAffs()==null){
			setAffs(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.AffectederVO>());
		}		channelBuff.writeShort(getAffs().size());
		for(com.ks.protocol.vo.fight.skill.AffectederVO p1000 : getAffs()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeInt(getAtk());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setSkillId(channelBuff.readInt());
		setSkillLevel(channelBuff.readInt());
		setFightId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setAffs(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.AffectederVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getAffs().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.AffectederVO.class));
		}
		setAtk(channelBuff.readInt());
	}
	public Object copy(){return new ReleaseSkillVOProxy();}
}