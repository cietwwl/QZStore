package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
/**
 * 附加伤害
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class SubHurtVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="被攻击者战斗编号")
	private int defFightId;
	@FieldDesc(desc="伤害")
	private int hurt;
	@FieldDesc(desc="吸收伤害")
	private int absorbHurt;
	@FieldDesc(desc="剩余血量")
	private int surHp;
	@FieldDesc(desc="掉落")
	private List<DropVO> drops;
	@FieldDesc(desc="伤害效果类型,请参照技能效果类型id")
	private List<Integer> atkEffectIds;
	public void addAtkEffectId(int effectId){
		if(atkEffectIds == null){
			atkEffectIds = new ArrayList<Integer>();
		}
		atkEffectIds.add(effectId);
	}
}
