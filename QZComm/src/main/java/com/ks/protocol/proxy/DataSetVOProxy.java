package com.ks.protocol.proxy;
public final class DataSetVOProxy extends com.ks.protocol.vo.data.DataSetVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getUser());
		writeObject(channelBuff,getUserStat());
		writeObject(channelBuff,getUserRecord());
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
		if(getEternals()==null){
			setEternals(new java.util.ArrayList<com.ks.protocol.vo.eternal.UserEternalVO>());
		}		channelBuff.writeShort(getEternals().size());
		for(com.ks.protocol.vo.eternal.UserEternalVO p4000 : getEternals()){
			writeObject(channelBuff,p4000);
		}
		if(getDeleteHeroIds()==null){
			setDeleteHeroIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getDeleteHeroIds().size());
		for(java.lang.Integer p5000 : getDeleteHeroIds()){
			channelBuff.writeInt(p5000);
		}
		if(getDeleteEquipIds()==null){
			setDeleteEquipIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getDeleteEquipIds().size());
		for(java.lang.Integer p6000 : getDeleteEquipIds()){
			channelBuff.writeInt(p6000);
		}
		if(getDeleteEternalIds()==null){
			setDeleteEternalIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getDeleteEternalIds().size());
		for(java.lang.Integer p7000 : getDeleteEternalIds()){
			channelBuff.writeInt(p7000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUser(readObject(channelBuff,com.ks.protocol.vo.user.UserVO.class));
		setUserStat(readObject(channelBuff,com.ks.protocol.vo.user.UserStatVO.class));
		setUserRecord(readObject(channelBuff,com.ks.protocol.vo.user.UserRecordVO.class));
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
		setEternals(new java.util.ArrayList<com.ks.protocol.vo.eternal.UserEternalVO>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getEternals().add(readObject(channelBuff,com.ks.protocol.vo.eternal.UserEternalVO.class));
		}
		setDeleteHeroIds(new java.util.ArrayList<java.lang.Integer>());
		int p5000=channelBuff.readShort();
		for(int i5000=0;i5000<p5000;i5000++){
			getDeleteHeroIds().add(channelBuff.readInt());
		}
		setDeleteEquipIds(new java.util.ArrayList<java.lang.Integer>());
		int p6000=channelBuff.readShort();
		for(int i6000=0;i6000<p6000;i6000++){
			getDeleteEquipIds().add(channelBuff.readInt());
		}
		setDeleteEternalIds(new java.util.ArrayList<java.lang.Integer>());
		int p7000=channelBuff.readShort();
		for(int i7000=0;i7000<p7000;i7000++){
			getDeleteEternalIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new DataSetVOProxy();}
}