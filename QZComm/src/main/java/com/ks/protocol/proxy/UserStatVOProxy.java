package com.ks.protocol.proxy;
public final class UserStatVOProxy extends com.ks.protocol.vo.user.UserStatVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		channelBuff.writeInt(getArenaCount());
		channelBuff.writeInt(getArenaBuyCount());
		channelBuff.writeInt(getArenaRefreshCount());
		channelBuff.writeLong(getExitGuildTime());
		if(getMallBuys()==null){
			setMallBuys(new java.util.ArrayList<com.ks.protocol.vo.mall.AssStatVO>());
		}		channelBuff.writeShort(getMallBuys().size());
		for(com.ks.protocol.vo.mall.AssStatVO p1000 : getMallBuys()){
			writeObject(channelBuff,p1000);
		}
		if(getGivingFriend()==null){
			setGivingFriend(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getGivingFriend().size());
		for(java.lang.Integer p2000 : getGivingFriend()){
			channelBuff.writeInt(p2000);
		}
		channelBuff.writeInt(getCollectStamina());
		channelBuff.writeByte(isDrawLoginAward()?(byte)1:(byte)0);
		if(getDrawVIPGifis()==null){
			setDrawVIPGifis(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getDrawVIPGifis().size());
		for(java.lang.Integer p3000 : getDrawVIPGifis()){
			channelBuff.writeInt(p3000);
		}
		if(getActivityZoneCount()==null){
			setActivityZoneCount(new java.util.ArrayList<com.ks.protocol.vo.mall.AssStatVO>());
		}		channelBuff.writeShort(getActivityZoneCount().size());
		for(com.ks.protocol.vo.mall.AssStatVO p4000 : getActivityZoneCount()){
			writeObject(channelBuff,p4000);
		}
		channelBuff.writeInt(getHireGp());
		channelBuff.writeInt(getGoldCall());
		channelBuff.writeLong(getLastGoldCallTime());
		channelBuff.writeInt(getDiamondCall());
		channelBuff.writeLong(getLastDiamondCallTime());
		channelBuff.writeByte(getMartialWayCount());
		channelBuff.writeByte(getMartialWayBuyCount());
		channelBuff.writeByte(getBuyGoldCount());
		channelBuff.writeByte(getBuyStaminaCount());
		if(getSigninDays()==null){
			setSigninDays(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getSigninDays().size());
		for(java.lang.Integer p5000 : getSigninDays()){
			channelBuff.writeInt(p5000);
		}
		channelBuff.writeInt(getFillSignin());
		if(getSumSigninDays()==null){
			setSumSigninDays(new java.util.ArrayList<java.lang.Integer>());
		}		channelBuff.writeShort(getSumSigninDays().size());
		for(java.lang.Integer p6000 : getSumSigninDays()){
			channelBuff.writeInt(p6000);
		}
		if(getBmg()==null){
			setBmg(new java.util.ArrayList<com.ks.protocol.vo.mall.BlackMarketGoodsVO>());
		}		channelBuff.writeShort(getBmg().size());
		for(com.ks.protocol.vo.mall.BlackMarketGoodsVO p7000 : getBmg()){
			writeObject(channelBuff,p7000);
		}
		if(getMallTotleBuyCount()==null){
			setMallTotleBuyCount(new java.util.ArrayList<com.ks.protocol.vo.mall.AssStatVO>());
		}		channelBuff.writeShort(getMallTotleBuyCount().size());
		for(com.ks.protocol.vo.mall.AssStatVO p8000 : getMallTotleBuyCount()){
			writeObject(channelBuff,p8000);
		}
		channelBuff.writeInt(getBlackMarketRefCount());
		channelBuff.writeLong(getSlateGainTime());
		if(getCycleCards()==null){
			setCycleCards(new java.util.ArrayList<com.ks.protocol.vo.user.CycleCardVO>());
		}		channelBuff.writeShort(getCycleCards().size());
		for(com.ks.protocol.vo.user.CycleCardVO p9000 : getCycleCards()){
			writeObject(channelBuff,p9000);
		}
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setArenaCount(channelBuff.readInt());
		setArenaBuyCount(channelBuff.readInt());
		setArenaRefreshCount(channelBuff.readInt());
		setExitGuildTime(channelBuff.readLong());
		setMallBuys(new java.util.ArrayList<com.ks.protocol.vo.mall.AssStatVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getMallBuys().add(readObject(channelBuff,com.ks.protocol.vo.mall.AssStatVO.class));
		}
		setGivingFriend(new java.util.ArrayList<java.lang.Integer>());
		int p2000=channelBuff.readShort();
		for(int i2000=0;i2000<p2000;i2000++){
			getGivingFriend().add(channelBuff.readInt());
		}
		setCollectStamina(channelBuff.readInt());
		setDrawLoginAward(channelBuff.readByte()==1);
		setDrawVIPGifis(new java.util.ArrayList<java.lang.Integer>());
		int p3000=channelBuff.readShort();
		for(int i3000=0;i3000<p3000;i3000++){
			getDrawVIPGifis().add(channelBuff.readInt());
		}
		setActivityZoneCount(new java.util.ArrayList<com.ks.protocol.vo.mall.AssStatVO>());
		int p4000=channelBuff.readShort();
		for(int i4000=0;i4000<p4000;i4000++){
			getActivityZoneCount().add(readObject(channelBuff,com.ks.protocol.vo.mall.AssStatVO.class));
		}
		setHireGp(channelBuff.readInt());
		setGoldCall(channelBuff.readInt());
		setLastGoldCallTime(channelBuff.readLong());
		setDiamondCall(channelBuff.readInt());
		setLastDiamondCallTime(channelBuff.readLong());
		setMartialWayCount(channelBuff.readByte());
		setMartialWayBuyCount(channelBuff.readByte());
		setBuyGoldCount(channelBuff.readByte());
		setBuyStaminaCount(channelBuff.readByte());
		setSigninDays(new java.util.ArrayList<java.lang.Integer>());
		int p5000=channelBuff.readShort();
		for(int i5000=0;i5000<p5000;i5000++){
			getSigninDays().add(channelBuff.readInt());
		}
		setFillSignin(channelBuff.readInt());
		setSumSigninDays(new java.util.ArrayList<java.lang.Integer>());
		int p6000=channelBuff.readShort();
		for(int i6000=0;i6000<p6000;i6000++){
			getSumSigninDays().add(channelBuff.readInt());
		}
		setBmg(new java.util.ArrayList<com.ks.protocol.vo.mall.BlackMarketGoodsVO>());
		int p7000=channelBuff.readShort();
		for(int i7000=0;i7000<p7000;i7000++){
			getBmg().add(readObject(channelBuff,com.ks.protocol.vo.mall.BlackMarketGoodsVO.class));
		}
		setMallTotleBuyCount(new java.util.ArrayList<com.ks.protocol.vo.mall.AssStatVO>());
		int p8000=channelBuff.readShort();
		for(int i8000=0;i8000<p8000;i8000++){
			getMallTotleBuyCount().add(readObject(channelBuff,com.ks.protocol.vo.mall.AssStatVO.class));
		}
		setBlackMarketRefCount(channelBuff.readInt());
		setSlateGainTime(channelBuff.readLong());
		setCycleCards(new java.util.ArrayList<com.ks.protocol.vo.user.CycleCardVO>());
		int p9000=channelBuff.readShort();
		for(int i9000=0;i9000<p9000;i9000++){
			getCycleCards().add(readObject(channelBuff,com.ks.protocol.vo.user.CycleCardVO.class));
		}
	}
	public Object copy(){return new UserStatVOProxy();}
}