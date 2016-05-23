package com.ks.protocol.proxy;
public final class TrialsZoneVOProxy extends com.ks.protocol.vo.zone.TrialsZoneVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getZoneId());
		if(getZoneBattleIds()==null){
			setZoneBattleIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getZoneBattleIds().size());
		for(java.lang.Integer p1000 : getZoneBattleIds()){
			channelBuff.writeInt(p1000);
		}
		channelBuff.writeInt(getNumber());
		channelBuff.writeInt(getFreeRefreshNum());
		channelBuff.writeInt(getDiamondRefreshNum());
		if(getChallengeIds()==null){
			setChallengeIds(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getChallengeIds().size());
		for(java.lang.Integer p2000 : getChallengeIds()){
			channelBuff.writeInt(p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setZoneId(channelBuff.readInt());
		setZoneBattleIds(new java.util.ArrayList<java.lang.Integer>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getZoneBattleIds().add(channelBuff.readInt());
		}
		setNumber(channelBuff.readInt());
		setFreeRefreshNum(channelBuff.readInt());
		setDiamondRefreshNum(channelBuff.readInt());
		setChallengeIds(new java.util.ArrayList<java.lang.Integer>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getChallengeIds().add(channelBuff.readInt());
		}
	}
	public Object copy(){return new TrialsZoneVOProxy();}
}