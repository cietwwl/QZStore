package com.ks.protocol.proxy;
public final class AttackVOProxy extends com.ks.protocol.vo.fight.AttackVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getAttackerId());
		channelBuff.writeInt(getHurtType());
		channelBuff.writeInt(getHurt());
		channelBuff.writeInt(getAbsorbHurt());
		if(getSubHurts()==null){
			setSubHurts(new java.util.ArrayList<com.ks.protocol.vo.fight.SubHurtVO>());
		}		channelBuff.writeShort(getSubHurts().size());
		for(com.ks.protocol.vo.fight.SubHurtVO p1000 : getSubHurts()){
			writeObject(channelBuff,p1000);
		}
		if(getRelSkill()==null){
			setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		}		channelBuff.writeShort(getRelSkill().size());
		for(com.ks.protocol.vo.fight.skill.ReleaseSkillVO p2000 : getRelSkill()){
			writeObject(channelBuff,p2000);
		}
		channelBuff.writeInt(getAtk());
		if(getAtkEffectIds()==null){
			setAtkEffectIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getAtkEffectIds().size());
		for(java.lang.Integer p3000 : getAtkEffectIds()){
			channelBuff.writeInt(p3000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setAttackerId(channelBuff.readInt());
		setHurtType(channelBuff.readInt());
		setHurt(channelBuff.readInt());
		setAbsorbHurt(channelBuff.readInt());
		setSubHurts(new java.util.ArrayList<com.ks.protocol.vo.fight.SubHurtVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getSubHurts().add(readObject(channelBuff,com.ks.protocol.vo.fight.SubHurtVO.class));
		}
		setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getRelSkill().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.ReleaseSkillVO.class));
		}
		setAtk(channelBuff.readInt());
		setAtkEffectIds(new java.util.ArrayList<java.lang.Integer>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getAtkEffectIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new AttackVOProxy();}
}