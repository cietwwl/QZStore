package com.ks.protocol.vo.eternal;

import com.ks.db.cfg.EternalSkill;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;

/**
 * @author fengpeng E-mail:fengpeng_15@163.com
 * @version 创建时间：2015年4月9日 上午11:01:32
 * 类说明
 */
public class EaternalSkillVO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc(desc="武魂属性Id")
	private int enternalSkillId;
	@FieldDesc(desc="技能值")
	private double skillValue;
	
	
	public void init(EternalSkill o){
		this.enternalSkillId = o.getEternalSkillId();
		this.skillValue = o.getSkillValue();
	}


	public int getEnternalSkillId() {
		return enternalSkillId;
	}


	public void setEnternalSkillId(int enternalSkillId) {
		this.enternalSkillId = enternalSkillId;
	}


	public double getSkillValue() {
		return skillValue;
	}


	public void setSkillValue(double skillValue) {
		this.skillValue = skillValue;
	}


	

}
