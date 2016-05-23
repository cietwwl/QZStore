package com.ks.model.fight;

import com.ks.constant.SystemConstant;

public class LivingAttribute {
	/**基础属性*/
	public static final int TYPE_ROLE_BASE = 101;
	/**突破属性*/
	public static final int TYPE_ROLE_BREAK = 102;
	/**装备*/
	public static final int TYPE_EQUIP = 201;
	/**装备附加*/
	public static final int TYPE_EQUIP_ADDITIONAL = 202;
	/**武魂*/
	public static final int TYPE_ETERNAL = 301;
	/**属性类型*/
	private int type;
	/**是否百分比*/
	private boolean percent;
	/**基础血量*/
	private int baseHp;
	/**血量*/
	private int hp;
	/**攻击力*/
	private int atk;
	/**暴击率*/
	private int critRate;
	/**暴击伤害*/
	private int critHit;
	/**多躲闪率*/
	private int dodgeRate;
	/**格挡率*/
	private int blockRate;
	/**格挡伤害*/
	private double blockHit ;
	
	public LivingAttribute(){
		
	}
	public LivingAttribute(int type, boolean percent) {
		super();
		this.type = type;
		this.percent = percent;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isPercent() {
		return percent;
	}
	public void setPercent(boolean percent) {
		this.percent = percent;
	}
	public int getBaseHp() {
		return baseHp;
	}
	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
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
	public int getBlockRate() {
		return blockRate;
	}
	public void setBlockRate(int blockRate) {
		this.blockRate = blockRate;
	}
	public double getBlockHit() {
		return blockHit;
	}
	public void setBlockHit(double blockHit) {
		this.blockHit = blockHit;
	}
	
}
