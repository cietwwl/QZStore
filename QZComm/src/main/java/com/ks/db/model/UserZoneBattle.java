package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 用户战场
 * @author ks
 */
@Data
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
	
	
}
