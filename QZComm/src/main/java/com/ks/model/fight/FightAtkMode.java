package com.ks.model.fight;

import java.io.Serializable;
/**
 * 战斗攻击模型
 * @author ks
 */
public class FightAtkMode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	/**攻击模型*/
	private String atkMode;
	/**移动模型*/
	private String moveMode;
	/**持续回合*/
	private int cd;
	/**回合*/
	private int round;
	/**技能*/
	private FightSkill skill;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FightSkill getSkill() {
		return skill;
	}
	public void setSkill(FightSkill skill) {
		this.skill = skill;
	}
	public String getMoveMode() {
		return moveMode;
	}
	public void setMoveMode(String moveMode) {
		this.moveMode = moveMode;
	}
	
}
