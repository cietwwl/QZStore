package com.ks.protocol.proxy;
public final class GainAwardVOProxy extends com.ks.protocol.vo.goods.GainAwardVO{
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
		if(getEquipments()==null){
			setEquipments(new java.util.ArrayList<com.ks.protocol.vo.equment.UserEquipmentVO>());
		}		channelBuff.writeShort(getEquipments().size());
		for(com.ks.protocol.vo.equment.UserEquipmentVO p3000 : getEquipments()){
			writeObject(channelBuff,p3000);
		}
		if(getEnternals()==null){
			setEnternals(new java.util.ArrayList<com.ks.protocol.vo.eternal.UserEternalVO>());
		}		channelBuff.writeShort(getEnternals().size());
		for(com.ks.protocol.vo.eternal.UserEternalVO p4000 : getEnternals()){
			writeObject(channelBuff,p4000);
		}
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
		setEquipments(new java.util.ArrayList<com.ks.protocol.vo.equment.UserEquipmentVO>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getEquipments().add(readObject(channelBuff,com.ks.protocol.vo.equment.UserEquipmentVO.class));
		}
		setEnternals(new java.util.ArrayList<com.ks.protocol.vo.eternal.UserEternalVO>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getEnternals().add(readObject(channelBuff,com.ks.protocol.vo.eternal.UserEternalVO.class));
		}
	}
	public Object copy(){return new GainAwardVOProxy();}
}