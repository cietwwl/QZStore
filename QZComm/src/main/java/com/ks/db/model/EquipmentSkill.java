package com.ks.db.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月9日 上午11:01:32
 * 类说明
 */
@Data
public class EquipmentSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	/**装备附加属性*/
	private int equipmentSkillId;
	/**装备附加属性值*/
	private double skillValue;
}
