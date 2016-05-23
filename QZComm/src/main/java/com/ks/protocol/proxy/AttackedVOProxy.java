package com.ks.protocol.proxy;
public final class AttackedVOProxy extends com.ks.protocol.vo.fight.AttackedVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getAttackederId());
		channelBuff.writeInt(getBatterCount());
		channelBuff.writeInt(getSurHp());
		if(getAttacks()==null){
			setAttacks(new java.util.ArrayList<com.ks.protocol.vo.fight.AttackVO>());
		}		channelBuff.writeShort(getAttacks().size());
		for(com.ks.protocol.vo.fight.AttackVO p1000 : getAttacks()){
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
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setAttackederId(channelBuff.readInt());
		setBatterCount(channelBuff.readInt());
		setSurHp(channelBuff.readInt());
		setAttacks(new java.util.ArrayList<com.ks.protocol.vo.fight.AttackVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getAttacks().add(readObject(channelBuff,com.ks.protocol.vo.fight.AttackVO.class));
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
	}
	public Object copy(){return new AttackedVOProxy();}
}