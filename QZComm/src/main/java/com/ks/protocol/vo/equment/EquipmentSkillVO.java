package com.ks.protocol.vo.equment;


import com.ks.db.model.EquipmentSkill;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月9日 上午11:01:32
 * 类说明
 */
public class EquipmentSkillVO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="装备附加属性")
	private int equipmentSkillId;
	@FieldDesc(desc="装备附加属性值")
	private double skillValue;
	
	public void init(EquipmentSkill es){
		this.equipmentSkillId=es.getEquipmentSkillId();
		this.skillValue=es.getSkillValue();
	}
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
