package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;

/**
 * 名望奖励
 *
 */
@DBBeanSet(tablename="t_fame_award", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class FameAward extends Goods{
	private static final long serialVersionUID = 1L;
	/**名望等级*/
	@DBFieldSet(dbfname="fame_level")
	private int fameLevel;
	public int getFameLevel() {
		return fameLevel;
	}
	public void setFameLevel(int fameLevel) {
		this.fameLevel = fameLevel;
	}
}
