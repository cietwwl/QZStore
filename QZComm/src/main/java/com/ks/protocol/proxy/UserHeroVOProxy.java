package com.ks.protocol.proxy;
public final class UserHeroVOProxy extends com.ks.protocol.vo.hero.UserHeroVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getId());
		channelBuff.writeInt(getHeroId());
		channelBuff.writeInt(getLevel());
		channelBuff.writeInt(getExp());
		channelBuff.writeInt(getEleLevel());
		channelBuff.writeInt(getState());
		channelBuff.writeInt(getSkillLevel());
		channelBuff.writeInt(getCapSkillLevel());
		channelBuff.writeInt(getEternal());
		channelBuff.writeInt(getBreakLevel());
		if(getBreakedSlots()==null){
			setBreakedSlots(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getBreakedSlots().size());
		for(java.lang.Integer p1000 : getBreakedSlots()){
			channelBuff.writeInt(p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setId(channelBuff.readInt());
		setHeroId(channelBuff.readInt());
		setLevel(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setEleLevel(channelBuff.readInt());
		setState(channelBuff.readInt());
		setSkillLevel(channelBuff.readInt());
		setCapSkillLevel(channelBuff.readInt());
		setEternal(channelBuff.readInt());
		setBreakLevel(channelBuff.readInt());
		setBreakedSlots(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getBreakedSlots().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new UserHeroVOProxy();}
}