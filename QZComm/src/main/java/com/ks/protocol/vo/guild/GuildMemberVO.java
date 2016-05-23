package com.ks.protocol.vo.guild;

import com.ks.db.model.GuildMember;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.user.UserBaseinfoVO;
/**
 * 公会成员
 * @author ks
 */
public abstract class GuildMemberVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="用户编号")
	private int userId;
	@FieldDesc(desc="公会编号")
	private int guildId;
	@FieldDesc(desc="属性")
	private int property;
	@FieldDesc(desc="贡献")
	private int devote;
	@FieldDesc(desc="今日贡献")
	private int todayDevote;
	@FieldDesc(desc="用户基本信息")
	private UserBaseinfoVO info;
	public void init(GuildMember o){
		this.userId = o.getUserId();
		this.guildId = o.getGuildId();
		this.property = o.getProperty();
		this.devote = o.getDevote();
		this.todayDevote = o.getTodayDevote();
	}

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
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
		this.property = property;
	}
	public int getDevote() {
		return devote;
	}
	public void setDevote(int devote) {
		this.devote = devote;
	}
	public int getTodayDevote() {
		return todayDevote;
	}
	public void setTodayDevote(int todayDevote) {
		this.todayDevote = todayDevote;
	}
	public UserBaseinfoVO getInfo() {
		return info;
	}
	public void setInfo(UserBaseinfoVO info) {
		this.info = info;
	}
	
}
