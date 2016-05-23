package com.ks.protocol.vo.friend;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.user.UserBaseinfoVO;
/**
 * 好友
 * @author ks
 */
public class FriendVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="使用次数")
	private int useCount;
	@FieldDesc(desc="友好度")
	private int friendlyDegrees;
	@FieldDesc(desc="最后刷新时间")
	private long lastRefTime;
	@FieldDesc(desc="基本信息")
	private UserBaseinfoVO info;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public UserBaseinfoVO getInfo() {
		return info;
	}
	public void setInfo(UserBaseinfoVO info) {
		this.info = info;
	}
	public int getUseCount() {
		return useCount;
	}
	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}
	public int getFriendlyDegrees() {
		return friendlyDegrees;
	}
	public void setFriendlyDegrees(int friendlyDegrees) {
		this.friendlyDegrees = friendlyDegrees;
	}
	public long getLastRefTime() {
		return lastRefTime;
	}
	public void setLastRefTime(long lastRefTime) {
		this.lastRefTime = lastRefTime;
	}
	
}
