package com.ks.protocol.vo.martial;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class MartialWayFightAwardVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="积分")
	private int score;
	@FieldDesc(desc="是否首胜")
	private boolean firstWin;
	@FieldDesc(desc="经验奖励")
	private int exp;
	@FieldDesc(desc="是否胜利")
	private boolean win;
	@FieldDesc(desc="连胜")
	private int winStreak;
	
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isFirstWin() {
		return firstWin;
	}
	public void setFirstWin(boolean firstWin) {
		this.firstWin = firstWin;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	public int getWinStreak() {
		return winStreak;
	}
	public void setWinStreak(int winStreak) {
		this.winStreak = winStreak;
	}
	
}
