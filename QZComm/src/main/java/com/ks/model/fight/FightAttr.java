package com.ks.model.fight;
/**
 * 英雄属性
 * @author hanjie.l
 *
 */
public class FightAttr {
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

	public int getHp() {
		return hp;
	}

	public void addHp(int hp) {
		this.hp += hp;
	}

	public int getAtk() {
		return atk;
	}

	public void addAtk(int atk) {
		this.atk += atk;
	}

	public int getCritRate() {
		return critRate;
	}

	public void addCritRate(int critRate) {
		this.critRate += critRate;
	}

	public int getCritHit() {
		return critHit;
	}

	public void addCritHit(int critHit) {
		this.critHit += critHit;
	}

	public int getDodgeRate() {
		return dodgeRate;
	}

	public void addDodgeRate(int dodgeRate) {
		this.dodgeRate += dodgeRate;
	}
}
