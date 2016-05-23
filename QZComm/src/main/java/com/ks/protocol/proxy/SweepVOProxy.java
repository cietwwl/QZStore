package com.ks.protocol.proxy;
public final class SweepVOProxy extends com.ks.protocol.vo.fight.SweepVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getGold());
		channelBuff.writeInt(getExp());
		if(getDrops()==null){
			setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		}		channelBuff.writeShort(getDrops().size());
		for(com.ks.protocol.vo.fight.DropVO p1000 : getDrops()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setGold(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setDrops(new java.util.ArrayList<com.ks.protocol.vo.fight.DropVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getDrops().add(readObject(channelBuff,com.ks.protocol.vo.fight.DropVO.class));
		}
	}
	public Object copy(){return new SweepVOProxy();}
}