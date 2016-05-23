package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.model.user.UserBaseinfo;
/**
 * 公会申请
 * @author ks
 */
@DBBeanSet(tablename="t_guild_apply", primaryKey={"user_id"})
public class GuildApply implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	private int userId;
	/**公会编号*/
	@DBFieldSet(dbfname="guild_id")
	private int guildId;
	/**创建时间*/
	@DBFieldSet(dbfname="create_time")
	private Date createTime = new Date();
	/**用户基本信息*/
	private UserBaseinfo baseInfo;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGuildId() {
		return guildId;
	}
	public void setGuildId(int guildId) {
		this.guildId = guildId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public UserBaseinfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(UserBaseinfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	
}
