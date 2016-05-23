package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;

/**
 * 签到
 *
 */
@DBBeanSet(tablename="t_signin", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Signin extends Goods{
	private static final long serialVersionUID = 1L;
	/**天*/
	@DBFieldSet(dbfname="day")
	private int day;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
