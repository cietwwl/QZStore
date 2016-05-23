package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.constant.SystemConstant;
import com.ks.model.user.UserBaseinfo;
/**
 * 公会
 * @author ks
 */
@DBBeanSet(tablename="t_guild", primaryKey={"guild_id"})
public class Guild implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**公会编号*/
	@DBFieldSet(dbfname="guild_id")
	private int guildId;
	/**公会名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**会长编号*/
	@DBFieldSet(dbfname="cdr_user_id")
	private int cdrUserId;
	/**成员数量*/
	@DBFieldSet(dbfname="member_num")
	private int memberNum;
	/**经验*/
	@DBFieldSet(dbfname="exp")
	private int exp;
	/**技能点*/
	@DBFieldSet(dbfname="skill_point")
	private int skillPoint;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	/**会长基本信息*/
	private UserBaseinfo cdrBaseInfo;
	/**
	 * 获得公会等级
	 * @return 公会等级
	 */
	public int getGuildLevel(){
		for(int i = 0; i < SystemConstant.GUILD_LEVEL_EXP.length; i++){
			if(exp < SystemConstant.GUILD_LEVEL_EXP[i]){
				return i+1;
			}
		}
		return SystemConstant.GUILD_LEVEL_EXP.length;
	}
	
	/**
	 * 获得总公会人数
	 * @return 总公会人数
	 */
	public int getMaxMemberNum(){
		return getGuildLevel()*5+15;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCdrUserId() {
		return cdrUserId;
	}
	public void setCdrUserId(int cdrUserId) {
		this.cdrUserId = cdrUserId;
	}
	public UserBaseinfo getCdrBaseInfo() {
		return cdrBaseInfo;
	}
	public void setCdrBaseInfo(UserBaseinfo cdrBaseInfo) {
		this.cdrBaseInfo = cdrBaseInfo;
	}
	
}
