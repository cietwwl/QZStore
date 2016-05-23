package com.ks.protocol.vo.fight;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.vo.fight.skill.ReleaseSkillVO;
/**
 * 被攻击VO
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class AttackedVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="被攻击者编号")
	private int attackederId;
	@FieldDesc(desc="连击次数")
	private int batterCount;
	@FieldDesc(desc="剩余hp")
	private int surHp;
	@FieldDesc(desc="攻击")
	private List<AttackVO> attacks;
	@FieldDesc(desc="掉落")
	private List<DropVO> drops;
	@FieldDesc(desc="释放技能")
	private List<ReleaseSkillVO> relSkill;
	
	
}
