package com.ks.protocol.proxy;
public final class UserZoneVOProxy extends com.ks.protocol.vo.zone.UserZoneVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getZoneId());
		channelBuff.writeInt(getCurrBattle());
		if(getGainAwardStar()==null){
			setGainAwardStar(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getGainAwardStar().size());
		for(java.lang.Integer p1000 : getGainAwardStar()){
			channelBuff.writeInt(p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setZoneId(channelBuff.readInt());
		setCurrBattle(channelBuff.readInt());
		setGainAwardStar(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getGainAwardStar().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new UserZoneVOProxy();}
}