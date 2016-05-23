package com.ks.protocol.vo.arena;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.user.UserBaseinfoVO;

public abstract class ArenaInfoVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="自己的竞技场")
	private ArenaVO myArena;
	@FieldDesc(desc="对手的竞技场")
	private List<UserBaseinfoVO> rivals;
	@FieldDesc(desc="对手刷新时间")
	private long rivalRefTime;
	public List<UserBaseinfoVO> getRivals() {
		return rivals;
	}
	public void setRivals(List<UserBaseinfoVO> rivals) {
		this.rivals = rivals;
	}
	public ArenaVO getMyArena() {
		return myArena;
	}
	public void setMyArena(ArenaVO myArena) {
		this.myArena = myArena;
	}
	public long getRivalRefTime() {
		return rivalRefTime;
	}
	public void setRivalRefTime(long rivalRefTime) {
		this.rivalRefTime = rivalRefTime;
	}
}
