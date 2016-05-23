package com.ks.protocol.proxy;
public final class SubHurtVOProxy extends com.ks.protocol.vo.fight.SubHurtVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getDefFightId());
		channelBuff.writeInt(getHurt());
		channelBuff.writeInt(getAbsorbHurt());
		channelBuff.writeInt(getSurHp());
		if(getDrops()==null){
			setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		}		channelBuff.writeShort(getDrops().size());
		for(com.ks.protocol.vo.fight.DropVO p1000 : getDrops()){
			writeObject(channelBuff,p1000);
		}
		if(getAtkEffectIds()==null){
			setAtkEffectIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getAtkEffectIds().size());
		for(java.lang.Integer p2000 : getAtkEffectIds()){
			channelBuff.writeInt(p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setDefFightId(channelBuff.readInt());
		setHurt(channelBuff.readInt());
		setAbsorbHurt(channelBuff.readInt());
		setSurHp(channelBuff.readInt());
		setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getDrops().add(readObject(channelBuff,com.ks.protocol.vo.fight.DropVO.class));
		}
		setAtkEffectIds(new java.util.ArrayList<java.lang.Integer>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getAtkEffectIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new SubHurtVOProxy();}
}