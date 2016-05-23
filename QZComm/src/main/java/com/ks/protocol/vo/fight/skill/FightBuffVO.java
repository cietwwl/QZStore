package com.ks.protocol.vo.fight.skill;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.model.fight.FightBuff;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

@EqualsAndHashCode(callSuper=true)
@Data
public abstract class FightBuffVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="编号")
	private int id;
	@FieldDesc(desc="效果编号")
	private int effectId;
	@FieldDesc(desc="分数")
	private int score;
	@FieldDesc(desc="实数")
	private int cons;
	@FieldDesc(desc="持续回合")
	private int round;
	@FieldDesc(desc="状态")
	private int state;
	@FieldDesc(desc="产生标识")
	private String uuid;
	@FieldDesc(desc="触发buff出手方id")
	private int shotUserId;
	public void init(FightBuff o){
		this.id = o.getId();
		this.effectId = o.getEffectId();
		this.score = o.getScore();
		this.cons = o.getCons();
		this.round = o.getRound();
		this.state = o.getState();
		this.uuid = o.getUuid();
		this.shotUserId = o.getShotUserId();
	}
	
	
}
