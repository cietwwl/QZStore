package com.ks.protocol.vo.fight;

import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 弹射伤害
 * @author ks
 */
public class CatapultHurtVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="战场编号")
	private int fightId;
	@FieldDesc(desc="伤害")
	private int hurt;
	@FieldDesc(desc="掉落")
	private List<DropVO> drops;
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public int getHurt() {
		return hurt;
	}
	public void setHurt(int hurt) {
		this.hurt = hurt;
	}
	public List<DropVO> getDrops() {
		return drops;
	}
	public void setDrops(List<DropVO> drops) {
		this.drops = drops;
	}
	
}
