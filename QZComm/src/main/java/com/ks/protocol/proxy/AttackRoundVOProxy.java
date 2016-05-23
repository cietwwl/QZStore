package com.ks.protocol.proxy;
public final class AttackRoundVOProxy extends com.ks.protocol.vo.fight.AttackRoundVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getMove());
		channelBuff.writeInt(getNextShotUserId());
		if(getAttackeds()==null){
			setAttackeds(new java.util.ArrayList<com.ks.protocol.vo.fight.AttackedVO>());
		}		channelBuff.writeShort(getAttackeds().size());
		for(com.ks.protocol.vo.fight.AttackedVO p1000 : getAttackeds()){
			writeObject(channelBuff,p1000);
		}
		if(getRotations()==null){
			setRotations(new java.util.ArrayList<com.ks.protocol.vo.fight.ModeRotationVO>());
		}		channelBuff.writeShort(getRotations().size());
		for(com.ks.protocol.vo.fight.ModeRotationVO p2000 : getRotations()){
			writeObject(channelBuff,p2000);
		}
		writeObject(channelBuff,getSubFightBattleVO());
		writeObject(channelBuff,getDisMonster());
		writeObject(channelBuff,getNextFight());
		if(getAffects()==null){
			setAffects(new java.util.ArrayList<com.ks.protocol.vo.fight.prop.FightPropAffectVO>());
		}		channelBuff.writeShort(getAffects().size());
		for(com.ks.protocol.vo.fight.prop.FightPropAffectVO p3000 : getAffects()){
			writeObject(channelBuff,p3000);
		}
		if(getPropRefs()==null){
			setPropRefs(new java.util.ArrayList<com.ks.protocol.vo.fight.prop.FightPropRefVO>());
		}		channelBuff.writeShort(getPropRefs().size());
		for(com.ks.protocol.vo.fight.prop.FightPropRefVO p4000 : getPropRefs()){
			writeObject(channelBuff,p4000);
		}
		if(getRelSkill()==null){
			setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		}		channelBuff.writeShort(getRelSkill().size());
		for(com.ks.protocol.vo.fight.skill.ReleaseSkillVO p5000 : getRelSkill()){
			writeObject(channelBuff,p5000);
		}
		if(getBuffAffects()==null){
			setBuffAffects(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.FightBuffAffectVO>());
		}		channelBuff.writeShort(getBuffAffects().size());
		for(com.ks.protocol.vo.fight.skill.FightBuffAffectVO p6000 : getBuffAffects()){
			writeObject(channelBuff,p6000);
		}
		if(getCatapult()==null){
			setCatapult(new java.util.ArrayList<com.ks.protocol.vo.fight.CatapultVO>());
		}		channelBuff.writeShort(getCatapult().size());
		for(com.ks.protocol.vo.fight.CatapultVO p7000 : getCatapult()){
			writeObject(channelBuff,p7000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setMove(readObject(channelBuff,com.ks.protocol.vo.fight.MoveVO.class));
		setNextShotUserId(channelBuff.readInt());
		setAttackeds(new java.util.ArrayList<com.ks.protocol.vo.fight.AttackedVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getAttackeds().add(readObject(channelBuff,com.ks.protocol.vo.fight.AttackedVO.class));
		}
		setRotations(new java.util.ArrayList<com.ks.protocol.vo.fight.ModeRotationVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getRotations().add(readObject(channelBuff,com.ks.protocol.vo.fight.ModeRotationVO.class));
		}
		setSubFightBattleVO(readObject(channelBuff,com.ks.protocol.vo.fight.SubFightBattleVO.class));
		setDisMonster(readObject(channelBuff,com.ks.protocol.vo.fight.FightModelVO.class));
		setNextFight(readObject(channelBuff,com.ks.protocol.vo.fight.FightVO.class));
		setAffects(new java.util.ArrayList<com.ks.protocol.vo.fight.prop.FightPropAffectVO>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getAffects().add(readObject(channelBuff,com.ks.protocol.vo.fight.prop.FightPropAffectVO.class));
		}
		setPropRefs(new java.util.ArrayList<com.ks.protocol.vo.fight.prop.FightPropRefVO>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getPropRefs().add(readObject(channelBuff,com.ks.protocol.vo.fight.prop.FightPropRefVO.class));
		}
		setRelSkill(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.ReleaseSkillVO>());
		int p5000=channelBuff.readShort();
		for(int i5000=0;i5000<p5000;i5000++){
			getRelSkill().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.ReleaseSkillVO.class));
		}
		setBuffAffects(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.FightBuffAffectVO>());
		int p6000=channelBuff.readShort();
		for(int i6000=0;i6000<p6000;i6000++){
			getBuffAffects().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.FightBuffAffectVO.class));
		}
		setCatapult(new java.util.ArrayList<com.ks.protocol.vo.fight.CatapultVO>());
		int p7000=channelBuff.readShort();
		for(int i7000=0;i7000<p7000;i7000++){
			getCatapult().add(readObject(channelBuff,com.ks.protocol.vo.fight.CatapultVO.class));
		}
	}
	public Object copy(){return new AttackRoundVOProxy();}
}