package com.ks.protocol.vo.fight.skill;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.DropVO;
import com.ks.protocol.vo.fight.PointVO;
/**
 * 被影响者
 * @author ks
 */
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class AffectederVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="伤害")
	public static final int TYPE_HURT = 1;
	@FieldDesc(desc="回血")
	public static final int TYPE_RECOVER = 2;
	
	@FieldDesc(desc="战斗编号")
	private int fightId;
	@FieldDesc(desc="类型")
	private int type;
	@FieldDesc(desc="值")
	private int val;
	@FieldDesc(desc="剩余hp")
	private int surHp;
	@FieldDesc(desc="吸收伤害")
	private int absorbHurt;
	@FieldDesc(desc="增加的buff")
	private FightBuffVO buff;
	@FieldDesc(desc="击退到的坐标")
	private List<PointVO> coors;
	@FieldDesc(desc="掉落")
	private List<DropVO> drops;
	@FieldDesc(desc="释放技能")
	private List<ReleaseSkillVO> relSkill;
	@FieldDesc(desc="伤害效果类型,请参照技能效果类型id")
	private List<Integer> atkEffectIds;
	
	public static final AffectederVO create(){
		AffectederVO vo = MessageFactory.getMessage(AffectederVO.class);
		vo.setCoors(new ArrayList<PointVO>());
		vo.setDrops(new ArrayList<DropVO>());
		vo.relSkill=new ArrayList<ReleaseSkillVO>();
		return vo;
	}
	public void addAtkEffectId(int effectId){
		if(atkEffectIds == null){
			atkEffectIds = new ArrayList<Integer>();
		}
		atkEffectIds.add(effectId);
	}
}
