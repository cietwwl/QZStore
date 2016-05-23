package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 好友
 * @author ks
 */
@DBBeanSet(primaryKey={"user_id", "friend_id"})
public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**好友编号*/
	@DBFieldSet(dbfname="friend_id")
	private int friendId;
	/**状态*/
	@DBFieldSet(dbfname="state")
	private int state;
	/**使用次数*/
	@DBFieldSet(dbfname="use_count")
	private int useCount;
	/**友好度*/
	@DBFieldSet(dbfname="friendly_degrees")
	private int friendlyDegrees;
	/**最后刷新时间*/
	@DBFieldSet(dbfname="last_ref_time")
	private Date lastRefTime = new Date();
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
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
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
	public int getUseCount() {
		return useCount;
	}
	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}
	public int getFriendlyDegrees() {
		return friendlyDegrees;
	}
	public void setFriendlyDegrees(int friendlyDegrees) {
		this.friendlyDegrees = friendlyDegrees;
	}
	public Date getLastRefTime() {
		return lastRefTime;
	}
	public void setLastRefTime(Date lastRefTime) {
		this.lastRefTime = lastRefTime;
	}
	
}
