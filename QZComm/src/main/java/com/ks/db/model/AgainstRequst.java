package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

import lombok.Data;
/**
 * 对战请求
 * @author ks
 */
@Data
@DBBeanSet(tablename="t_against_requst", primaryKey={"user_id"})
public class AgainstRequst implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**对战用户编号*/
	@DBFieldSet(dbfname="against_user_id")
	private int againstUserId;
	/**对战类型*/
	@DBFieldSet(dbfname="against_type")
	private int againstType;
	/**请求对战时间*/
	@DBFieldSet(dbfname="against_time")
	private Date againstTime = new Date();
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	private Date updateTime = new Date();
}
