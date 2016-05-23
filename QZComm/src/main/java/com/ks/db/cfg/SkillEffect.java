package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 技能效果
 *
 */
@DBBeanSet(tablename="t_skill_effect",  createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class SkillEffect implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 编号 */
	@DBFieldSet(dbfname="id")
	private int id;
	/** 技能编号 */
	@DBFieldSet(dbfname="skill_id")
	private int skillId;
	/** 等级 */
	@DBFieldSet(dbfname="lv")
	private int lv;
	/** 状态 */
	@DBFieldSet(dbfname="state")
	private int state;
	/** 效果编号 */
	@DBFieldSet(dbfname="effect_id")
	private int effectId;
	/** 分数 */
	@DBFieldSet(dbfname="score")
	private int score;
	/** 实数 */
	@DBFieldSet(dbfname="cons")
	private int cons;
	/** 持续回合 */
	@DBFieldSet(dbfname="round")
	private int round;
	/** 对象 */
	@DBFieldSet(dbfname="target")
	private int target;
	/** 范围 */
	@DBFieldSet(dbfname="range")
	private String range;
	/** 随机 */
	@DBFieldSet(dbfname="random")
	private int random;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getEffectId() {
		return effectId;
	}

	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCons() {
		return cons;
	}

	public void setCons(int cons) {
		this.cons = cons;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
