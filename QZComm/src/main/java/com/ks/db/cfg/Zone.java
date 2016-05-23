package com.ks.db.cfg;

import java.io.Serializable;

import com.ks.access.DBBeanSet;
import com.ks.access.DBFieldSet;
/**
 * 副本
 * @author ks
 */
@DBBeanSet(tablename="t_zone", createDeleteSql=false, createInsertSql=false, createSelectSql=false, createUpdateSql=false)
public class Zone implements Serializable {
	private static final long serialVersionUID = 1L;
	/**副本编号*/
	@DBFieldSet(dbfname="zone_id")
	private int zoneId;
	/**类型*/
	@DBFieldSet(dbfname="type")
	private int type;
	/**开放等级*/
	@DBFieldSet(dbfname="level")
	private int level;
	/**前置编号*/
	@DBFieldSet(dbfname="pev_zone")
	private int pevZone;
	/**后置编号*/
	@DBFieldSet(dbfname="next_zone")
	private int nextZone;
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPevZone() {
		return pevZone;
	}
	public void setPevZone(int pevZone) {
		this.pevZone = pevZone;
	}
	public int getNextZone() {
		return nextZone;
	}
	public void setNextZone(int nextZone) {
		this.nextZone = nextZone;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
