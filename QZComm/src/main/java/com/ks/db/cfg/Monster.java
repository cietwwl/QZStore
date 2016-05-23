package com.ks.db.cfg;

import java.io.Serializable;
import java.util.List;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 怪物
 * @author ks
 */
@DBBeanSet(tablename="t_monster", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Monster implements Serializable {
	private static final long serialVersionUID = 1L;
	/**怪物编号*/
	@DBFieldSet(dbfname="monster_id")
	private int monsterId;
	/**名称*/
	@DBFieldSet(dbfname="name")
	private String name;
	/**属性*/
	@DBFieldSet(dbfname="ele")
	private int ele;
	/**属性等级*/
	@DBFieldSet(dbfname="ele_lv")
	private int eleLv=1;
	/**能力*/
	@DBFieldSet(dbfname="ability")
	private int ability;
	/**血量*/
	@DBFieldSet(dbfname="hp")
	private int hp;
	/**攻击力*/
	@DBFieldSet(dbfname="atk")
	private int atk;
	/**攻击次数*/
	@DBFieldSet(dbfname="atk_count")
	private int atkCount;
	/**暴击率*/
	@DBFieldSet(dbfname="crit_rate")
	private int critRate;
	/**暴击伤害*/
	@DBFieldSet(dbfname="crit_hit")
	private int critHit;
	/**躲闪率*/
	@DBFieldSet(dbfname="dodge_rate")
	private int dodgeRate;
	/**队长技能编号*/
	private int capSkillId;
	/**体型*/
	@DBFieldSet(dbfname="body_type")
	private int bodyType;
	/**怪物攻击方式*/
	private List<MonsterAtkMode> modes;
	/**怪物掉落*/
	private List<Drop> drops;
	
	public int getMonsterId() {
		return monsterId;
	}
	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEle() {
		return ele;
	}
	public void setEle(int ele) {
		this.ele = ele;
	}
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getAtkCount() {
		return atkCount;
	}
	public void setAtkCount(int atkCount) {
		this.atkCount = atkCount;
	}
	public int getCritRate() {
		return critRate;
	}
	public void setCritRate(int critRate) {
		this.critRate = critRate;
	}
	public int getCritHit() {
		return critHit;
	}
	public void setCritHit(int critHit) {
		this.critHit = critHit;
	}
	public int getDodgeRate() {
		return dodgeRate;
	}
	public void setDodgeRate(int dodgeRate) {
		this.dodgeRate = dodgeRate;
	}
	public int getCapSkillId() {
		return capSkillId;
	}
	public void setCapSkillId(int capSkillId) {
		this.capSkillId = capSkillId;
	}
	public int getBodyType() {
		return bodyType;
	}
	public void setBodyType(int bodyType) {
		this.bodyType = bodyType;
	}
	public List<MonsterAtkMode> getModes() {
		return modes;
	}
	public void setModes(List<MonsterAtkMode> modes) {
		this.modes = modes;
	}
	public int getEleLv() {
		return eleLv;
	}
	public void setEleLv(int eleLv) {
		this.eleLv = eleLv;
	}
	public List<Drop> getDrops() {
		return drops;
	}
	public void setDrops(List<Drop> drops) {
		this.drops = drops;
	}
	
}
