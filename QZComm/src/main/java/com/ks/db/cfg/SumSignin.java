package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;

/**
 * 补签
 *
 */
@DBBeanSet(tablename="t_sum_signin", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class SumSignin  extends Goods{

	private static final long serialVersionUID = 1L;
	/**天*/
	@DBFieldSet(dbfname="day_num")
	private int dayNum;
	
	public int getDayNum() {
		return dayNum;
	}
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}
}
