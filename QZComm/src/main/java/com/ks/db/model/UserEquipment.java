package com.ks.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.codehaus.jackson.type.TypeReference;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.cache.JedisBeanSet;
import com.ks.cache.JedisFieldSet;
import com.ks.util.JSONUtil;
/**
 * 用户装备
 * @author ks
 */
@DBBeanSet(tablename_prefix="t_user_equipment_", primaryKey={"user_equipment_id"})
@JedisBeanSet()
@Data
public class UserEquipment implements Serializable {
	private static final long serialVersionUID = 1L;
	/**用户装备编号*/
	@DBFieldSet(dbfname="user_equipment_id")
	@JedisFieldSet()
	protected int userEquipmentId;
	/**用户编号*/
	@DBFieldSet(dbfname="user_id")
	@JedisFieldSet()
	protected int userId;
	/**装备编号*/
	@DBFieldSet(dbfname="equipment_id")
	@JedisFieldSet()
	protected int equipmentId;
	/**等级*/
	@DBFieldSet(dbfname="level")
	@JedisFieldSet()
	protected int level;
	/**用户英雄编号*/
	@DBFieldSet(dbfname="user_hero_id")
	@JedisFieldSet()
	protected int userHeroId;
	/**创建时间*/
	@JedisFieldSet()
	protected Date createTime = new Date();
	/**修改时间*/
	@DBFieldSet(dbfname="update_time")
	@JedisFieldSet()
	protected Date updateTime = new Date();
	/**装备附加技能*/
	@DBFieldSet(dbfname="equipment_skill")
	@JedisFieldSet()
	protected String skills;
	/**装备浮动攻击加成-30到30%*/
	@DBFieldSet(dbfname="add_atk")
	@JedisFieldSet()
	protected double addAtk;
	/**是否修改过*/
	@JedisFieldSet()
	protected boolean update;
	

	private List<EquipmentSkill> skillList;

	private void initSkillList(){
		skillList = JSONUtil.toObject(skills, new TypeReference<List<EquipmentSkill>>(){});
	}
	
	private void initSkills(){
		skills = JSONUtil.toJson(skillList);
	}
	
	public String getSkills() {
		initSkills();
		return skills;
	}
	
	public void setSkills(String skills) {
		this.skills = skills;
		initSkillList();
	}
	
}
