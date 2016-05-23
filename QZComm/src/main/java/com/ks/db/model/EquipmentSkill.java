package com.ks.db.model;

import java.io.Serializable;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月9日 上午11:01:32
 * 类说明
 */
public class EquipmentSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	/**装备附加属性*/
	private int equipmentSkillId;
	/**装备附加属性值*/
	private double skillValue;
	public int getEquipmentSkillId() {
		return equipmentSkillId;
	}
	public void setEquipmentSkillId(int equipmentSkillId) {
		this.equipmentSkillId = equipmentSkillId;
	}
	public double getSkillValue() {
		return skillValue;
	}
	public void setSkillValue(double skillValue) {
		this.skillValue = skillValue;
	}
	

}
