package com.ks.model.fight;

import java.io.Serializable;

import lombok.Data;
/**
 * 战斗技能
 * @author ks
 */
@Data
public class FightSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**技能编号*/
	private int skillId;
	/**技能等级*/
	private int skillLv;
	/**当前回合*/
	private int currRound;
	/**技能类型 1队长 0普通*/
	private int skillType;
	/**出手方用户编号*/
	private int shotUserId;
	
	/**
	 * 下回合
	 * @param shotUserId
	 */
	public void nextRound(int shotUserId){
		if(this.shotUserId == shotUserId){
			currRound++;
		}
	}
	
	public void release(int shotUserId){
		this.shotUserId = shotUserId;
		currRound = 0;
	}
	
}
