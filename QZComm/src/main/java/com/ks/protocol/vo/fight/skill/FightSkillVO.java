package com.ks.protocol.vo.fight.skill;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.model.fight.FightSkill;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 战斗技能
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class FightSkillVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="技能编号")
	private int skillId;
	@FieldDesc(desc="技能等级")
	private int skillLv;
	@FieldDesc(desc="当前回合")
	private int currRound;
	@FieldDesc(desc="触发技能出手方id")
	private int shotUserId;
	public void init(FightSkill o){
		this.skillId = o.getSkillId();
		this.skillLv = o.getSkillLv();
		this.currRound = o.getCurrRound();
		this.shotUserId = o.getShotUserId();
	}
}
