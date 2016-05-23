package com.ks.protocol.vo.fight;

import java.util.ArrayList;
import java.util.List;

import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.prop.FightPropAffectVO;
import com.ks.protocol.vo.fight.prop.FightPropRefVO;
import com.ks.protocol.vo.fight.skill.FightBuffAffectVO;
import com.ks.protocol.vo.fight.skill.ReleaseSkillVO;
/**
 * 攻击回合
 * @author ks
 */
public class AttackRoundVO extends Message {

	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="移动")
	private MoveVO move;
	@FieldDesc(desc="下一个出手方编号")
	private int nextShotUserId;
	@FieldDesc(desc="被攻击者")
	private List<AttackedVO> attackeds;
	@FieldDesc(desc="模型轮换")
	private List<ModeRotationVO> rotations;
	@FieldDesc(desc="替补上阵")
	private SubFightBattleVO subFightBattleVO;
	@FieldDesc(desc="乱入的怪物")
	private FightModelVO disMonster;
	@FieldDesc(desc="下一次战斗")
	private FightVO nextFight;
	@FieldDesc(desc="道具影响")
	private List<FightPropAffectVO> affects;
	@FieldDesc(desc="战斗道具刷新")
	private List<FightPropRefVO> propRefs;
	@FieldDesc(desc="释放技能")
	private List<ReleaseSkillVO> relSkill;
	@FieldDesc(desc="战斗buff影响")
	private List<FightBuffAffectVO> buffAffects;
	@FieldDesc(desc="弹射")
	private List<CatapultVO> catapult;
	
	public static final AttackRoundVO create(){
		AttackRoundVO round = MessageFactory.getMessage(AttackRoundVO.class);
		round.setAttackeds(new ArrayList<AttackedVO>());
		round.setAffects(new ArrayList<FightPropAffectVO>());
		round.setPropRefs(new ArrayList<FightPropRefVO>());
		round.setRelSkill(new ArrayList<ReleaseSkillVO>());
		round.setBuffAffects(new ArrayList<FightBuffAffectVO>());
		round.setCatapult(new ArrayList<CatapultVO>());
		return round;
	}
	
	public int getNextShotUserId() {
		return nextShotUserId;
	}
	public void setNextShotUserId(int nextShotUserId) {
		this.nextShotUserId = nextShotUserId;
	}
	public List<AttackedVO> getAttackeds() {
		return attackeds;
	}
	public void setAttackeds(List<AttackedVO> attackeds) {
		this.attackeds = attackeds;
	}
	public MoveVO getMove() {
		return move;
	}
	public void setMove(MoveVO move) {
		this.move = move;
	}
	public List<ModeRotationVO> getRotations() {
		return rotations;
	}
	public void setRotations(List<ModeRotationVO> rotations) {
		this.rotations = rotations;
	}
	public SubFightBattleVO getSubFightBattleVO() {
		return subFightBattleVO;
	}
	public void setSubFightBattleVO(SubFightBattleVO subFightBattleVO) {
		this.subFightBattleVO = subFightBattleVO;
	}
	public FightModelVO getDisMonster() {
		return disMonster;
	}
	public void setDisMonster(FightModelVO disMonster) {
		this.disMonster = disMonster;
	}
	public FightVO getNextFight() {
		return nextFight;
	}
	public void setNextFight(FightVO nextFight) {
		this.nextFight = nextFight;
	}
	public List<FightPropAffectVO> getAffects() {
		return affects;
	}
	public void setAffects(List<FightPropAffectVO> affects) {
		this.affects = affects;
	}
	public List<FightPropRefVO> getPropRefs() {
		return propRefs;
	}
	public void setPropRefs(List<FightPropRefVO> propRefs) {
		this.propRefs = propRefs;
	}
	public List<ReleaseSkillVO> getRelSkill() {
		return relSkill;
	}
	public void setRelSkill(List<ReleaseSkillVO> relSkill) {
		this.relSkill = relSkill;
	}
	public List<FightBuffAffectVO> getBuffAffects() {
		return buffAffects;
	}
	public void setBuffAffects(List<FightBuffAffectVO> buffAffects) {
		this.buffAffects = buffAffects;
	}

	public List<CatapultVO> getCatapult() {
		return catapult;
	}

	public void setCatapult(List<CatapultVO> catapult) {
		this.catapult = catapult;
	}
	
}
