package com.ks.db.cfg;

import java.io.Serializable;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月9日 上午11:01:32
 * 类说明
 */
public class EternalSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	/**武魂属性Id*/
	private int enternalSkillId;
	/**技能值*/
	private double skillValue;
	public int getEternalSkillId() {
		return enternalSkillId;
	}
	public void setEternalSkillId(int equipmentSkillId) {
		this.enternalSkillId = equipmentSkillId;
	}
	public double getSkillValue() {
		return skillValue;
	}
	public void setSkillValue(double skillValue) {
		this.skillValue = skillValue;
	}
}
