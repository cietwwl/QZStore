package com.ks.protocol.proxy;
public final class UserVOProxy extends com.ks.protocol.vo.user.UserVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getUserId());
		writeString(channelBuff,getUsername());
		channelBuff.writeInt(getPartner());
		writeString(channelBuff,getPlayerName());
		channelBuff.writeInt(getGold());
		channelBuff.writeInt(getDiamond());
		channelBuff.writeInt(getHeroCapacity());
		writeString(channelBuff,getFightId());
		channelBuff.writeInt(getLevel());
		channelBuff.writeInt(getExp());
		channelBuff.writeInt(getAddExpPool());
		channelBuff.writeInt(getStamina());
		channelBuff.writeInt(getGp());
		channelBuff.writeLong(getLastRegainStaminaTime());
		channelBuff.writeInt(getChargeDiamond());
		channelBuff.writeInt(getHeroExpPool());
		channelBuff.writeInt(getEquipmentCapacity());
		channelBuff.writeInt(getEternalCapacity());
		channelBuff.writeInt(getPlotStep());
		channelBuff.writeInt(getGuideStep());
		channelBuff.writeInt(getFunUnlock());
		channelBuff.writeInt(getFame());
		channelBuff.writeInt(getSlate());
		channelBuff.writeInt(getVip());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setUserId(channelBuff.readInt());
		setUsername(readString(channelBuff));
		setPartner(channelBuff.readInt());
		setPlayerName(readString(channelBuff));
		setGold(channelBuff.readInt());
		setDiamond(channelBuff.readInt());
		setHeroCapacity(channelBuff.readInt());
		setFightId(readString(channelBuff));
		setLevel(channelBuff.readInt());
		setExp(channelBuff.readInt());
		setAddExpPool(channelBuff.readInt());
		setStamina(channelBuff.readInt());
		setGp(channelBuff.readInt());
		setLastRegainStaminaTime(channelBuff.readLong());
		setChargeDiamond(channelBuff.readInt());
		setHeroExpPool(channelBuff.readInt());
		setEquipmentCapacity(channelBuff.readInt());
		setEternalCapacity(channelBuff.readInt());
		setPlotStep(channelBuff.readInt());
		setGuideStep(channelBuff.readInt());
		setFunUnlock(channelBuff.readInt());
		setFame(channelBuff.readInt());
		setSlate(channelBuff.readInt());
		setVip(channelBuff.readInt());
	}
	public Object copy(){return new UserVOProxy();}
}