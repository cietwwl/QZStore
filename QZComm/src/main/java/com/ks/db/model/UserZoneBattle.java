package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 用户战场
 * @author ks
 */
@DBBeanSet(primaryKey={"user_id", "zone_id", "zone_battle_id"})
public class UserZoneBattle implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**副本编号*/
	@DBFieldSet(dbfname="zone_id")
	private int zoneId;
	/**战场编号*/
	@DBFieldSet(dbfname="zone_battle_id")
	private int zoneBattleId;
	/**挑战次数*/
	@DBFieldSet(dbfname="challenge_count")
	private int challengeCount;
	/**通关次数*/
	@DBFieldSet(dbfname="pass_count")
	private int passCount;
	/**星数*/
	@DBFieldSet(dbfname="star")
	private int star;
	/**最后挑战时间*/
	@DBFieldSet(dbfname="last_challenge_time")
	private Date lastChallengeTime = new Date();
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getZoneBattleId() {
		return zoneBattleId;
	}
	public void setZoneBattleId(int zoneBattleId) {
		this.zoneBattleId = zoneBattleId;
	}
	public int getChallengeCount() {
		return challengeCount;
	}
	public void setChallengeCount(int challengeCount) {
		this.challengeCount = challengeCount;
	}
	public int getPassCount() {
		return passCount;
	}
	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}
	public Date getLastChallengeTime() {
		return lastChallengeTime;
	}
	public void setLastChallengeTime(Date lastChallengeTime) {
		this.lastChallengeTime = lastChallengeTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	
}
