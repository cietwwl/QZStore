package com.ks.protocol.vo.fight.skill;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;

@EqualsAndHashCode(callSuper=true)
@Data
public abstract class ReleaseSkillVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="释放的技能")
	private int skillId;
	@FieldDesc(desc="技能等级")
	private int skillLevel;
	@FieldDesc(desc="释放者编号")
	private int fightId;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="受影响者")
	private List<AffectederVO> affs;
	@FieldDesc(desc="攻击力")
	private int atk;
	public static final ReleaseSkillVO create(){
		ReleaseSkillVO rsVO = MessageFactory.getMessage(ReleaseSkillVO.class);
		rsVO.setAffs(new ArrayList<AffectederVO>());
		return rsVO;
	}
	
	
}
