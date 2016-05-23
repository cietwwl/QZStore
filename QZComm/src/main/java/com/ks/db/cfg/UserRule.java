package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.protocol.FieldDesc;
/**
 * 用户规则
 * @author ks
 */
@DBBeanSet(tablename="t_user_rule", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class UserRule implements Serializable {

	private static final long serialVersionUID = 1L;
	@DBFieldSet(dbfname="level")
	@FieldDesc(desc="等级")
	private int level;
	@DBFieldSet(dbfname="next_exp")
	@FieldDesc(desc="下一级经验")
	private int nextExp;
	@DBFieldSet(dbfname="cost")
	@FieldDesc(desc="统治力")
	private int cost;
	@DBFieldSet(dbfname="stamina")
	@FieldDesc(desc="体力")
	private int stamina;
	@DBFieldSet(dbfname="exp_pool")
	@FieldDesc(desc="经验池")
	private int expPool;
	@DBFieldSet(dbfname="equipment_capacity")
	@FieldDesc(desc="装备容量")
	private int equipmentCapacity;
	@DBFieldSet(dbfname="hero_capacity")
	@FieldDesc(desc="英雄容量")
	private int heroCapacity;
	@DBFieldSet(dbfname="eternal_capacity")
	@FieldDesc(desc="武魂容量")
	private int eternalCapacity;
	@DBFieldSet(dbfname="eternal_val")
	@FieldDesc(desc="熔炼点")
	private int eternalVal;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNextExp() {
		return nextExp;
	}
	public void setNextExp(int nextExp) {
		this.nextExp = nextExp;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getExpPool() {
		return expPool;
	}
	public void setExpPool(int expPool) {
		this.expPool = expPool;
	}
	public int getEquipmentCapacity() {
		return equipmentCapacity;
	}
	public void setEquipmentCapacity(int equipmentCapacity) {
		this.equipmentCapacity = equipmentCapacity;
	}
	public int getHeroCapacity() {
		return heroCapacity;
	}
	public void setHeroCapacity(int heroCapacity) {
		this.heroCapacity = heroCapacity;
	}
	public int getEternalCapacity() {
		return eternalCapacity;
	}
	public void setEternalCapacity(int eternalCapacity) {
		this.eternalCapacity = eternalCapacity;
	}
	public int getEternalVal() {
		return eternalVal;
	}
	public void setEternalVal(int eternalVal) {
		this.eternalVal = eternalVal;
	}
	
}
