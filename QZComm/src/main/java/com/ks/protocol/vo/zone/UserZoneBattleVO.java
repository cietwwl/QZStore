package com.ks.protocol.vo.zone;

import com.ks.db.model.UserZoneBattle;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 用户副本战场
 * @author ks
 */
public class UserZoneBattleVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="副本编号")
	private int zoneId;
	@FieldDesc(desc="战场编号")
	private int zoneBattleId;
	@FieldDesc(desc="挑战次数")
	private int challengeCount;
	@FieldDesc(desc="通关次数")
	private int passCount;
	@FieldDesc(desc="星数")
	private int star;
	
	public void init(UserZoneBattle o){
		this.zoneId = o.getZoneId();
		this.zoneBattleId = o.getZoneBattleId();
		this.challengeCount = o.getChallengeCount();
		this.passCount = o.getPassCount();
		this.star = o.getStar();
	}

	
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
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
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
}
