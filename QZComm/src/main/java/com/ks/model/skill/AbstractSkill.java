package com.ks.model.skill;

import java.util.List;

import com.ks.db.cfg.SkillEffect;
/**
 * 技能
 * @author ks
 */
public abstract class AbstractSkill {
	/**技能编号*/
	private int skillId;
	/**等级*/
	private int lv=1;
	/**技能效果*/
	private List<SkillEffect> effects;
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
	public List<SkillEffect> getEffects() {
		return effects;
	}
	public void setEffects(List<SkillEffect> effects) {
		this.effects = effects;
	}
	
	
}
