package com.ks.protocol.proxy;
public final class FightModelVOProxy extends com.ks.protocol.vo.fight.FightModelVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		channelBuff.writeByte(isNpc()?(byte)1:(byte)0);
		channelBuff.writeInt(getAssId());
		channelBuff.writeInt(getState());
		channelBuff.writeInt(getEle());
		channelBuff.writeInt(getAbility());
		channelBuff.writeInt(getEleLv());
		channelBuff.writeInt(getAtk());
		channelBuff.writeInt(getAtkCount());
		if(getAtkMode()==null){
			setAtkMode(new java.util.ArrayList<com.ks.protocol.vo.fight.FightAtkModeVO>());
		}		channelBuff.writeShort(getAtkMode().size());
		for(com.ks.protocol.vo.fight.FightAtkModeVO p1000 : getAtkMode()){
			writeObject(channelBuff,p1000);
		}
		channelBuff.writeInt(getHp());
		channelBuff.writeInt(getMaxHp());
		channelBuff.writeInt(getBaseHp());
		channelBuff.writeDouble(getCritRate());
		channelBuff.writeDouble(getCrithurt());
		channelBuff.writeDouble(getDodgeRate());
		if(getGridCoors()==null){
			setGridCoors(new java.util.ArrayList<com.ks.protocol.vo.fight.PointVO>());
		}		channelBuff.writeShort(getGridCoors().size());
		for(com.ks.protocol.vo.fight.PointVO p2000 : getGridCoors()){
			writeObject(channelBuff,p2000);
		}
		if(getBuffs()==null){
			setBuffs(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.FightBuffVO>());
		}		channelBuff.writeShort(getBuffs().size());
		for(com.ks.protocol.vo.fight.skill.FightBuffVO p3000 : getBuffs()){
			writeObject(channelBuff,p3000);
		}
		channelBuff.writeInt(getBlockRate());
		channelBuff.writeByte(getCatapult());
		channelBuff.writeDouble(getBlockHit());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setNpc(channelBuff.readByte()==1);
		setAssId(channelBuff.readInt());
		setState(channelBuff.readInt());
		setEle(channelBuff.readInt());
		setAbility(channelBuff.readInt());
		setEleLv(channelBuff.readInt());
		setAtk(channelBuff.readInt());
		setAtkCount(channelBuff.readInt());
		setAtkMode(new java.util.ArrayList<com.ks.protocol.vo.fight.FightAtkModeVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getAtkMode().add(readObject(channelBuff,com.ks.protocol.vo.fight.FightAtkModeVO.class));
		}
		setHp(channelBuff.readInt());
		setMaxHp(channelBuff.readInt());
		setBaseHp(channelBuff.readInt());
		setCritRate(channelBuff.readDouble());
		setCrithurt(channelBuff.readDouble());
		setDodgeRate(channelBuff.readDouble());
		setGridCoors(new java.util.ArrayList<com.ks.protocol.vo.fight.PointVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getGridCoors().add(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
		}
		setBuffs(new java.util.ArrayList<com.ks.protocol.vo.fight.skill.FightBuffVO>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getBuffs().add(readObject(channelBuff,com.ks.protocol.vo.fight.skill.FightBuffVO.class));
		}
		setBlockRate(channelBuff.readInt());
		setCatapult(channelBuff.readByte());
		setBlockHit(channelBuff.readDouble());
	}
	public Object copy(){return new FightModelVOProxy();}
}