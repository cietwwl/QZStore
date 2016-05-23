package com.ks.protocol.vo.martial;

import com.ks.model.martial.MartialWay;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class MartialWayVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="积分")
	private short score;
	@FieldDesc(desc="胜场")
	private short winCount;
	@FieldDesc(desc="连胜")
	private short winStreak;
	@FieldDesc(desc="排名")
	private int rank;
	
	public void init(MartialWay o,int rank){
		this.score = o.getScore();
		this.winCount = o.getWinCount();
		this.winStreak = o.getWinStreak();
		this.rank = rank;
		if(winStreak!=0){
			winStreak-=1;
		}
	}
	
	public short getScore() {
		return score;
	}
	public void setScore(short score) {
		this.score = score;
	}
	public short getWinCount() {
		return winCount;
	}
	public void setWinCount(short winCount) {
		this.winCount = winCount;
	}
	public short getWinStreak() {
		return winStreak;
	}
	public void setWinStreak(short winStreak) {
		this.winStreak = winStreak;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
