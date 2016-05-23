package com.ks.protocol.proxy;
public final class SweepAwardVOProxy extends com.ks.protocol.vo.fight.SweepAwardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getHeros()==null){
			setHeros(new java.util.ArrayList<com.ks.protocol.vo.hero.UserHeroVO>());
		}		channelBuff.writeShort(getHeros().size());
		for(com.ks.protocol.vo.hero.UserHeroVO p1000 : getHeros()){
			writeObject(channelBuff,p1000);
		}
		if(getSweeps()==null){
			setSweeps(new java.util.ArrayList<com.ks.protocol.vo.fight.SweepVO>());
		}		channelBuff.writeShort(getSweeps().size());
		for(com.ks.protocol.vo.fight.SweepVO p2000 : getSweeps()){
			writeObject(channelBuff,p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setHeros(new java.util.ArrayList<com.ks.protocol.vo.hero.UserHeroVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getHeros().add(readObject(channelBuff,com.ks.protocol.vo.hero.UserHeroVO.class));
		}
		setSweeps(new java.util.ArrayList<com.ks.protocol.vo.fight.SweepVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getSweeps().add(readObject(channelBuff,com.ks.protocol.vo.fight.SweepVO.class));
		}
	}
	public Object copy(){return new SweepAwardVOProxy();}
}