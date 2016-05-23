package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 道具效果
 * 
 * @author ks
 */
@DBBeanSet(tablename="t_prop_effect", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class PropEffect implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 道具编号 */
	@DBFieldSet(dbfname="prop_id")
	private int propId;
	/** 效果编号 */
	@DBFieldSet(dbfname="effect_id")
	private int effectId;
	/** 值 */
	@DBFieldSet(dbfname="val")
	private int val;
	/** cd */
	@DBFieldSet(dbfname="cd")
	private int cd;

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public int getEffectId() {
		return effectId;
	}

	public void setEffectId(int effectId) {
		this.effectId = effectId;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

}
