package com.ks.protocol.vo.fight;

import com.ks.model.fight.FightAtkMode;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;
import com.ks.protocol.vo.fight.skill.FightSkillVO;
/**
 * 攻击模式
 * @author ks
 */
public class FightAtkModeVO extends Message {

	private static final long serialVersionUID = 1L;
	
	private int id;
	@FieldDesc(desc="攻击模型")
	private String atkMode;
	@FieldDesc(desc="移动模型")
	private String moveModel;
	@FieldDesc(desc="持续回合")
	private int cd;
	@FieldDesc(desc="回合")
	private int round;
	@FieldDesc(desc="战斗技能vo")
	private FightSkillVO skill;
	
	public void init(FightAtkMode o){
		this.id = o.getId();
		this.atkMode = o.getAtkMode();
		this.moveModel = o.getMoveMode();
		this.cd = o.getCd();
		this.round = o.getRound();
		if(o.getSkill()!=null){
			skill = MessageFactory.getMessage(FightSkillVO.class);
			skill.init(o.getSkill());
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAtkMode() {
		return atkMode;
	}
	public void setAtkMode(String atkMode) {
		this.atkMode = atkMode;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public FightSkillVO getSkill() {
		return skill;
	}
	public void setSkill(FightSkillVO skill) {
		this.skill = skill;
	}
	public String getMoveModel() {
		return moveModel;
	}
	public void setMoveModel(String moveModel) {
		this.moveModel = moveModel;
	}
	
}
