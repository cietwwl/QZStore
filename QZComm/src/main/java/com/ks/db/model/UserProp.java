package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisFieldSet;
/***
 * 用户道具
 * @author ks
 */
@Data
@DBBeanSet(tablename_prefix="t_user_prop_", primaryKey={"id"})
public class UserProp implements Serializable {
	private static final long serialVersionUID = 1L;
	/**主键*/
	@DBFieldSet(dbfname="id")
	@JedisFieldSet()
	private int id;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet()
	private int userId;
	/**道具编号*/
	@DBFieldSet(dbfname="prop_id")
	@JedisFieldSet()
	private int propId;
	/**数量*/
	@DBFieldSet(dbfname="num")
	@JedisFieldSet()
	private int num;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	@JedisFieldSet()
	private Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet()
	private Date updateTime = new Date();
	/**是否修改过*/
	@JedisFieldSet()
	private boolean update;

	
}
