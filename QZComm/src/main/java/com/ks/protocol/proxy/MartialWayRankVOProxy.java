package com.ks.protocol.proxy;
public final class MartialWayRankVOProxy extends com.ks.protocol.vo.martial.MartialWayRankVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getMyBaseInfo());
		writeObject(channelBuff,getMyWay());
		if(getRankInfos()==null){
			setRankInfos(new java.util.ArrayList<com.ks.protocol.vo.user.UserBaseinfoVO>());
		}		channelBuff.writeShort(getRankInfos().size());
		for(com.ks.protocol.vo.user.UserBaseinfoVO p1000 : getRankInfos()){
			writeObject(channelBuff,p1000);
		}
		if(getRankWays()==null){
			setRankWays(new java.util.ArrayList<com.ks.protocol.vo.martial.MartialWayVO>());
		}		channelBuff.writeShort(getRankWays().size());
		for(com.ks.protocol.vo.martial.MartialWayVO p2000 : getRankWays()){
			writeObject(channelBuff,p2000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setMyBaseInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
		setMyWay(readObject(channelBuff,com.ks.protocol.vo.martial.MartialWayVO.class));
		setRankInfos(new java.util.ArrayList<com.ks.protocol.vo.user.UserBaseinfoVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getRankInfos().add(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
		}
		setRankWays(new java.util.ArrayList<com.ks.protocol.vo.martial.MartialWayVO>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getRankWays().add(readObject(channelBuff,com.ks.protocol.vo.martial.MartialWayVO.class));
		}
	}
	public Object copy(){return new MartialWayRankVOProxy();}
}