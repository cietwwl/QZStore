package com.ks.model.fight;

import java.io.Serializable;
/**
 * 攻击模型
 * @author ks
 */
public class AttackModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**攻击方战斗编号*/
	private int attackFightId;
	/**防守方战斗编号*/
	private int defendFightId;
	
	public int getAttackFightId() {
		return attackFightId;
	}
	public void setAttackFightId(int attackFightId) {
		this.attackFightId = attackFightId;
	}
	public int getDefendFightId() {
		return defendFightId;
	}
	public void setDefendFightId(int defendFightId) {
		this.defendFightId = defendFightId;
	}
}
