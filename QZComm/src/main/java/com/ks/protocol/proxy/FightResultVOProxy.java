package com.ks.protocol.proxy;
public final class FightResultVOProxy extends com.ks.protocol.vo.fight.FightResultVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getHeros()==null){
			setHeros(new java.util.ArrayList<com.ks.protocol.vo.hero.UserHeroVO>());
		}		channelBuff.writeShort(getHeros().size());
		for(com.ks.protocol.vo.hero.UserHeroVO p1000 : getHeros()){
			writeObject(channelBuff,p1000);
		}
		if(getProps()==null){
			setProps(new java.util.ArrayList<com.ks.protocol.vo.prop.UserPropVO>());
		}		channelBuff.writeShort(getProps().size());
		for(com.ks.protocol.vo.prop.UserPropVO p2000 : getProps()){
			writeObject(channelBuff,p2000);
		}
		if(getEquips()==null){
			setEquips(new java.util.ArrayList<com.ks.protocol.vo.equment.UserEquipmentVO>());
		}		channelBuff.writeShort(getEquips().size());
		for(com.ks.protocol.vo.equment.UserEquipmentVO p3000 : getEquips()){
			writeObject(channelBuff,p3000);
		}
		channelBuff.writeInt(getExp());
		channelBuff.writeInt(getGold());
		channelBuff.writeInt(getTotleGold());
		channelBuff.writeInt(getStar());
		channelBuff.writeInt(getSmeltingPoint());
		channelBuff.writeInt(getHeroExp());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setHeros(new java.util.ArrayList<com.ks.protocol.vo.hero.UserHeroVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getHeros().add(readObject(channelBuff,com.ks.protocol.vo.hero.UserHeroVO.class));
		}
		setProps(new java.util.ArrayList<com.ks.protocol.vo.prop.UserPropVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getProps().add(readObject(channelBuff,com.ks.protocol.vo.prop.UserPropVO.class));
		}
		setEquips(new java.util.ArrayList<com.ks.protocol.vo.equment.UserEquipmentVO>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getEquips().add(readObject(channelBuff,com.ks.protocol.vo.equment.UserEquipmentVO.class));
		}
		setExp(channelBuff.readInt());
		setGold(channelBuff.readInt());
		setTotleGold(channelBuff.readInt());
		setStar(channelBuff.readInt());
		setSmeltingPoint(channelBuff.readInt());
		setHeroExp(channelBuff.readInt());
	}
	public Object copy(){return new FightResultVOProxy();}
}