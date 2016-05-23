package com.ks.logic.service;

import java.util.List;

import com.ks.db.cfg.PassiveSkill;
import com.ks.db.cfg.Skill;
import com.ks.db.cfg.SkillEffect;

/**
 * 技能服务
 * @author ks
 */
public interface SkillService {
	/**
	 * 查询技能
	 * @return 所有技能
	 */
	List<Skill> querySkills();
	/**
	 * 查询所有技能效果
	 * @return 所有技能效果
	 */
	List<SkillEffect> querySkillEffects();
	/**
	 * 查询被动技能
	 * @return 被动技能
	 */
	List<PassiveSkill> queryPassiveSkill();
}
