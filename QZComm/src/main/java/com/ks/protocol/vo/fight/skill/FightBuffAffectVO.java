package com.ks.protocol.vo.fight.skill;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.DropVO;
/**
 * buff影响
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
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
	@FieldDesc(desc="伤害效果类型,请参照技能效果类型id")
	private List<Integer> atkEffectIds;
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
	
	public void addAtkEffectId(int effectId){
		if(atkEffectIds == null){
			atkEffectIds = new ArrayList<Integer>();
		}
		atkEffectIds.add(effectId);
	}
}
