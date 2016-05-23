package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 竞技场日志
 *
 */
@DBBeanSet(primaryKey="id")
public class ArenaLogger implements Serializable {
	private static final long serialVersionUID = 1L;
	/**主键id*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**用户id*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**用户名称*/
	@DBFieldSet(dbfname="user_name")
	private String userName;
	/**对手名称*/
	@DBFieldSet(dbfname="match_user_name")
	private String matchUserName;
	/**对手名称*/
	@DBFieldSet(dbfname="match_level")
	private int matchLevel;
	/**对手id*/
	@DBFieldSet(dbfname="match_user_id")
	private int matchUserId;
	/**胜败*/
	@DBFieldSet(dbfname="win_los")
	private int winLos;
	/**挑战时的队长id*/
	@DBFieldSet(dbfname="cap_id")
	private int capId;
	/**挑战时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**日志类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMatchUserName() {
		return matchUserName;
	}
	public void setMatchUserName(String matchUserName) {
		this.matchUserName = matchUserName;
	}
	public int getMatchLevel() {
		return matchLevel;
	}
	public void setMatchLevel(int matchLevel) {
		this.matchLevel = matchLevel;
	}
	public int getMatchUserId() {
		return matchUserId;
	}
	public void setMatchUserId(int matchUserId) {
		this.matchUserId = matchUserId;
	}
	public int getWinLos() {
		return winLos;
	}
	public void setWinLos(int winLos) {
		this.winLos = winLos;
	}
	public int getCapId() {
		return capId;
	}
	public void setCapId(int capId) {
		this.capId = capId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
