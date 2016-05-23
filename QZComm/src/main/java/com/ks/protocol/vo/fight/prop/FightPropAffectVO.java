package com.ks.protocol.vo.fight.prop;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 战斗道具影响
 * @author ks
 */
public class FightPropAffectVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="战斗道具影响")
	private int fightPropId;
	@FieldDesc(desc="影响的英雄")
	private int fightId;
	@FieldDesc(desc="影响值")
	private int value;
	public int getFightPropId() {
		return fightPropId;
	}
	public void setFightPropId(int fightPropId) {
		this.fightPropId = fightPropId;
	}
	public int getFightId() {
		return fightId;
	}
	public void setFightId(int fightId) {
		this.fightId = fightId;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
