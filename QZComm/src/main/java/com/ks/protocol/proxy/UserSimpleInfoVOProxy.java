package com.ks.protocol.proxy;
public final class UserSimpleInfoVOProxy extends com.ks.protocol.vo.user.UserSimpleInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getLevel());
		channelBuff.writeInt(getExp());
		channelBuff.writeInt(getAddExpPool());
		channelBuff.writeInt(getStamina());
		channelBuff.writeInt(getGold());
		channelBuff.writeInt(getDiamond());
		channelBuff.writeInt(getHeroCapacity());
		channelBuff.writeInt(getGp());
		channelBuff.writeLong(getLastRegainStaminaTime());
		channelBuff.writeInt(getChargeDiamond());
		channelBuff.writeInt(getFame());
		channelBuff.writeInt(getSlate());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setLevel(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setAddExpPool(channelBuff.readInt());
		setStamina(channelBuff.readInt());
		setGold(channelBuff.readInt());
		setDiamond(channelBuff.readInt());
		setHeroCapacity(channelBuff.readInt());
		setGp(channelBuff.readInt());
		setLastRegainStaminaTime(channelBuff.readLong());
		setChargeDiamond(channelBuff.readInt());
		setFame(channelBuff.readInt());
		setSlate(channelBuff.readInt());
	}
	public Object copy(){return new UserSimpleInfoVOProxy();}
}