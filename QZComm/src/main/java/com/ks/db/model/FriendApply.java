package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;

@Data
@DBBeanSet(tablename="t_friend_apply", primaryKey={"user_id", "apply_user_id"})
public class FriendApply implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**好友编号*/
	@DBFieldSet(dbfname="apply_user_id")
	private int applyUserId;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	
}
