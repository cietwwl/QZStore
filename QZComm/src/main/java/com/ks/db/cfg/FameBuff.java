package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 名望buff
 *
 */
@DBBeanSet(tablename="t_fame_buff", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class FameBuff implements Serializable {
	private static final long serialVersionUID = 1L;
	/**名为等级*/
	@DBFieldSet(dbfname="fame_level")
	private int fameLevel;
	/**效果编号*/
	@DBFieldSet(dbfname="effect_id")
	private int effectId;
	/**分数*/
	@DBFieldSet(dbfname="score")
	private int score;
	/**实数*/
	@DBFieldSet(dbfname="cons")
	private int cons;
	public int getFameLevel() {
		return fameLevel;
	}
	public void setFameLevel(int fameLevel) {
		this.fameLevel = fameLevel;
	}
	public int getEffectId() {
		return effectId;
	}
	public void setEffectId(int effectId) {
		this.effectId = effectId;
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
