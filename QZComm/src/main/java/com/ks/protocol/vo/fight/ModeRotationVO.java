package com.ks.protocol.vo.fight;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 攻击模型轮换
 * @author ks
 */
public class ModeRotationVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="战斗模型编号")
	private int fightId;
	@FieldDesc(desc="攻击模型编号")
	private int modeId;
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public int getModeId() {
		return modeId;
	}
	public void setModeId(int modeId) {
		this.modeId = modeId;
	}
}
