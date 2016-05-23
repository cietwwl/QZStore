package com.ks.protocol.proxy;
public final class UserInfoVOProxy extends com.ks.protocol.vo.user.UserInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getUser());
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
		if(getEternals()==null){
			setEternals(new java.util.ArrayList<com.ks.protocol.vo.eternal.UserEternalVO>());
		}		channelBuff.writeShort(getEternals().size());
		for(com.ks.protocol.vo.eternal.UserEternalVO p4000 : getEternals()){
			writeObject(channelBuff,p4000);
		}
		if(getFirstRechangeIds()==null){
			setFirstRechangeIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getFirstRechangeIds().size());
		for(java.lang.Integer p5000 : getFirstRechangeIds()){
			channelBuff.writeInt(p5000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUser(readObject(channelBuff,com.ks.protocol.vo.user.UserVO.class));
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
		setEternals(new java.util.ArrayList<com.ks.protocol.vo.eternal.UserEternalVO>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getEternals().add(readObject(channelBuff,com.ks.protocol.vo.eternal.UserEternalVO.class));
		}
		setFirstRechangeIds(new java.util.ArrayList<java.lang.Integer>());
		int p5000=channelBuff.readShort();
		for(int i5000=0;i5000<p5000;i5000++){
			getFirstRechangeIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new UserInfoVOProxy();}
}