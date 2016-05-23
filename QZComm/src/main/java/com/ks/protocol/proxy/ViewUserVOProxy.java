package com.ks.protocol.proxy;
public final class ViewUserVOProxy extends com.ks.protocol.vo.user.ViewUserVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getTeam());
		if(getHeros()==null){
			setHeros(new java.util.ArrayList<com.ks.protocol.vo.hero.UserHeroVO>());
		}		channelBuff.writeShort(getHeros().size());
		for(com.ks.protocol.vo.hero.UserHeroVO p1000 : getHeros()){
			writeObject(channelBuff,p1000);
		}
		writeString(channelBuff,getGuildName());
		writeObject(channelBuff,getBaseInfo());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setTeam(readObject(channelBuff,com.ks.protocol.vo.user.UserTeamVO.class));
		setHeros(new java.util.ArrayList<com.ks.protocol.vo.hero.UserHeroVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getHeros().add(readObject(channelBuff,com.ks.protocol.vo.hero.UserHeroVO.class));
		}
		setGuildName(readString(channelBuff));
		setBaseInfo(readObject(channelBuff,com.ks.protocol.vo.user.UserBaseinfoVO.class));
	}
	public Object copy(){return new ViewUserVOProxy();}
}