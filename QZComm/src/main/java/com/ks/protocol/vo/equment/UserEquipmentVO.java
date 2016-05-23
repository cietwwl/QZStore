package com.ks.protocol.vo.equment;

import java.util.ArrayList;
import java.util.List;

import com.ks.db.model.EquipmentSkill;
import com.ks.db.model.UserEquipment;
import com.ks.protocol.FieldDesc;
import com.ks.protocol.Message;
import com.ks.protocol.MessageFactory;

public class UserEquipmentVO extends Message {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc(desc="用户装备编号")
	private int userEquipmentId;
	@FieldDesc(desc="装备编号")
	private int equipmentId;
	@FieldDesc(desc="等级")
	private int level;
	@FieldDesc(desc="用户英雄编号")
	private int userHeroId;
	@FieldDesc(desc="装备附加技能")
	private List<EquipmentSkillVO> skills;
	@FieldDesc(desc="装备加成百分比")
	private double addAtk;
	public void init(UserEquipment o){
		this.userEquipmentId = o.getUserEquipmentId();
		this.equipmentId = o.getEquipmentId();
		this.level = o.getLevel();
		this.userHeroId = o.getUserHeroId();
		List<EquipmentSkillVO> list=new ArrayList<EquipmentSkillVO>();
		if(o.getSkills()!=null && !o.getSkills().isEmpty()){
			for (EquipmentSkill es:o.getSkillList()) {
				EquipmentSkillVO skillsVO = MessageFactory.getMessage(EquipmentSkillVO.class);
				skillsVO.init(es);
				list.add(skillsVO);
			}
		}
		this.skills=list;
		this.addAtk=o.getAddAtk();
	}

	public int getUserEquipmentId() {
		return userEquipmentId;
	}
	public void setUserEquipmentId(int userEquipmentId) {
		this.userEquipmentId = userEquipmentId;
	}
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getUserHeroId() {
		return userHeroId;
	}
	public void setUserHeroId(int userHeroId) {
		this.userHeroId = userHeroId;
	}

	public List<EquipmentSkillVO> getSkills() {
		return skills;
	}

	public void setSkills(List<EquipmentSkillVO> skills) {
		this.skills = skills;
	}

	public double getAddAtk() {
		return addAtk;
	}

	public void setAddAtk(double addAtk) {
		this.addAtk = addAtk;
	}
}
