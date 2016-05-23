package com.ks.protocol.proxy;
public final class EvolutionHeroResultVOProxy extends com.ks.protocol.vo.hero.EvolutionHeroResultVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getHero());
		if(getRemHeros()==null){
			setRemHeros(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getRemHeros().size());
		for(java.lang.Integer p1000 : getRemHeros()){
			channelBuff.writeInt(p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setHero(readObject(channelBuff,com.ks.protocol.vo.hero.UserHeroVO.class));
		setRemHeros(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getRemHeros().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new EvolutionHeroResultVOProxy();}
}