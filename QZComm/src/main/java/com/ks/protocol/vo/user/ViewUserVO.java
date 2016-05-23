package com.ks.protocol.vo.user;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.hero.UserHeroVO;

public abstract class ViewUserVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="队伍")
	private UserTeamVO team;
	@FieldDesc(desc="队员")
	private List<UserHeroVO> heros;
	@FieldDesc(desc="公会名称")
	private String guildName;
	@FieldDesc(desc="基础信息")
	private UserBaseinfoVO baseInfo;
	public UserTeamVO getTeam() {
		return team;
	}
	public void setTeam(UserTeamVO team) {
		this.team = team;
	}
	public List<UserHeroVO> getHeros() {
		return heros;
	}
	public void setHeros(List<UserHeroVO> heros) {
		this.heros = heros;
	}
	public String getGuildName() {
		return guildName;
	}
	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}
	public UserBaseinfoVO getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(UserBaseinfoVO baseInfo) {
		this.baseInfo = baseInfo;
	}
	
}
