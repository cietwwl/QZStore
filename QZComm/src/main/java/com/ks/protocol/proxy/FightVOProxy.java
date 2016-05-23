package com.ks.protocol.proxy;
public final class FightVOProxy extends com.ks.protocol.vo.fight.FightVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeString(channelBuff,getBattleId());
		channelBuff.writeInt(getBattleType());
		channelBuff.writeInt(getZoneBattleId());
		channelBuff.writeInt(getBattleRoundId());
		channelBuff.writeInt(getAttackUserId());
		channelBuff.writeInt(getDefenderUserId());
		channelBuff.writeInt(getShotUserId());
		if(getGrids()==null){
			setGrids(new java.util.ArrayList<com.ks.protocol.vo.fight.GridVO>());
		}		channelBuff.writeShort(getGrids().size());
		for(com.ks.protocol.vo.fight.GridVO p1000 : getGrids()){
			writeObject(channelBuff,p1000);
		}
		if(getAttackers()==null){
			setAttackers(new java.util.ArrayList<com.ks.protocol.vo.fight.FightModelVO>());
		}		channelBuff.writeShort(getAttackers().size());
		for(com.ks.protocol.vo.fight.FightModelVO p2000 : getAttackers()){
			writeObject(channelBuff,p2000);
		}
		writeObject(channelBuff,getAttSub());
		if(getDefenders()==null){
			setDefenders(new java.util.ArrayList<com.ks.protocol.vo.fight.FightModelVO>());
		}		channelBuff.writeShort(getDefenders().size());
		for(com.ks.protocol.vo.fight.FightModelVO p3000 : getDefenders()){
			writeObject(channelBuff,p3000);
		}
		writeObject(channelBuff,getDefSub());
		if(getRounds()==null){
			setRounds(new java.util.ArrayList<com.ks.protocol.vo.fight.AttackRoundVO>());
		}		channelBuff.writeShort(getRounds().size());
		for(com.ks.protocol.vo.fight.AttackRoundVO p4000 : getRounds()){
			writeObject(channelBuff,p4000);
		}
		writeString(channelBuff,getMapId());
		channelBuff.writeInt(getRound());
		channelBuff.writeByte(isEnd()?(byte)1:(byte)0);
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setBattleId(readString(channelBuff));
		setBattleType(channelBuff.readInt());
		setZoneBattleId(channelBuff.readInt());
		setBattleRoundId(channelBuff.readInt());
		setAttackUserId(channelBuff.readInt());
		setDefenderUserId(channelBuff.readInt());
		setShotUserId(channelBuff.readInt());
		setGrids(new java.util.ArrayList<com.ks.protocol.vo.fight.GridVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getGrids().add(readObject(channelBuff,com.ks.protocol.vo.fight.GridVO.class));
		}
		setAttackers(new java.util.ArrayList<com.ks.protocol.vo.fight.FightModelVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getAttackers().add(readObject(channelBuff,com.ks.protocol.vo.fight.FightModelVO.class));
		}
		setAttSub(readObject(channelBuff,com.ks.protocol.vo.fight.FightModelVO.class));
		setDefenders(new java.util.ArrayList<com.ks.protocol.vo.fight.FightModelVO>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getDefenders().add(readObject(channelBuff,com.ks.protocol.vo.fight.FightModelVO.class));
		}
		setDefSub(readObject(channelBuff,com.ks.protocol.vo.fight.FightModelVO.class));
		setRounds(new java.util.ArrayList<com.ks.protocol.vo.fight.AttackRoundVO>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getRounds().add(readObject(channelBuff,com.ks.protocol.vo.fight.AttackRoundVO.class));
		}
		setMapId(readString(channelBuff));
		setRound(channelBuff.readInt());
		setEnd(channelBuff.readByte()==1);
	}
	public Object copy(){return new FightVOProxy();}
}