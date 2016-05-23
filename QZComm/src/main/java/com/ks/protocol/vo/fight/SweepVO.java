package com.ks.protocol.vo.fight;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

public class SweepVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="金币")
	private int gold;
	@FieldDesc(desc="经验")
	private int exp;
	@FieldDesc(desc="掉落")
	private List<DropVO> drops;
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public List<DropVO> getDrops() {
		return drops;
	}
	public void setDrops(List<DropVO> drops) {
		this.drops = drops;
	}
}
