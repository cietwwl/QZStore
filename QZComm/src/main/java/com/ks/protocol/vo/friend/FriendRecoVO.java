package com.ks.protocol.vo.friend;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.user.UserBaseinfoVO;
/**
 * 推荐好友
 * @author ks
 */
public abstract class FriendRecoVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="推荐好友")
	private List<UserBaseinfoVO> recoFriends;
	@FieldDesc(desc="修改时间")
	private long updateTime;
	public List<UserBaseinfoVO> getRecoFriends() {
		return recoFriends;
	}
	public void setRecoFriends(List<UserBaseinfoVO> recoFriends) {
		this.recoFriends = recoFriends;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
}
