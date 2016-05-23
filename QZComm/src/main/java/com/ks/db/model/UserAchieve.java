package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 用户成就
 *
 */
@DBBeanSet(primaryKey={"user_id", "achieve_id"})
public class UserAchieve implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**成就编号*/
	@DBFieldSet(dbfname="achieve_id")
	private int achieveId;
	/**成就类型*/
	@DBFieldSet(dbfname="achieve_type")
	private int achieveType;
	/**关联编号*/
	@DBFieldSet(dbfname="ass_id")
	private int assId;
	/**当前数量*/
	@DBFieldSet(dbfname="num")
	private int num;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAchieveId() {
		return achieveId;
	}
	public void setAchieveId(int achieveId) {
		this.achieveId = achieveId;
	}
	public int getAchieveType() {
		return achieveType;
	}
	public void setAchieveType(int achieveType) {
		this.achieveType = achieveType;
	}
	public int getAssId() {
		return assId;
	}
	public void setAssId(int assId) {
		this.assId = assId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	
}
