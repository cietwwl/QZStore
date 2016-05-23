package com.ks.model.fight;

import java.io.Serializable;

import lombok.Data;

import com.ks.constant.SystemConstant;
/**
 * 战斗buff
 * @author ks
 */
@Data
public class FightBuff implements Serializable {
	private static final long serialVersionUID = 1L;
	/**产生的组别*/
	private String uuid;
	/**类型*/
	private int type;
	/**id*/
	private int id;
	/** 效果编号 */
	private int effectId;
	/** 分数 */
	private int score;
	/** 实数 */
	private int cons;
	/** 持续回合 */
	private int round;
	/**状态*/
	private int state;
	/**触发buff出手方id*/
	private int shotUserId;
	
	/**
	 * 下回合
	 * @param shotUserId
	 */
	public void nextRound(int shotUserId){
		if(this.shotUserId == shotUserId){
			if(round > 0){
				round--;
			}
		}
	}
	/**
	 * 是否能攻击
	 * @param fm 模型
	 * @return 是否能攻击
	 */
	public static boolean canFight(FightModel fm){
		if(fm.getState() == SystemConstant.FIGHT_MODEL_STATE_死亡){
			return false;
		}
		for(FightBuff buff : fm.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_眩晕||
					buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_缴械){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 是否能移动
	 * @param fm 模型
	 * @return 是否能移动
	 */
	public static boolean canMove(FightModel fm){
		if(fm.getState() == SystemConstant.FIGHT_MODEL_STATE_死亡){
			return false;
		}
		for(FightBuff buff : fm.getBuffs()){
			if(buff.getEffectId() == SystemConstant.SKILL_EFFECT_ID_眩晕){
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasBuff(FightModel fm , int effectId){
		for(FightBuff buff : fm.getBuffs()){
			if(buff.getEffectId() == effectId){
				return true;
			}
		}
		return false;
	}
	
}
