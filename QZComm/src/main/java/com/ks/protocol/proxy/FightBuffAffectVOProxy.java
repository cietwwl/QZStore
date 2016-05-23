package com.ks.protocol.proxy;
public final class FightBuffAffectVOProxy extends com.ks.protocol.vo.fight.skill.FightBuffAffectVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		channelBuff.writeInt(getEffectId());
		channelBuff.writeInt(getValType());
		channelBuff.writeInt(getVal());
		channelBuff.writeInt(getAbsorbHurt());
		channelBuff.writeInt(getSurHp());
		if(getDrops()==null){
			setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		}		channelBuff.writeShort(getDrops().size());
		for(com.ks.protocol.vo.fight.DropVO p1000 : getDrops()){
			writeObject(channelBuff,p1000);
		}
		if(getRelSkill()==null){
			setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		}		channelBuff.writeShort(getRelSkill().size());
		for(com.ks.protocol.vo.fight.skill.ReleaseSkillVO p2000 : getRelSkill()){
			writeObject(channelBuff,p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setEffectId(channelBuff.readInt());
		setValType(channelBuff.readInt());
		setVal(channelBuff.readInt());
		setAbsorbHurt(channelBuff.readInt());
		setSurHp(channelBuff.readInt());
		setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getDrops().add(readObject(channelBuff,com.ks.protocol.vo.fight.DropVO.class));
		}
		setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getRelSkill().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.ReleaseSkillVO.class));
		}
	}
	public Object copy(){return new FightBuffAffectVOProxy();}
}