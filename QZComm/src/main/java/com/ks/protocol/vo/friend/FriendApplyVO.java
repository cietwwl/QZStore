package com.ks.protocol.vo.friend;

import com.ks.protocol.Message;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public class FriendApplyVO extends Message {

	private static final long serialVersionUID = 1L;
	
	private long time;
	
	private UserBaseinfoVO infos;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public UserBaseinfoVO getInfos() {
		return infos;
	}

	public void setInfos(UserBaseinfoVO infos) {
		this.infos = infos;
	}
	
	
}
