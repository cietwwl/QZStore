package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 武魂效果
 * @author ks
 */
@DBBeanSet(tablename="t_eternal_effect", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class EternalEffect implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 武魂编号 */ 
	@DBFieldSet(dbfname="eternal_id")
	private int eternalId;                                 
	/** 效果编号 */
	@DBFieldSet(dbfname="effect_type")
	private int effectType;                                
	/** 分数 */
	@DBFieldSet(dbfname="score")
	private int score;                                     
	/** 实数 */
	@DBFieldSet(dbfname="cons")
	private int cons;
	
	public static EternalEffect  createEternalEffect(int eternalId, int effectType, int score, int cons) {
		EternalEffect ee = new EternalEffect();
		ee.eternalId = eternalId;
		ee.effectType = effectType;
		ee.score = score;
		ee.cons = cons;
		return ee;
	}
	public int getEternalId() {
		return eternalId;
	}
	public void setEternalId(int eternalId) {
		this.eternalId = eternalId;
	}
	public int getEffectType() {
		return effectType;
	}
	public void setEffectType(int effectType) {
		this.effectType = effectType;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCons() {
		return cons;
	}
	public void setCons(int cons) {
		this.cons = cons;
	}
}
