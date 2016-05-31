package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 好友
 * @author ks
 */
@Data
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
	
}
