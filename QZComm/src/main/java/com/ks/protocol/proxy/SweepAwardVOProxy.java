package com.ks.protocol.proxy;
public final class SweepAwardVOProxy extends com.ks.protocol.vo.fight.SweepAwardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		if(getSweeps()==null){
			setSweeps(new java.util.ArrayList<com.ks.protocol.vo.fight.SweepVO>());
		}		channelBuff.writeShort(getSweeps().size());
		for(com.ks.protocol.vo.fight.SweepVO p1000 : getSweeps()){
			writeObject(channelBuff,p1000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setSweeps(new java.util.ArrayList<com.ks.protocol.vo.fight.SweepVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getSweeps().add(readObject(channelBuff,com.ks.protocol.vo.fight.SweepVO.class));
		}
	}
	public Object copy(){return new SweepAwardVOProxy();}
}