package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 装备
 * 
 * @author ks
 */
@DBBeanSet(tablename="t_equipment", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 装备编号 */
	@DBFieldSet(dbfname="equipment_id")
	private int equipmentId;
	/** 名称 */
	@DBFieldSet(dbfname="name")
	private String name;
	/** 类型 */
	@DBFieldSet(dbfname="type")
	private int type;
	/** 血量 */
	@DBFieldSet(dbfname="hp")
	private int hp;
	/** 血量成长 */
	@DBFieldSet(dbfname="hp_up")
	private float hpUp;
	/** 攻击力 */
	@DBFieldSet(dbfname="atk")
	private int atk;
	/** 攻击力成长 */
	@DBFieldSet(dbfname="atk_up")
	private float atkUp;
	/**格挡率*/
	@DBFieldSet(dbfname="block_rate")
	private int blockRate;
	/**暴击率*/
	@DBFieldSet(dbfname="crit_rate")
	private int critRate;
	/**暴击伤害*/
	@DBFieldSet(dbfname="crit_hit")
	private int critHit;
	/**躲闪率*/
	@DBFieldSet(dbfname="dodge_rate")
	private int dodgeRate;
	/** 出售价格 */
	@DBFieldSet(dbfname="sell_price")
	private int sellPrice;
	/** 属性 */
	@DBFieldSet(dbfname="ele")
	private int ele;
	/** 品质 */
	@DBFieldSet(dbfname="quality")
	private int quality;
	/** 稀有度 */
	@DBFieldSet(dbfname="rarity")
	private int rarity;
	/** 最大等级 */
	@DBFieldSet(dbfname="max_level")
	private int maxLevel;
	/**熔炼点*/
	@DBFieldSet(dbfname="eternal_val")
	private int eternalVal;
	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

//	public static final int getLevelGold(int level,int quality){
//		return SystemConstant.EQUIP_LEVEL_UP_GOLD[level-1][quality-1];
//	}
	
	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public float getHpUp() {
		return hpUp;
	}

	public void setHpUp(float hpUp) {
		this.hpUp = hpUp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public float getAtkUp() {
		return atkUp;
	}

	public void setAtkUp(float atkUp) {
		this.atkUp = atkUp;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getEle() {
		return ele;
	}

	public void setEle(int ele) {
		this.ele = ele;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getBlockRate() {
		return blockRate;
	}

	public void setBlockRate(int blockRate) {
		this.blockRate = blockRate;
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

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getEternalVal() {
		return eternalVal;
	}

	public void setEternalVal(int eternalVal) {
		this.eternalVal = eternalVal;
	}

}
