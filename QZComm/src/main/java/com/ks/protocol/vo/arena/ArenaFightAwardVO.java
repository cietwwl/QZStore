package com.ks.protocol.vo.arena;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class ArenaFightAwardVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="勇气值")
	private int valour;
	@FieldDesc(desc="经验奖励")
	private int exp;
	@FieldDesc(desc="当前连胜场次")
	private int streakWin;
	@FieldDesc(desc="是否胜利")
	private boolean win;
	
	public int getValour() {
		return valour;
	}
	public void setValour(int valour) {
		this.valour = valour;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getStreakWin() {
		return streakWin;
	}
	public void setStreakWin(int streakWin) {
		this.streakWin = streakWin;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	
	
}
