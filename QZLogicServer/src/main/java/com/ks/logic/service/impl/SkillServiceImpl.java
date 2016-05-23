package com.ks.logic.service.impl;

import java.util.List;

import com.ks.db.cfg.PassiveSkill;
import com.ks.db.cfg.Skill;
import com.ks.db.cfg.SkillEffect;
import com.ks.logic.service.BaseService;
import com.ks.logic.service.SkillService;

public class SkillServiceImpl extends BaseService implements SkillService {

	@Override
	public List<Skill> querySkills() {
		return skillDAO.querySkills();
	}

	@Override
	public List<SkillEffect> querySkillEffects() {
		return skillDAO.querySkillEffects();
	}

	@Override
	public List<PassiveSkill> queryPassiveSkill() {
		return skillDAO.queryPassiveSkill();
	}

}
