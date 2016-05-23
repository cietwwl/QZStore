package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 名望
 *
 */
@DBBeanSet(tablename="t_fame", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Fame implements Serializable{
	private static final long serialVersionUID = 1L;
	/**名望等级*/
	@DBFieldSet(dbfname="fame_level")
	private int fameLevel;
	/**所需石板*/
	@DBFieldSet(dbfname="slate")
	private int slate;
	public int getFameLevel() {
		return fameLevel;
	}
	public void setFameLevel(int fameLevel) {
		this.fameLevel = fameLevel;
	}
	public int getSlate() {
		return slate;
	}
	public void setSlate(int slate) {
		this.slate = slate;
	}
	
}
