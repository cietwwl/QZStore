package com.ks.protocol.vo.guild;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 公会信息
 * @author ks
 */
public abstract class GuildInfoVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="公会")
	private GuildVO guild;
	@FieldDesc(desc="技能")
	private List<GuildSkillVO> skills;
	@FieldDesc(desc="申请")
	private GuildApplyVO apply;
	@FieldDesc(desc="我的公会信息")
	private GuildMemberVO guildMember;
	@FieldDesc(desc="弹劾")
	private GuildAccuseVO accuse;
	@FieldDesc(desc="会长最后上线时间")
	private long cdrLastLoginTime;
	public GuildVO getGuild() {
		return guild;
	}
	public void setGuild(GuildVO guild) {
		this.guild = guild;
	}
	public List<GuildSkillVO> getSkills() {
		return skills;
	}
	public void setSkills(List<GuildSkillVO> skills) {
		this.skills = skills;
	}
	public GuildApplyVO getApply() {
		return apply;
	}
	public void setApply(GuildApplyVO apply) {
		this.apply = apply;
	}
	public GuildMemberVO getGuildMember() {
		return guildMember;
	}
	public void setGuildMember(GuildMemberVO guildMember) {
		this.guildMember = guildMember;
	}
	public GuildAccuseVO getAccuse() {
		return accuse;
	}
	public void setAccuse(GuildAccuseVO accuse) {
		this.accuse = accuse;
	}
	public long getCdrLastLoginTime() {
		return cdrLastLoginTime;
	}
	public void setCdrLastLoginTime(long cdrLastLoginTime) {
		this.cdrLastLoginTime = cdrLastLoginTime;
	}
	
}
