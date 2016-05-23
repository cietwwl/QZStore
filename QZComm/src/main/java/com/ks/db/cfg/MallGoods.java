package com.ks.db.cfg;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;

/**
 * 商城物品
 *
 */
@DBBeanSet(tablename="t_mall_goods", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class MallGoods extends Goods {
	private static final long serialVersionUID = 1L;
	
	/**编号*/
	@DBFieldSet(dbfname="id")
	private int id;
	/**商城编号*/
	@DBFieldSet(dbfname="mall_id")
	private int mallId;
	/**出现概率 10000*/
	private int rate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMallId() {
		return mallId;
	}
	public void setMallId(int mallId) {
		this.mallId = mallId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
}
