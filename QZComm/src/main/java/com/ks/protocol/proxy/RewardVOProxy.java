package com.ks.protocol.proxy;
public final class RewardVOProxy extends com.ks.protocol.vo.reward.RewardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getEffects()==null){
			setEffects(new java.util.ArrayList<com.ks.protocol.vo.reward.ItemEffectVO>());
		}		channelBuff.writeShort(getEffects().size());
		for(com.ks.protocol.vo.reward.ItemEffectVO p1000 : getEffects()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setEffects(new java.util.ArrayList<com.ks.protocol.vo.reward.ItemEffectVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getEffects().add(readObject(channelBuff,com.ks.protocol.vo.reward.ItemEffectVO.class));
		}
	}
	public Object copy(){return new RewardVOProxy();}
}