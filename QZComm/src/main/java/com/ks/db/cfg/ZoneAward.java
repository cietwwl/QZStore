package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
import com.ks.db.model.Goods;

@DBBeanSet(tablename="t_zone_award", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class ZoneAward extends Goods implements Serializable {

	private static final long serialVersionUID = 1L;
	/**战场编号*/
	@DBFieldSet(dbfname="zone_id")
	private int zoneId;
	/**星级*/
	@DBFieldSet(dbfname="star")
	private int star;
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
}
