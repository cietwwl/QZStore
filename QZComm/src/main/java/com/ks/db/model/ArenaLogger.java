package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;

/**
 * 竞技场日志
 *
 */
@Data
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

}
