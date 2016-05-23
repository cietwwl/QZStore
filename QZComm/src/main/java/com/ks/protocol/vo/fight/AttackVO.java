package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.fight.skill.ReleaseSkillVO;
/**
 * 攻击者
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class AttackVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="攻击者编号")
	private int attackerId;
	@FieldDesc(desc="伤害类型(1为普通,2为暴击,3为闪避,4为格档)")
	private int hurtType;
	@FieldDesc(desc="伤害")
	private int hurt;
	@FieldDesc(desc="吸收伤害")
	private int absorbHurt;
	@FieldDesc(desc="附加伤害")
	private List<SubHurtVO> subHurts;
	@FieldDesc(desc="释放技能")
	private List<ReleaseSkillVO> relSkill;
	@FieldDesc(desc="攻击力")
	private int atk;
	@FieldDesc(desc="伤害效果类型,请参照技能效果类型id")
	private List<Integer> atkEffectIds;
	public void addAtkEffectId(int effectId){
		if(atkEffectIds == null){
			atkEffectIds = new ArrayList<Integer>();
		}
		atkEffectIds.add(effectId);
	}
}
