package com.ks.protocol.proxy;
public final class FightResultVOProxy extends com.ks.protocol.vo.fight.FightResultVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getStar());
		if(getRewards()==null){
			setRewards(new java.util.ArrayList<com.ks.protocol.vo.reward.ItemEffectVO>());
		}		channelBuff.writeShort(getRewards().size());
		for(com.ks.protocol.vo.reward.ItemEffectVO p1000 : getRewards()){
			writeObject(channelBuff,p1000);
		}
		if(getDrops()==null){
			setDrops(new java.util.ArrayList<com.ks.protocol.vo.reward.ItemEffectVO>());
		}		channelBuff.writeShort(getDrops().size());
		for(com.ks.protocol.vo.reward.ItemEffectVO p2000 : getDrops()){
			writeObject(channelBuff,p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setStar(channelBuff.readInt());
		setRewards(new java.util.ArrayList<com.ks.protocol.vo.reward.ItemEffectVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getRewards().add(readObject(channelBuff,com.ks.protocol.vo.reward.ItemEffectVO.class));
		}
		setDrops(new java.util.ArrayList<com.ks.protocol.vo.reward.ItemEffectVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getDrops().add(readObject(channelBuff,com.ks.protocol.vo.reward.ItemEffectVO.class));
		}
	}
	public Object copy(){return new FightResultVOProxy();}
}