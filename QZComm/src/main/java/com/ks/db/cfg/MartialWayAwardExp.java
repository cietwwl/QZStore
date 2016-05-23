package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;

/**
 * 武道会经验
 *
 */
@DBBeanSet(tablename="t_martial_way_exp", createDeleteSql=false, createSelectSql=false, createInsertSql=false, createUpdateSql=false)
public class MartialWayAwardExp implements Serializable{
	private static final long serialVersionUID = 2967651680840313275L;
	@DBFieldSet(dbfname="level")
	private int level;
	@DBFieldSet(dbfname="exp")
	private int exp;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}

}
