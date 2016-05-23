package com.ks.protocol.vo.guild;

import com.ks.db.model.Guild;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserBaseinfoVO;
/**
 * 公会
 * @author ks
 */
public abstract class GuildVO extends Message {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="公会编号")
	private int guildId;
	@FieldDesc(desc="公会名称")
	private String name;
	@FieldDesc(desc="成员数量")
	private int memberNum;
	@FieldDesc(desc="经验")
	private int exp;
	@FieldDesc(desc="技能点")
	private int skillPoint;
	@FieldDesc(desc="公会排名")
	private int rank;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="会长基本信息")
	private UserBaseinfoVO cdrBaseInfo;	
	public void init(Guild o,int rank){
		this.guildId = o.getGuildId();
		this.name = o.getName();
		this.memberNum = o.getMemberNum();
		this.exp = o.getExp();
		this.skillPoint = o.getSkillPoint();
		this.rank = rank;
		this.state = o.getState();
		cdrBaseInfo = MessageFactory.getMessage(UserBaseinfoVO.class);
		cdrBaseInfo.init(o.getCdrBaseInfo());
	}
	public int getGuildId() {
		return guildId;
	}
	public void setGuildId(int guildId) {
		this.guildId = guildId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getSkillPoint() {
		return skillPoint;
	}
	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public UserBaseinfoVO getCdrBaseInfo() {
		return cdrBaseInfo;
	}
	public void setCdrBaseInfo(UserBaseinfoVO cdrBaseInfo) {
		this.cdrBaseInfo = cdrBaseInfo;
	}
	
}
