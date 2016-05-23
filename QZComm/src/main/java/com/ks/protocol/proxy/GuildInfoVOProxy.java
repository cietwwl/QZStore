package com.ks.protocol.proxy;
public final class GuildInfoVOProxy extends com.ks.protocol.vo.guild.GuildInfoVO{
		private static final long serialVersionUID = 1L;
	public void encode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		writeObject(channelBuff,getGuild());
		if(getSkills()==null){
			setSkills(new java.util.ArrayList<com.ks.protocol.vo.guild.GuildSkillVO>());
		}		channelBuff.writeShort(getSkills().size());
		for(com.ks.protocol.vo.guild.GuildSkillVO p1000 : getSkills()){
			writeObject(channelBuff,p1000);
		}
		writeObject(channelBuff,getApply());
		writeObject(channelBuff,getGuildMember());
		writeObject(channelBuff,getAccuse());
		channelBuff.writeLong(getCdrLastLoginTime());
	}
	public void decode(org.jboss.netty.buffer.ChannelBuffer channelBuff){
		setGuild(readObject(channelBuff,com.ks.protocol.vo.guild.GuildVO.class));
		setSkills(new java.util.ArrayList<com.ks.protocol.vo.guild.GuildSkillVO>());
		int p1000=channelBuff.readShort();
		for(int i1000=0;i1000<p1000;i1000++){
			getSkills().add(readObject(channelBuff,com.ks.protocol.vo.guild.GuildSkillVO.class));
		}
		setApply(readObject(channelBuff,com.ks.protocol.vo.guild.GuildApplyVO.class));
		setGuildMember(readObject(channelBuff,com.ks.protocol.vo.guild.GuildMemberVO.class));
		setAccuse(readObject(channelBuff,com.ks.protocol.vo.guild.GuildAccuseVO.class));
		setCdrLastLoginTime(channelBuff.readLong());
	}
	public Object copy(){return new GuildInfoVOProxy();}
}