package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 用户buff
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_user_buff", primaryKey={"user_id", "effect_id"})
public class UserBuff implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**效果编号*/
	@DBFieldSet(dbfname="effect_id")
	private int effectId;
	/**值*/
	@DBFieldSet(dbfname="val")
	private int val;
	/**cd*/
	@DBFieldSet(dbfname="cd")
	private int cd;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
}
