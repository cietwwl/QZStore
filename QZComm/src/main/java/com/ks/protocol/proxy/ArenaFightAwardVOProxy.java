package com.ks.protocol.proxy;
public final class ArenaFightAwardVOProxy extends com.ks.protocol.vo.arena.ArenaFightAwardVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getValour());
		channelBuff.writeInt(getExp());
		channelBuff.writeInt(getStreakWin());
		channelBuff.writeByte(isWin()?(byte)1:(byte)0);
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setValour(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setStreakWin(channelBuff.readInt());
		setWin(channelBuff.readByte()==1);
	}
	public Object copy(){return new ArenaFightAwardVOProxy();}
}