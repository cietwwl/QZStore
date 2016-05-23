package com.ks.protocol.proxy;
public final class CatapultVOProxy extends com.ks.protocol.vo.fight.CatapultVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getFightId());
		writeObject(channelBuff,getCurrPoint());
		if(getHurts()==null){
			setHurts(new java.util.ArrayList<com.ks.protocol.vo.fight.CatapultHurtVO>());
		}		channelBuff.writeShort(getHurts().size());
		for(com.ks.protocol.vo.fight.CatapultHurtVO p1000 : getHurts()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setFightId(channelBuff.readInt());
		setCurrPoint(readObject(channelBuff,com.ks.protocol.vo.fight.PointVO.class));
		setHurts(new java.util.ArrayList<com.ks.protocol.vo.fight.CatapultHurtVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getHurts().add(readObject(channelBuff,com.ks.protocol.vo.fight.CatapultHurtVO.class));
		}
	}
	public Object copy(){return new CatapultVOProxy();}
}