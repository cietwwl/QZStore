package com.ks.protocol.vo.guild;

import com.ks.db.model.GuildApply;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public abstract class GuildApplyVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="公会编号")
	private int guildId;
	@FieldDesc(desc="用户基本信息")
	private UserBaseinfoVO baseinfo;
	@FieldDesc(desc="创建时间")
	private long createTime;
	public void init(GuildApply o){
		this.guildId = o.getGuildId();
		baseinfo = MessageFactory.getMessage(UserBaseinfoVO.class);
		baseinfo.init(o.getBaseInfo());
		this.createTime = o.getCreateTime().getTime();
	}
	
	public int getGuildId() {
		return guildId;
	}
	public void setGuildId(int guildId) {
		this.guildId = guildId;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public UserBaseinfoVO getBaseinfo() {
		return baseinfo;
	}
	public void setBaseinfo(UserBaseinfoVO baseinfo) {
		this.baseinfo = baseinfo;
	}
	
	
}
