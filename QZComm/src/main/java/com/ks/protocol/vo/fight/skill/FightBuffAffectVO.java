package com.ks.protocol.vo.fight.skill;

import java.util.ArrayList;
import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.DropVO;
/**
 * buff影响
 * @author ks
 */
public abstract class FightBuffAffectVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="战斗编号")
	private int fightId;
	@FieldDesc(desc="buff编号")
	private int effectId;
	@FieldDesc(desc="类型")
	private int valType;
	@FieldDesc(desc="值")
	private int val;
	@FieldDesc(desc="吸收伤害")
	private int absorbHurt;
	@FieldDesc(desc="剩余血量")
	private int surHp;
	@FieldDesc(desc="掉落")
	private List<DropVO> drops;
	@FieldDesc(desc="释放技能")
	private List<ReleaseSkillVO> relSkill=new ArrayList<ReleaseSkillVO>();
	public static final FightBuffAffectVO create(int fightId,int effectId, int valType, int val, int absorbHurt,int surHp){
		FightBuffAffectVO vo = MessageFactory.getMessage(FightBuffAffectVO.class);
		vo.setFightId(fightId);
		vo.setEffectId(effectId);
		vo.setVal(val);
		vo.setValType(valType);
		vo.setAbsorbHurt(absorbHurt);
		vo.setDrops(new ArrayList<DropVO>());
		vo.setSurHp(surHp);
		return vo;
	}
	
	public int getFightId() {
		return fightId;
	}

	public void setFightId(int fightId) {
		this.fightId = fightId;
	}

	public int getEffectId() {
		return effectId;
	}
	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}
	public int getValType() {
		return valType;
	}
	public void setValType(int valType) {
		this.valType = valType;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public int getAbsorbHurt() {
		return absorbHurt;
	}
	public void setAbsorbHurt(int absorbHurt) {
		this.absorbHurt = absorbHurt;
	}
	public List<DropVO> getDrops() {
		return drops;
	}
	public void setDrops(List<DropVO> drops) {
		this.drops = drops;
	}

	public int getSurHp() {
		return surHp;
	}

	public void setSurHp(int surHp) {
		this.surHp = surHp;
	}

	public List<ReleaseSkillVO> getRelSkill() {
		return relSkill;
	}

	public void setRelSkill(List<ReleaseSkillVO> relSkill) {
		this.relSkill = relSkill;
	}
	
}
