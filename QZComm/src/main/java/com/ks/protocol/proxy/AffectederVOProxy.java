package com.ks.protocol.proxy;
public final class AffectederVOProxy extends com.ks.protocol.vo.fight.skill.AffectederVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getVal());
		channelBuff.writeInt(getSurHp());
		channelBuff.writeInt(getAbsorbHurt());
		writeObject(channelBuff,getBuff());
		if(getCoors()==null){
			setCoors(new java.util.ArrayList<com.ks.protocol.vo.fight.PointVO>());
		}		channelBuff.writeShort(getCoors().size());
		for(com.ks.protocol.vo.fight.PointVO p1000 : getCoors()){
			writeObject(channelBuff,p1000);
		}
		if(getDrops()==null){
			setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		}		channelBuff.writeShort(getDrops().size());
		for(com.ks.protocol.vo.fight.DropVO p2000 : getDrops()){
			writeObject(channelBuff,p2000);
		}
		if(getRelSkill()==null){
			setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		}		channelBuff.writeShort(getRelSkill().size());
		for(com.ks.protocol.vo.fight.skill.ReleaseSkillVO p3000 : getRelSkill()){
			writeObject(channelBuff,p3000);
		}
		if(getAtkEffectIds()==null){
			setAtkEffectIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getAtkEffectIds().size());
		for(java.lang.Integer p4000 : getAtkEffectIds()){
			channelBuff.writeInt(p4000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setType(channelBuff.readInt());
		setVal(channelBuff.readInt());
		setSurHp(channelBuff.readInt());
		setAbsorbHurt(channelBuff.readInt());
		setBuff(readObject(channelBuff,com.ks.protocol.vo.fight.skill.FightBuffVO.class));
		setCoors(new java.util.ArrayList<com.ks.protocol.vo.fight.PointVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getCoors().add(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
		}
		setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getDrops().add(readObject(channelBuff,com.ks.protocol.vo.fight.DropVO.class));
		}
		setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getRelSkill().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.ReleaseSkillVO.class));
		}
		setAtkEffectIds(new java.util.ArrayList<java.lang.Integer>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getAtkEffectIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new AffectederVOProxy();}
}