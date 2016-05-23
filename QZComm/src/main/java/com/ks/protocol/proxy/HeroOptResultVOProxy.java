package com.ks.protocol.proxy;
public final class HeroOptResultVOProxy extends com.ks.protocol.vo.hero.HeroOptResultVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getType());
		channelBuff.writeInt(getExp());
		writeObject(channelBuff,getHero());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setType(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setHero(readObject(channelBuff,com.ks.protocol.vo.hero.UserHeroVO.class));
	}
	public Object copy(){return new HeroOptResultVOProxy();}
}