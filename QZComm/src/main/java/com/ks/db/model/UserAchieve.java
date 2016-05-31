package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;

/**
 * 用户成就
 *
 */
@Data
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
}
