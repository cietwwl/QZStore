package com.ks.protocol.proxy;
public final class SubFightBattleVOProxy extends com.ks.protocol.vo.fight.SubFightBattleVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		if(getPoints()==null){
			setPoints(new java.util.ArrayList<com.ks.protocol.vo.fight.PointVO>());
		}		channelBuff.writeShort(getPoints().size());
		for(com.ks.protocol.vo.fight.PointVO p1000 : getPoints()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setPoints(new java.util.ArrayList<com.ks.protocol.vo.fight.PointVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getPoints().add(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
		}
	}
	public Object copy(){return new SubFightBattleVOProxy();}
}